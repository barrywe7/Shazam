package com.barryirvine.shazam.dagger.module;

import com.barryirvine.shazam.api.ChartAPI;
import com.barryirvine.shazam.interactors.ChartData;
import com.barryirvine.shazam.interactors.InteractorContract;
import com.barryirvine.shazam.model.mapper.ChartResponseMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    @Singleton
    InteractorContract.ChartApi providePhotoData(final ChartAPI chartAPI, final ChartResponseMapper mapper) {
        return new ChartData(chartAPI, mapper);
    }
}
