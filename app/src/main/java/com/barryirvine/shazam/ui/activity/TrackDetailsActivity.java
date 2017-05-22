package com.barryirvine.shazam.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;

import com.barryirvine.shazam.App;
import com.barryirvine.shazam.R;
import com.barryirvine.shazam.databinding.ActivityTrackDetailsBinding;
import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.viewmodel.ChartEntryViewModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class TrackDetailsActivity extends AppCompatActivity {

    @Inject
    Picasso mPicasso;
    private ActivityTrackDetailsBinding mBinding;
    private ChartEntry mChartEntry;

    public static void start(@NonNull final Context context, @NonNull final ChartEntry chartEntry, @Nullable final ActivityOptionsCompat options) {
        context.startActivity(makeIntent(context, chartEntry), options != null ? options.toBundle() : null);
    }

    public static Intent makeIntent(@NonNull final Context context, final ChartEntry chartEntry) {
        return new Intent(context, TrackDetailsActivity.class)
                .putExtra(Extras.CHART_ENTRY, chartEntry);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_track_details);
        ((App) getApplication()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        mChartEntry = getIntent().getParcelableExtra(Extras.CHART_ENTRY);
        mBinding.setViewModel(new ChartEntryViewModel(mChartEntry, null));
        mBinding.setPicasso(mPicasso);
        mBinding.setCallback(new Callback() {
            @Override
            public void onSuccess() {
                ActivityCompat.startPostponedEnterTransition(TrackDetailsActivity.this);
            }

            @Override
            public void onError() {
                ActivityCompat.startPostponedEnterTransition(TrackDetailsActivity.this);
            }
        });
        setSupportActionBar(mBinding.toolbar);
        ActivityCompat.postponeEnterTransition(this);

    }

    private static class Extras {
        static final String CHART_ENTRY = ChartEntry.class.getSimpleName();
    }

}
