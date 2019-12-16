package com.example.final_assignment;

import java.util.ArrayList;

public class LocJsonToJava {
    Meta MetaObject;
    ArrayList< LocationToHuman > data = new ArrayList < LocationToHuman > ();


    // Getter Methods

    public Meta getMeta() {
        return MetaObject;
    }

    // Setter Methods

    public void setMeta(Meta metaObject) {
        this.MetaObject = metaObject;
    }
}