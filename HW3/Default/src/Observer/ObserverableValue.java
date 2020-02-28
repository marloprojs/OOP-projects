package Default;
import java.util.Observable;

public class ObserverableValue extends Observable
{
    String action = "";
    public ObserverableValue(String action)
    {
        this.action = action;
    }

    public void setValue(String action)
    {
      this.action = action;
      setChanged();
      notifyObservers();
    }
   public String getValue()
   {
      return action;
   }
}