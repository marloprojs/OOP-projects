package JorgesStuff;
import java.util.*;
//import carMain.Car;
public class carMain
{
 	public static void main(String args[])
 	{
/* Testing to make sure Decorator Works

//++++++++++++++++++++++++++++++ Test1 ++++++++++++++++++++++++++++++//
	    Car car = new Luxury("Lux123");
	    System.out.println("Car type is: " +car.getType() );
//++++++++++++++++++++++++++++++ Test2 ++++++++++++++++++++++++++++++//
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
		System.out.println("Feature List is: \n[" + features.substring(0, features.length()-1) + "]");
//++++++++++++++++++++++++++++++ End of Testing ++++++++++++++++++++++++++++++//
*/

//To Do:
	//Instantiate a Factory
		//Pass in number of eco, std, lux, su, min
			//Returns a stack of cars


      //Karen
      //For loop for 35 dats, 34 nights
        //12 customers
          //6 Casual
          //5 business
          //1 Regular
          //3 cars at a time
          // Up to 7 days of rental
          //Unique Names
        //Features:
          //Case1: Child car Seats (0 to 1)
          //Case2: GPS (0 or 1)
          //Case3: Satelite radio (0-1)
        //ArrayList[12][2] table = new ArrayList[12][2];
        //HashMap<String,String> customers = new HashMap<String,String>();
/*
    customerObject[] customers = new customerObject[12];
    customers[0] = new customerObject("Karen", "Regular");
    customers[1] = new customerObject("Charlie", "Casual");
    customers[2] = new customerObject("Denniss", "Business");
    customers[3] = new customerObject("Erwein", "Casual");
    customers[4] = new customerObject("Frank", "Business");
    customers[5] = new customerObject("Molly", "Casual");
    customers[6] = new customerObject("Bruce", "Business");
    customers[7] = new customerObject("Dee", "Casual");
    customers[8] = new customerObject("Gunter", "Business");
    customers[9] = new customerObject("Mandy", "Casual");
    customers[10] = new customerObject("Josiah", "Business");
    customers[11] = new customerObject("Mac", "Casual");
    System.out.println("ITS ALIVE!!!!!");
*/
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
}
