/*
 * Perform Division of two integers without using multiplication, division and mod operator
 * Basic Division formula Dividend = quotient * divisor + remainder
 * One approach is to use repeated subtraction. Find Quotient and Remainder
 * Another approach is to use Bit Manipulation
 */



public class PerformDivision {

	public static void main(String[] args) {
		//n1 is dividend, n2 is divisor
		int n1 = 84,n2 = 3;
		System.out.println(Integer.toBinaryString(n1));
		PerformDivision tst = new PerformDivision();
		tst.test(n1, n2);

	}
	
	//Time Complexity is O(n1) where n1 is dividend,space complexity is 1
	public void test(int dividend,int divisor) {
		int res = 0;
    	int currentDivisor = divisor;
    	while(dividend>=divisor){
    		int temp = 1;            
    		while( (currentDivisor << 1) <=dividend && //Checking for greater than dividend because both divisor and dividend are negative
    													//and in negative integers the divisor value has to be greater 
    				(currentDivisor << 1) >0 ){		//Keep shifting Divisor Left and make sure its less than Dividend
    			temp <<=1;				//Leftshift of divisor causes Quotient to double
    			currentDivisor <<=1;	//leftshift divisor
    		}
    		dividend -= currentDivisor;
    		res += temp;		//res is the Quotient
    		currentDivisor = divisor;
    	} 
    	
    	System.out.println("Remainder is :" + dividend);
    	System.out.println("Quotient is :" + res);
	}
	public void divideUsingBitManipulation(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) 
        	System.out.println(Integer.MAX_VALUE);
        boolean isSameSign = (dividend <0) == (divisor<0);             
        int res = divideHelper(-Math.abs(dividend),-Math.abs(divisor),isSameSign);    //we use negative dividend and divisor to avoid problem for MIN_VALUE     
        int q = isSameSign ? res : -res;
        System.out.println("Quotient is :" + q); 
    }
    
    private int divideHelper(int dividend, int divisor,boolean isSameSign){
    	int res = 0;
    	int currentDivisor = divisor;
    	while(dividend<=divisor){
    		int temp = 1;            
    		while( (currentDivisor << 1) >=dividend && //Checking for greater than dividend because both divisor and dividend are negative
    													//and in negative integers the divisor value has to be greater 
    				(currentDivisor << 1) <0 ){		//Keep shifting Divisor Left and make sure its less than Dividend
    			temp <<=1;				//Leftshift of divisor causes Quotient to double
    			currentDivisor <<=1;	//leftshift divisor
    		}
    		dividend -= currentDivisor;
    		res += temp;		//res is the Quotient
    		currentDivisor = divisor;
    	} 
    	int remainder = isSameSign ? dividend : -dividend;
    	System.out.println("Remainder is :" + remainder);
    	return res;
    }
}
