package com.miyu.androidup.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miyu.androidup.R;

/**
 * Created by Mireia on 22/04/2016.
 */
public class GlosarioFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.glosario_fragment,container,false);
        return v;
    }
}
