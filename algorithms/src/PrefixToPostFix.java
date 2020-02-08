/* https://www.geeksforgeeks.org/prefix-postfix-conversion/
 * Given a Prefix expression, convert it into a Postfix expression.
 * Input :  Prefix :  *+AB-CD
 * Output : Postfix : AB+CD-*
 */
import java.util.*;
public class PrefixToPostFix {

	public static void main(String[] args) {
		PrefixToPostFix test=new PrefixToPostFix();
		String s="*-A/BC-/AKL";
		System.out.println(test.prefixToPostfix(s));
	}
	public String prefixToPostfix(String s) {
		StringBuilder sb=new StringBuilder();
		Stack<String> stk = new Stack<>();
		for(int i=s.length()-1;i>=0;i--) {
			if(Character.isLetter(s.charAt(i))) {
				stk.push(Character.toString(s.charAt(i)));
			}else {
				StringBuilder sb1= new StringBuilder();
				sb1.append(!stk.isEmpty()?stk.pop():"");
				sb1.append(!stk.isEmpty()?stk.pop():"");
				sb1.append(s.charAt(i));
				stk.push(sb1.toString());
			}
		}
		while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
		return sb.toString();
	}
}
