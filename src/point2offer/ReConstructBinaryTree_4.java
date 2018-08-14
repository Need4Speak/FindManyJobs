package point2offer;

import java.util.Arrays;

/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class ReConstructBinaryTree_4 {
	private static ReConstructBinaryTree_4 bt = new ReConstructBinaryTree_4();

	/**
	 * 1. 传复制
	 * 
	 * @param pre
	 * @param in
	 * @return
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0)
			return null;
		else {
			TreeNode treeNode = new TreeNode(pre[0]);
			int i = 0;
			while (i < in.length) {
				if (in[i] == pre[0]) {
					break;
				}
				i++;
			}
			treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
			treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
					Arrays.copyOfRange(in, i + 1, in.length));
			return treeNode;
		}

	}

	/**
	 * 2. 传索引
	 * 
	 * @param pre
	 * @param in
	 * @return
	 */
	public TreeNode reConstructBinaryTreeByIndex(int[] pre, int[] in) {
		return this.buildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	public TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		} else {
			TreeNode treeNode = new TreeNode(pre[preStart]);
			int index = 0;
			while (index + inStart <= inEnd) {
				if (in[index + inStart] == pre[preStart])
					break;
				++index;
			}
			treeNode.left = this.buildTree(pre, preStart + 1, preStart + index, in, inStart, inStart + index - 1);
			treeNode.right = this.buildTree(pre, preStart + index + 1, preEnd, in, inStart + index + 1, inEnd);
			return treeNode;
		}

	}

	public void inTraverse(TreeNode treeNode) {
		if (treeNode != null) {
			inTraverse(treeNode.left);
			System.out.println(treeNode.val);
			inTraverse(treeNode.right);
		}
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
//		 TreeNode root = bt.reConstructBinaryTree(pre, in);
		TreeNode root2 = bt.reConstructBinaryTreeByIndex(pre, in);
		bt.inTraverse(root2);
	}
}