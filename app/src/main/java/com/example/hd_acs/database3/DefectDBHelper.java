package com.example.hd_acs.database3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hd_acs.database3.DefectContract.*;

public class DefectDBHelper extends SQLiteOpenHelper {
    public static final String DATABASEA_NAME = "def.db";

    //name of the version
    public static final int DATABASE_VERSION = 1;


    public DefectDBHelper(Context context) {
        super(context, DATABASEA_NAME, null, DATABASE_VERSION);
    }

    @Override
    //called we we first create the database
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_GROCERYLIST_TABLE = "CREATE TABLE " +
                DefectEntry.TABLE_NAME + " (" +
                DefectEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DefectEntry.COLUMN_EMPLOEYY + " TEXT NOT NULL, " +
                DefectEntry.COLUMN_MATERIAL + " TEXT NOT NULL, " +
                DefectEntry.COLUMN_AMOUNT + " TEXT NOT NULL, " +
                DefectEntry.COLUMN_COLOR + " TEXT NOT NULL, " +
                DefectEntry.COLUMN_MODEL + " TEXT NOT NULL, " +
                DefectEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_GROCERYLIST_TABLE);

    }

    @Override
    //called when you want to increment the version number manualy;if you want to change the schema of the database
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DefectEntry.TABLE_NAME);
        onCreate(db);
    }
}
