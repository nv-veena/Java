/*  https://projecteuler.net/problem=1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
	Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class MultiplesOfThreeAndFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplesOfThreeAndFive test= new MultiplesOfThreeAndFive();
		System.out.println(test.multiplesOfThreeAndFive());
	}
	public int multiplesOfThreeAndFive() {
		final int LIMIT = 1_000;
		int totalSum=0;
		for(int i=1;i<1000;i++) {
			if(i%3==0 || i%5==0) {
				totalSum+=i;
			}
		}
		return totalSum;
	}
}
