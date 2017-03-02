package com.astroandroid.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.webkit.URLUtil;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by paulnguyen on 3/2/17.
 */

@AutoValue
public abstract class ChannelEvent extends BaseObservable implements Serializable {

    public ChannelEvent() {
    }

    @SerializedName("provider")
    public abstract String provider();

    @Nullable
    @SerializedName("actors")
    public abstract String actors();

    @Nullable
    @SerializedName("certification")
    public abstract String certification();

    @SerializedName("channelHD")
    public abstract String channelHD();

    @SerializedName("channelId")
    public abstract int channelId();

    @SerializedName("channelStbNumber")
    public abstract int channelStbNumber();

    @SerializedName("channelTitle")
    public abstract String channelTitle();

    @Nullable
    @SerializedName("contentId")
    public abstract String contentId();

    @Nullable
    @SerializedName("contentImage")
    public abstract String contentImage();

    @Nullable
    @SerializedName("directors")
    public abstract String directors();

    @Nullable
    @SerializedName("displayDateTime")
    public abstract String displayDateTime();

    @Nullable
    @SerializedName("displayDateTimeUtc")
    public abstract String displayDateTimeUtc();

    @Nullable
    @SerializedName("displayDuration")
    public abstract String displayDuration();

    @Nullable
    @SerializedName("epgEventImage")
    public abstract String epgEventImage();

    @Nullable
    @SerializedName("episodeId")
    public abstract String episodeId();

    @SerializedName("eventID")
    public abstract int eventID();

    @Nullable
    @SerializedName("genre")
    public abstract String genre();

    @Nullable
    @SerializedName("groupKey")
    public abstract String groupKey();

    @Nullable
    @SerializedName("highlight")
    public abstract String highlight();

    @Nullable
    @SerializedName("live")
    public abstract String live();

    @Nullable
    @SerializedName("longSynopsis")
    public abstract String longSynopsis();

    @Nullable
    @SerializedName("ottBlackout")
    public abstract String ottBlackout();

    @Nullable
    @SerializedName("premier")
    public abstract String premier();

    @Nullable
    @SerializedName("producers")
    public abstract String producers();

    @Nullable
    @SerializedName("programmeId")
    public abstract String programmeId();

    @Nullable
    @SerializedName("programmeTitle")
    public abstract String programmeTitle();

    @Nullable
    @SerializedName("shortSynopsis")
    public abstract String shortSynopsis();

    @Nullable
    @SerializedName("siTrafficKey")
    public abstract String siTrafficKey();

    @Nullable
    @SerializedName("subGenre")
    public abstract String subGenre();


    @Bindable
    public String getImageUrl() {
        String image = epgEventImage();
        if (image != null)
            return image;
        return  "https://upload.wikimedia.org/wikipedia/en/5/5b/Astro_Satellite_Pay_TV_Provider_(Malaysia).png";
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(SimpleDraweeView view, String imageUrl) {
        Log.d(Results.class.getName(), "image URL = " + imageUrl);
        if (URLUtil.isHttpsUrl(imageUrl) || URLUtil.isHttpUrl(imageUrl)) {
            view.setImageURI(Uri.parse(imageUrl));
        } else {
            view.setImageURI("file://" + Uri.parse(imageUrl));
        }
    }

    public static TypeAdapter<ChannelEvent> typeAdapter(Gson gson) {
        return new AutoValue_ChannelEvent.GsonTypeAdapter(gson);
    }
}
