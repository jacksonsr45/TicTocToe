package com.jacksonsr45.tictoctoe.infrastructure.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE = "tic_toc_toe";
    public static final int DATABASE_VERSION = 1;

    public DBOpenHelper(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.beginTransaction();
        try {
            db.execSQL(ScriptDLL.getCreateTablePlayer());
            db.execSQL(ScriptDLL.getCreateTablePlayerHistory());
            db.execSQL(ScriptDLL.getCreateTableMatch());
            db.execSQL(ScriptDLL.getCreateTableMovements());
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
