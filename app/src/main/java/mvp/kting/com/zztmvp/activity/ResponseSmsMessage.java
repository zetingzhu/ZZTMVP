package mvp.kting.com.zztmvp.activity;


import java.util.List;

/**
 * 验证码
 * Created by zeting
 * Date 19/3/22.
 */

public class ResponseSmsMessage extends XDBaseResponse {
    private SmsMessageData sms_message ;
//    private List< UserInfoData > user_info ; // 如果有userinfo 表示此用户已经注册过了
    private List user_info ; // 如果有userinfo 表示此用户已经注册过了

    public List getUser_info() {
        return user_info;
    }

    public void setUser_info(List user_info) {
        this.user_info = user_info;
    }

    public SmsMessageData getSms_message() {
        return sms_message;
    }

    public void setSms_message(SmsMessageData sms_message) {
        this.sms_message = sms_message;
    }
}
