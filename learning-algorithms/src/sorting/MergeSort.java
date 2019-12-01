package sorting;
import java.util.Arrays;

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
