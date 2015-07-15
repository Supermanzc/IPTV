package com.zcoo.iptv.framework.mgr;

import android.content.Context;
import android.content.SharedPreferences;

import com.zcoo.iptv.IPTVApplication;
import com.zcoo.iptv.R;
import com.zcoo.iptv.framework.Constant;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv.framework.mgr
 * Time: 2015/7/15 11:31
 * 系统参数的存储和获取
 */
public class SystemMgr {

    /**
     * 获取系统语言
     * @return
     */
    public static String getSystemLangName() {
        SharedPreferences sp = IPTVApplication.getApplication()
                .getSharedPreferences(Constant.IPTV_SYS_CONFIG, Context.MODE_PRIVATE);
        String langName = sp.getString(Constant.IPTV_SYS_LANG_NAME,
                IPTVApplication.getApplication().getString(R.string.simple_chinese));
        return langName;
    }
}
