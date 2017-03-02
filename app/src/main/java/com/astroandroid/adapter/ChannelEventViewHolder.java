package com.astroandroid.adapter;

import android.support.v7.widget.RecyclerView;

import com.astroandroid.databinding.EventItemBinding;
import com.astroandroid.databinding.MovieItemBinding;
import com.astroandroid.model.ChannelEvent;
import com.astroandroid.model.Results;

/**
 * Created by Aan Nguyen on 1/10/17.
 */

public class ChannelEventViewHolder extends RecyclerView.ViewHolder{

    EventItemBinding binding;
    public ChannelEventViewHolder(EventItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void update(ChannelEvent trendsItem) {
        binding.setResult(trendsItem);
        binding.executePendingBindings();
    }
}
