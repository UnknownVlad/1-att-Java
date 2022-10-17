package actions_with_db;

import player_structure.Currencies;
import player_structure.Items;
import player_structure.Progresses;

import java.util.List;

public class Requests {

    public static String getQueryAllDataRequest(String tabelName){
        return "SELECT * FROM "+tabelName;
    }

    private static String getInsertModel(String tabelName, List<String> col){
        String request ="INSERT "+ tabelName+"(";
        for (int i = 0; i < col.size()-1; i++) {
            request +=col.get(i)+",";
        }
        request +=col.get(col.size()-1)+") VALUES(";
        return request;
    }
    private static String getSelectModel(String tableName, List<String> col){
        String request ="SELECT ";
        for (int i = 0; i < col.size()-1; i++) {
            request +=col.get(i)+",";
        }
        request +=col.get(col.size()-1)+" FROM " + tableName + " WHERE ";
        return request;
    }

    private static String getSelectModel(String tableName){
        String request ="SELECT * FROM " + tableName + " WHERE ";
        return request;
    }

    public static String getDeleteTabelRequest(String tabelName){
        return "DROP TABLE "+tabelName;
    }

    public static String getDeleteDataRequest(String tabelName, String nameKey, String value){
        return "DELETE FROM " + tabelName + " WHERE "+nameKey+" = " + value;
    }

    public static String getRequestPlayer(String tabelName, List<String> columns){
        String annotation = "SELECT ";
        for (int i = 0; i < columns.size()-1; i++) {
            annotation+=columns.get(i)+",";
        }
        annotation+=columns.get(columns.size()-1)+" from "+tabelName;

        return annotation;
    }
    public static String getInsertRequestForPlayer(String tabelName, List<String> columns, Integer playerId, String nickname){
        String annotation ="INSERT "+ tabelName+"(";
        for (int i = 0; i < columns.size()-1; i++) {
            annotation+=columns.get(i)+",";
        }
        annotation+=columns.get(columns.size()-1)+") VALUES("+ playerId+", '" + nickname + "')";
        return annotation;
    }

    public static String getInsertRequestCurrencies(String tabelName, List<String> col, Currencies c){

        return getInsertModel(tabelName, col) +
                c.getId()+", " + c.getPlayerId() + ", " + c.getResourceId() + ", '" + c.getName() +"', " + c.getCount()
                + ")";
    }

    public static String getInsertRequestItems(String tabelName, List<String> col, Items item){
        return getInsertModel(tabelName, col) +
                item.getId()+", " + item.getPlayerId() + ", " + item.getResourceId() + ", " + item.getCount() +", " + item.getLevel()
                + ")";
    }

    public static String getInsertRequestProgresses(String tabelName, List<String> col, Progresses p){
        return getInsertModel(tabelName, col) +
                p.getId()+", " + p.getPlayerId() + ", " + p.getResourceId() + ", " + p.getScore() +", " + p.getMaxScore()
                + ")";
    }

    public static String getQueryRequest(String tableName, List<String> col, String key, String val){
        return getSelectModel(tableName, col) + key + "="+val;
    }

    public static String getQueryRequest(String tableName, String key, String val){
        return getSelectModel(tableName) + key + "="+val;
    }
}
