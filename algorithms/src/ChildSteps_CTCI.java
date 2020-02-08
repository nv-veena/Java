import java.util.Arrays;
import java.util.Calendar;

/**
 * A child is running up a staircase with n steps, and can
 * hop either 1 step, 2 steps, or 3 steps at a time. Implement
 * a method to count how many possible ways the child can run
 * up the stairs.
 */
public class ChildSteps_CTCI {

	public static void main(String[] args) {
		ChildSteps_CTCI test=new ChildSteps_CTCI();
		int n=10;
		long time1=Calendar.getInstance().getTimeInMillis();
		System.out.println(test.childRunMemo(n));
		long time2=Calendar.getInstance().getTimeInMillis();
		System.out.println(time2-time1);

	}
	public int childRun(int n) {
		if(n<0)return 0;
		if(n==0)return 1;
		return childRun(n-1)+childRun(n-2)+childRun(n-3);
	}
	public int childRunMemo(int n) {
		int[] ans=new int[n+1];
		Arrays.fill(ans, -1);
		return helper(n,ans);
	}
	public int helper(int n,int[] memo) {
		if(n<0) {
			return 0;
		}
		else if(n==0) {
			memo[n]=1;
			return memo[n];
		}
		else if(memo[n]>-1) {
			return memo[n];
		}
		else{
			memo[n]=helper(n-1,memo)+helper(n-2,memo)+helper(n-3,memo);
			return memo[n];
		}
		
	}
}
