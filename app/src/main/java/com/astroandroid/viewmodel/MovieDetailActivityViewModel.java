package com.astroandroid.viewmodel;

import com.astroandroid.api.MovieApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aan Nguyen on 1/17/17.
 */

public class MovieDetailActivityViewModel extends BaseViewModel<MovieDetailActivityView> {

    private MovieApi movieApi;

    public MovieDetailActivityViewModel(MovieApi movieApi){
        this.movieApi = movieApi;
    }

    public void fetchChannelDetail(String id){
        compositeDisposable.add(movieApi.getChannelDetail(id)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> view.load(data.resultsList()),
                        throwable -> view.error(throwable)));
    }
}
