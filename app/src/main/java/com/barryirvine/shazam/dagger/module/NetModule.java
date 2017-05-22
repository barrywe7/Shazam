package com.barryirvine.shazam.dagger.module;


import android.app.Application;

import com.barryirvine.shazam.api.ChartAPI;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {
    private static final long CACHE_SIZE = 10 * 1024 * 1024; // 30 MiB
    private static final String CACHE_DIR = "http";
    private final String mBaseUrl;

    public NetModule(final String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Cache provideHttpCache(final Application application) {
        return new Cache(new File(application.getCacheDir(), CACHE_DIR), CACHE_SIZE);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(final Cache cache) {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).cache(cache).build();
    }

    @Provides
    @Singleton
    ChartAPI provideChartAPI(final Gson gson, final OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build()
                .create(ChartAPI.class);
    }

    @Provides
    @Singleton
    OkHttp3Downloader provideOkHttp3Downloader(final OkHttpClient client) {
        return new OkHttp3Downloader(client);
    }

    @Provides
    @Singleton
    Picasso providePicasso(final Application application, final OkHttp3Downloader downloader) {
        // Use indicators enabled here to check caching when required
        return new Picasso.Builder(application).downloader(downloader).build();

    }

}
