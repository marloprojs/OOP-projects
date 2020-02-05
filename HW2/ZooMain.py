
from Animal import *
from Zoo import *
from Zookeeper import *
#from ZooAnnouncer import *

#class zooMain:
  #def main():

Zoo = Zoo()
Zoo.addAnimal(Cat("Charlie"))
Zoo.addAnimal( Cat("Carl"))
Zoo.addAnimal( Cat("Creg"))

Zoo.addAnimal( Lion("Larry"))
Zoo.addAnimal( Lion("Lissa"))
Zoo.addAnimal( Dog("Dennis"))
Zoo.addAnimal( Tiger("Tyler"))
Zoo.addAnimal( Wolf("Watson"))
Zoo.addAnimal( Hippo("Henry"))
Zoo.addAnimal( Elephant("Eagor"))
Zoo.addAnimal( Dog("David"))

Zoo.addZookeper( Zookeeper("Bruce",24, 250000))

#wake up
Zoo.wakeUp()
print("")
Zoo.animalMakeNoise()
#roll call
#Zoo.rollCall()
#feed animals
#Zoo.feedAnimals()
#excersize
#Zoo.excersizeAnimals()
#shutdown
#Zoo.shutDownZoo()





"""
from Animal import *

kitty = Cat()
kitty.sleep()
kitty.roam()
kitty.makeNoise()
rhino = Rhino()
Rhino.makeNoise()
dog = Dog()
dog.makeNoise()
elephant = Elephant()
elephant.makeNoise()
hippo = Hippo()
hippo.makeNoise()
pacy = Pachyderm()
pacy.roam()
dog = Dog()
dog.makeNoise()
dog.roam()
dog.sleep()
wolf = Wolf()
wolf.makeNoise()
can = Canine()
can.roam()
tiger = Tiger()
tiger.makeNoise()
lion = Lion()
lion.makeNoise()
"""
