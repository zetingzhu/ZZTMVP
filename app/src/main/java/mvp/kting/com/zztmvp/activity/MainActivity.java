package mvp.kting.com.zztmvp.activity;

import android.os.Bundle;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.kting.mvplibrary.XBaseActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

        String url = "http://39.108.252.215/xdapp/serverconfig/anqi/gateway.php?cmd=addData&debug=ok&params={%22device_id%22:%22301%22,%22user_token%22:%22f4eaf36cbbcd668455779314543a3d29%22,%22key_token%22:%22aaa%22,%22qr_code%22:%22301%22,%22sign%22:%22dddd%22,%22user_id%22:%2213797745363%22}";
        try {
            String deurl = URLDecoder.decode(url,"UTF-8");
            Log.d(TAG , deurl.toString()) ;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

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
