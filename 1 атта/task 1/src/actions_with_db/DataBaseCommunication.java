package actions_with_db;

import java.sql.*;
import java.util.List;

public class DataBaseCommunication {
    public static final String USER_NAME = "vlad";
    public static final String PASSWORD = "vlad";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";


    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка SQL !");
        }
        return connection;
    }

    public static void createTabel(String request, Connection connection) throws SQLException {

        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.execute(request);
            System.out.println("Таблица создана!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteTabel(String request, Connection connection){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(request);
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void insertToDataBase(String request, Connection connection) throws SQLException {
        connection.createStatement().executeUpdate(request);
    }

    public static void insertListToDataBase(List<String> insertRequests, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        for (String a: insertRequests) {
            statement.executeUpdate(a);
        }
    }

    public static ResultSet getResultSet(String request, Connection connection) throws SQLException {
        return connection.createStatement().executeQuery(request);
    }










    public static void getInfo(String request, List<String> columns, Connection connection){

        Statement statement = null;
        try {

            statement = connection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(request);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {

                for (String s:columns) {
                    String inf = rs.getString(s);
                    System.out.println(s+": " + inf);
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void deleteData(String deleteAnnotation, Connection connection){

        Statement statement = null;
        try {
            connection = getDBConnection();
            statement = connection.createStatement();

            // выполняем запрос delete SQL
            statement.execute(deleteAnnotation);
            System.out.println("Record is deleted from DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }







}
