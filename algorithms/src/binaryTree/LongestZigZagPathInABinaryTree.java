package binaryTree;
/*https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 * Given a binary tree root, a ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right then move to the right child of the current node otherwise move to the left child.
Change the direction from right to left or right to left.
Repeat the second and third step until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.
 */
public class LongestZigZagPathInABinaryTree {
	
	int max=0;
	public static void main(String[] args) {
		LongestZigZagPathInABinaryTree tst=new LongestZigZagPathInABinaryTree();
		TreeNode r=new TreeNode(1);
		r.right = new TreeNode(2);r.right.left= new TreeNode(3);r.right.right= new TreeNode(4);
		r.right.right.left=new TreeNode(5);r.right.right.right=new TreeNode(6);
		r.right.right.left.right=new TreeNode(7);r.right.right.left.right.right=new TreeNode(8);
		System.out.println(tst.longestZigZag(r));

	}
	public int longestZigZag(TreeNode root) {
        helper(root,true);
        return max;
    }
    public int helper(TreeNode root,boolean goLeft){
        if(root==null){
            return 0;
        }
        int left =helper(root.left,false)  ;	//For every Node level, check ZigZag Height for leftNode
        int right = helper(root.right,true)  ;  //For every Node level, check ZigZag Height for RightNode
        max=Math.max(max,Math.max(left,right)); //The max ZigZagHeight for current Node is max of left or right nodes
        return 1+(goLeft?left:right);           //for current node, return 1 + either height of left or right node depending on boolean
        										//The boolean goLeft should toggle depending on what level it is
        										//This return statement takes care of toggling from left to right
    }
}
