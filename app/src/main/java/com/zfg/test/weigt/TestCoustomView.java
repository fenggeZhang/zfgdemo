package com.zfg.test.weigt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zfg on 2018/10/10
 * 自定义view
 */
public class TestCoustomView extends View {
    private Paint mPaint;//画笔

    public TestCoustomView(Context context) {
        super(context);
        init();
    }

    public TestCoustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TestCoustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF oval3 = new RectF(100, 180, 500, 600);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeWidth(3);//线宽度
        canvas.drawRoundRect(oval3, 20, 15, mPaint);
        canvas.drawOval(oval3, mPaint);//绘制椭圆
        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(100, 150, 80, mPaint);
        canvas.drawPoint(400, 400, mPaint);
        mPaint.setTextSize(60);
        canvas.drawText("西湖龙井", 400, 500, mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawArc(oval3, 0, 90, true, mPaint);

        Path path = new Path();
        path.moveTo(50, 600); //设定起始点
        path.lineTo(50, 700); //第一条直线的终点，也是第二条直线的起点
        path.lineTo(700, 700); //画第二条直线
        path.close();//闭环
        canvas.drawPath(path, mPaint);


        mPaint.setColor(Color.DKGRAY);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(40);
        canvas.drawTextOnPath("123456789012345678901234567890", path, 0, 0, mPaint);//第2 3得参数是偏移量得意思


    }
}
