package com.astroandroid.viewmodel;

import com.astroandroid.model.ChannelEvent;

import java.util.List;

/**
 * Created by Aan Nguyen on 1/17/17.
 */

public interface MovieDetailActivityView extends IView {

    void load(List<ChannelEvent> results);
}
