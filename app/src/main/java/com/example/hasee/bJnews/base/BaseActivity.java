package com.example.hasee.bJnews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Lmz on 2019/04/10
 *  最基础的类，根据项目模块所需要使用的类别，去选择继承的类，
 *  此项目，为新闻类项目，Fragment 用的比较多，故继承FragmentActivity
 */
public abstract class BaseActivity<V extends BaseView,P extends Basepresenter<V>, D> extends FragmentActivity implements BaseView<D>{

    private P persenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        persenter =createPersenter();
        persenter.attachView((V)this);
    }

    protected abstract P createPersenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //1
        persenter.DetachView();
    }
}
