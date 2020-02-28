package JorgesStuff;
import java.util.*;
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
/*
	for(int i = 0 ; i < 12; i++){
		System.out.println(customers[i].name + " : " + customers[i].type );
	}
*/

//Creating our Rental Factory Pattern
	//Economy(5), Standard(5), Luxury(4), Suv(5), Minivan(5)
	MJMRentalCompany mjm = new MJMRentalCompany(5, 5, 4, 5, 5);
		System.out.println(mjm.getAllCarType().size());
		System.out.println(mjm.getAllCarType());
	for(int i = 0; i < 35; i++){
		//Cars can be rented
		//moighjt need to change this a bit
		if(mjm.getAllCarType().size() > 0){
			//Get Random Customers count Ex: we want 7 customers
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(12) + 0;
			//This will hold the specific index of the customer(s).
				//This will give us 7 random indexs from the 12.
			if(randomInt != 0){
				Set<Integer>  randomCustomers = new HashSet<Integer>();
				for (int j = 0; j < randomInt; j++){
					randomCustomers.add(randomGenerator.nextInt(12) + 0);
				}
				System.out.println(randomCustomers);
				//Check if they can rent car
			     for (int index : randomCustomers) {
					 //Less than 3 cars rented. Can rent another
					 if(customers[index].numOfCarsCurrentRent <3){
						 randomInt = randomGenerator.nextInt(mjm.getAllCarType().size()) + 0;
						 ArrayList<String> allCarsAvailable = mjm.getAllCarType();
						 String modeltTypeChosen = allCarsAvailable.get(randomInt);

						 int indexOfNewCar = customers[index].nextOpenIndex();

						 int returnDate = customers[index].getEarliestDaysLeft();
						 //meaning there is already a car rented and it has a day set to be renterd in
						 if(returnDate != Integer.MAX_VALUE){
							 HashMap<String, Object> paperwork = mjm.rentCar(modeltTypeChosen, returnDate , customers[index].getRandomFeatures());
							 customers[index].daysLeft[indexOfNewCar] = returnDate;
						 }
						 //first car being rented.
						 else{
						  	returnDate = randomGenerator.nextInt(customers[index].maxRentDays +1) + customers[index].minRentDays;
							HashMap<String, Object> paperwork = mjm.rentCar(modeltTypeChosen, returnDate , customers[index].getRandomFeatures());
							customers[index].daysLeft[indexOfNewCar] = returnDate;
						 }
						 //All cars must be delived at same time, can be retned differnt times tho
						 //check other params

					 }
					 //can not rent any more cars
					 else{

					 }
				}
			}



			//0 customers came in
			else{

			}


		}
		//no Cars in rental Company
		else{

		}
	}



    System.out.println("ITS ALIVE!!!!!");
  //  for(int i = 0; i < 35; i++){
      //need to check if there are any cars availaible
      //if yes
        //Need to get a random customer
          //Check if they can rent car
            //IF yes:
              //can only rent car expiring same day as the rest
              //check other params
              //randomize features
            //if no get a new cust
  //  }
  }
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
}
