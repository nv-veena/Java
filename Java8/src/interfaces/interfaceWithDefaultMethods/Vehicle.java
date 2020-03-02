package interfaces.interfaceWithDefaultMethods;
/* default methods are implicitly public in interfaces - there's no need to specify the public modifier.
Purpose of default methods in interfaces is to incrementally provide additional 
functionality to a given type without breaking down the implementing classes.
In a typical design based on abstractions, where an interface has one or multiple 
implementations, if one or more methods are added to the interface, all the 
implementations will be forced to implement them too. Otherwise, the design will just break down.
Default interface methods are an efficient way to deal with this issue. They allow 
us to add new methods to an interface that are automatically available in the 
implementations. Thus, there's no need to modify the implementing classes.
In this way, backward compatibility is neatly preserved without having to refactor the implementers.
 * 
 */
public interface Vehicle {
	default String turnLightsOn() {
		return "Turned the Vehicle Lights On";
	}
	default String turnLightsOff() {
		return "Turned the Vehicle Lights Off";
	}
	public void speedUp();
	
	public void slowDown();
	
	public String getBrandName();
}
