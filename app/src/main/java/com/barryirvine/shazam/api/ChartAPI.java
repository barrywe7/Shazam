package com.barryirvine.shazam.api;


import com.barryirvine.shazam.model.server.ChartResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ChartAPI {

    String BASE_URL = "https://amp.shazam.com/";

    @GET("shazam/v2/en/US/android/-/tracks/web_chart_future_hits_us")
    Observable<ChartResponse> getChart();

}
