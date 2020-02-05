class ZooAnnouncer(observer):
	def __init__(self, Zookeeper):
		self.action = ""
		self.Zookeeper.register_observer(observer)
	
	def update(self, action):
		self.action = action
		self.display()

	def display(self):
		print("Hi, this is the Zoo Announcer. The Zookeeper is about to "+self.action)

