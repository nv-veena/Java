package interfaces.functionalinterface;
/* Functional Interface contains only 1 abstract function
 * All functional interfaces are recommended to have an informative @FunctionalInterface annotation. 
 * Since default methods have an implementation, they are not abstract. To use lambda expression in Java, 
 * you need to either create your own functional interface or use the predefined functional interface provided by Java. 
 * A functional interface can contain default and static methods which do have an implementation, 
 * in addition to the single unimplemented method.
 */

@FunctionalInterface
public interface FunctionalInterfaceSample {
	public int addMethod(int a,int b);
	public default void print(String text) {
		System.out.println("Test");
	}
}
