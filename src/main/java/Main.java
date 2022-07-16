import javax.swing.*;

public class Main {
    public static void main(String[] args) {

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












