

 
public class BinaryTree<E> {

	/* The root is inherited by any subclass
	 * so it must be protected instead of private.
	 */
	protected TreeNode<E> root;
	/**
	 * Create an empty BinaryTree.
	 */
	 
	public BinaryTree() {
	}

	/**
	 * Create a BinaryTree with a single item.
	 * @param item The only item in the tree.
	 */

	public BinaryTree(E item) {
		root = new TreeNode<E>(item);
	}
	/**
	 * Used only by subclasses and classes in the same package (directory).
	 * @return The root node of the tree.
	 */
	protected TreeNode<E> getRoot() {
		return root;
	}
	
	/**
	*	Finds the height of the binary tree
	* @return The height of the tree. The textbook's definition of the height 
	* is the maximum number of nodes from the root to a leaf node. 
	* The height of an empty tree is therefore equal to 0.
	*/
	public int height(){
		if(isEmpty()){
			return 0;
		}else{
        TreeNode<E> node = root;
        return height(node);
		}
		
	}
	
	/**
	*	Finds the height of the binary tree
	* @return The height of the tree. The textbook's definition of the height 
	* is the maximum number of nodes from the root to a leaf node. 
	* The height of an empty tree is therefore equal to 0.
	*/	
	int height(TreeNode<E> node1){
		if(node1 == null){
			return -1;
		}
		int leftheight = height(node1.left);
		int rightheight = height(node1.right);
		if(leftheight > rightheight){
			return leftheight + 1;
	}else{
			return rightheight +1;
		}
	}
	
	/**
	* finds if tree is empty
	* @return True if the tree is empty.
	*/
	
	public boolean isEmpty(){
		if(root==null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	* Removes all the nodes from the tree, making it empty.
	*/
	public void makeEmpty(){
		root = null;
	}



}

	
