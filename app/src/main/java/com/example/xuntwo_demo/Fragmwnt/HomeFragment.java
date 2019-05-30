package com.example.xuntwo_demo.Fragmwnt;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
public class HomeFragment extends Fragment implements listMyview {


    private RecyclerView rlv;
    private ArrayList<SBean.DataBean.DatasBean> list;
    private HomeAdapter adapter;
    private RecyclerView rlv2;
    private RecyclerView rlv3;


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
        rlv2 = (RecyclerView) inflate.findViewById(R.id.rlv2);
        rlv3 = (RecyclerView) inflate.findViewById(R.id.rlv3);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rlv.setLayoutManager(manager);
        LinearLayoutManager manager1 = new LinearLayoutManager(getContext());
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
         rlv2.setLayoutManager(manager1);
        rlv3.setLayoutManager(new GridLayoutManager(getContext(),2));
        list = new ArrayList<>();
        adapter = new HomeAdapter(getContext(), list);
        rlv.setAdapter(adapter);
        rlv2.setAdapter(adapter);
        rlv3.setAdapter(adapter);
    }

    @Override
    public void onSucces(SBean listbean) {
        list.addAll(listbean.getData().getDatas());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String errer)  {
        Log.i("123", "=====>" + errer);
    }
}
