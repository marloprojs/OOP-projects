
class Zookeeper:
    # Constructor
	def __init__(self, name, age, salary):
		self.name = name
		self.age = age
		self.salary = salary
	"""def register_observer(self, observer):
		self.observers.append(observer)

	def notify_observers(self):
		for observers in self.observers:
			observer.update(self.action)

	def action_occured(self):
		self.notify_observers()

	def action_changed(self, action):
		self.action = action
		self.action_occured()
	"""