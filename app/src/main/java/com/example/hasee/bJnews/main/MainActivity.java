package com.example.hasee.bJnews.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.hasee.bJnews.R;
import com.example.hasee.bJnews.base.BaseActivity;

/**
 * 1 activity 持有一个persenter对象，可以调用persenter的方法
 * 2.activity实现了view接口，用于更新UI,
 */
public class MainActivity extends BaseActivity<Mainview,MainPersenter,WordBean> implements Mainview{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //2
        createPersenter().translate("json","auto","rotate");
      //  presenter.translate("json", "auto", "code");
    }

    @Override
    protected MainPersenter createPersenter() {
        return new MainPersenter();
    }

    @Override
    public void onSuccess(WordBean data) {
        Log.d("lll","data:"+data.getTranslateResult().get(0).get(0).getTgt());
        String tgt = data.getTranslateResult().get(0).get(0).getTgt();
        Toast.makeText(this, "单词的意思是："+tgt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, "出现错误："+message, Toast.LENGTH_SHORT).show();
    }
}
