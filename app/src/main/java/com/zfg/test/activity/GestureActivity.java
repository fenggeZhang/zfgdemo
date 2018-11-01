package com.zfg.test.activity;

import android.view.MotionEvent;

import com.github.nisrulz.sensey.MovementDetector;
import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;
import com.github.nisrulz.sensey.TouchTypeDetector;
import com.zfg.test.R;
import com.zfg.test.activity.base.BaseActivity;
import com.zfg.test.utils.LogUtil;

/**
 * 设备手势
 */
public class GestureActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gesture;
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected void initData() {
        Sensey.getInstance().init(mContext);
        Sensey.getInstance().startShakeDetection(shakeListener);//震动
        Sensey.getInstance().startMovementDetection(movementListener);//移动
        Sensey.getInstance().startTouchTypeDetection(this, touchTypListener);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected int getTitleStringId() {
        return R.string.test_device_gesture;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Sensey.getInstance().stop();
    }

    //震动检测
    ShakeDetector.ShakeListener shakeListener = new ShakeDetector.ShakeListener() {
        @Override
        public void onShakeDetected() {
            // Shake detected, do something
            LogUtil.e("onShakeDetected");
        }

        @Override
        public void onShakeStopped() {
            // Shake stopped, do something
            LogUtil.e("onShakeStopped");
        }

    };
    //    移动探测 不是手指滑动，是设备移动
    MovementDetector.MovementListener movementListener = new MovementDetector.MovementListener() {
        @Override
        public void onMovement() {
            // Movement detected, do something
            showToast("设备移动");
            LogUtil.e("move");
        }

        @Override
        public void onStationary() {
            // Movement stopped, do something
            showToast("设备停止移动");
            LogUtil.e("stop_move");
        }

    };

    TouchTypeDetector.TouchTypListener touchTypListener = new TouchTypeDetector.TouchTypListener() {
        @Override
        public void onTwoFingerSingleTap() {
            // Two fingers single tap
            showToast("两个手指点击");
            LogUtil.e("onTwoFingerSingleTap");
        }

        @Override
        public void onThreeFingerSingleTap() {
            // Three fingers single tap
            showToast("三个手指点击");
            LogUtil.e("onThreeFingerSingleTap");
        }

        @Override
        public void onDoubleTap() {
            // Double tap
            showToast("双击");
            LogUtil.e("onDoubleTap");
        }

        @Override
        public void onScroll(int scrollDirection) {
            switch (scrollDirection) {
                case TouchTypeDetector.SCROLL_DIR_UP:
                    // Scrolling Up
                    LogUtil.e("Scrolling Up");
                    showToast("开始滚动");
                    break;
                case TouchTypeDetector.SCROLL_DIR_DOWN:
                    // Scrolling Down
                    LogUtil.e("Scrolling Down");
                    showToast("停止滚动");
                    break;
                case TouchTypeDetector.SCROLL_DIR_LEFT:
                    // Scrolling Left
                    LogUtil.e("Scrolling Left");
                    showToast("左边滚动");
                    break;
                case TouchTypeDetector.SCROLL_DIR_RIGHT:
                    // Scrolling Right
                    LogUtil.e("Scrolling Right");
                    showToast("右边滚动");
                    break;
                default:
                    // Do nothing
                    LogUtil.e("Do nothing");
                    break;
            }
        }

        @Override
        public void onSingleTap() {
            // Single tap
            LogUtil.e("Single tap");
            showToast("单击");
        }

        @Override
        public void onSwipe(int swipeDirection) {
            switch (swipeDirection) {
                case TouchTypeDetector.SWIPE_DIR_UP:
                    // Swipe Up
                    LogUtil.e("Swipe Up");
                    showToast("Swipe Up");
                    break;
                case TouchTypeDetector.SWIPE_DIR_DOWN:
                    // Swipe Down
                    LogUtil.e("Swipe Down");
                    showToast("Swipe Down");
                    break;
                case TouchTypeDetector.SWIPE_DIR_LEFT:
                    // Swipe Left
                    LogUtil.e("Swipe Left");
                    showToast("Swipe Left");
                    break;
                case TouchTypeDetector.SWIPE_DIR_RIGHT:
                    // Swipe Right
                    LogUtil.e("Swipe Right");
                    showToast("Swipe Right");
                    break;
                default:
                    //do nothing
                    break;
            }
        }

        @Override
        public void onLongPress() {
            // Long press
            LogUtil.e("Long press");
            showToast("长按");
        }
    };

    /**
     * 切记这个要重写
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // Setup onTouchEvent for detecting type of touch gesture
        Sensey.getInstance().setupDispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }
}
