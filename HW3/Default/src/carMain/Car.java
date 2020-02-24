package Default;
//Create Car class as the Component of the decorator
public class Car
{
    public String features = "";
    public String licenseID = "";

    public String getFeatures()
    {
        return this.features;
    }
}

class Economy extends Car
{
    public Economy(String licenseID)
    {
        this.licenseID = licenseID;
    }
    public int pricePerDay = 20;
}

class Standard extends Car
{
    public Standard(String licenseID)
    {
        this.licenseID = licenseID;
    }

    public int pricePerDay = 30;
}

class Luxury extends Car
{
    public Luxury(String licenseID)
    {
        this.licenseID = licenseID;
    }

    public int pricePerDay = 45;
}

class Suv extends Car
{
    public Suv(String licenseID)
    {
        this.licenseID = licenseID;
    }

    public int pricePerDay = 35;
}

class Minivan extends Car
{
    public Minivan(String licenseID)
    {
        this.licenseID = licenseID;
    }

    public int pricePerDay = 25;
}
