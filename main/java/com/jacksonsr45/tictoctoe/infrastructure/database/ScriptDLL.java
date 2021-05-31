package com.jacksonsr45.tictoctoe.infrastructure.database;

public class ScriptDLL {
    public static String getCreateTablePlayer() {
        StringBuilder query = new StringBuilder();
        query.append("create table player (");
        query.append(" id   text not null");
        query.append(" constraint player_pk");
        query.append(" primary key,");
        query.append(" name text not null );" );
        query.append("create unique index player_name_uindex");
        query.append(" on player (name);");
        return query.toString();
    }

    public static String getCreateTablePlayerHistory() {
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE IF NOT EXISTS player_history (");
        query.append(" id text not null");
        query.append(" constraint player_history_pk");
        query.append(" primary key,");
        query.append(" player_id text");
        query.append(" references player");
        query.append(" on update cascade on delete cascade,");
        query.append(" total int,");
        query.append(" victories int,");
        query.append(" defeats int,");
        query.append(" ties int);");
        return query.toString();
    }

    public static String getCreateTableMatch() {
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE IF NOT EXISTS match (");
        query.append(" id text not null");
        query.append(" constraint match_pk");
        query.append(" primary key,");
        query.append(" level int  not null,");
        query.append(" result int,");
        query.append(" created_at TEXT");
        query.append(" player_history_id text");
        query.append(" references player_history");
        query.append(" on update cascade on delete cascade);");
        return query.toString();
    }

    public static String getCreateTableMovements() {
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE IF NOT EXISTS movements (");
        query.append(" id int not null");
        query.append(" constraint movements_pk");
        query.append(" primary key,");
        query.append(" table_line int not null,");
        query.append(" table_column int not null,");
        query.append(" value int not null");
        query.append(" match_id text not null");
        query.append(" references match");
        query.append(" on update cascade on delete cascade);");
        return query.toString();
    }
}
