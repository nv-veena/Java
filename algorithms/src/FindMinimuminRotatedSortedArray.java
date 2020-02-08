
public class FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		int[] a= {5,1,2,3,4};
		 int s=0,e=a.length-1;
	        while(s<e){
	            int m=s + (e-s)/2;
	           if(a[m] > a[e]){     //Right side is sorted
	               s=m+1;
	           }else{           //Left side is sorted
	               e=m;         //Set High to Mid as 
	           }
	        }
	       System.out.println(a[s]);
	}

}
