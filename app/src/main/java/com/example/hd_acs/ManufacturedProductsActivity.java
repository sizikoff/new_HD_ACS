package com.example.hd_acs;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.example.hd_acs.database.ProdAdapter;
import com.example.hd_acs.database.ProductionContract;
import com.example.hd_acs.database.ProductionDbHelper;

public class ManufacturedProductsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnWrkPrs, btnManufProd, btnStorage, btnManufProdCrt, btnStorageCrt,btnDefProd ,btnDefProdCrt;
    private ImageButton btnNavLeftOpener, btnNavLeftCloser, imgBtnOptions, imgBtnHome, imgBtnProfile;
    private FrameLayout navBarLeft;
    RecyclerView recyclerView;
    private ProdAdapter mAdapter;
    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manufactured_products);
        ProductionDbHelper dbHelper = new ProductionDbHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        btnWrkPrs = (Button) findViewById(R.id.btnDefProd);
        btnManufProd = (Button) findViewById(R.id.btnManufProd);
        btnStorage = (Button) findViewById(R.id.btnStorage);
        btnManufProdCrt = (Button) findViewById(R.id.btnManufProdCrt);
        btnStorageCrt = (Button) findViewById(R.id.btnStorageCrt);
        btnDefProd = (Button) findViewById(R.id.btnDefProd);
        btnDefProdCrt = (Button) findViewById(R.id.btnDefProdCrt);
        recyclerView = findViewById(R.id.manufRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ProdAdapter(this,getAllItems());
        mAdapter.swapCursor(getAllItems());
        recyclerView.setAdapter(mAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;

            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                removeItem((long) viewHolder.itemView.getTag());

            }
        }).attachToRecyclerView(recyclerView);

        btnNavLeftOpener = (ImageButton) findViewById(R.id.btnNavLeftOpener);
        btnNavLeftCloser = (ImageButton) findViewById(R.id.btnNavLeftCloser);
        imgBtnOptions = (ImageButton) findViewById(R.id.imgBtnOptions);
        imgBtnHome = (ImageButton) findViewById(R.id.imgBtnHome);
        imgBtnProfile = (ImageButton) findViewById(R.id.imgBtnProfile);

        navBarLeft = (FrameLayout) findViewById(R.id.navBarLeft);

        btnWrkPrs.setOnClickListener(this);
        btnManufProd.setOnClickListener(this);
        btnStorage.setOnClickListener(this);
        btnManufProdCrt.setOnClickListener(this);
        btnStorageCrt.setOnClickListener(this);
        btnDefProd.setOnClickListener(this);
        btnDefProdCrt.setOnClickListener(this);

        btnNavLeftOpener.setOnClickListener(this);
        btnNavLeftCloser.setOnClickListener(this);

        imgBtnOptions.setOnClickListener(this);
        imgBtnHome.setOnClickListener(this);
        imgBtnProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWrkPrs:
                Intent actWPA = new Intent(ManufacturedProductsActivity.this, WorkersProgressActivity.class);
                startActivity(actWPA);
                finish();
                break;
            case R.id.btnManufProd:
                Intent actMPA = new Intent(ManufacturedProductsActivity.this, ManufacturedProductsActivity.class);
                startActivity(actMPA);
                finish();
                break;
            case R.id.btnStorage:
                Intent actSA = new Intent(ManufacturedProductsActivity.this, StorageActivity.class);
                startActivity(actSA);
                finish();
                break;
            case R.id.btnManufProdCrt:
                Intent actMPCA = new Intent(ManufacturedProductsActivity.this, ManufacturedProductsCreateActivity.class);
                startActivity(actMPCA);
                finish();
                break;
            case R.id.btnStorageCrt:
                Intent actSCA = new Intent(ManufacturedProductsActivity.this, StorageCreateActivity.class);
                startActivity(actSCA);
                finish();
                break;
            case R.id.btnDefProd:
                Intent actDPA = new Intent(ManufacturedProductsActivity.this, DefectProductsActivity.class);
                startActivity(actDPA);
                finish();
                break;
            case R.id.btnDefProdCrt:
                Intent actDPCA = new Intent(ManufacturedProductsActivity.this, DefectProductsCreateActivity.class);
                startActivity(actDPCA);
                finish();
                break;
            case R.id.imgBtnHome:
                Intent actHome = new Intent(ManufacturedProductsActivity.this, MainActivity2.class);
                startActivity(actHome);
                finish();
                break;
            case R.id.btnNavLeftOpener:
                navBarLeft.setVisibility(View.VISIBLE);
                break;
            case R.id.btnNavLeftCloser:
                navBarLeft.setVisibility(View.INVISIBLE);
                break;
        }
    }

    private void removeItem(long id){
        mDatabase.delete(ProductionContract.ProductionEntry.TABLE_NAME,
                ProductionContract.ProductionEntry._ID + "=" + id,null);
        mAdapter.swapCursor(getAllItems());
    }
    //returns a cursor
    private Cursor getAllItems(){
        return mDatabase.query(
                ProductionContract.ProductionEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ProductionContract.ProductionEntry.COLUMN_TIMESTAMP + " DESC"
        );

    }
}