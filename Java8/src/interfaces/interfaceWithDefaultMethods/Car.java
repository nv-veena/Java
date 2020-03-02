package interfaces.interfaceWithDefaultMethods;

public class Car implements Vehicle {
	private String brandName;
	
	public static void maim(String[] args) {
		Car test = new Car();
		test.brandName="Tesla";
		test.getBrandName();
		test.speedUp();
		test.slowDown();
		test.turnLightsOn();
		test.turnLightsOff();
	}
	
	@Override
	public void speedUp() {
		System.out.println("The car is speeding up");
	}

	@Override
	public void slowDown() {
		System.out.println("The car is slowing up");
	}

	@Override
	public String getBrandName() {
		return this.brandName;
	}

}
