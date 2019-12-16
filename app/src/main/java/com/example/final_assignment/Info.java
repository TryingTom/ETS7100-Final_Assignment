package com.example.final_assignment;

import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("name")
    private String name;
    @SerializedName("start_time")
    private String PVM;
    @SerializedName("mUrl")
    private String URL;
    @SerializedName("description")
    private String description;

    public Info(String name, String PVM, String URL, String description) {
        this.name = name;
        this.PVM = PVM;
        this.URL = URL;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPVM() {
        return PVM;
    }

    public void setPVM(String PVM) {
        this.PVM = PVM;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
