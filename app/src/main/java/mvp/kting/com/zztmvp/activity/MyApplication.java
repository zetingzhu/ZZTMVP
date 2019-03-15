package mvp.kting.com.zztmvp.activity;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/**
 * Created by allen on 18/8/7.
 */

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    private static MyApplication mInstance;
    Handler mWorkHandler = null; // 用于向工作线程发送执行代码
    HandlerThread mWorkThread = null; // 工作线程处理耗时操作,防止在主线程中执行界面卡

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    /**
     * 工作线程
     *
     * @param r
     * @return
     */
    public boolean postWorkRunnable(Runnable r) {
        if (mWorkHandler == null) {
            mWorkHandler = new Handler(getWorkLooper());
        }
        return mWorkHandler.post(r);
    }

    /**
     * 获取Looper实现自定义Handler,在指定线程(非当前线程)处理消息 获取工作线程Looper,注:获取主线程Looper请调用
     * getMainLooper()
     */
    public Looper getWorkLooper() {
        if (mWorkThread == null) { // 如果工作线程未开启,则开启工作线程
            mWorkThread = new HandlerThread("Rtcclient_WorkThread");
            mWorkThread.start();
        }
        return mWorkThread.getLooper();
    }
}
