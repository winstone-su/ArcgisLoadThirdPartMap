package com.carl.map.apps.samples.utils;

import com.carl.map.apps.samples.AppConfig;
import com.esri.arcgisruntime.layers.WebTiledLayer;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @ClassName ThirdMapUtils
 * @Description 地图加载类，支持高德、天地图
 * @Author Carl
 * @Date 2021/9/28 10:01 上午
 * @Version 1.0
 */
public class ThirdMapUtils {

    public enum Amap_MapType {
        AMAP_VECTOR,
        AMAP_IMAGE,
        AMAP_ANO
    }
    public enum TDT_MapType {
        TDT_IMG,
        TDT_TER,
        TDT_ANO
    }
    public enum Google_MapType {
        GOOGLE_VECTOR,        //标注电子地图
        GOOGLE_IMAGE,        //影像地图
        GOOGLE_ROAD        //道路标注图层
    }

    private static final List<String> aMapSubDomain = Arrays.asList("wprd01", "wprd02", "wprd03", "wprd04");
    private static final List<String> tdtSubDomain = Arrays.asList("t0", "t1", "t2", "t3", "t4", "t5", "t6", "t7");
    private static final List<String> googleSubDomain = Arrays.asList("mt0", "mt1", "mt2", "mt3", "mt4","m5", "m6", "m7","m8","m9","m10","m11",
            "m12","m13","m14","m15","m16","m17","m18","m19");
    /**
     *
     * @param mapType 天地图地图类型
     * @return WebTiledLayer
     */
    public static WebTiledLayer CreateTDTTiledLayer(TDT_MapType mapType) {
        WebTiledLayer webTiledLayer;
        String layerURL;
        switch (mapType) {
            case TDT_IMG:
                layerURL = AppConfig.Layer.TDT_IMG;
                break;
            case TDT_TER:
                layerURL = AppConfig.Layer.TDT_TER;
                break;
            case TDT_ANO:
                layerURL = AppConfig.Layer.TDT_ANO;
                break;
            default:
                layerURL = AppConfig.Layer.TDT_TER_ANO;
                break;
        }
        layerURL = String.format(Locale.CHINA, "%s%s", layerURL, AppConfig.TDT_KEY);
        webTiledLayer = new WebTiledLayer(
                layerURL,
                tdtSubDomain
        );
        webTiledLayer.loadAsync();

        return webTiledLayer;
    }

    /**
     *
     * @param mapType 高德地图类型
     * @return WebTiledLayer
     */
    public static WebTiledLayer CreateAMapTiledLayer(Amap_MapType mapType) {
        WebTiledLayer webTiledLayer;
        String layerURL;
        switch (mapType) {
            case AMAP_VECTOR:
                layerURL = AppConfig.Layer.AMAP_VECTOR;
                break;
            case AMAP_IMAGE:
                layerURL = AppConfig.Layer.AMAP_IMAGE;
                break;
            case AMAP_ANO:
                layerURL = AppConfig.Layer.AMAP_ANO;
                break;
            default:
                layerURL = AppConfig.Layer.AMAP_ANO_IMG;
                break;
        }

        webTiledLayer = new WebTiledLayer(
                layerURL,
                aMapSubDomain
        );
        webTiledLayer.loadAsync();

        return webTiledLayer;
    }

    /**
     * 目前Google地图大陆已经无法访问
     * @param mapType Google地图类型
     * @return WebTiledLayer
     */
    @Deprecated
    public static WebTiledLayer CreateGoogleTiledLayer(Google_MapType mapType){
        WebTiledLayer webTiledLayer;
        String layerURL;
        switch (mapType) {
            case GOOGLE_ROAD:
                layerURL = AppConfig.Layer.GOOGLE_ROAD;
                break;
            case GOOGLE_VECTOR:
                layerURL = AppConfig.Layer.GOOGLE_VECTOR;
                break;
            case GOOGLE_IMAGE:
            default:
                layerURL = AppConfig.Layer.GOOGLE_IMAGE;
                break;
        }
        webTiledLayer = new WebTiledLayer(layerURL, googleSubDomain);
        webTiledLayer.loadAsync();

        return webTiledLayer;
    }
}
