package Default;
//import carMain.Car;
public class carMain
{
    public static void main(String args[])
    {
       // Car car = new Car("12345");
        Car economy = new Economy("55555");
        System.out.println(economy.licenseID);
        System.out.println(economy.numGPS);

        Car luxury = new Luxury("44455");
        System.out.println(luxury.licenseID);
        System.out.println(luxury.numGPS);

        Car suv = new Suv("11111");
        System.out.println(suv.licenseID);
        System.out.println(suv.numGPS);

        Car minivan = new Minivan("22222");
        System.out.println(minivan.licenseID);
        System.out.println(minivan.numGPS);

        Car standard = new Standard("333333");
        System.out.println(standard.licenseID);
        System.out.println(standard.numGPS);
    }
}
