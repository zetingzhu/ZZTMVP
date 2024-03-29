package com.kting.mvplibrary.xmodel;

import android.util.Log;

import com.google.gson.JsonParseException;
import com.kting.mvplibrary.xview.XBaseView;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

public abstract class BaseObserver<T> extends DisposableObserver<T> {
    private final static String TAG = BaseObserver.class.getSimpleName() ;
    /** 界面view调用 */
    protected XBaseView view;
    /**
     * 解析数据失败
     */
    public static final int PARSE_ERROR = 1001;
    /**
     * 网络问题
     */
    public static final int BAD_NETWORK = 1002;
    /**
     * 连接错误
     */
    public static final int CONNECT_ERROR = 1003;
    /**
     * 连接超时
     */
    public static final int CONNECT_TIMEOUT = 1004;

    public BaseObserver(XBaseView view) {
        this.view = view;
    }

    @Override
    protected void onStart() {
        Log.d(TAG , "请求数据 --onStart--" + view);
        if (view != null) {
            view.showLoading();
        }
    }

    @Override
    public void onNext(T o) {
        Log.d(TAG , "请求数据 --onNext--");
        try {
            BaseModel model = (BaseModel) o;
            if (model.getCode().equals(0)) {
                onSuccess(o);
            } else {
                onError("返回码错误，错误代码：" + model.getCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            onParseError( o , e.toString());
        }
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG , "请求数据 --onError--");
        if (view != null) {
            view.hideLoading();
        }
        if (e instanceof HttpException) {
            //   HTTP错误
            onException(BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {
            //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {
            //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            //  解析错误
            onException(PARSE_ERROR);
        } else {
            if (e != null) {
                onError(e.toString());
            } else {
                onError("未知错误");
            }
        }

    }

    private void onException(int unknownError) {
        switch (unknownError) {
            case CONNECT_ERROR:
                onError("连接错误");
                break;

            case CONNECT_TIMEOUT:
                onError("连接超时");
                break;

            case BAD_NETWORK:
                onError("网络问题");
                break;

            case PARSE_ERROR:
                onError("解析数据失败");
                break;

            default:
                break;
        }
    }

    @Override
    public void onComplete() {
        Log.d(TAG , "请求数据 --onComplete--");
        if (view != null) {
            view.hideLoading();
        }
    }

    /** 操作成功 */
    public abstract void onSuccess(T o);
    /** 操作错误 */
    public abstract void onError(String msg);
    /** 解析数据baseModel错误 */
    public abstract void onParseError(T o , String msg);

}