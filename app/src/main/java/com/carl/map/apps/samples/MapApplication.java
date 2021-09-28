package com.carl.map.apps.samples;

import android.app.Application;

import com.esri.arcgisruntime.ArcGISRuntimeEnvironment;
import com.esri.arcgisruntime.io.RequestConfiguration;

/**
 * @ClassName MapApplication
 * @Description TODO
 * @Author Carl
 * @Date 2021/9/28 9:51 上午
 * @Version 1.0
 */
public class MapApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ArcGISRuntimeEnvironment.setApiKey("AAPKa03d099fda19491d927fd67436ac4797ObDB_wJESIzbsFQo7XssKCysNBdHHesNHm8qi587HsZeIXj1qJJPgx0L-RSkINtu");
        ArcGISRuntimeEnvironment.setLicense("runtimelite,1000,rud9978704000,none,TRB3LNBHPFMB4P7EJ046");

        RequestConfiguration requestConfiguration = new RequestConfiguration();
        requestConfiguration.getHeaders().put("referer", "http://www.arcgis.com");

    }
}
