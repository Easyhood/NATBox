package com.rgk.qiguan.natbox.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rgk.qiguan.natbox.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends BaseActivity {

    @BindView(R.id.ivImage)
    ImageView ivImage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_layout)
    CollapsingToolbarLayout collapsingLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.web_text)
    WebView webText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);

        //新闻页面接收数据
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        final ArrayList<String> data = bundle.getStringArrayList("data");
        toolbar.setTitle(data.get(2));
        setSupportActionBar(toolbar);
        //设置返回箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        webText.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webText.loadUrl(data.get(1));

        Glide.with(this)
                .load(data.get(0))
                .error(R.mipmap.ic_launcher)
                .fitCenter()
                .into(ivImage);


    }
}
