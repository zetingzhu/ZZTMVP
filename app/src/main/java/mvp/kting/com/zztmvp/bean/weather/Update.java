package mvp.kting.com.zztmvp.bean.weather;

/**
 * update 接口更新时间
 * Created by zeting
 * Date 19/3/15.
 */

public class Update {
    private String loc ;// 当地时间，24小时制，格式yyyy-MM-dd HH:mm	2017-10-25 12:34
    private String utc ;// UTC时间，24小时制，格式yyyy-MM-dd HH:mm

    public String getUtc() {
        return utc;
    }

    public void setUtc(String utc) {
        this.utc = utc;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
