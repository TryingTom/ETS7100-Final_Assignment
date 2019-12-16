package com.example.final_assignment;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JavaToHuman {
    @SerializedName("id")
    String id;
    @SerializedName("location")
    Location LocationObject;
    @SerializedName("keywords")
    List<Keyword> keywords;
    @SerializedName("super_event")
    Super_event Super_eventObject;
    @SerializedName("event_status")
    String event_status;
    @SerializedName("external_links")
    List<External_links> external_links;
    @SerializedName("offers")
    List<Offers> offers;
    @SerializedName("data_source")
    private String data_source;
    @SerializedName("publisher")
    String publisher;
    @SerializedName("sub_events")
    List< Sub_events > sub_events;
    @SerializedName("images")
    List<Images> images;
    @SerializedName("in_language")
    List<In_language> in_language;
    @SerializedName("audience")
    List< Audience > audience;
    @SerializedName("created_time")
    String created_time;
    @SerializedName("last_modified_time")
    String last_modified_time;
    @SerializedName("date_published")
    String date_published;
    @SerializedName("start_time")
    String start_time;
    @SerializedName("end_time")
    String end_time;
    @SerializedName("custom_data")
    StringObjectTooLazy custom_data;
    @SerializedName("audience_min_age")
    StringObjectTooLazy audience_min_age;
    @SerializedName("audience_max_age")
    StringObjectTooLazy audience_max_age;
    @SerializedName("super_event_type")
    String super_event_type;
    @SerializedName("provider")
    Providers provider;
    @SerializedName("name")
    Name NameObject;
    @SerializedName("location_extra_info")
    Location_extra_info location_extra_info;
    @SerializedName("description")
    Description DescriptionObject;
    @SerializedName("short_description")
    Short_description Short_descriptionObject;
    @SerializedName("provider_contact_info")
    StringObjectTooLazy provider_contact_info;
    @SerializedName("info_url")
    Info_url info_urlObject;
    @SerializedName("@id")
    private String id2;
    @SerializedName("@context")
    private String context;
    @SerializedName("@type")
    private String type;

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getSuper_event_type() {
        return super_event_type;
    }

    public void setSuper_event_type(String super_event_type) {
        this.super_event_type = super_event_type;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getLast_modified_time() {
        return last_modified_time;
    }

    public void setLast_modified_time(String last_modified_time) {
        this.last_modified_time = last_modified_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvent_status() {
        return event_status;
    }

    public void setEvent_status(String event_status) {
        this.event_status = event_status;
    }

    public String getData_source() {
        return data_source;
    }

    public void setData_source(String data_source) {
        this.data_source = data_source;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Getter Methods

    public Location getLocation() {
        return LocationObject;
    }

    public Super_event getSuper_event() {
        return Super_eventObject;
    }

    public Name getName() {
        return NameObject;
    }

    public Providers getProvider() {
        if(provider != null){
            return provider;
        }
        else {
            return new Providers("[None]");
        }
    }

    public Description getDescription() {
        if(DescriptionObject != null){
            return DescriptionObject;
        }
        else {
            return new Description("[None]");
        }

    }

    public Short_description getShort_description() {
        return Short_descriptionObject;
    }

    public String get_id2() {
        return id2;
    }

    public String get_context() {
        return context;
    }

    public String get_type() {
        return type;
    }

    // Setter Methods

    public void setLocation(Location locationObject) {
        this.LocationObject = locationObject;
    }

    public void setSuper_event(Super_event super_eventObject) {
        this.Super_eventObject = super_eventObject;
    }

    public void setName(Name nameObject) {
        this.NameObject = nameObject;
    }

    public void setDescription(Description descriptionObject) {
        this.DescriptionObject = descriptionObject;
    }

    public void setShort_description(Short_description short_descriptionObject) {
        this.Short_descriptionObject = short_descriptionObject;
    }

    public void set_id2(String id2) {
        this.id2 = id2;
    }

    public void set_context(String context) {
        this.context = context;
    }

    public void set (String type) {
        this.type = type;
    }
}

class Short_description {
    private String fi;


    // Getter Methods

    public String getFi() {
        return fi;
    }

    // Setter Methods

    public void setFi(String fi) {
        this.fi = fi;
    }
}

class Info_url {
    private String fi;


    // Getter Methods

    public String getFi() {
        return fi;
    }

    // Setter Methods

    public void setFi(String fi) {
        this.fi = fi;
    }
}


class Description {
    private String fi;

    public Description(String fi) {
        this.fi = fi;
    }

    // Getter Methods

    public String getFiDesc() {
        if (fi != null){
            return fi;
        }
        else{
            return "[None]";
        }
    }

    // Setter Methods

    public void setFi(String fi) {
        this.fi = fi;
    }
}

class Name {
    private String fi;

    public Name(String fi) {
        this.fi = fi;
    }

    // Getter Methods

    public String getFi() {
        if (fi != null){
            return fi;
        }else {
            return "Error :(";
        }

    }

    // Setter Methods

    public void setFi(String fi) {
        this.fi = fi;
    }
}

class Super_event {
    @SerializedName("@id")
    private String id2;


    // Getter Methods

    public String get_id2() {
        return id2;
    }

    // Setter Methods

    public void set_id2(String id2) {
        this.id2 = id2;
    }
}

class Location {
    @SerializedName("@id")
    private String id2;


    // Getter Methods

    public String get_id2() {
        return id2;
    }

    // Setter Methods

    public void set_id2(String id2) {
        this.id2 = id2;
    }
}

class Keyword {
    @SerializedName("@id")
    private String id2;


    // Getter Methods

    public String get_id2() {
        return id2;
    }

    // Setter Methods

    public void set_id2(String id2) {
        this.id2 = id2;
    }
}

class Offers{
    private boolean is_free;
    Price price;
    Description description;// = null;
    StringObjectTooLazy info_url;// = null;


    // Getter Methods

    public boolean getIs_free() {
        return is_free;
    }

    // Setter Methods

    public void setIs_free(boolean is_free) {
        this.is_free = is_free;
    }

}

class Price{
    String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

class Images {
    private float id;
    private String license;
    private String created_time;
    private String last_modified_time;
    private String name;
    private String url;
    private String cropping;
    private String photographer_name;
    private String data_source;
    private String publisher;
    @SerializedName("@id")
    private String id2;
    @SerializedName("@context")
    private String context;
    @SerializedName("@type")
    private String type;

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getLast_modified_time() {
        return last_modified_time;
    }

    public void setLast_modified_time(String last_modified_time) {
        this.last_modified_time = last_modified_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCropping() {
        return cropping;
    }

    public void setCropping(String cropping) {
        this.cropping = cropping;
    }

    public String getPhotographer_name() {
        return photographer_name;
    }

    public void setPhotographer_name(String photographer_name) {
        this.photographer_name = photographer_name;
    }

    public String getData_source() {
        return data_source;
    }

    public void setData_source(String data_source) {
        this.data_source = data_source;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Audience {
    @SerializedName("@id")
    private String id2;

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
}

class External_links{
    @SerializedName("@id")
    private String id2;

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
}

class Sub_events{
    @SerializedName("@id")
    private String id2;

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
}