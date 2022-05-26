package com.example.hd_acs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnWrkPrs, btnManufProd, btnStorage, btnManufProdCrt, btnStorageCrt,btnDefProd ,btnDefProdCrt;
    private ImageButton btnNavLeftOpener, btnNavRightOpener, btnNavLeftCloser, btnNavRightCloser, imgBtnOptions, imgBtnHome, imgBtnProfile;
    private FrameLayout navBarLeft, navBarRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrkPrs = (Button) findViewById(R.id.btnWrkPrs);
        btnManufProd = (Button) findViewById(R.id.btnManufProd);
        btnStorage = (Button) findViewById(R.id.btnStorage);
        btnManufProdCrt = (Button) findViewById(R.id.btnManufProdCrt);
        btnStorageCrt = (Button) findViewById(R.id.btnStorageCrt);
        btnDefProd = (Button) findViewById(R.id.btnDefProd);
        btnDefProdCrt = (Button) findViewById(R.id.btnDefProdCrt);

        btnNavLeftOpener = (ImageButton) findViewById(R.id.btnNavLeftOpener);
        btnNavRightOpener = (ImageButton) findViewById(R.id.btnNavRightOpener);
        btnNavLeftCloser = (ImageButton) findViewById(R.id.btnNavLeftCloser);
        btnNavRightCloser = (ImageButton) findViewById(R.id.btnNavLeftCloser);
        imgBtnOptions = (ImageButton) findViewById(R.id.imgBtnOptions);
        imgBtnHome = (ImageButton) findViewById(R.id.imgBtnHome);
        imgBtnProfile = (ImageButton) findViewById(R.id.imgBtnProfile);

        navBarLeft = (FrameLayout) findViewById(R.id.navBarLeft);
        navBarRight = (FrameLayout) findViewById(R.id.navBarRight);

        btnWrkPrs.setOnClickListener(this);
        btnManufProd.setOnClickListener(this);
        btnStorage.setOnClickListener(this);
        btnManufProdCrt.setOnClickListener(this);
        btnStorageCrt.setOnClickListener(this);
        btnDefProd.setOnClickListener(this);
        btnDefProdCrt.setOnClickListener(this);

        btnNavLeftOpener.setOnClickListener(this);
        btnNavRightOpener.setOnClickListener(this);
        btnNavLeftCloser.setOnClickListener(this);
        btnNavRightCloser.setOnClickListener(this);

        imgBtnOptions.setOnClickListener(this);
        imgBtnHome.setOnClickListener(this);
        imgBtnProfile.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWrkPrs:
                Intent actWPA = new Intent(MainActivity.this, WorkersProgressActivity.class);
                startActivity(actWPA);
                finish();
                break;
            case R.id.btnManufProd:
                Intent actMPA = new Intent(MainActivity.this, ManufacturedProductsActivity.class);
                startActivity(actMPA);
                finish();
                break;
            case R.id.btnStorage:
                Intent actSA = new Intent(MainActivity.this, StorageActivity.class);
                startActivity(actSA);
                finish();
                break;
            case R.id.btnManufProdCrt:
                Intent actMPCA = new Intent(MainActivity.this, ManufacturedProductsCreateActivity.class);
                startActivity(actMPCA);
                finish();
                break;
            case R.id.btnStorageCrt:
                Intent actSCA = new Intent(MainActivity.this, StorageCreateActivity.class);
                startActivity(actSCA);
                finish();
                break;
            case R.id.btnDefProd:
                Intent actDPA = new Intent(MainActivity.this, DefectProductsActivity.class);
                startActivity(actDPA);
                finish();
                break;
            case R.id.btnDefProdCrt:
                Intent actDPCA = new Intent(MainActivity.this, DefectProductsCreateActivity.class);
                startActivity(actDPCA);
                finish();
                break;
            case R.id.imgBtnHome:
                Intent actHome = new Intent(MainActivity.this, MainActivity.class);
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
            case R.id.btnNavLeftCloser:
                navBarRight.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void onImgBtnOptions(View view) {
    }

    public void onImgBtnProfile(View view) {
    }

    public void onImgBtnHome(View view) {
    }

}