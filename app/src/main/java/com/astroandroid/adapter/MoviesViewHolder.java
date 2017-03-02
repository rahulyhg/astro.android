package com.astroandroid.adapter;

import android.support.v7.widget.RecyclerView;

import com.astroandroid.databinding.MovieItemBinding;
import com.astroandroid.model.Results;

/**
 * Created by Aan Nguyen on 1/10/17.
 */

public class MoviesViewHolder extends RecyclerView.ViewHolder{

    MovieItemBinding binding;
    public MoviesViewHolder(MovieItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void update(Results trendsItem) {
        binding.setResult(trendsItem);
        binding.executePendingBindings();
    }
}
