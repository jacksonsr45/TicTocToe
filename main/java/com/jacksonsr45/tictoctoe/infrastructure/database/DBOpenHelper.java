package com.jacksonsr45.tictoctoe.infrastructure.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context) {
        super(context, "tic_toc_toe", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ScriptDLL.getCreateTablePlayer());
        db.execSQL(ScriptDLL.getCreateTablePlayerHistory());
        db.execSQL(ScriptDLL.getCreateTableMatch());
        db.execSQL(ScriptDLL.getCreateTableMovements());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
