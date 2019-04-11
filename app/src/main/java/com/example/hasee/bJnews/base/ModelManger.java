package com.example.hasee.bJnews.base;

import java.lang.reflect.Constructor;

/**
 * Created by Lmz on 2019/04/11
 * 创建单例模式
 */
public class ModelManger {
    private static final ModelManger ourInstance = new ModelManger();

    public static ModelManger getInstance() {
        return ourInstance;
    }

    private ModelManger() {
    }

    public <M>M getModel(Class<M> modelclass){

        try {
            Constructor<M> constructor = modelclass.getConstructor();
            M instance = constructor.newInstance();
            return instance;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
