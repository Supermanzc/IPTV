package com.zcoo.iptv;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.zcoo.iptv.utils.CommonUtil;
import com.zcoo.iptv.utils.LogUtil;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.e("我好想你，非常想你，真的很想你");

        LogUtil.d("-----------"+CommonUtil.getLocalMacAddress(IPTVApplication.getApplication()));
    }
}
