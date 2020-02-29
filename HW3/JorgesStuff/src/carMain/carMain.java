package JorgesStuff;
import java.util.*;
import java.io.*;
//import carMain.Car;
public class carMain
{
 	public static void main(String args[]){

//++++++++++++++++++++++++TEST METHODS++++++++++++++++++++++++//

	//Testing restraints on features with max of 1
		//decoratorTest1();

	//Testing removal of Features and prices updating
		//decoratorTest2();

	//Testing max Feature addition
		//decoratorTest3();

	//Testing Marissas factory implementation
		//facotryTest1();

//++++++++++++++++++++++++End of Test METHODS++++++++++++++++++++++++//






//++++++++++++++++++++++++Start of Simulation++++++++++++++++++++++++ //

		outputFolder outStuff = new outputFolder();

//Initializing 12 Cutomers
	    customerObject[] customers = new customerObject[12];
		//Regular Customer(1)
		customers[0] = new RegularCustomer("Karen");
		//Casual Customer(6)
	    customers[1] = new CasualCustomer("Charlie");
		customers[2] = new CasualCustomer("Erwein");
		customers[3] = new CasualCustomer("Molly");
	    customers[4] = new CasualCustomer("Dee");
	    customers[5] = new CasualCustomer("Mandy");
		customers[6] = new CasualCustomer("Mac");

		//Business Customer (5)
	    customers[7] = new BusinessCustomer("Denniss");
	    customers[8] = new BusinessCustomer("Frank");
	    customers[9] = new BusinessCustomer("Bruce");
	    customers[10] = new BusinessCustomer("Gunter");
	    customers[11] = new BusinessCustomer("Josiah");

		//TO DO:
			//[X] Change days back 35
			//[X] on last day return all cars
			//[] implement the Observer into this
			//[] Do Read Me
			//[] Comment code
			//[] Extra Make sub method in main
			//[X] Remove all uneccessary system calls
			//Create outputStuff.



		//Creating our Rental Factory Pattern
			//Economy(5), Standard(5), Luxury(4), Suv(5), Minivan(5)
		MJMRentalCompany mjm = new MJMRentalCompany(5, 5, 4, 5, 5);
		for(int i = 1; i < 36; i++){

			int totalCarsRentedToday = 0;
			int totalCarsReturnedToday = 0;
			System.out.println("Day is: " + i);
			//return all Cars on last Day/ NO MORE RENTING
			if(i== 35){
				System.out.println("Returning all Cars from Customers");
				for(int j = 0; j < customers.length; j++){
					List<Integer> carList = customers[j].returnAllCarsLastDay();
					customers[j].resetDaysLeft();
					for(int carInd: carList){
						String featureString = customers[j].cars[carInd].getFeatures();
						List<String> featureList = new ArrayList<String>(Arrays.asList(featureString.split(", ")));
						mjm.returnCar(customers[j].cars[carInd],  featureList);
						totalCarsReturnedToday ++;
					}
				}
			}
			//still days to rent
			else{
			//Cars can be rented
				//1. update Car Retnal and returns if necessary
				for(int j = 0; j < customers.length; j++){
					customers[j].updateDaysLeft();
					//Check if any cars are due
					if(customers[j].checkZeros()){
						List<Integer> carList = customers[j].getCarIndex();
						//IF any cars are due, ALL CARS ARE DUE.
						customers[j].resetDaysLeft();
						for(int carInd: carList){
							//Cars has features in string but we need them in a list to return it in mjm
							//prettyPrintCustomer(customers[j], carInd ,false, customers[j].cars[carInd]);

							//prettyPrintCustomer(customer[j].cars[carID]);
							String featureString = customers[j].cars[carInd].getFeatures();
							List<String> featureList = new ArrayList<String>(Arrays.asList(featureString.split(", ")));

							mjm.returnCar(customers[j].cars[carInd],  featureList);
							totalCarsReturnedToday++;
						}
					}
				}

				//Get Random Customers count Ex: we want 7 customers
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(customers.length+1) + 0;
				if(randomInt != 0){
					//Making a Set of customers with their indexes randomly
					Set<Integer>  randomCustomers = new HashSet<Integer>();
					for (int j = 0; j < randomInt; j++){
						randomCustomers.add(randomGenerator.nextInt(customers.length) + 0);
					}

					//looping through our customers
					 for (int index : randomCustomers) {
						 //cars are availabe to rent
						 if(mjm.getAllCarType().size() > 0){
							 //Check if they can rent car

							  if(customers[index].numOfCarsCurrentRent <3){
								  //Grab a random number from 0 to amount of cars abailable to rent (24 at start)
								  int randomCarIndex = randomGenerator.nextInt(mjm.getAllCarType().size()) + 0;
								  ArrayList<String> allCarsAvailable = mjm.getAllCarType();
								  //Get the model Type chosen
								  String modelTypeChosen = allCarsAvailable.get(randomCarIndex);
								  //Get next open index to update returnDate
								  int nextCustomerOpenIndex = customers[index].nextOpenIndex();
								  int returnDate = customers[index].getEarliestDaysLeft();

								  //meaning there is already a car rented and it has a day set to be renterd in
								  HashMap<String,Object> paperwork;
								  if(returnDate != Integer.MAX_VALUE){
									  paperwork = mjm.rentCar(modelTypeChosen, returnDate , customers[index].getRandomFeatures());
									  customers[index].daysLeft[nextCustomerOpenIndex] = returnDate;
									  customers[index].cars[nextCustomerOpenIndex] = (Car) paperwork.get("car");
									  outStuff.addToCarRentalInfo(customers[index],(Car) paperwork.get("car") );
								  }
								  //first car being rented.
								  else{
									 returnDate = randomGenerator.nextInt(customers[index].maxRentDays +1) + customers[index].minRentDays;
									 paperwork = mjm.rentCar(modelTypeChosen, returnDate , customers[index].getRandomFeatures());
									 customers[index].daysLeft[0] = returnDate;
									 customers[index].cars[0] =  (Car) paperwork.get("car");
									 outStuff.addToCarRentalInfo(customers[0],(Car) paperwork.get("car") );
								  }
									customers[index].numOfCarsCurrentRent += 1;
									totalCarsRentedToday++;

									//prettyPrintCustomer(customers[index], nextCustomerOpenIndex , true, paperwork);
							  }
							 // outStuff.initialDayStuff(totalCarsRentedToday,i);




							  //can not rent any more cars
							  else{
								 // System.out.println("Customer already has 3 cars rented");
							  }
						 }
						 //no current cars available to rent
						 else{
							 System.out.println("MJM has no more cars");
						 }
					}
					outStuff.initialDayStuff(totalCarsRentedToday,i);
					outStuff.addToActiveCarRentals(customers);
					outStuff.remainingCarString(mjm);
					outStuff.addTotalDaySummary();
					outStuff.writeToFile();
					outStuff.resetStrings();
				}
				//0 customers came in
				else{
					System.out.println("Lonely Day at the Office");
				}
			}
			System.out.println("Total Cars Returned Today: " + totalCarsReturnedToday);
			System.out.println("Total Cars Rented Today: " + totalCarsRentedToday);
			System.out.println("Total Cars in MJM: " + mjm.getAllCarType().size() + "\n");
		}


		outStuff.closeFile();

	}


	//Helpfer Function Debuging Car Objects Moving
	public static void prettyPrintCustomer(customerObject customer, int nextCustomerOpenIndex, boolean Rented, Car car){
  		if(Rented){
			System.out.println("RENTING!!!");
		}
		else{
			System.out.println("RETURNING!!!!");
		}
		System.out.println("Customer Car Object \nCustomer Name: " + customer.name + " : Customer Car object Features: " +customer.cars[nextCustomerOpenIndex].getFeatures() +  "Custom Car License: "+customer.cars[nextCustomerOpenIndex].getLicense());
		System.out.println("Car Object Features: " +car.getFeatures() + " Car License: "+car.getLicense());
	}





//Test Helper Methids
  public static void decoratorTest1(){
	  Car car = new Luxury("Lux123");
	  car = new gps(car);
	  car = new gps(car);
	  System.out.println("Car type is: " +car.getType() + " : "+car.getTotalCost() );
  }
  public static void decoratorTest2(){
	  Car car2 = new Economy("Econ123");
	  car2 = new gps(car2);
	  System.out.println("Car type is: " +car2.getType() + " : "+car2.getTotalCost() +" : " +car2.getFeatures());
	  car2.removeFeatures("GPS");
	  System.out.println("Car type is: " +car2.getType() + " : "+car2.getTotalCost() +" : " +car2.getFeatures());
  }
  public static void decoratorTest3(){
	  Car car2 = new Economy("Eco123"); //20
	  car2 = new gps(car2); // 10
	  car2 = new gps(car2); // 0
	  car2 = new gps(car2); //0

	  car2 = new satelliteRadio(car2); //7
	  car2 = new satelliteRadio(car2);//0

	  car2 = new carSeat(car2); //5
	  car2 = new carSeat(car2); //5
	  car2 = new carSeat(car2); // 5
	  car2 = new carSeat(car2); //5
	  car2 = new carSeat(car2); //0
	  car2 = new carSeat(car2); //0

	  //Total = 57
	  System.out.println("Car Type is: " + car2.getType());
	  System.out.println("Total Cost is: $" + car2.getTotalCost());
	  String features = car2.getFeatures();
	  System.out.println("Feature List is: \n[" + features.substring(0, features.length()-2 ) + "]");
  }
/*
  public static void facotryTest1(){
	  // Order of inventory: eco, std, lux, su, min
	  MJMRentalCompany mjm = new MJMRentalCompany(5, 5, 4, 5, 5);
	  // FEATURES: "Car Seat"  "GPS"  "Satellite Radio"
	  List<String> features = new ArrayList<String>();
	  features.add("GPS");
	  features.add("Satellite Radio");

	  // MODELS:  "Economy"  "Standard"   "Luxury"  "SUV" "Minivan"
	  HashMap<String, Object> testRental = mjm.rentCar("Luxury", 3, features);
	  // Price should be $152
	  System.out.println(testRental.get("statment"));

	  // Have to cast Object to Car and List
	  mjm.returnCar((Car) testRental.get("car"), (List<String>) testRental.get("features"));
	  // Price should be $0s
	  //System.out.println(testRental.get("car").getTotalCost());
  }
  */
}
