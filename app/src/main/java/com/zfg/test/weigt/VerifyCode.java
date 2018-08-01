package com.zfg.test.weigt;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.zfg.test.R;

import java.util.Random;

/**
 * Created by zfg on 2018/8/1
 */
public class VerifyCode extends View {
    private String mCodeText;//文本内容
    private int mCodeTextSize;//文本大小
    private int mCodeLength;//验证码长度
    private int mCodeBackground;//背景色
    private boolean isContainChar;//验证码是否包含字母
    private int mPointNum;//干扰点数
    private int mLineNum;//干扰线数

    private Paint mPaint;//画笔
    private Rect mBound;//绘制范围
    private Bitmap bitmap;//验证码图片

    private static Random mRandom = new Random();
    private static int mWidth;//控件的宽度
    private static int mHeight;//控件的高度
    public VerifyCode(Context context) {
        super(context);
    }

    public VerifyCode(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrValues(context,attrs);
        initData();
    }

    /**
     * 初始化属性集合
     * @param context
     * @param attrs
     */
    private void initAttrValues(Context context, AttributeSet attrs){
        // //获取在AttributeSet中定义的 VerifyCode 中声明的属性的集合
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.VerifyCode);
        //获取TypeArray的长度
        int count=typedArray.getIndexCount();
        for (int i=0;i<count;i++){
            //获取此项属性的ID
            int index=typedArray.getIndex(i);
            switch (index){
                case R.styleable.VerifyCode_codeTextSize:
                    // 默认设置为16sp，TypeValue类 px转sp 一个转换类
                    mCodeTextSize =typedArray.getDimensionPixelSize(index,(int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.VerifyCode_codeBackground:
                    mCodeBackground=typedArray.getColor(index, Color.WHITE);
                    break;
                case R.styleable.VerifyCode_codeLength:
                    mCodeLength=typedArray.getInteger(index,4);
                    break;
                case R.styleable.VerifyCode_isContainChar:
                    isContainChar=typedArray.getBoolean(index,false);
                    break;
                case R.styleable.VerifyCode_pointNum:
                    mPointNum=typedArray.getInteger(index,100);
                    break;
                case R.styleable.VerifyCode_linNum:
                    mLineNum=typedArray.getInteger(index,3);
                    break;
            }
        }
        //Recycles the TypedArray, to be re-used by a later caller
        //官方解释：回收TypedArray 以便后面的使用者重用
        typedArray.recycle();
    }

    /**
     * 初始化数据
     */
    private void initData(){
        mCodeText=getValidationCode(mCodeLength,isContainChar);
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mBound=new Rect();
        //计算文字所在矩形，可以得到宽高
        mPaint.getTextBounds(mCodeText,0, mCodeText.length(),mBound);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取控件宽高的显示模式
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        //获取宽高的尺寸值  固定值的宽度
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);
        //设置宽高默认为建议的最小宽高
        int width= getDefaultSize(getSuggestedMinimumWidth(),widthMeasureSpec) ;
        int height=getDefaultSize(getSuggestedMinimumHeight(),heightMeasureSpec);

//        MeasureSpec父布局传递给后代的布局要求 包含 确定大小和三种模式
//        EXACTLY：一般是设置了明确的值或者是MATCH_PARENT
//        AT_MOST：表示子布局限制在一个最大值内，一般为WARP_CONTENT
//        UNSPECIFIED：表示子布局想要多大就多大，很少使用
        if (widthMode==MeasureSpec.EXACTLY){
            width=widthSize;
        }else{
            mPaint.setTextSize(mCodeTextSize);
            mPaint.getTextBounds(mCodeText,0,mCodeText.length(),mBound);
            float textWidth=mBound.width();
            int tempWidth=(int)(getPaddingLeft()+textWidth+getPaddingRight());
            width=tempWidth;
        }
        if (heightMode == MeasureSpec.EXACTLY)
        {
            height = heightSize;
        } else
        {
            mPaint.setTextSize(mCodeTextSize);
            mPaint.getTextBounds(mCodeText, 0, mCodeText.length(), mBound);
            float textHeight = mBound.height();
            int tempHeight = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = tempHeight;
        }
        //设置测量的宽高
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mWidth=getWidth();
        mHeight=getHeight();

        if (bitmap==null){
            bitmap=createBitmapValidate();
        }
        canvas.drawBitmap(bitmap,0,0,mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                refresh();
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 创建图片验证码
     * @return
     */
    private Bitmap createBitmapValidate(){
        if(bitmap != null && !bitmap.isRecycled()){
            //回收并且置为null
            bitmap.recycle();
            bitmap = null;
        }
        //创建图片
        Bitmap sourceBitmap=Bitmap.createBitmap(mWidth,mHeight, Bitmap.Config.ARGB_8888);
        //创建画布
        Canvas canvas=new Canvas(sourceBitmap);
        //画上背景颜色
        canvas.drawColor(mCodeBackground);
        //初始化文字画笔
        mPaint.setStrokeWidth(3f);
        mPaint.setTextSize(mCodeTextSize);
        //测量验证码字符串显示的宽度值
        float textWidth=mPaint.measureText(mCodeText);
        //画上验证码
        int length = mCodeText.length();
        //计算一个字符的所占位置
        float charLength = textWidth / length;
        for (int i = 1; i <= length; i++) {
            int offsetDegree = mRandom.nextInt(15);
            //这里只会产生0和1，如果是1那么正旋转正角度，否则旋转负角度
            offsetDegree = mRandom.nextInt(2) == 1 ? offsetDegree : -offsetDegree;
            //用来保存Canvas的状态。save之后，可以调用Canvas的平移、放缩、旋转、错切、裁剪等操作。
            canvas.save();
            //设置旋转
            canvas.rotate(offsetDegree, mWidth / 2, mHeight / 2);
            //给画笔设置随机颜色
            mPaint.setARGB(255, mRandom.nextInt(200) + 20, mRandom.nextInt(200) + 20,
                    mRandom.nextInt(200) + 20);
            //设置字体的绘制位置
            canvas.drawText(String.valueOf(mCodeText.charAt(i - 1)), (i - 1) * charLength+5,
                    mHeight * 4 / 5f, mPaint);
            //用来恢复Canvas之前保存的状态。防止save后对Canvas执行的操作对后续的绘制有影响。
            canvas.restore();
        }

        //重新设置画笔
        mPaint.setARGB(255, mRandom.nextInt(200) + 20, mRandom.nextInt(200) + 20,
                mRandom.nextInt(200) + 20);
        mPaint.setStrokeWidth(1);
        //产生干扰效果1 －－ 干扰点
        for (int i = 0; i < mPointNum; i++) {
            drawPoint(canvas, mPaint);
        }
        //生成干扰效果2 －－ 干扰线
        for (int i = 0; i < mLineNum; i++) {
            drawLine(canvas, mPaint);
        }
        return sourceBitmap;
    }

    /**
     * 生成干扰点
     */
    private static void drawPoint(Canvas canvas, Paint paint) {
        PointF pointF = new PointF(mRandom.nextInt(mWidth) + 10, mRandom.nextInt(mHeight) + 10);
        canvas.drawPoint(pointF.x, pointF.y, paint);
    }

    /**
     * 生成干扰线
     */
    private static void drawLine(Canvas canvas, Paint paint) {
        int startX = mRandom.nextInt(mWidth);
        int startY = mRandom.nextInt(mHeight);
        int endX = mRandom.nextInt(mWidth);
        int endY = mRandom.nextInt(mHeight);
        canvas.drawLine(startX, startY, endX, endY, paint);
    }

    /**
     * 获取验证码
     *
     * @param length 生成随机数的长度
     * @param contains 是否包含字符串
     * @return
     */
    public String getValidationCode(int length,boolean contains) {
        String val = "";
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            if (contains){
                //字母或数字
                String code = random.nextInt(2) % 2 == 0 ? "char" : "num";
                //字符串
                if ("char".equalsIgnoreCase(code)) {
                    //大写或小写字母
                    int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    val += (char) (choice + random.nextInt(26));
                } else if ("num".equalsIgnoreCase(code)) {
                    val += String.valueOf(random.nextInt(10));
                }
            }else{
                val += String.valueOf(random.nextInt(10));
            }

        }
        return val;
    }

    /**
     *判断验证码是否一致 忽略大小写
     */
    public Boolean isEqualsIgnoreCase(String CodeString) {
        return mCodeText.equalsIgnoreCase(CodeString);
    }

    /**
     * 判断验证码是否一致 不忽略大小写
     */
    public Boolean isEquals(String CodeString) {
        return mCodeText.equals(CodeString);
    }

    /**
     * 提供外部调用的刷新方法
     */
    public void refresh(){
        mCodeText= getValidationCode(mCodeLength,isContainChar);
        bitmap = createBitmapValidate();
        invalidate();
    }
}
