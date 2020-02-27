package JorgesStuff;
import java.util.*;
//Create Car class as the Component of the decorator
public abstract class Car
{
	 //Param that should not change
    String licenseID = "N/A";
    String type = "Unknown Car";
	int totalCost = 0;
    String features = "";
    int numSR = 0;
    int numCarSeat = 0;
    int gpsCount = 0;



	public String getLicense(){
	return licenseID;
}
	public String getType(){
	return type;
}

	public int getTotalCost(){
		return this.totalCost;
	}
	public void setTotalCost(int val){
		this.totalCost += val;
	}

	//returns a string of features
	public String getFeatures(){
      return features;
    }
	//removes Feature and updates cost
	public void removeFeatures(String feature){
		System.out.println("");
	}
	//adds to the string of features
	public void setFeatures(String feature){
		this.features += feature;
	}
	//removes specific feature from string
	public void updateFeatures(String feature){
		this.features = this.features.replaceFirst(feature, "");
	}

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
        type = "economy";
        features = "";
		totalCost = 20;
    }
    public int getTotalCost(){
        return totalCost;
    }
}

class Luxury extends Car{
    public Luxury(String licenseID){
        type = "luxury";
        licenseID = licenseID;
		features = "";
		totalCost = 45;
    }
    public int getTotalCost(){
        return totalCost;
    }
}

class Standard extends Car{
    public Standard(String licenseID){
        type = "standard";
        licenseID = licenseID;
		features = "";
		totalCost = 30;
    }
    public int getTotalCost(){
        return totalCost;
    }
}

class Suv extends Car{
    public Suv(String licenseID){
        type = "suv";
        features = "";
        licenseID = licenseID;
		totalCost = 35;
    }

    public int getTotalCost(){
        return totalCost;
    }
}

class Minivan extends Car{
    public Minivan(String licenseID){
        type = "minivan";
		features = "";
    	licenseID = licenseID;
		totalCost = 25;
    }

    public int getTotalCost(){
        return totalCost;
    }
}
