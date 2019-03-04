package com.wook.achitecturepatternsample.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wook.achitecturepatternsample.R;
import com.wook.achitecturepatternsample.databinding.ActivityMvvmBinding;
import com.wook.achitecturepatternsample.mvvm.viewmodel.MvvmViewModel;

public class MvvmActivity extends AppCompatActivity {
    private MvvmViewModel viewModel = new MvvmViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        binding.setModel(viewModel);
        viewModel.run();
    }

    @Override
    protected void onDestroy() {
        viewModel.release();
        super.onDestroy();
    }
}