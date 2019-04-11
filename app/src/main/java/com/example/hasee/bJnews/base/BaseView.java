package com.example.hasee.bJnews.base;

/**
 * Created by Lmz on 2019/04/11
 * 获取数据的方法接口。 共用的方法
 */
public interface BaseView<D> {
    // 因为不确定数据的类型，所以用泛型，什么时候用到了。在确认类型
    void onSuccess(D data);
    // 设置失败方法，参数是失败的原因
    void onFailure(String message);
}
