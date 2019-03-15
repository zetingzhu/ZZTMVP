package com.kting.mvplibrary.xpersenter;

import com.kting.mvplibrary.api.ApiRetrofit;
import com.kting.mvplibrary.api.ApiServer;
import com.kting.mvplibrary.xmodel.BaseObserver;
import com.kting.mvplibrary.xview.XBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * presenter 基类
 * Created by zeting
 * Date 19/3/13.
 * 使用方法： public class MainPresenter<T extends IMainView> extends XBasePresenter<T>
 *
 */

public class XBasePresenter<V extends XBaseView> {

    /** observer 管理器 */
    private CompositeDisposable compositeDisposable;
    /** baseView 引用 */
    protected WeakReference<V> mViewRef ;

    /** 绑定view */
    public void attachView(V view){
        mViewRef = new WeakReference<V>(view);
    }

    /** 解绑view */
    public void detachView(){
        mViewRef.clear() ;
        removeDisposable() ;
    }

    /**
     * 将需要被 CompositeDisposable 管理的 observer 加入到管理集合中
     */
    public void addDisposable(Observable<?> observable, BaseObserver observer) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }

        // 订阅事件
        Observable<?> mObservable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Disposable disposable = mObservable.subscribeWith(observer);
        // Disposable 加入到 CompositeDisposable 中
        compositeDisposable.add( disposable );
    }

    /**
     *  取消订阅
     */
    public void removeDisposable() {
        if (compositeDisposable != null) {
            // 将所有的 observer 取消订阅
            compositeDisposable.dispose();
        }
    }


}
