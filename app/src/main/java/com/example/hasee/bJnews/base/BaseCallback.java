package com.example.hasee.bJnews.base;

/**
 * Created by Lmz on 2019/04/11
 *
 */
public interface BaseCallback<D> {
    void onSuccess(D data);
    void onFailure(String message);

}
