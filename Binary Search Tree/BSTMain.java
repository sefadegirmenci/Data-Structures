import java.util.Arrays;
import java.util.Scanner;

public class BSTMain {
	//GLOBAL VARIABLE 
	static double array[]; //this array is for storing BST's elements
	static int count=0; //when putting values into array, counter gives index
	static int size=0; //part 2 find size of the BST
	// left- root - right -> do in order traverse and put every item on the array
	public static void fillArray(TreeNode focusNode) 
	{
		if(focusNode!=null)
		{
			fillArray(focusNode.getLeft());
			array[count++]=focusNode.getData();
			fillArray(focusNode.getRight());
		}
	}

	//return size of the tree by using in order traverse
	public static void getSize(TreeNode focusNode)
	{
		if(focusNode!=null)
		{
			getSize(focusNode.getLeft());
			size++;
			getSize(focusNode.getRight());
		}
	}

	public static double findMedianwithSizeInfo(BinarySearchTree bst,int size) {
		array=new double[size];
		fillArray(bst.getRoot());
		count=0;	//reset global variable count	

		if(size%2==1)
		{
			return array[(size/2)];
		}
		else
		{
			return (array[size/2]+array[(size/2)-1])/2;
		}
	}
	
	public static BinarySearchTree reduceOneTree(BinarySearchTree tree1,BinarySearchTree tree2,TreeNode focusNode)
	{
		if(focusNode!=null)
		{
			tree1=reduceOneTree(tree1,tree2,focusNode.getLeft());
			tree1.add(focusNode.getData());
			tree1=reduceOneTree(tree1,tree2,focusNode.getRight());
		}
		return tree1;

	}
	// median exercise #1
	public static double perfectMedian(BinarySearchTree bst){
		return bst.getRoot().getData();	
	}


	// median exercise #2
	public static double anyMedian(BinarySearchTree bst){
		//get the size of the bst by getSize function
		size=0;
		getSize(bst.getRoot());
		
		return findMedianwithSizeInfo(bst, size);
	}
	
	// median exercise #3
	public static double nChildrenMedian(BinarySearchTree bst){
		int treeSize=(bst.getRoot().getNumberOfChildren())+1;
		
		return findMedianwithSizeInfo(bst, treeSize);
	}
	
	// median exercise #4
	public static double twoTreesMedian(BinarySearchTree tree1, BinarySearchTree tree2){
		BinarySearchTree newTree;
		
		int sizeFirst=tree1.getRoot().getNumberOfChildren()+1;
		int sizeSecond=tree2.getRoot().getNumberOfChildren()+1;
		//add tree with minimum elements to the tree with more elements
		if(sizeFirst>sizeSecond) 
		{
			newTree=reduceOneTree(tree1,tree2,tree2.getRoot());	//adds items of tree2 to tree1
		}else
		{
			newTree=reduceOneTree(tree2,tree1,tree1.getRoot());	//adds items of tree2 to tree1
		}
		
		return nChildrenMedian(newTree);
	}

	public static void main(String[] args) {
		BinarySearchTree myTree = new BinarySearchTree();


		myTree.add(1);
		myTree.add(3);
		myTree.add(6);
		myTree.add(4);
		myTree.add(7);
		myTree.add(8);
		myTree.add(10);
		myTree.add(14);
		myTree.add(13);



		System.out.println(myTree);
		System.out.println(anyMedian(myTree));

				
	}

}
