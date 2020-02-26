package Default;
import java.util.*;
//Create Car class as the Component of the decorator
public class Car
{
    public String features = "";
    public String licenseID = "";
    int numGPS = 0;
    int numSR = 0;
    int numcarSeat = 0;

    public String getFeatures()
    {
        return this.features;
    }
}

class Economy extends Car
{
    int pricePerDay = 20;
    String type = "economy";

    public Economy(String licenseID)
    {
        this.licenseID = licenseID;
    }
   
}

class Standard extends Car
{
    String type = "standard";
    int pricePerDay = 30;

    public Standard(String licenseID)
    {
        this.licenseID = licenseID;
    }

}

class Luxury extends Car
{
    int pricePerDay = 45;
    String type = "luxury";

    public Luxury(String licenseID)
    {
        this.licenseID = licenseID;
    }

}

class Suv extends Car
{
    String type = "suv";
    int pricePerDay = 35;

    public Suv(String licenseID)
    {
        this.licenseID = licenseID;
    }

}

class Minivan extends Car
{
    int numGPS = 0;
    int numSR = 0;
    int numcarSeat = 0;
    String type = "minivan";
    int pricePerDay = 25;

    public Minivan(String licenseID)
    {
        this.licenseID = licenseID;
    }

}
