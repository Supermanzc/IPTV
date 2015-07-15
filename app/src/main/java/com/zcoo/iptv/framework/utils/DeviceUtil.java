package com.zcoo.iptv.framework.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;

import com.zcoo.iptv.IPTVApplication;
import com.zcoo.iptv.R;
import com.zcoo.iptv.framework.Constant;
import com.zcoo.iptv.framework.mgr.SystemMgr;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.ServerSocket;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv.framework.utils
 * Time: 2015/7/15 11:21
 * 系统驱动工具类
 */
public class DeviceUtil {

    /**
     * 获取设备在WiFi和连接状态下的的IP地址
     *
     * @return
     */
    public static String getLocalWifiMacAddress() {
        // 在wifi未开启状态下，仍然可以获取MAC地址，但是IP地址必须在已连接状态下否则为0
        String macAddress = null;
        WifiManager wifiMgr = (WifiManager) IPTVApplication.getApplication()
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
        if (null != info) {
            macAddress = info.getMacAddress();
        }

        return macAddress;
    }

    /**
     * 使用WIFI
     *
     * @return
     */
    public static String getLocalWifiIpAdress() {
        int ipAddress = 0;
        WifiManager wifiMgr = (WifiManager) IPTVApplication.getApplication()
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
        if (null != info) {
            ipAddress = info.getIpAddress();
        }
        String ip = intToIp(ipAddress);
        return ip;
    }

    /**
     * 获取空闲的可用端口
     *
     * @return
     */
    public static int getUseablePort() {
        ServerSocket serverSocket;
        int port = 0;
        try {
            serverSocket = new ServerSocket(0);
            port = serverSocket.getLocalPort();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return port;
    }

    public static String intToIp(int i) {
        return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF) + "." + (i >> 24 & 0xFF);
    }

    /**
     * 判断sdcard是否挂载
     * @return
     */
    public static boolean isSDCardExist() {
        boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        return sdCardExist;
    }

    /**
     * 获取sdcard的路径
     * @return
     */
    public static String getSDPath() {
        String sdDirString = null;
        if (isSDCardExist()) {
            sdDirString = Environment.getExternalStorageDirectory().getPath();
        }

        return sdDirString;
    }

    /**
     * 获取设备的mac地址
     * @param macType
     * @return
     */
    public static String getMac(int macType) {
        String macSerial = null;
        String str = "";
        try {
            Process pp = null;
            if (macType == Constant.WIFI_MAC) {
                pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address");
            } else if (macType == Constant.ETHERNET_MAC) {
                pp = Runtime.getRuntime().exec("cat /sys/class/net/eth0/address");
            } else {
                pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address");
            }

            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str; ) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();
                    break;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return macSerial;
    }

    /**
     * 获取本地连接状态下的mac地址
     * @return
     */
    public static String getIptvMacString() {
        return DeviceUtil.getMac(Constant.ETHERNET_MAC);
    }

    /**
     * 获取当前系统的语言
     * @return
     */
    public static String getCustomSystemLang() {
        String lang = SystemMgr.getSystemLangName();
        if (IPTVApplication.getApplication().getString(R.string.simple_chinese).equalsIgnoreCase(lang)) {
            return "zh_CN";
        } else if (IPTVApplication.getApplication().getString(R.string.english).equalsIgnoreCase(lang)) {
            return "en_US";
        } else {
            return "zh_CN";
        }
    }

    /**
     * 判断当前网络的状态的类型
     * @param context
     * @return
     */
    public static int getEthernetState(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
        if (null != networkInfo) {
            int netWorkType = networkInfo.getType();
            return netWorkType;
        }
        return -1;
    }
}
