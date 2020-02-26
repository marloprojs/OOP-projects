package JorgesStuff;

//Create Car class as the Component of the decorator
public abstract class CarDecorator extends Car
{
    public Car car;
    public abstract String getFeatures();

    public int getNumGPS(){
      return car.getNumGPS();
    }
	public void setGPS(){
		car.setGPS();
	}
	public int getNumSR(){
		return car.getNumSR();
	}
	public void setSR(){
		car.setSR();
	}
	public int getNumCarSeat(){
		return car.getNumCarSeat();
	}
	public void setCarSeat(){
		car.setCarSeat();
	}
}

class gps extends CarDecorator{
	int cost = 10;
 	Boolean newGps = false;

	public gps(Car car2){
        this.car = car2;
        addGPS();
    }

    public String getType(){
      return car.getType();
    }

    public void addGPS(){
        if(car.getNumGPS() == 0){
			car.setGPS();
            newGps = true;
        }
        else
      		System.out.println("Sorry, you can't rent more than one GPS per car");
    }

    public String getFeatures(){
		if(newGps)
        	return car.getFeatures() + "gps, ";
		else
			return car.getFeatures() ;
	}

	public int getTotalCost(){
      if(newGps)
        return car.getTotalCost() + this.cost;
      else
        return car.getTotalCost();
    }
}

class satelliteRadio extends CarDecorator{
    int cost = 7;
	Boolean newSR = false;

    public satelliteRadio(Car car2){
        this.car = car2;
        addSR();
    }

	public String getType(){
      return car.getType();
    }

	public void addSR(){
        if(car.getNumSR() == 0){
            car.setSR();
			newSR = true;
        }
        else{
            System.out.println("Sorry, you can't rent more than one satellite radio per car");
        }
    }

	public String getFeatures(){
		if(newSR)
        	return car.getFeatures() + "satellite radio, ";
		else
			return car.getFeatures();
    }

	public int getTotalCost(){
	  if(newSR)
		return car.getTotalCost() + this.cost;
	  else
		return car.getTotalCost();
	}
}

class carSeat extends CarDecorator{
    int cost = 5;
	boolean newCarSeat = false;

    public carSeat(Car car){
        this.car = car;
        addCarSeat();
    }

	public String getType(){
	  return car.getType();
	}

	public String getFeatures(){
        return car.getFeatures() + "car seat, ";
    }

    public void addCarSeat(){
        if(car.getNumCarSeat() < 4){
            car.setCarSeat();
			newCarSeat = true;
        }
        else{
            System.out.println("Sorry, you can't rent more than four car seats per car");
        }
    }
	public int getTotalCost(){
	  if(newCarSeat)
		return car.getTotalCost() + this.cost;
	  else
		return car.getTotalCost();
	}
}
