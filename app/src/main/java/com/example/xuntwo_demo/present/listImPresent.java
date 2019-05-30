package com.example.xuntwo_demo.present;


import com.example.xuntwo_demo.Callback.listCallBack;
import com.example.xuntwo_demo.bean.SBean;
import com.example.xuntwo_demo.model.ListModel;
import com.example.xuntwo_demo.view.listMyview;

public class listImPresent implements listPresent, listCallBack {
    private ListModel listModel;
    private listMyview mListMyview;

    public listImPresent(ListModel listModel, listMyview listMyview) {
        this.listModel = listModel;
        this.mListMyview = listMyview;
    }

    @Override
    public void getlist() {
        if (listModel != null) {
            listModel.getlist(this);
        }
    }

    @Override
    public void onSucces(SBean listbean) {
        if (mListMyview != null) {
            mListMyview.onSucces(listbean);
        }
    }

    @Override
    public void onFail(String errer) {
        if (mListMyview != null) {
            mListMyview.onFail(errer);
        }
    }
}
