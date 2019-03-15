package mvp.kting.com.zztmvp.bean.weather;

/**
 * hourly 逐小时预报
 * Created by zeting
 * Date 19/3/15.
 */

public class Hourly {
    private String time	; // 预报时间，格式yyyy-MM-dd hh:mm	2013-12-30 13:00
    private String tmp	; // 温度	2
    private String cond_code	; // 天气状况代码	101
    private String cond_txt	; // 天气状况代码	多云
    private String wind_deg	; // 风向360角度	290
    private String wind_dir	; // 风向	西北
    private String wind_sc	; // 风力	3-4
    private String wind_spd	; // 风速，公里/小时	15
    private String hum	; // 相对湿度	30
    private String  pres	; // 大气压强	1030
    private String pop	; // 降水概率，百分比	30
    private String dew	; // 露点温度	12
    private String cloud	; // 云量	23

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getCond_code() {
        return cond_code;
    }

    public void setCond_code(String cond_code) {
        this.cond_code = cond_code;
    }

    public String getCond_txt() {
        return cond_txt;
    }

    public void setCond_txt(String cond_txt) {
        this.cond_txt = cond_txt;
    }

    public String getDew() {
        return dew;
    }

    public void setDew(String dew) {
        this.dew = dew;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(String wind_deg) {
        this.wind_deg = wind_deg;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getWind_sc() {
        return wind_sc;
    }

    public void setWind_sc(String wind_sc) {
        this.wind_sc = wind_sc;
    }

    public String getWind_spd() {
        return wind_spd;
    }

    public void setWind_spd(String wind_spd) {
        this.wind_spd = wind_spd;
    }
}
