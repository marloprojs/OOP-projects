package Default;

//Create Car class as the Component of the decorator
public class Decorator extends Car
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

class removeGps extends Decorator
{
    Car car;
    int cost = 10;

    public removeGps(Car car)
    {
        this.car = car;
        unplugGPS(car);
    }

    public String getFeatures()
    {
        return car.getFeatures().replace(", gps", "");
    }

    public void updateCost(Car car)
    {
        car.totalFeatureCost -= this.cost;
    }

    public void unplugGPS(Car car)
    {
        if(car.numGPS == 0)
        {
            System.out.println("Sorry, you can't remove more than zero GPSs");   
        }
        else
        {
            car.numGPS = 0;
            updateCost(car);
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

class removeSatelliteRadio extends Decorator
{
    Car car;
    int cost = 7;

    public removeSatelliteRadio(Car car)
    {
        this.car = car;
        unplugSR(car);
    }

    public String getFeatures()
    {
        return car.getFeatures().replace(", satellite radio", "");
    }

    public void updateCost(Car car)
    {
        car.totalFeatureCost -= this.cost;
    }

    public void unplugSR(Car car)
    {
        if(car.numSR == 0)
        {
            System.out.println("Sorry, you can't remove more than zero satellite radios");  
        }
        else
        {
            car.numSR = 0;
            updateCost(car);
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


class removeCarSeat extends Decorator
{
    Car car;
    int cost = 5;

    public removeCarSeat(Car car)
    {
        this.car = car;
        unplugCarSeat(car);
    }

    public String getFeatures()
    {
        return car.getFeatures().replace(", car seat", "");
    }

    public void updateCost(Car car)
    {
        car.totalFeatureCost -= this.cost;
    }

    public void unplugCarSeat(Car car)
    {
        if(car.numcarSeat == 0)
        {
            System.out.println("Sorry, you can't remove more than zero car seats");
        }
        else
        {
            car.numcarSeat -= 1;
            updateCost(car);
        }
    }
}