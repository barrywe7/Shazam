package com.barryirvine.shazam.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.barryirvine.shazam.App;
import com.barryirvine.shazam.R;
import com.barryirvine.shazam.databinding.FragmentChartBinding;
import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.ui.adapter.ChartEntryAdapter;
import com.barryirvine.shazam.ui.contract.MainContract;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
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
        outState.putParcelableArrayList(Args.CHART_ENTRIES, new ArrayList<Parcelable>(mAdapter.getItems()));
        outState.putParcelable(Args.RECYCLER_VIEW_STATE, mBinding.recyclerView.getLayoutManager().onSaveInstanceState());
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
            mBinding.recyclerView.getLayoutManager().onRestoreInstanceState(savedInstanceState.getParcelable(Args.RECYCLER_VIEW_STATE));
            final ArrayList<ChartEntry> list = savedInstanceState.getParcelableArrayList(Args.CHART_ENTRIES);
            mAdapter = new ChartEntryAdapter(list, mPicasso, mPresenter);
            mBinding.recyclerView.setAdapter(mAdapter);
        }
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        if (((GridLayoutManager) mBinding.recyclerView.getLayoutManager()).getSpanCount() > 1) {
            //TODO: The default item decorator draws at the end and the start - so you get a double width one
            // should just create my own item decorator
            mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL));
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
        Toast.makeText(getContext(), getString(R.string.f_error_retrieving_chart, message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRefresh() {
        mPresenter.loadData();
    }

    private class Args {
        private static final String CHART_ENTRIES = "CHART_ENTRIES";
        private static final String RECYCLER_VIEW_STATE = "RECYCLER_VIEW_STATE";

    }

}
