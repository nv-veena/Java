/*
 * Perform x mod of power 2 without actual division example 77 modulos 64 should give 13
 * https://www.geeksforgeeks.org/compute-modulus-division-by-a-power-of-2-number/
 * Elements of Programming Interview Question - section 4.1
 */
public class PerformModuleDivisionOfPower2 {

	public static void main(String[] args) {
		int n = 77,d=64;
		System.out.println(n & (d - 1));

	}

}
