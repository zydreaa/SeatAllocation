import javax.swing.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        /*
        * I would like to build a seat allocation system for a plane
It should show all available seats
If a seat is taken, it should show that that seat is taken.
All entries should be saved.
It should be possible to ask the system to assign you a seat automatically in which case it should assign you a seat that fits your ticket class
All users will have a name and ticket type,
Based on your ticket type, you can book certain seats on the plane.
It should also be possible to choose a seat from available seats, if your ticket fits into seat category, you should be assigned seat of your choice, if not, it rejects your choice.
Application must remember all choices*/


        ReservationProcess reservation = new ReservationProcess();
        reservation.existingSeats();

        boolean quite = false;
        int options;

        JOptionPane.showMessageDialog(null, "Welcome to Seat allocation System!");

        while (!quite){
            options = Integer.parseInt(JOptionPane.showInputDialog("Enter your choice:\n " +
                    "0. Create my Account \n" +
                    "1. Print available seats \n" +
                    "2. Select ticket manually\n" +
                    "3. Select ticket automatically \n" +
                    "4. My Tickets \n" +
                    "5. Existing customer list \n" +
                    "6. Quit"));


            switch (options){
                case 0:
                    reservation.newCustomer();
                    break;
                case 1:
                    reservation.printAvailableSeats();
                    break;
                case 2:
                    reservation.selectSeatManually();
                    break;
                case 3:
                    reservation.selectSeatAutomatically();
                    break;
                case 4:
                    reservation.readUserPurchases();
                    break;
                case 5:
                    reservation.readExistingCustomers();
                    break;
                case 6:
                    quite = true;
                    break;
                default:
                    System.out.println("Error, try again!");
            }
        }
    }
}












