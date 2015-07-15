package com.zcoo.iptv.framework;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.zcoo.iptv.R;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv.framework
 * Time: 2015/7/15 22:34
 */
public class BaseActivity extends Activity{

    private Toast mToast;
    private View mToastView;

    private static BaseActivity mInstance;
    private BaseActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = this;
        ViewUtils.inject(this); //初始化xutils
        // 保持屏幕常亮、加入电源锁
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public static BaseActivity getInstance(){
        return mInstance;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * 自定义Toast显示
     * @param msg 消息信息
     * @param duration 展示时间
     */
    public void showToast(String msg, int duration){
        TextView message = null;
        if (null == mToastView) {
            mToastView = getLayoutInflater().inflate(R.layout.iptv_toast, null);
        }
        message = (TextView) mToastView.findViewById(R.id.message);
        message.setText(msg);

        if (null == mToast) {
            mToast = new Toast(this);
        }
        mToast.setDuration(duration);
        mToast.setView(mToastView);
        mToast.show();
    }
}
