import javax.swing.*;
import java.util.ArrayList;

public class ReservationProcess {

    int chosenSeatId;
    int currentAmount;
    int availability;


    ArrayList<Seat> seatArrayList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<Purchase> userPurchases = new ArrayList<>();

    public void existingSeats() {
        Seat businessWindow = new Seat(seatArrayList.size(), "Business Class", "Window", 1);
        seatArrayList.add(businessWindow);
        Seat businessAisle = new Seat(seatArrayList.size(), "Business Class", "Aisle", 1);
        seatArrayList.add(businessAisle);
        Seat economicWindow = new Seat(seatArrayList.size(), "Economy Class", "Window", 5);
        seatArrayList.add(economicWindow);
        Seat economicAisle = new Seat(seatArrayList.size(), "Economy Class", "Aisle", 5);
        seatArrayList.add(economicAisle);
    }

    public void newCustomer() {
        int customerId = userList.size();
        String name = JOptionPane.showInputDialog("Enter your Name: ");
        String[] availableTicketType = {"Business Class", "Economy Class"};
        String ticketType = (String) JOptionPane.showInputDialog(
                null,
                "Enter your ticket type: ",
                "Ticket Type ",
                JOptionPane.QUESTION_MESSAGE,
                null,
                availableTicketType,
                availableTicketType[0]
        );

        User user = new User(customerId, name, ticketType);
        userList.add(user);
        System.out.println(user.name + ", your account is created! \n Your account information: \n" + user);

    }

    public void readExistingCustomers() {
        for (User existingUsers : userList) {
            System.out.println(existingUsers);
        }
    }

    public void readUserPurchases() {
        try {
            int customerId = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer ID: "));
            for (Purchase customerPurchase : userPurchases) {
                if (customerPurchase.getCustomerId() == customerId) {
                    System.out.println("Your purchase details: \n");
                    System.out.println(customerPurchase);
                }
            }
        }catch (Exception e){
                System.out.println("This customer hasn't bought any ticket yet!");
        }
    }

    public void printAvailableSeats() {
        for (Seat availableSeats : seatArrayList) {
            System.out.println(availableSeats);
        }
    }

    public void selectSeatManually() {
        int customerId = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer ID: "));
        int chosenAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter seat amount: "));
        for (User userIdentify : userList) {
            if (userIdentify.getCustomerId() == customerId) {
                String [] availableType = {"Business Class", "Economy Class"};
                String chosenSeatType = (String) JOptionPane.showInputDialog(
                        null,
                        "Chose seat type: ",
                        "Seat type ",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        availableType,
                        availableType[0]
                );
                String [] availablePositions = {"Window", "Aisle"};
                String chosenSeatPosition = (String) JOptionPane.showInputDialog(
                        null,
                        "Chose seat position: ",
                        "Seat position ",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        availablePositions,
                        availablePositions[0]
                );
                for (Seat seatsToOffer : seatArrayList){
                    if (chosenSeatType.equals("Business Class") && chosenSeatPosition.equals("Window")){
                        chosenSeatId = 0;
                        break;
                    } else if (chosenSeatType.equals("Business Class") && chosenSeatPosition.equals("Aisle")){
                        chosenSeatId = 1;
                        break;
                    } else if (chosenSeatType.equals("Economy Class") && chosenSeatPosition.equals("Window")){
                        chosenSeatId = 2;
                        break;
                    } else {
                        chosenSeatId = 3;
                        break;
                    }
                }
;
                Purchase selectedSeat = new Purchase(customerId, userIdentify.getName(),chosenAmount, chosenSeatType, chosenSeatPosition, chosenAmount);
                availableAmount(chosenSeatId, chosenAmount);
                if (availability == 1) {
                    userPurchases.add(selectedSeat);
                    reduceAmount(chosenSeatId, chosenAmount);
                    System.out.println("Seats successfully booked!");
                    System.out.println("Your ticket details:\n" + selectedSeat);
                } else {
                    System.out.println("Sorry, seats are not available at necessary amount!");
                }
            }
        }
    }

    public void selectSeatAutomatically() {
        int customerId = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer ID: "));
        int chosenAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter seat amount: "));

        String availableTicketType = "";
        for (User userIdentify : userList) {
            if (userIdentify.getCustomerId() == customerId) {
                availableTicketType = userIdentify.getTicketType();
                System.out.println("AvailableTicketType: " + availableTicketType); // to delete

                String [] availablePositions = {"Window", "Aisle"};
                String chosenSeatPosition = (String) JOptionPane.showInputDialog(
                        null,
                        "Chose seat position: ",
                        "Seat position ",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        availablePositions,
                        availablePositions[0]
                );
                System.out.println("chosenSeatPosition " + chosenSeatPosition );
                for (Seat seatsToOffer : seatArrayList){
                    if (availableTicketType.equals("Business Class") && chosenSeatPosition.equals("Window")){
                        chosenSeatId = 0;
                        break;
                    } else if (availableTicketType.equals("Business Class") && chosenSeatPosition.equals("Aisle")){
                        chosenSeatId = 1;
                        break;
                    } else if (availableTicketType.equals("Economy Class") && chosenSeatPosition.equals("Window")){
                        chosenSeatId = 2;
                        break;
                    } else {
                        chosenSeatId = 3;
                        break;
                    }
                }
                System.out.println("chosenSeatID provided by System: " + chosenSeatId);// to delete
                System.out.println("chosenAmountA : " + chosenAmount);// to delete
                availableAmount(chosenSeatId, chosenAmount);
                System.out.println("Availability after checking" + availability);// to delete
                Purchase seatToOfferNew = new Purchase(customerId, userIdentify.getName(), chosenSeatId, availableTicketType, chosenSeatPosition, chosenAmount);
                if (availability == 1) {
                    userPurchases.add(seatToOfferNew);
                    reduceAmountA(chosenSeatId, chosenAmount);
                    System.out.println("Seats successfully booked!");
                    System.out.println("Your ticket details: \n" + seatToOfferNew);
                } else {
                    System.out.println("Sorry, seats are not available at necessary amount!");
                }
            }

        }
    }

    private void reduceAmount(int chosenSeatId, int chosenAmount) {
        for (Seat seatReduceAmount : seatArrayList) {
            if (seatReduceAmount.getSeatId() == chosenSeatId) {
                currentAmount = seatReduceAmount.getAmount() - chosenAmount;
                seatReduceAmount.setAmount(currentAmount);
                break;
            }
        }
    }

    public int availableAmount(int chosenSeatId, int chosenAmount) {
        availability = 0;
        Seat seatAvailability = seatArrayList.get(chosenSeatId);
        if (seatAvailability.getAmount() >= chosenAmount) {
            availability = 1;
        }
        return availability;
    }

    private void reduceAmountA(int chosenSeatId, int chosenAmountA) {
        for (Seat seatReduceAmount : seatArrayList) {
            if (seatReduceAmount.getSeatId() == chosenSeatId) {
                currentAmount = seatReduceAmount.getAmount() - chosenAmountA;
                seatReduceAmount.setAmount(currentAmount);
                break;
            }
        }
    }

}