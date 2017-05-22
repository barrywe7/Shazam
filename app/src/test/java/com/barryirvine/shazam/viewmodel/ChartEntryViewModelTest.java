package com.barryirvine.shazam.viewmodel;

import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.model.local.MockChartEntryUtils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChartEntryViewModelTest {

    private ChartEntry mChartEntry;
    private ChartEntryViewModel mChartEntryViewModel;

    @Before
    public void setUp() throws Exception {
        mChartEntry = MockChartEntryUtils.createMockChartEntry();
        mChartEntryViewModel = new ChartEntryViewModel(mChartEntry);
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
}
