/*
 * Perform Division of two integers without using multiplication, division and mod operator
 * Basic Division formula Dividend = quotient * divisor + remainder
 * One approach is to use repeated subtraction. Find Quotient and Remainder
 * Another approach is to use Bit Manipulation
 */



public class PerformDivision {

	public static void main(String[] args) {
		//n1 is dividend, n2 is divisor
		int n1 = -256,n2 = -3;
		System.out.println(Integer.toBinaryString(n1));
		PerformDivision tst = new PerformDivision();
		tst.divideUsingBitManipulation(n1, n2);

	}
	
	//Time Complexity is O(n1) where n1 is dividend,space complexity is 1
	public void useRepeatedSubtraction(int n1,int n2) {
		int sign = 1;
		int q = 0;int r =0;
		sign = ((n1<0 ) ^ (n2 < 0)) ? -1:1 ;
		int divd = Math.abs(n1);
		int divis = Math.abs(n2);
		while(divd>=divis) {
			q++;
			divd = divd - divis;
		}
		r = divd;
		q = sign * q;
		System.out.println("Quotient is :" + q + " and the remainder is :" + r);
	}
	public void divideUsingBitManipulation(int dividend, int divisor) {
       // if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
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
            while( (currentDivisor << 1) >=dividend && 
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
