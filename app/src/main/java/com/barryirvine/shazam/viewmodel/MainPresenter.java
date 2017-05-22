package com.barryirvine.shazam.viewmodel;

import com.barryirvine.shazam.interactors.InteractorContract;
import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.ui.contract.MainContract;

import java.util.Collections;
import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private final InteractorContract.ChartApi mChartApi;

    private boolean mLoading;
    private boolean mItemsClickable;

    private MainContract.View mView;

    private List<ChartEntry> mPendingResult = Collections.emptyList();
    private String mPendingError = "";

    public MainPresenter(final InteractorContract.ChartApi chartApi) {
        mChartApi = chartApi;
    }

    @Override
    public void attachView(final MainContract.View view) {
        setClicksEnabled(true);
        mView = view;
        mView.onLoading(mLoading);
        if (!mPendingError.isEmpty()) {
            mView.showError(mPendingError);
            mPendingError = "";
        } else if (!mPendingResult.isEmpty()) {
            mView.onDataLoaded(mPendingResult);
            mPendingResult = Collections.emptyList();
        }
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void loadData() {
        mLoading = true;
        mChartApi.getChart().subscribe(this::onReceivedChart, this::onError);
    }

    private void onReceivedChart(final List<ChartEntry> chartEntries) {
        mLoading = false;
        if (mView != null) {
            mView.onLoading(false);
            if (chartEntries != null) {
                mView.onDataLoaded(chartEntries);
            }
        } else {
            mPendingResult = chartEntries;
        }
    }

    private void onError(final Throwable throwable) {
        mLoading = false;
        if (mView != null) {
            mView.onLoading(false);
            mView.showError(throwable.getMessage());
        } else {
            mPendingError = throwable.getMessage();
        }
    }

    @Override
    public void setClicksEnabled(final boolean enabled) {
        mItemsClickable = enabled;
    }

    @Override
    public boolean areClicksEnabled() {
        return mItemsClickable;
    }
}
