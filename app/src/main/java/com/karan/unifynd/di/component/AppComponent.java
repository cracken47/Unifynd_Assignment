package com.karan.unifynd.di.component;


import android.app.Application;


import com.karan.unifynd.App;
import com.karan.unifynd.di.module.ActivityModule;
import com.karan.unifynd.di.module.AppModule;
import com.karan.unifynd.di.module.FragmentModule;
import com.karan.unifynd.di.module.NetworkModule;
import com.karan.unifynd.di.module.ViewModelModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityModule.class, FragmentModule.class, NetworkModule.class, ViewModelModule.class})
public interface AppComponent {

    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}

