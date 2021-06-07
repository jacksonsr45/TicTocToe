package com.jacksonsr45.tictoctoe.domain.response.tictoctoe;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.MatchEntity;

public class MatchResponse implements Parcelable {
    public String id;
    public String playersHistoryId;
    public int level;
    public int result;
    public String createdAt;

    public MatchResponse(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
        this.playersHistoryId = cursor.getString(cursor.getColumnIndexOrThrow("player_history_id"));
        this.level = cursor.getInt(cursor.getColumnIndexOrThrow("level"));
        this.result = cursor.getInt(cursor.getColumnIndexOrThrow("result"));
        this.createdAt = cursor.getString(cursor.getColumnIndexOrThrow("created_at"));;
    }

    public MatchResponse(MatchEntity entity) {
        this.id = entity.id;
        this.playersHistoryId = entity.playersHistoryId;
        this.level = entity.level;
        this.result = entity.result;
        this.createdAt = entity.createdAt;
    }

    protected MatchResponse(Parcel in) {
        id = in.readString();
        playersHistoryId = in.readString();
        level = in.readInt();
        result = in.readInt();
        createdAt = in.readString();
    }

    public static final Creator<MatchResponse> CREATOR = new Creator<MatchResponse>() {
        @Override
        public MatchResponse createFromParcel(Parcel in) {
            return new MatchResponse(in);
        }

        @Override
        public MatchResponse[] newArray(int size) {
            return new MatchResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(playersHistoryId);
        dest.writeInt(level);
        dest.writeInt(result);
        dest.writeString(createdAt);
    }
}
