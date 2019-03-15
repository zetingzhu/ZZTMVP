package mvp.kting.com.zztmvp.xmodel;

import java.util.List;

import mvp.kting.com.zztmvp.bean.weather.DailyForecast;

/**
 * Created by zeting
 * Date 19/3/13.
 */

public interface IMainModel {

    void loadData(IMainLoadListener iMainLoadListener );

    interface IMainLoadListener{
        void onComplete(List<DailyForecast> listData) ;
    }
}
