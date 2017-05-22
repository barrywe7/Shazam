package com.barryirvine.shazam.model.mapper;


import com.barryirvine.shazam.model.local.ChartEntry;
import com.barryirvine.shazam.model.server.ChartResponse;
import com.barryirvine.shazam.model.server.Track;

import java.util.ArrayList;
import java.util.List;

public class ChartResponseMapper {
    public List<ChartEntry> map(ChartResponse chartResponse) {
        if (chartResponse == null || chartResponse.getTracks() == null || chartResponse.getTracks().size() == 0) {
            return null;
        }

        final List<ChartEntry> chartEntries = new ArrayList<>(chartResponse.getTracks().size());

        for (final Track track : chartResponse.getTracks()) {
            chartEntries.add(
                    new ChartEntry.Builder()
                            .title(track.getHeading().getTitle())
                            .artist(track.getHeading().getSubtitle())
                            .imageUrl(track.getImages().getUrl())
                            .build());
        }

        return chartEntries;
    }
}
