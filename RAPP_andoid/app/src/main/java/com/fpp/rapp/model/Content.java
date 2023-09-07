package com.fpp.rapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    String rendered;
    @SerializedName("protected")
    String protecteds;

    public Content(String rendered, String protecteds) {
        this.rendered = rendered;
        this.protecteds = protecteds;
    }

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public String getProtecteds() {
        return protecteds;
    }

    public void setProtecteds(String protecteds) {
        this.protecteds = protecteds;
    }
}
