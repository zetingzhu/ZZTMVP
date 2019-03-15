package mvp.kting.com.zztmvp.xview;

import com.kting.mvplibrary.xview.XBaseView;

import java.util.List;

import mvp.kting.com.zztmvp.bean.weather.DailyForecast;

/**
 * Created by zeting
 * Date 19/3/13.
 */

public interface IMainView extends XBaseView {

    // 显示数据
    void showListData(List<DailyForecast> albumList);

}
