package com.carl.map.apps.samples;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.carl.map.apps.samples.databinding.ActivityMainBinding;
import com.carl.map.apps.samples.utils.ThirdMapUtils;
import com.carl.map.apps.samples.utils.ThirdMapUtils.Amap_MapType;
import com.carl.map.apps.samples.utils.ThirdMapUtils.TDT_MapType;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReference;
import com.esri.arcgisruntime.layers.WebTiledLayer;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public enum MapType {
        TYPE_AMAP,
        TYPE_TDT,
        TYPE_GOOGLE
    }

    private WebTiledLayer aMapImageLayer; //高德地图影像
    private WebTiledLayer aMapAnoLayer; //高德地图注记
    private WebTiledLayer tdtAnoLayer;  //天地图注记
    private WebTiledLayer tdtTerLayer;  //天地图地形图

    private MapView mapView;

    private ActivityMainBinding binding;
    private MapType currentType = MapType.TYPE_AMAP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
        initMap();
        changeBaseMap();
    }

    //初始化控件
    private void initViews(){
        mapView = binding.mapView;
        binding.btnAno.setOnClickListener(this);
        binding.btnChangeBasemap.setOnClickListener(this);
    }

    /**
     * 初始化地图
     */
    private void initMap() {

        mapView.setAttributionTextVisible(false);
        ArcGISMap map = new ArcGISMap(SpatialReference.create(3857));
//        map.setBackgroundColor(0x000000);
        map.setMaxScale(570);
        mapView.setMap(map);
        zoom(new Point(113.04368704055344, 27.6398518896398, SpatialReference.create(4326)), 3429032);

        aMapImageLayer = ThirdMapUtils.CreateAMapTiledLayer(Amap_MapType.AMAP_IMAGE);
        aMapAnoLayer = ThirdMapUtils.CreateAMapTiledLayer(Amap_MapType.AMAP_ANO);

        tdtTerLayer = ThirdMapUtils.CreateTDTTiledLayer(TDT_MapType.TDT_TER);
        tdtAnoLayer = ThirdMapUtils.CreateTDTTiledLayer(TDT_MapType.TDT_ANO);
    }

    public void zoom(com.esri.arcgisruntime.geometry.Point point, double scale) {

        if (point != null) {
            mapView.setViewpointCenterAsync(point, scale);
        }
    }


    /**
     * 更改地图类型
     */
    private void changeBaseMap(){
        Basemap basemap = mapView.getMap().getBasemap();
        basemap.getBaseLayers().clear();
        basemap.getReferenceLayers().clear();
        switch (currentType){
            case TYPE_AMAP:
                basemap.getBaseLayers().add(aMapImageLayer);
                basemap.getReferenceLayers().add(aMapAnoLayer);
                break;
            case TYPE_TDT:
                basemap.getBaseLayers().add(tdtTerLayer);
                basemap.getReferenceLayers().add(tdtAnoLayer);
                break;
            default:
                break;
        }
    }

    private void changeAnoStatus(){
        switch (currentType) {
            case TYPE_AMAP:
                aMapAnoLayer.setVisible(!aMapAnoLayer.isVisible());
                break;
            case TYPE_TDT:
                tdtAnoLayer.setVisible(!tdtAnoLayer.isVisible());
                break;
            default:
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_change_basemap:
                switch (currentType){
                    case TYPE_AMAP:
                        currentType = MapType.TYPE_TDT;
                        break;
                    case TYPE_TDT:
                        currentType = MapType.TYPE_AMAP;
                        break;
                    default:
                        break;
                }
                changeBaseMap();
                break;
            case R.id.btn_ano:
                changeAnoStatus();
                break;
        }
    }
}