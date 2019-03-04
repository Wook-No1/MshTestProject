package com.wook.achitecturepatternsample.mvc.model;

public class MvcModel {
    private String displayName;
    private String displaySubName;

    public MvcModel(String displayName, String displaySubName){
        this.displayName = displayName;
        this.displaySubName = displaySubName;
    }


    public String getDisplayName() {
        return displayName;
    }

    public String getDisplaySubName() {
        return displaySubName;
    }
}
