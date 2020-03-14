package interfaces.functionalinterface;

public class TestClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionalInterfaceSample sum = (a,b) -> a+b;
		FunctionalInterfaceSample multip = (a,b) -> a * b;
		System.out.println("Result :" + sum.addMethod(12, 100));
		System.out.println("Result of multiplication :" + multip.addMethod(3, 5));
	}

}
