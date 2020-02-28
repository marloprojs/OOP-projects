package Default;
import java.util.Observable;
import java.util.Observer;

public class CarRenter implements Observer
{
    private ObserverableValue ov = null;
    public CarRenter(ObserverableValue ov)
    {
      this.ov = ov;
    }
   public void update(Observable obs, Object obj)
   {
      if (obs == ov)
      {
         System.out.println(ov.getValue());
      }
   }
}