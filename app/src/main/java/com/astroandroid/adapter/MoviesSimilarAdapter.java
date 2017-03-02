package com.astroandroid.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.astroandroid.R;
import com.astroandroid.databinding.EventItemBinding;
import com.astroandroid.databinding.MovieItemBinding;
import com.astroandroid.model.ChannelEvent;
import com.astroandroid.model.Results;

import java.util.List;

/**
 * Created by Aan Nguyen on 1/17/17.
 */

public class MoviesSimilarAdapter extends RecyclerView.Adapter<ChannelEventViewHolder> {

    private static final String TAG = MoviesSimilarAdapter.class.getName();

    private List<ChannelEvent> itemList;
    private ChannelEvent dataResults;
    private EventItemBinding binding;

    @Override
    public ChannelEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        binding = DataBindingUtil.inflate(inflater, R.layout.event_item, parent, false);
        return new ChannelEventViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ChannelEventViewHolder holder, int position) {
        dataResults = itemList.get(position);
        holder.update(dataResults);
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void setResultItems(List<ChannelEvent> resultItems) {
        this.itemList = resultItems;
        notifyDataSetChanged();
    }
}
