import java.io.*;
import java.util.Random;

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

class Feline extends Animal
{
	public Feline(){}
	public void roam()
	{
		System.out.println("Wandering");
	}
}

class Cat extends Feline
{
	public Cat(String name){
    this.name=name;
  }
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

class Canine extends Animal
{
//	public Canine(){}
	public void roam()
	{
		System.out.println("Scampering");
	}
}

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

class Pachyderm extends Animal
{
	public Pachyderm(){}
	public void roam()
	{
		System.out.println("Stompping");
	}
}

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
