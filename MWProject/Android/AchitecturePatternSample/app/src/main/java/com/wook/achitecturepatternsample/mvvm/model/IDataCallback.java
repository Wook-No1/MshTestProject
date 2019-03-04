package com.wook.achitecturepatternsample.mvvm.model;

public interface IDataCallback<T>{
    void getResponse(T object);
    void failure();
}
