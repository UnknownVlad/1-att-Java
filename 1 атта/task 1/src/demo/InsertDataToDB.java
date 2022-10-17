package demo;

import actions_with_db.Data;
import actions_with_db.DataBaseCommunication;
import actions_with_db.Requests;
import player_structure.Currencies;
import player_structure.Items;
import player_structure.Player;
import player_structure.Progresses;

import java.sql.SQLException;
import java.util.List;

public class InsertDataToDB {

   public static void insertAllInformation(List<Player> players, Data data) throws SQLException {
       int count = 0;
       System.out.println("Insert");
       for (Player player: players) {

           DataBaseCommunication.insertToDataBase(Requests.getInsertRequestForPlayer(data.getPlayerTabelName(), data.getPlayerTabelColumns(), player.getPlayerId(), player.getNickname()), data.getConnection());
           for (Currencies currencie : player.getCurrencies()) {
               DataBaseCommunication.insertToDataBase(Requests.getInsertRequestCurrencies(data.getCurrenciesTabelName(), data.getCurrenciesTabelColumns(), currencie), data.getConnection());
           }
           for (Items item : player.getItems()) {
               DataBaseCommunication.insertToDataBase(Requests.getInsertRequestItems(data.getItemsTabelName(), data.getItemsTabelColumns(), item), data.getConnection());
           }
           for (Progresses progress: player.getProgresses()) {
               DataBaseCommunication.insertToDataBase(Requests.getInsertRequestProgresses(data.getProgressesTabelName(), data.getProgressesTabelColumns(), progress), data.getConnection());
           }

           count++;
           if(count%100==0)
            System.out.println(count/100+"%");

       }

       System.out.println("finish");
   }

}
