package JorgesStuff;
import java.util.*;

public abstract class customerObject{
 	String name = "";
 	String type = "";
	int numOfCarsCurrentRent= 0;
	int minRentDays;
	int maxRentDays;
	//Car[] cars = new Car[3];
	int[] daysLeft = new int[] {-1,-1,-1};
	public int nextOpenIndex(){
		for(int i = 0; i < 3; i++){
			if (daysLeft[i] == -1)
				return i;
		}
		return -1;
	}
	public int getEarliestDaysLeft(){
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++){
			if (daysLeft[i] < min && daysLeft[i] != -1){
				min = daysLeft[i];
			}
		}
		return min;

	}
	public List<String> getRandomFeatures(){
		int featureCount;
		List<String> features = new ArrayList<String>();

	 	featureCount = (int) (Math.random() * ((1 - 0) + 1)) + 0 ;
	 	for(int i = 0; i < featureCount; i++){
	 		features.add("GPS");
		 }
	 	//satelliteRadio
		 featureCount = (int) (Math.random() * ((1 - 0) + 1)) + 0 ;
		 for(int i = 0; i < featureCount; i++){
			 features.add("Satellite Radio");
		 }
		 //Car Seats
		 featureCount = (int) (Math.random() * ((4 - 0) + 1)) + 0 ;
		 for(int i = 0; i < featureCount; i++){
			 features.add("Car Seat");
		 }
		 return features;
	}
}

class CasualCustomer extends customerObject{
	public CasualCustomer(String name){
		this.name = name;
		this.type = "Casual";
		this.minRentDays = 1;
		this.maxRentDays = 3;
		//need cars[]
	}
}
class BusinessCustomer extends customerObject{
	public BusinessCustomer(String name){
		this.name = name;
		this.type = "Business";
		this.minRentDays = 7;
		this.maxRentDays = 7;
		//need cars[]
	}

}
class RegularCustomer extends customerObject{
	public RegularCustomer(String name){
		this.name = name;
		this.type = "Regular";
		this.minRentDays = 3;
		this.maxRentDays = 5;
		//need cars[]
	}

}
