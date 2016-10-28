package com.rgk.qiguan.natbox.service;



import com.rgk.qiguan.natbox.domain.NewsGson;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Description:
 * Copyright  : Copyright (c) 2016
 * Company    : RGK
 * Author     : qi.guan
 * Date       : 2016/10/27 16:55
 */

public interface ApiService {
    @GET("social/")
    Observable<String> getString(@Query("key")String key, @Query("num")String num, @Query("page")int page);

    @GET("social/")
    Observable<NewsGson> getNewsData(@Query("key")String key, @Query("num")String num, @Query("page")int page);

    @GET("meinv/")
    Observable<String> getPictureData(@Query("key")String key,@Query("num")String num,@Query("page")int page);
}
