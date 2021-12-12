package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This Vehicle Bookings Management Systems manages the booking of Vehicles
 * by Passengers.
 *
 * This program reads from 3 text files:
 * "vehicles.txt", "passengers.txt", and "next-id-store.txt"
 * You should be able to see them in the project pane.
 * You will create "bookings.txt" at a later stage, to store booking records.
 *
 * "next-id-store.txt" contains one number ("201"), which will be the
 * next auto-generated id to be used to when new vehicles, passengers, or
 * bookings are created.  The value in the file will be updated when new objects
 * are created - but not when objects are recreated from records in
 * the files - as they already have IDs.  Dont change it - it will be updated by
 * the IdGenerator class.
 */

//public class App
//{
//    public static void main(String[] args)
//    {
//        System.out.println("\nWelcome to the VEHICLE BOOKINGS MANAGEMENT SYSTEM - CA1 for OOP\n");
//
//        // create PassengerStore and load it with passenger records from text file
//        PassengerStore passengerStore = new PassengerStore("passengers.txt");
//        System.out.println("List of all passengers:");
//        passengerStore.displayAllPassengers();
//
//        VehicleManager vehicleManager = new VehicleManager("vehicles.txt");
//        System.out.println("List of all Vehicles:");
//        vehicleManager.displayAllVehicles();
//
//        System.out.println("Program exiting... Goodbye");
//    }
//}



public class AppMenu
{
    // Components (objects) used in this App
    PassengerStore passengerStore;  // encapsulates access to list of Passengers
    VehicleManager vehicleManager;  // encapsulates access to list of Vehicles
    BookingManager bookingManager;  // deals with all bookings

    public static void main(String[] args)
    {
        AppMenu app = new AppMenu();
        app.start();
    }

    public void start()
    {
        // create PassengerStore and load all passenger records from text file
        passengerStore = new PassengerStore("passengers.txt");

        // create VehicleManager, and load all vehicles from text file
        vehicleManager = new VehicleManager("vehicles.txt");

        try
        {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");
    }

    private void displayMainMenu() throws IOException
    {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. Passengers\n"
                + "2. Vehicles\n"
                + "3. Bookings\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int PASSENGERS = 1;
        final int VEHICLES = 2;
        final int BOOKINGS = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.println("\n" + MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case PASSENGERS:
                        System.out.println("Passengers option chosen");
                        displayPassengerMenu();
                        break;
                    case VEHICLES:
                        System.out.println("Vehicles option chosen");
                        break;
                    case BOOKINGS:
                        System.out.println("Bookings option chosen");
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");

    }

    // Sub-Menu for Passenger operations
    //
    private void displayPassengerMenu() throws IOException
    {
        final String MENU_ITEMS = "\n*** PASSENGER MENU ***\n"
                + "1. Show all Passengers\n"
                + "2. Add new Passenger\n"
                + "3. Find Passenger by Name\n"
                + "4. Delete A Passenger\n"
                + "5. Exit\n"
                + "Enter Option [1,5]";

        final int SHOW_ALL = 1;
        final int NEW_PASSENGER = 2;
        final int FIND_BY_NAME = 3;
        final int DELETE_BOOKING = 4;
        final int EXIT = 5;

        Scanner keyboard = new Scanner(System.in);
        FileWriter write = new FileWriter("passengers.txt", true);
        int option = 0;
        Passenger p;
        do
        {
            System.out.println("\n" + MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case SHOW_ALL:
                        System.out.println("Display ALL Passengers");
                        passengerStore.displayAllPassengers();
                        break;
                    case NEW_PASSENGER:
                        System.out.println("Add a passenger");
                        System.out.println("Enter new passenger details:");
                        boolean check = false;
                        while (check == false) {
                            System.out.println("What Is Your Name Fam");
                            String Name = keyboard.nextLine();
                            System.out.println("What Is Your Email Fam");
                            String Email = keyboard.next();
                            System.out.println("What Is Your Phone Fam");
                            String Phone = keyboard.next();
                            System.out.println("What Is Your Lat Fam");
                            Double Latitude = keyboard.nextDouble();
                            System.out.println("What Is Your Long Fam");
                            Double Longitude = keyboard.nextDouble();
                            Passenger Fam = new Passenger(Name, Email, Phone, Latitude, Longitude);
                            passengerStore.getAllPassengers().add(Fam);

                            String textHolder;
                            textHolder = String.valueOf(Fam.getId()) + ",";
                            textHolder += Fam.getName() + ",";
                            textHolder += Fam.getEmail() + ",";
                            textHolder += Fam.getPhone() + ",";
                            textHolder += String.valueOf(Fam.getLocation().getLatitude()) + ",";
                            textHolder += String.valueOf(Fam.getLocation().getLongitude());
                            if (check == false) {
                                if (passengerStore.getAllPassengers().toString().contains(Fam.getEmail()) || passengerStore.getAllPassengers().toString().contains(Fam.getName())) {
                                    System.out.println("You have inputed a duplicate email or name, pulling you back to the menu");
                                    //  You could do 2 if's with  both OR's seperated to distinguish whether email OR name is invalid directly
                                } else {
                                    System.out.println("Adding you to the system.");
                                    write.write("\r" + textHolder);
                                    write.close();
                                    System.out.println(passengerStore.getAllPassengers());
                                    System.out.println("Reciept: " + Fam);
                                    break;
                                }
                            }
                        }
                        System.out.println(passengerStore.getAllPassengers().toString());
                        break;
                    case DELETE_BOOKING:
                        System.out.println("Delete Booking");
                        bookingManager.deletebyBookingId(1);
                        break;
                    case FIND_BY_NAME:
                        System.out.println("Find Passenger by Name");
                        System.out.println("Enter passenger name: ");
                        String name = keyboard.nextLine();
                        p = passengerStore.findPassengerByName(name);
                        if (p == null)
                            System.out.println("No passenger matching the name \"" + name + "\"");
                        else
                            System.out.println("Found passenger: \n" + p.toString());
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }
            }

            catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    // Sub-Menu for Bookings operations
    //
    private void displayBookingsMenu()
    {
        final String MENU_ITEMS = "\n*** BOOKINGS MENU ***\n"
                + "1. Show all Bookings\n"
                + "2. Make a NEW Booking\n"
                + "3. Exit\n"
                + "Enter Option [1,3]";

        final int SHOW_ALL = 1;
        final int NEW_BOOKING = 2;
        final int EXIT = 3;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.println("\n" + MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case SHOW_ALL:
                        System.out.println("Display ALL Bookings");
                        //bookingManager.displayAllBookings();
                        break;
                    case NEW_BOOKING:
                        System.out.println("Find Passenger by Name");
                        System.out.println("Enter passenger name: ");

                        String passengerId;
                        String vehicleId;
                        System.out.println("Enter booking date and time using format \"YYYY-MM-DDTHH:mm\"");
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }
}
