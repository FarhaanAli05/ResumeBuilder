/*
 * Date: June 16, 2022
 * Author: Farhaan Ali
 * Description: Category parent class; acts as 'template' for subclasses by taking in category name and line-by-line contents
 */
public class Category {
	private String category;
	private String line;
	
	// Constructors
	public Category() {
		category = "";
		line = "";
	}
	
	public Category(String inCategory, String inLine) {
		category = inCategory;
		line = inLine;
	}
	
    // Accessor methods
	public String getCategory() {
		return category;
	}
	
	public String getLine() {
		return line;
	}
	
    // Modifier methods
	public void setCategory(String inCategory) {
		category = inCategory;
	}
	
	public void setLine(String inLine) {
		line = inLine;
	}
}