package com.zcoo.iptv;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.zcoo.iptv.framework.Constant;
import com.zcoo.iptv.framework.interfaces.IResponseable;
import com.zcoo.iptv.framework.utils.CommonUtil;
import com.zcoo.iptv.framework.utils.DeviceUtil;
import com.zcoo.iptv.framework.utils.LogUtil;
import com.zcoo.iptv.framework.utils.network.HttpUtil;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String url = "http://127.0.0.1:8090/main?index=0";
    }
}
