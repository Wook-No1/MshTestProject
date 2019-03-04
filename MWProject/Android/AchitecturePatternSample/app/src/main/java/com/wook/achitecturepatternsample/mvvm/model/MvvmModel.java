package com.wook.achitecturepatternsample.mvvm.model;

public class MvvmModel {
    private static MvvmModel INSTANCE;
    private String displayName;
    private String displaySubName;

    public static MvvmModel getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MvvmModel();
        }
        return INSTANCE;
    }


    public String getDisplayName() {
        return displayName;
    }

    public String getDisplaySubName() {
        return displaySubName;
    }

    public void getData(IDataCallback<MvvmModel> dataCallback) {
        // api request
        // response api
        displayName = "response displayName";
        displaySubName = "response displaySubName";
        dataCallback.getResponse(this);
    }
}
