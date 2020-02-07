

#Zoo class with methods to get details on the zoo and actions that can occur at the zoo
class Zoo:
    #Construct a zoo with animals and zoo keeper
    def __init__(self):
        self.zooAnimals = []
        self.zooKeeper = None
        self.zooAnnouncer = None

    def addZookeper(self, keeper):
        self.zooKeeper = keeper

    def addAnnouncer(self, announcer):
        self.zooAnnouncer = announcer

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
    #Notify observer that an action has occured
    def wakeUp(self):
        self.zooKeeper.action = " wake up the animals"
        self.zooKeeper.action_occured()
        allNames= ""
        for ani in self.zooAnimals:
            if (ani.isAwake == False):
                ani.isAwake = True
                allNames+= ani.name + ", "
            else:
                print(ani.name + " already awake")

        print(self.zooKeeper.name + " woke up "+ allNames)
    #Notify observer that an action has occured
    def animalMakeNoise(self):
        for ani in self.zooAnimals:
            print(ani.name ,end = " went ")
            ani.makeNoise()


    #Roll call all of the animals: call out the animals' names
    #Notify observer that an action has occured
    def rollCall(self):
        self.zooKeeper.action = " take roll call"
        self.zooKeeper.action_occured()
        #print("Roll Call")
        allNames= ""
        for ani in self.zooAnimals:
            allNames+= ani.name + ", "
        #print(allNames)

    #Feed all of the animals in the zoo if they haven't already been fed
    #Notify observer that an action has occured
    def feedAnimals(self):
        self.zooKeeper.action = " feed the animals"
        self.zooKeeper.action_occured()
        allNames= ""
        for ani in self.zooAnimals:
            if(ani.isFed == False):
                allNames+= ani.name + ", "
            else:
                print(ani.name + " already Fed.")
        #print(self.zooKeeper.name + " fed "+ allNames)

    #Exercise all of the animals in the zoo
    #Notify observer that an action has occured
    def excersizeAnimals(self):
        self.zooKeeper.action = " exercise the animals"
        self.zooKeeper.action_occured()
        allNames= ""
        for ani in self.zooAnimals:
            allNames += ani.name + ", "
        #print(self.zooKeeper.name + " exercised "+ allNames)

    #Reset the zoo - all of the animals haven't been fed and are asleep after reset
    #Notify observer that an action has occured
    def shutDownZoo(self):
        self.zooKeeper.action = " shut down the zoo"
        self.zooKeeper.action_occured()
        allNames= ""
        #print(self.zooKeeper.name +" shutting down zoo!")
        for ani in self.zooAnimals:
            allNames += ani.name + ", "
            ani.isAwake = False
            ani.isFed = False
        #print(self.zooKeeper.name +" put " + allNames + "to sleep")
