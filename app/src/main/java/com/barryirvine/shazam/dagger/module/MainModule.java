package com.barryirvine.shazam.dagger.module;

import com.barryirvine.shazam.interactors.InteractorContract;
import com.barryirvine.shazam.ui.contract.MainContract;
import com.barryirvine.shazam.viewmodel.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    @Singleton
    MainContract.Presenter providePresenter(final InteractorContract.ChartApi chartApi) {
        return new MainPresenter(chartApi);
    }
}
