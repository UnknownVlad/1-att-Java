package actions_with_db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Data {
    private Connection connection = null;
    private Statement statement = null;

    public Data() throws SQLException {
        this.connection = DataBaseCommunication.getDBConnection();
        this.statement = connection.createStatement();
    }

    public void closeConnection() throws SQLException {
        if(connection != null)
            connection.close();
        if(statement != null)
            statement.close();

        connection = null;
        statement = null;

    }

    public void setConnection(){
        connection = DataBaseCommunication.getDBConnection();
    }
    public void setStatement() throws SQLException {
        setConnection();
        statement = connection.createStatement();
    }

    private String playerTabelName = "playersdb.players";
    private List<String> playerTabelColumns = List.of("playerId", "nickname");
    private String createPlayerTabel =
            "CREATE TABLE " + playerTabelName
            + "("
            + "playerId int NOT NULL,"
            + "nickname varchar(45) DEFAULT NULL,"
            + " PRIMARY KEY (playerId)" +
            ")";

    private String currenciesTabelName = "playersdb.currencies";
    private List<String> currenciesTabelColumns = List.of("id", "playerId", "resourceId", "name", "count");
    private String createCurrencieTabel =
            "CREATE TABLE " + currenciesTabelName +
            "(" +
            "  id int NOT NULL," +
            "  playerId int NOT NULL," +
            "  resourceId int NOT NULL," +
            "  name varchar(45) DEFAULT NULL," +
            "  count int DEFAULT NULL," +
            "  PRIMARY KEY (id)" +
            ")";

    private String itemsTabelName = "playersdb.items";
    private List<String> itemsTabelColumns = List.of("id", "playerId", "resourceId", "count", "level");
    private String  createItemTabel =
            "CREATE TABLE " + itemsTabelName +
            "(" +
            "  id int NOT NULL," +
            "  playerId int NOT NULL," +
            "  resourceId int NOT NULL," +
            "  count int DEFAULT NULL," +
            "  level int DEFAULT NULL," +
            "  PRIMARY KEY (id)" +
            ")";

    private String progressesTabelName = "playersdb.progresses";
    private List<String> progressesTabelColumns = List.of("id", "playerId", "resourceId", "score", "maxScore");
    private String createProgressesTabel =
            "CREATE TABLE " +progressesTabelName +
            "(" +
            "  id int NOT NULL," +
            "  playerId int NOT NULL," +
            "  resourceId int NOT NULL," +
            "  score int DEFAULT NULL," +
            "  maxScore int DEFAULT NULL," +
            "  PRIMARY KEY (id)" +
            ")";

    public Connection getConnection() {
        return connection;
    }

    public String getPlayerTabelName() {
        return playerTabelName;
    }

    public List<String> getPlayerTabelColumns() {
        return playerTabelColumns;
    }

    public String getCreatePlayerTabel() {
        return createPlayerTabel;
    }

    public String getCurrenciesTabelName() {
        return currenciesTabelName;
    }

    public List<String> getCurrenciesTabelColumns() {
        return currenciesTabelColumns;
    }

    public String getCreateCurrencieTabel() {
        return createCurrencieTabel;
    }

    public String getItemsTabelName() {
        return itemsTabelName;
    }

    public List<String> getItemsTabelColumns() {
        return itemsTabelColumns;
    }

    public String getCreateItemTabel() {
        return createItemTabel;
    }

    public String getProgressesTabelName() {
        return progressesTabelName;
    }

    public List<String> getProgressesTabelColumns() {
        return progressesTabelColumns;
    }

    public String getCreateProgressesTabel() {
        return createProgressesTabel;
    }
}
