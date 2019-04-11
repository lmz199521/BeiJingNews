package com.example.hasee.bJnews.main;

import android.support.annotation.IdRes;
import android.util.Log;

import com.example.hasee.bJnews.base.Basepresenter;
import com.example.hasee.bJnews.base.ModelManger;

/**
 * Created by Lmz on 2019/04/11
 * 调用Model的方法获取数据，并处理数据（业务逻辑）
 */
public class MainPersenter extends Basepresenter<Mainview>{


    public void translate(String doctype,String type,String i){
        MainModel model = ModelManger.getInstance().getModel(MainModel.class);
        model.translate(doctype, type, i, new MainCallback() {
            @Override
            public void onSuccess(WordBean data) {
                Log.d("lmz","zzzz");
                boolean attach = isAttach();
                Log.d("lmz","attach:"+attach);
                if (isAttach()){

                    view.onSuccess(data);
                }
                Log.d("lmz","data:"+data.getTranslateResult().get(0).get(0).getTgt());

            }

            @Override
            public void onFailure(String message) {
                if (isAttach()){
                    view.onFailure(message);
                }



            }
        });

    }

}
