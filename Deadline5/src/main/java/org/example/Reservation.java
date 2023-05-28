public class Reservation {
    private String reservation_type;
    private int courtID;
    private int playerID;
    private int paymentID;

    public Reservation(String reservation_type, int courtID, int playerID, int paymentID) {
        this.reservation_type = reservation_type;
        this.courtID = courtID;
        this.playerID = playerID;
        this.paymentID = paymentID;
    }

    public void createReservation() {
        // check if court, player, and payment exist in database
        if (checkCourtExists() && checkPlayerExists() && checkPaymentExists()) {
            // create reservation in database
            System.out.println("Reservation created with type " + reservation_type + ", courtID " + courtID + ", playerID " + playerID + ", and paymentID " + paymentID);
        } else {
            System.out.println("Could not create reservation - court, player, or payment does not exist in database");
        }
    }

    private boolean checkCourtExists() {
        // check if court with courtID exists in database
        return true; // replace with actual implementation
    }

    private boolean checkPlayerExists() {
        // check if player with playerID exists in database
        return true; // replace with actual implementation
    }

    private boolean checkPaymentExists() {
        // check if payment with paymentID exists in database
        return true; // replace with actual implementation
    }

    // getters and setters omitted for brevity
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
}