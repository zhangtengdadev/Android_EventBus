package zhang.test.android_eventbus;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import zhang.test.android_eventbus.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_fl, new MainFragment());
        ft.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
