/*
 * Reverse a linked list from position m to n. Do it in one-pass.
 */
class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int val) {
		this.val=val;
	}
}
public class ReverseLinkedListFrom_mton {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		int m=2,n=4;
		if(head == null) {
			System.out.println("null");
			return;
		}

	    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
	    dummy.next = head;
	    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
	    for(int i = 0; i<m-1; i++) 
	    	pre = pre.next;
	    
	    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
	    ListNode then = start.next; // a pointer to a node that will be reversed
	    
	    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
	    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
	    
	    //start node remains with same Node till reversal is done
	    //then node is always pointing next to start node
	    for(int i=0; i<n-m; i++)
	    {
	        start.next = then.next;
	        then.next = pre.next;
	        pre.next = then;
	        then = start.next;
	    }
	    
	    System.out.println(dummy.next);

	}

}
