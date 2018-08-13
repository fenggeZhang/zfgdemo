package com.zfg.test.weigt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.facebook.stetho.common.LogUtil;
import com.zfg.test.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zfg on 2018/8/7
 * 自定义的电子签名
 */
public class DrawTextView extends View {
    private Paint linePaint;//画笔
    private ArrayList<Path> lines;
    private int lineCount;//记录画笔的数目

    private final int DEFULT_LINE_WIDTH = 10;//默认画笔的宽度

    private int lineColor = Color.BLACK;
    private float lineWidth = DEFULT_LINE_WIDTH;


    public DrawTextView(Context context) {
        super(context);
        initLinePaint();
        lines = new ArrayList<Path>();
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.SignView);
            parseTyepdArray(tArray);
        }
        initLinePaint();
        lines = new ArrayList<Path>();
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.SignView, defStyleAttr, 0);
            parseTyepdArray(tArray);
        }
        initLinePaint();
        lines = new ArrayList<Path>();
    }

    @SuppressLint("NewApi")
    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        if (attrs != null) {
            TypedArray tArray = context.obtainStyledAttributes(attrs, R.styleable.SignView, defStyleAttr, defStyleRes);
            parseTyepdArray(tArray);
        }
        initLinePaint();
        lines = new ArrayList<Path>();
    }

    private void parseTyepdArray(TypedArray tArray) {
        lineColor = tArray.getColor(R.styleable.SignView_lineColor, Color.BLACK);
        lineWidth = tArray.getDimension(R.styleable.SignView_lineWidth, DEFULT_LINE_WIDTH);
    }

    /**
     * 初始化 画笔
     */
    private void initLinePaint() {
        linePaint = new Paint();
        linePaint.setColor(lineColor);
        linePaint.setStrokeWidth(lineWidth);
        linePaint.setStrokeCap(Paint.Cap.ROUND);
        linePaint.setPathEffect(new CornerPathEffect(50));
        linePaint.setStyle(Paint.Style.STROKE);
    }

    /**
     * 绘制
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (lines != null && lines.size() > 0) {
            for (Path path : lines)
                canvas.drawPath(path, linePaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {// 按下这个屏幕
            Path path = new Path();
            path.moveTo(event.getX(), event.getY());
            lines.add(path);
            lineCount = lines.size();
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {// 在屏幕上移动
            lines.get(lineCount - 1).lineTo(event.getX(), event.getY());
            invalidate();
        } else {

        }
        return true;
    }

    public void setLineColor(int lineColor) {
        this.lineColor = lineColor;
        linePaint.setColor(lineColor);
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
        linePaint.setStrokeWidth(lineWidth);
    }

    public Bitmap getImage() {

        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Log.e("绘制", getWidth() + "::" + getHeight());

        Canvas canvas = new Canvas(bitmap);
        /**
         * 绘制背景
         */
        Drawable bgDrawable = getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        draw(canvas);// 绘制view视图的内容
        return bitmap;
    }

    /**
     * 保存图像到本地文件
     *
     * @param filePath
     * @return
     */
    public boolean saveImageToFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            getImage().compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public void clearPath() {
        lines.removeAll(lines);
        invalidate();
    }
}

