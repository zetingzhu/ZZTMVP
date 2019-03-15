package mvp.kting.com.zztmvp.bean.weather;

/**
 * lifestyle_forecast 生活指数未来3天预报
 * Created by zeting
 * Date 19/3/15.
 */

public class LifestyleForecast {
    private String date;// 预报日期，例如2017-12-30
    private String brf;// 生活指数简介
    private String txt;// 生活指数详细描述
    /**
     * 生活指数类型 comf：舒适度指数、cw：洗车指数、drsg：穿衣指数、
     * flu：感冒指数、sport：运动指数、trav：旅游指数、uv：紫外线指数、
     * air：空气污染扩散条件指数、ac：空调开启指数、ag：过敏指数、
     * gl：太阳镜指数、mu：化妆指数、airc：晾晒指数、ptfc：交通指数、
     * fsh：钓鱼指数、spi：防晒指数
     */
    private String type;

    public String getBrf() {
        return brf;
    }

    public void setBrf(String brf) {
        this.brf = brf;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
