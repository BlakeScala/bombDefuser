package com.epicodus.blake.bombdefuser.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.blake.bombdefuser.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClockFragment extends Fragment {


    public ClockFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        View view = inflater.inflate(R.layout.fragment_clock, container, false);
        return view;

    }

}
