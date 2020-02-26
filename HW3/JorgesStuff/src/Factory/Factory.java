package Default;

public class Factory{
  public Car getCar(String model){
    
    Car car = null;
    if (model.equals("Economy")){
      car = new Economy("");
    }
    else if (model.equals("Standard")){
      car = new Standard("");
    }
    else if (model.equals("Luxury")){
      car = new Luxury("");
    }
    else if (model.equals("SUV")){
      car = new Suv("");
    }   
    else{
      car = new Minivan("");
    }
    return car;
  }
}




