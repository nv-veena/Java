package sorting;
import java.util.Arrays;
/*Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, c
 * alls itself for the two halves and then merges the two sorted halves. The merge() function is used 
 * for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m] and 
 * arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. 
 * See following C implementation for details.

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)

Time Complexities
Time complexity of Merge Sort is \Theta(nLogn) in all 3 cases (worst, average and best) as merge sort 
always divides the array into two halves and take linear time to merge two halves.

Auxiliary Space: O(n)

Algorithmic Paradigm: Divide and Conquer

Sorting In Place: No in a typical implementation

*/
public class MergeSort {

	public static void main(String[] args) {
		MergeSort test = new MergeSort();
		int[] nums= {8,9,1,6,5,4,0,7};
		test.mergeSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	public void mergeSort(int[] nums,int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			mergeSort(nums,low,mid);
			mergeSort(nums,mid+1,high);
			merge(nums,low,mid,high);
		}
	}
	public void merge(int[] nums,int low,int mid,int high) {
		int n1=mid-low+1;int n2=high-mid;
		int[] left=new int[n1];
		int[] right=new int[n2];
		for(int i=0;i<n1;i++) {
			left[i]=nums[i+low];
		}
		for(int j=0;j<n2;j++) {
			right[j]=nums[j+mid+1];
		}
		int i=0,j=0,k=low;
		//int[] temp=new int[nums.length];
		while(i<n1 && j<n2) {
			if(left[i]<right[j]) {
				nums[k++]=left[i++];
			}else {
				nums[k++]=right[j++];
			}
		}
		while(i<n1) {
			nums[k++]=left[i++];
		}
		while(j<n2) {
			nums[k++]=right[j++];
		}
	}
}
