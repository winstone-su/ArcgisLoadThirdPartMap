package com.carl.map.apps.samples;

/**
 * @ClassName AppConfig
 * @Description TODO
 * @Author Carl
 * @Date 2021/9/28 10:20 上午
 * @Version 1.0
 */
public class AppConfig {
    public static final String TDT_KEY = "ba4c3a45bcaf0fe4698a548992fd57f5";
    public static class Layer{
        //高德影像
        public static final String AMAP_IMAGE = "http://{subDomain}.is.autonavi.com/appmaptile?style=6&lang=zh_cn&size=1&scl=1&scale=1&x={col}&y={row}&z={level}";
        //
        public static final String AMAP_VECTOR = "http://{subDomain}.is.autonavi.com/appmaptile?style=7&lang=zh_cn&size=1&scl=1&scale=1&x={col}&y={row}&z={level}";
        //高德注记
        public static final String AMAP_ANO = "http://{subDomain}.is.autonavi.com/appmaptile?style=8&ltype=4&lang=zh_cn&size=1&scl=1&scale=1&x={col}&y={row}&z={level}";
        //
        public static final String AMAP_ANO_IMG = "http://{subDomain}.is.autonavi.com/appmaptile?style=8&lang=zh_cn&size=1&scl=1&scale=1&x={col}&y={row}&z={level}";
        //TODO 更多底图类型参考 天地图 http://lbs.tianditu.gov.cn/server/MapService.html
        //天地图球面墨卡托投影影像底图
        public static final String TDT_IMG = "http://{subDomain}.tianditu.gov.cn/img_w/wmts?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=img&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles&TILEMATRIX={level}&TILEROW={row}&TILECOL={col}&tk=";
        //天地图球面墨卡托投影矢量注记
        public static final String TDT_ANO = "http://{subDomain}.tianditu.gov.cn/cva_w/wmts?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=cva&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles&TILEMATRIX={level}&TILEROW={row}&TILECOL={col}&tk=";
        //天地图球面墨卡托投影影像注记
        public static final String TDT_TER_ANO = "http://{subDomain}.tianditu.gov.cn/cia_w/wmts?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=cia&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles&TILEMATRIX={level}&TILEROW={row}&TILECOL={col}&tk=";
        //天地图球面墨卡托投影地形晕渲
        public static final String TDT_TER = "http://{subDomain}.tianditu.gov.cn/ter_w/wmts?SERVICE=WMTS&VERSION=1.0.0&REQUEST=GetTile&LAYER=ter&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles&TILEMATRIX={level}&TILEROW={row}&TILECOL={col}&tk=";
        //
        public static final String GOOGLE_VECTOR = "http://{subDomain}.google.cn/vt/lyrs=m@225000000&hl=zh-CN&gl=CN&src=app&s=G&x={col}&y={row}&z={level}";
        //
        public static final String GOOGLE_ROAD = "http://{subDomain}.google.cn/vt/imgtp=png&hl=zh-CN&gl=CN&src=app&s=G&x={col}&y={row}&z={level}";
        //
        public static final String GOOGLE_IMAGE = "http://{subDomain}.google.cn/maps/vt/lyrs=s@40717&hl=zh-CN&gl=CN&src=app&s=G&x={col}&y={row}&z={level}";
    }
}
