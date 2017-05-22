package com.barryirvine.shazam.dagger.module;

import com.barryirvine.shazam.model.mapper.ChartResponseMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MapperModule {
    @Provides
    @Singleton
    ChartResponseMapper provideChartResponseMapper() {
        return new ChartResponseMapper();
    }
}