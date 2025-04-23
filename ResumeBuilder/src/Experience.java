/*
 * Date: June 16, 2022
 * Author: Farhaan Ali
 * Description: Experience subclass that inherits from category parent class
 */
public class Experience extends Category {
	private String titleAndYearHeader;
	private String companyAndAddressHeader; // Header variables store and format each value passed to them (e.g. company name, year, etc.)
	private String yearBegin;
	private String yearEnd;
	private int year;
	private boolean currentlyWorking;
	private String entry;
	
	// Constructor
	public Experience() {
		super();
		titleAndYearHeader = "";
		companyAndAddressHeader = "";
		yearBegin = "";
		yearEnd = "";
		year = 0;
		currentlyWorking = false;
	}

	// Methods
	
    /*
    *  Pre: Receives String variables containing user-specified position they worked/volunteered as, and the years they began and ended their work
    *  Post: Modifies variable containing header that contains the position title and years worked
    *  Description: Formats header containing the specified title and year
    */
	public void setTitleAndYearHeader(String inTitle, String yearBegin, String yearEnd) {
		if (yearEnd.equals(yearBegin)) {
			StringBuilder expHeader1 = new StringBuilder();
			expHeader1.append("\n│    " + inTitle);
			for (int j = inTitle.length() + 5; j <= 80 - yearBegin.length(); j++) {
				expHeader1.append(" ");
			}
			expHeader1.append(yearBegin);
			for (int j = 0; j < 4; j++) {
				expHeader1.append(" ");
			}
			expHeader1.append("│");
			titleAndYearHeader = expHeader1.toString();
			return;
		}
		StringBuilder expHeader1 = new StringBuilder();
		expHeader1.append("\n│    " + inTitle);
		for (int j = inTitle.length() + 5; j <= 80 - yearBegin.length() - yearEnd.length() - 1; j++) {
			expHeader1.append(" ");
		}
		expHeader1.append(yearBegin + "-" + yearEnd);
		for (int j = 0; j < 4; j++) {
			expHeader1.append(" ");
		}
		expHeader1.append("│");
		titleAndYearHeader = expHeader1.toString();
	}

    /*
    *  Pre: Receives String variables containing user-specified organization they worked/volunteered at as well as its street address
    *  Post: Modifies variable containing header that contains the organization name and address
    *  Description: Formats header containing the specified organization name and address
    */
	public void setCompanyAndAddressHeader(String inCompany, String inAddress) {
		StringBuilder expHeader2 = new StringBuilder();
		expHeader2.append("│    " + inCompany + " | " + inAddress);
		for (int j = inCompany.length() + inAddress.length() + 8; j < 85; j++) {
			expHeader2.append(" ");
		}
		expHeader2.append("│");
		companyAndAddressHeader = expHeader2.toString();
	}

	// Accessor methods
	public String getTitleAndYearHeader() {
		return titleAndYearHeader;
	}
	
	public String getCompanyAndAddressHeader() {
		return companyAndAddressHeader;
	}
	
	public String getYearBegin() {
		return yearBegin;
	}

	public void setYearBegin(String yearBegin) {
		this.yearBegin = yearBegin;
	}

	public String getYearEnd() {
		return yearEnd;
	}

	// Modifier methods
	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}

	public boolean isCurrentlyWorking() {
		return currentlyWorking;
	}

	public void setCurrentlyWorking(boolean currentlyWorking) {
		this.currentlyWorking = currentlyWorking;
		if (currentlyWorking == true) {
			yearEnd = "Present";
			year = 99999;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int inYear) {
		year = inYear;
	}
	
	public void setEntry(String inEntry) {
		entry = inEntry;
	}
	
	public String getEntry() {
		return entry;
	}
	
	// toString/helper method
	public String toString() {
		return titleAndYearHeader + "\n" +
			   companyAndAddressHeader +
			   super.getLine() +
			   "\n│                                                                                    │";
	}
}