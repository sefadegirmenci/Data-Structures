
public interface BSTInterface {

	
    /**
     * Add a new integer element to the BST
     */
	public void add(int data);

	
    /**
     * Find a TreeNode with the given data in the tree and remove it
     * 
     * @return TreeNode with the given data, from the tree
     */
	public TreeNode delete(int data);

	
    /**
     * Find a TreeNode with the given data in the tree
     * 
     * @return TreeNode with the given data, from the tree
     */
	public TreeNode search(int data);

	
    /**
     * Check whether there is a TreeNode with the given data in the tree
     * 
     * @return boolean value result
     */
	public boolean contains(int data);

}
