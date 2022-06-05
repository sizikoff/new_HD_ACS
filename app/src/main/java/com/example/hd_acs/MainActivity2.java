package com.example.hd_acs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Data> arrayList;
    private ImageButton imgBtnHatsAdd, imgBtnMerchOpener, menu_lock_but, btnNavRightOpener;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayout osn_info;
    private ScrollView left_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        arrayList = new ArrayList<>();

        arrayList.add(new Data("Панама"));
        arrayList.add(new Data("Шляпа"));
        arrayList.add(new Data("Козырёк"));
        arrayList.add(new Data("Картуз"));
        arrayList.add(new Data("Кепка"));
        arrayList.add(new Data("Французский берет"));
        arrayList.add(new Data("Объемный берет"));
        arrayList.add(new Data("Берет Чехия"));
        arrayList.add(new Data("Кепка Линда"));
        arrayList.add(new Data("Ушанка"));
        arrayList.add(new Data("Жокейка"));
        arrayList.add(new Data("Жокейка с мех. ушами"));
        arrayList.add(new Data("Восьмиклинка"));

        imgBtnHatsAdd = findViewById(R.id.imgBtnHatsAdd);
        menu_lock_but = findViewById(R.id.menu_lock_but);
        btnNavRightOpener = findViewById(R.id.btnNavRightOpener);
        osn_info = findViewById(R.id.osn_info);
        left_menu = findViewById(R.id.left_menu);
        imgBtnMerchOpener = findViewById(R.id.imgBtnMerchOpener);
        recyclerView = findViewById(R.id.recicler);
        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));

        menu_lock_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left_menu.setVisibility(View.GONE);
                btnNavRightOpener.setVisibility(View.VISIBLE);
                osn_info.setVisibility(View.VISIBLE);
                menu_lock_but.setVisibility(View.GONE);
                imgBtnMerchOpener.setVisibility(View.VISIBLE);
            }
        });

        imgBtnMerchOpener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left_menu.setVisibility(View.VISIBLE);
                btnNavRightOpener.setVisibility(View.GONE);
                osn_info.setVisibility(View.GONE);
                menu_lock_but.setVisibility(View.VISIBLE);
                imgBtnMerchOpener.setVisibility(View.GONE);
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
                        recyclerAdapter = new RecyclerAdapter(arrayList);
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
}