package airlines.reservation.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Passenger {
    private static int id = 0;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;
    private double balance = 0;
    private ArrayList<Ticket> tickets;

    // Constructor
    public Passenger(String userName, String password, String firstName, String lastName, String birthday) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.tickets = new ArrayList<Ticket>();
        id++;
    }

    // Set and Get id
    public int getId() {
        return id;
    }

    // Set and Get userName
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    // Set and Get password
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // Set and Get firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    // Set and Get lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    // Set and Get birthday
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    // Create, Get and Set balance
    public void createBalance() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n---------- MONEY DEPOSIT ----------\n");
        System.out.print("> Enter the amount: $");

        double balance = scan.nextDouble();

        // Prevent minus input
        if(balance < 0) {
            System.out.println("You can not deposit minus amount. Please try again.\n");

            while (balance < 0) {
                createBalance();
            }
        } else {
            this.balance = balance;
            System.out.println("Successful operation.");
            System.out.println("\nNow your balance is $" + getBalance() + "\n");
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    // Add ticket
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    // Get ticket
    public Ticket getTicket(int index) {
        return tickets.get(index);
    }

    // Get tickets size
    public int getTicketSize() {
        return tickets.size();
    }
}
