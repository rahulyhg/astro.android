package com.astroandroid.api;

import com.astroandroid.model.ChannelEvents;
import com.astroandroid.model.Data;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Aan Nguyen on 1/9/17.
 */

public interface MovieApi {

    @GET("/api/channels")
    Flowable<Data> getChannels();

    @GET("/api/channel/ASTRO/{id}")
    Flowable<ChannelEvents> getChannelDetail(@Path("id") String id);
}
