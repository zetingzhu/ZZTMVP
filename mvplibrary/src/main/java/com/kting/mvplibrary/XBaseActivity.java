package com.kting.mvplibrary;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.kting.mvplibrary.dialog.MyLogingDialog;
import com.kting.mvplibrary.xpersenter.XBasePresenter;
import com.kting.mvplibrary.xview.XBaseView;


/**
 * Created by zeting
 * Date 19/3/13.
 */

public abstract class XBaseActivity<V extends XBaseView, T extends XBasePresenter<V>>  extends Activity implements XBaseView{
    private final static String TAG = XBaseActivity.class.getSimpleName() ;

    // 表层引用
    public T mPresenter ;
    private MyLogingDialog mLogingDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = CreatePresenter() ;
        mPresenter.attachView((V) this);
        mLogingDialog = new MyLogingDialog(this);
    }

    /**
     * 设置presenter
     * @return
     */
    protected abstract T CreatePresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void showLoading() {
        Log.d(TAG , "显示对话框");
        mLogingDialog.show();
    }

    @Override
    public void hideLoading() {
        Log.d(TAG , "隐藏对话框");
        mLogingDialog.dismiss();
    }

    @Override
    public void showError(String msg) {
        Log.d(TAG , "显示错误" + msg);
    }

}
