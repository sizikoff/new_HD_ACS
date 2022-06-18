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
import android.widget.Toast;

import com.example.hd_acs.database.ProductionDbHelper;
import com.example.hd_acs.database3.DefectContract.*;
import com.example.hd_acs.database3.DefectDBHelper;


public class DefectProductsCreateActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnWrkPrs, btnManufProd, btnStorage, btnManufProdCrt, btnStorageCrt,btnDefProd ,btnDefProdCrt,btnCrtReport;
    private ImageButton btnNavRightOpener, btnNavLeftCloser, imgBtnOptions, imgBtnHome, imgBtnProfile;
    private FrameLayout navBarLeft;

    EditText edTxtModel,edTxtMaterial,edTxtColor,edTxtWorker,edTxtAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defect_products_create);

        btnWrkPrs = (Button) findViewById(R.id.btnDefProd);
        btnManufProd = (Button) findViewById(R.id.btnManufProd);
        btnStorage = (Button) findViewById(R.id.btnStorage);
        btnManufProdCrt = (Button) findViewById(R.id.btnManufProdCrt);
        btnStorageCrt = (Button) findViewById(R.id.btnStorageCrt);
        btnDefProd = (Button) findViewById(R.id.btnDefProd);
        btnDefProdCrt = (Button) findViewById(R.id.btnDefProdCrt);

        btnNavRightOpener = (ImageButton) findViewById(R.id.btnNavLeftOpener);
        btnNavLeftCloser = (ImageButton) findViewById(R.id.btnNavLeftCloser);
        imgBtnOptions = (ImageButton) findViewById(R.id.imgBtnOptions);
        imgBtnHome = (ImageButton) findViewById(R.id.imgBtnHome);
        imgBtnProfile = (ImageButton) findViewById(R.id.imgBtnProfile);
        btnCrtReport =  findViewById(R.id.btnCrtReport);

        edTxtModel =  findViewById(R.id.edTxtModel);
        edTxtMaterial =  findViewById(R.id.edTxtMaterial);
        edTxtColor =  findViewById(R.id.edTxtColor);
        edTxtWorker =  findViewById(R.id.edTxtWorker);
        edTxtAmount =  findViewById(R.id.edTxtAmount);

        navBarLeft = (FrameLayout) findViewById(R.id.navBarLeft);

        btnWrkPrs.setOnClickListener(this);
        btnManufProd.setOnClickListener(this);
        btnStorage.setOnClickListener(this);
        btnManufProdCrt.setOnClickListener(this);
        btnStorageCrt.setOnClickListener(this);
        btnDefProd.setOnClickListener(this);
        btnDefProdCrt.setOnClickListener(this);

        btnNavRightOpener.setOnClickListener(this);
        btnNavLeftCloser.setOnClickListener(this);

        imgBtnOptions.setOnClickListener(this);
        imgBtnHome.setOnClickListener(this);
        imgBtnProfile.setOnClickListener(this);

        btnCrtReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DefectDBHelper dbHelper = new DefectDBHelper(DefectProductsCreateActivity.this);
                SQLiteDatabase mDatabase = dbHelper.getWritableDatabase();
                String model = edTxtModel.getText().toString();
                String material = edTxtMaterial.getText().toString();
                String color = edTxtColor.getText().toString();
                String worker = edTxtWorker.getText().toString();
                String amount = edTxtAmount.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put(DefectEntry.COLUMN_MODEL,model);
                cv.put(DefectEntry.COLUMN_MATERIAL,material);
                cv.put(DefectEntry.COLUMN_COLOR,color);
                cv.put(DefectEntry.COLUMN_EMPLOEYY,worker);
                cv.put(DefectEntry.COLUMN_AMOUNT,amount);
                mDatabase.insert(DefectEntry.TABLE_NAME,null,cv);
                System.out.println(mDatabase.insert(DefectEntry.TABLE_NAME,null,cv));
                edTxtModel.getText().clear();
                edTxtMaterial.getText().clear();
                edTxtColor.getText().clear();
                edTxtWorker.getText().clear();
                edTxtAmount.getText().clear();
                Toast.makeText(DefectProductsCreateActivity.this, "Отчет создан", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWrkPrs:
                Intent actWPA = new Intent(DefectProductsCreateActivity.this, WorkersProgressActivity.class);
                startActivity(actWPA);
                finish();
                break;
            case R.id.btnManufProd:
                Intent actMPA = new Intent(DefectProductsCreateActivity.this, ManufacturedProductsActivity.class);
                startActivity(actMPA);
                finish();
                break;
            case R.id.btnStorage:
                Intent actSA = new Intent(DefectProductsCreateActivity.this, StorageActivity.class);
                startActivity(actSA);
                finish();
                break;
            case R.id.btnManufProdCrt:
                Intent actMPCA = new Intent(DefectProductsCreateActivity.this, ManufacturedProductsCreateActivity.class);
                startActivity(actMPCA);
                finish();
                break;
            case R.id.btnStorageCrt:
                Intent actSCA = new Intent(DefectProductsCreateActivity.this, StorageCreateActivity.class);
                startActivity(actSCA);
                finish();
                break;
            case R.id.btnDefProd:
                Intent actDPA = new Intent(DefectProductsCreateActivity.this, DefectProductsActivity.class);
                startActivity(actDPA);
                finish();
                break;
            case R.id.btnDefProdCrt:
                Intent actDPCA = new Intent(DefectProductsCreateActivity.this, DefectProductsCreateActivity.class);
                startActivity(actDPCA);
                finish();
                break;
            case R.id.imgBtnHome:
                Intent actHome = new Intent(DefectProductsCreateActivity.this, MainActivity2.class);
                startActivity(actHome);
                finish();
                break;
            case R.id.btnNavRightOpener:
                navBarLeft.setVisibility(View.VISIBLE);
                break;
            case R.id.btnNavLeftCloser:
                navBarLeft.setVisibility(View.INVISIBLE);
                break;
        }
    }
}