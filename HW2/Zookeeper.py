class Subject:
	def register_observer(self, observer):
		raise NotImplementedError

	def remove_observer(self, observer):
		raise NotImplementedError

	def notify_observers(self):
		raise NotImplementedError


class Zookeeper(Subject):
    # Constructor
	def __init__(self, name, age, salary):
		self.name = name
		self.age = age
		self.salary = salary
		self.action = ""
		self.observers = []

	#Make a list of the observers
	def register_observer(self, Observer):
		self.observers.append(Observer)

	def remove_observer(self, Observer):
		self.observers.remove(Observer)

	#Update the observers that an action has occured
	def notify_observers(self,fileOpen):
		for observer in self.observers:
			observer.update(self.action,fileOpen)

	def action_occured(self,fileOpen):
		self.notify_observers(fileOpen)

	def action_changed(self, action):
		self.action = action
		self.action_occured()
