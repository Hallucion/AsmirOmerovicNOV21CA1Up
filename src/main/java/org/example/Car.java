package org.example;

public class Car extends Vehicle
{
    private int passengers;

    public Car(String type, String make, String model, double milesPerKwH,
               String registration, double costPerMile,
               int year, int month, int day,
               int mileage, double latitude, double longitude,
               int passengers)
    {
        super(type, make, model, milesPerKwH,
                registration, costPerMile,
                year, month, day,
                mileage, latitude, longitude);

        this.passengers = passengers;
    }

    public Car(int id, String type, String make, String model, double milesPerKwH,
               String registration, double costPerMile,
               int year, int month, int day,
               int mileage, double latitude, double longitude, int passengers)
    {

        super(id, type, make, model, milesPerKwH,
                registration, costPerMile,
                year, month, day,
                mileage, latitude, longitude);

        this.passengers = passengers;
    }

    public double getPassengers()
    {
        return passengers;
    }

    public void setPassengers(int Passengers)
    {
        this.passengers = Passengers;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "Passengers=" + passengers +
                "} " + super.toString();
    }
}

