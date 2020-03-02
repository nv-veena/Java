package binaryTree;
/*https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
 * Given a binary tree root, the task is to return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
class Pair{
    Integer min;
    Integer max;
    int sum;
    boolean isBST;

    public Pair(Integer min, Integer max, int sum, boolean isBST) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.isBST = isBST;
    }
}
public class MaximumSumBSTinBinaryTree {
	int max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		MaximumSumBSTinBinaryTree tst=new MaximumSumBSTinBinaryTree();
		TreeNode r=new TreeNode(4);
		r.left = new TreeNode(3);
		r.left.left=new TreeNode(1);r.left.right=new TreeNode(2);
				
		//r.right = new TreeNode(3);r.right.left= new TreeNode(2);r.right.right= new TreeNode(5);
		//r.right.right.left=new TreeNode(4);r.right.right.right=new TreeNode(6);
		//r.right.right.left.right=new TreeNode(7);r.right.right.left.right.right=new TreeNode(8);
		System.out.println(tst.maxSumBST(r));	
	}
	 public int maxSumBST(TreeNode root) {
			if(root==null)
				return 0;
	        helper(root);
	        return Math.max(0,max);	//take care of the situation where sum is Negative then return 0
	    }
		public Pair helper(TreeNode root) {
			if(root==null) { //If reached null then return MIN as Integer.MIN_VAULUE, max as Integer.MAX_VALUE and return isBST to be true
				return new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
			}
			Pair left=helper(root.left); //get Pair value from left subrtee
			Pair right=helper(root.right); //get Pair value from right subtree
			if(left.isBST &&  		//If left and right subtrees are BSTs
			   right.isBST && 
				((left.max==Integer.MAX_VALUE || left.max<root.val) &&  //Check is current Tree is also BST
				(right.min==Integer.MIN_VALUE || right.min>root.val))) {
				int sum=left.sum+right.sum+root.val;
				max=Math.max(sum, max);
				
				//In below conditions, why are we checking Integer.MIN_VALUE and Integer.MAX_VALUE
				//this is because if it reaches end of leaf node then the previous stack might 
				//have returned Integer.MIN_VALUE from left node and Integer.MAX_VALUE from right node respectively
				int min = left.min==Integer.MIN_VALUE ? root.val:left.min; //Find the minimum to be returned from current stack
																			//if current node is left child
				int max = right.max==Integer.MAX_VALUE?root.val:right.max; //Find the maximum to be returned from current stack if
																			//current node is right child
				return new Pair(min,max,sum,true);                          //return from current node stack with minimum , maximum and sum values
			}else {
				return new Pair(root.val,root.val,root.val,false);  //current Node is not BST or Left or Right Nodes are not BSTs and 
																    //hence return min, max and sum as current root node value
			}
		}
}
