package com.barryirvine.shazam.ui.contract;

import android.support.v4.widget.SwipeRefreshLayout;

import com.barryirvine.shazam.model.local.ChartEntry;

import java.util.List;

public interface MainContract {
    interface View extends SwipeRefreshLayout.OnRefreshListener {
        void onLoading(final boolean loading);

        void onDataLoaded(final List<ChartEntry> chartEntries);

        void showError(final String message);
    }

    interface Presenter {

        void attachView(final View view);

        void detachView();

        void loadData();

        void setClicksEnabled(final boolean enabled);

        boolean areClicksEnabled();

    }
}
