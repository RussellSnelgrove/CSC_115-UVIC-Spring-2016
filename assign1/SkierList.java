

/**
 * Progarmmer note: Use this space to describe the class SkierList. You may use
 * the specification description as a guide.
 */
public class SkierList {
	// Programmer note: Do not alter the following instance variables.
	private Skier[] skiers; // array storage for skiers
	private int count; // the number of skiers in the list
	// the following is the initial size of the empty skiers array.
	private static final int INITIAL_CAP = 3;

	/*
	 * Programmer note: Each of the methods below are not complete and need to
	 * be implemented by you. Make sure you provide method header comments and
	 * provide the implementation code. Make sure you test regularly for
	 * compilation and errors. It is recommended that you reference the
	 * completed main method, where each of your methods is tested; follow that
	 * ordering so you can monitor your progress.
	 */

	 
	/**
	*this initializes a skier list
	*/	
	public SkierList() {
		skiers = new Skier[INITIAL_CAP];
	}

		
	/**
	* Gets the size of the SkierList
	* @return The number of Skiers in the list.
	*/	
	public int size() {
		int g = 0;
		while (g < skiers.length) {
			if (skiers[g] == null) {
				return g;
			}
			g++;
		}
		return g;
	}

	/**
	* Accesses the skier in the list by their position index.
	* If the index is out of range of the list, then null is returned.
	* @param index The index of the position.
	* @return The skier at that index (0...size-1) or null if the index is out of bounds.
	*/
	public Skier get(int index) {
		if (skiers.length <= index) {
			return null;
		} else {
			return skiers[index];
		}
	}
	
	
	/**
	* Removes the skier at the index position from the list. If the index is out of range, then nothing is removed.
	* @param index The index number (0 ... size-1) of the list.
	*/
	public void remove(int index) {
		if (index < size()) {
			int z = index;
			while (z < size() - 1) {
				skiers[z] = skiers[z + 1];
				z++;
			}
			skiers[z] = null;
		}
	}
	
		/**
		*adds a new skier
		*@param skier
		*/
	public void add(Skier skier) {

		/*
		 * If the skiers array is full, it is replaced with a larger array.
		 */
		if (size() >= skiers.length) {
			Skier[] newList = new Skier[size() * 2];
			int y = 0;
			while (y < size()) {
				newList[y] = skiers[y];
				y++;
			}
			skiers = newList;
		}
		if (size() < skiers.length) {
			skiers[size()] = skier;
		}

		/*
		 * Programmer note: If the skiers array is full, it needs to be replaced
		 * with a larger array. It has been proven by algorithm efficiency
		 * experts that the best resize process is to double the size of the
		 * existing array. In this assignment, you do not need to similarly
		 * reduce the size of the array when skiers are removed.
		 */
	}

	
	/**
	*finds the position of a skier in an array
	*@param skier
	*@returns the position of the skier in the array
	*/
	public int findSkier(Skier skier) {
		// Programmer note: The following is a placeholder.
		int a = 0;
		while (a <= (size())) {
			if (skier == skiers[a]) {
				break;
			}
			a++;

		}
		return a;		
	}

	/**
	 * Used primarily as a test harness for the class.
	 * 
	 * @param args
	 *            Not used.
	 */
	public static void main(String[] args) {
		System.out.println("Testing the SkierList class.");
		SkierList list = null;
		try {
			list = new SkierList();
		} catch (Exception e) {
			System.out.println("Constructor not working.");
			e.printStackTrace();
			return;
		}
		// Add some skiers.
		Skier s1 = new Skier("Daffy Duck", 0);
		list.add(s1);
		if (list.size() != 1) {
			System.out.println("Failed at test one.");
			return;
		}
		if (!list.get(0).equals(s1)) {
			System.out.println("Failed at test two.");
			System.out.println("The first skier in the list needs to be in index position 0");
			return;
		}
		if (list.findSkier(s1) == -1) {
			System.out.println("Failed at test three.");
			return;
		}
		Skier s2 = new Skier("Bugs Bunny", 4);
		list.add(s2);
		if (s2.getLevel() != 4) {
			System.out.println("Failed at test four.");
			return;
		}
		if (list.size() != 2) {
			System.out.println("Failed at test five.");
			return;
		}
		Skier tmp1 = list.get(0);
		Skier remaining;
		if (tmp1.equals(s1)) {
			remaining = s2;
		} else {
			remaining = s1;
		}
		list.remove(0);
		if (list.findSkier(remaining) == -1) {
			System.out.println("Failed at test six.");
			return;
		}
		if (list.size() != 1) {
			System.out.println("Failed at test seven.");
			return;
		}
		if (!list.get(0).equals(remaining)) {
			System.out.println("Failed at test eight.");
			return;
		}
		list.remove(0);
		if (list.size() != 0) {
			System.out.println("Failed at test nine.");
			return;
		}
		System.out.println("Testing for expansion.");
		// note that the array has to expand in this test.
		// Creating an initial array with a length >= max is a failure.
		String prefix = "Skier";
		int max = 1000;
		try {
			for (int i = 0; i < max; i++) {
				list.add(new Skier(prefix + i));
			}
		} catch (Exception e) {
			System.out.println("Failed at test 10.");
			e.printStackTrace();
			return;
		}
		for (int i = max - 1; i >= 0; i--) {
			if (list.findSkier(new Skier(prefix + i)) == -1) {
				System.out.println("Failed at test 11.");
				System.out.println("Unable to find skier: " + (prefix + i));
				return;
			}
		}
		System.out.println("All tests passed");
	}
}