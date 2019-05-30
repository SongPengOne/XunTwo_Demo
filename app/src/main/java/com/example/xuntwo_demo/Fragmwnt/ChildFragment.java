package com.example.xuntwo_demo.Fragmwnt;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.xuntwo_demo.Adapter.HomeAdapter;
import com.example.xuntwo_demo.R;
import com.example.xuntwo_demo.bean.SBean;
import com.example.xuntwo_demo.model.ListImModel;
import com.example.xuntwo_demo.present.listImPresent;
import com.example.xuntwo_demo.view.listMyview;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragment extends Fragment implements listMyview {


    private RecyclerView rlv;
    private ArrayList<SBean.DataBean.DatasBean> list;
    private HomeAdapter homeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        listImPresent listImPresent = new listImPresent(new ListImModel(), this);
        listImPresent.getlist();
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        rlv.setLayoutManager(new GridLayoutManager(getContext(), 1));
        list = new ArrayList<>();
        homeAdapter = new HomeAdapter(getContext(), list);
        rlv.setAdapter(homeAdapter);
    }


    @Override
    public void onSucces(SBean listbean) {
        list.addAll(listbean.getData().getDatas());
        homeAdapter.notifyDataSetChanged();
    }

    @Override

    public void onFail(String errer) {
        Log.i("123", "=====>" + errer);
    }
}
