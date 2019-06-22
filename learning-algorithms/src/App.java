import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayToMerge = {6,4,3,0,1,5,8,55,38,99};
		
		MergeSort sorter = new MergeSort();
		sorter.sort(arrayToMerge);
		
		System.out.println("Merged Array :" + Arrays.toString(arrayToMerge));
		
	}

}
