package algo.recursion;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	reduceByOne(10);
	//	System.out.println(recursiveLinearSearch(new int[] {4,48,4,28,34,76,9,3}, 0, 28));
		
		System.out.println("Found index in :" + resursiveBinarySearch(new int[] {11,22,33,44,55,66,77,88,98,99}, 23, 0,18));
	}

	public static void reduceByOne( int n) {
		if(n >= 0) {
			reduceByOne(n - 1);
		}
		System.out.println("Completed  call: " + n);
		
	}
	
	public static int recursiveLinearSearch(int[] arr,int idx, int x) {
		if(idx > arr.length) {
			return -1;
		}
		else if(arr[idx] == x) {
			return idx;
		}
		else {
			System.out.println("index at : " + idx);
			return recursiveLinearSearch(arr, idx+1, x);
		}
		//return -1;
	}
	public static int resursiveBinarySearch(int[] arr,int x,int p,int r) {
		System.out.println("[... " + p + "..." + r + "..]");
		
		if(p>r) {
			return -1;
		}else {
			int q = (p+r)/2;
			if(arr[q] == x) {
				return q;
			}else if(arr[q] < x) {
					return resursiveBinarySearch(arr,x,q + 1,r);
			}else{
					return resursiveBinarySearch(arr,x,p,q - 1);
			}
		}
	}
}
