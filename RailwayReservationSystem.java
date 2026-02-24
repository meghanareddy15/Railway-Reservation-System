import java.util.*;

public class RailwayReservationSystem {

    static ArrayList<Train> trains = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Add some default trains
        trains.add(new Train(101, "Express Line", 5));
        trains.add(new Train(102, "SuperFast Express", 3));

        while (true) {
            System.out.println("\n--- Railway Reservation System ---");
            System.out.println("1. View Trains");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: viewTrains(); break;
                case 2: bookTicket(); break;
                case 3: cancelTicket(); break;
                case 4: viewBookings(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid Choice!");
            }
        }
    }

    static Train findTrain(int trainNo) {
        for (Train t : trains) {
            if (t.getTrainNumber() == trainNo) {
                return t;
            }
        }
        return null;
    }

    static void viewTrains() {
        for (Train t : trains) {
            System.out.println(t);
        }
    }

    static void bookTicket() {
        System.out.print("Enter Train Number: ");
        int trainNo = sc.nextInt();
        sc.nextLine();

        Train t = findTrain(trainNo);
        if (t != null) {
            System.out.print("Enter Passenger Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            t.bookTicket(name, age);
        } else {
            System.out.println("Train Not Found!");
        }
    }

    static void cancelTicket() {
        System.out.print("Enter Train Number: ");
        int trainNo = sc.nextInt();
        System.out.print("Enter Seat Number: ");
        int seatNo = sc.nextInt();

        Train t = findTrain(trainNo);
        if (t != null) {
            t.cancelTicket(seatNo);
        } else {
            System.out.println("Train Not Found!");
        }
    }

    static void viewBookings() {
        System.out.print("Enter Train Number: ");
        int trainNo = sc.nextInt();

        Train t = findTrain(trainNo);
        if (t != null) {
            t.showPassengers();
        } else {
            System.out.println("Train Not Found!");
        }
    }
}
