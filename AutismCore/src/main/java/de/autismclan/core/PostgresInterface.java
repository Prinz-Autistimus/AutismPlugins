package de.autismclan.core;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresInterface {
    private Connection currentConnection = null;
    private String ip = null;
    private int port = 0;
    private String db = null;
    private String user = null;
    private String password = null;

    public PostgresInterface(String ip, int port, String db, String user, String password) {
        this.ip = ip;
        this.port = port;
        this.db = db;
        this.user = user;
        this.password = password;

        System.out.println(connect());
    }

    public String connect() {

        try {
            if (currentConnection != null && !currentConnection.isClosed()) { return "Already connected"; }

            DriverManager.registerDriver(new Driver());
            currentConnection = DriverManager.getConnection("jdbc:postgresql://" + ip + ":" + port + "/" + db, user, password);

            return "Connected to PostgreSQL Server";

        } catch (SQLException e) {
            System.err.println("Error while establishsing connection to SQL Server");
            e.printStackTrace();
        }

        return "An Error has occured";
    }


    public boolean isConnected() {
        boolean res = false;
        try {
            res = currentConnection != null && !currentConnection.isClosed();
        } catch (SQLException e) {
            System.err.println("Error while requesting connection status");
            e.printStackTrace();
        }
        return res;
    }

}
