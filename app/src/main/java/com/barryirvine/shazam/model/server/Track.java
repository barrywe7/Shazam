package com.barryirvine.shazam.model.server;

import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("images")
    private Images mImages;

    @SerializedName("heading")
    private Heading mHeading;

    //TODO: Some of the results are returning no images but have a cover art
    // url for each of the stores I could use one of these as a fallback
    public Images getImages() {
        return mImages;
    }

    public Heading getHeading() {
        return mHeading;
    }
}
