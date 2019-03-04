package com.wook.achitecturepatternsample.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wook.achitecturepatternsample.R;
import com.wook.achitecturepatternsample.mvc.model.MvcModel;
import com.wook.achitecturepatternsample.mvc.view.MvcView;

public class MvcActivity extends AppCompatActivity {
    private MvcModel mMvcModel;
    private MvcView mMvcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        initLayout();
        bindData();
    }

    private void initLayout() {
        mMvcView = findViewById(R.id.view_mvc);
    }

    private void bindData() {
        //request Api
        //response Api
        mMvcModel = new MvcModel("update", "update1");

        updateView();
    }

    private void updateView() {
        mMvcView.updateView(mMvcModel);
    }
}
