package com.kting.mvplibrary.xview;

/**
 * Created by zeting
 * Date 19/3/13.
 */

public interface XBaseView {
    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading();
    /**
     * 显示错误信息
     *
     * @param msg
     */
    void showError(String msg);

}
