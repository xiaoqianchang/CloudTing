package com.ximalaya.cloudting.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import com.ximalaya.cloudting.android.adapter.SimpleFragmentPagerAdapter;
import com.ximalaya.cloudting.android.base.ToolBarActivity;
import com.ximalaya.cloudting.android.fragment.CategoriesFragment;
import com.ximalaya.cloudting.android.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 主界面
 * <p>
 * Created by Chang.Xiao on 2017/6/6.
 *
 * @version 1.0
 */
public class MainActivity extends ToolBarActivity implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;
    @Bind(R.id.vp_content)
    ViewPager mVpContent;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.nav_podcasts);
        initFragmentList();
        initDrawerLayout();
    }

    private void initFragmentList() {
        List<String> mTitleList = new ArrayList<>(4);
        List<Fragment> mFragmentList = new ArrayList<>(4);
        mTitleList.add(getResources().getString(R.string.tab_podcasts));
        mTitleList.add(getResources().getString(R.string.tab_categories));
        mFragmentList.add(RecommendFragment.newInstance());
        mFragmentList.add(CategoriesFragment.newInstance());

        SimpleFragmentPagerAdapter simpleFragmentPagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList, mTitleList);
        mVpContent.setAdapter(simpleFragmentPagerAdapter);
        // 设置ViewPager最大缓存的页面个数(cpu消耗少)
        mVpContent.setOffscreenPageLimit(2);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED); // 固定的，标签很多时候会被挤压，不能滑动。
        mTabLayout.setupWithViewPager(mVpContent);
    }

    private void initDrawerLayout() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        search.collapseActionView();
        search.expandActionView();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_podcasts) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == R.id.nav_radio) {

        } else if (id == R.id.nav_subscribed) {

        } else if (id == R.id.nav_history) {

        } else if (id == R.id.nav_downloads) {

        } else if (id == R.id.nav_favorites) {

        } else if (id == R.id.nav_countries) {

        } else if (id == R.id.nav_rate_this_app) {

        } else if (id == R.id.nav_share_to_friends) {

        } else if (id == R.id.nav_report_a_problem) {

        } else if (id == R.id.nav_setting) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//        switch (position) {
//            case 0:
//                ivTitleGank.setSelected(true);
//                ivTitleOne.setSelected(false);
//                ivTitleDou.setSelected(false);
//                break;
//            case 1:
//                ivTitleOne.setSelected(true);
//                ivTitleGank.setSelected(false);
//                ivTitleDou.setSelected(false);
//                break;
//            case 2:
//                ivTitleDou.setSelected(true);
//                ivTitleOne.setSelected(false);
//                ivTitleGank.setSelected(false);
//                break;
//        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
