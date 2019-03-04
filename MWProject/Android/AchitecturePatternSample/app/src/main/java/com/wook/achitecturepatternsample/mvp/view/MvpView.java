package com.wook.achitecturepatternsample.mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wook.achitecturepatternsample.R;

public class MvpView extends RelativeLayout {
    private Context mContext;
    private LayoutInflater mLayoutinflater;

    private TextView mTextDisplay;
    private TextView mTextSubDisplay;
    private TextView mTextError;

    public MvpView(Context context) {
        super(context);
        mContext = context;
        initLayout();
    }

    public MvpView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initLayout();
    }

    public MvpView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initLayout();
    }

    private void initLayout() {
        mLayoutinflater = LayoutInflater.from(mContext);
        mLayoutinflater.inflate(R.layout.view_mvp, this);
        mTextDisplay = findViewById(R.id.text_display);
        mTextSubDisplay = findViewById(R.id.text_sub_display);
        mTextError = findViewById(R.id.text_error_msg);
    }

    public void updateDisplay(String display) {
        mTextDisplay.setText(display);
    }

    public void updateSubDisplay(String subDisplay) {
        mTextSubDisplay.setText(subDisplay);
    }

    public void fail(String errorMsg) {
        mTextError.setVisibility(View.VISIBLE);
        mTextDisplay.setVisibility(View.GONE);
        mTextSubDisplay.setVisibility(View.GONE);
        mTextError.setText(errorMsg);
    }
}
