import java.util.*;

//Zoo class with methods to get details on the zoo and actions that can occur at the zoo
public class Zoo{
  List<Animal> zooAnimals;
  Zookeeper zooKeeper;

//Construct a zoo with animals and zoo keeper
  public Zoo(){
    zooAnimals =new ArrayList<Animal>();
    zooKeeper = null;
  }
  public void addZookeper(Zookeeper keeper){
    zooKeeper = keeper;
  }
  public void addAnimal(Animal newAnimal){
    zooAnimals.add(newAnimal);
  }

//Get list of animals in zoo
  public List<Animal> getAnimals(){
    return this.zooAnimals;
  }

//Get zoo keeper
  public Zookeeper getZooKeeper(){
    return this.zooKeeper;
  }

  //Number of animals in the zoo
  public void getNumberOfAnimals(){
    System.out.println(zooAnimals.size());
  }

//Wake up all of the animals in the zoo if they're not already awake
  public void wakeUp(){
    String allNames= "";
    for(Animal ani: this.zooAnimals){
      if (ani.isAwake == false){
        ani.isAwake = true;
        allNames+= ani.name + ", ";
      }
      else{
        System.out.println(ani.name + " already awake");
      }
    }
    System.out.println(zooKeeper.name + " woke up "+ allNames);
  }

//Roll call all of the animals: call out the animals' names
  public void rollCall(){
    System.out.println("Roll Call");
    String allNames= "";
    for(Animal ani: this.zooAnimals){
        allNames+= ani.name + ", ";
    }
    System.out.println(allNames);
  }

//Feed all of the animals in the zoo if they haven't already been fed
  public void feedAnimals(){
    String allNames= "";
    for(Animal ani: this.zooAnimals){
      if(ani.isFed == false)
        allNames+= ani.name + ", ";
      else{
        System.out.println(ani.name + " already Fed.");
      }
    }
    System.out.println(zooKeeper.name + " fed "+ allNames);
  }

  //Exercise all of the animals in the zoo
  public void excersizeAnimals(){
    String allNames= "";
    for(Animal ani: this.zooAnimals){
      allNames+= ani.name + ", ";
    }
    System.out.println(zooKeeper.name + " excersized "+ allNames);
  }

  //Reset the zoo - all of the animals haven't been fed and are asleep after reset
  public void shutDownZoo(){
    String allNames= "";
      System.out.println(zooKeeper.name +" shutting down zoo!");
      for(Animal ani: this.zooAnimals){
        allNames+= ani.name + ", ";
        ani.isAwake = false;
        ani.isFed = false;
      }
      System.out.println(zooKeeper.name +" put " + allNames + "to sleep");
  }

}
