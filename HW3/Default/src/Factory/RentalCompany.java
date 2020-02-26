package Default;
import java.util.*;


public abstract class RentalCompany{
  
  private HashMap<String, Stack<Car>> catalog = new HashMap<String, Stack<Car>>();
  
  //constructor (set the catalog)
  public RentalCompany(int eco, int std, int lux, int su, int min){
    Stack<Car> economy = getCars("Economy", eco);
    Stack<Car> standard = getCars("Standard", std);
    Stack<Car> luxury = getCars("Luxury", lux);
    Stack<Car> suv = getCars("SUV", su);
    Stack<Car> minivan = getCars("Minivan", min);

    this.catalog.put("Economy", economy);
    this.catalog.put("Standard", standard);
    this.catalog.put("Luxury", luxury);
    this.catalog.put("SUV", suv);
    this.catalog.put("Minivan", minivan);
  }
  protected abstract Stack<Car> getCars(String model, int  count);

  protected abstract Car UpdateRental(Car car, String feature);

  public Car rentCar(String model){
    //check if its in catalog
    if (this.catalog.get(model).empty() == false) {
      // grab the car
      Car car = this.catalog.get(model).pop();
      //set other attributes with the car (gps, radio,.. etc)
      //set return date
      //set checkout date
      return car;
    }
    return null;
  }

  public void returnCar(Car car){
    //update catalog
    String model = car.model;
    this.catalog.get(model).push(car);
    //set other attributes with the car
    //set return date checkout date
    //check if we have any left?
    return;
  }

  //public String creatRentalRecors(price, car, how many nights, features, ){}

}