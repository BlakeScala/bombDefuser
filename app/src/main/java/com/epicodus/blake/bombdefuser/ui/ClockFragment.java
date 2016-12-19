package com.epicodus.blake.bombdefuser.ui;


import android.icu.util.TimeUnit;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.blake.bombdefuser.Counter;
import com.epicodus.blake.bombdefuser.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClockFragment extends Fragment {
    @Bind(R.id.clockTimerView) TextView mClockTimerView;

    public ClockFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        TextView textView = new TextView(getActivity());
//
//        View view = inflater.inflate(R.layout.fragment_clock, container, false);
//        Counter counter = new Counter
//            counter.start();
//
//        };
//        return view;
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        View view = inflater.inflate(R.layout.fragment_clock, container, false);


        ButterKnife.bind(this, view);

        CountDownTimer timer = new CountDownTimer(180000, 1000) {
            @Override
            public void onTick(long timeLeft) {
                long millis = timeLeft;
                String hms = String.format("%02d:%02d",
                        java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis) - java.util.concurrent.TimeUnit.HOURS.toMinutes(java.util.concurrent.TimeUnit.MILLISECONDS.toHours(millis)),
                        java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(millis) - java.util.concurrent.TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millis))
                );
                String timeLeftString = String.valueOf((timeLeft/1000));
                mClockTimerView.setText(hms);
            }

            @Override
            public void onFinish() {
                // Take to loser's page!
            }
        };
        timer.start();

        return view;

    };
}
