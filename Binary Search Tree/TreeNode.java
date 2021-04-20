/**
* This class is an implementation 
* of a tree node with 2 children
* 
*/

public class TreeNode {
		private int numberOfChildren=0;
		private int data;
		private TreeNode left, right;
		
		public TreeNode(int data) {
			this.setData(data);
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		public int getNumberOfChildren(){
			return numberOfChildren;
		}
		public void incrementNumberOfChildren(){
			this.numberOfChildren++;
		}
}
