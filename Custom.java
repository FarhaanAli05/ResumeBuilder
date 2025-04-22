package FinalProject;
/*
 * Date: June 16, 2022
 * Author: Farhaan Ali
 * Description: Custom category subclass that inherits from category parent class
 */
public class Custom extends Category {
	
	// Constructors
	public Custom() {
		super();
	}
	
	public Custom(String inCategory, String inLine) {
		super(inCategory, inLine);
	}
	
	// toString/helper method
	public String toString() {
		return super.getLine();
	}
}