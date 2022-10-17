package test;

import actions_with_db.Data;
import actions_with_db.DataBaseCommunication;
import actions_with_db.Requests;
import converters.UploadDataFromDB;
import demo.InsertDataToDB;
import json_reader.JsonReader;
import player_structure.Player;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void deleteAllTabels(Data d){
        DataBaseCommunication.deleteTabel(Requests.getDeleteTabelRequest(d.getPlayerTabelName()), d.getConnection());
        DataBaseCommunication.deleteTabel(Requests.getDeleteTabelRequest(d.getItemsTabelName()), d.getConnection());
        DataBaseCommunication.deleteTabel(Requests.getDeleteTabelRequest(d.getCurrenciesTabelName()), d.getConnection());
        DataBaseCommunication.deleteTabel(Requests.getDeleteTabelRequest(d.getProgressesTabelName()), d.getConnection());
    }

    public static void createAllTabels(Data d) throws SQLException {
        DataBaseCommunication.createTabel(d.getCreatePlayerTabel(), d.getConnection());
        DataBaseCommunication.createTabel(d.getCreateItemTabel(), d.getConnection());
        DataBaseCommunication.createTabel(d.getCreateCurrencieTabel(), d.getConnection());
        DataBaseCommunication.createTabel(d.getCreateProgressesTabel(), d.getConnection());
    }

    public static void insertData() throws SQLException, IOException {
        Data data = new Data();
        Test.createAllTabels(data);
        List<Player> l = JsonReader.getPlayers("players.json");
        System.out.println(l.size());
        InsertDataToDB.insertAllInformation(l, data);
        List<Player> l1 = UploadDataFromDB.upload(data);
        for (Player p:l1) {
            System.out.println(p.getPlayerId()+" "+p.getNickname());
        }
    }



}
