package com.quickrelease;

import com.quickrelease.database.DatabaseManager;
import com.quickrelease.ui.ConsoleUI;

/**
 * Entry point for the Quick Release application.
 *
 * Quick Release is a bowling league and tournament
 * management system that allows users to:
 * - Register and login
 * - Create leagues and tournaments
 * - Join leagues and tournaments
 * - View bowling oil pattern information
 *
 * @author Your Name
 * @version 1.0
 */
public class Main {

    /**
     * Main method that starts the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
         DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.initializeDatabase();


        System.out.println("=================================");
        System.out.println("      QUICK RELEASE");
        System.out.println(" Bowling League/Tournament Management App");
        System.out.println("=================================");

        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }
}