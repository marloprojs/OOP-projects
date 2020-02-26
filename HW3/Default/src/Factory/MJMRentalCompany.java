package Default;


public class MJMRentalCompany extends RentalCompany{
  
  // This is the factory????
  public Stack<Car> getCars(String model, int count){
    Stack<Car> cars = new Stack<Car>();

    if (model.equals("Economy")){
      for( int i = 0; i < count; i++){
        cars.push(new Economy("eco-12"+i));
      }
    }
    else if (model.equals("Standard")){
      for( int i = 0; i < count; i++){
        cars.push(new Standard("std-12"+i));
      }
    }
    else if (model.equals("Luxury")){
      for( int i = 0; i < count; i++){
        cars.push(new Luxury("lux-12"+i));
      }
    }
    else if (model.equals("SUV")){
      for( int i = 0; i < count; i++){
        cars.push(new Suv("suv-12"+i));
      }
    }   
    else{
      for( int i = 0; i < count; i++){
        cars.push(new Minivan("min-12"+i));
      }
    }
    return cars;
  }
  
  public Car UpdateRental(Car car, String feature){
    if (feature.equals("Car Seat")){
      car = new carSeat(car);
      //price = car.rentalPrice;
    }
    else if (feature.equals("GPS")){
      car = new gps(car);
    }
    else {
      car = new satelliteRadio(car);
    }
    return car;
  }
}