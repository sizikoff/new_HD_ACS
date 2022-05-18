package com.example.hd_acs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HD_ACS";
    public static final String TABLE_MNFPRODCRT = "MnfProdCrt";

    public static final String KEY_ID = "_id";
    public static final String KEY_MODEL = "model";
    public static final String KEY_MATERIAL = "material";
    public static final String KEY_COLOR = "color";
    public static final String KEY_WORKER = "worker";
    public static final String KEY_AMOUNT = "amount";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_MNFPRODCRT + "(" + KEY_ID + "integer primary key,"
                + KEY_MODEL + "text," + KEY_MATERIAL + "text," + KEY_COLOR + "text," + KEY_WORKER + "text," + KEY_AMOUNT + "text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_MNFPRODCRT);

        onCreate(db);
    }
}
