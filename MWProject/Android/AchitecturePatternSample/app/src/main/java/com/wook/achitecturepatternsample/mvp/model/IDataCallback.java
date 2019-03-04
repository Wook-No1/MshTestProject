package com.wook.achitecturepatternsample.mvp.model;

public interface IDataCallback<T>{
    void getResponse(T object);
    void failure();
}
