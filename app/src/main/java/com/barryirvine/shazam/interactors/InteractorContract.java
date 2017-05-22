package com.barryirvine.shazam.interactors;

import com.barryirvine.shazam.model.local.ChartEntry;

import java.util.List;

import io.reactivex.Observable;

public interface InteractorContract {
    interface ChartApi {
        Observable<List<ChartEntry>> getChart();
    }
}