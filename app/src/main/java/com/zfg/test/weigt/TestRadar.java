package com.zfg.test.weigt;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.zfg.test.utils.LogUtil;


/**
 * Created by zfg on 2018/10/9
 * 自定义得view必须实现三个构造方法
 */
public class TestRadar extends View {
    private Paint mSweepPaint;
    private Paint mPaint;
    //扫描的转速，表示几秒转一圈
    private float mSpeed = 3.0f;

    private float mDegrees; //扫描时的扫描旋转角度。

    //扫描的颜色 RadarView会对这个颜色做渐变透明处理
    private int mSweepColor = Color.parseColor("#91D7F4");

    public TestRadar(Context context) {
        super(context);
        init();
    }

    public TestRadar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        getAttrs(context, attrs);
        init();
    }

    public TestRadar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        getAttrs(context, attrs);
        init();
    }

    /**
     * 初始化画笔
     */
    private void init() {
        mSweepPaint = new Paint();
        mSweepPaint.setAntiAlias(true);
        mPaint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //计算圆的半径
        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int height = getHeight() - getPaddingTop() - getPaddingBottom();
        int radius = Math.min(width, height) / 2;
        //计算圆的圆心
        int cx = getPaddingLeft() + (getWidth() - getPaddingLeft() - getPaddingRight()) / 2;
        int cy = getPaddingTop() + (getHeight() - getPaddingTop() - getPaddingBottom()) / 2;

       /* RectF oval3 = new RectF(150,100,600,600);
        mPaint.setColor(Color.BLACK);
        canvas.drawRoundRect(oval3, 20, 15, mPaint);*/

        drawSweep(canvas, cx, cy, radius);
        //计算雷达扫描的旋转角度
        LogUtil.e("绘制：" + mDegrees);
        mDegrees = (mDegrees + (360 / mSpeed / 60)) % 360;
        invalidate();
    }

    /**
     * 画扫描效果
     *
     * @param canvas
     * @param cx
     * @param cy
     * @param radius
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void drawSweep(Canvas canvas, int cx, int cy, int radius) {
        //扇形的透明的渐变效果  <梯度渲染>
        SweepGradient sweepGradient = new SweepGradient(cx, cy,
                new int[]{Color.TRANSPARENT, changeAlpha(mSweepColor, 0), changeAlpha(mSweepColor, 168),
                        changeAlpha(mSweepColor, 240), changeAlpha(mSweepColor, 255)
                }, new float[]{0.0f, 0.6f, 0.99f, 0.998f, 1f});
        mSweepPaint.setShader(sweepGradient);
        //先旋转画布，再绘制扫描的颜色渲染，实现扫描时的旋转效果。
        canvas.rotate(-90 + mDegrees, cx, cy);
        canvas.drawCircle(cx, cy, radius, mSweepPaint);
    }

    /**
     * 改变颜色的透明度
     *
     * @param color
     * @param alpha
     * @return
     */
    private static int changeAlpha(int color, int alpha) {
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        return Color.argb(alpha, red, green, blue);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*//设置宽高,默认200dp
        int defaultSize = dp2px(getContext(), 200);
        setMeasuredDimension(measureWidth(widthMeasureSpec, defaultSize),
                measureHeight(heightMeasureSpec, defaultSize));*/
    }

    /**
     * dp转px
     */
    private static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    /**
     * 测量宽
     *
     * @param measureSpec
     * @param defaultSize
     * @return
     */
    private int measureWidth(int measureSpec, int defaultSize) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = defaultSize + getPaddingLeft() + getPaddingRight();
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        result = Math.max(result, getSuggestedMinimumWidth());
        return result;
    }

    /**
     * 测量高
     *
     * @param measureSpec
     * @param defaultSize
     * @return
     */
    private int measureHeight(int measureSpec, int defaultSize) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = defaultSize + getPaddingTop() + getPaddingBottom();
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        result = Math.max(result, getSuggestedMinimumHeight());
        return result;
    }

}
