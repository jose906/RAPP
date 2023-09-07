package com.fpp.rapp.model;

public class Guid {

    String rendered;
    int p;

    public Guid(String rendered, int p) {
        this.rendered = rendered;
        this.p = p;
    }

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
}
