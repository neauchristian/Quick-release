package com.quickrelease.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Manages SQLite database connection and setup for Quick Release.
 * Creates tables and provides database connections.
 */
public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:quickrelease.db";

    /**
     * Opens and returns a connection to the SQLite database.
     *
     * @return Connection object
     * @throws SQLException if connection fails
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    /**
     * Creates all required tables if they do not already exist.
     */
    public void initializeDatabase() {

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            String usersTable =
                    "CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "username TEXT UNIQUE NOT NULL, " +
                    "password TEXT NOT NULL" +
                    ");";

            String leaguesTable =
                    "CREATE TABLE IF NOT EXISTS leagues (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "bowling_center TEXT NOT NULL, " +
                    "event_time TEXT NOT NULL, " +
                    "oil_pattern_name TEXT NOT NULL, " +
                    "pattern_length INTEGER, " +
                    "oil_volume REAL, " +
                    "ratio REAL" +
                    ");";

            String tournamentsTable =
                    "CREATE TABLE IF NOT EXISTS tournaments (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "bowling_center TEXT NOT NULL, " +
                    "event_time TEXT NOT NULL, " +
                    "oil_pattern_name TEXT NOT NULL, " +
                    "pattern_length INTEGER, " +
                    "oil_volume REAL, " +
                    "ratio REAL" +
                    ");";

            stmt.execute(usersTable);
            stmt.execute(leaguesTable);
            stmt.execute(tournamentsTable);

            System.out.println("Database initialized successfully.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
