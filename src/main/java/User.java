import java.util.ArrayList;

public class User {
    public int customerId;
    public String name;
    public String ticketType;
    public String ticketPosition;
    public int seatNumber;

    public User(String name, String ticketType, int seatNumber) {
        this.name = name;
        this.ticketType = ticketType;
        this.seatNumber = seatNumber;
    }

    public User(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public User(int customerId, String name, String ticketType) {
        this.customerId = customerId;
        this.name = name;
        this.ticketType = ticketType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketPosition() {
        return ticketPosition;
    }

    public void setTicketPosition(String ticketPosition) {
        this.ticketPosition = ticketPosition;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "User | " +
                "customerId: " + customerId +
                " | name: " + name + " | ticket type: " + ticketType;
    }
}