package com.barryirvine.shazam.dagger.component;

import com.barryirvine.shazam.dagger.module.AppModule;
import com.barryirvine.shazam.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(final MainActivity activity);

}
