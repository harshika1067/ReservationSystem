
    



import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class Reservation {
    private int id;
    private String name;
    private String date;
    private int age;
    private int trainNumber;
    private String fromPlace;
    private String destinationPlace;

    public Reservation(int id, String name, String date, int age,int trainNumber,String fromPlace,String destinationPlace) 
    {
        this.id = id;
        this.name = name;
        this.date = date;
        this.age = age;
        this.trainNumber = trainNumber;
        this.fromPlace = fromPlace;
        this.destinationPlace = destinationPlace;
       }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int age() {
        return age;
    }

     public int trainNumber() {
        return trainNumber;
    }

    public String fromPlace() {
        return fromPlace;
    }
     
     public String destinationPlace () {
        return destinationPlace;
    }
}


 class ReservationSystem {
    private List<Reservation> reservations = new ArrayList<>();
    private int nextId = 1;

    public Reservation makeReservation(String name, String date, int age, int trainNumber, String fromPlace, String destinationPlace) {
        Reservation reservation = new Reservation(nextId++, name, date, age, trainNumber, fromPlace, destinationPlace);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Reservation getReservationById(int id) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == id) {
                return reservation;
            }
        }
        return null;
    }

    public boolean cancelReservation(int id) {
        Reservation reservation = getReservationById(id);
        if (reservation != null) {
            reservations.remove(reservation);
            return true;
        }
        return false;
    }
}


 class ReservationSystemUI {
    private ReservationSystem reservationSystem = new ReservationSystem();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Make a reservation");
            System.out.println("2. View all reservations");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Date: ");
                    String date = scanner.nextLine(); 
                    System.out.print("Age: ");
                    int age= scanner.nextInt();
                    System.out.print("Train Number: ");
                    int trainNumber = scanner.nextInt();
                    System.out.print("From(from place): ");
                    String fromPlace = scanner.next();
                    System.out.print("To(destination place): ");
                    String destinationPlace = scanner.next();
                    
                                 
                    scanner.nextLine();

                    Reservation reservation = reservationSystem.makeReservation(name, date, age, trainNumber, fromPlace, destinationPlace);
                    System.out.println("Reservation made with ID " + reservation.getId());
                    break;
                case 2:
                    System.out.println("Reservations:");
                    for (Reservation r : reservationSystem.getReservations()) {
                        System.out.println(r.getId() + " - " + r.getName() + " - " + r.getDate() + " - " + r.age() + " - " + r.trainNumber() + " - " + r.fromPlace() + " - " + r.destinationPlace() +".");
                    }
                    break;
                case 3:
                    System.out.print("Reservation ID to cancel: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    if (reservationSystem.cancelReservation(id)) {
                        System.out.println("Reservation canceled");
                    } else {
                        System.out.println("Reservation not found");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        ReservationSystemUI obj = new ReservationSystemUI();
        obj.start();
    }
}