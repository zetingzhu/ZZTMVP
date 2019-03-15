package mvp.kting.com.zztmvp.xmodel;

/**
 * Created by zeting
 * Date 19/3/13.
 */

public class MainModelImpl implements IMainModel {

    @Override
    public void loadData(IMainLoadListener iMainLoadListener) {

//        ApiRetrofitWeather.getInstance().getApiService().getWheatherGroup();

        iMainLoadListener.onComplete(null);

    }

}
