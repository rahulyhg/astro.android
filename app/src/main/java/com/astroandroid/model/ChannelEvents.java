package com.astroandroid.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Aan Nguyen on 1/8/17.
 */

@AutoValue
public abstract class ChannelEvents {

    @SerializedName("page")
    public abstract int page();

    @SerializedName("data")
    public abstract List<ChannelEvent> resultsList();

    public static TypeAdapter<ChannelEvents> typeAdapter(Gson gson){
        return new AutoValue_ChannelEvents.GsonTypeAdapter(gson);
    }

}
