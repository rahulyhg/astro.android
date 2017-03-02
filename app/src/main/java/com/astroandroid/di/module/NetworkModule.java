package com.astroandroid.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.astroandroid.api.AutoValueGsonFactory;
import com.astroandroid.api.LoggingInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aan Nguyen on 1/8/17.
 */


@Module
public class NetworkModule {

    @Provides
    @Singleton
    Gson provideGson(){
        return new GsonBuilder().serializeNulls().registerTypeAdapterFactory(AutoValueGsonFactory.create()).create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    Retrofit proviRetrofit(OkHttpClient okHttpClient, GsonConverterFactory factory){
        return new Retrofit.Builder()
                .baseUrl("http://punny.me/")
                .client(okHttpClient)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
