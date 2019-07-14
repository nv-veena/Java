import java.util.Arrays;

/*
 * Divide and Conquer Algorithm where all elements left of Pivot are guaranteed to be smaller than element at Pivot
 * All elements greater than pivot are placed to the right of the pivot element.
 * Pivot element is guaranteed to be placed at the correct index
 * Left side elements again Quicksorted, Right side elements are again Quick sorted
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] nums = {5,8,9,4,1,2,7,6,3};
		QuickSort tst = new QuickSort();
		tst.quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	public void quickSort(int[] nums,int p,int q) {
		if(p<q) {
			int idx = partition(nums,p,q);
			
			quickSort(nums,p,idx-1);
			quickSort(nums,idx+1,q);
		}
	}
	public int partition(int[] nums,int start,int end) {
		int i=start-1;
		int pivot = nums[end];
		for(int j=start;j<end;j++) {
			if(nums[j]<=pivot) {
				i++;
				int temp = nums[j];
				nums[j]=nums[i];
				nums[i]=temp;
			}
		}
		int temp = nums[i+1];
		nums[i+1]=pivot;
		nums[end]=temp;
		
		return i+1;
	}
}
