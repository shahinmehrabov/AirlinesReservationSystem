package airlines.reservation.system;

import java.util.Scanner;

public class Registration {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;

    // Constructor
    public Registration(Airline airline) {
        Scanner scan = new Scanner(System.in);

        System.out.println("---------- REGISTRATION ----------");
        System.out.println();

        createUserName(airline, scan);
        createPassword(scan);
        createFirstName(scan);
        createLastName(scan);
        createBirthday(scan);

        Passenger passenger = new Passenger(userName, password, firstName, lastName, birthday);
        airline.addPassenger(passenger);

        System.out.println("\nPassenger succesfuly created.\n");
        System.out.println("Username: " + getUserName());
        System.out.println("Password: " + printPasswordStars(password.length()));
        System.out.println("Firstname: " + firstName);
        System.out.println("Lastname: " + lastName);
        System.out.println("Birthday: " + birthday);
        System.out.println("Balance: 0.00\n");
    }

    // Create, Set and Get userName
    public void createUserName(Airline airline, Scanner scan) {
        System.out.print("> Username: ");
        this.userName = scan.nextLine();

        // Prevent empty input
        while (userName.isEmpty()) {
            System.out.println("\nUsername can not be empty. Please try again.\n");
            createUserName(airline, scan);
        }

        // Check userName is available or not
        for (int i = 0; i < airline.getPassengersSize(); i++) {
            if(userName.equals(airline.getPassengerUserName(i))) {
                System.out.println("This username is already taken. Please try another one.\n");
                createUserName(airline, scan);
            }
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    // Create, Set and Get password
    public void createPassword(Scanner scan) {
        System.out.print("> Password: ");
        this.password = scan.nextLine();

        // Prevent empty input
        while (password.isEmpty()) {
            System.out.println("\nPassword can not be empty. Please try again.\n");
            createPassword(scan);
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // Create, Set and Get firstName
    public void createFirstName(Scanner scan) {
        System.out.print("> Firstname: ");
        this.firstName = scan.nextLine();

        // Prevent empty input
        while (firstName.isEmpty()) {
            System.out.println("\nFirstname can not be empty. Please try again.\n");
            createFirstName(scan);
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    // Create, Set and Get lastName
    public void createLastName(Scanner scan) {
        System.out.print("> Last name: ");
        this.lastName = scan.nextLine();

        // Prevent empty input
        while (lastName.isEmpty()) {
            System.out.println("\nLastname can not be empty. Please try again.\n");
            createLastName(scan);
        }
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    // Create, Set and Get birthday
    public void createBirthday(Scanner scan) {
        System.out.println("\nEnter your birthday date like 'day.month.year'.");
        String day = "";
        String month = "";
        String year = "";

        System.out.print("> Day (1-31): ");
        // Prevent empty day input
        do {
            day = scan.nextLine();
            if(day.isEmpty()) {
                System.out.println("\nDay field can not be empty. Please try again.\n");
                System.out.print("> Day (1-31): ");
            } else {
                this.birthday = day + ".";
            }
        } while (day.isEmpty());

        System.out.print("> Month (1-12): ");
        // Prevent empty month input
        do {
            month = scan.nextLine();
            if(month.isEmpty()) {
                System.out.println("\nMonth field can not be empty. Please try again.\n");
                System.out.print("> Month (1-12): ");
            } else {
                this.birthday += month + ".";
            }
        } while (month.isEmpty());

        System.out.print("> Year: ");
        // Prevent empty year input
        do {
            year = scan.nextLine();
            if(year.isEmpty()) {
                System.out.println("\nYear field can not be empty. Please try again.\n");
                System.out.print("> Year: ");
            } else {
                this.birthday += year;
            }
        } while (year.isEmpty());
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    // Print password stars
    public String printPasswordStars(int size) {
        String star = "";
        for (int i = 0; i < size; i++) {
            star += "*";
        }
        return star;
    }
}
