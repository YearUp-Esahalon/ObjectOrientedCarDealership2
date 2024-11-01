package com.pluralsight; // Package declaration

import java.util.ArrayList; // Import ArrayList
import java.util.List; // Import List interface

// Class to manage dealership inventory
public class Dealership {
    // Attributes for dealership information
    private String name; // Name of the dealership
    private String address; // Address of the dealership
    private String phone; // Contact phone number for the dealership
    private ArrayList<Vehicle> inventory; // List to hold the vehicles in the dealership

    // Constructor to initialize the dealership with name, address, and phone
    public Dealership(String name, String address, String phone) {
        this.name = name; // Set the dealership name
        this.address = address; // Set the dealership address
        this.phone = phone; // Set the dealership phone number
        this.inventory = new ArrayList<>(); // Instantiate the inventory ArrayList to hold vehicles
    }

    // Method to add a vehicle to the dealership's inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle); // Add the given vehicle to the inventory list
    }

    // Method to retrieve all vehicles in the inventory
    public List<Vehicle> getAllVehicles() {
        return inventory; // Return the entire inventory list
    }

    // Method to get a vehicle by VIN
    public Vehicle getVehicleByVin(int vin) {
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                return vehicle; // Return the found vehicle
            }
        }
        return null; // Return null if vehicle not found
    }

    // Method to sell a vehicle
    public void sellVehicle(Vehicle vehicle, String buyerName, double salePrice) {
        if (inventory.contains(vehicle)) {
            inventory.remove(vehicle); // Remove the vehicle from inventory
            // Create a record for the sale
            String record = "Sale," + vehicle.getVin() + "," + buyerName + "," + salePrice + "\n";
            DealerShipFileManager fileManager = new DealerShipFileManager("sales.csv");
            fileManager.writeSalesRecord(record); // Append the record to the sales file
            System.out.println("Vehicle sold: " + vehicle.getMake() + " " + vehicle.getModel());
        } else {
            System.out.println("Vehicle not found in inventory.");
        }
    }

    // Method to lease a vehicle
    public void leaseVehicle(Vehicle vehicle, String lesseeName, double leaseAmount) {
        if (inventory.contains(vehicle)) {
            inventory.remove(vehicle); // Remove the vehicle from inventory
            // Create a record for the lease
            String record = "Lease," + vehicle.getVin() + "," + lesseeName + "," + leaseAmount + "\n";
            DealerShipFileManager fileManager = new DealerShipFileManager("sales.csv");
            fileManager.writeSalesRecord(record); // Append the record to the sales file
            System.out.println("Vehicle leased: " + vehicle.getMake() + " " + vehicle.getModel());
        } else {
            System.out.println("Vehicle not found in inventory.");
        }
    }

    // Method to get vehicles by make and model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingVehicles.add(vehicle); // Add the vehicle to the list if it matches
            }
        }
        return matchingVehicles; // Return the list of matching vehicles
    }

    // Method to get vehicles by manufacturing year
    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> vehiclesInYearRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                vehiclesInYearRange.add(vehicle); // Add the vehicle to the list if it matches the criteria
            }
        }
        return vehiclesInYearRange; // Return the list of vehicles within the year range
    }

    // Method to get vehicles by color
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehiclesByColor.add(vehicle); // Add the vehicle to the list if it matches
            }
        }
        return vehiclesByColor; // Return the list of vehicles of the specified color
    }

    // Method to get vehicles within a specified price range
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehiclesInRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesInRange.add(vehicle); // Add vehicle to the list if it matches the criteria
            }
        }
        return vehiclesInRange; // Return the list of vehicles within the price range
    }

    // Getters for dealership properties
    public String getName() {
        return name; // Return the name of the dealership
    }

    public String getAddress() {
        return address; // Return the address of the dealership
    }

    public String getPhone() {
        return phone; // Return the phone number of the dealership
    }
}
