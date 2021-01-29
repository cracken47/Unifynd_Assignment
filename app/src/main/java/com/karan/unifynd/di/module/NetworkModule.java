package com.karan.unifynd.di.module;


import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.karan.unifynd.App;
import com.karan.unifynd.utils.Constant;


import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder().setLenient().create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(App app) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(chain -> {
            HttpUrl newHttpurl = chain.request().url().newBuilder()
                    .addQueryParameter("cl", "Android")
                    .addQueryParameter("api", Integer.toString(Build.VERSION.SDK_INT))
                    .build();

            Request.Builder requestBuilder = chain.request().newBuilder().url(newHttpurl);


            Request request = requestBuilder.build();
            Log.i("Request", String.format("Request %s -> %s", request.method(), request.url().toString()));
            Response response = chain.proceed(request);
            Log.i("Request", String.format("Request %s <- %s %d", request.method(), request.url().toString(), response.code()));
            return response;
        }).connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS);


        return httpClient.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(Constant.BASE_URL)
                .client(okHttpClient)
                .build();
    }

}
