package com.ximalaya.cloudting.android.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ximalaya.cloudting.android.R;
import com.ximalaya.cloudting.android.utils.SystemUtils;

import butterknife.Bind;

/**
 * 带Toolbar自定义Title的基类Activity
 * <p>
 * Created by Chang.Xiao on 2017/6/7.
 *
 * @version 1.0
 */

public abstract class ToolBarActivity extends BaseActivity {

    @Bind(R.id.app_bar_layout)
    protected AppBarLayout mAppBarLayout;
    @Bind(R.id.status_bar)
    protected View mStatusBar;
    @Bind(R.id.toolBar)
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatusBar();
        initToolBar();
    }

    protected void initStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mStatusBar.setVisibility(View.VISIBLE);
            mStatusBar.getLayoutParams().height = SystemUtils.getStatusHeight(this);
            mStatusBar.setLayoutParams(mStatusBar.getLayoutParams());
        } else {
            mStatusBar.setVisibility(View.GONE);
        }
    }

    protected void initToolBar() {
        if (null == mAppBarLayout || null == mToolbar) {
            throw new IllegalStateException("The subclass of ToolbarActivity must contain a toolbar.");
        }
        mToolbar.setOnClickListener(v -> onToolbarClick());
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(canBack()); // 设置返回箭头
        }
        if (Build.VERSION.SDK_INT >= 21) {
            mAppBarLayout.setElevation(1f);
        }
    }

    /**
     * onToolbarClick
     */
    protected void onToolbarClick() {
        // empty
    }

    /**
     * 设置 NavigationButton 是否可见
     *
     * @return
     */
    protected boolean canBack() {
        return false;
    }
}
