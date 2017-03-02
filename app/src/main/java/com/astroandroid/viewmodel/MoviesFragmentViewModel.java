package com.astroandroid.viewmodel;

import com.astroandroid.api.MovieApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Aan Nguyen on 1/15/17.
 */

public class MoviesFragmentViewModel extends BaseViewModel<MoviesFragmentView> {

    private MovieApi movieApi;

    public MoviesFragmentViewModel(MovieApi movieApi) {
        this.movieApi = movieApi;
    }

    public void fetchCharacter() {
        compositeDisposable.add(movieApi.getChannels()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> view.load(data.resultsList()),
                        throwable -> view.error(throwable)));
    }
}
