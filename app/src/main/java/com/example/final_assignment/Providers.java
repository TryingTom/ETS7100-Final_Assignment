package com.example.final_assignment;

class Providers {
    String fi;

    public Providers(String fi) {
        this.fi = fi;
    }

    public String getFi() {
        if (fi != null){
            return fi;
        }else {
            return "[None]";
        }

    }

    public void setFi(String fi) {
        this.fi = fi;
    }
}
