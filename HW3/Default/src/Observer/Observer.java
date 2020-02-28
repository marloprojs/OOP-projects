package Default;

public class Observer
{
    String action = "";
    public void update(String action)
    {
        this.action = action;

    }

    public void display(String action)
    {
        System.out.println("The customer just rented " + action);
    }
}