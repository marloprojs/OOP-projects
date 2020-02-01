

#Zoo class with methods to get details on the zoo and actions that can occur at the zoo
class Zoo:
    #Construct a zoo with animals and zoo keeper
    def __init__(self):
        zooAnimals = []
        zooKeeper = null

    def addZookeper(Zookeeper keeper):
        zooKeeper = keeper

    def addAnimal(Animal newAnimal):
        zooAnimals.add(newAnimal)

    #Get list of animals in zoo
    def getAnimals()
        return this.zooAnimals

    #Get zoo keeper
    def getZooKeeper()
        return this.zooKeeper

    #Number of animals in the zoo
    def getNumberOfAnimals():
        print(zooAnimals.size())

    #Wake up all of the animals in the zoo if they're not already awake
    def wakeUp():
        allNames= ""
        for ani in this.zooAnimals:
        if (ani.isAwake == false):
            ani.isAwake = true
            allNames+= ani.name + ", "
        else:
            print(ani.name + " already awake")
        print(zooKeeper.name + " woke up "+ allNames)

    #Roll call all of the animals: call out the animals' names
    def rollCall():
        print("Roll Call")
        allNames= ""
        for ani in this.zooAnimals:
            allNames+= ani.name + ", "
        print(allNames)

    #Feed all of the animals in the zoo if they haven't already been fed
    def feedAnimals():
        allNames= ""
        for ani in this.zooAnimals:
            if(ani.isFed == false):
                allNames+= ani.name + ", "
            else:
                print(ani.name + " already Fed.")
        print(zooKeeper.name + " fed "+ allNames)

    #Exercise all of the animals in the zoo
    def excersizeAnimals():
        allNames= ""
        for ani in this.zooAnimals:
            allNames += ani.name + ", "
        print(zooKeeper.name + " excersized "+ allNames)

    #Reset the zoo - all of the animals haven't been fed and are asleep after reset
    def shutDownZoo():
        allNames= ""
        print(zooKeeper.name +" shutting down zoo!")
        for ani in self.zooAnimals:
            allNames += ani.name + ", "
            ani.isAwake = false
            ani.isFed = false
        print(zooKeeper.name +" put " + allNames + "to sleep")