public class Purchase {

    public int customerId;
    public String customerName;
    public int seatId;
    public String seatType;
    public String seatPosition;
    public int seatAmount;

    public Purchase(int customerId, String customerName, int seatId, String seatType, String seatPosition, int seatAmount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatPosition = seatPosition;
        this.seatAmount = seatAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "Customer name: " + customerName + " | Seat type : " + seatType +
                " | Seat position: " + seatPosition + " | Amount of seat(s): " + seatAmount;
    }
}
