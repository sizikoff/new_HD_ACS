package com.example.hd_acs.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.hd_acs.database.ProductionContract.*;

public class ProductionDbHelper extends SQLiteOpenHelper {
    public static final String DATABASEA_NAME = "productionList.db";

    //name of the version
    public static final int DATABASE_VERSION = 1;


    public ProductionDbHelper(Context context) {
        super(context, DATABASEA_NAME, null, DATABASE_VERSION);
    }

    @Override
    //called we we first create the database
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_PRODLIST_TABLE = "CREATE TABLE " +
                ProductionEntry.TABLE_NAME + " (" +
                ProductionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ProductionEntry.COLUMN_EMPLOEYY + " TEXT NOT NULL, " +
                ProductionEntry.COLUMN_MATERIAL + " TEXT NOT NULL, " +
                ProductionEntry.COLUMN_AMOUNT + " TEXT NOT NULL, " +
                ProductionEntry.COLUMN_COLOR + " TEXT NOT NULL, " +
                ProductionEntry.COLUMN_MODEL + " TEXT NOT NULL, " +
                ProductionEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_PRODLIST_TABLE);

    }

    @Override
    //called when you want to increment the version number manualy;if you want to change the schema of the database
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +ProductionEntry.TABLE_NAME);
        onCreate(db);

    }
}