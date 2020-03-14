package slidingWindow;

public class MinimumSwapstoGroupAllOnesTogether {

	public static void main(String[] args) {
		int[] nums = {1,0,1,0,1,0,0,1,1,0,1};
		MinimumSwapstoGroupAllOnesTogether test = new MinimumSwapstoGroupAllOnesTogether();
		System.out.println(test.minSwaps(nums));

	}
	public int minSwaps(int[] data) {
        int cntOnes=0;
        for(int i=0;i<data.length;i++){
            if(data[i]==1)
            	cntOnes++;
        }
        
        int minSwaps=data.length;
        int low=0,high=0;int cntTempOnes=0;
        while(high<data.length) {
        	if(high-low<cntOnes) {
        		cntTempOnes+=data[high++];
        	}else {
        		minSwaps=Math.min(minSwaps, cntTempOnes);
        		cntTempOnes-=data[low++];
        		cntTempOnes+=data[high++];
        	}
        }
        return minSwaps;
    }
}
