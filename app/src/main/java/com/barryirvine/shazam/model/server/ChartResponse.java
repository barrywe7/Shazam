package com.barryirvine.shazam.model.server;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChartResponse {

    @SerializedName("chart")
    private List<Track> mTracks;

    public List<Track> getTracks() {
        return mTracks;
    }
}
