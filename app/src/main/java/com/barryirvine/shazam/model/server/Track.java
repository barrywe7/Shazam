package com.barryirvine.shazam.model.server;

import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("images")
    private Images mImages;

    @SerializedName("heading")
    private Heading mHeading;

    public Images getImages() {
        return mImages;
    }

    public Heading getHeading() {
        return mHeading;
    }
}
