package com.zcoo.iptv;

import android.app.Application;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv
 * Time: 2015/7/14 18:14
 */
public class IPTVApplication extends Application {

    private static IPTVApplication mIptvApp;
    public static final float S_MBASE_SCREEN_WIDTH = 1280;
    public static final float S_MBASE_SCREEN_HEIGHT = 720;
    private int mScreenWidth;
    private int mScreenHeight;
    private float mScreenDensity; //屏幕密度

    private DisplayImageOptions mOptions;
    private DisplayImageOptions mFadeInOptions;
    private DisplayImageOptions mRoundOptions;
    private ImageLoader mImageLoader;


    @Override
    public void onCreate() {
        super.onCreate();
        setApplication(this);
        initScreenInfo();
        initImageLoadConfiguration();

    }

    private void setApplication(IPTVApplication app) {
        mIptvApp = app;
    }

    public static IPTVApplication getApplication() {
        return mIptvApp;
    }

    /**
     * 初始化屏幕信息
     */
    public void initScreenInfo(){
        DisplayMetrics dms = new DisplayMetrics();
        dms = getResources().getDisplayMetrics();
        mScreenDensity = dms.density;
        mScreenWidth = dms.widthPixels;
        mScreenHeight = dms.heightPixels;
    }

    /**
     * 获取屏幕的像素比例
     * @return
     */
    public float getScreenDensity(){
        return mScreenDensity;
    }

    /**
     * 设置屏幕的宽度
     * @param screenWidth
     */
    public void setScreenWidth(int screenWidth){
        mScreenWidth = screenWidth;
    }

    /**
     * 获取屏幕的宽度
     * @return
     */
    public int getScreenWidth(){
        return mScreenWidth;
    }

    /**
     * 设置屏幕的高度
     * @param screenHeight
     */
    public void setScreenHeight(int screenHeight){
        mScreenHeight = screenHeight;
    }

    /**
     * 获取屏幕的高度
     * @return
     */
    public int getScreenHeight(){
        return mScreenHeight;
    }

    /**
     * 初始化网络图片加载类
     */
    private void initImageLoadConfiguration(){
        mOptions = new DisplayImageOptions.Builder().showImageOnLoading(null).showImageForEmptyUri(null).
                showImageOnFail(null).cacheInMemory(true).cacheOnDisk(true).
                considerExifParams(true).bitmapConfig(Bitmap.Config.ARGB_8888).build();
        mFadeInOptions = new DisplayImageOptions.Builder().showImageOnLoading(null).showImageForEmptyUri(null).showImageOnFail(null)
                .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(Bitmap.Config.ARGB_8888)
                .displayer(new FadeInBitmapDisplayer(2000)).build();
        mRoundOptions = new DisplayImageOptions.Builder().showImageOnLoading(null).showImageForEmptyUri(null).showImageOnFail(null)
                .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(Bitmap.Config.ARGB_8888)
                .displayer(new RoundedBitmapDisplayer(20)).build();

        mImageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()).diskCacheSize(50 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        mImageLoader.init(configuration);
    }

    /**
     * 获取图片加载
     * @return
     */
    public ImageLoader getImageLoader(){
        return mImageLoader;
    }

    /**
     * 获取图片加载一般属性
     * @return
     */
    public DisplayImageOptions getImageLoaderOptions(){
        return mOptions;
    }

    /**
     * 获取图片渐显属性
     * @return
     */
    public DisplayImageOptions getImageLoaderFadeInOptions(){
        return mFadeInOptions;
    }

    /**
     * 获取圆形图片加载属性
     * @return
     */
    public DisplayImageOptions getImageLoaderRoundOptions(){
        return mRoundOptions;
    }
}
