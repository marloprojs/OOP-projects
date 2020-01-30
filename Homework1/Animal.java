import java.io.*;
import java.util.Random;

//Animal class is the superclass, variables include the animal's name, if it's been fed, and if it's awake
public class Animal
{
  public String name = "";
  public boolean isAwake = false;
  public boolean isFed = false;

	public void sleep()
	{
		System.out.println("Sleeping");
	}
	public int random_number_generator()
	{
		Random rand = new Random();
		int num = rand.nextInt(2);
		return num;
	}
  public void makeNoise(){
    System.out.println("");
  }
}

//Feline is a subclass of Animal
class Feline extends Animal
{
	public Feline(){}
	public void roam()
	{
		System.out.println("Wandering");
	}
}

//Cat is a subclass of Feline
class Cat extends Feline
{
	public Cat(String name){
    this.name=name;
  }
  //The cat's action is unpredictable, hence the random action generator for when it makes a noise
	public void random_action_generator()
	{
		int num = random_number_generator();
		if(num == 0)
		{
			roam();
		}
		else
		{
			System.out.println("Meow!");
		}
	}
	public void makeNoise()
	{
		random_action_generator();
	}
}

//Lion is a subclass of Feline
class Lion extends Feline
{
	public Lion(String name){
    this.name = name;
  }
	public void makeNoise()
	{
		System.out.println("Roar");
	}
}

//Tiger is a subclass of Feline
class Tiger extends Feline
{
	public Tiger(String name){
    this.name = name;
  }
	public void makeNoise()
	{
		System.out.println("Grrrrrr");
	}
}

//Canine is a subclass of Animal 
class Canine extends Animal
{
//	public Canine(){}
	public void roam()
	{
		System.out.println("Scampering");
	}
}

//Wolf is a subclass of Canine
class Wolf extends Canine
{
	public Wolf(String name){
    this.name = name;
  }
	public void makeNoise()
	{
		System.out.println("Grrrrr");
	}
}

//Dog is a subclass of Canine
class Dog extends Canine
{
	public Dog(String name){
    this.name = name;
  }
	public void makeNoise()
	{
		System.out.println("Bark Bark");
	}
}

//Pachyderm is a subclass of Animal
class Pachyderm extends Animal
{
	public Pachyderm(){}
	public void roam()
	{
		System.out.println("Stompping");
	}
}

//Hippo is a subclass of Pachyderm
class Hippo extends Pachyderm
{
	public Hippo(String name ){
    this.name = name;
  }
	public void makeNoise()
	{
		System.out.println("Whaaaa");
	}
}

//Rhino is a subclass of Pachyderm
class Rhino extends Pachyderm
{
	public Rhino(String name){
    this.name = name;
  }
	public void makeNoise()
	{
		System.out.println("Grumble Grumble");
	}
}

//Elephant is a subclass of Pachyderm
class Elephant extends Pachyderm
{
	public Elephant(String name){
    this.name = name;
  }
	public void makeNoise()
	{
		System.out.println("Raaaaaaa");
	}
}
