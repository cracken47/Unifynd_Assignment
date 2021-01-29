package com.karan.unifynd.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import com.karan.unifynd.viewmodels.FactoryViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
abstract public class ViewModelModule {


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);



}
