
#Implementing Strategy Patternself.
import abc
#making abstract class to define makeNoise
class makeNoiseStrategyAbstract(abc.ABC):
    __metaclass__ = abc.ABCMeta

    @abc.abstractmethod
    def makeNoise(self):
        return ""

#All these are instantiating makeNoise to make a noise for a certain animal typeself
    #like loud quack and quiet quack but its for us its different "quacks" or noises
    #
class catMakeNoise(makeNoiseStrategyAbstract):
    def makeNoise(self):
        return ("Meow")
class lionMakeNoise(makeNoiseStrategyAbstract):
    def makeNoise(self):
        return("Roar")
class tigerMakeNoise(makeNoiseStrategyAbstract):
    def makeNoise(self):
        return("Rawr")

class wolfMakeNoise(makeNoiseStrategyAbstract):
    def makeNoise(self):
        return("Grrr")
class dogMakeNoise(makeNoiseStrategyAbstract):
    def makeNoise(self):
        return("Bark Bark")

class hippoMakeNoise(makeNoiseStrategyAbstract):
    def makeNoise(self):
        return("Whaaaa")
class rhinoMakeNoise(makeNoiseStrategyAbstract):
    def makeNoise(self):
        return("Grumble Grumble")
class elephantMakeNoise(makeNoiseStrategyAbstract):
    def makeNoise(self):
        return("Raaaaa")
