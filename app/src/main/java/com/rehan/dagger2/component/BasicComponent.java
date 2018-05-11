package com.rehan.dagger2.component;

import javax.inject.Singleton;

import dagger.Component;
import com.rehan.dagger2.module.AppModule;
import com.rehan.dagger2.ui.MainActivity;

/**
 * Created by rehan on 05/11/2018.
 */
@Singleton
@Component (modules = {AppModule.class})
public interface BasicComponent {
    void inject(MainActivity activity);
}
