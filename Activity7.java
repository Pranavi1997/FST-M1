
interface BicycleParts {
       int tyres = 2; 
    int maxSpeed = 50;
}

interface BicycleOperations {
    void applyBrake(int decrement);
    void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations {
    protected int gears;
    protected int currentSpeed;

    public Bicycle(int gears, int currentSpeed) {
           this.gears = gears;
           this.currentSpeed = currentSpeed;
       }
public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        System.out.println("Current speed after brake: " + currentSpeed);
    }

public void speedUp(int increment) {
        currentSpeed += increment;
        System.out.println("Current speed after speeding up: " + currentSpeed);
    }

public String bicycleDesc() {
        return "Number of gears: " + gears + "\nMax speed: " + maxSpeed;
    }
}
class MountainBike extends Bicycle {
    public int seatHeight;
    public MountainBike(int gears, int currentSpeed, int startHeight) {
        super(gears, currentSpeed); 
        seatHeight = startHeight;
    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public String bicycleDesc() {
        return super.bicycleDesc() + "\nSeat height is " + seatHeight;
    }
}

public class Activity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 MountainBike mb = new MountainBike(3, 0, 25);
		        System.out.println(mb.bicycleDesc());
		        mb.speedUp(20);
		        mb.applyBrake(5);
		       }

	}