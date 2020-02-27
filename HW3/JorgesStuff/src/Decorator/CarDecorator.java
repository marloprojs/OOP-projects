package JorgesStuff;

//Create Car class as the Component of the decorator
public abstract class CarDecorator extends Car
{
    public Car car;

//Decorator getters and setters
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

//Car getter and Setters
	public String getType(){
		return car.getType();
	}

	public int getTotalCost(){
		return car.getTotalCost();
	}
	public void setTotalCost(int val){
		car.setTotalCost(val);
	}

	public String getFeatures(){
		return car.getFeatures();
	}
	public void setFeatures(String feature){
		car.setFeatures(feature);
	}
	public void removeFeatures(String feature){
		switch (feature){
			case "gps":{
				if (getNumGPS() >0){
					setGPS(-1);
					updateTotalCost("remove");
					updateFeatures("gps, ");
				}
				else{
					System.out.println("Can not remove gps. Gps count :" + car.getNumGPS());
				}
			}
			case "satellite radio":{
				if (getNumSR() > 0){
					setSR(-1);
					updateTotalCost("remove");
					updateFeatures("satellite radio, ");
				}
				else{
					System.out.println("Can not remove satellite radio. Satellite radio count :" + car.getNumSR());
				}
				break;
			}
			case "car seat":{
				if (getNumCarSeat() > 0){
					setCarSeat(-1);
					updateTotalCost("remove");
					updateFeatures("car seat, ");
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
			case "gps":{
				if (getNumGPS() ==0){
					setGPS(1);
					updateTotalCost("add");
					setFeatures("gps, ");
				}
				else{
					System.out.println("Can not add gps. Gps count :" + car.getNumGPS());
				}
				break;
			}
			case "satellite radio":{
				if (getNumSR() ==0){
					setSR(1);
					updateTotalCost("add");
					setFeatures("satellite radio, ");
				}
				else{
					System.out.println("Can not add satellite radio. Satellite radio count :" + car.getNumSR());
				}
				break;
			}
			case "car seat":{
				if (getNumCarSeat() <4){
					setCarSeat(1);
					updateTotalCost("add");
					setFeatures("car seat, ");
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
        addFeature("gps");
    }
    public void updateTotalCost(String result){
		switch(result){
			case "add":{
				setTotalCost(this.cost);
				break;
			}
			case "remove": {
				setTotalCost(-this.cost);

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
		addFeature("satellite radio");
	}
	public void updateTotalCost(String result){
		switch(result){
			case "add":{
				setTotalCost(this.cost);
				break;
			}
			case "remove": {
				setTotalCost(-this.cost);
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
		addFeature("car seat");
	}
	public void updateTotalCost(String result){
		switch(result){
			case "add":{
				setTotalCost(this.cost);
				break;
			}
			case "remove": {
				setTotalCost(-this.cost);
				break;
			}
			default: {
				setTotalCost(0);
				break;
			}
		}
	}
}
