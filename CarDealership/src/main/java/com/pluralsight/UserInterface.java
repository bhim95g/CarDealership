package com.pluralsight;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    private Scanner scanner;

    public UserInterface() {

        scanner = new Scanner(System.in);

    }

    public void display() {

        init();

        boolean running = true;

        while (running) {

            displayMenu();

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":

                    processGetAllVehiclesRequest();

                    break;

                case "2":

                    processGetByPriceRequest();

                    break;

                case "3":

                    processGetByMakeModelRequest();

                    break;

                case "4":

                    processGetByYearRequest();

                    break;

                case "5":

                    processGetByColorRequest();

                    break;

                case "6":

                    processGetByMileageRequest();

                    break;

                case "7":

                    processGetByVehicleTypeRequest();

                    break;

                case "8":

                    processAddVehicleRequest();

                    break;

                case "9":

                    processRemoveVehicleRequest();

                    break;

                case "0":

                    running = false;

                    break;

                default:

                    System.out.println("Invalid choice. Please try again.");

            }

        }

        System.out.println("Exiting the application. Goodbye!");

    }

    private void init() {

        DealershipFileManager fileManager = new DealershipFileManager();

        dealership = fileManager.getDealership();

    }

    private void displayMenu() {

        System.out.println("\n=== Dealership Inventory Menu ===");

        System.out.println("1. View All Vehicles");

        System.out.println("2. Search by Price");

        System.out.println("3. Search by Make and Model");

        System.out.println("4. Search by Year");

        System.out.println("5. Search by Color");

        System.out.println("6. Search by Mileage");

        System.out.println("7. Search by Vehicle Type");

        System.out.println("8. Add a Vehicle");

        System.out.println("9. Remove a Vehicle");

        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");

    }

    private void displayVehicles(List<Vehicle> vehicles) {

        if (vehicles == null || vehicles.isEmpty()) {

            System.out.println("No vehicles found.");

        } else {

            for (Vehicle v : vehicles) {

                System.out.printf("VIN: %d | %d %s %s | Type: %s | Color: %s | Mileage: %d | Price: $%.2f%n",

                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),

                        v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());

            }

        }

    }

    private void processGetAllVehiclesRequest() {

        List<Vehicle> vehicles = dealership.getAllVehicles();

        displayVehicles(vehicles);

    }
    void processGetByPriceRequest() {}
    void processGetByMakeModelRequest() {}
    void processGetByYearRequest() {}
    void processGetByColorRequest() {}
    void processGetByMileageRequest() {}
    void processGetByVehicleTypeRequest() {}
    void processAddVehicleRequest() {}
    void processRemoveVehicleRequest() {}
}
