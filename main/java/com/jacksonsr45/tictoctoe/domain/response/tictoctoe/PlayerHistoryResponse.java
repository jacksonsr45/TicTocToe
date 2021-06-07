package com.jacksonsr45.tictoctoe.domain.response.tictoctoe;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import com.jacksonsr45.tictoctoe.domain.entity.tictoctoe.PlayerHistoryEntity;

public class PlayerHistoryResponse implements Parcelable {
    public String id;
    public String playerId;
    public int total, victories, defeats, ties;

    public PlayerHistoryResponse(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow("id"));
        this.playerId = cursor.getString(cursor.getColumnIndexOrThrow("player_id"));
        this.total = cursor.getInt(cursor.getColumnIndexOrThrow("total"));
        this.victories = cursor.getInt(cursor.getColumnIndexOrThrow("victories"));
        this.defeats = cursor.getInt(cursor.getColumnIndexOrThrow("defeats"));
        this.ties = cursor.getInt(cursor.getColumnIndexOrThrow("ties"));
    }

    public PlayerHistoryResponse(PlayerHistoryEntity entity) {
        this.id = entity.id;
        this.playerId = entity.playerId;
        this.total = entity.total;
        this.victories = entity.victories;
        this.defeats = entity.defeats;
        this.ties = entity.ties;
    }

    protected PlayerHistoryResponse(Parcel in) {
        id = in.readString();
        playerId = in.readString();
        total = in.readInt();
        victories = in.readInt();
        defeats = in.readInt();
        ties = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(playerId);
        dest.writeInt(total);
        dest.writeInt(victories);
        dest.writeInt(defeats);
        dest.writeInt(ties);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlayerHistoryResponse> CREATOR = new Creator<PlayerHistoryResponse>() {
        @Override
        public PlayerHistoryResponse createFromParcel(Parcel in) {
            return new PlayerHistoryResponse(in);
        }

        @Override
        public PlayerHistoryResponse[] newArray(int size) {
            return new PlayerHistoryResponse[size];
        }
    };
}
