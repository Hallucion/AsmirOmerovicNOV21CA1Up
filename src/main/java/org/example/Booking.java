package org.example;

import java.time.LocalDateTime;

class Booking {
    private int bookingId;
    private int passengerId;
    private int vehicleId;
    private LocalDateTime bookingDateTime;
    private LocationGPS startLocation;
    private LocationGPS endLocation;


    private double cost;  //Calculated at booking time

    //TODO - see specification

    public Booking (int bookingId,int passengerId, int vehicleId, int year,
                    int month, int day, int hour, int minute, double latitude,
                    double longitude)

    {
        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.vehicleId = vehicleId;
        this.bookingDateTime = LocalDateTime.of(year, month, day, hour, minute);
        this.startLocation = new org.example.LocationGPS(latitude, longitude);
        this.endLocation = new org.example.LocationGPS(latitude, longitude);
        this.cost = cost;
    }
    public int getBookingId ()
    {
        return bookingId;
    }
    public void setBookingId ( int bookingId)
    {
        this.bookingId = bookingId;
    }
    public int getPassengerId ()
    {
        return passengerId;
    }
    public void setPassengerId ( int passengerId)
    {
        this.passengerId = passengerId;
    }
    public int getVehicleId ()
    {
        return vehicleId;
    }
    public void setvehicleId (int vehicleId)
    {
        this.vehicleId = vehicleId;
    }
    public LocalDateTime getBookingDateTime ()
    {
        return bookingDateTime;
    }
    public void setBookingDateTime (LocalDateTime bookingDateTime)
    {
        this.bookingDateTime = bookingDateTime;
    }
    public LocationGPS getStartLocation ()
    {
        return startLocation;
    }
    public void setStartLocation (LocationGPS startLocation)
    {
        this.startLocation = startLocation;
    }
    public LocationGPS setStartLocation ()
    {
        return endLocation;
    }
    public void setEndLocation (LocationGPS endLocation)
    {
        this.endLocation = endLocation;
    }

    public double getCost ()
    {
        return cost;
    }
    public void setCost ( double cost)
    {
        this.cost = cost;
    }

//    @Override
//    public String toString ()
//    {
//
//    }
//    @Override
//    public boolean equals (Object o)
//    {
//
//    }
//}
}