package com.barryirvine.shazam.model.server;

import com.google.gson.annotations.SerializedName;

class Images {

    @SerializedName("default")
    private String mUrl;

    String getUrl() {
        return mUrl;
    }
}
