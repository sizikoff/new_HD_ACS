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

import com.example.hd_acs.database3.DefectAdapter;
import com.example.hd_acs.database3.DefectDBHelper;
import com.example.hd_acs.database4.StorageAdapter;
import com.example.hd_acs.database4.StorageContract;
import com.example.hd_acs.database4.StorageDBHelper;

public class StorageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnWrkPrs, btnManufProd, btnStorage, btnManufProdCrt, btnStorageCrt,btnDefProd ,btnDefProdCrt;
    private ImageButton btnNavLeftOpener, btnNavLeftCloser, imgBtnOptions, imgBtnHome, imgBtnProfile;
    private FrameLayout navBarLeft;
    RecyclerView recyclerView;
    private StorageAdapter mAdapter;
    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        StorageDBHelper dbHelper = new StorageDBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        btnWrkPrs = (Button) findViewById(R.id.btnDefProd);
        btnManufProd = (Button) findViewById(R.id.btnManufProd);
        btnStorage = (Button) findViewById(R.id.btnStorage);
        btnManufProdCrt = (Button) findViewById(R.id.btnManufProdCrt);
        btnStorageCrt = (Button) findViewById(R.id.btnStorageCrt);
        btnDefProd = (Button) findViewById(R.id.btnDefProd);
        btnDefProdCrt = (Button) findViewById(R.id.btnDefProdCrt);

        btnNavLeftOpener = (ImageButton) findViewById(R.id.btnNavLeftOpener);
        btnNavLeftCloser = (ImageButton) findViewById(R.id.btnNavLeftCloser);
        imgBtnOptions = (ImageButton) findViewById(R.id.imgBtnOptions);
        imgBtnHome = (ImageButton) findViewById(R.id.imgBtnHome);
        imgBtnProfile = (ImageButton) findViewById(R.id.imgBtnProfile);

        navBarLeft = (FrameLayout) findViewById(R.id.navBarLeft);

        recyclerView = findViewById(R.id.storageRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new StorageAdapter(this,getAllItems());
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
                Intent actWPA = new Intent(StorageActivity.this, WorkersProgressActivity.class);
                startActivity(actWPA);
                finish();
                break;
            case R.id.btnManufProd:
                Intent actMPA = new Intent(StorageActivity.this, ManufacturedProductsActivity.class);
                startActivity(actMPA);
                finish();
                break;
            case R.id.btnStorage:
                Intent actSA = new Intent(StorageActivity.this, StorageActivity.class);
                startActivity(actSA);
                finish();
                break;
            case R.id.btnManufProdCrt:
                Intent actMPCA = new Intent(StorageActivity.this, ManufacturedProductsCreateActivity.class);
                startActivity(actMPCA);
                finish();
                break;
            case R.id.btnStorageCrt:
                Intent actSCA = new Intent(StorageActivity.this, StorageCreateActivity.class);
                startActivity(actSCA);
                finish();
                break;
            case R.id.btnDefProd:
                Intent actDPA = new Intent(StorageActivity.this, DefectProductsActivity.class);
                startActivity(actDPA);
                finish();
                break;
            case R.id.btnDefProdCrt:
                Intent actDPCA = new Intent(StorageActivity.this, DefectProductsCreateActivity.class);
                startActivity(actDPCA);
                finish();
                break;
            case R.id.imgBtnHome:
                Intent actHome = new Intent(StorageActivity.this, MainActivity2.class);
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
        mDatabase.delete(StorageContract.StorageEntry.TABLE_NAME,
                StorageContract.StorageEntry._ID + "=" + id,null);
        mAdapter.swapCursor(getAllItems());
    }
    //returns a cursor
    private Cursor getAllItems(){
        return mDatabase.query(
                StorageContract.StorageEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                StorageContract.StorageEntry.COLUMN_TIMESTAMP + " DESC"
        );

    }
}