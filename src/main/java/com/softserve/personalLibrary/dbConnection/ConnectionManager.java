package com.softserve.personalLibrary.dbConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
    here is needed to create methods for set/get DBSource to/from a connections, to check if a connection exist already, to
    write all connections to a HashMap <Long, Connection>, to close all connections, to register a DB driver and so on.*/


public final class ConnectionManager {

    public static Properties prop = loadProperties();

    private static volatile ConnectionManager connectionManager = null;

    private final Map<Long, Connection> allConnections = new HashMap<>();

    private ConnectionManager() {
    }


    public static Properties loadProperties() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/accessData.properties"));
            prop.load(new FileInputStream("src/main/resources/sqlQuery.properties"));
        } catch (IOException e) {
            System.out.println("ConnectionManager, loadProperties");
        }
        return prop;

    }


    public static ConnectionManager getConnectionManager() {
        if (connectionManager == null)
            synchronized (ConnectionManager.class) {
                if (connectionManager == null) {
                    connectionManager = new ConnectionManager();
                }
            }
        return connectionManager;
    }


    //instate of getInstance
    //creating new Connection and adding it to my HashMap
    public Connection createConnection(String dbURL, String dbUser, String dbPassword) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            allConnections.putIfAbsent(Thread.currentThread().getId(), conn);
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("ConnectionManager, createConnection");
        }
        return null;
    }



    public void beginTransaction() {
        try {
            allConnections.get(Thread.currentThread().getId()).setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("ConnectionManager, beginTransaction");

        }
    }

    public void commitTransaction() {
        try {
            allConnections.get(Thread.currentThread().getId()).commit();

        } catch (SQLException e) {
            System.out.println("ConnectionManager, commitTransaction");
        }
    }

    public void rollbackTransaction() {
        try {
            allConnections.get(Thread.currentThread().getId()).rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeAllConnections() {
        if (connectionManager != null) {
            for (Long key : connectionManager.allConnections.keySet()) {
                if (connectionManager.allConnections.keySet() != null) {
                    try {
                        connectionManager.allConnections.get(key).close();

                    } catch (SQLException e) {
                        System.out.println("ConnectionManager, closeAllConnections");
                    }
                    connectionManager.allConnections.put(key, null);
                }
            }
        }
    }
}
