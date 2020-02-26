package Default;
import java.util.*;
//Create Car class as the Component of the decorator
public class Car
{   public String type = "";
    public String features = "";
    public String licenseID = "";
    int numGPS = 0;
    int numSR = 0;
    int numcarSeat = 0;
    int totalFeatureCost = 0;

    public String getFeatures()
    {
        return this.features;
    }

    public int getTotalCost()
    {
        return -1;
    }
}

class Economy extends Car
{
    int pricePerDay = 20;

    public Economy(String licenseID)
    {
        this.licenseID = licenseID;
        this.type = "Economy";
    }
    public int getTotalCost()
    {
        return this.totalFeatureCost + this.pricePerDay;
    }

}

class Standard extends Car
{
    int pricePerDay = 30;

    public Standard(String licenseID)
    {
        this.licenseID = licenseID;
        this.type = "Standard";
    }
    public int getTotalCost()
    {
        return this.totalFeatureCost + this.pricePerDay;
    }

}

class Luxury extends Car
{
    int pricePerDay = 45;

    public Luxury(String licenseID)
    {
        this.licenseID = licenseID;
        this.type = "Luxury";
    }
    public int getTotalCost()
    {
        return this.totalFeatureCost + this.pricePerDay;
    }
}

class Suv extends Car
{
    int pricePerDay = 35;

    public Suv(String licenseID)
    {
        this.licenseID = licenseID;
        this.type = "SUV";
    }

    public int getTotalCost()
    {
        return this.totalFeatureCost + this.pricePerDay;
    }
}

class Minivan extends Car
{
    int numGPS = 0;
    int numSR = 0;
    int numcarSeat = 0;
    int pricePerDay = 25;

    public Minivan(String licenseID)
    {
        this.licenseID = licenseID;
        this.type = "Minivan";
    }

    public int getTotalCost()
    {
        return this.totalFeatureCost + this.pricePerDay;
    }
}
