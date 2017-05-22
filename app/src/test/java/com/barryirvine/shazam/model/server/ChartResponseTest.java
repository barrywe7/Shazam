package com.barryirvine.shazam.model.server;

import com.barryirvine.shazam.TestUtils;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ChartResponseTest {

    private Gson mGson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    /**
     * The purpose of this test is not to test the Gson deserialisation but to ensure that
     * the data model is configured correctly
     *
     * @throws Exception If the file cannot be found or we fail to meet the test criteria
     */
    @Test
    public void getTracks() throws Exception {
        final String json = TestUtils.getFileContents("two_chart_entry.json", ChartResponseTest.class);
        final ChartResponse response = mGson.fromJson(json, ChartResponse.class);
        assertNotNull("Response should not be null", response);
        assertEquals(2, response.getTracks().size());
    }

}
