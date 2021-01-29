package com.karan.unifynd.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.karan.unifynd.database.converter.TypeConverter;
import com.karan.unifynd.models.HipHop;


@Database(entities = {HipHop.class}, version = 9, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile MyDatabase INSTANCE;

    //  ---Dao---



}
