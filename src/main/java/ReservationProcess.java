import javax.swing.*;
import java.util.ArrayList;

public class ReservationProcess {

    int chosenSeatId;
    int chosenAmount;
    int currentAmount;
    int availability;


    ArrayList<Seat> seatArrayList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<Seat> userPurchases = new ArrayList<>();

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
        for (Seat purchase : userPurchases) {
            System.out.println("Your purchases: " + purchase);
        }
    }

    public void printAvailableSeats() {
        for (Seat availableSeats : seatArrayList) {
            System.out.println(availableSeats);
        }
    }

    public void selectSeatManually() {

        chosenSeatId = Integer.parseInt(JOptionPane.showInputDialog("Enter seat ID: "));
        chosenAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter seat amount: "));
        String chosenSeatType = seatArrayList.get(chosenSeatId).getSeatType();
        String chosenSeatPosition = seatArrayList.get(chosenSeatId).getSeatPosition();
        Seat selectedSeat = new Seat(chosenSeatId, chosenSeatType, chosenSeatPosition, chosenAmount);
        availableAmount(chosenSeatId, chosenAmount);
        if (availability == 1) {
            userPurchases.add(selectedSeat);
            reduceAmount(chosenSeatId, chosenAmount);
            System.out.println("Seats successfully booked!");
        } else {
            System.out.println("Sorry, seats are not available at necessary amount!");
        }
    }

    public void selectSeatAutomatically() {
        int customerIdA = Integer.parseInt(JOptionPane.showInputDialog("Enter your customer ID: "));
        int chosenAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter seat amount: "));

        String availableTicketType = "";
        for (User userIdentify : userList) {
            if (userIdentify.getCustomerId() == customerIdA) {
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
                Seat seatToOfferNew = new Seat(chosenSeatId, availableTicketType, chosenSeatPosition, chosenAmount);
                if (availability == 1) {
                    System.out.println("seatToOfferNew: " + seatToOfferNew);
                    userPurchases.add(seatToOfferNew);
                    reduceAmountA(chosenSeatId, chosenAmount);
                    System.out.println("Seats successfully booked!");
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