package com.pluralsight;

import java.io.BufferedReader; // For reading text from files
import java.io.FileReader; // For reading files
import java.io.FileWriter; // For writing to files
import java.io.IOException; // For handling input/output errors

public class DealerShipFileManager {
    private String fileName; // Variable to hold the name of the file

    // Constructor to set the file name
    public DealerShipFileManager(String fileName) {
        this.fileName = fileName; // Assign the file name to the variable
    }

    // Method to load dealership data from the CSV file
    public Dealership loadDealership() {
        Dealership dealership = null; // Initialize dealership as null

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read the first line for dealership information
            String dealershipInfo = reader.readLine();
            if (dealershipInfo != null) { // Check if the line is not empty
                // Split the line by '|'
                String[] parts = dealershipInfo.split("\\|");
                String name = parts[0]; // Get dealership name
                String address = parts[1]; // Get dealership address
                String phone = parts[2]; // Get dealership phone number

                // Create a new Dealership object
                dealership = new Dealership(name, address, phone);
            }

            // Read the rest of the file for vehicle information
            String line;
            while ((line = reader.readLine()) != null) { // Continue until the end of the file
                // Split the line by '|'
                String[] vehicleParts = line.split("\\|");
                int vin = Integer.parseInt(vehicleParts[0]); // Get VIN
                int year = Integer.parseInt(vehicleParts[1]); // Get year
                String make = vehicleParts[2]; // Get make
                String model = vehicleParts[3]; // Get model
                String vehicleType = vehicleParts[4]; // Get vehicle type
                String color = vehicleParts[5]; // Get color
                int odometer = Integer.parseInt(vehicleParts[6]); // Get odometer reading
                double price = Double.parseDouble(vehicleParts[7]); // Get price

                // Create a new Vehicle object and add it to the dealership
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle); // Add the vehicle to the dealership's inventory
            }
        } catch (IOException e) { // Handle any file reading errors
            System.out.println("Error reading from file: " + e.getMessage()); // Print error message
        }

        return dealership; // Return the populated dealership object
    }

    // Method to save dealership data back to the CSV file
    public void saveDealership(Dealership dealership) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Write dealership information
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");

            // Write each vehicle in the inventory
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|"
                        + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");
            }
        } catch (IOException e) { // Handle any file writing errors
            System.out.println("Error writing to file: " + e.getMessage()); // Print error message
        }
    }

    // Method to append a sale or lease record to the contracts CSV file
    public void appendToContractsFile(String record) {
        try (FileWriter writer = new FileWriter("contracts.csv", true)) { // Open in append mode
            writer.write(record + "\n"); // Write the record to the file followed by a new line
        } catch (IOException e) { // Handle any file writing errors
            System.out.println("Error writing to contracts file: " + e.getMessage()); // Print error message
        }
    }
}