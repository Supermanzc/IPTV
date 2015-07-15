package com.zcoo.iptv.framework.utils.network;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.zcoo.iptv.IPTVApplication;
import com.zcoo.iptv.R;
import com.zcoo.iptv.framework.interfaces.IResponseable;
import com.zcoo.iptv.framework.utils.CommonUtil;
import com.zcoo.iptv.framework.utils.DeviceUtil;
import com.zcoo.iptv.framework.utils.LogUtil;
import com.zcoo.iptv.framework.utils.StringUtil;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv.framework.utils.network
 * Time: 2015/7/15 11:09
 * 网络请求工具类
 */
public class HttpUtil {
    /**
     * get网络数据
     * @param url url地址
     * @param iResponseable 返回结果数据
     */
    public static void get(String url, final IResponseable iResponseable){
        if(null == url || "".equals(url)){
            return;
        }

        if(CommonUtil.isNetworkAvailable(IPTVApplication.getApplication())){
            String lang = DeviceUtil.getCustomSystemLang();
            //url路径后面加入语言控制，便于服务端中英文切换
            String doActionUrl = url.indexOf("?") == -1 ? url + "?locale=" + lang : url + "&locale=" + lang;
            HttpUtils httpUtils = new HttpUtils();
            httpUtils.configCurrentHttpCacheExpiry(0);
            httpUtils.send(HttpRequest.HttpMethod.GET, doActionUrl, new RequestCallBack<String>() {

                @Override
                public void onStart() {
                    super.onStart();
                    iResponseable.onStart();
                }

                @Override
                public void onLoading(long total, long current, boolean isUploading) {
                    super.onLoading(total, current, isUploading);
                    LogUtil.d("LVB_X httpRequest doing onLoading total=" + total + "current=" + current + "\n");
                }

                @Override
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    LogUtil.d("LVB_X httpRequest end onSuccess responseInfo.result=" + responseInfo.result + "\n");
                    if (StringUtil.isEmpty(responseInfo.result)) {
                        iResponseable.onFailed(IPTVApplication.getApplication().getString(R.string.request_url_error));
                    } else {
                        iResponseable.onSuccess(responseInfo.result);
                    }
                }

                @Override
                public void onFailure(HttpException error, String msg) {
                    LogUtil.d("LVB_X httpRequest end onFailure msg=" + msg + "\n");
                    iResponseable.onFailed(msg);
                }
            });
        }else{
            //没有网络的状态
            iResponseable.onFailed(IPTVApplication.getApplication().getString(R.string.net_is_unusable_tips));
        }
    }
}
