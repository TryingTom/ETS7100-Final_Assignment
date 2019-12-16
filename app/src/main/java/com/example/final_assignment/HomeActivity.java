package com.example.final_assignment;

/* The Final Assignment from course ETS7100

Written https://github.com/TryingTom


The basic premise of the assignment is that the user writes something on the search bar, then
has the chance to choose starting day and specific location too.

The app starts with 3,5 second splash screen with my name and student ID.

Search bar is just an EditText, while the date is a button which prompts an DatePickerDialog,
then the user can choose a date. The location select is also an EditText, but once pressed, it'll
prompt a fragment which asks user to write something on EditText which is inside the fragment.
Once the button is pressed, the user gets a ListView of possible addresses they can pick.
Once they've chosen their location, they press "ok" and the EditText is changed to the address
chosen. The fragment also gives "tprek", which is specific id for location inside Helsinki.
Though I couldn't extract that information from the API.

The APIs used for this projects are:
http://api.hel.fi/linkedevents/v1/event/
http://api.hel.fi/linkedevents/v1/search/

Once everything is set, the user can press Search button from the HomeActivity, which will show
the response from API in human-readable -form, having the title of the event, the name of the
publisher and starting date and time, and the description below that.

The API gives the information of events in Json, which is parsed into JsonToJavam, which is an
arraylist of JavaToHumans, which is a Java class containing loots of information, from which
everything important is thrown into Info class, which is then shown with an adapter. LocJsonToJava
and LocationToHuman are pretty much same than JsonToJava and JavaToHuman, but with slightly
different, and they're used to get the location instead of events.
 */

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {

    // all the global variables

    ListView listView;
    Button searchBtn;
    EditText searchEventTxt;
    EditText searchLocTxt;
    Button searchDateBtn;

    RequestQueue jono;

    String urli;

    String date = "";
    String tprek = "";

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    // all the global variables end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // init all the view elements
        listView = (ListView) findViewById(R.id.viewLW);
        searchBtn = (Button) findViewById(R.id.searchBTN);
        searchEventTxt = (EditText) findViewById(R.id.searchET);

        searchLocTxt = (EditText) findViewById(R.id.searchLOCET);
        searchDateBtn = (Button) findViewById(R.id.searchPVMBTN);

        // Json and Gson requests
        jono = Volley.newRequestQueue(this);
        final Gson gson = new Gson();

        // new list
        final ArrayList<Info> infoList = new ArrayList<>();

        // set the adapter and attach it to the layout
        final InfoAdapter adapter = new InfoAdapter (this, R.layout.adapter_layout, infoList);
        listView.setAdapter(adapter);



        // Ask location -----------------------------------------------------------------------------------------

        searchLocTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(searchLocTxt);
            }
        });

        // Ask location end -------------------------------------------------------------------------------------

        // Ask date     -----------------------------------------------------------------------------------------

        searchDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();

                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        HomeActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                DecimalFormat formatter = new DecimalFormat("00");

                date = year + "-" + formatter.format(month) + "-" + formatter.format(day);
                Toast.makeText(HomeActivity.this, date, Toast.LENGTH_SHORT)
                        .show();
            }
        };

        // Ask date end -----------------------------------------------------------------------------------------

        // Search button click     ------------------------------------------------------------------------------

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(HaveNetwork()){

                    infoList.clear();

                    urli = "http://api.hel.fi/linkedevents/v1/search/?format=json&type=event";

                    if (date.length() != 0){
                        urli += "&start=" + date;
                    }

                    if(searchEventTxt.getText().toString().length() != 0){
                        urli = urli + "&q=" + searchEventTxt.getText().toString().trim();
                    }

                    if(searchLocTxt.getText().toString().length() != 0){
                        urli = urli + "&location=tprek" + tprek;
                    }


                    adapter.clear();
                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urli, null,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    JsonToJava gottenData = gson.fromJson(String.valueOf(response),JsonToJava.class);

                                    Name nimi;
                                    String daNimi;
                                    String PVM;
                                    String time;
                                    Providers providers;
                                    String daProvider;
                                    Description desci;
                                    String daDesci;

                                    for (int i=0; i < gottenData.data.size(); i++){
                                        nimi = gottenData.data.get(i).getName();
                                        daNimi =nimi.getFi();
                                        PVM = gottenData.data.get(i).getStart_time();
                                        providers = gottenData.data.get(i).getProvider();
                                        daProvider = providers.getFi();
                                        desci = gottenData.data.get(i).getDescription();
                                        daDesci = android.text.Html.fromHtml(desci.getFiDesc()).toString();


                                        // sometimes the start time is only given as date and without time
                                        if(PVM.length()>10){
                                            time = PVM.substring(11,16);
                                        } else{
                                            time = "[Empty]";
                                        }

                                        PVM = PVM.substring(0,10) + "\nklo: " + time;

                                        infoList.add(new Info(daNimi, PVM, daProvider, daDesci));
                                    }

                                    adapter.notifyDataSetChanged();

                                    if(infoList.isEmpty()){
                                        Toast.makeText(HomeActivity.this, "Couldn't find any searches", Toast.LENGTH_SHORT)
                                                .show();
                                    }else{
                                        Toast.makeText(HomeActivity.this, "Here's all the search info", Toast.LENGTH_SHORT)
                                                .show();
                                    }


                                }

                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if(searchEventTxt.getText().toString().length() != 0){
                                Toast.makeText(HomeActivity.this, "Couldn't find any searches", Toast.LENGTH_SHORT)
                                        .show();
                            } else{
                                Toast.makeText(HomeActivity.this, "Try writing something on the search box", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    }
                    );
                    jono.add(jsonObjectRequest);


                }   // HaveNetwork (true) end
                else{
                    Toast.makeText(HomeActivity.this, "Not connected to the internet :(", Toast.LENGTH_SHORT)
                            .show();
                }   // HaveNetwork (false) end

                adapter.notifyDataSetChanged();
            }
        });


        // Search button click end ------------------------------------------------------------------------------

    } // onCreate end


    // check if the user has internet ---------------------------------------------------------------------------

    private boolean HaveNetwork()
    {
        boolean have_WIFI = false;
        boolean have_MobileData = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for(NetworkInfo info:networkInfos){
            if (info.getTypeName().equalsIgnoreCase("WIFI")){
                if (info.isConnected()){
                    have_WIFI = true;
                }
            }
            if (info.getTypeName().equalsIgnoreCase("MOBILE")){
                if (info.isConnected()){
                    have_MobileData = true;
                }
            }
        }
        return have_MobileData || have_WIFI;
    }

    // check if the user has internet end------------------------------------------------------------------------

    // Fragment dialog

    public void openDialog(View v) {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String username, String tprek) {
        searchLocTxt.setText(username);
        this.tprek = tprek;
    }
}


