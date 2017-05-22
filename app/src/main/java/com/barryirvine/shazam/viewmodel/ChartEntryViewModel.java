package com.barryirvine.shazam.viewmodel;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.ui.contract.MainContract;

/**
 * View Model for {@link ChartEntry} Remember to use the {@link Bindable} annotation for all getters and to do
 * {@link #notifyPropertyChanged(int)} after a value is set in a setter.
 */

public class ChartEntryViewModel extends BaseObservable {

    private final ChartEntry mChartEntry;
    private final MainContract.Presenter mPresenter;

    // The presenter is nullable because I've lazily used the same view model on the detail screen
    public ChartEntryViewModel(@NonNull final ChartEntry chartEntry, @Nullable final MainContract.Presenter presenter) {
        mChartEntry = chartEntry;
        mPresenter = presenter;
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

    public void onClick(final ImageView view) {
        if (mPresenter != null && mPresenter.areClicksEnabled()) {
            mPresenter.openItem((Activity) view.getContext(), view, mChartEntry);
        }
    }

}
