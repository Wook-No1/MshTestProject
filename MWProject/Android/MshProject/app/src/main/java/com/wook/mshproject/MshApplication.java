package com.wook.mshproject;

import android.app.Application;

import com.wook.mshproject.api.MshApiInterface;
import com.wook.mshproject.common.MshProperty;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MshApplication extends Application {
    static MshApplication instance;
    private MshApiInterface mshApiInterface;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setApiInfo();
    }

    public static MshApplication getInstance() {
        return instance;
    }

    private void setApiInfo() {
        this.mshApiInterface = new Retrofit.Builder().baseUrl(MshProperty.API_URL)
                .addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build().create(MshApiInterface.class);
    }

    public MshApiInterface getApiInfo() {
        return mshApiInterface;
    }
}
