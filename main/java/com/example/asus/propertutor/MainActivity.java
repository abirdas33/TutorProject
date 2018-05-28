package com.example.asus.propertutor;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainView;
    private FrameLayout mMainFrame;
    private FragmentHome fragmentHome;
    private FragmentChat fragmentChat;
    private FragmentNotify fragmentNotify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainView=(BottomNavigationView)findViewById(R.id.main_nav);
        mMainFrame=(FrameLayout)findViewById(R.id.main_frame);
        fragmentHome = new FragmentHome();
        fragmentChat=new FragmentChat();
        fragmentNotify = new FragmentNotify();

        setFragment(fragmentHome);

        mMainView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        mMainView.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(fragmentHome);
                        return true;
                    case R.id.nav_chat:
                        mMainView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(fragmentChat);
                        return true;
                    case R.id.nav_notify:
                        mMainView.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(fragmentNotify);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();

    }


}
