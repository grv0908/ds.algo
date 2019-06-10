/**
 * 
 */
package ds.algo.binaryTree;

import java.util.Stack;

/**
 * @author Gaurav Rajput (grv0908@gmail.com)
 * Created at Jun 8, 2019
 */
public class TreeTraversals {
	
	/**
	 * Takes root of tree and traverse tree in
	 * preorder manner recursively
	 * @param root
	 */
	public static void recursivePreorder(TreeNode root) {
		if(root == null)
			return;
	
		System.out.print(root.val + " ");
		recursivePreorder(root.left);
		recursivePreorder(root.right);
	}
	
	/**
	 * Takes root of tree and traverse tree in
	 * inorder manner recursively.
	 * @param root
	 */
	public static void recursiveInorder(TreeNode root) {
		if(root == null)
			return;
	
		recursiveInorder(root.left);
		System.out.print(root.val + " ");
		recursiveInorder(root.right);
	}
	
	/**
	 * Takes root of tree and traverse tree in
	 * postorder manner recursively
	 * @param root
	 */
	public static void recursivePostorder(TreeNode root) {
		if(root == null)
			return;
	
		recursivePostorder(root.left);
		System.out.print(root.val + " ");
		recursivePostorder(root.right);
	}
	
	/**
	 * Takes root of tree and traverse tree in
	 * preorder manner (iteratively) using stack.
	 * @param root
	 */
	public static void iterativePreorder(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();

		while(true) {
			if(root != null) {
				st.push(root);
				System.out.print(root.val + " ");
				root = root.left;
			}
			else {
				if(!st.isEmpty()) {
					break;
				}
				root = st.pop();
				root = root.right;
			}
		}
		System.out.println();
	}
	
	
	/**
	 * Takes root of the tree and traverse it
	 * in inorder manner (iteratively) using stack
	 * @param root
	 */
	public static void iterativeInorder(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		
		while(true) {
			if(root != null) {
				st.push(root);
				root = root.left;
			}
			else {
				if(st.isEmpty())
					break;
				
				root = st.pop();
				System.out.print(root.val + " ");
				root = root.right;
			}
		}
		System.out.println();
	}
	
	
	/**
	 * Take root of tree and print postorder 
	 * traversal of tree in iterative manner 
	 * using stack
	 * @param root
	 */
	public static void iterativePostorder(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();

		while(!st.isEmpty() || root != null) {
			if(root != null) {
				st.push(root);
				root = root.left;
			}
			else {
				TreeNode temp = st.peek().right;
				if(temp == null) {
					temp = st.pop();
					System.out.print(temp.val + " ");
					while(!st.isEmpty() && temp == st.peek().right) {
						temp = st.pop();
						System.out.print(temp.val + " ");
					}
				}
				else {
					root = temp;
				}
			}
		}
		System.out.println();
	}
}
