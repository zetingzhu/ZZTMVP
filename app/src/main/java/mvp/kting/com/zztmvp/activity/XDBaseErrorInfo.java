package mvp.kting.com.zztmvp.activity;

/**
 * Created by zeting
 * Date 19/3/22.
 */

public class XDBaseErrorInfo {
    private String c_err ; // ":"sign code is error",
    private Object err_type; // ":"param_err",
    private String err_fun; // ":"GatewaysmakeSecret",
    private Object err_data; // ":"str=sign=====FBC33427B1392E0429B3883EEB8BF719",
    private String err_code ; // ":100000
    private String mysqli_class ; // ":"MysqlClass",
    private String mysqli_model ; // ":"dbcache",
    private String mysql_innerfun ; // ":"mysql_query",
    private String mysql_sql ; // ":" select * from user_relation where user_id=137 9774 5363",
    private String mysql_time ; // ":"2019-03-22 20:21:23",
    private String mysql_syserr ; // ":"You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '9774 5363' at line 1",
    private String mysql_db ; // ":"anqi_user_center"
    private XDBaseParams params ;

    public String getC_err() {
        return c_err;
    }

    public void setC_err(String c_err) {
        this.c_err = c_err;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public Object getErr_data() {
        return err_data;
    }

    public void setErr_data(Object err_data) {
        this.err_data = err_data;
    }

    public String getMysql_db() {
        return mysql_db;
    }

    public void setMysql_db(String mysql_db) {
        this.mysql_db = mysql_db;
    }

    public String getMysql_innerfun() {
        return mysql_innerfun;
    }

    public void setMysql_innerfun(String mysql_innerfun) {
        this.mysql_innerfun = mysql_innerfun;
    }

    public String getMysql_sql() {
        return mysql_sql;
    }

    public void setMysql_sql(String mysql_sql) {
        this.mysql_sql = mysql_sql;
    }

    public String getMysql_syserr() {
        return mysql_syserr;
    }

    public void setMysql_syserr(String mysql_syserr) {
        this.mysql_syserr = mysql_syserr;
    }

    public String getMysql_time() {
        return mysql_time;
    }

    public void setMysql_time(String mysql_time) {
        this.mysql_time = mysql_time;
    }

    public String getMysqli_class() {
        return mysqli_class;
    }

    public void setMysqli_class(String mysqli_class) {
        this.mysqli_class = mysqli_class;
    }

    public String getMysqli_model() {
        return mysqli_model;
    }

    public void setMysqli_model(String mysqli_model) {
        this.mysqli_model = mysqli_model;
    }

    public String getErr_fun() {
        return err_fun;
    }

    public void setErr_fun(String err_fun) {
        this.err_fun = err_fun;
    }

    public Object getErr_type() {
        return err_type;
    }

    public void setErr_type(Object err_type) {
        this.err_type = err_type;
    }

    public XDBaseParams getParams() {
        return params;
    }

    public void setParams(XDBaseParams params) {
        this.params = params;
    }
}
