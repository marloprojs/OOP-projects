package JorgesStuff;

//Create Car class as the Component of the decorator
public abstract class CarDecorator extends Car
{
    public Car car;

//Decorator Feaitre getters and setters
	public int getNumGPS(){
	  return car.getNumGPS();
	}
	public int getNumCarSeat(){
		return car.getNumCarSeat();
	}
	public int getNumSR(){
		return car.getNumSR();
	}
	public void setSR(int val){
		car.setSR(val);
	}
	public void setGPS(int val){
		car.setGPS(val);
	}
	public void setCarSeat(int val){
		car.setCarSeat(val);
	}


//Car Param Getters and Setters (need these or else wont update properly)
	public void setDailyCost(int val){
		car.setDailyCost(val);
	}
	public int getDailyCost(){
		return car.getDailyCost();
	}
	public void setDays(int days){
		car.setDays(days);
	}
	public int getDays(){
		return car.getDays();
	}
	public String getType(){
		return car.getType();
	}
	public String getLicense(){
		return car.getLicense();
	}
	public int getTotalCost(){
		return car.getTotalCost();
	}
	public void setTotalCost(int val){
		System.out.println("In Decorator: " + car.getTotalCost() + ":" + val);
		car.setTotalCost(val);
	}
	public void setTotalFeatureCost(int val){
		car.setTotalFeatureCost(val);
	}
	public String getFeatures(){
		return car.getFeatures();
	}
	public void setFeatures(String feature){
		car.setFeatures(feature);
	}
	public void updateFeatures(String feature){
		car.updateFeatures(feature);
	}
	//Nast functions below. Sorry.
	public void removeFeatures(String feature){
		switch (feature){
			case "GPS":{
				if (getNumGPS() >0){
					setGPS(-1);
					updateTotalCost("remove");
					updateFeatures("GPS, ");
					System.out.println("Removed GPS. Remainig features: " +car.getFeatures());
				}
				else{
					System.out.println("Can not remove gps. Gps count :" + car.getNumGPS());
				}
				break;
			}
			case "Satellite Radio":{
				if (getNumSR() > 0){
					setSR(-1);
					updateTotalCost("remove");
					updateFeatures("Satellite Radio, ");
					System.out.println("Removed Satellite Radio. Remainig features: " +car.getFeatures());
				}
				else{
					System.out.println("Can not remove satellite radio. Satellite radio count :" + car.getNumSR());
				}
				break;
			}
			case "Car Seat":{
				if (getNumCarSeat() > 0){
					setCarSeat(-1);
					updateTotalCost("remove");
					updateFeatures("Car Seat, ");
					System.out.println("Removed Car Seat. Remainig features: " +car.getFeatures());

				}
				else{
					System.out.println("Can not remove car seat. Car seat count :" + car.getNumCarSeat());
				}
				break;
			}
			default:{
				System.out.println("ERROR");
			}
		}
	}
	public void addFeature(String feature){
		switch (feature){
			case "GPS":{
				if (getNumGPS() ==0){
					setGPS(1);
					updateTotalCost("add");
					setFeatures("GPS, ");
				}
				else{
					System.out.println("Can not add gps. Gps count :" + car.getNumGPS());
				}
				break;
			}
			case "Satellite Radio":{
				if (getNumSR() ==0){
					setSR(1);
					updateTotalCost("add");
					setFeatures("Satellite Radio, ");
				}
				else{
					System.out.println("Can not add satellite radio. Satellite radio count :" + car.getNumSR());
				}
				break;
			}
			case "Car Seat":{
				if (getNumCarSeat() <4){
					setCarSeat(1);
					updateTotalCost("add");
					setFeatures("Car Seat, ");
				}
				else{
					System.out.println("Can not add car seat. Car seat count :" + car.getNumCarSeat());
				}
				break;
			}
			default:{
				System.out.println("ERROR");
				break;
			}
		}
	}
//Abstract class
	public abstract void updateTotalCost(String result);
}

class gps extends CarDecorator{
	int cost = 10;

	public gps(Car car2){
        this.car = car2;
        addFeature("GPS");
    }
    public void updateTotalCost(String result){
		switch(result){
			case "add":{
				setTotalFeatureCost(this.cost);
				break;
			}
			case "remove": {
				setTotalFeatureCost(-this.cost);

				break;
			}
			default: {
				setTotalCost(0);
				break;
			}
		}
	}
}

class satelliteRadio extends CarDecorator{
    int cost = 7;

    public satelliteRadio(Car car2){
        this.car = car2;
		addFeature("Satellite Radio");
	}
	public void updateTotalCost(String result){
		switch(result){
			case "add":{
				setTotalFeatureCost(this.cost);
				break;
			}
			case "remove": {
				setTotalFeatureCost(-this.cost);
				break;
			}
			default: {
				setTotalCost(0);
				break;
			}
		}
	}
}

class carSeat extends CarDecorator{
    int cost = 5;

    public carSeat(Car car){
        this.car = car;
		addFeature("Car Seat");
	}
	public void updateTotalCost(String result){
		switch(result){
			case "add":{
				setTotalFeatureCost(this.cost);
				break;
			}
			case "remove": {
				setTotalFeatureCost(-this.cost);
				break;
			}
			default: {
				setTotalCost(0);
				break;
			}
		}
	}
}
