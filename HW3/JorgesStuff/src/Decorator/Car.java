package JorgesStuff;
import java.util.*;
//Create Car class as the Component of the decorator
public abstract class Car
{
//Car Params
    String licenseID = "N/A";
    String type = "Unknown Car";
	int totalCost = 0;
	int dailyCost = 0;
	int totalFeatureCost = 0;
	int days = 0;
    String features = "1";
//Feature Params
	int numSR = 0;
    int numCarSeat = 0;
    int gpsCount = 0;

//Parameter getters and Setters (NON FEATURE)
	public int getDailyCost(){
		return dailyCost;
	}
	public void setDailyCost(int val){
		this.dailyCost = val;
	}
	public String getLicense(){
		return licenseID;
	}
	public String getType(){
		return type;
	}
	public void setTotalFeatureCost(int val){
		this.totalFeatureCost += val;
	}
	public int getTotalFeatureCost(){
		return totalFeatureCost;
	}
	public int getTotalCost(){
		return (days * dailyCost) + totalFeatureCost;
	}
	public void setTotalCost(int val){
		totalCost += val;
	}
	public int getDays(){
		return days;
	}
	public void setDays(int rentTime){
		this.days = rentTime;
	}

//String Feature Manipulation
	//returns a string of features
	public String getFeatures(){
      return features;
    }
	//adds to the string of features
	public void setFeatures(String feature){
		this.features += feature;
	}
	//removes specific feature from string
	public void updateFeatures(String feature){
		features = features.replaceFirst(feature, "");
	}
	//removes Feature and updates cost
	public void removeFeatures(String feature){
		System.out.println("Check Decorator");
	}


//Features getters and setters
	public int getNumGPS(){
	  return this.gpsCount;
	}
	public int getNumSR(){
		return this.numSR;
	}
	public int getNumCarSeat(){
		return this.numCarSeat;
	}

	public void setGPS(int val){
		this.gpsCount += val;
	}
	public void setSR(int val){
		this.numSR +=val;
	}
	public void setCarSeat(int val){
		this.numCarSeat +=val;
	}

}

//using extends since its an abstract class
class Economy extends Car{
    public Economy(String licenseID){
        licenseID = licenseID;
        type = "Economy";
        features = "";
		setDailyCost(20);
    }
}

class Luxury extends Car{
    public Luxury(String licenseId){
        type = "Luxury";
        licenseID = licenseId;
		features = "";
		setDailyCost(45);
    }

}

class Standard extends Car{
    public Standard(String licenseID){
        type = "Standard";
        licenseID = licenseID;
		features = "";
		setDailyCost(30);
    }
}

class Suv extends Car{
    public Suv(String licenseID){
        type = "Suv";
        features = "";
        licenseID = licenseID;
		setDailyCost(35);
    }
}

class Minivan extends Car{
    public Minivan(String licenseID){
        type = "Minivan";
		features = "";
    	licenseID = licenseID;
		setDailyCost(25);
    }
}
