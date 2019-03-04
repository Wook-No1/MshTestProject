package com.wook.achitecturepatternsample.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wook.achitecturepatternsample.R;
import com.wook.achitecturepatternsample.mvp.presenter.MvpPresenter;
import com.wook.achitecturepatternsample.mvp.view.MvpView;

public class MvpActivity extends AppCompatActivity implements Constract.View {
    private Constract.Presenter mvpPresenter;
    private MvpView mvpView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        initLayout();

        mvpPresenter = new MvpPresenter();
        mvpPresenter.attachView(this);
        mvpPresenter.loadData();
    }

    private void initLayout() {
        mvpView = findViewById(R.id.view_mvp);
        mvpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mvpPresenter.loadData();
            }
        });
    }

    @Override
    public void updateView(String display, String subDisplay) {
        mvpView.updateDisplay(display);
        mvpView.updateSubDisplay(subDisplay);
    }

    @Override
    public void failView(String msg) {
        mvpView.fail(msg);
    }

}
