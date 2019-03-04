package com.wook.achitecturepatternsample.mvp.model;

public class MvpModel {
    private static MvpModel INSTANCE;
    private String displayName;
    private String displaySubName;

    public static MvpModel getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MvpModel();
        }
        return INSTANCE;
    }


    public String getDisplayName() {
        return displayName;
    }

    public String getDisplaySubName() {
        return displaySubName;
    }

    public void getData(IDataCallback dataCallback) {
        // api request
        // response api
        displayName = "response displayName";
        displaySubName = "response displaySubName";
        dataCallback.getResponse(this);
    }
}
