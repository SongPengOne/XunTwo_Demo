package com.example.xuntwo_demo.api;


import com.example.xuntwo_demo.bean.SBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Myservice {

     String List="https://www.wanandroid.com/";
     @GET("project/list/1/json?cid=294")
    Observable<SBean>getlist();
}
