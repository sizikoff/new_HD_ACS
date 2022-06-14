package com.example.hd_acs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class HatsHatActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPanama, btnHat, btnVisor, btnKartuz, btnCap, btnBeretFr, btnBeretVol, btnBeretCz, btnCapLinda, btnUshanka, btnJockeyka, btnJockeykaFurr, btnEightblade;
    private ImageButton btnNavLeftOpener, btnNavLeftCloser, imgBtnOptions, imgBtnHome, imgBtnProfile, imgBtnHatsOpener, imgBtnMerchOpener;
    private FrameLayout navBarLeft, layHats, layMerch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hats_hat);

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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPanama:
                Intent actP = new Intent(HatsHatActivity.this, HatsPanamaActivity.class);
                startActivity(actP);
                finish();
                break;
            case R.id.imgBtnHome:
                Intent actHome = new Intent(HatsHatActivity.this, MainActivity2.class);
                startActivity(actHome);
                finish();
                break;
            case R.id.btnNavLeftOpener:
                navBarLeft.setVisibility(View.VISIBLE);
                break;
            case R.id.btnNavLeftCloser:
                navBarLeft.setVisibility(View.INVISIBLE);
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