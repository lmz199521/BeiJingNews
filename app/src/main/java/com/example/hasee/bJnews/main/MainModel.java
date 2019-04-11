package com.example.hasee.bJnews.main;

import com.example.hasee.bJnews.base.BaseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lmz on 2019/04/11
 * 请求服务器，获取到数据后，通过callback接口回调给 调用者
 */
public class MainModel extends BaseModel{
        public void translate(String doctype,String type,String i,final MainCallback callback){
            //创建retrofit对象
            Retrofit retrofit =new Retrofit.Builder()
                                    .baseUrl("http://fanyi.youdao.com/")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
            //创建serviece 对象
            TranslateService service = retrofit.create(TranslateService.class);
            //创建call对象
            Call<WordBean> call = service.translate(doctype, type, i);
            //异步请求服务器
            call.enqueue(new Callback<WordBean>() {
                @Override
                public void onResponse(Call<WordBean> call, Response<WordBean> response) {
                        if (callback != null){
                            if (response.isSuccessful()){
                                WordBean body = response.body();
                                callback.onSuccess(body);
                            }else {
                                callback.onFailure(response.message());
                            }

                        }else {
                            //发送异常信号，callback不可以为空
                            throw  new NullPointerException("callback can not be null");
                        }
                }

                @Override
                public void onFailure(Call<WordBean> call, Throwable t) {

                    if (callback != null){
                        callback.onFailure(t.getMessage());
                    }else {
                        throw  new NullPointerException("callback can not be null");
                    }

                }
            });

        }
}
