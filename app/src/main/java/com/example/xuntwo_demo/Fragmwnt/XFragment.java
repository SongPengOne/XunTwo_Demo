package com.example.xuntwo_demo.Fragmwnt;


import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.xuntwo_demo.Adapter.MainAdapter;
import com.example.xuntwo_demo.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class XFragment extends Fragment {


    private ViewPager vpr;
    private TabLayout tablat;

    public XFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_x, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        vpr = (ViewPager) inflate.findViewById(R.id.vpr);
        tablat = (TabLayout) inflate.findViewById(R.id.tablat);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new ChildFragment());
        MainAdapter mainAdapter = new MainAdapter(getChildFragmentManager(), list);
        vpr.setAdapter(mainAdapter);
        tablat.setupWithViewPager(vpr);
        tablat.getTabAt(0).setText("专题活动").setIcon(R.drawable.ic_launcher_background);
        tablat.getTabAt(1).setText("人气宝贝").setIcon(R.drawable.ic_launcher_background);

    }
}
