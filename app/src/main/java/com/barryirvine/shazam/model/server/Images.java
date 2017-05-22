package com.barryirvine.shazam.model.server;

import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("default")
    private String mUrl;

    public String getUrl() {
        return mUrl;
    }
}
