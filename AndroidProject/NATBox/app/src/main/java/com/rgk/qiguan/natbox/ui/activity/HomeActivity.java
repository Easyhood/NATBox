package com.rgk.qiguan.natbox.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.rgk.qiguan.natbox.R;
import com.rgk.qiguan.natbox.ui.fragment.ChatFragment;
import com.rgk.qiguan.natbox.ui.fragment.ContactFragment;
import com.rgk.qiguan.natbox.ui.fragment.MeFragment;
import com.rgk.qiguan.natbox.ui.fragment.NewsFragment;

import etong.bottomnavigation.lib.BottomBarTab;
import etong.bottomnavigation.lib.BottomNavigationBar;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;


public class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationBar bottomlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        /**
         * 版本初始化判断
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            //半透明状态栏
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //半透明的选择栏
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //初始化标题栏
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null){
            toolbar.setTitle("德玛西亚");
        }


        //初始化浮动选择键
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null){
            fab.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "替换为你自己的action", Snackbar.LENGTH_LONG).setAction("action", null).show();
                }
            });
        }


        //初始化主页面抽屉布局
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_home);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        if (drawer != null){
            drawer.setDrawerListener(toggle);
            toggle.syncState();
        }


        //初始化navigatinview
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null){
            navigationView.setNavigationItemSelectedListener(this);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, NewsFragment.newInstance()).commitAllowingStateLoss();
        }


        /**
         * 根据按键切换fragment
         */
        setUpBottomNavigationBar();

        /**
         * IMKit调用第二步，建立与服务器的连接
         */
        //reconnect();
    }


    /**
     * 将按键与相应的fragment绑定
     */
    public void setUpBottomNavigationBar(){
        bottomlayout = (BottomNavigationBar) findViewById(R.id.bottomLayout);
        if (bottomlayout != null){
            bottomlayout.setTabWidthSelectedScale(1.5f);
            bottomlayout.setTextDefaultVisible(false);
            bottomlayout.addTab(R.drawable.tab_news_selector,"资讯",0xff4a5965);
            bottomlayout.addTab(R.drawable.tab_chat_selector,"会话",0xff096c54);
            bottomlayout.addTab(R.drawable.tab_contact_selector,"通讯录",0xff8a6a64);
            bottomlayout.addTab(R.drawable.tab_me_selector,"我",0xff553b36);
            bottomlayout.setOnTabListener(new BottomNavigationBar.TabListener() {
                @Override
                public void onSelected(BottomBarTab tab,int position) {
                    Fragment fragment = null;
                    switch (position){
                        case 0:
                            fragment = NewsFragment.newInstance();
                            break;
                        case 1:
                            fragment = ChatFragment.newInstance();
                            break;
                        case 2:
                            fragment = ContactFragment.newInstance();
                            break;
                        case 3:
                            fragment = MeFragment.newInstance();
                            break;
                        default:
                            fragment = NewsFragment.newInstance();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commitAllowingStateLoss();
                }
            });
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 建立与融云服务器的连接
     */
    private void reconnect() {
        String Token = "lalalalala";//测试用Token
        RongIM.connect(Token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                //Connect Token失效的处理，需要重新获取Token

            }

            @Override
            public void onSuccess(String s) {
                Log.e("SplashActivity", "--onSuccess--" + s);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("SplashActivity", "--onError--" + errorCode);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_home);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
