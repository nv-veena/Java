import java.util.Arrays;

/*
 * Bubble Sort has Average case Time complexity O(n^2) and worst case time complexity O(n^2)
 * Example Sort [5,4,3,2,1]
 * End of First pass [4,3,2,1,5]
 * End of Second pass [3,2,1,4,5]
 * End of Third pass [2,1,3,4,5]
 * End of 4th pass [1,2,3,4,5]
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = {5,4,3,2,1};
		int n=nums.length-1;
		for(int i=0;i<=n;i++) {
			for(int j=1;j<=n-i;j++) {
				if(nums[j-1] > nums[j]) {
					int temp = nums[j-1];
					nums[j-1]=nums[j];
					nums[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}

}
