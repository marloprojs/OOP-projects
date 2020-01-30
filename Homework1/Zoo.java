import java.util.*;
public class Zoo{
  List<Animal> zooAnimals;
  Zookeeper zooKeeper;

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

  public List<Animal> getAnimals(){
    return this.zooAnimals;
  }

  public Zookeeper getZooKeeper(){
    return this.zooKeeper;
  }
  public void getNumberOfAnimals(){
    System.out.println(zooAnimals.size());
  }

  public void wakeUp(){
    for(Animal ani: this.zooAnimals){
      if (ani.isAwake == false){
        ani.isAwake = true;
        System.out.println(zooKeeper.name + " woke up "+ ani.name);
      }
      else{
        System.out.println(ani.name + " already awake");
      }
    }
  }

  public void rollCall(){
    System.out.println("Roll Call");
    String allNames= "";
    for(Animal ani: this.zooAnimals){
        allNames+= ani.name + ", ";
    }
    System.out.println(allNames);
  }

  public void feedAnimals(){
    for(Animal ani: this.zooAnimals){
      if(ani.isFed == false)
        System.out.println(zooKeeper.name + " fed "+ ani.name);
      else{
        System.out.println(ani.name + " already Fed.");
      }
    }
  }
  public void excersizeAnimals(){
    for(Animal ani: this.zooAnimals){
      System.out.println(zooKeeper.name + " excersized "+ ani.name);
    }
  }
  public void shutDownZoo(){
      System.out.println(zooKeeper.name +" shutting down zoo!");
      for(Animal ani: this.zooAnimals){
        System.out.println(zooKeeper.name +" put " + ani.name + "to sleep");
        ani.isAwake = false;
        ani.isFed = false;
      }
  }

}
