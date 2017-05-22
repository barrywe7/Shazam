package com.barryirvine.shazam.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.barryirvine.shazam.model.local.ChartEntry;

/**
 * View Model for {@link ChartEntry} Remember to use the {@link Bindable} annotation for all getters and to do
 * {@link #notifyPropertyChanged(int)} after a value is set in a setter.
 */

public class ChartEntryViewModel extends BaseObservable {

    private final ChartEntry mChartEntry;

    public ChartEntryViewModel(final ChartEntry chartEntry) {
        mChartEntry = chartEntry;
    }

    @Bindable
    public String getTitle() {
        return mChartEntry.getTitle();
    }

    @Bindable
    public String getArtist() {
        return mChartEntry.getArtist();
    }

    @Bindable
    public String getImageUrl() {
        return mChartEntry.getImageUrl();
    }
}
