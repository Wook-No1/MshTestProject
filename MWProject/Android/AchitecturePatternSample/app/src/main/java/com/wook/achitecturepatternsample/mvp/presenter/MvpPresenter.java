package com.wook.achitecturepatternsample.mvp.presenter;

import com.wook.achitecturepatternsample.mvp.Constract;
import com.wook.achitecturepatternsample.mvp.model.IDataCallback;
import com.wook.achitecturepatternsample.mvp.model.MvpModel;

public class MvpPresenter implements Constract.Presenter {
    private Constract.View view;

    @Override
    public void attachView(Constract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        MvpModel mvpModel = new MvpModel();
        mvpModel.getData(new IDataCallback<MvpModel>() {
            @Override
            public void getResponse(MvpModel model) {
                viewUpdate(model);
            }

            @Override
            public void failure() {
                view.failView("데이터 로드 실패");
            }
        });
    }

    private void viewUpdate(MvpModel model) {
        view.updateView(model.getDisplayName(), model.getDisplaySubName());
    }
}
