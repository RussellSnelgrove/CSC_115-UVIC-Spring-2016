
import java.util.ArrayList;


public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	// the root is inherited from BinaryTree.

	/**
	 * Create an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		super();
	}


	/**
	* Inserts a new item into the tree, maintaining its order. If the item already exists in the tree, nothing happens.
	* @param item - The newest item.
	*/
	
   public void insert(E item) {
		root= insert(root, item);
		
   }

   /**
	* Inserts a new item into the tree, maintaining its order. If the item already exists in the tree, nothing happens.
	* @param item - The newest item and the node in which to compare it too.
	*/
	
   protected TreeNode<E> insert(TreeNode<E> Node, E item2) {
		  TreeNode<E> node2;
				if (Node== null){
					Node = new TreeNode<E>(item2,null,null);
				return Node;
				}
			if(item2.compareTo(Node.item)<0){
				node2= insert(Node.left, item2);
				Node.left = node2;
				return Node;
			}else{
				node2= insert(Node.right, item2);
				Node.right = node2;
				return Node;
			}
   }
   
   /**
   * Looks for the item in the tree that is equivalent to the key.
   * @param key - The item that is equivalent to the item we are looking for. Equality is determined by the equals method of the item.
   * @return The item if it's in the tree, null if it is not.
   */
   
   	public E retrieve(E key){
			return retrieve(root, key);
	}
	
	protected E retrieve(TreeNode<E> Node, E key){
		if (Node ==null){
			return null;
		}else{
			if(key.compareTo(Node.item)==0){
				return Node.item;
			}else if (key.compareTo(Node.item)<0){
				return retrieve(Node.left, key);
			}else{
				return retrieve(Node.right, key);
			}
			
	}
	}

   /**
   * Finds the item that is equivalent to the key and removes it, if it's in the tree.
   * @param key - the item that is equivgalent to the item we are looking for.
   */
   
	public void delete(E key){
		root =  deleteItem(root, key);
	}
	
	protected TreeNode<E> deleteItem(TreeNode<E> Node, E item){
		if (Node ==null){
			return null;
		}else{
			if(item.compareTo(Node.item)==0){
				Node = deleteNode(Node);
			}else if (item.compareTo(Node.item)<0){
				Node.left =  deleteItem(Node.left, item);
			}else{
				Node.right = deleteItem(Node.right, item);
			}		
		}
		return Node;
	
	}
	
	protected TreeNode<E> deleteNode(TreeNode<E> Node){
		E replacement;	
		
		if (Node.left == null && Node.right == null){
			return null;
		}
		else if(Node.left==null){
			return Node.right;
		}else if(Node.right==null){
			return Node.left;
		}
		else{
			replacement= findLeftMost(Node.right);
			Node.item = replacement;
			Node.right = deleteLeftMost(Node.right);
			return Node;
		}
		
	}
	
	
	protected E findLeftMost(TreeNode<E> Node){
		if(Node.left==null){
			return Node.item;
		}else{
			return findLeftMost(Node.left);
		}
	}
	
	protected TreeNode<E> deleteLeftMost(TreeNode<E> Node){
		if(Node.left==null){
			return Node.right;
		}else{
			Node.left = deleteLeftMost(Node.left);
			return Node;
		}		
	}
	


   
   
	/**
	 * Places all the items in the tree into a sorted list.
	 * @return the sorted list.
	 */
	public ArrayList<E> inOrder() { 
		ArrayList<E> list = new ArrayList<E>();
		collectInOrder(list,root);
		return list;
	}

	


/*
 * NOTE TO STUDENT.
 * This recursive method is the one that does the work
 * of traversing the tree in order and placing items
 * into the list.c
 */
	private void collectInOrder(ArrayList<E> list, TreeNode<E> node) {
		if(node==null){
		return;
		}
		collectInOrder(list, node.left);
		System.out.println(node.item+ ",");
		collectInOrder(list, node.right);
	}

	/**
	 * Internal test harness.
	 * @param args Not used.
	 */
	public static void main(String[] args) {



		BinarySearchTree<PatientLocation> tree = new BinarySearchTree<PatientLocation>();
		PatientLocation p1 = new PatientLocation("Duck", "Donald", 338);
		PatientLocation p2 = new PatientLocation("Mouse", "Minnie",116);
		PatientLocation p3 = new PatientLocation("Dog", "Goofie",422);
		PatientLocation p4 = new PatientLocation("Newman","Alfred",607);
		tree.insert(p1);
		tree.insert(p4);
		tree.insert(p3);
		tree.insert(p2);
		System.out.println(tree.retrieve(p2));
		tree.delete(p1);
		ArrayList<PatientLocation> list  = tree.inOrder();
		System.out.println(list);
		// draw the tree in its current state:
		DrawableBTree<PatientLocation> dbt = new DrawableBTree<PatientLocation>(tree);
		dbt.showFrame();

	}

}
