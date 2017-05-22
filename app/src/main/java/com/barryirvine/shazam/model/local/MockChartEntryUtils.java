package com.barryirvine.shazam.model.local;

import java.util.UUID;

public class MockChartEntryUtils {

    private static String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    public static ChartEntry createMockChartEntry() {
        return new ChartEntry.Builder()
                .title(generateRandomString())
                .artist(generateRandomString())
                .imageUrl(generateRandomString())
                .build();
    }
}
