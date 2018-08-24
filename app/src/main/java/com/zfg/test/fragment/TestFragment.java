package com.zfg.test.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;

import com.zfg.test.R;

import skin.support.SkinCompatManager;

/**
 * Created by zfg on 2018/8/9
 */

public class TestFragment extends PreferenceFragment {
    SwitchPreference testPrefer;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_preferences);
        testPrefer = (SwitchPreference) findPreference("BuildInNightMode");
        testPrefer.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
//                应用内换肤
                boolean boolValue = (boolean) newValue;
                if (boolValue) {
                    SkinCompatManager.getInstance().loadSkin("night", null, SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                } else {
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                }
                return true;
            }
        });
    }
}
