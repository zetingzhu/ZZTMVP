package mvp.kting.com.zztmvp.bean.weather;

/**
 * basic 基础信息
 * Created by zeting
 * Date 19/3/15.
 */

public class Basic {
    private String location	; // 地区／城市名称	卓资
    private String cid	; // 地区／城市ID	CN101080402
    private String lat	; // 地区／城市纬度	40.89576
    private String lon	; // 地区／城市经度	112.577702
    private String parent_city	; // 该地区／城市的上级城市	乌兰察布
    private String admin_area	; // 该地区／城市所属行政区域	内蒙古
    private String cnty	; // 该地区／城市所属国家名称	中国
    private String  tz	; // 该地区／城市所在时区	+8.0

    public String getAdmin_area() {
        return admin_area;
    }

    public void setAdmin_area(String admin_area) {
        this.admin_area = admin_area;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getParent_city() {
        return parent_city;
    }

    public void setParent_city(String parent_city) {
        this.parent_city = parent_city;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }
}
