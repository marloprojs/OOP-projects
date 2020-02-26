package Default;

//Create Car class as the Component of the decorator
public class Decorator
{
    Car car;

}

class gps extends Decorator
{
    Car car;

    public gps(Car car)
    {
        this.car = car;
    }

    public String getFeatures()
    {
        return car.getFeatures() + ", gps";
    }

    public void addGPS(Car car)
    {
        if(car.numGPS == 0)
        {
            car.numGPS = 1;
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

    public satelliteRadio(Car car)
    {
        this.car = car;
    }

    public String getFeatures()
    {
        return car.getFeatures() + ", satellite radio";
    }

    public void addSR(Car car)
    {
        if(car.numSR == 0)
        {
            car.numSR = 1;
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

    public carSeat(Car car)
    {
        this.car = car;
    }

    public String getFeatures()
    {
        return car.getFeatures() + ", car seat";
    }

    public void addCarSeat(Car car)
    {
        if(car.numcarSeat < 4)
        {
            car.numcarSeat += 1;
        }
        else
        {
            System.out.println("Sorry, you can't rent more than four car seats per car");
        }
    }
}