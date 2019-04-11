package com.example.hasee.bJnews.base;

/**
 * Created by Lmz on 2019/04/11
 * 中间人类， 继承Baseview 。可以共用他里面的方法
 */
public class Basepresenter<V extends BaseView>{
    //受保护的类，它定义的值，只要是子类都可以直接使用1
    protected V view;
    //返回View
    public V getView(){
        return view;
    }
    /**
     * 绑定Activity 和View
     */
    public void attachView(V view){
        this.view =view;
    }
    //解绑
    public void DetachView(){
        this.view = null;
    }
    //判断是否绑定
    public boolean isAttach(){
        return view!=null;
    }


}
