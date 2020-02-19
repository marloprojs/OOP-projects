
from Animal import *
from Zoo import *
from Zookeeper import *
from ZooAnnouncer import *

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
keeper = Zookeeper("Bruce",24, 250000)
an = ZooAnnouncer()
keeper.register_observer(an)
Zoo.addZookeper(keeper)

#wake up
Zoo.wakeUp()
#roll call
Zoo.rollCall()
#feed animals
Zoo.feedAnimals()
#excersize
Zoo.excersizeAnimals()
#shutdown
Zoo.shutDownZoo()
