package com.example.hd_acs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ManufacturedProductsCreateActivity extends AppCompatActivity implements View.OnClickListener {

     private Button btnWrkPrs, btnManufProd, btnStorage, btnManufProdCrt, btnStorageCrt, btnCrtReport;
     private ImageButton btnNavRightOpener, btnNavRightCloser, imgBtnHome;
     private FrameLayout navBarLeft;
     private EditText edTxtModel, edTxtMaterial, edTxtColor, edTxtWorker, edTxtAmount;
     private DatabaseReference mDataBase;

     DBHelper dbHelper;

     private String ManufProd_KEY = "ManufProd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufactured_products_create);

        btnWrkPrs = (Button) findViewById(R.id.btnWrkPrs);
        btnManufProd = (Button) findViewById(R.id.btnManufProd);
        btnStorage = (Button) findViewById(R.id.btnStorage);
        btnManufProdCrt = (Button) findViewById(R.id.btnManufProdCrt);
        btnStorageCrt = (Button) findViewById(R.id.btnStorageCrt);
        btnCrtReport = (Button) findViewById(R.id.btnCrtReport);

        btnNavRightOpener = (ImageButton) findViewById(R.id.btnNavRightOpener);
        btnNavRightCloser = (ImageButton) findViewById(R.id.btnNavLeftCloser);
        imgBtnHome = (ImageButton) findViewById(R.id.imgBtnHome);

        navBarLeft = (FrameLayout) findViewById(R.id.navBarLeft);

        edTxtModel = (EditText) findViewById(R.id.edTxtModel);
        edTxtMaterial = (EditText) findViewById(R.id.edTxtMaterial);
        edTxtColor = (EditText) findViewById(R.id.edTxtColor);
        edTxtWorker = (EditText) findViewById(R.id.edTxtWorker);
        edTxtAmount = (EditText) findViewById(R.id.edTxtAmount);

        dbHelper = new DBHelper(this);

        mDataBase = FirebaseDatabase.getInstance().getReference(ManufProd_KEY);

        btnWrkPrs.setOnClickListener(this);
        btnManufProd.setOnClickListener(this);
        btnStorage.setOnClickListener(this);
        btnManufProdCrt.setOnClickListener(this);
        btnStorageCrt.setOnClickListener(this);
        btnCrtReport.setOnClickListener(this);

        btnNavRightOpener.setOnClickListener(this);
        btnNavRightCloser.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String model = edTxtModel.getText().toString();
        String material = edTxtMaterial.getText().toString();
        String color = edTxtColor.getText().toString();
        String worker = edTxtWorker.getText().toString();
        String amount = edTxtAmount.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValuse = new ContentValues();

        switch (v.getId()) {
            case R.id.btnWrkPrs:
                Intent actWPA = new Intent(ManufacturedProductsCreateActivity.this, WorkersProgressActivity.class);
                startActivity(actWPA);
                finish();
                break;
            case R.id.btnManufProd:
                Intent actMPA = new Intent(ManufacturedProductsCreateActivity.this, ManufacturedProductsActivity.class);
                startActivity(actMPA);
                finish();
                break;
            case R.id.btnStorage:
                Intent actSA = new Intent(ManufacturedProductsCreateActivity.this, StorageActivity.class);
                startActivity(actSA);
                finish();
                break;
            case R.id.btnManufProdCrt:
                Intent actMPCA = new Intent(ManufacturedProductsCreateActivity.this, ManufacturedProductsCreateActivity.class);
                startActivity(actMPCA);
                finish();
                break;
            case R.id.btnStorageCrt:
                Intent actSCA = new Intent(ManufacturedProductsCreateActivity.this, StorageCreateActivity.class);
                startActivity(actSCA);
                finish();
                break;
            case R.id.btnNavRightOpener:
                navBarLeft.setVisibility(View.VISIBLE);
                break;
            case R.id.btnNavLeftCloser:
                navBarLeft.setVisibility(View.INVISIBLE);
                break;
            case R.id.imgBtnHome:
                Intent homeBtn = new Intent(ManufacturedProductsCreateActivity.this, MainActivity.class);
                startActivity(homeBtn);
                finish();
                break;
        }
    }
}