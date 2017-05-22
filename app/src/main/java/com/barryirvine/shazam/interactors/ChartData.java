package com.barryirvine.shazam.interactors;


import com.barryirvine.shazam.api.ChartAPI;
import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.model.mapper.ChartResponseMapper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ChartData implements InteractorContract.ChartApi {
    private final ChartAPI mChartAPI;
    private final ChartResponseMapper mChartResponseMapper;

    public ChartData(final ChartAPI chartAPI, final ChartResponseMapper mapper) {
        mChartAPI = chartAPI;
        mChartResponseMapper = mapper;
    }

    @Override
    public Observable<List<ChartEntry>> getChart() {
        return mChartAPI.getChart()
                .map(mChartResponseMapper::map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
