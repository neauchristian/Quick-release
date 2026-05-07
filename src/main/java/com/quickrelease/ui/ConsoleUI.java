package com.quickrelease.ui;

import com.quickrelease.model.League;
import com.quickrelease.model.OilPattern;
import com.quickrelease.model.Tournament;
import com.quickrelease.model.User;
import com.quickrelease.service.AuthService;
import com.quickrelease.service.LeagueService;
import com.quickrelease.service.TournamentService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner;

    private final AuthService authService;
    private final LeagueService leagueService;
    private final TournamentService tournamentService;

    public ConsoleUI() {
        scanner = new Scanner(System.in);

        authService = new AuthService();
        leagueService = new LeagueService();
        tournamentService = new TournamentService();
    }

    public void start() {

        boolean running = true;

        while (running) {

            showMenu();

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    createLeague();
                    break;

                case 4:
                    createTournament();
                    break;

                case 5:
                    viewUsers();
                    break;

                case 6:
                    viewLeagues();
                    break;

                case 7:
                    viewTournaments();
                    break;

                case 8:
                    joinWaitlist();
                    break;

                case 9:
                    serveNextPlayer();
                    break;

                case 10:
                    viewWaitlist();
                    break;

                case 11:
                    viewHistory();
                    break;

                case 12:
                    undoLastAction();
                    break;

                case 13:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showMenu() {

        System.out.println("\n===== QUICK RELEASE =====");

        System.out.println("1. Register");
        System.out.println("2. Login");

        System.out.println("3. Create League");
        System.out.println("4. Create Tournament");

        System.out.println("5. View Users");
        System.out.println("6. View Leagues");
        System.out.println("7. View Tournaments");

        System.out.println("8. Join Tournament Waitlist");
        System.out.println("9. Serve Next Player");
        System.out.println("10. View Waitlist");

        System.out.println("11. View Action History");
        System.out.println("12. Undo Last Action");

        System.out.println("13. Exit");
    }


    private void register() {

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (authService.register(username, password)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private void login() {

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (authService.login(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }


    private void createLeague() {

        System.out.print("League name: ");
        String name = scanner.nextLine();

        System.out.print("Bowling center: ");
        String center = scanner.nextLine();

        OilPattern pattern = inputOilPattern();

        leagueService.createLeague(
                name,
                center,
                LocalDateTime.now(),
                pattern
        );

        System.out.println("League created!");
    }


    private void createTournament() {

        System.out.print("Tournament name: ");
        String name = scanner.nextLine();

        System.out.print("Bowling center: ");
        String center = scanner.nextLine();

        OilPattern pattern = inputOilPattern();

        tournamentService.createTournament(
                name,
                center,
                LocalDateTime.now(),
                pattern
        );

        System.out.println("Tournament created!");
    }


    private OilPattern inputOilPattern() {

        System.out.println("\n--- Oil Pattern ---");

        System.out.print("Pattern name: ");
        String patternName = scanner.nextLine();

        int length;

        while (true) {
            System.out.print("Length (32 - 60 feet): ");
            length = scanner.nextInt();

            if (length >= 32 && length <= 60) {
                break;
            }

            System.out.println("Invalid. Must be 32–60 feet.");
        }

        System.out.print("Oil volume (ml): ");
        double oilVolume = scanner.nextDouble();

        System.out.print("Ratio (e.g. 8.0): ");
        double ratio = scanner.nextDouble();
        scanner.nextLine();

        return new OilPattern(patternName, length, oilVolume, ratio);
    }


    private void viewUsers() {

        System.out.println("\n--- USERS ---");

        if (authService.getAllUsers().isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        for (User user : authService.getAllUsers()) {
            System.out.println("Username: " + user.getUsername());
        }
    }


    private void viewLeagues() {

        System.out.println("\n--- LEAGUES ---");

        for (League league : leagueService.getAllLeagues()) {
            System.out.println("Name: " + league.getName());
        }
    }


    private void viewTournaments() {

        System.out.println("\n--- TOURNAMENTS ---");

        for (Tournament tournament : tournamentService.getAllTournaments()) {
            System.out.println("Name: " + tournament.getName());
        }
    }


    private void joinWaitlist() {

        User user = authService.getLoggedInUser();

        if (user == null) {
            System.out.println("You must be logged in.");
            return;
        }

        tournamentService.joinWaitlist(user);
        System.out.println("Added to waitlist.");
    }

    private void serveNextPlayer() {

        User next = tournamentService.serveNextUser();

        if (next == null) {
            System.out.println("Waitlist is empty.");
        } else {
            System.out.println("Next player: " + next.getUsername());
        }
    }

    private void viewWaitlist() {

        System.out.println("\n--- WAITLIST ---");

        if (tournamentService.getWaitlist().isEmpty()) {
            System.out.println("Empty.");
            return;
        }

        for (User user : tournamentService.getWaitlist()) {
            System.out.println(user.getUsername());
        }
    }


    private void viewHistory() {

        System.out.println("\n--- ACTION HISTORY ---");

        for (String action : tournamentService.getActionHistory()) {
            System.out.println(action);
        }
    }

    private void undoLastAction() {

        String action = tournamentService.undoLastAction();

        if (action == null) {
            System.out.println("Nothing to undo.");
        } else {
            System.out.println("Undid: " + action);
        }
    }
}