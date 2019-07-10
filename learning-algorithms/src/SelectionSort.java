import java.util.Arrays;

/*
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64

Time Complexities
Best Case -- (n^2)	
Average Case -- (n^2)	
Worst Case -- O(n^2)
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] nums = {5,4,3,2,1};
		int n=nums.length-1;
		for(int i=0;i<=n;i++) {
			int minIdx = i;
			for(int j=i+1;j<=n;j++) {
				if(nums[j] <nums[minIdx])
					minIdx=j;
			}
			int temp = nums[minIdx];
			nums[minIdx]=nums[i];
			nums[i]=temp;
		}
		System.out.println(Arrays.toString(nums));
	}

}
