package com.barryirvine.shazam.viewmodel;

import android.app.Activity;
import android.widget.ImageView;

import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.model.local.MockChartEntryUtils;
import com.barryirvine.shazam.ui.contract.MainContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ChartEntryViewModelTest {

    @Mock
    private ImageView mImageView;
    @Mock
    private MainContract.Presenter mPresenter;
    @Mock
    private Activity mActivity;
    private ChartEntry mChartEntry;
    private ChartEntryViewModel mChartEntryViewModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mPresenter.areClicksEnabled()).thenReturn(true);
        when(mImageView.getContext()).thenReturn(mActivity);
        mChartEntry = MockChartEntryUtils.createMockChartEntry();
        mChartEntryViewModel = new ChartEntryViewModel(mChartEntry, mPresenter);
    }

    @Test
    public void shouldGetTitle() throws Exception {
        assertEquals(mChartEntry.getTitle(), mChartEntryViewModel.getTitle());
    }

    @Test
    public void shouldGetArtist() throws Exception {
        assertEquals(mChartEntry.getArtist(), mChartEntryViewModel.getArtist());
    }

    @Test
    public void shouldGetImageUrl() throws Exception {
        assertEquals(mChartEntry.getImageUrl(), mChartEntryViewModel.getImageUrl());
    }

    @Test
    public void shouldOnClickWithCorrectChartEntry() throws Exception {
        mChartEntryViewModel.onClick(mImageView);
        verify(mPresenter).openItem(Mockito.any(Activity.class), eq(mImageView), eq(mChartEntry));
    }
}
