import java.util.ArrayList;
import java.util.List;

enum PassengerType {
    STANDARD, GOLD, PREMIUM
}

class TravelPackage {
    private String name;
    private int capacity;
    private final List<Destination> itinerary;
    private final List<Passenger> passengers;

    public TravelPackage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void enroll(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Package is full. Cannot enroll more passengers.");
        }
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            destination.printActivities();
        }
    }

    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Capacity: " + capacity);
        System.out.println("Number of Passengers: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger: " + passenger.getName() + " - " + passenger.getPassengerType());
        }
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

class Destination {
    private final String name;
    private final List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void printActivities() {
        System.out.println("Destination: " + name);
        for (Activity activity : activities) {
            System.out.println("Activity: " + activity.getName() + ", Cost: " + activity.getCost());
        }
    }
}

class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;

    // Constructor
    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

class Passenger {
    private String name;
    private PassengerType type;

    // Constructor
    public Passenger(String name, PassengerType type) {
        this.name = name;
        this.type = type;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PassengerType getPassengerType() {
        return type;
    }

    public void setPassengerType(PassengerType type) {
        this.type = type;
    }

    public void signUpForActivity(Activity activity) {
        System.out.println("Passenger " + name + " signed up for activity " + activity.getName());
    }

    public static class Main {
        public static void main(String[] args) {
            // Example usage
            TravelPackage package1 = new TravelPackage("Package 1", 10);
            Destination destination1 = new Destination("Destination 1");
            destination1.addActivity(new Activity("Activity 1", "Description 1", 50.0, 20));
            destination1.addActivity(new Activity("Activity 2", "Description 2", 100.0, 15));
            package1.addDestination(destination1);
            package1.printItinerary();
        }
    }
}
