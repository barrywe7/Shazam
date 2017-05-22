package com.barryirvine.shazam.model.mapper;

import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.model.server.ChartResponse;
import com.barryirvine.shazam.model.server.Heading;
import com.barryirvine.shazam.model.server.Images;
import com.barryirvine.shazam.model.server.Track;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ChartResponseMapperTest {

    private static final String ARTIST = "Artist";
    private static final String TITLE = "Title";
    private static final String IMAGE_URL = "www.somedomain.com/image.jpg";

    @Mock
    private ChartResponse mChartResponse;
    @Mock
    private Heading mHeading;
    @Mock
    private Images mImages;
    @Mock
    private Track mTrack;

    private ChartResponseMapper mMapper;

    private List<ChartEntry> mChartEntries = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        mMapper = new ChartResponseMapper();
        MockitoAnnotations.initMocks(this);
        when(mImages.getUrl()).thenReturn(IMAGE_URL);
        when(mHeading.getSubtitle()).thenReturn(ARTIST);
        when(mHeading.getTitle()).thenReturn(TITLE);
        when(mTrack.getImages()).thenReturn(mImages);
        when(mTrack.getHeading()).thenReturn(mHeading);
        when(mChartResponse.getTracks()).thenReturn(Collections.singletonList(mTrack));
    }

    @Test
    public void map() throws Exception {
        final List<ChartEntry> entries = mMapper.map(mChartResponse);
        final Track testTrack = mChartResponse.getTracks().get(0);
        final ChartEntry testChartEntry = entries.get(0);
        assertEquals(testTrack.getHeading().getSubtitle(), testChartEntry.getArtist());
        assertEquals(testTrack.getHeading().getTitle(), testChartEntry.getTitle());
        assertEquals(testTrack.getImages().getUrl(), testChartEntry.getImageUrl());
    }

}
