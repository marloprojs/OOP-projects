class Observer:
	def update(self, action):
		raise NotImplementedError

class DisplayElement:
	def display(self):
		raise NotImplementedError

class ZooAnnouncer(Observer, DisplayElement):
	def __init__(self):
		self.action = ""
		#self.Zookeeper.register_observer(self)

	def update(self, action,fileOpen):
		self.action = action
		self.display(fileOpen)

	#Announce the action that the zoo keeper has taken
	def display(self,fileOpen):
		print("Hi, this is the Zoo Announcer. The Zookeeper is about to "+self.action + "\n", file=fileOpen)
		print("Hi, this is the Zoo Announcer. The Zookeeper is about to "+self.action + "\n")
