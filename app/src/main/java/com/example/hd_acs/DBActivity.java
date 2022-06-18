package com.example.hd_acs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hd_acs.database2.ZakazAdapter;
import com.example.hd_acs.database2.ZakazContract;
import com.example.hd_acs.database2.ZakazDBHelper;

public class DBActivity extends AppCompatActivity {
    //create member variables
    private ZakazAdapter mAdapter;
    private SQLiteDatabase mDatabase;
    EditText model;
    EditText color;
    EditText amount;
    EditText material;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbactivity);

        ZakazDBHelper dbHelper = new ZakazDBHelper(this);
        //to add items to the database
        mDatabase = dbHelper.getWritableDatabase();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ZakazAdapter(this,getAllItems());
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

        //create variable for the buttons
        Button button_add1 = findViewById(R.id.button_add1);
        model = findViewById(R.id.model);
        color = findViewById(R.id.color);
        amount = findViewById(R.id.amount);
        material = findViewById(R.id.material);

        button_add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    private void addItem(){
        String model1 = model.getText().toString();
        String color1 = color.getText().toString();
        String amount1 = amount.getText().toString();
        String material1 = material.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put(ZakazContract.ZakazEntry.COLUMN_NAME,model1);
        cv.put(ZakazContract.ZakazEntry.COLUMN_AMOUNT,amount1);
        cv.put(ZakazContract.ZakazEntry.COLUMN_COLOR,color1);
        cv.put(ZakazContract.ZakazEntry.COLUMN_MATERIAL,material1);

        mDatabase.insert(ZakazContract.ZakazEntry.TABLE_NAME,null,cv);
        mAdapter.swapCursor(getAllItems());
        this.model.getText().clear();
        this.color.getText().clear();
        this.amount.getText().clear();
        this.material.getText().clear();
    }

    private void removeItem(long id){
        mDatabase.delete(ZakazContract.ZakazEntry.TABLE_NAME,
                ZakazContract.ZakazEntry._ID + "=" + id,null);
        mAdapter.swapCursor(getAllItems());
    }
    //returns a cursor
    private Cursor getAllItems(){
        return mDatabase.query(
                ZakazContract.ZakazEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ZakazContract.ZakazEntry.COLUMN_TIMESTAMP + " DESC"
        );

    }
}