package com.pluralsight;

import java.util.ArrayList; // Import ArrayList class
import java.util.List; // Import List interface

public class Dealership {
    // Attributes for dealership information
    private String name; // Name of the dealership
    private String address; // Address of the dealership
    private String phone; // Contact phone number for the dealership
    private ArrayList<Vehicle> inventory; // List to hold the vehicles in the dealership <vehicle> the list contains objects of type vehicle.

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

    // Method to get vehicles within a specified price range
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehiclesInRange = new ArrayList<>(); // Create a list to hold vehicles in the specified price range

        // Iterate through all vehicles in the inventory
        for (Vehicle vehicle : inventory) {
            // Check if the vehicle's price is within the specified range
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesInRange.add(vehicle); // Add the vehicle to the list if it matches the criteria
            }
        }
        return vehiclesInRange; // Return the list of vehicles within the price range
    }

    // Method to get vehicles by make and model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matchingVehicles = new ArrayList<>(); // Create a list to hold matching vehicles

        // Iterate through all vehicles in the inventory
        for (Vehicle vehicle : inventory) {
            // Check if the vehicle's make and model match the specified values
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingVehicles.add(vehicle); // Add the vehicle to the list if it matches
            }
        }
        return matchingVehicles; // Return the list of matching vehicles
    }

    // Method to get vehicles by manufacturing year
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehiclesInYearRange = new ArrayList<>(); // Create a list to hold vehicles within the specified year range

        // Iterate through all vehicles in the inventory
        for (Vehicle vehicle : inventory) {
            // Check if the vehicle's year is within the specified range
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                vehiclesInYearRange.add(vehicle); // Add the vehicle to the list if it matches the criteria
            }
        }
        return vehiclesInYearRange; // Return the list of vehicles within the year range
    }

    // Method to get vehicles by color
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehiclesByColor = new ArrayList<>(); // Create a list to hold vehicles of the specified color

        // Iterate through all vehicles in the inventory
        for (Vehicle vehicle : inventory) {
            // Check if the vehicle's color matches the specified value
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehiclesByColor.add(vehicle); // Add the vehicle to the list if it matches
            }
        }
        return vehiclesByColor; // Return the list of vehicles of the specified color
    }

    // Method to get vehicles by mileage
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehiclesByMileage = new ArrayList<>(); // Create a list to hold vehicles within the specified mileage range

        // Iterate through all vehicles in the inventory
        for (Vehicle vehicle : inventory) {
            // Check if the vehicle's odometer reading is within the specified range
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                vehiclesByMileage.add(vehicle); // Add the vehicle to the list if it matches the criteria
            }
        }
        return vehiclesByMileage; // Return the list of vehicles within the mileage range
    }

    // Method to get vehicles by type (e.g., SUV, Sedan)
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehiclesByType = new ArrayList<>(); // Create a list to hold vehicles of the specified type

        // Iterate through all vehicles in the inventory
        for (Vehicle vehicle : inventory) {
            // Check if the vehicle's type matches the specified value
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehiclesByType.add(vehicle); // Add the vehicle to the list if it matches
            }
        }
        return vehiclesByType; // Return the list of vehicles of the specified type
    }

    // Method to remove a vehicle from the inventory
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle); // Remove the specified vehicle from the inventory list
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