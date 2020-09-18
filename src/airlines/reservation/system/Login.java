package airlines.reservation.system;

import java.util.Scanner;

public class Login {
    Airline airline;
    private int index;

    public Login (Airline airline){
        this.airline = airline;
    }

    public boolean enterLogin(Airline airline) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n---------- LOGIN MENU ----------");
        System.out.println();

        System.out.print("> Username: ");
        String userName = scan.nextLine();
        System.out.print("> Password: ");
        String password = scan.nextLine();

        return checkLogin(userName, password, airline);
    }

    public boolean checkLogin(String userName, String password, Airline airline) {
        for(int i = 0; i < airline.getPassengersSize(); i++) {
            if(userName.equals(airline.getPassengerUserName(i)) && password.equals(airline.getPassengerPassword(i))) {
                this.index = i;
                return true;
            }
        }
        return false;
    }

    public int getLoginIndex() {
        return index;
    }
}
