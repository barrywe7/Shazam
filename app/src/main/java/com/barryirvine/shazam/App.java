package com.barryirvine.shazam;

import android.app.Application;

import com.barryirvine.shazam.api.ChartAPI;
import com.barryirvine.shazam.dagger.component.AppComponent;
import com.barryirvine.shazam.dagger.component.DaggerAppComponent;
import com.barryirvine.shazam.dagger.module.AppModule;
import com.barryirvine.shazam.dagger.module.NetModule;

public class App extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(ChartAPI.BASE_URL))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
