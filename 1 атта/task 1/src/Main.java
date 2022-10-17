import actions_with_db.Data;
import converters.UploadDataFromDB;
import demo.InsertDataToDB;
import json_reader.JsonReader;
import player_structure.Player;
import test.Test;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Data data = new Data();
        //Test.deleteAllTabels(data);

        //Test.insertData();

        UploadDataFromDB.upload(data);
        data.closeConnection();

    }
}
