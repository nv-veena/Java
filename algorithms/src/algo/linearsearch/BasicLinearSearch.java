package algo.linearsearch;

public class BasicLinearSearch {
		public static void main(String[] args) {
			char[] arr = {'a','c','d','r','e'};
			int indexPos = linearsearch(arr, 'r');
			System.out.println("Printing the position of the character :" + indexPos);
		}
		
		public static int linearsearch(char[] ar, char x) {
			for(int i=0;i<ar.length;i++) {
				if(x== ar[i]) {
					return i;
				}
			}
			return -1;
		}
}
