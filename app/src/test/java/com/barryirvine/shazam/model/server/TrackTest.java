package com.barryirvine.shazam.model.server;

import com.barryirvine.shazam.TestUtils;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * The purpose of this test is not to test the Gson deserialisation but to ensure that
 * the data model is configured correctly. The strings in the file single_track.json are used
 */
public class TrackTest {

    private Track mTrack;

    @Before
    public void setUp() {
        final Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        final String json = TestUtils.getFileContents("single_track.json", TrackTest.class);
        mTrack = gson.fromJson(json, Track.class);

    }

    @Test
    public void getImages() throws Exception {
        assertNotNull("Track should not be null", mTrack);
        assertNotNull("Track images should not be null", mTrack.getImages());
        assertEquals("https://images.shazam.com/coverart/t352190393_s400.jpg", mTrack.getImages().getUrl());
    }

    @Test
    public void getHeading() throws Exception {
        assertNotNull("Track should not be null", mTrack);
        assertNotNull("Track heading should not be null", mTrack.getHeading());
        assertEquals("DJ Khaled Feat. Justin Bieber & Quavo & Chance The Rapper & Lil Wayne", mTrack.getHeading().getSubtitle());
        assertEquals("I'm The One", mTrack.getHeading().getTitle());
    }

}
