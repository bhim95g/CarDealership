package com.pluralsight;
import java.io.*;
import java.nio.file.Path;


public class DealershipFileManager {

    private static final String FILE_PATH = "src/main/resources/inventory.csv";

    public Dealership getDealership() {

        Dealership dealership = new Dealership("My Dealership", "123 Main St", "555-1234");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length == 8) {

                    int vin = Integer.parseInt(parts[0]);

                    int year = Integer.parseInt(parts[1]);

                    String make = parts[2];

                    String model = parts[3];

                    String vehicleType = parts[4];

                    String color = parts[5];

                    int odometer = Integer.parseInt(parts[6]);

                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                    dealership.addVehicle(vehicle);

                }

            }

        } catch (IOException e) {

            System.out.println("Error reading inventory file: " + e.getMessage());

        }

        return dealership;

    }

    public void saveDealership(Dealership dealership) {

        // To be implemented

    }


}