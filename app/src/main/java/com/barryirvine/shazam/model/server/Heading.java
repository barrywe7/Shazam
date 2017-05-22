package com.barryirvine.shazam.model.server;

import com.google.gson.annotations.SerializedName;

public class Heading {

    @SerializedName("subtitle")
    private String mSubtitle;

    @SerializedName("title")
    private String mTitle;

    public String getSubtitle() {
        return mSubtitle;
    }

    public String getTitle() {
        return mTitle;
    }
}
