package com.zfg.test.activity.anim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;

import com.zfg.test.R;

public class Anim3DActivity extends AppCompatActivity {
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim3_d);
        mButton = findViewById(R.id.btn);
        Rotate3DAnimation rotate3DAnimation = new Rotate3DAnimation(0.1f, 1.0f, 400.0f, 800.0f, 500.0f, true);

        //这个是设置动画时间的
        rotate3DAnimation.setDuration(2000);
        //动画执行完毕后是否停在结束时的角度上
        rotate3DAnimation.setFillAfter(false);
        rotate3DAnimation.setRepeatCount(Animation.INFINITE);//无限次循环
        rotate3DAnimation.setRepeatMode(Animation.RESTART);//循环
        //启动动画
        mButton.startAnimation(rotate3DAnimation);
    }

    public class Rotate3DAnimation extends Animation {
        private float mFromDegrees;
        private float mToDegrees;
        private float mCenterX;
        private float mCenterY;
        private float mDepthZ;
        private boolean mReverse;
        private Camera mCamera;

        private Rotate3DAnimation(float fromDegrees, float toDegrees, float centerX, float centerY, float depthZ, boolean reverse) {
            mFromDegrees = fromDegrees;
            mToDegrees = toDegrees;
            mCenterX = centerX;
            mCenterY = centerY;
            mDepthZ = depthZ;
            mReverse = reverse;
        }

        @Override
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            super.initialize(width, height, parentWidth, parentHeight);
            mCamera = new Camera();
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            float fromDegrees = mFromDegrees;
            float degrees = fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime);
            float centerX = mCenterX;
            float centerY = mCenterY;
            Camera camera = mCamera;
            Matrix matrix = t.getMatrix();
            camera.save();
            if (mReverse) {
                camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);
            } else {
                camera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime));
            }
            camera.rotateY(degrees);
            camera.getMatrix(matrix);
            camera.restore();

            matrix.preTranslate(-centerX, -centerY);
            matrix.postTranslate(centerX, centerY);
        }
    }
}
