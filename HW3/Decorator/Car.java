import java.io.*;

//Create Car class as the Component of the decorator
public class Car
{
    public String features = ""
    public String licenseID = "";
    public void getFeatures(this)
    {
        return self.features;
    }
}

class Economy extends Car
{
    public int pricePerDay = 20;
}

class Standard extends Car
{
    public int pricePerDay = 30;
}

class Luxury extends Car
{
    public int pricePerDay = 45;
}

class Suv extends Car
{
    public int pricePerDay = 35;
}

class Minivan extends Car
{
    public int pricePerDay = 25;
}