package duelGame;

import java.sql.Connection;
import java.sql.DriverManager;

import static duelGame.Provider.*;

public class ConnectionProvider {
    private static Connection conn = null;

    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
        }
    }

    public static Connection getConn() {
        return conn;
    }
}