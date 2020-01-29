import java.io.*;
import java.util.Random;

/*class Zookeeper
{
	public Zookeeper(){System.out.println("Zookeeper");}
	public void hello(){System.out.println("hello");}
}*/

class Animal
{
	public Animal(){}

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
}

class Feline extends Animal
{
	public Feline(){}
	public void roam()
	{
		System.out.println("Wandering");
	}
}

public class Cat extends Feline
{
	public Cat(){}
	public void random_action_generator()
	{
		int num = random_number_generator();
		if(num == 0)
		{
			roam();
		}
		else
		{
			sleep();
		}
	}
	public void makeNoise()
	{
		random_action_generator();
	}
}

class Lion extends Feline
{
	public Lion(){}
	public void makeNoise()
	{
		System.out.println("Roar");
	}
}

class Tiger extends Feline
{
	public Tiger(){}
	public void makeNoise()
	{
		System.out.println("Grrrrrr");
	}
}

class Canine extends Animal
{
	public Canine(){}
	public void roam()
	{
		System.out.println("Scampering");
	}
}

class Wolf extends Canine
{
	public Wolf(){}
	public void makeNoise()
	{
		System.out.println("Grrrrr");
	}
}

class Dog extends Canine
{
	public Dog(){}
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
	public Hippo(){}
	public void makeNoise()
	{
		System.out.println("Whaaaa");
	}
}

class Rhino extends Pachyderm
{
	public Rhino(){}
	public void makeNoise()
	{
		System.out.println("Grumble Grumble");
	}
}

class Elephant extends Pachyderm
{
	public Elephant(){}
	public void makeNoise()
	{
		System.out.println("Raaaaaaa");
	}
}
