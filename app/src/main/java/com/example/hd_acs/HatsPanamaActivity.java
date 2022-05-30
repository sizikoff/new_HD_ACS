package com.example.hd_acs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class HatsPanamaActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ;
    private ImageButton btnNavLeftOpener, btnNavLeftCloser, imgBtnOptions, imgBtnHome, imgBtnProfile, imgBtnHatsOpener, imgBtnMerchOpener;
    private FrameLayout navBarLeft, layHats, layMerch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hats_panama);

        btnNavLeftOpener = (ImageButton) findViewById(R.id.btnNavLeftOpener);
        btnNavLeftCloser = (ImageButton) findViewById(R.id.btnNavLeftCloser);
        imgBtnOptions = (ImageButton) findViewById(R.id.imgBtnOptions);
        imgBtnHome = (ImageButton) findViewById(R.id.imgBtnHome);
        imgBtnProfile = (ImageButton) findViewById(R.id.imgBtnProfile);
        imgBtnHatsOpener = (ImageButton) findViewById(R.id.imgBtnHatsOpener);
        imgBtnMerchOpener = (ImageButton) findViewById(R.id.imgBtnMerchOpener);

        navBarLeft = (FrameLayout) findViewById(R.id.navBarLeft);
        layHats = (FrameLayout) findViewById(R.id.layHats);
        layMerch = (FrameLayout) findViewById(R.id.layMerch);

        btnNavLeftOpener.setOnClickListener(this);
        btnNavLeftCloser.setOnClickListener(this);

        imgBtnOptions.setOnClickListener(this);
        imgBtnHome.setOnClickListener(this);
        imgBtnProfile.setOnClickListener(this);

        imgBtnHatsOpener.setOnClickListener(this);
        imgBtnMerchOpener.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.imgBtnHome:
                Intent actHome = new Intent(HatsPanamaActivity.this, MainActivity.class);
                startActivity(actHome);
                finish();
                break;
            case R.id.btnNavLeftOpener:
                navBarLeft.setVisibility(View.VISIBLE);
                navBarRight.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnNavRightOpener:
                navBarRight.setVisibility(View.VISIBLE);
                navBarLeft.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnNavLeftCloser:
                navBarLeft.setVisibility(View.INVISIBLE);
                break;
            case R.id.btnNavRightCloser:
                navBarRight.setVisibility(View.INVISIBLE);
                break;
            case R.id.imgBtnHatsOpener:
                if (layHats.getVisibility() == View.GONE){
                    layHats.setVisibility(View.VISIBLE);
                } else {
                    layHats.setVisibility(View.GONE);
                }
                break;
            case R.id.imgBtnMerchOpener:
                if (layMerch.getVisibility() == View.GONE){
                    layMerch.setVisibility(View.VISIBLE);
                } else {
                    layMerch.setVisibility(View.GONE);
                }
                break;
        }
    }
}