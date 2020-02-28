package JorgesStuff;
import java.util.*;


public abstract class RentalCompany{

  private HashMap<String, Stack<Car>> catalog = new HashMap<String, Stack<Car>>();

  //constructor (set the catalog)
  public RentalCompany(int eco, int std, int lux, int su, int min){
    Stack<Car> economy = getCars("Economy", eco);
    Stack<Car> standard = getCars("Standard", std);
    Stack<Car> luxury = getCars("Luxury", lux);
    Stack<Car> suv = getCars("Suv", su);
    Stack<Car> minivan = getCars("Minivan", min);

    this.catalog.put("Economy", economy);
    this.catalog.put("Standard", standard);
    this.catalog.put("Luxury", luxury);
    this.catalog.put("SUV", suv);
    this.catalog.put("Minivan", minivan);
  }
  protected abstract Stack<Car> getCars(String model, int  count);

  protected abstract Car UpdateRental(Car car, String feature);

  protected abstract Car UndoRental(Car car, String feature);

  public ArrayList<String> getAllCarType(){
	  ArrayList<String> carList = new ArrayList<String>();
	  String model;
	  //getting the model types into a set
   	  Set<String> keys = catalog.keySet();
	  	//adding to totalCount
		for(Iterator<String> it = keys.iterator(); it.hasNext(); ) {
			model = it.next();
			for(int i = 0; i < this.catalog.get(model).size(); i++){
				carList.add(model);
			}

		}
		return carList;
  }
  // Pass in model, days, and list of features you want
  // Either rental record dict or null if not avalible
  public Car rentCar(String model, int days, List<String> features){
    //check if its in catalog process request
    if (this.catalog.get(model).empty() == false) {
      Car car = this.catalog.get(model).pop();
	  System.out.println(car.getLicense());
	   car.setDays(days);
      // set features
      for (int i = 0; i < features.size(); i++) {
        car = UpdateRental(car, features.get(i));
      }
      // Do paperwork
      int price = car.getTotalCost();

      HashMap<String, Object> paperwork = creatRentalRecors(price, car, days, features);

      return car;
    }
    return null;
  }

  public void returnCar(Car car, List<String> features){
    // Update days
	car.setDays(0);
    // Undo features

    for (int i = 0; i < features.size(); i++) {
		car = UndoRental(car, features.get(i));
    }
	System.out.println("Check for no Features:[" +car. getFeatures() + "]");
    // Update catalog
    String model = car.getType();
	System.out.println(model);
    this.catalog.get(model).push(car);

	String statment = "The " + car.getType() + " car with the license "+ car.getLicense()+" was returned and set to " + car.getDays() + " days at $" + car.getDailyCost() + " with default features [" +car.getFeatures()+"]";
	System.out.println(statment);

    return;
  }

  public HashMap<String, Object> creatRentalRecors(int price, Car car, int days, List<String> features){
    HashMap<String, Object> record = new HashMap<String, Object>();
    // Store important things
    record.put("price", price);
    record.put("car", car);
    record.put("days", days);
    record.put("features", features);
	//String prettyFeatures = car.getFeatures().substring(0,car.getFeatures().length()-2);
    String statment = "The " + car.getType() + " car with the license "+ car.getLicense()+" was rented for " + car.getDays() + " days for $" + price + " with features [" +car.getFeatures()+"]";
    record.put("statment", statment);

    return record;
  }

}
