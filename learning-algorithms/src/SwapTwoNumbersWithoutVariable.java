/*
 * Swap two numbers without using a temp variable
 * https://www.geeksforgeeks.org/swap-two-numbers-without-using-temporary-variable/
 */
public class SwapTwoNumbersWithoutVariable {

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 50;
		n1 = n1 * n2;  
		n2 = n1/n2;    
		n1 = n1 /n2;
		System.out.println("n1 : " + n1 + " : " + "n2 : " + n2);

	}

}
