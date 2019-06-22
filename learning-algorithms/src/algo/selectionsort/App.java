package algo.selectionsort;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Slection Sort Array :" + Arrays.toString(selectionSort1(new int[] {56,78,10,5,4,8,33,55,88,90})));
	}

	public static int[] selectionSort1(int[] arr) {
		int lowestNumberIndex;
		
		for(int i=0;i<arr.length;i++) {
			lowestNumberIndex = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[lowestNumberIndex]) {
					lowestNumberIndex = j;
				}
			}
			System.out.println("Lowest Number and lowest index :" + arr[lowestNumberIndex] + ", " + lowestNumberIndex);
			if(arr[lowestNumberIndex] != arr[i]) {
				int mini = arr[lowestNumberIndex];
				arr[lowestNumberIndex] = arr[i];
				arr[i] = mini;
			}
			System.out.println("Partial Sorted array :" + Arrays.toString(arr));
		}
		return arr;
	}
}
