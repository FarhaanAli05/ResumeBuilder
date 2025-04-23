/*
 * Date: June 16, 2022
 * Author: Farhaan Ali
 * Description: Education subclass that inherits from category parent class
 */
public class Education extends Category {
	private String schoolInfoHeader;
	
	// Constructors
	public Education() {
		super();
		schoolInfoHeader = "";
	}
	
	public Education(String inCategory, String inLine) {
		super(inCategory, inLine);
		schoolInfoHeader = "";
	}

	// Accessor method
	public String getSchoolInfoHeader() {
		return schoolInfoHeader;
	}

	// Modifier method
	public void setSchoolInfoHeader(String inSchoolInfoHeader) {
		schoolInfoHeader = inSchoolInfoHeader;
	}
}