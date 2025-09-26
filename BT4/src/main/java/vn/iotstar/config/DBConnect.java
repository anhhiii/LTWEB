package vn.iotstar.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    private final String serverName = "localhost";
    private final String dbName = "BT4JPA";
    private final String portNumber = "1433";
    private final String instance = ""; 
    private final String userID = "sa";
    private final String password = "thutrang@1510";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber 
                   + ";databaseName=" + dbName 
                   + ";encrypt=true;trustServerCertificate=true;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            System.out.println(new DBConnect().getConnection());
            System.out.println("Kết nối thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
