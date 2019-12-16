package com.example.final_assignment;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;

import java.util.ArrayList;

public class LocationToHuman {
    private String id;
    ArrayList< Object > divisions = new ArrayList < Object > ();
    String created_time;
    private String last_modified_time;
    StringObjectTooLazy custom_data;
    String email;
    StringObjectTooLazy contact_type;
    StringObjectTooLazy address_region;
    String postal_code;
    String post_office_box_num;
    String address_country;
    private boolean deleted;
    private float n_events;
    private float image;
    private String data_source;
    private String publisher;
    StringObjectTooLazy parent;
    StringObjectTooLazy replaced_by;
    Position PositionObject;
    @SerializedName("name")
    Name NameObject;
    Description DescriptionObject;
    StringObjectTooLazy telephone;
    Address_locality Address_localityObject;
    Street_address Street_addressObject;
    Info_url Info_urlObject;
    @SerializedName("@id")
    private String id2;
    @SerializedName("@context")
    private String context;
    @SerializedName("@type")
    private String type;
    private String resource_type;
    private float score;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPost_office_box_num() {
        return post_office_box_num;
    }

    public void setPost_office_box_num(String post_office_box_num) {
        this.post_office_box_num = post_office_box_num;
    }

    public String getAddress_country() {
        return address_country;
    }

    public void setAddress_country(String address_country) {
        this.address_country = address_country;
    }

    // Getter Methods

    public String getId() {
        return id;
    }

    public String getLast_modified_time() {
        return last_modified_time;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public float getN_events() {
        return n_events;
    }

    public float getImage() {
        return image;
    }

    public String getData_source() {
        return data_source;
    }

    public String getPublisher() {
        return publisher;
    }


    public Position getPosition() {
        return PositionObject;
    }

    public Name getName() {
        if (NameObject != null){
            return NameObject;
        }else{
            return new Name("Error");
        }

    }

    public Description getDescription() {
        return DescriptionObject;
    }

    public Address_locality getAddress_locality() {
        return Address_localityObject;
    }

    public Street_address getStreet_address() {
        return Street_addressObject;
    }

    public Info_url getInfo_url() {
        return Info_urlObject;
    }


    public String getResource_type() {
        return resource_type;
    }

    public float getScore() {
        return score;
    }

    // Setter Methods

    public void setId(String id) {
        this.id = id;
    }

    public void setLast_modified_time(String last_modified_time) {
        this.last_modified_time = last_modified_time;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setN_events(float n_events) {
        this.n_events = n_events;
    }

    public void setImage(float image) {
        this.image = image;
    }

    public void setData_source(String data_source) {
        this.data_source = data_source;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public void setPosition(Position positionObject) {
        this.PositionObject = positionObject;
    }

    public void setName(Name nameObject) {
        this.NameObject = nameObject;
    }

    public void setDescription(Description descriptionObject) {
        this.DescriptionObject = descriptionObject;
    }


    public void setAddress_locality(Address_locality address_localityObject) {
        this.Address_localityObject = address_localityObject;
    }

    public void setStreet_address(Street_address street_addressObject) {
        this.Street_addressObject = street_addressObject;
    }

    public void setInfo_url(Info_url info_urlObject) {
        this.Info_urlObject = info_urlObject;
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

    public void setResource_type(String resource_type) {
        this.resource_type = resource_type;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
class Info_url2 {
    private String fi;
    private String sv;
    private String en;


    // Getter Methods

    public String getFi() {
        return fi;
    }

    public String getSv() {
        return sv;
    }

    public String getEn() {
        return en;
    }

    // Setter Methods

    public void setFi(String fi) {
        this.fi = fi;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
class Street_address {
    private String fi;
    private String sv;


    // Getter Methods

    public String getFi() {
        return fi;
    }

    public String getSv() {
        return sv;
    }

    // Setter Methods

    public void setFi(String fi) {
        this.fi = fi;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }
}
class Address_locality {
    private String fi;
    private String sv;
    private String en;


    // Getter Methods

    public String getFi() {
        return fi;
    }

    public String getSv() {
        return sv;
    }

    public String getEn() {
        return en;
    }

    // Setter Methods

    public void setFi(String fi) {
        this.fi = fi;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
class DescriptionLOC {
    private String fi;
    private String sv;
    private String en;


    // Getter Methods

    public String getFi() {
        return fi;
    }

    public String getSv() {
        return sv;
    }

    public String getEn() {
        return en;
    }

    // Setter Methods

    public void setFi(String fi) {
        this.fi = fi;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
class NameLoc {
    private String fi;
    private String sv;
    private String en;


    // Getter Methods

    public String getFi() {
        return fi;
    }

    public String getSv() {
        return sv;
    }

    public String getEn() {
        return en;
    }

    // Setter Methods

    public void setFi(String fi) {
        this.fi = fi;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
class Position {
    private String type;
    ArrayList < Object > coordinates = new ArrayList < Object > ();


    // Getter Methods

    public String getType() {
        return type;
    }

    // Setter Methods

    public void setType(String type) {
        this.type = type;
    }
}
