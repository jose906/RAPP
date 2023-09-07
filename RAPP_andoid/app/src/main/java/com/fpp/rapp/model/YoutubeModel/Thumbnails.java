package com.fpp.rapp.model.YoutubeModel;

import com.google.gson.annotations.SerializedName;

public class Thumbnails {


    @SerializedName("default")
    DefaultThumb defaultThumb;
    Medium medium;
    High high;
    Standard standard;
    Maxres maxres;

    public Thumbnails(DefaultThumb defaultThumb, Medium medium, High high, Standard standard, Maxres maxres) {
        this.defaultThumb = defaultThumb;
        this.medium = medium;
        this.high = high;
        this.standard = standard;
        this.maxres = maxres;
    }

    public DefaultThumb getDefaultThumb() {
        return defaultThumb;
    }

    public void setDefaultThumb(DefaultThumb defaultThumb) {
        this.defaultThumb = defaultThumb;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public Maxres getMaxres() {
        return maxres;
    }

    public void setMaxres(Maxres maxres) {
        this.maxres = maxres;
    }
}
