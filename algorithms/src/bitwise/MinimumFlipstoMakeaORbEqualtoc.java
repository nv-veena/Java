package bitwise;
/* https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

Example 1:
Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
 */
public class MinimumFlipstoMakeaORbEqualtoc {

	public static void main(String[] args) {
		MinimumFlipstoMakeaORbEqualtoc test = new MinimumFlipstoMakeaORbEqualtoc();
		System.out.println(test.minFlips(2, 6, 5));

	}
	
	public int minFlips(int a, int b, int c) {
		//If a | b ==c then number of flips needed is zero
        if((a | b) == c) return 0;
       int res=0;
       
       //while all integers are non-zero, check for each bit 
       //how many flips are needed for a,b to make it a | b == c
       //add the count and return. Do right shift for each integer 
       //for each iteration
	     while(a!=0 | b!=0 | c!=0) {
            int A=a & 1;
            int B=b & 1;
            int C = c & 1;
	        if(C==1){
               if(A==0 & B==0){
                   res++;
               }
               
           }else {
              if(A==1 & B==1){
                   res+=2;
               }else if(A==1 | B==1){
                   res++;
               } 
           }
            a=a>>1;b=b>>1;c=c>>1;
        }
       return res;
   }
}
