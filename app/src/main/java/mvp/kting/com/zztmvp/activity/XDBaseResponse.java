package mvp.kting.com.zztmvp.activity;

/**
 * 重构请求后的基本请求格式
 *
 */
public class XDBaseResponse  {
	public XDBaseErrorInfo errorinfo ;

	public XDBaseErrorInfo getErrorinfo() {
		return errorinfo;
	}

	public void setErrorinfo(XDBaseErrorInfo errorinfo) {
		this.errorinfo = errorinfo;
	}
}
