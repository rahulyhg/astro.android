package com.astroandroid.api;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by Aan Nguyen on 1/8/17.
 */

@GsonTypeAdapterFactory
public abstract class AutoValueGsonFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create(){
        return new AutoValueGson_AutoValueGsonFactory();
    }
}
