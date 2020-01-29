import java.io.*;
import java.util.Random;

class Animal
{
	public Animal()
	{
		System.out.println("REEEEEE");
	}

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
	public void roam()
	{
		System.out.println("Wandering");
	}
}

class Cat extends Feline
{
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
	public void makeNoise()
	{
		System.out.println("Roar");
	}
}

class Tiger extends Feline
{
	public void makeNoise()
	{
		System.out.println("Grrrrrr");
	}
}

class Canine extends Animal
{
	public void roam()
	{
		System.out.println("Scampering");
	}
}

class Wolf extends Canine
{
	public void makeNoise()
	{
		System.out.println("Grrrrr");
	}
}

class Dog extends Canine
{
	public void makeNoise()
	{
		System.out.println("Bark Bark");
	}
}

class Pachyderm extends Animal 
{
	public void roam()
	{
		System.out.println("Stompping");
	}
}

class Hippo extends Pachyderm
{
	public void makeNoise()
	{
		System.out.println("Whaaaa");
	}
}

class Rhino extends Pachyderm
{
	public void makeNoise()
	{
		System.out.println("Grumble Grumble");
	}
}

class Elephant extends Pachyderm
{
	public void makeNoise()
	{
		System.out.println("Raaaaaaa");
	}
}
