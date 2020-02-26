package JorgesStuff;
import java.util.*;
//Create Car class as the Component of the decorator
public abstract class Car
{
//might want getLicense instead and features will be the stuff we get later.

    //Param that should not change
    String licenseID = "N/A";
    String type = "Unknown Car";


    String features = "None";
    int numSR = 0;
    int numCarSeat = 0;
    int gpsCount = 0;

//Helper Functions to get important info
    public String getLicense(){
  		return licenseID;
    }
    public String getType(){
		return type;
    }
    public String getFeatures(){
      return features;
    }
	public int getNumGPS(){
	  return this.gpsCount;
	}
	public void setGPS(){
		this.gpsCount +=1;
	}
	public int getNumSR(){
		return this.numSR;
	}
	public void setSR(){
		this.numSR +=1;
	}
	public int getNumCarSeat(){
		return this.numCarSeat;
	}
	public void setCarSeat(){
		this.numCarSeat +=1;
	}

	public abstract int getTotalCost();


}

//using extends since its an abstract class
class Economy extends Car
{
    public Economy(String licenseID)
    {
        licenseID = licenseID;
        this.type = "economy";
        this.features = "";

    }
    public int getTotalCost()
    {
        return 20;
    }

}

class Luxury extends Car
{
    int pricePerDay = 45;
    public Luxury(String licenseID)
    {
        type = "luxury";
        pricePerDay = 45;
        licenseID = licenseID;
    }
    public int getTotalCost()
    {
        return this.pricePerDay;
    }
}

/*
class Standard extends Car
{
    //int pricePerDay = 30;

    public Standard(String licenseID)
    {
        this.type = "standard";
        this.pricePerDay = 30;
        this.licenseID = licenseID;
    }
    public int getTotalCost()
    {
        return this.totalFeatureCost + this.pricePerDay;
    }

}


class Suv extends Car
{
    //String type = "suv";
    //int pricePerDay = 35;

    public Suv(String licenseID)
    {
        this.type = "suv";
        this.pricePerDay = 35;
        this.licenseID = licenseID;
    }

    public int getTotalCost()
    {
        return this.totalFeatureCost + this.pricePerDay;
    }
}

class Minivan extends Car
{
  //  int numGPS = 0;
    //int numSR = 0;
  //  int numcarSeat = 0;
    //String type = "minivan";
  //  int pricePerDay = 25;

    public Minivan(String licenseID)
    {
        this.type = "minivan";
        this.pricePerDay = 25;
        this.licenseID = licenseID;
    }

    public int getTotalCost()
    {
        return this.totalFeatureCost + this.pricePerDay;
    }
}
*/
