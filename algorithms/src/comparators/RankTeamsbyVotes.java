package comparators;
/* https://leetcode.com/problems/rank-teams-by-votes/
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.

The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, 
we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. 
If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking 
system described above.

Return a string of all teams sorted by the ranking system.
Example 1:

Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
Team B was ranked second by 2 voters and was ranked third by 3 voters.
Team C was ranked second by 3 voters and was ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team and team B is the third.
 */
import java.util.*;
public class RankTeamsbyVotes {

	public static void main(String[] args) {
		String[] votes = {"ABC","ACB","ABC","ACB","ACB"};

	}
	public String rankTeams(String[] votes) {
        if(votes.length==1 || votes[0].length()==1)return votes[0];
        Map<Character,int[]> map = new HashMap<>();
        int n=votes[0].length();
        
        //For each character, prepare an array of length of the string
        //Since all strings in the array are of same length, the count
        //in each array for each character will give its number of occurence
        //in that specific position
        for(int i=0;i<votes.length;i++){
            for(int j=0;j<votes[i].length();j++){
                char c= votes[i].charAt(j);
                map.putIfAbsent( c,new int[n]);
                map.get(c)[j]++;
            }
        }
        List<Character> lst = new ArrayList<Character>(map.keySet());
        
        //Create a custom comparator where count of each characters position
        //is compared and the list is sorted based on this compare
        Collections.sort(lst,new Comparator<Character>(){
          public int compare(Character a,Character b){
              int[] votes1=map.get(a);
              int[] votes2=map.get(b);
              for(int i=0;i<votes1.length;i++){
                  if(votes1[i]!=votes2[i]){
                      return votes2[i]-votes1[i];
                  }
              }
              return a - b;
          }  
        });
        StringBuilder sb = new StringBuilder();
        for(char c:lst){
            sb.append(c);
        }
        return sb.toString();
    }
}
