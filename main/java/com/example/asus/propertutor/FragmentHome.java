package com.example.asus.propertutor;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    ViewPager viewPager;
    // LinearLayout sliderdots;
    public int dotcounts;
    public ImageView[] dots;
    private CircleIndicator indicator;
    // Context context;
    private final Handler timerHandler = new Handler();


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        indicator = (CircleIndicator) getView().findViewById(R.id.indicator);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);
        indicator.setViewPager(viewPager);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new myTimerTask(), 6000 ,6000);
    }
    public class myTimerTask extends TimerTask {
        @Override
        public void run() {

            timerHandler.post(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else
                    {
                        viewPager.setCurrentItem(0);
                    }

                }
            });
        }
    }
}


