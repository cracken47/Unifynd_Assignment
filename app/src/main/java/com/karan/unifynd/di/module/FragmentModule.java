package com.karan.unifynd.di.module;



import com.karan.unifynd.fragments.FragmentFirst;
import com.karan.unifynd.fragments.FragmentSecond;
import com.karan.unifynd.fragments.FragmentThird;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract FragmentFirst fragmentFirst();

    @ContributesAndroidInjector
    abstract FragmentSecond fragmentSecond();

    @ContributesAndroidInjector
    abstract FragmentThird fragmentThird();



}
