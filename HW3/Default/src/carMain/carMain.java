package Default;
import java.util.*;
//import carMain.Car;
public class carMain
{
  public static void main(String args[])
  {
    //To do:
      //Make our car rental place
      

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

    for(int i = 0; i < 35; i++){
      //need to check if there are any cars availaible
      //if yes
        //Need to get a random customer
          //Check if they can rent car
            //IF yes:
              //can only rent car expiring same day as the rest
              //check other params
              //randomize features
            //if no get a new cust
    }
  }
}
