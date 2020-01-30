public class zooMain{
  public static void main(String args[]){

    Zoo newZoo = new Zoo();
    newZoo.addAnimal(new Cat("Charlie"));
    newZoo.addAnimal(new Cat("Carl"));
    newZoo.addAnimal(new Cat("Creg"));
    newZoo.addAnimal(new Lion("Larry"));
    newZoo.addAnimal(new Lion("Lissa"));
    newZoo.addAnimal(new Dog("Dennis"));
    newZoo.addAnimal(new Tiger("Tyler"));
    newZoo.addAnimal(new Wolf("Watson"));
    newZoo.addAnimal(new Hippo("Henry"));
    newZoo.addAnimal(new Elephant("Eagor"));
    newZoo.addAnimal(new Dog("David"));
    newZoo.addZookeper(new Zookeeper("Bruce",24, 250000));

    //wake up
    newZoo.wakeUp();
    //roll call
    newZoo.rollCall();
    //feed animals
    newZoo.feedAnimals();
    //excersize
    newZoo.excersizeAnimals();
    //shutdown
    newZoo.shutDownZoo();
    return ;
  }
}
