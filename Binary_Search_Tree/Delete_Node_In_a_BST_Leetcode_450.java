package Binary_Search_Tree;
import Binary_Search_Tree.Binary_Search_Tree.Node;
//import Binary_Search_Tree.Insert_In_To_A_Binary_Search_Tree_Leetcode_701.TreeNode;
public class Delete_Node_In_a_BST_Leetcode_450 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(){		
		}
		TreeNode(int val){
			this.val=val;
		}
		TreeNode(int val,TreeNode left,TreeNode right){
			this.val=val;
			this.left=left;
			this.right=right;
		}		
   }
	class solution{
		public TreeNode deletNode(TreeNode root,int key) {
			return delet(root,key);
		}
		public TreeNode delet(TreeNode root,int key) {
			if(root==null) {
				return null;
			}
			if(root.val<key) {
				root.right=delet(root.right,key);
			}else if(root.val>key){
				root.right=delet(root.right,key);
			}else {
				//0 or 1Child
				if(root.left==null) {
					return root.right;
				}else if(root.right==null){
					return root.left;
				}else {	
					int max=max(root.left);
					root.left=delet(root,max);
					root.val=max;
				}
			}
			return root;
		}
		private int max(TreeNode node) {
			if(node==null) {
				return Integer.MIN_VALUE;
			}
			int right=max(node.right);
			return Math.max(node.val,right);
		}
	}
}