package airlines.reservation.system;

import java.util.Scanner;

public class Account {

    public Account(Airline airline, int index) {
        accountMenu(airline, index);
    }

    // Account menu
    public void accountMenu(Airline airline, int index) {
        Scanner scan = new Scanner(System.in);
        int choice;

        System.out.println("\nWelcome, " + airline.getPassenger(index).getFirstName() + " " + airline.getPassenger(index).getLastName() + ".\n");
        System.out.println("What would you like to do?");
        System.out.println("1) Deposit money");
        System.out.println("2) Display balance");
        System.out.println("3) Buy ticket");
        System.out.println("4) See your ticket(s)");
        System.out.println("5) Account settings");
        System.out.println("6) Change account");
        System.out.println("7) Quit");
        System.out.print("\nEnter you choice: ");
        choice = scan.nextInt();

        switch (choice) {
            case 1:
                depositMenu(airline, index);
                accountMenu(airline, index);
                break;
            case 2:
                displayBalance(airline, index);
                accountMenu(airline, index);
                break;
            case 3:
                buyTicket(airline, index, scan);
                accountMenu(airline, index);
                break;
            case 4:
                seeTickets(airline, index);
                accountMenu(airline, index);
                break;
            case 5:
                accountSetting(airline, index, scan);
                accountMenu(airline, index);
                break;
            case 6:
                AirlinesReservationSystem.mainMenu(airline, scan);
            case 7:
                System.out.println("Good bye :)");
                break;
            default:
                System.out.println("Invalid input. Please try again.\n");
                accountMenu(airline, index);
                break;
        }
    }

    // Deposit money
    public void depositMenu(Airline airline, int index) {
        airline.getPassenger(index).createBalance();
    }

    // Display balance
    public void displayBalance(Airline airline, int index) {
        System.out.println("\n> Your balance: $" + airline.getPassenger(index).getBalance() + "\n");
    }

    // Buy ticket
    public void buyTicket(Airline airline, int index, Scanner scan) {
        showFlights(airline);

        System.out.print("Which one would you like to buy (1 - " + airline.getFlightsSize() + "): ");
        int choice = scan.nextInt() - 1;
        if(choice > airline.getFlightsSize()) {
            System.out.println("Wrong choice. Please try again.\n");
        } else {
            if(airline.getPassenger(index).getBalance() < airline.getFlight(choice).getTicketPrice()) {
                System.out.println("Your balance is not enough for this ticket. Please fund some money and try again.\n");
                accountMenu(airline, index);
            } else {
                airline.getPassenger(index).setBalance(airline.getPassenger(index).getBalance() - airline.getFlight(choice).getTicket().getTicketPrice());
                airline.addTicket(airline.getFlight(choice).getTicket(), index);
                System.out.println("\nYou successfully bought ticket.\n");
            }
        }

    }

    // See your ticket(s)
    public void seeTickets(Airline airline, int index) {
        System.out.println("\n---------- YOUR TICKETS ----------\n");
        for(int i = 0; i < airline.getPassenger(index).getTicketSize(); i++) {
            System.out.println((i + 1) + ". " + airline.getPassenger(index).getTicket(i).printTicket());
        }
    }

    // Account Settings
    public void accountSetting(Airline airline, int index, Scanner scan) {
        System.out.println("\n---------- ACCOUNT SETTINGS ----------\n");
        System.out.println("What would you like to do?");
        System.out.println("1. Change username");
        System.out.println("2. Change password");
        System.out.println("3. Change firstname");
        System.out.println("4. Change lastname");
        System.out.println("5. Go back");
        System.out.print("\n> Enter your choice: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                changeUserName(airline, index, scan);
                accountSetting(airline, index, scan);
                break;
            case 2:
                changePassword(airline, index, scan);
                accountSetting(airline, index, scan);
                break;
            case 3:
                changeFirstName(airline, index, scan);
                accountSetting(airline, index, scan);
                break;
            case 4:
                changeLastName(airline, index, scan);
                accountSetting(airline, index, scan);
                break;
            case 5:
                accountMenu(airline, index);
            default:
                System.out.println("Invalid input. Please try again.");
                accountSetting(airline, index, scan);
                break;
        }
    }

    // Change username
    public void changeUserName(Airline airline, int index, Scanner scan) {
        System.out.println("\nYour username: " + airline.getPassenger(index).getUserName());
        System.out.print("> New username: ");
        scan.nextLine();
        String userName = scan.nextLine();
        airline.getPassenger(index).setUserName(userName);
        System.out.println("Username successfully changed.");
    }

    // Change password
    public void changePassword(Airline airline, int index, Scanner scan) {
        System.out.print("\n> Your current password: ");
        scan.nextLine();
        String password = scan.nextLine();
        if(password.equals(airline.getPassenger(index).getPassword())) {
            System.out.print("> New password: ");
            password = scan.nextLine();
            airline.getPassenger(index).setPassword(password);
            System.out.println("Password successfully changed.");
        } else {
            System.out.println("Enter your current password correctly.\n");
            changePassword(airline, index, scan);
        }
    }

    // Change firstName
    public void changeFirstName(Airline airline, int index, Scanner scan) {
        System.out.println("\nYour firstname: " + airline.getPassenger(index).getFirstName());
        System.out.print("> New firstname: ");
        scan.nextLine();
        String firstName = scan.nextLine();
        airline.getPassenger(index).setUserName(firstName);
        System.out.println("Firstname successfully changed.");
    }

    // Change lastName
    public void changeLastName(Airline airline, int index, Scanner scan) {
        System.out.println("\nYour lastname: " + airline.getPassenger(index).getLastName());
        System.out.print("> New lastname: ");
        scan.nextLine();
        String lastName = scan.nextLine();
        airline.getPassenger(index).setUserName(lastName);
        System.out.println("Lastname successfully changed.");
    }

    // Show flights
    public void showFlights(Airline airline) {
        System.out.println("\n---------- FLIGHTS ----------\n");
        for (int i = 0; i < airline.getFlightsSize(); i++) {
            System.out.println((i + 1) + ". " + airline.getFlight(i).printFlight());
        }
    }
}
