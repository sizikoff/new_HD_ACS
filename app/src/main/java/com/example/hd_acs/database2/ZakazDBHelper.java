package com.example.hd_acs.database2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hd_acs.database2.ZakazContract.*;

public class ZakazDBHelper extends SQLiteOpenHelper {
    //create two constants
    //name of the database
    public static final String DATABASEA_NAME = "zakaz.db";

    //name of the version
    public static final int DATABASE_VERSION = 1;


    public ZakazDBHelper(Context context) {
        super(context, DATABASEA_NAME, null, DATABASE_VERSION);
    }

    @Override
    //called we we first create the database
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_GROCERYLIST_TABLE = "CREATE TABLE " +
               ZakazEntry.TABLE_NAME + " (" +
                ZakazEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ZakazEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                ZakazEntry.COLUMN_MATERIAL + " TEXT NOT NULL, " +
                ZakazEntry.COLUMN_AMOUNT + " TEXT NOT NULL, " +
                ZakazEntry.COLUMN_COLOR + " TEXT NOT NULL, " +
                ZakazEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_GROCERYLIST_TABLE);

    }

    @Override
    //called when you want to increment the version number manualy;if you want to change the schema of the database
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ZakazEntry.TABLE_NAME);
        onCreate(db);
    }
}
