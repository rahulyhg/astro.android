package com.astroandroid.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.astroandroid.viewmodel.BaseViewModel;
import com.astroandroid.viewmodel.IView;

/**
 * Created by Aan Nguyen on 1/15/17.
 */

public abstract class BaseFragment<B extends ViewDataBinding,T extends BaseViewModel> extends Fragment implements IView {

    protected T viewModel;
    B binding;

    protected final void bindFragmentView(LayoutInflater inflater, int layout, ViewGroup viewGroup, boolean flag){
        if(viewModel == null){
            throw new IllegalStateException("channelDetail must not be null and should be injected via activityComponent().inject(this)");
        }
        binding = DataBindingUtil.inflate(inflater,layout,viewGroup,flag);// setContentView(this,layout);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewModel.clearSubscription();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.detach();
    }
}
