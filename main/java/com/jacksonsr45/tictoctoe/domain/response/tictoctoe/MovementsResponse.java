package com.jacksonsr45.tictoctoe.domain.response.tictoctoe;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MovementEntity;
import com.jacksonsr45.tictoctoe.domain.usecases.tictoctoe.Table;

public class MovementsResponse implements Parcelable {
    public Table table;
    public int id;
    public String matchId;
    public int line;
    public int column;
    public int value;

    public MovementsResponse(Cursor cursor, Table table) {
        this.table = table;
        this.id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        this.matchId = cursor.getString(cursor.getColumnIndexOrThrow("match_id"));
        this.line = cursor.getInt(cursor.getColumnIndexOrThrow("table_line"));
        this.column = cursor.getInt(cursor.getColumnIndexOrThrow("table_column"));
        this.value = cursor.getInt(cursor.getColumnIndexOrThrow("value"));
    }

    public MovementsResponse(MovementEntity entity) {
        this.table = entity.table;
        this.id = entity.id;
        this.matchId = entity.matchId;
        this.line = entity.line;
        this.column = entity.column;
        this.value = entity.value;
    }

    protected MovementsResponse(Parcel in) {
        id = in.readInt();
        matchId = in.readString();
        line = in.readInt();
        column = in.readInt();
        value = in.readInt();
    }

    public static final Creator<MovementsResponse> CREATOR = new Creator<MovementsResponse>() {
        @Override
        public MovementsResponse createFromParcel(Parcel in) {
            return new MovementsResponse(in);
        }

        @Override
        public MovementsResponse[] newArray(int size) {
            return new MovementsResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(matchId);
        dest.writeInt(line);
        dest.writeInt(column);
        dest.writeInt(value);
    }
}
