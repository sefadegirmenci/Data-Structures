
public class BinarySearchTree implements BSTInterface {
	
	private TreeNode root;
	
	//search for data in the tree whether exist or not
	public boolean duplicateExists(TreeNode focusNode,int data) {
		boolean found=false;
		while(focusNode!=null)
		{
			if(data<focusNode.getData())
			{
				focusNode=focusNode.getLeft();
			}else if(data>focusNode.getData())
			{
				focusNode=focusNode.getRight();
			}else return true;
		}
		return found;
	}
	
	public BinarySearchTree() {
		// add your code here
		root=null;
	}

	@Override
	public void add(int data) {
		// add your code here, you are free to use helper methods
		
		TreeNode newNode=new TreeNode(data);
		if(root==null)
		{
			root=newNode;
			return;
		}
		
		
		
		if(!duplicateExists(root, data)) {
			TreeNode focusNode=root;
			TreeNode parent=root;
			while(true)
			{
				
				parent=focusNode;
				parent.incrementNumberOfChildren();

				if(data<focusNode.getData())
				{
					focusNode=focusNode.getLeft();
					if(focusNode==null)
					{
						parent.setLeft(newNode);
						break;
					}
				}
				else
				{
					focusNode=focusNode.getRight();
					if(focusNode==null)
					{
						parent.setRight(newNode);
						break;
					}
				}


			}

		}
	}
	

	@Override
	public TreeNode delete(int data) {
		// you don't have to implement this
		return null;
	}

	@Override
	public TreeNode search(int data) {
		// you don't have to implement this
		return null;
	}

	@Override
	public boolean contains(int data) {
		// you don't have to implement this
		return false;
	}
	
	//provides the String representation of the BST in inorder fashion
	public String toString() {
		return toStringInorder(root).trim();
	}
	
	private String toStringInorder(TreeNode root) {
	    String result = "";
	    if (root == null)
	        return result;
	    result += toStringInorder(root.getLeft());
	    result += root.getData() + " ";
	    result += toStringInorder(root.getRight());

	    return result;
	}
	
	public TreeNode getRoot(){
		return root;
	}

}
