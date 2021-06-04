package com.jacksonsr45.tictoctoe.infrastructure.factory;

import android.app.AlertDialog;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.jacksonsr45.tictoctoe.infrastructure.database.DBOpenHelper;
import com.jacksonsr45.tictoctoe.userinterface.activity.R;

public class DBFactory {
    private SQLiteDatabase connection;
    private DBOpenHelper dbOpenHelper;
    private Context context;

    public DBFactory(Context context) {
        this.context = context;
    }

    public SQLiteDatabase getConnection() {
        try {
            this.dbOpenHelper = new DBOpenHelper(this.context);
            this.connection = this.dbOpenHelper.getWritableDatabase();
        } catch (SQLException exception) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this.context);
            dialog.setTitle(R.string.dialog_title_error);
            dialog.setMessage(exception.getMessage());
            dialog.setNeutralButton(R.string.action_ok, null);
            dialog.show();
        }
        return this.connection;
    }
}
