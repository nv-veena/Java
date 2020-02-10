package slidingWindow;
/* https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 * Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 
Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.

 */
public class NumberOfSubStringsContainingAllThreeCharacters {

	public static void main(String[] args) {
		String s= "abcabc";
		NumberOfSubStringsContainingAllThreeCharacters test = new NumberOfSubStringsContainingAllThreeCharacters();
		System.out.println(test.numberOfSubstrings(s));

	}
	public int numberOfSubstrings(String s) {
		int[] arr=new int[3];
		int ans=0;
		for(int low=0,hi=0;hi<s.length();hi++) {
			++arr[s.charAt(hi)-'a'];
			while(arr[0]>0 && arr[1]>0 && arr[2]>0) {
				ans+=s.length()-hi;
				--arr[s.charAt(low)-'a'];
				low++;
			}
		}
		return ans;
	}
}
