package com.zfg.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.zfg.test.R;
import com.zfg.test.utils.LogUtil;
import com.zfg.test.utils.ToastUtils;
import com.zfg.test.weigt.EditLayout;

public class MapSearchActivity extends Activity  {

//    PoiSearch poiSearch;
    EditLayout mEditLayout;
    MapView mMapView;
//    PoiSearch.Query query;

    private CustomMapStyleOptions mapStyleOptions = new CustomMapStyleOptions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_search);
        //获取地图控件引用
        mMapView = findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
        mEditLayout = findViewById(R.id.my_edit_layout);
        //初始化地图控制器对象
        AMap aMap = null;
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        aMap.setMapType(AMap.MAP_TYPE_NORMAL);// 矢量地图模式
//        mapStyleOptions.setEnable(b);
//					mapStyleOptions.setStyleId("your id");
        aMap.setCustomMapStyle(mapStyleOptions);

//        initData();
    }


    /*protected void initData() {
        query = new PoiSearch.Query("万达", "", "330100");
        LogUtil.e(mEditLayout.getContent());
        //keyWord表示搜索字符串，
        //第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
        //cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
        query.setPageSize(10);// 设置每页最多返回多少条poiitem
        query.setPageNum(1);//设置查询页码

        poiSearch = new PoiSearch(this, query);
        poiSearch.setOnPoiSearchListener(this);
    }*/


    /*@Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        LogUtil.e(poiResult.toString());
        ToastUtils.show(this, "结果" + poiResult.getPois().toString());
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    public void goSearch(View view) {
        query = new PoiSearch.Query(mEditLayout.getContent(), "", "330100");
        poiSearch.setQuery(query);
        poiSearch.searchPOIAsyn();
    }*/

   /* public void back(View view) {
        finish();
    }*/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
}
