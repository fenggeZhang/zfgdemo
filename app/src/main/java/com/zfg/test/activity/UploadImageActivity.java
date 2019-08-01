package com.zfg.test.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.yanzhenjie.nohttp.Binary;
import com.yanzhenjie.nohttp.BitmapBinary;
import com.yanzhenjie.nohttp.FileBinary;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.OnUploadListener;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.StringRequest;
import com.zfg.test.R;

import java.io.File;

public class UploadImageActivity extends AppCompatActivity {
    RequestQueue queue = NoHttp.newRequestQueue();
    String TAG = "ck";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
    }

    public void upload(View view) {
//        String url = "http://cloud.ppaa66.com/Interface/api/Upload/EquipmentUploadImage?token=a717268e2e4c4240ac04646632ef77facim4kyl3";
        File file = new File("/storage/emulated/0/PictureSelector/CameraImage/PictureSelector_20190524_144943.png");
        FileBinary binary1 = new FileBinary(file);
        binary1.setUploadListener(0, mOnUploadListener); // 设置一个上传监听器。
        Request<String> request = new StringRequest("", RequestMethod.POST);
        request.add("Photo", binary1);
        queue.add(0, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {
                Log.e(TAG, "onStart");
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                Log.e(TAG, "onSucceed" + response.toString());
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                Log.e(TAG, "onFailed" + response.toString());
            }

            @Override
            public void onFinish(int what) {
                Log.e(TAG, "onFinish");
            }
        });
    }

    private OnUploadListener mOnUploadListener = new OnUploadListener() {
        @Override
        public void onStart(int what) {// 文件开始上传。
            Log.e(TAG, "onStart");
        }

        @Override
        public void onCancel(int what) {// 文件的上传被取消时。
            Log.e(TAG, "onCancel");
        }

        @Override
        public void onProgress(int what, int progress) {// 文件的上传进度发生变化。
            Log.e(TAG, "onProgress");
        }

        @Override
        public void onFinish(int what) {// 文件上传完成
            Log.e(TAG, "onFinish");
        }

        @Override
        public void onError(int what, Exception exception) {// 文件上传发生错误。
            Log.e(TAG, "onError");
        }
    };
}
