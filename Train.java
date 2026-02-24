import java.util.*;

class Train {
    private int trainNumber;
    private String trainName;
    private int totalSeats;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public Train(int trainNumber, String trainName, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.totalSeats = totalSeats;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getAvailableSeats() {
        return totalSeats - passengers.size();
    }

    public void bookTicket(String name, int age) {
        if (passengers.size() < totalSeats) {
            int seatNo = passengers.size() + 1;
            passengers.add(new Passenger(name, age, seatNo));
            System.out.println("Ticket Booked! Seat No: " + seatNo);
        } else {
            System.out.println("No Seats Available!");
        }
    }

    public void cancelTicket(int seatNumber) {
        passengers.removeIf(p -> p.getSeatNumber() == seatNumber);
        System.out.println("Ticket Cancelled (if existed).");
    }

    public void showPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No Bookings Yet.");
        } else {
            for (Passenger p : passengers) {
                System.out.println(p);
            }
        }
    }

    public String toString() {
        return "Train No: " + trainNumber +
               ", Name: " + trainName +
               ", Available Seats: " + getAvailableSeats();
    }
}
