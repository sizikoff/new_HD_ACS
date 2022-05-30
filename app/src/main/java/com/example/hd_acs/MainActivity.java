package com.example.hd_acs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnWrkPrs, btnManufProd, btnStorage, btnManufProdCrt, btnStorageCrt,btnDefProd ,btnDefProdCrt, btnPanama, btnHat, btnVisor, btnKartuz, btnCap, btnBeretFr, btnBeretVol, btnBeretCz, btnCapLinda, btnUshanka, btnJockeyka, btnJockeykaFurr, btnEightblade;
    private ImageButton btnNavLeftOpener, btnNavRightOpener, btnNavLeftCloser, btnNavRightCloser, imgBtnOptions, imgBtnHome, imgBtnProfile, imgBtnHatsOpener, imgBtnMerchOpener;
    private FrameLayout navBarLeft, navBarRight, layHats, layMerch;

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

        btnPanama = (Button) findViewById(R.id.btnPanama);
        btnHat = (Button) findViewById(R.id.btnHat);
        btnVisor = (Button) findViewById(R.id.btnVisor);
        btnKartuz = (Button) findViewById(R.id.btnKartuz);
        btnCap = (Button) findViewById(R.id.btnCap);
        btnBeretFr = (Button) findViewById(R.id.btnBeretFr);
        btnBeretVol = (Button) findViewById(R.id.btnBeretVol);
        btnBeretCz = (Button) findViewById(R.id.btnBeretCz);
        btnCapLinda = (Button) findViewById(R.id.btnCapLinda);
        btnUshanka = (Button) findViewById(R.id.btnUshanka);
        btnJockeyka = (Button) findViewById(R.id.btnJockeyka);
        btnJockeykaFurr = (Button) findViewById(R.id.btnJockeykaFurr);
        btnEightblade = (Button) findViewById(R.id.btnEightblade);

        btnDefProdCrt = (Button) findViewById(R.id.btnDefProdCrt);
        btnDefProdCrt = (Button) findViewById(R.id.btnDefProdCrt);
        btnDefProdCrt = (Button) findViewById(R.id.btnDefProdCrt);

        btnNavLeftOpener = (ImageButton) findViewById(R.id.btnNavLeftOpener);
        btnNavRightOpener = (ImageButton) findViewById(R.id.btnNavRightOpener);
        btnNavLeftCloser = (ImageButton) findViewById(R.id.btnNavLeftCloser);
        btnNavRightCloser = (ImageButton) findViewById(R.id.btnNavRightCloser);
        imgBtnOptions = (ImageButton) findViewById(R.id.imgBtnOptions);
        imgBtnHome = (ImageButton) findViewById(R.id.imgBtnHome);
        imgBtnProfile = (ImageButton) findViewById(R.id.imgBtnProfile);
        imgBtnHatsOpener = (ImageButton) findViewById(R.id.imgBtnHatsOpener);
        imgBtnMerchOpener = (ImageButton) findViewById(R.id.imgBtnMerchOpener);

        navBarLeft = (FrameLayout) findViewById(R.id.navBarLeft);
        navBarRight = (FrameLayout) findViewById(R.id.navBarRight);
        layHats = (FrameLayout) findViewById(R.id.layHats);
        layMerch = (FrameLayout) findViewById(R.id.layMerch);

        btnWrkPrs.setOnClickListener(this);
        btnManufProd.setOnClickListener(this);
        btnStorage.setOnClickListener(this);
        btnManufProdCrt.setOnClickListener(this);
        btnStorageCrt.setOnClickListener(this);
        btnDefProd.setOnClickListener(this);
        btnDefProdCrt.setOnClickListener(this);

        btnPanama.setOnClickListener(this);
        btnHat.setOnClickListener(this);
        btnVisor.setOnClickListener(this);
        btnKartuz.setOnClickListener(this);
        btnCap.setOnClickListener(this);
        btnBeretFr.setOnClickListener(this);
        btnBeretVol.setOnClickListener(this);
        btnBeretCz.setOnClickListener(this);
        btnCapLinda.setOnClickListener(this);
        btnUshanka.setOnClickListener(this);
        btnJockeyka.setOnClickListener(this);
        btnJockeykaFurr.setOnClickListener(this);

        btnNavLeftOpener.setOnClickListener(this);
        btnNavRightOpener.setOnClickListener(this);
        btnNavLeftCloser.setOnClickListener(this);
        btnNavRightCloser.setOnClickListener(this);

        imgBtnOptions.setOnClickListener(this);
        imgBtnHome.setOnClickListener(this);
        imgBtnProfile.setOnClickListener(this);

        imgBtnHatsOpener.setOnClickListener(this);
        imgBtnMerchOpener.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPanama:
                Intent actP = new Intent(MainActivity.this, HatsPanamaActivity.class);
                startActivity(actP);
                finish();
                break;
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

    public void onImgBtnOptions(View view) {
    }

    public void onImgBtnProfile(View view) {
    }

    public void onImgBtnHome(View view) {
    }

}