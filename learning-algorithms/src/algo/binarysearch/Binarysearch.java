package algo.binarysearch;

public class Binarysearch {
	
	public static void main(String[] args) {
		int[] arr = {11,22,33,44,55,66,77,88,99,100};
		int searchElementIndex = doBinarysearch(100,arr);
		System.out.println(" The index position of the element is : " + searchElementIndex);
	}
	
	public static int doBinarysearch(int data,int[] arr1) {
		int p = 0;
		int r = arr1.length - 1;
		int q = 0;
		
		while( p <= r) {
			q = (p + r ) / 2 ;
			
			if(arr1[q] == data) {
				return q;
			}else if( data > arr1[q] ) {
				p = q + 1;
			}else if(data < arr1[q]) {
				r = q - 1;
			}

		}
		System.out.println( "p: " + p + " , " + "q: " + q + "r :" + r);
		return - 1;
		
	}
}
