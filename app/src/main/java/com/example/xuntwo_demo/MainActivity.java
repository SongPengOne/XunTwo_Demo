package com.example.xuntwo_demo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.xuntwo_demo.Adapter.MainAdapter;
import com.example.xuntwo_demo.Fragmwnt.AFragment;
import com.example.xuntwo_demo.Fragmwnt.CFragment;
import com.example.xuntwo_demo.Fragmwnt.ChildFragment;
import com.example.xuntwo_demo.Fragmwnt.HomeFragment;
import com.example.xuntwo_demo.Fragmwnt.XFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTabla = (TabLayout) findViewById(R.id.tabla);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new XFragment());
        list.add(new CFragment());
        list.add(new ChildFragment());
        list.add(new AFragment());
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), list);
        mVp.setAdapter(mainAdapter);
        mTabla.setupWithViewPager(mVp);

        mTabla.getTabAt(0).setText("主页").setIcon(R.drawable.select1);
        mTabla.getTabAt(1).setText("发现").setIcon(R.drawable.select);
        mTabla.getTabAt(2).setIcon(R.drawable.page_release);
        mTabla.getTabAt(3).setText("成长").setIcon(R.drawable.select2);
        mTabla.getTabAt(4).setText("我的").setIcon(R.drawable.select3);


    }
}
