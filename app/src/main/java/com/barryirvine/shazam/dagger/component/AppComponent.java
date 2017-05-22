package com.barryirvine.shazam.dagger.component;

import com.barryirvine.shazam.dagger.module.AppModule;
import com.barryirvine.shazam.dagger.module.InteractorModule;
import com.barryirvine.shazam.dagger.module.MainModule;
import com.barryirvine.shazam.dagger.module.MapperModule;
import com.barryirvine.shazam.dagger.module.NetModule;
import com.barryirvine.shazam.ui.fragment.ChartFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, NetModule.class, InteractorModule.class, MainModule.class, MapperModule.class})
public interface AppComponent {

    void inject(final ChartFragment fragment);

}
