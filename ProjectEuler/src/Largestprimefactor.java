/* https://projecteuler.net/problem=3
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime factor of the number 600851475143 ?
 */
public class Largestprimefactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Largestprimefactor test = new Largestprimefactor();
		System.out.println(test.largestPrimeFactor());
	}
	public long largestPrimeFactor() {
		long LIMIT = 600851475143L;
		// First, start from the maximum number and divide by 2
        // until you can no longer divide evenly by 2, i.e., the number is odd
		while(LIMIT % 2 == 0) {
			// in the case of 600851475143 this will be skipped entirely since it is an odd number, 
            // but for the sake of generality we will keep it so it can be used on any number
			LIMIT/=2;			
		}
		// the next prime number is 3, and all prime numbers from there are odd numbers,
        // so we can safely just add 2 to the factor each time and only test for odd numbers
        // note that this has a small inefficiency in that it will also test for a few non-prime odd numbers
        // like 9, 15, 21, etc. but it's much less computational work to try dividing by a candidate factor than to test for primality.
		for(long factor = 3;factor<LIMIT;factor+=2) {
			while(LIMIT%factor == 0 && factor <LIMIT) {
				LIMIT /=factor;
			}
		}
		return LIMIT;
	}
	
}
