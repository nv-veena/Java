package binaryTree;
/* https://leetcode.com/problems/linked-list-in-binary-tree/
 * Given a binary tree root and a linked list with head as the first node. 

Return True if all the elements in the linked list starting from the head correspond to some downward 
path connected in the binary tree otherwise return False.

In this context downward path means a path that starts at some node and goes downwards.
 */
//  Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
 
 
public class LinkedListinBinaryTree {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);head.next=new ListNode(4);head.next.next=new ListNode(2);
		head.next.next.next=new ListNode(6);head.next.next.next.next=new ListNode(8);
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(4);root.right=new TreeNode(4);
		root.left.right=new TreeNode(2);root.left.right.left=new TreeNode(1);
		
		root.right.left=new TreeNode(2);root.right.left.left=new TreeNode(6);
		root.right.left.right=new TreeNode(8);
		
		 LinkedListinBinaryTree test= new LinkedListinBinaryTree();
		System.out.println(test.isSubPath(head, root));
	}
	public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) 
        	return false;
       return check(head,root) || 		//Check if LinkedList is part of binary tree
              isSubPath( head, root.left) || 		//Check if LinkedList is part of left tree of root
              isSubPath( head, root.right); 		//Check if LinkedList is part of right tree of root
    }
    public boolean check(ListNode head, TreeNode root){
        if(head ==null) return true;		//Check if head == null then it means all comparing is done and hence return true
        if(root == null) return false;		//If root is null it means head might still have value but root has reached leaf hence return true
        if(head.val!=root.val) return false; //if head value != root value then return null
        return check(head.next,root.left) || check(head.next,root.right);     //if head.val==root.val, check the next node of head with root's left and right children
    }
}
