package com.kting.mvplibrary.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import com.kting.mvplibrary.R;
import com.kting.mvplibrary.widget.LVFinePoiStar;


/**
 * 加载对话框
 * Created by zeting
 * Date 19/3/14.
 */
public class MyLogingDialog extends Dialog {
    /**
     * 对话框 根视图
     */
    protected View rootView;
    private LVFinePoiStar mLVFinePoiStar ;

    public MyLogingDialog(Context context) {
        super(context);
        initDialog();
    }

    protected MyLogingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initDialog();
    }

    public MyLogingDialog(Context context, int themeResId) {
        super(context, themeResId);
        initDialog();
    }

    private void initDialog() {
        rootView = LayoutInflater.from(getContext()).inflate( R.layout.my_dialog_loading , null);
        setContentView(rootView);
        mLVFinePoiStar = (LVFinePoiStar) findViewById(R.id.star_loading);
        mLVFinePoiStar.setViewColor(Color.BLACK);
        mLVFinePoiStar.setCircleColor(Color.YELLOW);
        // 去掉背景白色背景
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        mLVFinePoiStar.stopAnim();
    }

    @Override
    public void show() {
        super.show();
        mLVFinePoiStar.setDrawPath(true);
        mLVFinePoiStar.startAnim(3500);
    }
}
