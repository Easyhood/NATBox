package com.rgk.qiguan.natbox.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.rgk.qiguan.natbox.Easyrecycle.NewsAdapter;
import com.rgk.qiguan.natbox.R;
import com.rgk.qiguan.natbox.domain.News;
import com.rgk.qiguan.natbox.domain.NewsGson;
import com.rgk.qiguan.natbox.service.ApiService;
import com.rgk.qiguan.natbox.utils.PixUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static android.os.Build.VERSION_CODES.N;
import static com.rgk.qiguan.natbox.R.id.recyclerView;

/**
 * 新闻资讯的Fragment
 */
public class NewsFragment extends BaseFragment {

    private NewsAdapter adapter;

    private int page = 0;

    @BindView(recyclerView)
    EasyRecyclerView recyclerView;
    @BindView(R.id.container_news)
    LinearLayout containerNews;

    public NewsFragment() {
        // Required empty public constructor
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setAdapter(adapter = new NewsAdapter(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //添加边框
        SpaceDecoration itemDecoration = new SpaceDecoration((int) PixUtils.convertDpToPixel(8, getContext()));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);

        //更多加载
        adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                //TODO 2016年10月28日09:31:43
            }

            @Override
            public void onMoreClick() {

            }
        });
        return view;
    }

    /**
     * 获取数据
     */
    private void getData(){
        Log.d("page",page + "" ) ;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.tianapi.com/")
                //String
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())//添加json转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加Rxjava适配器
                .build();
        ApiService apiManager = retrofit.create(ApiService.class);//这里采用的是java的动态代理模式
        apiManager.getNewsData("4df7151666666314af76d8c3b4e40a77","10",page)
                .subscribeOn(Schedulers.io())
                .map(new Func1<NewsGson, List<News>>() {
                    @Override
                    public List<News> call(NewsGson newsGson) {
                        List<News> newsList = new ArrayList<News>();
                        for (NewsGson.newslistBean listBean : newsGson.getNewslist()){
                            News new1 = new News();
                            new1.setTitle(listBean.getTitle());
                            new1.setCtime(listBean.getCtime());
                            new1.setDescription(listBean.getDescription());
                            new1.setPicUrl(listBean.getPicUrl());
                            new1.setUrl(listBean.getUrl());
                            newsList.add(new1);
                        }
                        return newsList;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<News>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getContext(),"网络连接失败"，Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNext(List<News> newsList) {
                       adapter.addAll(newsList);
                    }
                });
        page = page + 1;
    }

}
