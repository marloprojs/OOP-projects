package Default;
import java.util.*;


public abstract class RentalCompany{
  
  private HashMap<String, Stack<Car>> catalog = new HashMap<String, Stack<Car>>();
  protected ObserverableValue ov = new ObserverableValue("");
  protected CarRenter cr = new CarRenter(this.ov);


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
    
    this.ov.addObserver(this.cr);
  }
  protected abstract Stack<Car> getCars(String model, int  count);

  protected abstract Car UpdateRental(Car car, String feature);

  protected abstract Car UndoRental(Car car, String feature);

  // Pass in model, days, and list of features you want
  // Either rental record dict or null if not avalible
  public HashMap<String, Object> rentCar(String model, int days, List<String> features){
    //check if its in catalog process request
    if (this.catalog.get(model).empty() == false) {
      Car car = this.catalog.get(model).pop();
      // set features
      for (int i = 0; i < features.size(); i++) {
        car = UpdateRental(car, features.get(i));
      }
      // Update how many days its being rented
      car.days = days;
      // Do paperwork
      int price = car.getTotalCost();
      HashMap<String, Object> paperwork = creatRentalRecors(price, car, days, features);
      
      // Tell the observer
      this.ov.setValue((String)paperwork.get("statment"));

      return paperwork;
    }
    return null;
  }

  public void returnCar(Car car, List<String> features){
    // Update days
    car.days = 0;
    // Undo features
    for (int i = 0; i < features.size(); i++) {
      car = UndoRental(car, features.get(i));
    }
    // Update catalog
    String model = car.type;
    System.out.println(car.getFeatures());
    this.catalog.get(model).push(car);
    return;
  }

  public HashMap<String, Object> creatRentalRecors(int price, Car car, int days, List<String> features){
    HashMap<String, Object> record = new HashMap<String, Object>();
    // Store important things
    record.put("price", price);
    record.put("car", car);
    record.put("days", days);
    record.put("features", features);
    String statment = "The " + car.type + " with the license "+ car.licenseID+" was rented for " + days + " days for $" + price + " with " + car.getFeatures();
    record.put("statment", statment);

    return record;
  }

}