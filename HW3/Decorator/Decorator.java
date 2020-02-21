import java.io.*;

//Create Car class as the Component of the decorator
public class Decorator
{
    public void getFeatures(this)
    {
        System.out.println("");
    }
}

class gps extends Decorator
{
    Car car;

    public car(Car car)
    {
        this.car = car;
    }

}

class satelliteRadio extends Decorator
{
    Car car;

    public car(Car car)
    {
        this.car = car;
    }

}

class carSeat extends Decorator
{
    Car car;

    public car(Car car)
    {
        this.car = car;
    }

}