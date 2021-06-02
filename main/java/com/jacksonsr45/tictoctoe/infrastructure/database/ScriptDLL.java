package com.jacksonsr45.tictoctoe.infrastructure.database;

public class ScriptDLL {
    public static String getCreateTablePlayer() {
        StringBuilder query = new StringBuilder();
        query.append("create table if not exists player (");
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
        query.append("create table if not exists player_history (");
        query.append(" id text not null");
        query.append(" constraint player_history_pk ");
        query.append(" primary key,");
        query.append(" player_id text not null");
        query.append(" constraint player_history_player_id_fk");
        query.append(" references player");
        query.append(" on update cascade on delete cascade,");
        query.append(" total int not null,");
        query.append(" victories int not null,");
        query.append(" defeats int not null,");
        query.append(" ties int not null);");
        return query.toString();
    }

    public static String getCreateTableMatch() {
        StringBuilder query = new StringBuilder();
        query.append("create table if not exists match (");
        query.append(" id text not null ");
        query.append(" constraint match_pk ");
        query.append(" primary key, ");
        query.append(" level int not null, ");
        query.append(" result int not null, ");
        query.append(" created_at text not null, ");
        query.append(" player_history_id int not null ");
        query.append(" constraint match_player_history_id_fk ");
        query.append(" references player_history ");
        query.append(" on update cascade on delete cascade); ");
        return query.toString();
    }

    public static String getCreateTableMovements() {
        StringBuilder query = new StringBuilder();
        query.append("create table if not exists movements (");
        query.append(" id integer not null");
        query.append(" constraint movements_pk");
        query.append(" primary key,");
        query.append(" table_line int not null,");
        query.append(" table_column int not null,");
        query.append(" value int not null,");
        query.append(" match_id text not null");
        query.append(" constraint movements_match_id_fk");
        query.append(" references match");
        query.append(" on update cascade on delete cascade);");
        return query.toString();
    }
}
