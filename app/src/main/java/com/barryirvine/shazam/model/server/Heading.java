package com.barryirvine.shazam.model.server;

import com.google.gson.annotations.SerializedName;

class Heading {

    @SerializedName("subtitle")
    private String mSubtitle;

    @SerializedName("title")
    private String mTitle;

    String getSubtitle() {
        return mSubtitle;
    }

    String getTitle() {
        return mTitle;
    }
}
