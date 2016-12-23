package zhang.test.android_eventbus.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhang.test.android_eventbus.MessageEvent;
import zhang.test.android_eventbus.R;

/**
 * Created by Administrator on 2016/12/8.
 */

public class MainFragment extends BaseFragment {
    @BindView(R.id.event_main)
    Button eventMain;
    private MessageEvent mEvent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        ButterKnife.bind(this, view);

        mEvent = new MessageEvent(false);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(getActivity()).unbind();
    }
    
    @OnClick({R.id.event_main, R.id.event_asyc})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.event_main:
                Toast.makeText(getActivity(), "event_main", Toast.LENGTH_SHORT).show();
                EventBus.getDefault().postSticky(mEvent);
                break;

            case R.id.event_asyc:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EventBus.getDefault().postSticky(mEvent);
                    }
                }).start();
                break;
        }
    }
}
