package mvp.kting.com.zztmvp.bean;

import java.util.List;

import mvp.kting.com.zztmvp.bean.weather.Basic;
import mvp.kting.com.zztmvp.bean.weather.DailyForecast;
import mvp.kting.com.zztmvp.bean.weather.Hourly;
import mvp.kting.com.zztmvp.bean.weather.Lifestyle;
import mvp.kting.com.zztmvp.bean.weather.Now;
import mvp.kting.com.zztmvp.bean.weather.Update;

/**
 * 常规天气
 */

public class MyWeather {

    private List<HeWeather6> HeWeather6 ;

    public List<MyWeather.HeWeather6> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<MyWeather.HeWeather6> heWeather6) {
        HeWeather6 = heWeather6;
    }

    public class HeWeather6{
        private Basic basic ;
        private List<DailyForecast> daily_forecast ;
        private List<Hourly> hourly ;
        private List<Lifestyle> lifestyle ;
        private Now now ;
        private String status ;
        private Update update ;

        public Basic getBasic() {
            return basic;
        }

        public void setBasic(Basic basic) {
            this.basic = basic;
        }

        public List<DailyForecast> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecast> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<Hourly> getHourly() {
            return hourly;
        }

        public void setHourly(List<Hourly> hourly) {
            this.hourly = hourly;
        }

        public List<Lifestyle> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<Lifestyle> lifestyle) {
            this.lifestyle = lifestyle;
        }

        public Now getNow() {
            return now;
        }

        public void setNow(Now now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Update getUpdate() {
            return update;
        }

        public void setUpdate(Update update) {
            this.update = update;
        }
    }

}
