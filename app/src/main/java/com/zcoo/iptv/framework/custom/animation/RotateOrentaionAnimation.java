package com.zcoo.iptv.framework.custom.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Author: Supermanzc
 * Project: IPTV
 * Package: com.zcoo.iptv.framework.custom.animation
 * Time: 2015/7/17 11:35
 */
public class RotateOrentaionAnimation extends Animation {
    /** 值为true时可明确查看动画的旋转方向。 */
    public static final boolean DEBUG = false;
    /** 沿Y轴正方向看，数值减1时动画逆时针旋转。 */
    public static final boolean ROTATE_DECREASE = true;
    /** 沿Y轴正方向看，数值减1时动画顺时针旋转。 */
    public static final boolean ROTATE_INCREASE = false;
    /** Z轴上最大深度。 */
    public static final float DEPTH_Z = 1000.0f;
    /** 动画显示时长。 */
    public static final long DURATION = 2000l;
    /** 围绕y轴转动 **/
    public static final int VERTICAL = 10;
    /** 围绕x轴转动 **/
    public static final int HORIZONTAL = 11;
    /** 图片翻转类型。 */
    private final boolean mType;
    private final float mCenterX;
    private final float mCenterY;
    private Camera mCamera;
    private int mOrentation;
    /** 用于监听动画进度。当值过半时需更新txtNumber的内容。 */
    private InterpolatedTimeListener listener;

    public RotateOrentaionAnimation(float cX, float cY, boolean type, int orentation) {
        mCenterX = cX;
        mCenterY = cY;
        this.mType = type;
        this.mOrentation = orentation;
        setDuration(DURATION);
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        // 在构造函数之后、getTransformation()之前调用本方法。
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    public void setInterpolatedTimeListener(InterpolatedTimeListener listener) {
        this.listener = listener;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        // interpolatedTime:动画进度值，范围为[0.0f,1.0f]
        if (listener != null) {
            listener.interpolatedTime(interpolatedTime);
        }
        float from = 0.0f, to = 0.0f;
        if (mType == ROTATE_DECREASE) {
            from = 0.0f;
            to = 180.0f;
        } else if (mType == ROTATE_INCREASE) {
            from = 360.0f;
            to = 180.0f;
        }
        float degree = from + (to - from) * interpolatedTime;
        boolean overHalf = (interpolatedTime > 0.5f);
        if (overHalf) {
            // 翻转过半的情况下，为保证数字仍为可读的文字而非镜面效果的文字，需翻转180度。
            degree = degree - 180;
        }
        // float depth = 0.0f;
        float depth = (0.5f - Math.abs(interpolatedTime - 0.5f)) * DEPTH_Z;
        final Matrix matrix = transformation.getMatrix();
        mCamera.save();
        mCamera.translate(0.0f, 0.0f, depth);
        if (mOrentation == VERTICAL) {
            mCamera.rotateY(degree);
        } else {
            mCamera.rotateX(degree);
        }
        mCamera.getMatrix(matrix);
        mCamera.restore();
        if (DEBUG) {
            if (overHalf) {
                matrix.preTranslate(-mCenterX * 2, -mCenterY);
                matrix.postTranslate(mCenterX * 2, mCenterY);
            }
        } else {
            // 确保图片的翻转过程一直处于组件的中心点位置
            matrix.preTranslate(-mCenterX, -mCenterY);
            matrix.postTranslate(mCenterX, mCenterY);
        }
    }

    /** 动画进度监听器。 */
    public static interface InterpolatedTimeListener {
        public void interpolatedTime(float interpolatedTime);
    }
}
