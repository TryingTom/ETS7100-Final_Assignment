package com.example.final_assignment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;


public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextLocation;
    private ListView listViewLocations;
    private Button search;
    private ExampleDialogListener listener;

    Context context;

    // the index of location
    int which_item = -1;
    String tprek = "";
    String location = "";

    LocJsonToJava gottenData;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Choose location")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.applyTexts(location, tprek);
                    }
                });



        editTextLocation = view.findViewById(R.id.edit_username);
        search = view.findViewById(R.id.searchLOCATION);
        listViewLocations = view.findViewById(R.id.LocLista);

        // Json and Gson requests
        final RequestQueue jono = Volley.newRequestQueue(context);
        final Gson gson = new Gson();

        // new list
        final ArrayList<String> locList = new ArrayList<>();

        // set the adapter and attach it to the layout
        final ArrayAdapter adapter = new ArrayAdapter (context, android.R.layout.simple_list_item_1, locList);
        listViewLocations.setAdapter(adapter);

        // search onClick Listeneri -------------------------------------------------------------------------------------

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urli = "http://api.hel.fi/linkedevents/v1/search/?format=json&type=place";

                if(editTextLocation.getText().toString().length() != 0){
                    urli += "&input=" + editTextLocation.getText().toString().trim();
                }

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urli, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                gottenData = gson.fromJson(String.valueOf(response),LocJsonToJava.class);

                                Name nimi;

                                for (int i=0; i < gottenData.data.size(); i++){

                                    nimi = gottenData.data.get(i).getName();
                                    String text = nimi.getFi();

                                    locList.add(text);
                                }

                                adapter.notifyDataSetChanged();

                                Toast.makeText(context, "Here's all the event info", Toast.LENGTH_SHORT)
                                        .show();

                            }

                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Couldn't find any events, though the index is " + which_item, Toast.LENGTH_SHORT)
                                .show();
                    }
                }
                );
                jono.add(jsonObjectRequest);
            }
        });

        // search onClick Listeneri end----------------------------------------------------------------------------------

        // listaView onClick Listeneri ----------------------------------------------------------------------------------

        listViewLocations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {

                which_item = position;
                location = locList.get(position);
                tprek = gottenData.data.get(position).getId();
                // muuten hyvä mutta ei vissiin missään aina saa tprekkiä?
                // En ainakaan minä löydä sellaista missä välillä ei aina jotain muutakin
                Toast.makeText(context, location + "\nTprek: " + tprek, Toast.LENGTH_SHORT)
                        .show();

                // olisi varmaan myös ihan kiva jos saisi painalluksella pois, ettei tarvitsisi painaa aina ok...
            }
        });

        // listaView onClick Listeneri end-------------------------------------------------------------------------------

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;

        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String username, String tprek);
    }
}