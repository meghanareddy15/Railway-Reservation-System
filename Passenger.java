class Passenger {
    private String name;
    private int age;
    private int seatNumber;

    public Passenger(String name, int age, int seatNumber) {
        this.name = name;
        this.age = age;
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Seat No: " + seatNumber;
    }
}
