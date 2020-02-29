package JorgesStuff;
import java.util.*;
import java.io.*;



public class outputFolder{
	int moneyEarnedToday = 0;
	int carsRentedToday = 0;

	int numIndexCarRent = 1;
	int day;

	int totalRevenue = 0;
	int totalRentals = 0;

	int totalCasualRentals = 0;
	int totalBusinessRentals = 0;
	int totalREgularRentals = 0;

	FileWriter myWriter;

	String firstPart= "";
	ArrayList<String> carRentalInfo = new ArrayList<String>(); //will need to reset
	String newActiveSummary = "Active Rentals\n"; // will need to reset
	String remainingCar = "Remaining Cars:";
	String endResultString= "";
	String totalDaySummary= "";

	public outputFolder(){
		try{
		myWriter= new FileWriter("rentalCompanyOutputFile.txt");
		}
		catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
	}

	public void initialDayStuff(int totalCarsRentedToday, int thisday  ){
		day = thisday;
		firstPart = "+++++++++++++++++++ Day "+day+ " Results +++++++++++++++++++ \n"
			+"Total Cars Rented Today: " + totalCarsRentedToday + "\n\n"
			+ "Cars Rented: \n";
		totalRentals += totalCarsRentedToday;
	}

	//Need to update carsRentedToday
	public void addToCarRentalInfo(customerObject customer, Car car){
		String newSummary = "	Car " + numIndexCarRent + ":\n"
		+ "		Customer Name: " + customer.name +"\n"
		+ "		Car License: " + car.getLicense() + "\n"
		+ "		Rented for: " + car.getDays() + "\n"
		+ "		Car Features: " + car.getFeatures() + "\n";


		numIndexCarRent ++;
		totalRevenue += car.getTotalCost();
		moneyEarnedToday += car.getTotalCost();
		String customerType = customer.type;
		if(customerType == "Casual"){
			totalCasualRentals++;
		}
		else if(customerType == "Business"){
			totalBusinessRentals++;
		}
		else{
			totalREgularRentals++;
		}
		carRentalInfo.add(newSummary);
	}

	public void addToActiveCarRentals(customerObject[] customers){

		for(int i = 0; i < customers.length; i++){

			for(int carInd : customers[i].getIndexOfCarsRented()){
				newActiveSummary += "	Customer Name: " + customers[i].name + "\n";
				newActiveSummary+= "		Car License: " + customers[i].cars[carInd].getLicense() +"\n";
			}
		}

	}

	public void remainingCarString(MJMRentalCompany mjm){

		remainingCar += mjm.getAllCarType().size() + "\n";
			//need to get licesnes lol

	}

	public void endResultPart(){
		endResultString += "+++++++++++++++++++ End Results +++++++++++++++++++\n"
		+ "Total Rented Cars: " + totalRentals+"\n"
		+ "Customer Business Rented: " + totalBusinessRentals +"\n"
		+ "Customer Regular Rented: " + totalREgularRentals+"\n"
		+ "Customer Casual Rented: " + totalCasualRentals+"\n"
		+ "Total Revenue: $" +totalRevenue;

	}

	public void addTotalDaySummary(){
		totalDaySummary += firstPart;
		for (String j : carRentalInfo){
			totalDaySummary+= j;
		}
		totalDaySummary += newActiveSummary;
		totalDaySummary +=remainingCar ;
		totalDaySummary += "Total Cash Earned Today: " + moneyEarnedToday + "\n";
	}

	public void resetStrings(){
		carRentalInfo = new ArrayList<String>(); //will need to reset
		newActiveSummary = "Active Rentals\n	"; // will need to reset
		remainingCar = "Remaining Cars:";
		endResultString= "";
		totalDaySummary= "";
		numIndexCarRent = 1;
		moneyEarnedToday = 0;
		carsRentedToday = 0;
	}
	public void closeFile(){
		try {
		      //FileWriter myWriter = new FileWriter("rentalCompanyOutputFile.txt");
		      //myWriter.write("Files in Java might be tricky, but it is fun enough!\n");
			  //myWriter.write("2");
			  endResultPart();
			  myWriter.write(endResultString);
		      myWriter.close();
		      //System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public void writeToFile(){
		try{
			myWriter.write(totalDaySummary);
		}catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
	}
}
