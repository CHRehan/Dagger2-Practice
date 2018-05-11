package com.rehan.dagger2;

import android.app.Application;

import com.rehan.dagger2.component.BasicComponent;
import com.rehan.dagger2.component.DaggerBasicComponent;
import com.rehan.dagger2.module.AppModule;

/**
 * Created by rehan on 05/11/2018.
 */

public class MyApp extends Application {
    private static MyApp app;
    private BasicComponent basicComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        basicComponent = DaggerBasicComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();
    }

    public static MyApp app() {
        return app;
    }

    public BasicComponent basicComponent() {
        return basicComponent;
    }
}
