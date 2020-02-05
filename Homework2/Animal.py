import random

#Yuck Look at this code!


#Animal class is the superclass, variables include the animal's name, if it's been fed, and if it's awake
class Animal(object):
	def __init__(self, name="", isAwake=False, isFed=False):
		name = name
		isAwake = isAwake
		isFed = isFed

	def sleep():
		print("Sleeping")

	def random_number_generator():
		num = random.randrange(2)
		return num

	def makeNoise():
		print("")

#Feline is a subclass of Animal
class Feline(Animal):
	def __init__(self, name="", isAwake=False, isFed=False):
		Animal.__init__(self, name="", isAwake=False, isFed=False)

	def roam():
		print("Wandering")

#Cat is a subclass of Feline
class Cat(Feline):
	def __init__(self, name="", isAwake=False, isFed=False):
		Feline.__init__(self, name="", isAwake=False, isFed=False)

    #The cat's action is unpredictable, hence the random action generator for when it makes a noise
	def random_action_generator():
		num = random_number_generator()
		if num == 0:
			roam()
		else:
			print("Meow!")
	def makeNoise():
		random_action_generator()

#Lion is a subclass of Feline
class Lion(Feline):
	def __init__(self, name="", isAwake=False, isFed=False):
		Feline.__init__(self, name="", isAwake=False, isFed=False)
	def makeNoise():
		print("Roar")

#Tiger is a subclass of Feline
class Tiger(Feline):
	def __init__(self, name="", isAwake=False, isFed=False):
		Feline.__init__(self, name="", isAwake=False, isFed=False)
	def makeNoise():
		print("Grrrrrr")

#Canine is a subclass of Animal
class Canine (Animal):
	def __init__(self, name="", isAwake=False, isFed=False):
		Animal.__init__(self, name="", isAwake=False, isFed=False)
	def roam():
		print("Scampering")


#Wolf is a subclass of Canine
class Wolf (Canine):
	def __init__(self, name="", isAwake=False, isFed=False):
		Canine.__init__(self, name="", isAwake=False, isFed=False)
	def makeNoise():
		System.out.println("Grrrrr")


#Dog is a subclass of Canine
class Dog(Canine):
	def __init__(self, name="", isAwake=False, isFed=False):
		Canine.__init__(self, name="", isAwake=False, isFed=False)
	def makeNoise():
		print("Bark Bark")


#Pachyderm is a subclass of Animal
class Pachyderm(Animal):
	def __init__(self, name="", isAwake=False, isFed=False):
		Animal.__init__(self, name="", isAwake=False, isFed=False)
	def roam():
		print("Stompping")


#Hippo is a subclass of Pachyderm
class Hippo(Pachyderm):
	def __init__(self, name="", isAwake=False, isFed=False):
		Pachyderm.__init__(self, name="", isAwake=False, isFed=False)
	def makeNoise():
		print("Whaaaa")


#Rhino is a subclass of Pachyderm
class Rhino(Pachyderm):
	def __init__(self, name="", isAwake=False, isFed=False):
		Pachyderm.__init__(self, name="", isAwake=False, isFed=False)
	def makeNoise():
		print("Grumble Grumble")


#Elephant is a subclass of Pachyderm
class Elephant(Pachyderm):
	def __init__(self, name="", isAwake=False, isFed=False):
		Animal.__init__(self, name="", isAwake=False, isFed=False)
	def makeNoise():
		print("Raaaaaaa")
