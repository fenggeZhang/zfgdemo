package com.zfg.test.weigt.helper;

import android.annotation.SuppressLint;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;

import java.lang.reflect.Field;

/**
 * Created by zfg on 2018/8/21
 */
public class BottomNavigationViewHelper {


    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView bottomNavigationView) {
        BottomNavigationMenuView view = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
        try {
            Field shiftingMode = view.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(view, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < view.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) view.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
