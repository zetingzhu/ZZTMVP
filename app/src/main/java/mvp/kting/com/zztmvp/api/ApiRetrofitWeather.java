package mvp.kting.com.zztmvp.api;

import android.util.Log;

import com.kting.mvplibrary.api.ApiRetrofit;
import com.kting.mvplibrary.api.ApiServer;

/**
 * 天气请求api
 */

public class ApiRetrofitWeather extends ApiRetrofit  {

    public static String BASE_SERVER_URL_WEATHER = "https://free-api.heweather.net/s6/";

    private static ApiRetrofitWeather apiRetrofit;

    private ApiServerWeather apiServer ;

    public ApiRetrofitWeather( ) {
        super( BASE_SERVER_URL_WEATHER  );
        apiServer = retrofit.create( ApiServerWeather.class );
    }

    public static ApiRetrofitWeather getInstance() {
        if (apiRetrofit == null) {
            synchronized (Object.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new ApiRetrofitWeather();
                }
            }
        }
        return apiRetrofit;
    }

    public ApiServerWeather getApiService() {
        Log.d("class " , "class "   );
        if (apiServer instanceof ApiServer){
            Log.d("class ", "class : ApiServer "  );
        }
        if (apiServer instanceof ApiServerWeather) {
            Log.d("class ", "class :" + apiServer.getClass().getName());
            return apiServer;
        }
        return apiServer ;
    }

}