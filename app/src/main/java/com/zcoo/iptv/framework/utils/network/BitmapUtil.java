package com.zcoo.iptv.framework.utils.network;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.zcoo.iptv.IPTVApplication;
import com.zcoo.iptv.framework.utils.AnimationUtil;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv.framework.utils.network
 * Time: 2015/7/17 11:19
 * 加载网络图片类
 */
public class BitmapUtil {


    /**
     * 获取网络图片，随机动画显示
     * @param url
     * @param views
     */
    public static void setRandomImage(String url, ImageView... views){
        for (int i = 0; i < views.length; i++) {
            IPTVApplication.getApplication().getImageLoader().displayImage(url, views[i],
                    IPTVApplication.getApplication().getImageLoaderFadeInOptions(),
                    new SimpleImageLoadingListener(){
                        @Override
                        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                            super.onLoadingComplete(imageUri, view, loadedImage);
                            AnimationUtil.setRandomAnimation(view);
                        }
                    });
        }

    }

    /**
     * 获取网络图片，无动画效果显示
     * @param url
     * @param views
     */
    public static void setImage(String url, ImageView... views) {
        for (int i = 0; i < views.length; i++) {
            IPTVApplication.getApplication().getImageLoader().displayImage(url, views[i],
                    IPTVApplication.getApplication().getImageLoaderOptions(),
                    new SimpleImageLoadingListener(), new ImageLoadingProgressListener() {

                        @Override
                        public void onProgressUpdate(String imageUri, View view, int current, int total) {

                        }
                    });
        }
    }

    /**
     * 获取网络图片，渐入方式显示
     * @param url
     * @param views
     */
    public static void setFadeInImage(String url, ImageView... views) {
        for (int i = 0; i < views.length; i++) {
            IPTVApplication.getApplication().getImageLoader().displayImage(url, views[i],
                    IPTVApplication.getApplication().getImageLoaderFadeInOptions(),
                    new SimpleImageLoadingListener(), new ImageLoadingProgressListener() {

                        @Override
                        public void onProgressUpdate(String imageUri, View view, int current, int total) {

                        }
                    });
        }
    }

    /**
     * 获取网络图片，圆角形式展示
     * @param url
     * @param views
     */
    public static void setRoundImage(String url, ImageView... views) {
        for (int i = 0; i < views.length; i++) {
            IPTVApplication.getApplication().getImageLoader().displayImage(url, views[i],
                    IPTVApplication.getApplication().getImageLoaderRoundOptions(),
                    new SimpleImageLoadingListener(), new ImageLoadingProgressListener() {

                        @Override
                        public void onProgressUpdate(String imageUri, View view, int current, int total) {

                        }
                    });
        }
    }

    /**
     * 圆角图片渐入展示
     * @param url
     * @param views
     */
    public static void setRoundFadeInImage(String url, ImageView... views) {
        for (int i = 0; i < views.length; i++) {
            IPTVApplication.getApplication().getImageLoader().displayImage(url, views[i],
                    IPTVApplication.getApplication().getImageLoaderRoundOptions(),
                    new SimpleImageLoadingListener() {

                        @Override
                        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                            super.onLoadingComplete(imageUri, view, loadedImage);
                            FadeInBitmapDisplayer.animate(view, 1000);
                        }

                    }, new ImageLoadingProgressListener() {

                        @Override
                        public void onProgressUpdate(String imageUri, View view, int current, int total) {

                        }
                    });
        }
    }
}
