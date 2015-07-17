package com.zcoo.iptv.framework.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.zcoo.iptv.IPTVApplication;
import com.zcoo.iptv.framework.custom.animation.RotateOrentaionAnimation;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv.framework.utils
 * Time: 2015/7/17 11:30
 * 动画
 */
public class AnimationUtil {

    /**
     * 随机动画集
     * @param view
     */
    public static void setRandomAnimation(View... view) {
        int index = (int) (Math.random() * 10);
        // 动画集
        AnimationSet set = new AnimationSet(true);

        switch (index) {
            case 0:
                // 初始化 Alpha动画
                Animation alphaAnimation0 = new AlphaAnimation(0.1f, 1.0f);
                set.addAnimation(alphaAnimation0);
                break;
            case 1:
                // 初始化 Alpha动画
                Animation alphaAnimation1 = new AlphaAnimation(0.1f, 1.0f);
                // 初始化缩放动画
                Animation scaleAnimation1 = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f);
                set.addAnimation(alphaAnimation1);
                set.addAnimation(scaleAnimation1);
                break;
            case 2:
                // 初始化 Alpha动画
                Animation alphaAnimation2 = new AlphaAnimation(0.1f, 1.0f);
                // 初始化缩放动画
                Animation scaleAnimation2 = new ScaleAnimation(0.1f, 1.0f, 1.0f, 1.0f);
                set.addAnimation(alphaAnimation2);
                set.addAnimation(scaleAnimation2);
                break;
            case 3:
                // 初始化 Alpha动画
                Animation alphaAnimation3 = new AlphaAnimation(0.1f, 1.0f);
                // 初始化缩放动画
                Animation scaleAnimation3 = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f);
                set.addAnimation(alphaAnimation3);
                set.addAnimation(scaleAnimation3);
                break;
            case 4:
                // 初始化 Alpha动画
                Animation alphaAnimation4 = new AlphaAnimation(0.1f, 1.0f);
                // 初始化移动动画
                Animation translateAnimation4 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                        Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                set.addAnimation(alphaAnimation4);
                set.addAnimation(translateAnimation4);
                break;
            case 5:
                // 初始化 Alpha动画
                Animation alphaAnimation5 = new AlphaAnimation(0.1f, 1.0f);
                Animation scaleAnimation5 = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                // 初始化旋转动画
                Animation rotateAnimation5 = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                set.addAnimation(alphaAnimation5);
                set.addAnimation(scaleAnimation5);
                set.addAnimation(rotateAnimation5);
                break;
            case 6:
                // 初始化 Alpha动画
                Animation alphaAnimation6 = new AlphaAnimation(0.1f, 1.0f);
                Animation rotateVerticalAnimation6 = new RotateOrentaionAnimation(
                        IPTVApplication.getApplication().getScreenWidth() / 2,
                        IPTVApplication.getApplication().getScreenHeight() / 2,
                        RotateOrentaionAnimation.ROTATE_DECREASE, RotateOrentaionAnimation.HORIZONTAL);
                set.addAnimation(alphaAnimation6);
                set.addAnimation(rotateVerticalAnimation6);
                break;
            case 7:
                // 初始化 Alpha动画
                Animation alphaAnimation7 = new AlphaAnimation(0.1f, 1.0f);
                Animation rotateVerticalAnimation7 = new RotateOrentaionAnimation(
                        IPTVApplication.getApplication().getScreenWidth() / 2,
                        IPTVApplication.getApplication().getScreenHeight() / 2,
                        RotateOrentaionAnimation.ROTATE_INCREASE, RotateOrentaionAnimation.HORIZONTAL);
                set.addAnimation(alphaAnimation7);
                set.addAnimation(rotateVerticalAnimation7);
                break;
            case 8:
                // 初始化 Alpha动画
                Animation alphaAnimation8 = new AlphaAnimation(0.1f, 1.0f);
                Animation rotateVerticalAnimation8 = new RotateOrentaionAnimation(
                        IPTVApplication.getApplication().getScreenWidth() / 2,
                        IPTVApplication.getApplication().getScreenHeight() / 2,
                        RotateOrentaionAnimation.ROTATE_INCREASE, RotateOrentaionAnimation.VERTICAL);
                set.addAnimation(alphaAnimation8);
                set.addAnimation(rotateVerticalAnimation8);
                break;
            case 9:
                // 初始化 Alpha动画
                Animation alphaAnimation9 = new AlphaAnimation(0.1f, 1.0f);
                Animation rotateVerticalAnimation9 = new RotateOrentaionAnimation(
                        IPTVApplication.getApplication().getScreenWidth() / 2,
                        IPTVApplication.getApplication().getScreenHeight() / 2,
                        RotateOrentaionAnimation.ROTATE_INCREASE, RotateOrentaionAnimation.VERTICAL);
                set.addAnimation(alphaAnimation9);
                set.addAnimation(rotateVerticalAnimation9);
                break;
            default:
                break;
        }
        // 设置动画时间 (作用到每个动画)
        set.setDuration(2000);
        for (int i = 0; i < view.length; i++) {
            view[i].startAnimation(set);
            view[i].setVisibility(View.VISIBLE);
        }
    }

    /**
     * 2D随机动画集
     * @param view
     */
    public static void setRandom2DAnimation(View... view) {
        int index = (int) (Math.random() * 5);
        // 动画集
        AnimationSet set = new AnimationSet(true);

        switch (index) {
            case 0:
                // 初始化 Alpha动画
                Animation alphaAnimation0 = new AlphaAnimation(0.1f, 1.0f);
                set.addAnimation(alphaAnimation0);
                break;
            case 1:
                // 初始化 Alpha动画
                Animation alphaAnimation1 = new AlphaAnimation(0.1f, 1.0f);
                // 初始化缩放动画
                Animation scaleAnimation1 = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f);
                set.addAnimation(alphaAnimation1);
                set.addAnimation(scaleAnimation1);
                break;
            case 2:
                // 初始化 Alpha动画
                Animation alphaAnimation2 = new AlphaAnimation(0.1f, 1.0f);
                // 初始化缩放动画
                Animation scaleAnimation2 = new ScaleAnimation(0.1f, 1.0f, 1.0f, 1.0f);
                set.addAnimation(alphaAnimation2);
                set.addAnimation(scaleAnimation2);
                break;
            case 3:
                // 初始化 Alpha动画
                Animation alphaAnimation3 = new AlphaAnimation(0.1f, 1.0f);
                // 初始化缩放动画
                Animation scaleAnimation3 = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f);
                set.addAnimation(alphaAnimation3);
                set.addAnimation(scaleAnimation3);
                break;
            case 4:
                // 初始化 Alpha动画
                Animation alphaAnimation4 = new AlphaAnimation(0.1f, 1.0f);
                // 初始化移动动画
                Animation translateAnimation4 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                        Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                set.addAnimation(alphaAnimation4);
                set.addAnimation(translateAnimation4);
                break;
            default:
                break;
        }
        // 设置动画时间 (作用到每个动画)
        set.setDuration(2000);
        for (int i = 0; i < view.length; i++) {
            view[i].startAnimation(set);
            view[i].setVisibility(View.VISIBLE);
        }
    }

    /**
     * 设置透明动画
     * @param view
     */
    public static void setAlphaAnimation(View... view) {
        // 初始化 Alpha动画
        Animation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        // 动画集
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(alphaAnimation);
        // 设置动画时间 (作用到每个动画)
        set.setDuration(2000);
        for (int i = 0; i < view.length; i++) {
            view[i].startAnimation(set);
            view[i].setVisibility(View.VISIBLE);
        }
    }

    /**
     * 设置旋转动画
     * @param view
     */
    public static void setRotateAnimation(View... view) {
        // 初始化旋转动画
        Animation rotateAnimation = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // 动画集
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(rotateAnimation);
        // 设置动画时间 (作用到每个动画)
        set.setDuration(2000);
        for (int i = 0; i < view.length; i++) {
            view[i].startAnimation(set);
            view[i].setVisibility(View.VISIBLE);
        }
    }

    /**
     * 设置缩放动画
     * @param view
     */
    public static void setScaleAnimation(View... view) {
        // 初始化缩放动画
        Animation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f);
        // 初始化 Alpha动画
        Animation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        // 动画集
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);
        // 设置动画时间 (作用到每个动画)
        set.setDuration(2000);
        for (int i = 0; i < view.length; i++) {
            view[i].startAnimation(set);
            view[i].setVisibility(View.VISIBLE);
        }
    }
}
