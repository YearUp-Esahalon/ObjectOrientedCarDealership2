package com.pluralsight;

// Class representing a generic contract
public class Contract {
    // Common attributes for all contracts
    private String date;            // Date of the contract
    private String customerName;     // Name of the customer
    private String customerEmail;    // Email of the customer
    private String vehicleSold;      // Vehicle sold (VIN or description)
    private double totalPrice;       // Total price of the vehicle
    private double monthlyPayment;    // Monthly payment for leases

    // Constructor to initialize for properties 
    public Contract(String date, String customerName, String customerEmail,
                    String vehicleSold, double totalPrice, double monthlyPayment) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    // Getters plz
    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getVehicleSold() {
        return vehicleSold;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }
}