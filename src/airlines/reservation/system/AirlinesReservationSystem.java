package airlines.reservation.system;

import java.util.Scanner;

public class AirlinesReservationSystem {
    public static void main(String[] args) {
        // Scanner
        Scanner scan = new Scanner(System.in);

        // Create new Airline company
        Airline azal = new Airline("AZAL");

        // Create new flights
        Flight fl1 = new Flight("Warsaw", "Baku", "19.09.2020", "15:15", "22:15", 500);
        Flight fl2 = new Flight("Baku", "Berlin", "19.09.2020", "15:15", "22:15", 500);

        // Add flights to company database
        azal.addFlight(fl1);
        azal.addFlight(fl2);

        // Create new passenger
        Passenger passenger = new Passenger("shahin", "1524", "Shahin", "Mehrabov", "10.08.1997");

        // Add passenger to airline company
        azal.addPassenger(passenger);

        // Start main menu
        mainMenu(azal, scan);
    }

    public static void mainMenu(Airline airline, Scanner scan) {
        System.out.println("\n---------- " + airline.getName() + " MENU ----------\n");
        System.out.println("What would you like to do?");
        System.out.println("1) Login to you account");
        System.out.println("2) Create a new account");
        System.out.println("3) Quit");
        System.out.print("\nEnter your choice: ");

        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                Login login = new Login(airline);
                boolean run = true;
                while(run) {
                    if(login.enterLogin(airline)) {
                        new Account(airline, login.getLoginIndex());
                        run = false;
                    } else {
                        System.out.println("Wrong Username or Password. Please try again.\n");
                    }
                }
                break;
            case 2:
                new Registration(airline);
                mainMenu(airline, scan);
                break;
            case 3:
                System.out.println("\nGood bye :)");
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
    }
}
