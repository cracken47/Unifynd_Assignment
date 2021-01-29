package com.karan.unifynd.di.module;



import com.karan.unifynd.activities.BaseActivity;
import com.karan.unifynd.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector()
    abstract BaseActivity baseActivity();


}
