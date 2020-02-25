package Default;


public abstract class RentalCompany{
  
  protected abstract Car getCar(String model);

  public Car rentCar(String model){
    Car car = getCar(model);
    //set other attributes with the car
    //set return date checkout date
    //check if we have any left?
    return car;
  }

}