package mvp.kting.com.zztmvp.api;

import com.kting.mvplibrary.api.ApiServer;

import java.util.Map;

import io.reactivex.Observable;
import mvp.kting.com.zztmvp.bean.MyWeather;
import mvp.kting.com.zztmvp.bean.MyWeatherNow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 网络请求接口定义
 */
public interface ApiServerWeather {

    /** 天气预报 */
    //https://search.heweather.com/top?group=cn&key=4b61a68895b149f1a5ea53fe43782e17&number=20
    @GET("top?key=4b61a68895b149f1a5ea53fe43782e17")
    Observable<MyWeatherNow> getWheatherGroup(@Query("group") String group, @Query("number") String number);

    /** 实时天气  https://free-api.heweather.net/s6/weather/now?location=上海&unit=m&key=4b61a68895b149f1a5ea53fe43782e17  */
    @GET("weather/now?key=4b61a68895b149f1a5ea53fe43782e17&unit=m")
    Observable<MyWeatherNow> getWheatherNow(@Query("location") String location );

    /** 常规天气查询 https://free-api.heweather.net/s6/weather?location=上海&unit=m&key=4b61a68895b149f1a5ea53fe43782e17 */
    @GET("weather?key=4b61a68895b149f1a5ea53fe43782e17&unit=m")
    Observable<MyWeather> getWheather(@Query("location") String location );

    /** 3-10天天气预报 https://free-api.heweather.net/s6/weather/forecast?location=上海&unit=m&key=4b61a68895b149f1a5ea53fe43782e17 */
    @GET("weather/now?key=4b61a68895b149f1a5ea53fe43782e17&unit=m")
    Observable<MyWeather> getWheatherForecast(@Query("location") String location );

}