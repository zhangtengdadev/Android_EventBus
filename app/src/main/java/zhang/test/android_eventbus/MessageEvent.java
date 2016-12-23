package zhang.test.android_eventbus;

/**
 * Created by Administrator on 2016/12/8.
 */
public class MessageEvent {
    private boolean mShow;

    public MessageEvent (boolean show) {
        mShow = show;
    }

    public boolean isShow () {
        return mShow;
    }
}
