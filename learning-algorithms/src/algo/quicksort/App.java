package algo.quicksort;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayToMerge = {6,4,5,3,0,1,5,8,55,1,38,5,99};
		
		QuickSort sorter = new QuickSort();
		sorter.quickSort(arrayToMerge,0,arrayToMerge.length - 1);
		
		System.out.println("Merged Array :" + Arrays.toString(arrayToMerge));

	}

}
