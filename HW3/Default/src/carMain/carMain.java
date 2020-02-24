package Default;
//import carMain.Car;
public class carMain
{
    public static void main(String args[])
    {
       // Car car = new Car("12345");
        Car economy = new Economy("55555");
        System.out.println(economy.licenseID);

        Car luxury = new Luxury("44455");
        System.out.println(luxury.licenseID);

        Car suv = new Suv("11111");
        System.out.println(suv.licenseID);

        Car minivan = new Minivan("22222");
        System.out.println(minivan.licenseID);

        Car standard = new Standard("333333");
        System.out.println(standard.licenseID);
    }
}
