package mvp.kting.com.zztmvp.xpersenter;

import android.util.Log;

import com.kting.mvplibrary.xmodel.BaseObserver;
import com.kting.mvplibrary.xpersenter.XBasePresenter;

import java.util.List;

import mvp.kting.com.zztmvp.api.ApiRetrofitWeather;
import mvp.kting.com.zztmvp.api.ApiServerWeather;
import mvp.kting.com.zztmvp.bean.MyWeather;
import mvp.kting.com.zztmvp.bean.weather.DailyForecast;
import mvp.kting.com.zztmvp.xmodel.IMainModel;
import mvp.kting.com.zztmvp.xmodel.MainModelImpl;
import mvp.kting.com.zztmvp.xview.IMainView;

/**
 * Created by zeting
 * Date 19/3/13.
 */
public class MainPresenter<T extends IMainView> extends XBasePresenter<T> {
    private final static String TAG = MainPresenter.class.getSimpleName() ;

    IMainView mIMainView ;

    IMainModel mIMainModel = new MainModelImpl();

    /** 接口调用服务 */
    protected ApiServerWeather apiServer ;

    public MainPresenter() {
        apiServer = ApiRetrofitWeather.getInstance().getApiService();
    }

    /**
     * 执行获取数据
     * 这里借鉴 appfram 中的mvp 设置模式
     */
    public void fetchListData(){
        mIMainView = mViewRef.get() ;
        if (mIMainView != null) {
            // 显示加载loading
            mIMainView.showLoading();
            // 获取数据
            mIMainModel.loadData(new IMainModel.IMainLoadListener() {

                @Override
                public void onComplete(List<DailyForecast> listData) {
                    // 设置数据
                    mIMainView.showListData(listData);
                    // 隐藏加载loading
                    mIMainView.hideLoading();
                }
            });
        }
    }

    /**
     * 获取标准天气数据
     */
    public void fetchListData1(){
        mIMainView = mViewRef.get() ;
        // 显示加载loading
        mIMainView.showLoading();
        addDisposable(apiServer.getWheather("上海"), new BaseObserver<MyWeather>(null) {

            @Override
            public void onSuccess(MyWeather o) {
                Log.d(TAG , "fetch data --onSuccess-- " );
            }

            @Override
            public void onError(String msg) {
                Log.d(TAG , "fetch data --onError-- " + msg );
            }

            @Override
            public void onParseError(MyWeather o, String msg) {
                Log.d(TAG , "fetch data --onParseError-- " );
                if (o != null) {
                    List<DailyForecast> dailyForecasts = o.getHeWeather6().get(0).getDaily_forecast();
                    mIMainView.showListData(dailyForecasts);
                    // 隐藏加载loading
                    mIMainView.hideLoading();
                }
            }
        });
    }

}
