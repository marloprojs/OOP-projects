package JorgesStuff;

import java.util.*;

 // Factory //
public class MJMRentalCompany extends RentalCompany{

  public MJMRentalCompany(int eco, int std, int lux, int su, int min){
    super(eco, std, lux, su, min);
  }

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
        cars.push(new Luxury("lux-12" + i) );
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
	  //car = new carSeat(car)
    if (feature.equals("Car Seat")){
      car = new carSeat(car);
    }
    else if (feature.equals("GPS")){
      car = new gps(car);
    }
    else {
      car = new satelliteRadio(car);
    }
    return car;
  }

  public Car UndoRental(Car car, String feature){
	  car.removeFeatures(feature);
	  return car;
  }
}
