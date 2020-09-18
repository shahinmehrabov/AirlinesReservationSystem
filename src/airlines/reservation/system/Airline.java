package airlines.reservation.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Airline {
    private String name;
    private ArrayList<Passenger> passengers;
    private ArrayList<Flight> flights;

    public Airline(String name) {
        this.name = name;
        passengers = new ArrayList<Passenger>();
        flights = new ArrayList<Flight>();
    }

    // Add passenger company database
    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    // Get passenger Id
    public int getPassengerId(int index) {
        return passengers.get(index).getId();
    }

    // Get passenger
    public Passenger getPassenger(int index) {
        return passengers.get(index);
    }

    // Get passengers length
    public int getPassengersSize() {
        return passengers.size();
    }

    // Get passenger username with Id
    public String getPassengerUserName(int id) {
        return passengers.get(id).getUserName();
    }

    // Get passenger password
    public String getPassengerPassword(int id) {
        return passengers.get(id).getPassword();
    }

    // Set and Get name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Add flight to database
    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    // Get ticket price for flight
    public double getTicketPrice(int index) {
        return flights.get(index).getTicketPrice();
    }

    // Get flight
    public Flight getFlight(int index) {
        return flights.get(index);
    }

    // Get flights size
    public int getFlightsSize() {
        return flights.size();
    }

    // Add ticket to passenger
    public void addTicket(Ticket ticket, int index) {
        passengers.get(index).addTicket(ticket);
    }
}
