package com.zcoo.iptv;

import android.app.Application;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv
 * Time: 2015/7/14 18:14
 */
public class IPTVApplication extends Application {

    private static IPTVApplication mIptvApp;

    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);

    }

    private void setApplication(IPTVApplication app) {
        mIptvApp = app;
    }

    public static IPTVApplication getApplication() {
        return mIptvApp;
    }
}
