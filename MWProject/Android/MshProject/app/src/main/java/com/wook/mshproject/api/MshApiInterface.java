package com.wook.mshproject.api;

import com.wook.mshproject.model.UserInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MshApiInterface {
    @GET("test.php")
    Call<List<UserInfo>> getApiTest();

    @GET("test.php")
    Call<UserInfo> getApiTest1();

    @GET("test.php")
    Call<UserInfo> getApiTest2();

    @GET("test.php")
    Call<UserInfo> getApiTest3();

    @GET("test.php")
    Call<UserInfo> getApiTest4();

    @GET("test.php")
    Call<UserInfo> getApiTest5();

}
