package mvp.kting.com.zztmvp.activity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.kting.mvplibrary.XBaseActivity;

import java.util.List;

import mvp.kting.com.zztmvp.R;
import mvp.kting.com.zztmvp.adapter.WeatherAdapter;
import mvp.kting.com.zztmvp.bean.MyWeather;
import mvp.kting.com.zztmvp.bean.weather.DailyForecast;
import mvp.kting.com.zztmvp.widget.PullLoadRecyclerView;
import mvp.kting.com.zztmvp.xpersenter.MainPresenter;
import mvp.kting.com.zztmvp.xview.IMainView;

public class MainActivity extends XBaseActivity<IMainView , MainPresenter<IMainView>> implements IMainView {
    private final static String TAG = MainActivity.class.getSimpleName() ;

    private PullLoadRecyclerView mRecyclerView ;
    private WeatherAdapter mAdapter ;
    private boolean mIsFromRefresh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView() ;

        String strJson = "{\"HeWeather6\":[{\"basic\":{\"cid\":\"CN101020100\",\"location\":\"上海\",\"parent_city\":\"上海\",\"admin_area\":\"上海\",\"cnty\":\"中国\",\"lat\":\"31.23170662\",\"lon\":\"121.47264099\",\"tz\":\"+8.00\"},\"update\":{\"loc\":\"2019-03-15 09:55\",\"utc\":\"2019-03-15 01:55\"},\"status\":\"ok\",\"now\":{\"cloud\":\"0\",\"cond_code\":\"100\",\"cond_txt\":\"晴\",\"fl\":\"16\",\"hum\":\"56\",\"pcpn\":\"0.0\",\"pres\":\"1024\",\"tmp\":\"16\",\"vis\":\"12\",\"wind_deg\":\"272\",\"wind_dir\":\"西风\",\"wind_sc\":\"0\",\"wind_spd\":\"1\"}}]}" ;
        MyWeather myWeather = new MyWeather();
        Gson gson = new Gson();
        Log.d( TAG ,  "--:" +gson.toJson(myWeather) ) ;
        myWeather = gson.fromJson( strJson , MyWeather.class );
//        Log.d( TAG ,  "--:" +gson.toJson(myWeather) ) ;


//        Intent intent = new Intent();
//        intent.setAction("android.intent.action.VIEW");
//        Uri content_url = Uri.parse("http://admin.vipcare.com/Login/login.html");
//        intent.setData(content_url);
//        intent.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
//        startActivity(intent);

    }

    @Override
    protected MainPresenter<IMainView> CreatePresenter() {
        return new MainPresenter<>();
    }


    private void initView() {
        mRecyclerView = (PullLoadRecyclerView) findViewById(R.id.pull_recycler_view);

        mRecyclerView.setLinearLayout();
        mAdapter = new WeatherAdapter(MainActivity.this);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnPullLoadMoreListener(new PullLoadRecyclerView.OnPullLoadMoreListener() {
            @Override
            public void onRefresh() {
                Log.d(TAG , "下拉数据刷新" ) ;
                mIsFromRefresh = true;
                // 获取数据
                mPresenter.fetchListData1();
                mRecyclerView.setRefreshCompleted();
            }

            @Override
            public void onLoadMore() {
                Log.d(TAG , "上拉数据刷新" ) ;
//                mAlbumPresenter.loadingNext();
                mRecyclerView.setLoadMoreCompleted();
            }
        });
    }

    @Override
    public void showListData(List<DailyForecast> albumList) {
        if (mIsFromRefresh) {
//            mAdapter.cleanData();
            mIsFromRefresh = false;
        }
        if (albumList != null && albumList.size() > 0) {
            for (DailyForecast videoInfo : albumList) {
                mAdapter.addData(videoInfo);
            }
            mAdapter.notifyDataSetChanged();
        }
    }

}
