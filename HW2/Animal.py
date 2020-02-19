import random
from Strategy import *

#Animal class is the superclass, variables include the animal's name, if it's been fed, and if it's awake
class Animal(object):
	#Strategy Implementation: Strategy is defined by animal type and passed in, in init to self._makeNoise_strategy.
	def __init__(self, name="",strgy = "", isAwake=False, isFed=False):
		self.name = name
		self.isAwake = isAwake
		self.isFed = isFed
		self._makeNoise_strategy = strgy

	def sleep(self):
		print("Sleeping")

	def random_number_generator(self):
		num = random.randrange(2)
		return num
	#Strategy Pattern Implementation: calling in the makeNoise Strategy for the specific animal
	def makeNoise(self):
		self._makeNoise_strategy.makeNoise()

#Feline is a subclass of Animal
class Feline(Animal):
	def __init__(self, name="",strgy = "", isAwake=False, isFed=False):
		Animal.__init__(self, name=name,strgy = strgy, isAwake=False, isFed=False)

	def roam(self):
		return("Wandering")



#Strategy Implementation: For each low level class, we are defidning the strategy to use from the strategy file.
#Cat is a subclass of Feline
class Cat(Feline):
	def __init__(self, name="", isAwake=False, isFed=False):
		Feline.__init__(self, name=name,strgy = catMakeNoise(), isAwake=False, isFed=False)

    #The cat's action is unpredictable, hence the random action generator for when it makes a noise
	def random_action_generator(self):
		num = self.random_number_generator()
		if num == 0:
			return (self.roam())
		else:
			return (self._makeNoise_strategy.makeNoise())
	def makeNoise(self):
		return (self.random_action_generator())


#Lion is a subclass of Feline
class Lion(Feline):
	def __init__(self, name="",strgy = lionMakeNoise(), isAwake=False, isFed=False):
		Feline.__init__(self, name=name, strgy = strgy ,isAwake=False, isFed=False)
	def makeNoise(self):
		return(self._makeNoise_strategy.makeNoise())

#Tiger is a subclass of Feline
class Tiger(Feline):
	def __init__(self, name="",strgy =tigerMakeNoise(), isAwake=False, isFed=False):
		Feline.__init__(self, name=name, strgy = strgy, isAwake=False, isFed=False)
	def makeNoise(self):
		return(self._makeNoise_strategy.makeNoise())

#Canine is a subclass of Animal
class Canine (Animal):
	def __init__(self, name="",strgy = "", isAwake=False, isFed=False):
		Animal.__init__(self, name=name,strgy = strgy, isAwake=False, isFed=False)
	def roam(self):
		return("Scampering")


#Wolf is a subclass of Canine
class Wolf(Canine):
	def __init__(self, name="", strgy = wolfMakeNoise(), isAwake=False, isFed=False):
		Canine.__init__(self, name=name, strgy = strgy ,isAwake=False, isFed=False)
	def makeNoise(self):
		return (self._makeNoise_strategy.makeNoise())


#Dog is a subclass of Canine
class Dog(Canine):
	def __init__(self, name="", strgy = dogMakeNoise(), isAwake=False, isFed=False):
		Canine.__init__(self, name=name,strgy = strgy, isAwake=False, isFed=False)
	def makeNoise(self):
		return (self._makeNoise_strategy.makeNoise())


#Pachyderm is a subclass of Animal
class Pachyderm(Animal):
	def __init__(self, name="", strgy = "", isAwake=False, isFed=False):
		Animal.__init__(self, name=name, strgy =strgy, isAwake=False, isFed=False)
	def roam(self):
		return("Stomping")


#Hippo is a subclass of Pachyderm
class Hippo(Pachyderm):
	def __init__(self, name="", strgy = hippoMakeNoise(), isAwake=False, isFed=False):
		Pachyderm.__init__(self, name=name,strgy = strgy, isAwake=False, isFed=False)
	def makeNoise(self):
		return (self._makeNoise_strategy.makeNoise())


#Rhino is a subclass of Pachyderm
class Rhino(Pachyderm):
	def __init__(self, name="", strgy = rhinoMakeNoise(), isAwake=False, isFed=False):
		Pachyderm.__init__(self, name=name,strgy = strgy, isAwake=False, isFed=False)
	def makeNoise():
		return (self._makeNoise_strategy.makeNoise())


#Elephant is a subclass of Pachyderm
class Elephant(Pachyderm):
	def __init__(self, name="", strgy = elephantMakeNoise(), isAwake=False, isFed=False):
		Animal.__init__(self, name=name, strgy = strgy, isAwake=False, isFed=False)
	def makeNoise(self):
		return (self._makeNoise_strategy.makeNoise())
