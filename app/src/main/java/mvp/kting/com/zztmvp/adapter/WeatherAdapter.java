package mvp.kting.com.zztmvp.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mvp.kting.com.zztmvp.R;
import mvp.kting.com.zztmvp.bean.MyWeatherNow;
import mvp.kting.com.zztmvp.bean.weather.DailyForecast;

/**
 * Created by zeting
 * Date 19/3/13.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private Context mContext;
    private List<DailyForecast> mWeatherList = new ArrayList<>();

    public WeatherAdapter(Context context) {
        mContext = context;
    }

    public WeatherAdapter(Context context, List<DailyForecast> weatherList) {
        mContext = context;
        mWeatherList = weatherList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ((Activity) mContext).getLayoutInflater().inflate(R.layout.item_weather_layout, null);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DailyForecast dataInfo = mWeatherList.get(position);
        holder.mRvDate.setText("预报日期："+dataInfo.getDate() );
        holder.mTvName.setText("白天天气："+dataInfo.getCond_txt_d() + "-" + "晚间天气："+dataInfo.getCond_txt_n() );
        holder.mTvStat.setText("最高温度："+dataInfo.getTmp_max() + "-" + "最低温度："+dataInfo.getTmp_min() );
    }

    @Override
    public int getItemCount() {
        return mWeatherList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvName ;
        TextView mTvStat ;
        TextView mRvDate ;

        public ViewHolder(View itemView) {
            super(itemView);
            mRvDate = (TextView) itemView.findViewById(R.id.tv_date);
            mTvName = (TextView) itemView.findViewById(R.id.tv_name);
            mTvStat = (TextView) itemView.findViewById(R.id.tv_stat);
        }
    }

    public void addData(DailyForecast videoInfo) {
        mWeatherList.add(videoInfo);
    }

    public void cleanData() {
        mWeatherList.clear();
    }
}
