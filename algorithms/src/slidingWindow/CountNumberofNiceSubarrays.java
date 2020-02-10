package slidingWindow;

public class CountNumberofNiceSubarrays {

	public static void main(String[] args) {
		CountNumberofNiceSubarrays test = new CountNumberofNiceSubarrays();
		int[] nums = new int[] {2,2,2,1,2,2,1,2,2,2};int k=2;
		System.out.println(test.numberOfSubarrays(nums, k));

	}
	public int numberOfSubarrays(int[] nums, int k) {
		int ans=0;int temp=0;
		for(int low=0,hi=0;hi<nums.length;hi++) {
			if(nums[hi]%2!=0)temp++;
			while(temp==k) {
				ans++;
				if(nums[low]%2!=0) {
					--temp;
				}
				low++;
			}
		}
		return ans;
	}
}
