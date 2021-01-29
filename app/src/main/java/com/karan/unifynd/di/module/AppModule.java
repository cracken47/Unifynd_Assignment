package com.karan.unifynd.di.module;

import android.app.Application;

import androidx.room.Room;


import com.karan.unifynd.App;
import com.karan.unifynd.database.MyDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    App provideApp(Application application) {
        return (App) application;
    }

    @Provides
    @Singleton
    MyDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                MyDatabase.class, "UnifyndDatabase.db")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }





}
