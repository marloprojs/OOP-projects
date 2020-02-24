package Default;

//Create Car class as the Component of the decorator
public class Decorator
{
    public Decorator(){
        System.out.println("decoTest");
      }
    public void getFeatures()
    {
        System.out.println("");
    }
}

class gps extends Decorator
{
    Car car;

    public void car(Car car)
    {
        this.car = car;
    }

}

class satelliteRadio extends Decorator
{
    Car car;

    public void car(Car car)
    {
        this.car = car;
    }

}

class carSeat extends Decorator
{
    Car car;

    public void car(Car car)
    {
        this.car = car;
    }

}