package slidingWindow;

public class GetEqualSubstringsWithinBudget {

	public static void main(String[] args) {
		 String s = "abcd",t = "cdef"; int maxCost = 1;
		 GetEqualSubstringsWithinBudget test = new GetEqualSubstringsWithinBudget();
		 System.out.println(test.equalSubstring(s, t, maxCost));

	}
	public int equalSubstring(String s, String t, int maxCost) {
		int ans=0;
		for(int low=0,high=0,tempCost=0;high<s.length();){
            while(high<s.length() && s.charAt(high)==t.charAt(high)){
                high++;
            }
            ans=Math.max(ans,high-low);
            if(maxCost==0)
                return ans;
            while(high<s.length() && s.charAt(high)!=t.charAt(high) &&
                  Math.abs(s.charAt(high) - t.charAt(high)) + tempCost<=maxCost){
                    tempCost += Math.abs(s.charAt(high) - t.charAt(high));
                    ans=Math.max(ans,high-low+1);                              
                    high++;
                
            }
                        
                tempCost-=Math.abs(s.charAt(low) - t.charAt(low));
                low++;
            
        }
        return ans;
    }
}
