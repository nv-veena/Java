import java.util.Calendar;

public class FibonacciSeries {

	public static void main(String[] args) {
		FibonacciSeries test=new FibonacciSeries();
		int n=10000;
		long time1=Calendar.getInstance().getTimeInMillis();
		System.out.println(test.findFib(n));
		long time2=Calendar.getInstance().getTimeInMillis();
		System.out.println(time2-time1);
	}
	public int fibRecursive(int n) {
		if(n==0 ||n==1)return n;
		return fibRecursive(n-1)+fibRecursive(n-2);
	}
	public int fibMemoization(int n) {
		return helper(n,new int[n+1]);
	}
	public int helper(int n,int[] memo) {
		if(n==0 || n==1)return n;
		if(memo[n]==0) {
			memo[n]=helper(n-1,memo)+helper(n-2,memo);
		}
		return memo[n];
	}
	public int dp(int n) {
		if(n<=1)return n;
		int[] ans=new int[n+1];
		ans[0]=0;ans[1]=1;
		for(int i=2;i<=n;i++) {
			ans[i]=ans[i-1]+ans[i-2];
		}
		return ans[n];
	}
	public int findFib(int n) {
		if(n<=1)return n;
		int a=0;int b=1;
		int c=0;
		for(int i=2;i<=n;i++) {
			c=a+b;
			a=b;
			b=c;
		}
		return c;
	}
}
