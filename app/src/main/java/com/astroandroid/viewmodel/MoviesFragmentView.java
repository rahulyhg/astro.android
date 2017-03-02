package com.astroandroid.viewmodel;

import com.astroandroid.model.Results;

import java.util.List;

/**
 * Created by Aan Nguyen on 1/15/17.
 */

public interface MoviesFragmentView extends IView {

    void load(List<Results> results);
}
