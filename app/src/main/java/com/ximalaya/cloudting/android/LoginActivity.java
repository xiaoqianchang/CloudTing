package com.ximalaya.cloudting.android;

import android.view.View;
import android.widget.Toast;

import com.ximalaya.cloudting.android.base.BaseActivity;

import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getStatusBarColorResId() {
        return R.color.transparent;
    }

    @OnClick({R.id.img_google, R.id.img_facebook, R.id.img_line, R.id.img_twitter})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_google:
                Toast.makeText(this, "Login with google", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.img_facebook:
                Toast.makeText(this, "Login with facebook", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_line:
                Toast.makeText(this, "Login with line", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_twitter:
                Toast.makeText(this, "Login with twitter", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
