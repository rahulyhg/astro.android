package com.astroandroid.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

import com.astroandroid.viewmodel.BaseViewModel;
import com.astroandroid.viewmodel.IView;

/**
 * Created by Aan Nguyen on 1/8/17.
 */

public abstract class BaseActivity<B extends ViewDataBinding, T extends BaseViewModel> extends AppCompatActivity implements IView {

    protected T channelDetail;
    B binding;

    protected final void bindView(int layout){
        if(channelDetail == null){
            throw new IllegalStateException("channelDetail must not be null and should be injected via activityComponent().inject(this)");
        }
        binding = DataBindingUtil.setContentView(this,layout);
    }

    @Override
    protected void onStop() {
        super.onStop();
        channelDetail.clearSubscription();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        channelDetail.detach();
    }
}
