package com.astroandroid.di.component;

import com.astroandroid.di.module.AppModule;
import com.astroandroid.di.module.MovieModule;
import com.astroandroid.di.module.NetworkModule;
import com.astroandroid.view.FavoritesFragment;
import com.astroandroid.view.MovieDetailActivity;
import com.astroandroid.view.MoviesFragment;
import com.astroandroid.viewmodel.FavoritesFragmentViewModel;
import com.astroandroid.viewmodel.MovieDetailActivityViewModel;
import com.astroandroid.viewmodel.MoviesFragmentViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aan Nguyen on 1/8/17.
 */

@Singleton
@Component(modules ={AppModule.class, NetworkModule.class, MovieModule.class} )
public interface AppComponent {

    void inject(MoviesFragment activity);
    void inject(MoviesFragmentViewModel activity);

    void inject(FavoritesFragment activity);
    void inject(FavoritesFragmentViewModel activity);

    void inject(MovieDetailActivity activity);
    void inject(MovieDetailActivityViewModel activity);
}
