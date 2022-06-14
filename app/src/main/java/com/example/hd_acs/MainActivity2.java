package com.example.hd_acs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<Data> arrayList;
    private ImageButton imgBtnHatsAdd, imgBtnMerchOpener, menu_lock_but, btnNavRightOpener, btnNavRightCloser, imgBtnHome;
    private Button btnWrkPrs, btnManufProd, btnStorage, btnManufProdCrt, btnStorageCrt,btnDefProd ,btnDefProdCrt;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayout osn_info, layLeft_menu;
    private FrameLayout navBarRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        arrayList = new ArrayList<>();

        arrayList.add(new Data("Панама"));
        arrayList.add(new Data("Шляпа"));
        arrayList.add(new Data("Козырёк"));
        arrayList.add(new Data("Картуз"));
        arrayList.add(new Data("Ушанка"));
        arrayList.add(new Data("Кепка"));
        arrayList.add(new Data("Французский берет"));
        arrayList.add(new Data("Объемный берет"));
        arrayList.add(new Data("Берет Чехия"));
        arrayList.add(new Data("Кепка Линда"));
        arrayList.add(new Data("Жокейка"));
        arrayList.add(new Data("Жокейка с мех. ушами"));
        arrayList.add(new Data("Восьмиклинка"));

        btnWrkPrs = (Button) findViewById(R.id.btnWrkPrs);
        btnManufProd = (Button) findViewById(R.id.btnManufProd);
        btnStorage = (Button) findViewById(R.id.btnStorage);
        btnManufProdCrt = (Button) findViewById(R.id.btnManufProdCrt);
        btnStorageCrt = (Button) findViewById(R.id.btnStorageCrt);
        btnDefProd = (Button) findViewById(R.id.btnDefProd);
        btnDefProdCrt = (Button) findViewById(R.id.btnDefProdCrt);

        imgBtnHatsAdd = findViewById(R.id.imgBtnHatsAdd);
        menu_lock_but = findViewById(R.id.menu_lock_but);
        btnNavRightCloser = findViewById(R.id.btnNavRightCloser);
        btnNavRightOpener = findViewById(R.id.btnNavRightOpener);
        imgBtnHome = findViewById(R.id.imgBtnHome);
        osn_info = findViewById(R.id.osn_info);
        layLeft_menu = findViewById(R.id.layLeft_menu);
        navBarRight = findViewById(R.id.navBarRight);
        imgBtnMerchOpener = findViewById(R.id.imgBtnMerchOpener);
        recyclerAdapter = new RecyclerAdapter(this, arrayList);
        recyclerView = findViewById(R.id.recicler);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));

        btnWrkPrs.setOnClickListener(this);
        btnManufProd.setOnClickListener(this);
        btnStorage.setOnClickListener(this);
        btnManufProdCrt.setOnClickListener(this);
        btnStorageCrt.setOnClickListener(this);
        btnDefProd.setOnClickListener(this);
        btnDefProdCrt.setOnClickListener(this);

        menu_lock_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layLeft_menu.setVisibility(View.GONE);
                btnNavRightOpener.setVisibility(View.VISIBLE);
                osn_info.setVisibility(View.VISIBLE);
                imgBtnMerchOpener.setVisibility(View.VISIBLE);
            }
        });

        imgBtnMerchOpener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layLeft_menu.setVisibility(View.VISIBLE);
                btnNavRightOpener.setVisibility(View.GONE);
                osn_info.setVisibility(View.GONE);
                imgBtnMerchOpener.setVisibility(View.GONE);
            }
        });
        btnNavRightOpener.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                navBarRight.setVisibility(View.VISIBLE);
                btnNavRightOpener.setVisibility(View.GONE);
                osn_info.setVisibility(View.GONE);
                imgBtnMerchOpener.setVisibility(View.GONE);
            }
        });
        btnNavRightCloser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navBarRight.setVisibility(View.GONE);
                btnNavRightOpener.setVisibility(View.VISIBLE);
                osn_info.setVisibility(View.VISIBLE);
                imgBtnMerchOpener.setVisibility(View.VISIBLE);
            }
        });
        imgBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BH = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(BH);
            }
        });

        imgBtnHatsAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Добавление");
                alert.setMessage("Введите название головного убора");
                final EditText input = new EditText(MainActivity2.this);
                alert.setView(input);

                alert.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = input.getText().toString();
                        arrayList.add(new Data(value));
                        recyclerAdapter = new RecyclerAdapter(MainActivity2.this, arrayList);
                        recyclerView.setAdapter(recyclerAdapter);
                        Toast.makeText(MainActivity2.this, value + " добавлен(а) в список", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });

                alert.show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWrkPrs:
                Intent actWPA = new Intent(MainActivity2.this, WorkersProgressActivity.class);
                startActivity(actWPA);
                finish();
                break;
            case R.id.btnManufProd:
                Intent actMPA = new Intent(MainActivity2.this, ManufacturedProductsActivity.class);
                startActivity(actMPA);
                finish();
                break;
            case R.id.btnStorage:
                Intent actSA = new Intent(MainActivity2.this, StorageActivity.class);
                startActivity(actSA);
                finish();
                break;
            case R.id.btnManufProdCrt:
                Intent actMPCA = new Intent(MainActivity2.this, ManufacturedProductsCreateActivity.class);
                startActivity(actMPCA);
                finish();
                break;
            case R.id.btnStorageCrt:
                Intent actSCA = new Intent(MainActivity2.this, StorageCreateActivity.class);
                startActivity(actSCA);
                finish();
                break;
            case R.id.btnDefProd:
                Intent actDPA = new Intent(MainActivity2.this, DefectProductsActivity.class);
                startActivity(actDPA);
                finish();
                break;
            case R.id.btnDefProdCrt:
                Intent actDPCA = new Intent(MainActivity2.this, DefectProductsCreateActivity.class);
                startActivity(actDPCA);
                finish();
                break;
            case R.id.imgBtnHome:
                Intent actHome = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(actHome);
                finish();
                break;
        }
    }
}