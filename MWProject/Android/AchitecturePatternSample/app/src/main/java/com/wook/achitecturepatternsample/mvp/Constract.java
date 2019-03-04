package com.wook.achitecturepatternsample.mvp;

public interface Constract {
    interface View {
        void updateView(String disPlay, String subDisplay);
        void failView(String msg);
        void toast(String msg);
    }

    interface Presenter {
        // Presenter method
        void attachView(View view);
        void loadData();
    }
}
