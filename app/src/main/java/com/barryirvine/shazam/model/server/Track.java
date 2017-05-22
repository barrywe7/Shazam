package com.barryirvine.shazam.model.server;

import com.google.gson.annotations.SerializedName;

class Track {

    @SerializedName("images")
    private Images mImages;

    @SerializedName("heading")
    private Heading mHeading;

    Images getImages() {
        return mImages;
    }

    Heading getHeading() {
        return mHeading;
    }
}
