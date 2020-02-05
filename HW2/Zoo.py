

#Zoo class with methods to get details on the zoo and actions that can occur at the zoo
class Zoo:
    #Construct a zoo with animals and zoo keeper
    def __init__(self):
        self.zooAnimals = []
        self.zooKeeper = None

    def addZookeper(self, keeper):
        self.zooKeeper = keeper

    def addAnimal(self, newAnimal):
        self.zooAnimals.append(newAnimal)

    #Get list of animals in zoo
    def getAnimals():
        return self.zooAnimals

    #Get zoo keeper
    
    def getZooKeeper():
        return self.zooKeeper

    #Number of animals in the zoo
    def getNumberOfAnimals(self):
        print(len(self.zooAnimals))

    #Wake up all of the animals in the zoo if they're not already awake
    def wakeUp(self):
        allNames= ""
        for ani in self.zooAnimals:
            if (ani.isAwake == False):
                ani.isAwake = True
                allNames+= ani.name + ", "
            else:
                print(ani.name + " already awake")
        print(self.zooKeeper.name + " woke up "+ allNames)

    
    #Roll call all of the animals: call out the animals' names
    def rollCall(self):
        print("Roll Call")
        allNames= ""
        for ani in self.zooAnimals:
            allNames+= ani.name + ", "
        print(allNames)

    #Feed all of the animals in the zoo if they haven't already been fed
    def feedAnimals(self):
        allNames= ""
        for ani in self.zooAnimals:
            if(ani.isFed == False):
                allNames+= ani.name + ", "
            else:
                print(ani.name + " already Fed.")
        print(self.zooKeeper.name + " fed "+ allNames)

    #Exercise all of the animals in the zoo
    def excersizeAnimals(self):
        allNames= ""
        for ani in self.zooAnimals:
            allNames += ani.name + ", "
        print(self.zooKeeper.name + " exercised "+ allNames)

    #Reset the zoo - all of the animals haven't been fed and are asleep after reset
    def shutDownZoo(self):
        allNames= ""
        print(self.zooKeeper.name +" shutting down zoo!")
        for ani in self.zooAnimals:
            allNames += ani.name + ", "
            ani.isAwake = False
            ani.isFed = False
        print(self.zooKeeper.name +" put " + allNames + "to sleep")