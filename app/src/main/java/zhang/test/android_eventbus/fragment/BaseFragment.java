package zhang.test.android_eventbus.fragment;


import android.support.v4.app.Fragment;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import zhang.test.android_eventbus.MessageEvent;
import zhang.test.android_eventbus.Util.LogUtil;

/**
 * Created by Administrator on 2016/12/8.
 */

public class BaseFragment extends Fragment {
    @Override
    public void onStart() {
        super.onStart();
        // 注册该事件
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        // 取消该事件
    }

    // 主线程
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if (event.isShow()) {
            LogUtil.d("EvnetBus == 主线程：", "接收到了消息 true");
        }  else {
            LogUtil.d("EvnetBus == 主线程：", "接收到了消息 false");
        }
    }

    // 事件的处理在和事件的发送在相同的进程
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessagePosting(MessageEvent event) {
        if (event.isShow()) {
            LogUtil.d("EvnetBus == 同一线程：", "接收到了消息 true");
        }  else {
            LogUtil.d("EvnetBus == 同一线程：", "接收到了消息 false");
        }
    }

    // 事件的处理会在一个后台线程中执行
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessageBackGround(MessageEvent event) {
        if (event.isShow()) {
            LogUtil.d("EvnetBus == 子线程：", "接收到了消息 true");
        }  else {
            LogUtil.d("EvnetBus == 子线程：", "接收到了消息 false");
        }
    }

    // 事件处理会在单独的线程中执行
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessageAsync(MessageEvent event) {
        if (event.isShow()) {
            LogUtil.d("EvnetBus == 异步线程：", "接收到了消息 true");
        }  else {
            LogUtil.d("EvnetBus == 异步线程：", "接收到了消息 false");
        }
    }

//    ========================================================================
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEventPostThread(MessageEvent messageEvent) {
        Log.e("PostThread", Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEventMainThread(MessageEvent messageEvent) {
        Log.e("MainThread", Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessageEventBackgroundThread(MessageEvent messageEvent) {
        Log.e("BackgroundThread", Thread.currentThread().getName());
    }

    @Subscribe(threadMode = ThreadMode.ASYNC, sticky = true)
    public void onMessageEventAsync(MessageEvent messageEvent) {
        Log.e("Async", Thread.currentThread().getName());
    }
}
