package com.zfg.test.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zfg.test.R;

import java.util.Scanner;

public class AcmTestActivity extends AppCompatActivity {
    private int[] mInts1 = new int[]{80, 88, 55, 74, 106, 1, 77, 12, 50};
    private int[] mInts2 = new int[]{80, 88, 55, 74, 106, 1, 77, 12, 50};
    private int[] mInts3 = new int[]{80, 88, 55, 74, 106, 1, 77, 12, 50};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acm_test);
        insertSort();
        selectSort();
        bubbSort();
//        minMultiple();
    }

    private void minMultiple() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = a * b;
        if (a < b) {
            int r = 0;
            r = a;
            a = b;
            b = r;
        }
        while (true) {
            int r = a % b;
            if (r == 0) {
                System.out.println("最小公倍数：" + c / b);
                break;
            } else {
                a = b;
                b = r;
            }
        }
    }

    private void bubbSort() {
//        冒泡排序
        int temp;
        for (int i = 0; i < mInts1.length; i++) {
            for (int j = i; j < mInts1.length - 1; j++) {
                Log.e("zfg", "冒泡i:" + i + " j:" + j);
                if (mInts1[j + 1] < mInts1[i]) {
                    Log.e("zfg", "冒泡交换");
                    temp = mInts1[j + 1];
                    mInts1[j + 1] = mInts1[i];
                    mInts1[i] = temp;
                }
            }
        }
        for (int i = 0; i < mInts1.length; i++) {
            Log.e("zfg", "冒泡排序:" + mInts1[i]);
        }
    }

    private void selectSort() {
//        选择排序
        int temp;
        for (int i = 0; i < mInts2.length; i++) {
            for (int j = i; j < mInts2.length - 1; j++) {
                Log.e("zfg", "选择i:" + i + " j:" + j);
                if (mInts2[j + 1] < mInts2[j]) {
                    Log.e("zfg" + i, "选择交换");
                    temp = mInts2[j + 1];
                    mInts2[j + 1] = mInts2[j];
                    mInts2[j] = temp;
                }
            }
        }
        for (int i = 0; i < mInts2.length; i++) {
            Log.e("zfg" + i, "选择排序结果：" + mInts2[i]);
        }
    }

    private void insertSort() {
//        插入排序
        int temp;
        for (int i = 0; i < mInts3.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                Log.e("zfg", "插入i:" + i + " j:" + j);
                if (mInts3[j + 1] < mInts3[j]) {
                    Log.e("zfg" + i, "插入交换");
                    temp = mInts3[j + 1];
                    mInts3[j + 1] = mInts3[j];
                    mInts3[j] = temp;
                }
            }
        }
        for (int i = 0; i < mInts3.length; i++) {
            Log.e("zfg", "插入排序结果：" + mInts3[i]);
        }
    }
}
