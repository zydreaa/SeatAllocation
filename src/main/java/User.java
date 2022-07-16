

public class User {
    public int customerId;
    public String name;
    public String ticketType;

    public User(int customerId, String name, String ticketType) {
        this.customerId = customerId;
        this.name = name;
        this.ticketType = ticketType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getTicketType() {
        return ticketType;
    }

    @Override
    public String toString() {
        return "User | " + "customerId: " + customerId +
                " | name: " + name + " | ticket type: " + ticketType;
    }
}