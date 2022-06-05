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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Data> arrayList;
    private ImageButton imgBtnHatsAdd;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();

        arrayList.add(new Data("Шапка"));
        arrayList.add(new Data("Шляпа"));
        arrayList.add(new Data("Кепка"));

        imgBtnHatsAdd = findViewById(R.id.imgBtnHatsAdd);
        recyclerView = findViewById(R.id.recicler);
        recyclerAdapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));

        imgBtnHatsAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Добавление");
                alert.setMessage("Введите название головного убора");
                final EditText input = new EditText(MainActivity.this);
                alert.setView(input);

                alert.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = input.getText().toString();
                        arrayList.add(new Data(value));
                        recyclerAdapter = new RecyclerAdapter(arrayList);
                        recyclerView.setAdapter(recyclerAdapter);
                        Toast.makeText(MainActivity.this, value + " добавлен(а) в список", Toast.LENGTH_SHORT).show();
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