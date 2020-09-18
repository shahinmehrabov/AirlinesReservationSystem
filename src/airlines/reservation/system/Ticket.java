package airlines.reservation.system;

public class Ticket {
    private String fromWhere;
    private String toWhere;
    private String date;
    private String departureTime;
    private String arrivalTime;
    private double ticketPrice;

    public Ticket(String fromWhere, String toWhere, String date, String departureTime, String arrivalTime, double ticketPrice) {
        this.fromWhere = fromWhere;
        this.toWhere = toWhere;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.ticketPrice = ticketPrice;
    }

    // Print ticket
    public String printTicket() {
        String printTicket = "Ticket from " + fromWhere + " to " + toWhere + " on " + date +
                "\nDeparture time: " + departureTime + "\tArrival time: " + arrivalTime +
                "\nTicket price for this flight: " + ticketPrice + "\n";
        return  printTicket;
    }

    // Set and Get fromWhere
    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    // Set and Get toWhere
    public void setToWhere(String toWhere) {
        this.toWhere = toWhere;
    }

    public String getToWhere() {
        return toWhere;
    }

    // Set and Get date
    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    // Set and Get departureTime
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    // Set and Get arrivalTime
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    // Set and Get ticketPrice
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
