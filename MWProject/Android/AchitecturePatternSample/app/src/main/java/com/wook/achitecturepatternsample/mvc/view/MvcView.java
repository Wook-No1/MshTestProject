package com.wook.achitecturepatternsample.mvc.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wook.achitecturepatternsample.R;
import com.wook.achitecturepatternsample.mvc.model.MvcModel;

public class MvcView extends RelativeLayout {
    private Context mContext;
    private LayoutInflater mLayoutinflater;

    private TextView mTextDisplay;
    private TextView mTextSubDisplay;

    public MvcView(Context context) {
        super(context);
        mContext = context;
        initLayout();
    }

    public MvcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initLayout();
    }

    public MvcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initLayout();
    }

    private void initLayout() {
        mLayoutinflater = LayoutInflater.from(mContext);
        mLayoutinflater.inflate(R.layout.view_mvc, this);
        mTextDisplay = findViewById(R.id.text_display);
        mTextSubDisplay = findViewById(R.id.text_sub_display);
    }

    public void updateView(MvcModel mvcModel) {
        mTextDisplay.setText(mvcModel.getDisplayName());
        mTextSubDisplay.setText(mvcModel.getDisplaySubName());
    }
}
