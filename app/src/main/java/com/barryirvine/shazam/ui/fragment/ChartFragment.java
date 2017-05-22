package com.barryirvine.shazam.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.barryirvine.shazam.App;
import com.barryirvine.shazam.R;
import com.barryirvine.shazam.databinding.FragmentChartBinding;
import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.ui.adapter.ChartEntryAdapter;
import com.barryirvine.shazam.ui.contract.MainContract;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class ChartFragment extends Fragment implements MainContract.View {

    @Inject
    Picasso mPicasso;
    @Inject
    MainContract.Presenter mPresenter;
    private FragmentChartBinding mBinding;
    private ChartEntryAdapter mAdapter;

    public ChartFragment() {
    }

    public static ChartFragment newInstance() {
        final ChartFragment fragment = new ChartFragment();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
        if (savedInstanceState == null) {
            mPresenter.loadData();
        }
    }

    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        //TODO: Save instance state
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.attachView(this);
    }

    @Override
    public void onStop() {
        mPresenter.detachView();
        super.onStop();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_chart, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding = DataBindingUtil.bind(view);
        if (savedInstanceState == null) {
            mAdapter = new ChartEntryAdapter(Collections.emptyList(), mPicasso, mPresenter);
            mBinding.recyclerView.setAdapter(mAdapter);
        } else {
            //TODO: Update recyclerview with saved state
        }
        mBinding.swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onLoading(final boolean loading) {
        mBinding.swipeRefreshLayout.setRefreshing(loading);
    }

    @Override
    public void onDataLoaded(final List<ChartEntry> chartEntries) {
        mAdapter = new ChartEntryAdapter(chartEntries, mPicasso, mPresenter);
        mBinding.recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showError(final String message) {
        //TODO: Show Error
    }

    @Override
    public void onRefresh() {
        mPresenter.loadData();
    }

}
