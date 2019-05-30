package com.example.xuntwo_demo.Fragmwnt;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xuntwo_demo.Adapter.CAdapter;
import com.example.xuntwo_demo.R;
import com.example.xuntwo_demo.bean.Bean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment {


    private RecyclerView rlv;
    private ArrayList<Bean.ResultBean.DataBean> list;
    private CAdapter cAdapter;

    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_c, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .url("http://172.16.56.109:8080/a/b.txt")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("123","=====>"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final Bean bean = new Gson().fromJson(string, Bean.class);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list.addAll(bean.getResult().getData());
                        cAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void initView(View inflate) {
        rlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        cAdapter = new CAdapter(getContext(), list);
        rlv.setAdapter(cAdapter);

    }
}
