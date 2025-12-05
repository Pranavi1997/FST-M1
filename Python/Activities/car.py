
class car:
    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make            
        self.transmission = transmission  
        self.color = color

    def accelerate(self):
        print(f"{self.manufacturer} {self.model} is moving")

    def stop(self):
        print(f"{self.manufacturer} {self.model} has stopped")

car1 = car(manufacturer="Toyota", model="Corolla", make=2022, transmission="Automatic", color="Blue")
car2 = car(manufacturer="Honda", model="Civic", make=2021, transmission="Manual", color="white")
car3 = car(manufacturer="Honda", model="Civic", make=2021, transmission="Manual", color="Red")

# Demo: use the methods
car1.accelerate()
car1.stop()
car2.accelerate()
car2.stop()
car3.accelerate()
car3.stop()