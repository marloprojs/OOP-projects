import random

#Yuck Look at this code!


#Animal class is the superclass, variables include the animal's name, if it's been fed, and if it's awake
class Animal:
    def __init__(self, name="", isAwake=false, isFed=false):
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
    def __init__(self, name="", isAwake=false, isFed=false):
        Animal.__init__(self, name="", isAwake=false, isFed=false)

	def roam():
		print("Wandering")

#Cat is a subclass of Feline
class Cat (Feline):
	def __init__(self, name="", isAwake=false, isFed=false):
        Feline.__init__(self, name="", isAwake=false, isFed=false)

    #The cat's action is unpredictable, hence the random action generator for when it makes a noise
	def random_action_generator():
		num = random_number_generator()
		if(num == 0)
			roam()
		else:
			print("Meow!")
	def makeNoise():
		random_action_generator()

#Lion is a subclass of Feline
class Lion(Feline):
	def __init__(self, name="", isAwake=false, isFed=false):
        Feline.__init__(self, name="", isAwake=false, isFed=false)
	def makeNoise():
		print("Roar")

#Tiger is a subclass of Feline
class Tiger (Feline)
	def __init__(self, name="", isAwake=false, isFed=false):
        Feline.__init__(self, name="", isAwake=false, isFed=false)
	def makeNoise():
		print("Grrrrrr")

#Canine is a subclass of Animal
class Canine (Animal):
    def __init__(self, name="", isAwake=false, isFed=false):
        Animal.__init__(self, name="", isAwake=false, isFed=false)
	def roam():
		print("Scampering")


#Wolf is a subclass of Canine
class Wolf (Canine):
	def __init__(self, name="", isAwake=false, isFed=false):
        Canine.__init__(self, name="", isAwake=false, isFed=false)
	def makeNoise():
		System.out.println("Grrrrr")


#Dog is a subclass of Canine
class Dog(Canine):
	def __init__(self, name="", isAwake=false, isFed=false):
        Canine.__init__(self, name="", isAwake=false, isFed=false)
	def makeNoise():
		print("Bark Bark")


#Pachyderm is a subclass of Animal
class Pachyderm(Animal):
    def __init__(self, name="", isAwake=false, isFed=false):
        Animal.__init__(self, name="", isAwake=false, isFed=false)
	def roam():
		print("Stompping")


#Hippo is a subclass of Pachyderm
class Hippo(Pachyderm):
	def __init__(self, name="", isAwake=false, isFed=false):
        Pachyderm.__init__(self, name="", isAwake=false, isFed=false)
	def makeNoise():
		print("Whaaaa")


#Rhino is a subclass of Pachyderm
class Rhino(Pachyderm):
    def __init__(self, name="", isAwake=false, isFed=false):
        Pachyderm.__init__(self, name="", isAwake=false, isFed=false)
    def makeNoise():
		print("Grumble Grumble")


#Elephant is a subclass of Pachyderm
class Elephant(Pachyderm):
    def __init__(self, name="", isAwake=false, isFed=false):
        Animal.__init__(self, name="", isAwake=false, isFed=false)
	def makeNoise():
		print("Raaaaaaa")
