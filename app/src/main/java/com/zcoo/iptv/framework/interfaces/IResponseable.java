package com.zcoo.iptv.framework.interfaces;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv.framework.interfaces
 * Time: 2015/7/15 11:11
 */
public interface IResponseable {

    /**
     * 请求开始
     */
    void onStart();

    /**
     * 网络请求成功
     * @param result 返回字符结果
     */
    void onSuccess(String result);

    /**
     * 网络请求失败
     * @param result 返回字符结果
     */
    void onFailed(String result);
}
