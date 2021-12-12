package org.example;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingManager {
    private final ArrayList<Booking> bookingList;
    private PassengerStore passengerStore;
    private VehicleManager vehicleManager;

    // Constructor
//    public BookingManager() {
//        this.bookingList = new ArrayList<>();
//    }

    public BookingManager(String fileName, VehicleManager vehicleManager, PassengerStore passengerStore) {
        this.bookingList = new ArrayList<>();
        this.vehicleManager = vehicleManager;
        this.passengerStore = passengerStore;


        loadBookingsFromFile(fileName);
    }

    private void loadBookingsFromFile(String filename) {

        try {
            Scanner sc = new Scanner(new File(filename));

            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int bookingId = sc.nextInt();
                int passengerId = sc.nextInt();
                int vehicleId = sc.nextInt();
                String bookingDateTime = sc.next();
                double startLocation = sc.nextDouble();
                double endLocation = sc.nextDouble();
                double cost = sc.nextDouble();


            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }

    public void displayAllBookings() {

        for (Booking b : bookingList)
            System.out.println(b.toString());
    }


//    public void createBooking(int passengerId, int vehicleId, int year, int month, int day, int hour, int minute
//            , double startLatitude, double startLongitude,double endLatitude,double endLongitude)
//    {
//        if (passengerStore.findPassengerByID(passengerId) != null)
//        {
//            // create booking
//
//        }
//        else
//        {
//            System.out.println("No such passenger");
//        }
////        public void addPassenger(String name, String email, String phone, double latitude, double longitude)
////         {
////            if(passengerStore.addPassenger(name,email,phone,latitude,longitude));
////
// }
//       bookingList.add(new Booking(bookingId, passengerId, vehicleId, bookingDateTime, startLocation, endLocation, cost));


    public void deletebyBookingId(int id) {
        for (int j = 0; j < bookingList.size(); j++) {
            Booking obj = bookingList.get(j);
            if (obj.getBookingId()==id) {
                bookingList.remove(j);
            }
        }
    }
}