package Default;

//Create Car class as the Component of the decorator
public class Decorator
{
    Car car;
}

class gps extends Decorator
{
    Car car;
    int cost = 10;

    public gps(Car car)
    {
        this.car = car;
        addGPS(car);
    }

    public String getFeatures()
    {
        return car.getFeatures() + ", gps";
    }

    public void updateCost(Car car)
    {
        car.totalFeatureCost += this.cost;
    }

    public void addGPS(Car car)
    {
        if(car.numGPS == 0)
        {
            car.numGPS = 1;
            updateCost(car);
        }
        else
        {
            System.out.println("Sorry, you can't rent more than one GPS per car");
        }
    }

}

class satelliteRadio extends Decorator
{
    Car car;
    int cost = 7;

    public satelliteRadio(Car car)
    {
        this.car = car;
        addSR(car);
    }

    public String getFeatures()
    {
        return car.getFeatures() + ", satellite radio";
    }

    public void updateCost(Car car)
    {
        car.totalFeatureCost += this.cost;
    }

    public void addSR(Car car)
    {
        if(car.numSR == 0)
        {
            car.numSR = 1;
            updateCost(car);
        }
        else
        {
            System.out.println("Sorry, you can't rent more than one satellite radio per car");
        }
    }

}

class carSeat extends Decorator
{
    Car car;
    int cost = 5;

    public carSeat(Car car)
    {
        this.car = car;
        addCarSeat(car);
    }

    public String getFeatures()
    {
        return car.getFeatures() + ", car seat";
    }

    public void updateCost(Car car)
    {
        car.totalFeatureCost += this.cost;
    }

    public void addCarSeat(Car car)
    {
        if(car.numcarSeat < 4)
        {
            car.numcarSeat += 1;
            updateCost(car);
        }
        else
        {
            System.out.println("Sorry, you can't rent more than four car seats per car");
        }
    }
}