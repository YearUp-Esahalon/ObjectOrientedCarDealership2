package com.pluralsight;

import java.util.List; // Import List for managing collections
import java.util.Scanner; // Import Scanner for user input

public class UserInterface {
    private Dealership dealership; // Instance of the Dealership
    private Scanner scanner; // Scanner to read user input
    private DealerShipFileManager fileManager; // File manager to handle file operations

    // Constructor to initialize the UserInterface with a Dealership object
    public UserInterface(Dealership dealership) {
        this.dealership = dealership; // Set the dealership
        this.scanner = new Scanner(System.in); // Initialize the Scanner
        this.fileManager = new DealerShipFileManager("inventory.csv"); // Set the filename
        loadVehicles(); // Load vehicles from the CSV file when starting
    }

    // Method to load vehicles from the file into the dealership
    private void loadVehicles() {
        Dealership loadedDealership = fileManager.loadDealership(); // Load the dealership from the file
        if (loadedDealership != null) {
            // If loaded successfully, add all vehicles to the current dealership
            for (Vehicle vehicle : loadedDealership.getAllVehicles()) {
                dealership.addVehicle(vehicle);
            }
        }
    }

    // Method to start the user interface
    public void start() {
        boolean running = true; // Flag to control the loop

        while (running) { // Loop until the user decides to exit
            displayMenu(); // Show the menu options
            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewAllVehicles(); // Option to view all vehicles
                    break;
                case 2:
                    addVehicle(); // Option to add a new vehicle
                    fileManager.saveDealership(dealership); // Save changes to the file after adding
                    break;
                case 3:
                    findVehiclesByPrice(); // Find vehicles by price range
                    break;
                case 4:
                    findVehiclesByMakeModel(); // Find vehicles by make/model
                    break;
                case 5:
                    findVehiclesByYear(); // Find vehicles by year range
                    break;
                case 6:
                    findVehiclesByColor(); // Find vehicles by color
                    break;
                case 7:
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice, please try again."); // Handle invalid input
            }
        }

        System.out.println("Thank you for using the dealership interface."); // Goodbye message
        scanner.close(); // Close the scanner
    }

    // Method to display the menu options
    private void displayMenu() {
        System.out.println("Welcome to the Dealership Interface");
        System.out.println("1. View All Vehicles");
        System.out.println("2. Add a Vehicle");
        System.out.println("3. Find Vehicles by Price Range");
        System.out.println("4. Find Vehicles by Make/Model");
        System.out.println("5. Find Vehicles by Year Range");
        System.out.println("6. Find Vehicles by Color");
        System.out.println("7. Exit");
        System.out.print("Please enter your choice: "); // Prompt user for input
    }

    // Method to view all vehicles in the dealership
    private void viewAllVehicles() {
        List<Vehicle> vehicles = dealership.getAllVehicles(); // Get all vehicles from the dealership

        if (vehicles.isEmpty()) { // Check if there are no vehicles
            System.out.println("No vehicles available in the inventory.");
        } else {
            System.out.println("Vehicles in Inventory:");
            for (Vehicle vehicle : vehicles) { // Loop through each vehicle
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }

    // Method to add a new vehicle to the dealership
    private void addVehicle() {
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt(); // Read VIN
        System.out.print("Enter Year: ");
        int year = scanner.nextInt(); // Read Year
        System.out.print("Enter Make: ");
        String make = scanner.next(); // Read Make
        System.out.print("Enter Model: ");
        String model = scanner.next(); // Read Model
        System.out.print("Enter Vehicle Type: ");
        String vehicleType = scanner.next(); // Read Vehicle Type
        System.out.print("Enter Color: ");
        String color = scanner.next(); // Read Color
        System.out.print("Enter Odometer: ");
        int odometer = scanner.nextInt(); // Read Odometer
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble(); // Read Price

        // Create a new vehicle and add it to the dealership
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle); // Add the vehicle to the inventory

        System.out.println("Vehicle added successfully!"); // Confirmation message
    }

    // Method to find vehicles by price range
    private void findVehiclesByPrice() {
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble(); // Read minimum price
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble(); // Read maximum price

        List<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minPrice, maxPrice); // Find vehicles in price range
        if (vehiclesByPrice.isEmpty()) {
            System.out.println("No vehicles found in this price range."); // Inform user
        } else {
            System.out.println("Vehicles found in the price range:");
            for (Vehicle vehicle : vehiclesByPrice) {
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }

    // Method to find vehicles by make/model
    private void findVehiclesByMakeModel() {
        System.out.print("Enter make: ");
        String make = scanner.next(); // Read vehicle make
        System.out.print("Enter model: ");
        String model = scanner.next(); // Read vehicle model

        List<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model); // Find vehicles
        if (vehiclesByMakeModel.isEmpty()) {
            System.out.println("No vehicles found with this make/model."); // Inform user
        } else {
            System.out.println("Vehicles found:");
            for (Vehicle vehicle : vehiclesByMakeModel) {
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }

    // Method to find vehicles by year range
    private void findVehiclesByYear() {
        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt(); // Read minimum year
        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt(); // Read maximum year

        List<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(minYear, maxYear); // Find vehicles
        if (vehiclesByYear.isEmpty()) {
            System.out.println("No vehicles found in this year range."); // Inform user
        } else {
            System.out.println("Vehicles found:");
            for (Vehicle vehicle : vehiclesByYear) {
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }

    // Method to find vehicles by color
    private void findVehiclesByColor() {
        System.out.print("Enter color: ");
        String color = scanner.next(); // Read vehicle color

        List<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color); // Find vehicles
        if (vehiclesByColor.isEmpty()) {
            System.out.println("No vehicles found with this color."); // Inform user
        } else {
            System.out.println("Vehicles found:");
            for (Vehicle vehicle : vehiclesByColor) {
                System.out.println(vehicle.getVin() + ": " + vehicle.getMake() + " " + vehicle.getModel() + " - $" + vehicle.getPrice());
            }
        }
    }
}