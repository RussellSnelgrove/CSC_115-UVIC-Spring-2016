

/*
 * Programmer note: Use this space to describe the class Skier.
 * You may use the specification description as a guide.
 */
public class Skier {

	// Programmer note: Do not alter the following instance variables.
	private String name; // the unique name of the skier
	private int level; // level of skill

/*
 * Programmer note:  Each of the methods below are not complete and
 * need to be implemented by you.
 * Make sure you provide method header comments and provide
 * the implementation code. 
 * Make sure you test regularly for compilation and errors,
 * It is recommended that you reference the completed main method,
 * where each of your methods is tested;
 * follow that ordering so lyou can monitor your progress.
 */

	/**
	*sets the name of the skier and level
	*@param name
	*/
	public Skier(String name) {
		this.name = name;
		this.level =0;
	}

	/**
	*sets the name of the skier and level
	*@param name, level
	*/
	public Skier(String name, int level) {
		this.name = name;
		if (level <= 4 && level >=0){
		this.level = level;
	}else{
		this.level = 0;
	}
	}

	
	/**
	*updates the name of the skier
	*@param name
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	*returns the name of the skier
	*@return name
	*/
	public String getName() {
		// programmer note, the return statement is only a placeholder so compilation works.
		return name;
	}

	/**
	*sets the level of the skier
	*@param level
	*/
	public void setLevel(int level) {
		if (level <= 4 && level >0){
		this.level = level;
	}else{
	}
	}

	
	/**
	*gets the level of the skier
	*@return level
	*/
	public int getLevel() {
		// programmer note: The return statement is only a placeholder.
		return level;
	}
	
	
	/**
	*checks for equality in skiers
	*@param other (skier)
	*/
	public boolean equals(Skier other) {
		if(this.getName(). equals (other.name)){
			return true;
		}else{
		return false;
	}
	}

	/**
	*returns the name and level of the skier
	*@reutrn level and name
	*/
	public String toString() {
		// programmer note: The return statement is only a placeholder.

	return (getName() + " (level "+ (getLevel())+ ")") ;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("Testing the Skier class.");
		Skier s1 = null;
		try {
			s1 = new Skier("Howie SnowSkier", 4);
		} catch(Exception e) {
			System.out.println("Constructor not working.");
			e.printStackTrace();
			return;
		}
		if (!s1.getName().equals("Howie SnowSkier")) {
			System.out.println("Failed at test one.");
			return;
		}
		if (s1.getLevel() != 4) {
			System.out.println("Failed at test two.");
			return;
		}
		Skier s2 = new Skier("Baby Skier");
		if (!s2.getName().equals("Baby Skier")) {
			System.out.println("Failed at test three.");
			return;
		}
		if (s2.getLevel() != 0) {
			System.out.println("Failed at test four.");
			return;
		}
		s2.setName("Better Skier");
		s2.setLevel(1);
		if (!s2.getName().equals("Better Skier") || s2.getLevel() != 1) {
			System.out.println("Failed at test five.");
			return;
		}
		if (s1.equals(s2)) {
			System.out.println("Failed at test six.");
			return;
		}
		if (!s1.equals(new Skier("Howie SnowSkier",4))) {
			System.out.println("Failed at test seven.");
			return;
		}
		if (s1.toString().equals("Howie SnowSkier (level 0)")) {
			System.out.println("Failed at test eight.");
			System.out.println("Expected: Howie SnowSkier (level 0)");
			System.out.println("Got:      "+s1.toString());
			return;
		}
		System.out.println("All tests passed.");
	}
}
	