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

}