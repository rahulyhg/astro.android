package com.astroandroid;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.astroandroid.di.component.AppComponent;
import com.astroandroid.di.component.DaggerAppComponent;
import com.astroandroid.di.module.AppModule;
import com.astroandroid.di.module.MovieModule;
import com.astroandroid.di.module.NetworkModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Aan Nguyen on 1/15/17.
 */

public class MovieApplication extends Application{

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);

        appComponent = DaggerAppComponent.builder()
                .movieModule(new MovieModule())
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();

    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }

    public static MovieApplication get(Context context) {
        return (MovieApplication) context.getApplicationContext();
    }
}
