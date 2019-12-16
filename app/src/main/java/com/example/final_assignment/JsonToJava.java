package com.example.final_assignment;

import java.util.ArrayList;

public class JsonToJava {
    Meta MetaObject;
    ArrayList< JavaToHuman > data = new ArrayList < JavaToHuman > ();


    // Getter Methods

    public Meta getMeta() {
        return MetaObject;
    }

    // Setter Methods

    public void setMeta(Meta metaObject) {
        this.MetaObject = metaObject;
    }
}
class Meta {
    private float count;
    private String next;
    private String previous = null;


    // Getter Methods

    public float getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    // Setter Methods

    public void setCount(float count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
