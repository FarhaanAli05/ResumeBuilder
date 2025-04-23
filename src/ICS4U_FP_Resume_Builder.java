/*
 * Date: June 16, 2022
 * Author: Farhaan Ali
 * Description: Main class for resume builder; builds resume based on user input
 */
import java.io.*; // Import for file I/O
import java.util.Scanner;

public class ICS4U_FP_Resume_Builder {

    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("\n" +
                           " ██████  ███████ ███████ ██    ██ ███    ███ ███████ \n" +
                           " ██   ██ ██      ██      ██    ██ ████  ████ ██      \n" +
                           " ██████  █████   ███████ ██    ██ ██ ████ ██ █████   \n" +
                           " ██   ██ ██           ██ ██    ██ ██  ██  ██ ██      \n" +
                           " ██   ██ ███████ ███████  ██████  ██      ██ ███████ \n" +
                           "                                                     \n" +
                           " ██████  ██    ██ ██ ██      ██████  ███████ ██████  \n" +
                           " ██   ██ ██    ██ ██ ██      ██   ██ ██      ██   ██ \n" +
                           " ██████  ██    ██ ██ ██      ██   ██ █████   ██████  \n" +
                           " ██   ██ ██    ██ ██ ██      ██   ██ ██      ██   ██ \n" +
                           " ██████   ██████  ██ ███████ ██████  ███████ ██   ██  Press enter to continue.");
        scanner.nextLine();
        String fileLine;
    	BufferedReader reader = new BufferedReader(new FileReader("Resume Template.txt")); // Displays .txt containing resume sample at specified directory
		while ((fileLine = reader.readLine()) != null) {
			System.out.println(fileLine); // Reads all existing lines of file
		}
		reader.close();
		System.out.print("\nAbove is a preview of the resume you'll be building.");
		scanner.nextLine();
        System.out.print("\nTo begin building your own, you'll need to answer a few questions to set up the resume header.");
        scanner.nextLine();
        System.out.print("\nDisclaimer #1: Questions are case-sensetive.");
        scanner.nextLine();
        System.out.print("\nDisclaimer #2: Your resume should not exceed 53 lines; keep it brief and to the point!");
        scanner.nextLine();
        System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        String fullName, cell, location, email;
        while (true) { // Loops if invalid input is given
            System.out.print("Enter first and last name (e.g. John Doe): ");
            fullName = scanner.nextLine();
            if (fullName.length() > 70) {
                System.out.println("\nName cannot exceed 70 characters.\n");
            } else if (fullName.isBlank()) {
                System.out.println("\nCannot leave entry blank.\n");
            } else {
                break;
            }
        } // Loop for each question ensures the user does not have to re-enter their information after one invalid input is given
        while (true) {
            System.out.print("\nEnter phone number (e.g. 123-456-7890): ");
                cell = scanner.nextLine();
            if (cell.length() > 50) {
                System.out.println("\nPhone number cannot exceed 50 characters.");
            } else if (!(cell.contains("1")) && !(cell.contains("2")) && !(cell.contains("3")) && !(cell.contains("4")) && !(cell.contains("5")) && !(cell.contains("6")) && !(cell.contains("7")) && !(cell.contains("8")) && !(cell.contains("9")) && !(cell.contains("0"))) {
                System.out.println("\nPlease enter a valid phone number."); // User must enter a String containing at least 1 number
            } else if (cell.isBlank()) {
                System.out.println("\nCannot leave entry blank.");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("\nEnter city and province/state (e.g. City, ST): ");
            location = scanner.nextLine();
            if (location.length() > 50) {
                System.out.println("\nLocation cannot exceed 50 characters.");
            } else if (location.isBlank()) {
                System.out.println("\nCannot leave entry blank.");
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("\nEnter personal email (e.g. johndoe2005@gmail.com): ");
            email = scanner.nextLine();
            if (email.length() > 50) {
                System.out.println("\nEmail cannot exceed 50 characters.");
            } else if (email.isBlank()) {
                System.out.println("\nCannot leave entry blank.");
            } else {
                break;
            }
        }
		BufferedWriter writer = new BufferedWriter(new FileWriter(fullName + " - Resume.txt")); // Creates new file with name set as user's full name
		writer.close();
		// Functionality to center user's full name in resume header
		String resumeName = "│                                     John Doe                                       │";
		int middleOfString = resumeName.length()/2;
		int splitName = fullName.length()/2; // Not double variable; quotient should be truncated
		int centerNameHalf = middleOfString - splitName; // To center text, middle of resume must be subtracted with half of user's name; name will be placed in that index

		StringBuilder assemblingString = new StringBuilder(); // Import StringBuilder to assemble resume header
		
		assemblingString.append("│"); // Adds parts of Strings to resume builder
		for (int i = 0; i < centerNameHalf - 2; i++) {
			// For as many characters as there are between the half of resume minus the full name's length, add necessary # of spaces
			// Minus 2 due to resume borders
			assemblingString.append(" ");
		}
		assemblingString.append(fullName);
		for (int i = 0; i < centerNameHalf - 1; i++) {
			assemblingString.append(" ");
		}
		if (fullName.length() % 2 == 0) {
			assemblingString.append(" ");
		}
		assemblingString.append("│");
		String assembledString = assemblingString.toString(); // Resume builder combines String components into one String line
		// User's full name has now been centered in the resume header
		
		// Same 'centering' process applies to following line of resume header
		String contact = "│              123-123-1234 ∙ Placeholder, LI ∙ johndoe123@domain.com                │";
		String userContact = cell + " ∙ " + location + " ∙ " + email;
		int middleOfContactString = contact.length()/2;
		int splitUserContact = userContact.length()/2; // Not double variable; quotient should be truncated
		int centerContactHalf = middleOfContactString - splitUserContact;

		StringBuilder assemblingStringContact = new StringBuilder();
		
		assemblingStringContact.append("│");
		for (int i = 0; i < centerContactHalf - 2; i++) {
			assemblingStringContact.append(" ");
		}
		assemblingStringContact.append(userContact);
		for (int i = 0; i < centerContactHalf - 1; i++) {
			assemblingStringContact.append(" ");
		}
		if (userContact.length() % 2 == 0) {
			assemblingStringContact.append(" ");
		}
		assemblingStringContact.append("│");
		String assembledStringContact = assemblingStringContact.toString();
		
		System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
		String resumeInProgress = "┌––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┐\n"
								+ "│                                                                                    │\n"
								+ "│                                                                                    │\n"
								+ assembledString + "\n"
								+ "│                                                                                    │\n"
								+ assembledStringContact + "\n"
								+ "│                                                                                    │\n"
								+ "│                                                                                    │";
		System.out.println("Here's what you've got so far:\n");
		System.out.println(resumeInProgress); // Displays completed resume header to user - end of guided part of program
        String categoryNoStr;
        int categoryNo;
        scanner.nextLine();
        while (true) {
            System.out.println("CATEGORIES (DUPLICATES ALLOWED)\n" +
            				   "- Summary\n" +
			                   "- Education\n" +
			                   "- Skills\n" +
			                   "- Highlights\n" +
			                   "- Work/Volunteer/Relevant Experience\n" +
			                   "- Other Interests\n" +
			                   "- Competitions\n" +
			                   "- Custom");
        	System.out.print("\nHow many categories will you include in your resume? (Max = 6) ");
            categoryNoStr = scanner.nextLine();
            if (!(categoryNoStr.equals("1")) && !(categoryNoStr.equals("2")) && !(categoryNoStr.equals("3")) && !(categoryNoStr.equals("4")) && !(categoryNoStr.equals("5")) && !(categoryNoStr.equals("6"))) {
            	System.out.println("\nInvalid input.\n"); // User can only enter numbers between 1 and 6
            	continue;
            } else {
            	categoryNo = Integer.valueOf(categoryNoStr); // Ensures the program doesn't prompt the user with an error if they do not enter a non-integer value
                break;
            }
        }
        Category[][] categoryArray = new Category[categoryNo][]; // Declares new 2D category array of user-specified size
        
        for (int i = 0; i < categoryNo; i++) { // User can add as many categories as they initially specified
    		System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
            System.out.println("ADD A CATEGORY\n" +
            				   "[1] - Summary\n" +
    		                   "[2] - Education\n" +
    		                   "[3] - Skills\n" +
    		                   "[4] - Highlights\n" +
    		                   "[5] - Work/Volunteer/Relevant Experience\n" +
    		                   "[6] - Other Interests\n" +
    		                   "[7] - Competitions\n" +
    		                   "[8] - Custom\n" + 
    		                   "OTHER OPTIONS\n" +
    		                   "[9] - View resume\n" +
    		                   "[10] - Remove a category\n" +
    		                   "[11] - Finish building resume (premature)\n");
            System.out.print("Select an option (" + i + "/" + categoryNo + " categories added): ");
            String categChoice = scanner.nextLine();
            if (categChoice.equals("1")) { // User chooses to add summary category; before adding category, program confirms with user if they would like to add category
            	System.out.println("\nSummary\n"
            					+ "––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n"
            					+ "Diligent, flexible student at Maple High School who is seeking to acquire a\n"
		            			+ "position that enables use of strong organizational and communication skills.\n"
		            			+ "I am motivated, detail-oriented, and can work in a fast-paced environment.");
            	System.out.print("\nAre you sure you want to include this category (Y/N)? ");
            	String categConf = scanner.nextLine();
            	if (categConf.equals("Y") || categConf.equals("y") || categConf.contains("Yes") || categConf.contains("yes")) {
            		resumeInProgress = categSummary(i, scanner, categoryArray, resumeInProgress);
            		String[] lineCount = resumeInProgress.split("\n"); // Splits resume by \n regex (every line contains "\n") to count up number of lines in resume thus far
            		if (lineCount.length >= 53) { // If # of lines exceeds 53, warns user
                    	System.out.println("\n" + resumeInProgress);
            			for (int j = lineCount.length; j < 53; j++) {
            				if (j == 52) {
            					System.out.println("└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					System.out.println("│                                                                                    │");
            				}
            			} // Display to user current resume
            			while (true) {
            				lineCount = resumeInProgress.split("\n");
            				if (lineCount.length < 53) {
            					break;
            				}
            				String warningSelectStr;
            				int warningSelect;
            				System.out.println("\nWARNING: Your resume has exceeded 52 lines! Line count: " + lineCount.length);
	            			System.out.println("[1] - Remove a category and continue building resume\n" +
	            							   "[2] - Finish building resume");
			     			System.out.print("Select an option: ");
			     			warningSelectStr = scanner.nextLine();
			     			if (!(warningSelectStr.equals("1") && !(warningSelectStr.equals("2")))) { // If user enters invalid input, program does not break
			     				continue;
			     			} else {
			     				warningSelect = Integer.valueOf(warningSelectStr);
			     			}
			     			if (warningSelect == 1) {
			     				while (true) {
			     	        		String temp = removeCategory(resumeInProgress, lineCount, scanner, i); // Temp value stores resume without removed category as well as updated category count separated by "⟁"
			     	        		String[] tempSplit = temp.split("⟁"); // Splits resume by ⟁ unicode
			     	        		resumeInProgress = tempSplit[0]; // Resume is set to modified resume
			     	        		if (Integer.valueOf(tempSplit[1]) == (i-1)) {
					     				StringBuilder resumeCompletion = new StringBuilder();
					     				resumeCompletion.append(resumeInProgress);
				            			for (int j = lineCount.length; j < lineCount.length + 5; j++) {
				            				if (j == lineCount.length + 4) {
				            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
				            				} else {
				            					resumeCompletion.append("\n│                                                                                    │");
				            				}
				            			}
				            			resumeInProgress = resumeCompletion.toString();
				            			writeToFile(resumeInProgress, fullName);
				            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
				            			return; // If updated category count has not been updated (if user selects exit when asked which category they would like to remove), completes resume for user and program terminates
			     	        		}
			     					lineCount = resumeInProgress.split("\n");
		     						i--; // Decrements category count value so when for loop loops, i changes appropriate (when category is removed, i decreases; when it has not been removed, i remains the same)
		     						break;
			     				}
			     				continue;
			     			} else if (warningSelect == 2) {
			     				StringBuilder resumeCompletion = new StringBuilder();
			     				resumeCompletion.append(resumeInProgress);
		            			for (int j = lineCount.length; j < lineCount.length + 4; j++) {
		            				if (j == lineCount.length + 3) {
		            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
		            				} else {
		            					resumeCompletion.append("\n│                                                                                    │");
		            				} // Adds extra resume lines as well as bottom border to close off and complete the resume
		            			}
		            			resumeInProgress = resumeCompletion.toString();
		            			writeToFile(resumeInProgress, fullName); // Writes completed resume to file
		            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
		            			break; // Completes resume for user if they enter 2
			     			} else {
			     			}
            			}
            		} else if (i == categoryNo - 1) {
            			String[] resumeLines = resumeInProgress.split("\n");
            			StringBuilder resumeFiller = new StringBuilder();
            			resumeFiller.append(resumeInProgress);
            			for (int j = resumeLines.length; j < 53; j++) {
            				if (j == 52) {
            					resumeFiller.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					resumeFiller.append("\n│                                                                                    │");
            				}
            			}
            			resumeInProgress = resumeFiller.toString();
            			writeToFile(resumeInProgress, fullName);
            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
            			break; // Completes resume for user if category count has reached its limit and user chooses to exit
            		} else {
            			System.out.println("\nHere's what you've got so far:\n" + resumeInProgress);
            			System.out.println("Lines used: " + lineCount.length + " of 53"); // When category is removed, displays modified resume to user as well as current resume line count
            		}
            	} else {
            		i--;
            	}
            } else if (categChoice.equals("2")) { // User chooses to add education category
            	System.out.println("\nEducation\n"
		    					+ "––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n"
		    					+ "Maple High School                                                  2019-2023\n"
		            			+ "Currently enrolled at Maple High School, aiming for Ontario Secondary \n"
		            			+ "School Diploma (OSSD) completion.");
		    	System.out.print("\nAre you sure you want to include this category (Y/N)? ");
		    	String categConf = scanner.nextLine();
            	if (categConf.equals("Y") || categConf.equals("y") || categConf.contains("Yes") || categConf.contains("yes")) {
            		resumeInProgress = categEducation(i, scanner, categoryArray, resumeInProgress);
            		String[] lineCount = resumeInProgress.split("\n");
            		if (lineCount.length >= 53) {
                    	System.out.println("\n" + resumeInProgress);
            			for (int j = lineCount.length; j < 53; j++) {
            				if (j == 52) {
            					System.out.println("└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					System.out.println("│                                                                                    │");
            				}
            			}
            			while (true) {
            				lineCount = resumeInProgress.split("\n");
            				if (lineCount.length < 53) {
            					break;
            				}
            				String warningSelectStr;
            				int warningSelect;
            				System.out.println("\nWARNING: Your resume has exceeded 52 lines! Line count: " + lineCount.length);
	            			System.out.println("[1] - Remove a category and continue building resume\n" +
	            							   "[2] - Finish building resume");
			     			System.out.print("Select an option: ");
			     			warningSelectStr = scanner.nextLine();
			     			if (!(warningSelectStr.equals("1") && !(warningSelectStr.equals("2")))) {
			     				continue;
			     			} else {
			     				warningSelect = Integer.valueOf(warningSelectStr);
			     			}
			     			if (warningSelect == 1) {
			     				while (true) {
			     	        		String temp = removeCategory(resumeInProgress, lineCount, scanner, i);
			     	        		String[] tempSplit = temp.split("⟁");
			     	        		resumeInProgress = tempSplit[0];
			     	        		if (Integer.valueOf(tempSplit[1]) == (i-1)) {
					     				StringBuilder resumeCompletion = new StringBuilder();
					     				resumeCompletion.append(resumeInProgress);
				            			for (int j = lineCount.length; j < lineCount.length + 5; j++) {
				            				if (j == lineCount.length + 4) {
				            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
				            				} else {
				            					resumeCompletion.append("\n│                                                                                    │");
				            				}
				            			}
				            			resumeInProgress = resumeCompletion.toString();
				            			writeToFile(resumeInProgress, fullName);
				            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
				            			return;
			     	        		}
			     					lineCount = resumeInProgress.split("\n");
		     						i--;
		     						break;
			     				}
			     				continue;
			     			} else if (warningSelect == 2) {
			     				StringBuilder resumeCompletion = new StringBuilder();
			     				resumeCompletion.append(resumeInProgress);
		            			for (int j = lineCount.length; j < lineCount.length + 4; j++) {
		            				if (j == lineCount.length + 3) {
		            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
		            				} else {
		            					resumeCompletion.append("\n│                                                                                    │");
		            				}
		            			}
		            			resumeInProgress = resumeCompletion.toString();
		            			writeToFile(resumeInProgress, fullName);
		            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
		            			break;
			     			} else {
			     			}
            			}
            		} else if (i == categoryNo - 1) {
            			String[] resumeLines = resumeInProgress.split("\n");
            			StringBuilder resumeFiller = new StringBuilder();
            			resumeFiller.append(resumeInProgress);
            			for (int j = resumeLines.length; j < 53; j++) {
            				if (j == 52) {
            					resumeFiller.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					resumeFiller.append("\n│                                                                                    │");
            				}
            			}
            			resumeInProgress = resumeFiller.toString();
            			writeToFile(resumeInProgress, fullName);
            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
            			break;
            		} else {
            			System.out.println("\nHere's what you've got so far:\n" + resumeInProgress);
            			System.out.println("Lines used: " + lineCount.length + " of 53");
            		}
            	} else {
            		i--;
            	}
            } else if (categChoice.equals("3")) { // User chooses to add skills category
            	System.out.println("\nSkills\n"
		    					+ "––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n"
		    					+ "∙ Can work effectively independently and follow instructions precisely\n"
		    					+ "∙ Demonstrates strong time management skills by balancing extracurricular\n"
		    					+ "  work and hobbies with school work to consistently meet deadlines\n"
		    					+ "∙ Consistently interacts with others to gain a full perception of tasks and\n"
		    					+ "  environments");
            	System.out.print("\nTip: It is generally not advisable to include both 'skills' and 'highlights' categories in the same resume.\nAre you sure you want to include this category? (Y/N) ");
            	String categConf = scanner.nextLine();
            	if (categConf.equals("Y") || categConf.equals("y") || categConf.contains("Yes") || categConf.contains("yes")) {
            		resumeInProgress = categSkills(i, scanner, resumeInProgress);
            		String[] lineCount = resumeInProgress.split("\n");
            		if (lineCount.length >= 53) {
                    	System.out.println("\n" + resumeInProgress);
            			for (int j = lineCount.length; j < 53; j++) {
            				if (j == 52) {
            					System.out.println("└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					System.out.println("│                                                                                    │");
            				}
            			}
            			while (true) {
            				lineCount = resumeInProgress.split("\n");
            				if (lineCount.length < 53) {
            					break;
            				}
            				String warningSelectStr;
            				int warningSelect;
            				System.out.println("\nWARNING: Your resume has exceeded 52 lines! Line count: " + lineCount.length);
	            			System.out.println("[1] - Remove a category and continue building resume\n" +
	            							   "[2] - Finish building resume");
			     			System.out.print("Select an option: ");
			     			warningSelectStr = scanner.nextLine();
			     			if (!(warningSelectStr.equals("1") && !(warningSelectStr.equals("2")))) {
			     				continue;
			     			} else {
			     				warningSelect = Integer.valueOf(warningSelectStr);
			     			}
			     			if (warningSelect == 1) {
			     				while (true) {
			     	        		String temp = removeCategory(resumeInProgress, lineCount, scanner, i);
			     	        		String[] tempSplit = temp.split("⟁");
			     	        		resumeInProgress = tempSplit[0];
			     	        		if (Integer.valueOf(tempSplit[1]) == (i-1)) {
					     				StringBuilder resumeCompletion = new StringBuilder();
					     				resumeCompletion.append(resumeInProgress);
				            			for (int j = lineCount.length; j < lineCount.length + 5; j++) {
				            				if (j == lineCount.length + 4) {
				            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
				            				} else {
				            					resumeCompletion.append("\n│                                                                                    │");
				            				}
				            			}
				            			resumeInProgress = resumeCompletion.toString();
				            			writeToFile(resumeInProgress, fullName);
				            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
				            			return;
			     	        		}
			     					lineCount = resumeInProgress.split("\n");
		     						i--;
		     						break;
			     				}
			     				continue;
			     			} else if (warningSelect == 2) {
			     				StringBuilder resumeCompletion = new StringBuilder();
			     				resumeCompletion.append(resumeInProgress);
		            			for (int j = lineCount.length; j < lineCount.length + 4; j++) {
		            				if (j == lineCount.length + 3) {
		            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
		            				} else {
		            					resumeCompletion.append("\n│                                                                                    │");
		            				}
		            			}
		            			resumeInProgress = resumeCompletion.toString();
		            			writeToFile(resumeInProgress, fullName);
		            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
		            			break;
			     			} else {
			     			}
            			}
            		} else if (i == categoryNo - 1) {
            			String[] resumeLines = resumeInProgress.split("\n");
            			StringBuilder resumeFiller = new StringBuilder();
            			resumeFiller.append(resumeInProgress);
            			for (int j = resumeLines.length; j < 53; j++) {
            				if (j == 52) {
            					resumeFiller.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					resumeFiller.append("\n│                                                                                    │");
            				}
            			}
            			resumeInProgress = resumeFiller.toString();
            			writeToFile(resumeInProgress, fullName);
            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
            			break;
            		} else {
            			System.out.println("\nHere's what you've got so far:\n" + resumeInProgress);
            			System.out.println("Lines used: " + lineCount.length + " of 53");
            		}
            	} else {
            		i--;
            	}
            } else if (categChoice.equals("4")) { // User chooses to add highlights category
            	System.out.println("\nHighlights\n"
		    					+ "––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n"
		    					+ "∙ Lorem ipsum dolor                    ∙ Nullam dapibus elit\n"
		    					+ "∙ Sit amet                             ∙ Sed lacus scelerisque\n"
		    					+ "∙ Consectetur adipiscing elit          ∙ Pulvinar pellentesque aliquet");
            	System.out.print("\nAre you sure you want to include this category?\nTip: It is generally not advisable to include both 'skills' and 'highlights' categories in the same resume. (Y/N) ");
            	String categConf = scanner.nextLine();
            	if (categConf.equals("Y") || categConf.equals("y") || categConf.contains("Yes") || categConf.contains("yes")) {
            		resumeInProgress = categHighlights(i, scanner, resumeInProgress);
            		String[] lineCount = resumeInProgress.split("\n");
            		if (lineCount.length >= 53) {
                    	System.out.println("\n" + resumeInProgress);
            			for (int j = lineCount.length; j < 53; j++) {
            				if (j == 52) {
            					System.out.println("└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					System.out.println("│                                                                                    │");
            				}
            			}
            			while (true) {
            				lineCount = resumeInProgress.split("\n");
            				if (lineCount.length < 53) {
            					break;
            				}
            				String warningSelectStr;
            				int warningSelect;
            				System.out.println("\nWARNING: Your resume has exceeded 52 lines! Line count: " + lineCount.length);
	            			System.out.println("[1] - Remove a category and continue building resume\n" +
	            							   "[2] - Finish building resume");
			     			System.out.print("Select an option: ");
			     			warningSelectStr = scanner.nextLine();
			     			if (!(warningSelectStr.equals("1") && !(warningSelectStr.equals("2")))) {
			     				continue;
			     			} else {
			     				warningSelect = Integer.valueOf(warningSelectStr);
			     			}
			     			if (warningSelect == 1) {
			     				while (true) {
			     	        		String temp = removeCategory(resumeInProgress, lineCount, scanner, i);
			     	        		String[] tempSplit = temp.split("⟁");
			     	        		resumeInProgress = tempSplit[0];
			     	        		if (Integer.valueOf(tempSplit[1]) == (i-1)) {
					     				StringBuilder resumeCompletion = new StringBuilder();
					     				resumeCompletion.append(resumeInProgress);
				            			for (int j = lineCount.length; j < lineCount.length + 5; j++) {
				            				if (j == lineCount.length + 4) {
				            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
				            				} else {
				            					resumeCompletion.append("\n│                                                                                    │");
				            				}
				            			}
				            			resumeInProgress = resumeCompletion.toString();
				            			writeToFile(resumeInProgress, fullName);
				            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
				            			return;
			     	        		}
			     					lineCount = resumeInProgress.split("\n");
		     						i--;
		     						break;
			     				}
			     				continue;
			     			} else if (warningSelect == 2) {
			     				StringBuilder resumeCompletion = new StringBuilder();
			     				resumeCompletion.append(resumeInProgress);
		            			for (int j = lineCount.length; j < lineCount.length + 4; j++) {
		            				if (j == lineCount.length + 3) {
		            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
		            				} else {
		            					resumeCompletion.append("\n│                                                                                    │");
		            				}
		            			}
		            			resumeInProgress = resumeCompletion.toString();
		            			writeToFile(resumeInProgress, fullName);
		            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
		            			break;
			     			} else {
			     			}
            			}
            		} else if (i == categoryNo - 1) {
            			String[] resumeLines = resumeInProgress.split("\n");
            			StringBuilder resumeFiller = new StringBuilder();
            			resumeFiller.append(resumeInProgress);
            			for (int j = resumeLines.length; j < 53; j++) {
            				if (j == 52) {
            					resumeFiller.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					resumeFiller.append("\n│                                                                                    │");
            				}
            			}
            			resumeInProgress = resumeFiller.toString();
            			writeToFile(resumeInProgress, fullName);
            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
            			break;
            		} else {
            			System.out.println("\nHere's what you've got so far:\n" + resumeInProgress);
            			System.out.println("Lines used: " + lineCount.length + " of 53");
            		}
            	} else {
            		i--;
            	}
            } else if (categChoice.equals("5")) { // User chooses to add experience category
            	System.out.println("\nExperience\n"
		    					+ "––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n"
		    					+ "Instruction Manual Designer                                             2021\n"
		    					+ "Exceed Robotics | Address\n"
		    					+ "∙ Wrote and designed an instruction manual detailing the steps to assemble a\n"
		    					+ "  6-legged walking robot for children aged 8-10");
            	System.out.print("\nAre you sure you want to include this category (Y/N)? ");
            	String categConf = scanner.nextLine();
            	if (categConf.equals("Y") || categConf.equals("y") || categConf.contains("Yes") || categConf.contains("yes")) {
            		resumeInProgress = categExperience(i, scanner, resumeInProgress);
            		String[] lineCount = resumeInProgress.split("\n");
            		if (lineCount.length >= 53) {
                    	System.out.println("\n" + resumeInProgress);
            			for (int j = lineCount.length; j < 53; j++) {
            				if (j == 52) {
            					System.out.println("└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					System.out.println("│                                                                                    │");
            				}
            			}
            			while (true) {
            				lineCount = resumeInProgress.split("\n");
            				if (lineCount.length < 53) {
            					break;
            				}
            				String warningSelectStr;
            				int warningSelect;
            				System.out.println("\nWARNING: Your resume has exceeded 52 lines! Line count: " + lineCount.length);
	            			System.out.println("[1] - Remove a category and continue building resume\n" +
	            							   "[2] - Finish building resume");
			     			System.out.print("Select an option: ");
			     			warningSelectStr = scanner.nextLine();
			     			if (!(warningSelectStr.equals("1") && !(warningSelectStr.equals("2")))) {
			     				continue;
			     			} else {
			     				warningSelect = Integer.valueOf(warningSelectStr);
			     			}
			     			if (warningSelect == 1) {
			     				while (true) {
			     	        		String temp = removeCategory(resumeInProgress, lineCount, scanner, i);
			     	        		String[] tempSplit = temp.split("⟁");
			     	        		resumeInProgress = tempSplit[0];
			     	        		if (Integer.valueOf(tempSplit[1]) == (i-1)) {
					     				StringBuilder resumeCompletion = new StringBuilder();
					     				resumeCompletion.append(resumeInProgress);
				            			for (int j = lineCount.length; j < lineCount.length + 5; j++) {
				            				if (j == lineCount.length + 4) {
				            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
				            				} else {
				            					resumeCompletion.append("\n│                                                                                    │");
				            				}
				            			}
				            			resumeInProgress = resumeCompletion.toString();
				            			writeToFile(resumeInProgress, fullName);
				            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
				            			return;
			     	        		}
			     					lineCount = resumeInProgress.split("\n");
		     						i--;
		     						break;
			     				}
			     				continue;
			     			} else if (warningSelect == 2) {
			     				StringBuilder resumeCompletion = new StringBuilder();
			     				resumeCompletion.append(resumeInProgress);
		            			for (int j = lineCount.length; j < lineCount.length + 4; j++) {
		            				if (j == lineCount.length + 3) {
		            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
		            				} else {
		            					resumeCompletion.append("\n│                                                                                    │");
		            				}
		            			}
		            			resumeInProgress = resumeCompletion.toString();
		            			writeToFile(resumeInProgress, fullName);
		            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
		            			break;
			     			} else {
			     			}
            			}
            		} else if (i == categoryNo - 1) {
            			String[] resumeLines = resumeInProgress.split("\n");
            			StringBuilder resumeFiller = new StringBuilder();
            			resumeFiller.append(resumeInProgress);
            			for (int j = resumeLines.length; j < 53; j++) {
            				if (j == 52) {
            					resumeFiller.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					resumeFiller.append("\n│                                                                                    │");
            				}
            			}
            			resumeInProgress = resumeFiller.toString();
            			writeToFile(resumeInProgress, fullName);
            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
            			break;
            		} else {
            			System.out.println("\nHere's what you've got so far:\n" + resumeInProgress);
            			System.out.println("Lines used: " + lineCount.length + " of 53");
            		}
            	} else {
            		i--;
            	}
            } else if (categChoice.equals("6")) { // User chooses to add interests category
            	System.out.println("\nOther Interests\n"
		    					+ "––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n"
		    					+ "∙ Chorus Music (Royal Conservatory of Music): Studied music theory and\n"
		    					+ "  practiced classical piano; RCM Grade 8\n");
            	System.out.print("Are you sure you want to include this category (Y/N)? ");
            	String categConf = scanner.nextLine();
            	if (categConf.equals("Y") || categConf.equals("y") || categConf.contains("Yes") || categConf.contains("yes")) {
            		resumeInProgress = categInterests(i, scanner, resumeInProgress);
            		String[] lineCount = resumeInProgress.split("\n");
            		if (lineCount.length >= 53) {
                    	System.out.println("\n" + resumeInProgress);
            			for (int j = lineCount.length; j < 53; j++) {
            				if (j == 52) {
            					System.out.println("└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					System.out.println("│                                                                                    │");
            				}
            			}
            			while (true) {
            				lineCount = resumeInProgress.split("\n");
            				if (lineCount.length < 53) {
            					break;
            				}
            				String warningSelectStr;
            				int warningSelect;
            				System.out.println("\nWARNING: Your resume has exceeded 52 lines! Line count: " + lineCount.length);
	            			System.out.println("[1] - Remove a category and continue building resume\n" +
	            							   "[2] - Finish building resume");
			     			System.out.print("Select an option: ");
			     			warningSelectStr = scanner.nextLine();
			     			if (!(warningSelectStr.equals("1") && !(warningSelectStr.equals("2")))) {
			     				continue;
			     			} else {
			     				warningSelect = Integer.valueOf(warningSelectStr);
			     			}
			     			if (warningSelect == 1) {
			     				while (true) {
			     	        		String temp = removeCategory(resumeInProgress, lineCount, scanner, i);
			     	        		String[] tempSplit = temp.split("⟁");
			     	        		resumeInProgress = tempSplit[0];
			     	        		if (Integer.valueOf(tempSplit[1]) == (i-1)) {
					     				StringBuilder resumeCompletion = new StringBuilder();
					     				resumeCompletion.append(resumeInProgress);
				            			for (int j = lineCount.length; j < lineCount.length + 5; j++) {
				            				if (j == lineCount.length + 4) {
				            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
				            				} else {
				            					resumeCompletion.append("\n│                                                                                    │");
				            				}
				            			}
				            			resumeInProgress = resumeCompletion.toString();
				            			writeToFile(resumeInProgress, fullName);
				            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
				            			return;
			     	        		}
			     					lineCount = resumeInProgress.split("\n");
		     						i--;
		     						break;
			     				}
			     				continue;
			     			} else if (warningSelect == 2) {
			     				StringBuilder resumeCompletion = new StringBuilder();
			     				resumeCompletion.append(resumeInProgress);
		            			for (int j = lineCount.length; j < lineCount.length + 4; j++) {
		            				if (j == lineCount.length + 3) {
		            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
		            				} else {
		            					resumeCompletion.append("\n│                                                                                    │");
		            				}
		            			}
		            			resumeInProgress = resumeCompletion.toString();
		            			writeToFile(resumeInProgress, fullName);
		            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
		            			break;
			     			} else {
			     			}
            			}
            		} else if (i == categoryNo - 1) {
            			String[] resumeLines = resumeInProgress.split("\n");
            			StringBuilder resumeFiller = new StringBuilder();
            			resumeFiller.append(resumeInProgress);
            			for (int j = resumeLines.length; j < 53; j++) {
            				if (j == 52) {
            					resumeFiller.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					resumeFiller.append("\n│                                                                                    │");
            				}
            			}
            			resumeInProgress = resumeFiller.toString();
            			writeToFile(resumeInProgress, fullName);
            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
            			break;
            		} else {
            			System.out.println("\nHere's what you've got so far:\n" + resumeInProgress);
            			System.out.println("Lines used: " + lineCount.length + " of 53");
            		}
            	} else {
            		i--;
            	}
            } else if (categChoice.equals("7")) { // User chooses to add competitions category
            	System.out.println("\nCompetitions\n"
		    					+ "––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n"
		    					+ "∙ UWaterloo’s Euclid: Took part in several math and computer science-related\n"
		    					+ "  competitions\n"
		    					+ "∙ CanHack 2021: Placed in the top 8.29% of all global participants in \n"
		    					+ "  picoCTF 2021; top 42 in Canada\n");
            	System.out.print("Are you sure you want to include this category (Y/N)? ");
            	String categConf = scanner.nextLine();
            	if (categConf.equals("Y") || categConf.equals("y") || categConf.contains("Yes") || categConf.contains("yes")) {
            		resumeInProgress = categCompetitions(i, scanner, resumeInProgress);
            		String[] lineCount = resumeInProgress.split("\n");
            		if (lineCount.length >= 53) {
                    	System.out.println("\n" + resumeInProgress);
            			for (int j = lineCount.length; j < 53; j++) {
            				if (j == 52) {
            					System.out.println("└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					System.out.println("│                                                                                    │");
            				}
            			}
            			while (true) {
            				lineCount = resumeInProgress.split("\n");
            				if (lineCount.length < 53) {
            					break;
            				}
            				String warningSelectStr;
            				int warningSelect;
            				System.out.println("\nWARNING: Your resume has exceeded 52 lines! Line count: " + lineCount.length);
	            			System.out.println("[1] - Remove a category and continue building resume\n" +
	            							   "[2] - Finish building resume");
			     			System.out.print("Select an option: ");
			     			warningSelectStr = scanner.nextLine();
			     			if (!(warningSelectStr.equals("1") && !(warningSelectStr.equals("2")))) {
			     				continue;
			     			} else {
			     				warningSelect = Integer.valueOf(warningSelectStr);
			     			}
			     			if (warningSelect == 1) {
			     				while (true) {
			     	        		String temp = removeCategory(resumeInProgress, lineCount, scanner, i);
			     	        		String[] tempSplit = temp.split("⟁");
			     	        		resumeInProgress = tempSplit[0];
			     	        		if (Integer.valueOf(tempSplit[1]) == (i-1)) {
					     				StringBuilder resumeCompletion = new StringBuilder();
					     				resumeCompletion.append(resumeInProgress);
				            			for (int j = lineCount.length; j < lineCount.length + 5; j++) {
				            				if (j == lineCount.length + 4) {
				            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
				            				} else {
				            					resumeCompletion.append("\n│                                                                                    │");
				            				}
				            			}
				            			resumeInProgress = resumeCompletion.toString();
				            			writeToFile(resumeInProgress, fullName);
				            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
				            			return;
			     	        		}
			     					lineCount = resumeInProgress.split("\n");
		     						i--;
		     						break;
			     				}
			     				continue;
			     			} else if (warningSelect == 2) {
			     				StringBuilder resumeCompletion = new StringBuilder();
			     				resumeCompletion.append(resumeInProgress);
		            			for (int j = lineCount.length; j < lineCount.length + 4; j++) {
		            				if (j == lineCount.length + 3) {
		            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
		            				} else {
		            					resumeCompletion.append("\n│                                                                                    │");
		            				}
		            			}
		            			resumeInProgress = resumeCompletion.toString();
		            			writeToFile(resumeInProgress, fullName);
		            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
		            			break;
			     			} else {
			     			}
            			}
            		} else if (i == categoryNo - 1) {
            			String[] resumeLines = resumeInProgress.split("\n");
            			StringBuilder resumeFiller = new StringBuilder();
            			resumeFiller.append(resumeInProgress);
            			for (int j = resumeLines.length; j < 53; j++) {
            				if (j == 52) {
            					resumeFiller.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					resumeFiller.append("\n│                                                                                    │");
            				}
            			}
            			resumeInProgress = resumeFiller.toString();
            			writeToFile(resumeInProgress, fullName);
            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
            			break;
            		} else {
            			System.out.println("\nHere's what you've got so far:\n" + resumeInProgress);
            			System.out.println("Lines used: " + lineCount.length + " of 53");
            		}
            	} else {
            		i--;
            	}
            } else if (categChoice.equals("8")) { // User chooses to add their own category
            	System.out.println("\nCustom\n"
		    					+ "––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––\n"
		    					+ "You can choose write your text in sentence form\n"
		            			+ "∙ Or you can choose to write your text in a list\n");
            	System.out.print("Are you sure you want to include this category (Y/N)? ");
            	String categConf = scanner.nextLine();
            	if (categConf.equals("Y") || categConf.equals("y") || categConf.contains("Yes") || categConf.contains("yes")) {
            		resumeInProgress = categCustom(i, scanner, resumeInProgress);
            		String[] lineCount = resumeInProgress.split("\n");
            		if (lineCount.length >= 53) {
                    	System.out.println("\n" + resumeInProgress);
            			for (int j = lineCount.length; j < 53; j++) {
            				if (j == 52) {
            					System.out.println("└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					System.out.println("│                                                                                    │");
            				}
            			}
            			while (true) {
            				lineCount = resumeInProgress.split("\n");
            				if (lineCount.length < 53) {
            					break;
            				}
            				String warningSelectStr;
            				int warningSelect;
            				System.out.println("\nWARNING: Your resume has exceeded 52 lines! Line count: " + lineCount.length);
	            			System.out.println("[1] - Remove a category and continue building resume\n" +
	            							   "[2] - Finish building resume");
			     			System.out.print("Select an option: ");
			     			warningSelectStr = scanner.nextLine();
			     			if (!(warningSelectStr.equals("1") && !(warningSelectStr.equals("2")))) {
			     				continue;
			     			} else {
			     				warningSelect = Integer.valueOf(warningSelectStr);
			     			}
			     			if (warningSelect == 1) {
			     				while (true) {
			     	        		String temp = removeCategory(resumeInProgress, lineCount, scanner, i);
			     	        		String[] tempSplit = temp.split("⟁");
			     	        		resumeInProgress = tempSplit[0];
			     	        		if (Integer.valueOf(tempSplit[1]) == (i-1)) {
					     				StringBuilder resumeCompletion = new StringBuilder();
					     				resumeCompletion.append(resumeInProgress);
				            			for (int j = lineCount.length; j < lineCount.length + 5; j++) {
				            				if (j == lineCount.length + 4) {
				            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
				            				} else {
				            					resumeCompletion.append("\n│                                                                                    │");
				            				}
				            			}
				            			resumeInProgress = resumeCompletion.toString();
				            			writeToFile(resumeInProgress, fullName);
				            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
				            			return;
			     	        		}
			     					lineCount = resumeInProgress.split("\n");
		     						i--;
		     						break;
			     				}
			     				continue;
			     			} else if (warningSelect == 2) {
			     				StringBuilder resumeCompletion = new StringBuilder();
			     				resumeCompletion.append(resumeInProgress);
		            			for (int j = lineCount.length; j < lineCount.length + 4; j++) {
		            				if (j == lineCount.length + 3) {
		            					resumeCompletion.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
		            				} else {
		            					resumeCompletion.append("\n│                                                                                    │");
		            				}
		            			}
		            			resumeInProgress = resumeCompletion.toString();
		            			writeToFile(resumeInProgress, fullName);
		            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
		            			break;
			     			} else {
			     			}
            			}
            		} else if (i == categoryNo - 1) {
            			String[] resumeLines = resumeInProgress.split("\n");
            			StringBuilder resumeFiller = new StringBuilder();
            			resumeFiller.append(resumeInProgress);
            			for (int j = resumeLines.length; j < 53; j++) {
            				if (j == 52) {
            					resumeFiller.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
            				} else {
            					resumeFiller.append("\n│                                                                                    │");
            				}
            			}
            			resumeInProgress = resumeFiller.toString();
            			writeToFile(resumeInProgress, fullName);
            			System.out.println("\nCompleted resume:\n" + resumeInProgress);
            			break;
            		} else {
            			System.out.println("\nHere's what you've got so far:\n" + resumeInProgress);
            			System.out.println("Lines used: " + lineCount.length + " of 53");
            		}
            	} else {
            		i--;
            	}
            } else if (categChoice.equals("9")) { // User wants to view their resume
            	System.out.println("\nHere's what you've got so far:");
            	String[] lineCount = resumeInProgress.split("\n");
            	System.out.println(resumeInProgress);
    			for (int j = lineCount.length; j < 53; j++) { // Since the resume in progress lacks a bottom border and its bottom spaces, when viewing the resume it is displayed with the bottom border and spaces
    				if (j == 52) { // For as many lines left until 53, adds lines to resume display for user; if line count = 52, closes off resume
    					System.out.println("└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
    				} else {
    					System.out.println("│                                                                                    │");
    				}
    			}
    			System.out.println("Lines used: " + lineCount.length + "/53"); // Displays # of lines in resume to user
    			i--;
        	} else if (categChoice.equals("10")) { // User wants to remove a category
        		if (i == 0) { // If category count is 0, no category can be removed
            		System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
            		System.out.println("No categories have been added yet.");
            		i--;
            		continue;
            	}
        		String[] lineCount = resumeInProgress.split("\n");
        		String temp = removeCategory(resumeInProgress, lineCount, scanner, i); // Same logic as explained above; temp equals String that contains modified resume as well as category count
        		String[] tempSplit = temp.split("⟁");
        		resumeInProgress = tempSplit[0]; // The resume equals the first part of the returned resume after it is split
        		i = Integer.valueOf(tempSplit[1]); // The category count equals the second part of the returned resume after it is split
            } else if (categChoice.equals("11")) { // Uses chooses to prematurely complete their resume
    			String[] resumeLines = resumeInProgress.split("\n");
    			StringBuilder resumeFiller = new StringBuilder();
    			resumeFiller.append(resumeInProgress);
    			for (int j = resumeLines.length; j < 53; j++) {
    				if (j == 52) {
    					resumeFiller.append("\n└––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––┘");
    				} else {
    					resumeFiller.append("\n│                                                                                    │");
    				}
    			}
    			resumeInProgress = resumeFiller.toString();
    			writeToFile(resumeInProgress, fullName);
    			System.out.println("\nCompleted resume:\n" + resumeInProgress);
    			break;
            } else {
            	i--;
            }
        }
    }
    
    /*
    *  Pre: Receives String containing resume as well as the user's full name
    *  Post: Writes resume to pre-existing file under user's name
    *  Description: Fills resume file contents with resume that the user built
    */
    public static void writeToFile(String resumeInProgress, String fullName) throws IOException {
		BufferedWriter resumeWriter = new BufferedWriter(new FileWriter(fullName + " - Resume.txt", true));
		resumeWriter.write(resumeInProgress);
		resumeWriter.close();
    }
    
    /*
    *  Pre: Receives min (number that will start at 0 and increment until 9), max (character limit that the scale will span to) as well as a behind-the-code counter that will increase until it reaches the max
    *  Post: Displays character count scale using an increasing 'min' until 'count' reaches 'max'
    *  Description: Displays to the user the maximum number of characters they can type in their response
    */
    public static void getCharacterCountScale(int min, int max, int count) {
    	if (count == max - 1) {
    		System.out.println("✘");
    		return;
    	}
    	System.out.print(min);
    	if (min == 9) {
    		min = -1;
    	}
    	min++;
    	count++;
    	getCharacterCountScale(min, max, count);
    	// Logic for recursive method:
        // Min and character limit variables exist as parameters for recursive method
        // Min increases by 1 and is printed, and method recurses
        // When min reaches 9, min is reset to 0, and actualCount increases
        // When actualCount reaches max (character limit) - 1, instead of printing next number, prints ✘ - Base case
    }
    
    /*
    *  Pre: Receives String containing resume, array containing line-by-line contents of resume String, scanner object as well as the number of currently existing categories
    *  Post: Returns the modified resume String
    *  Description: Calls on other method with category name as parameter to ultimately remove a category from the resume (or not if the user enters 8)
    */
    public static String removeCategory(String resumeInProgress, String[] lineCount, Scanner scanner, int i) {
		while (true) {
			System.out.println("\nCATEGORIES\n" +
    				   "[1] - Summary\n" +
	                   "[2] - Education\n" +
	                   "[3] - Skills\n" +
	                   "[4] - Highlights\n" +
	                   "[5] - Other Interests\n" +
	                   "[6] - Competitions\n" +
	                   "[7] - Custom\n" +
	                   "[8] - Exit");
            System.out.print("Select category to remove: "); // User chooses category they would like removed
            int removeCateg = scanner.nextInt();
            scanner.nextLine();
            if (removeCateg == 1) {
            	resumeInProgress = removeCategoryFunctionality(resumeInProgress, lineCount, i, "Summary"); // Calls method to execute functionality and remove specified category
            	return resumeInProgress;
            } else if (removeCateg == 2) {
            	resumeInProgress = removeCategoryFunctionality(resumeInProgress, lineCount, i, "Education");
            	return resumeInProgress;
            } else if (removeCateg == 3) {
            	resumeInProgress = removeCategoryFunctionality(resumeInProgress, lineCount, i, "Skills");
            	return resumeInProgress;
            } else if (removeCateg == 4) {
            	resumeInProgress = removeCategoryFunctionality(resumeInProgress, lineCount, i, "Highlights");
            	return resumeInProgress;
            } else if (removeCateg == 5) {
            	resumeInProgress = removeCategoryFunctionality(resumeInProgress, lineCount, i, "Other Interests");
            	return resumeInProgress;
            } else if (removeCateg == 6) {
            	resumeInProgress = removeCategoryFunctionality(resumeInProgress, lineCount, i, "Competitions");
            	return resumeInProgress;
            } else if (removeCateg == 7) {
            	System.out.print("\nEnter the name of your custom category (case-sensetive): "); // User enters name of custom category
        		String customCategName = scanner.nextLine();
        		resumeInProgress = removeCategoryFunctionality(resumeInProgress, lineCount, i, customCategName);
        		return resumeInProgress;
            } else if (removeCateg == 8) {
            	resumeInProgress = removeCategoryFunctionality(resumeInProgress, lineCount, i, "N/A");
            	return resumeInProgress;
            } else {
            }
		}
    }
    
    /*
    *  Pre: Receives String containing resume, array containing line-by-line contents of resume String, the number of categories added so far, as well as the user-specified category they would like removed
    *  Post: Returns String containing resume with unicode ⟁ to use as regex for String-splitting, as well as a modified category count
    *  Description: Splits resume by line, marks all lines of specified category with unicode ✗, and removes all lines with unicode ✗, effectively removing a category from the resume
    */
    public static String removeCategoryFunctionality(String resumeInProgress, String[] lineCount, int i, String categName) {
    	if (categName.equals("N/A")) { // If user chooses to exit, does not modify category count or resume
    		i--;
    		return resumeInProgress + "⟁" + i;
    	}
    	int xCount = 0;
    	for (int j = 0; j < lineCount.length; j++) {
    		// Searches resume until category name is found (and border after category is found too)
    		if (lineCount[j].contains(categName) && lineCount[j+1].contains("––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––")) {
    			while (!(lineCount[j].contains("│                                                                                    │"))) {
    				lineCount[j] = lineCount[j] + "✗";
    				j++;
    				xCount++;
    			}
				if (lineCount[j].contains("│                                                                                    │")) {
					lineCount[j] = lineCount[j] + "✗";
    				lineCount[j+1] = lineCount[j+1] + "✗";
    				xCount = xCount + 2;
    				break;
				}
    		} else if (j == lineCount.length - 1) {
    			System.out.println("\nCategory was not found.");
    			i--;
    			return resumeInProgress + "⟁" + i;
    		}
    	} // Marks all lines to remove with "✗"
    	// All lines will be removed until empty line appears in resume
    	StringBuilder avoidX = new StringBuilder();
    	for (int j = 0; j < lineCount.length; j++) {
    		if (!(lineCount[j].contains("✗"))) { // If line contains "✗", do not add; add all other lines
    			avoidX.append(lineCount[j] + "\n");
    		} else {
    			continue;
    		}
    	}
    	resumeInProgress = avoidX.toString(); // Resume is set to modified resume without removed category
    	resumeInProgress = resumeInProgress.substring(0, resumeInProgress.length() - 1);
    	String[] lineCountUpdated = resumeInProgress.split("\n");
    	System.out.println("\nCategory was successfully removed.");
    	System.out.println("Lines remaining: " + lineCountUpdated.length + " of 53");
    	i = i - 2; // Category count is decremented by 2 so that when for loop loops, it has gone down by 1 (category has been removed)
    	return resumeInProgress + "⟁" + i; // Returns resume as well as category count separated by unicode character
	}
    
    /*
    *  Pre: Receives experience object array that stores each experience object
    *  Post: Retrieves all year integer values from experience objects and uses insertion sort to order each experience object reverse chronologically
    *  Description: Sorts the entries under the experience category in order of latest to oldest
    */
    private static void insertionSort(Experience[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Experience valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1].getYear() < valueToSort.getYear()) { // > is instead switched with < so that the algorithm sorts in descending order
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSort;
        }
    }
    
    /*
    *  Pre: Receives number of categories added so far, scanner object, 2D category array storing all category subclasses as well as String containing resume
    *  Post: Returns resume with added summary category
    *  Description: User answers prompts and questions to create and add summary category to resume
    */
    public static String categSummary(int i, Scanner scanner, Category[][] categoryArray, String resumeInProgress) {
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        System.out.println("CATEGORY " + (i+1) + ": SUMMARY");
        String inHighSchool, qual1, qual2, persQual1, persQual2, skill1, skill2, skill3;
        while (true) {
        	System.out.print("\nWhich high school do you attend? (Leave blank if you prefer not to include): ");
            inHighSchool = scanner.nextLine();
            if (inHighSchool.length() > 50) {
            	System.out.println("\nCannot exceed 50 characters\n");
            	continue;
            } else {
            	break;
            }
        }
        System.out.print("\nAre you a senior student? (Y/N): ");
        boolean isSenior = false;
        String inSenior = scanner.nextLine();
        if (inSenior.contains("Yes") || inSenior.contains("yes") || inSenior.equals("Y") || inSenior.equals("y")) {
        	isSenior = true;
        }
		System.out.println("\nEnter your 2 best qualities (e.g. hard-working, motivated)");
		while (true) {
			System.out.print("Quality #1: ");
			qual1 = scanner.nextLine();
			if (qual1.length() > 25) {
				System.out.println("\nCannot exceed 25 characters.\n");
				continue;
			} else {
				qual1 = qual1.substring(0, 1).toUpperCase() + qual1.substring(1);
				break;
			}
		}
		while (true) {
			System.out.print("Quality #2: ");
			qual2 = scanner.nextLine();
			if (qual2.length() > 25) {
				System.out.println("\nCannot exceed 25 characters.\n");
				continue;
			} else {
				qual2 = qual2.toLowerCase();
				break;
			}
		}
		System.out.println("\nEnter 2 qualities that would be fit for the job (e.g. detail-oriented, communicative): ");
		while (true) {
			System.out.print("Personal Quality #1: ");
			persQual1 = scanner.nextLine().toLowerCase();
			if (persQual1.length() > 25) {
				System.out.println("\nCannot exceed 25 characters.\n");
				continue;
			} else {
				persQual1 = persQual1.toLowerCase();
				break;
			}
		}
		while (true) {
			System.out.print("Personal Quality #2: ");
			persQual2 = scanner.nextLine().toLowerCase();
			if (persQual2.length() > 25) {
				System.out.println("\nCannot exceed 25 characters.\n");
				continue;
			} else {
				persQual2 = persQual2.toLowerCase();
				break;
			}
		}
		System.out.println("\nEnter 2 of the best skills you can offer for the job (e.g. leadership, organizational): ");
		while (true) {
			System.out.print("Skill #1: ");
			skill1 = scanner.nextLine().toLowerCase();
			if (skill1.length() > 25) {
				System.out.println("\nCannot exceed 25 characters.\n");
				continue;
			} else {
				skill1 = skill1.toLowerCase();
				break;
			}
		}
		while (true) {
			System.out.print("Skill #2: ");
			skill2 = scanner.nextLine().toLowerCase();
			if (skill2.length() > 25) {
				System.out.println("\nCannot exceed 25 characters.\n");
				continue;
			} else {
				skill2 = skill2.toLowerCase();
				break;
			}
		}
		while (true) {
			System.out.println("\nEnter 1 more useful skill in short sentence form (e.g. can work in a fast-paced environment/have strong work ethic, etc.)");
			System.out.println("Character count scale (50 char. max):");
			getCharacterCountScale(1, 50, 0);
			skill3 = scanner.nextLine();
			if (skill3.length() > 50) {
				System.out.println("\nCannot exceed 50 characters.");
				continue;
			} else {
				break;
			}
		}
		
		String summaryTemp; // temp = template
		
		if (inHighSchool.isBlank() && isSenior == true) { // Assembles user input into template
			summaryTemp = qual1 + ", " + qual2 + " senior student who is seeking to acquire a position that enables use of strong " + skill1 + " and " + skill2 + " skills. I am " + persQual1 + ", " + persQual2 + ", and " + skill3 + ".";
		} else if (isSenior == true){
			summaryTemp = qual1 + ", " + qual2 + " senior student at " + inHighSchool + " who is seeking to acquire a position that enables use of strong " + skill1 + " and " + skill2 + " skills. I am " + persQual1 + ", " + persQual2 + ", and " + skill3 + ".";
		} else if (inHighSchool.isBlank() && isSenior == false) {
			summaryTemp = qual1 + ", " + qual2 + " student who is seeking to acquire a position that enables use of strong " + skill1 + " and " + skill2 + " skills. I am " + persQual1 + ", " + persQual2 + ", and " + skill3 + ".";
		} else {
			summaryTemp = qual1 + ", " + qual2 + " student at " + inHighSchool + " who is seeking to acquire a position that enables use of strong " + skill1 + " and " + skill2 + " skills. I am " + persQual1 + ", " + persQual2 + ", and " + skill3 + ".";
		}
		
		StringBuilder summaryTempAssemb = new StringBuilder();
		char[] summaryTempArr = summaryTemp.toCharArray(); // Converts String to char array to count # of characters
		for (int j = 0; j < summaryTemp.length(); j++) {
			if (j > 0 && j % 75 == 0) {
				if (summaryTempArr[j] == 32 || summaryTempArr[j] == 46 || summaryTempArr[j] == 44) { // Only adds line break (no hyphen) if previous character contains space, period or comma
					summaryTempAssemb.append("\n"); // Adds line break after character limit of 75 has been reached
				} else {
					if (summaryTempArr[j-1] == 32 || summaryTempArr[j-1] == 46 || summaryTempArr[j-1] == 44) { // If index in char array contains specified characters, adds hyphen and line break
						summaryTempAssemb.append("\n");
					} else {
						summaryTempAssemb.append("-\n"); // Adds hyphen and line break if no near index contains specified characters
					}
				}
			}
			summaryTempAssemb.append(summaryTemp.charAt(j)); // Adds individual characters of line-broken summary template to StringBuilder
		}
		summaryTemp = summaryTempAssemb.toString();
		String[] summaryTempLine = summaryTemp.split("\n"); // Splits summary template by line breaks
		
		categoryArray[i] = new Summary[summaryTempLine.length]; // Adds lines to summary object
		
		StringBuilder assemblingCateg = new StringBuilder();
		assemblingCateg.append("\n│    Summary                                                                         │");
		assemblingCateg.append("\n│    ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––    │");
		for (int j = 0; j < categoryArray[i].length; j++) { // Adds category name and following border
			categoryArray[i][j] = new Summary("Summary", summaryTempLine[j]);
			String linePre = "│    " + summaryTempLine[j];
			StringBuilder assemblingLine = new StringBuilder();
			assemblingLine.append("│    ");
			assemblingLine.append(summaryTempLine[j]);
			int lineDiff = 86 - linePre.length(); // 86 = width of resume
			for (int k = 0; k < lineDiff - 1; k++) {
				assemblingLine.append(" ");
				// Add spaces - then, when k = lineDiff - 1, add vertical line
			}
			assemblingLine.append("│");
			String assembledLine = assemblingLine.toString();
			// For as many spaces between the line's length and 86 (difference), adds just as many spaces - 1. Then, adds long vertical line character.
			categoryArray[i][j].setLine(assembledLine);
			assemblingCateg.append("\n" + categoryArray[i][j].getLine());
		}
		assemblingCateg.append("\n│                                                                                    │");
		assemblingCateg.append("\n│                                                                                    │");
		resumeInProgress = resumeInProgress + assemblingCateg.toString(); // Adds formatted information and 2 extra borders, then sets resume as StringBuilder's assembled String
		
		return resumeInProgress;
    }
    
    /*
    *  Pre: Receives number of categories added so far, scanner object, 2D category array storing all category subclasses as well as String containing resume
    *  Post: Returns resume with added education category
    *  Description: User answers prompts and questions to create and add education category to resume
    */
    public static String categEducation(int i, Scanner scanner, Category[][] categoryArray, String resumeInProgress) {
    	String inHighSchool, yearBegin, yearEnd, diploma;
    	boolean isHonourRoll = false;
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        System.out.println("CATEGORY " + (i+1) + ": EDUCATION");
        while (true) {
        	System.out.print("\nEnter name of high school (e.g. Miller Grove High School): "); // User cannot enter high school with more than 50 characters in name
            inHighSchool = scanner.nextLine();
            if (inHighSchool.length() > 50) {
            	System.out.println("\nCannot exceed 50 characters.");
            	continue;
            } else {
            	break;
            }
        }
        while (true) {
            System.out.print("\nWhat year did you begin high school (e.g. 2019): ");
            yearBegin = scanner.nextLine();
            if (!(yearBegin.contains("1")) && !(yearBegin.contains("2")) && !(yearBegin.contains("3")) && !(yearBegin.contains("4")) && !(yearBegin.contains("5")) && !(yearBegin.contains("6")) && !(yearBegin.contains("7")) && !(yearBegin.contains("8")) && !(yearBegin.contains("9")) && !(yearBegin.contains("0"))) {
            	System.out.println("\nMust enter a year."); // Year input must contain a number
            	continue;
            } else {
            	break;
            }
        }
        while (true) {
        	System.out.print("\nWhat year did/will you graduate (e.g. 2023): ");
            yearEnd = scanner.nextLine();
            if (!(yearEnd.contains("1")) && !(yearEnd.contains("2")) && !(yearEnd.contains("3")) && !(yearEnd.contains("4")) && !(yearEnd.contains("5")) && !(yearEnd.contains("6")) && !(yearEnd.contains("7")) && !(yearEnd.contains("8")) && !(yearEnd.contains("9")) && !(yearEnd.contains("0"))) {
            	System.out.println("\nMust enter a year.");
            	continue;
            } else {
            	break;
            }
        }
        while (true) {
            System.out.print("\nWhat is the name of your areas's official high school diploma (e.g. Ontario Secondary School Diploma)? ");
            diploma = scanner.nextLine();
            if (diploma.length() > 50) {
            	System.out.println("\nCannot exceed 50 characters.");
            	continue;
            } else {
            	break;
            }
        }
        System.out.print("\nWould you like to mention if you're an honours student (Y/N)? ");
        isHonourRoll = false;
        String inHonourRoll = scanner.nextLine();
        if (inHonourRoll.contains("Yes") || inHonourRoll.contains("yes") || inHonourRoll.equals("Y") || inHonourRoll.equals("y")) {
        	isHonourRoll = true;
        }
        
        String hsYear = inHighSchool + "," + yearBegin + "-" + yearEnd; // Creates String to be split, containing info to be put into header
		
		hsYear.split(",");
		StringBuilder eduHeader = new StringBuilder();
		eduHeader.append("│    " + inHighSchool);
		for (int j = inHighSchool.length() + 5; j <= 80 - yearBegin.length() - yearEnd.length() - 1; j++) {
			eduHeader.append(" "); // Formats years to be placed directly before edge of category border in resume
		}
		eduHeader.append(yearBegin + "-" + yearEnd);
		for (int j = 0; j < 4; j++) {
			eduHeader.append(" ");
		}
		eduHeader.append("│"); // Closes off edge of resume with spaces and border
		String eduHeaderStr = eduHeader.toString();
		
		String eduTemp;
		
		if (isHonourRoll == false) {
			eduTemp = "Currently enrolled at " + inHighSchool + ", aiming for " + diploma + " completion.";
		} else {
			eduTemp = "Honours student enrolled at " + inHighSchool + ", aiming for " + diploma + " completion.";
		}
		
		StringBuilder eduTempAssemb = new StringBuilder();
		char[] eduTempArray = eduTemp.toCharArray();
		for (int j = 0; j < eduTemp.length(); j++) {
			if (j > 0 && j % 75 == 0) {
				if (eduTempArray[j] == 32 || eduTempArray[j] == 46 || eduTempArray[j] == 44) {
					eduTempAssemb.append("\n"); // Same line-splitting logic as explained above
				} else {
					if (eduTempArray[j-1] == 32 || eduTempArray[j-1] == 46 || eduTempArray[j-1] == 44) {
						eduTempAssemb.append("\n");
					} else {
						eduTempAssemb.append("-\n");
					}
				}
			}
			eduTempAssemb.append(eduTemp.charAt(j));
		}
		eduTemp = eduTempAssemb.toString();
		
		String[] eduTempLine = eduTemp.split("\n");
		
		categoryArray[i] = new Education[eduTempLine.length + 1];
		
		StringBuilder assemblingCateg = new StringBuilder();
		assemblingCateg.append("\n│    Education                                                                       │");
		assemblingCateg.append("\n│    ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––    │");
		categoryArray[i][0] = new Education("Education", eduHeaderStr);
		categoryArray[i][0].setLine(eduHeaderStr);
		assemblingCateg.append("\n" + categoryArray[i][0].getLine()); // Adds header of education category (header follows category line)
		for (int j = 1; j < categoryArray[i].length; j++) {
			categoryArray[i][j] = new Education("Education", eduTempLine[j-1]);
			String linePre = "│    " + eduTempLine[j-1];
			StringBuilder assemblingLine = new StringBuilder();
			assemblingLine.append("│    ");
			assemblingLine.append(eduTempLine[j-1]);
			int lineDiff = 86 - linePre.length();
			for (int k = 0; k < lineDiff - 1; k++) {
				assemblingLine.append(" ");
			}
			assemblingLine.append("│");
			String assembledLine = assemblingLine.toString();
			categoryArray[i][j].setLine(assembledLine);
			assemblingCateg.append("\n" + categoryArray[i][j].getLine()); // Adds all lines in education category to resume
		}
		assemblingCateg.append("\n│                                                                                    │");
		assemblingCateg.append("\n│                                                                                    │");
		resumeInProgress = resumeInProgress + assemblingCateg.toString();	
		return resumeInProgress;
    }
    
    /*
    *  Pre: Receives number of categories added so far, scanner object as well as String containing resume
    *  Post: Returns resume with added skills category
    *  Description: User specifies how many skill entries they would like to add, and adds skills category to resume
    */
    public static String categSkills(int i, Scanner scanner, String resumeInProgress) {
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        System.out.println("CATEGORY " + (i+1) + ": SKILLS");
        int skillCount;
        String skillCountStr;
        while (true) {
        	System.out.print("\nHow many skills will you be entering? (1-6): ");
            skillCountStr = scanner.nextLine();
            if (!(skillCountStr.equals("1")) && !(skillCountStr.equals("2")) && !(skillCountStr.equals("3")) && !(skillCountStr.equals("4")) && !(skillCountStr.equals("5")) && !(skillCountStr.equals("6"))) {
            	System.out.println("\nInvalid input."); // User must enter a number between 1 and 6 inclusive
            	continue;
            } else {
            	skillCount = Integer.valueOf(skillCountStr);
                break;
            }
        }
        StringBuilder skillTBsplit = new StringBuilder();
        if (skillCount <= 3 && skillCount > 0) {
        	System.out.println("\nEnter the top " + skillCount + " skills you can offer for the job.\n(E.g. Can work effectively independently/Demonstrates strong time management skills by balancing extracurricular work with school work, etc.)\n");
            for (int j = 0; j < skillCount; j++) {
            	System.out.print("Enter skill #" + (j+1));
            	if (j == 0) {
            		System.out.print(" (this should be your most valuable skill):\n∙ ");
            	} else {
            		System.out.print(":\n∙ ");
            	}
            	String inSkill = scanner.nextLine();
            	inSkill = "∙ " + inSkill; // Adds hyphen dot before inputted skill
            	if (j == skillCount - 1) {
            		skillTBsplit.append(inSkill); // Does not add ✗ if skill is last one entered (skills will be split using ✗)
            	} else {
            		skillTBsplit.append(inSkill + "✗");
            	}
            }
        }
        if (skillCount > 3 && skillCount < 7) {
        	System.out.println("\nEnter the best skills you can offer for the job.\n(E.g. Can work effectively independently/Demonstrates strong time management skills by balancing extracurricular work with school work, etc.)\n");
            for (int j = 0; j < skillCount; j++) {
            	System.out.print("Enter skill #" + (j+1) + ": ");
            	String inSkill = scanner.nextLine();
            	inSkill = "∙ " + inSkill;
            	if (j == skillCount - 1) {
            		skillTBsplit.append(inSkill);
            	} else {
            		skillTBsplit.append(inSkill + "✗");
            	}
            }
        }
        String skillSplit = skillTBsplit.toString(); // Converts mashed skills marked with ✗'s to String
        String[] skillPt = skillSplit.split("✗"); // Splits String containing skills, with '✗' serving as regex
		StringBuilder assemblingCateg = new StringBuilder();
		assemblingCateg.append("\n│    Skills                                                                          │");
		assemblingCateg.append("\n│    ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––    │");
		for (int j = 0; j < skillPt.length; j++) {
			StringBuilder skillAssemb = new StringBuilder();
			char[] skillPtArray = skillPt[j].toCharArray();
			for (int k = 0; k < skillPt[j].length(); k++) {
				if (k > 0 && k % 73 == 0) {
					if (skillPtArray[k] == 32 || skillPtArray[k] == 46 || skillPtArray[k] == 44) {
						skillAssemb.append("\n"); // Same character limit-oriented line break logic
					} else {
						if (skillPtArray[k-1] == 32 || skillPtArray[k-1] == 46 || skillPtArray[k-1] == 44) {
							skillAssemb.append("\n");
						} else {
							skillAssemb.append("-\n");
						}
					}
				}
				skillAssemb.append(skillPt[j].charAt(k));
			}
			skillPt[j] = skillAssemb.toString();
		}
		String[][] skillPtLine = new String[skillPt.length][30]; // 2 line types; line with hyphen dot and line without - a 2D array can effectively store multiple entries (row) with different line types for each (column)
		for (int j = 0; j < skillPtLine.length; j++) {
			for (int k = 0; k < skillPtLine[j].length; k++) {
				skillPtLine[j] = skillPt[j].split("\n"); // Stores single entry split by line into row index
			}
		}
		for (int j = 0; j < skillPtLine.length; j++) {
			for (int k = 0; k < skillPtLine[j].length; k++) {
				if (skillPtLine[j][k].contains("∙ ")) { // If entry line contains hyphen dot, add less spaces before entry than if there were none (improves formatting look)
					assemblingCateg.append("\n│    ");
					assemblingCateg.append(skillPtLine[j][k]);
					for (int l = skillPtLine[j][k].length() + 5; l < 85; l++) {
						assemblingCateg.append(" ");
					}
					assemblingCateg.append("│"); // Reminder: vertical line = resume border, space = space between info and border
				} else { // Adds more spaces before entry
					assemblingCateg.append("\n│");
					for (int l = 0; l < 6; l++) {
						assemblingCateg.append(" ");
					}
					assemblingCateg.append(skillPtLine[j][k]);
					for (int l = skillPtLine[j][k].length() + 7; l < 85; l++) {
						assemblingCateg.append(" ");
					}
					assemblingCateg.append("│");
				}
			}
		}
		assemblingCateg.append("\n│                                                                                    │"); // Adds two extra empty resume lines for each category so that it is all spaced 2 lines apart from each other
		assemblingCateg.append("\n│                                                                                    │");
		resumeInProgress = resumeInProgress + assemblingCateg.toString();
		return resumeInProgress;
    }
    
    /*
    *  Pre: Receives number of categories added so far, scanner object as well as String containing resume
    *  Post: Returns resume with added highlights category
    *  Description: User enters short qualities about themselves, and adds highlights category to resume
    */
    public static String categHighlights(int i, Scanner scanner, String resumeInProgress) {
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
    	StringBuilder highlights = new StringBuilder();
        System.out.println("CATEGORY " + (i+1) + ": HIGHLIGHTS");
        System.out.println("\nEnter 6 of your best qualities (e.g. Committed/Fast learner/Stays composed under pressure)\n"); // User cannot enter high school with more than 50 characters in name
        System.out.println("Character count scale (35 char. max):");
        for (int j = 0; j < 6; j++) {
        	System.out.println("\nQuality " + (j+1) + ":");
        	getCharacterCountScale(0, 35, 0);
        	String inHighlight = scanner.nextLine();
        	if (inHighlight.length() > 35) {
        		System.out.println("\nCannot exceed 35 characters.");
        		j--;
        		continue;
        	}
        	inHighlight = "∙ " + inHighlight; // Adds hyphen dot before each highlight entry
        	highlights.append(inHighlight);
        	if (j != 5) {
        		highlights.append("✗"); // Every highlight entry is added onto a single line, which will then be split into multiple lines using ✗
        	}
        }
        String highlightsTemp = highlights.toString();
		String[] splitHL = highlightsTemp.split("✗");
		StringBuilder lineAssemb = new StringBuilder();
		for (int j = 0; j < splitHL.length; j = j + 2) { // For as many indices before the number of highlight lines (6), adds 2 entries per line, then increments counter by 2
			int kCount = 0;
			lineAssemb.append("\n│    ");
			lineAssemb.append(splitHL[j]);
			for (int k = splitHL[j].length() + 5; k < 44; k++) {
				lineAssemb.append(" "); // 2 highlights/entries are placed on each line
				kCount++;
			}
			lineAssemb.append(splitHL[j+1]);
			for (int k = 5 + splitHL[j].length() + kCount + splitHL[j+1].length(); k < 85; k++) {
				lineAssemb.append(" ");
			}
			lineAssemb.append("│");
			// Adds resume border and beginning spaces, then adds first highlight. For as many spaces left before 38, adds spaces
			// Adds second highlight, and for as many spaces left before 85, adds spaces, then adds border
		}
		String tempHL = lineAssemb.toString();
		StringBuilder assemblingCateg = new StringBuilder();
		assemblingCateg.append("\n│    Highlights                                                                      │");
		assemblingCateg.append("\n│    ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––    │");
		assemblingCateg.append(tempHL);
		assemblingCateg.append("\n│                                                                                    │");
		assemblingCateg.append("\n│                                                                                    │");
		resumeInProgress = resumeInProgress + assemblingCateg.toString();
		return resumeInProgress;
    }
    
    /*
    *  Pre: Receives number of categories added so far, scanner object as well as String containing resume
    *  Post: Returns resume with added specified-type-of-experience category
    *  Description: User answers prompts and questions to create and add specified-type-of-experience category to resume
    */
    public static String categExperience(int i, Scanner scanner, String resumeInProgress) {
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
    	StringBuilder assemblingCateg = new StringBuilder();
        StringBuilder categSorted = new StringBuilder(); // 2 StringBuilders: 1 for category unsorted and 1 for sorted category using insertion sort
    	String expType = "";
    	while (true) { // User specifies what type of experience they will be entering
    		System.out.println("[1] - Work Experience"
		 				   + "\n[2] - Volunteer Experience"
		 				   + "\n[3] - Relevant Experience"
		 				   + "\n[4] - Experience");
		 	System.out.print("What type of experience will you enter? ");
		 	int expChoice = scanner.nextInt();
		 	scanner.nextLine();
		 	if (expChoice == 1) {
		 		expType = "Work ";
		 		assemblingCateg.append("\n│    Work Experience                                                                 │");
		        categSorted.append("\n│    Work Experience                                                                 │");
		 		break;
		 	} else if (expChoice == 2) {
		 		expType = "Volunteer ";
		 		assemblingCateg.append("\n│    Volunteer Experience                                                            │");
		 		categSorted.append("\n│    Volunteer Experience                                                            │");
		 		break;
		 	} else if (expChoice == 3) {
		 		expType = "Relevant ";
		 		assemblingCateg.append("\n│    Relevant Experience                                                             │");
		 		categSorted.append("\n│    Relevant Experience                                                             │");
		 		break;
		 	} else if (expChoice == 4) {
		 		assemblingCateg.append("\n│    Experience                                                                      │");
		 		categSorted.append("\n│    Experience                                                                      │");
		 		break;
		 	} else {
		 	}
    	}
        categSorted.append("\n│    ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––    │");
    	assemblingCateg.append("\n│    ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––    │");
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––"); // Adds category line after specified category name is added into resume
    	int entryCount;
    	String entryCountStr;
    	while (true) {
    		System.out.print("How many entries will you make? (1-5) ");
        	entryCountStr = scanner.nextLine();
        	if (!(entryCountStr.equals("1")) && !(entryCountStr.equals("2")) && !(entryCountStr.equals("3")) && !(entryCountStr.equals("4")) && !(entryCountStr.equals("5"))) {
        		System.out.println("\nInvalid input.\n");
        	} else {
        		entryCount = Integer.valueOf(entryCountStr);
        		break;
        	}
    	}
    	Experience[] expArray = new Experience[entryCount];
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        System.out.println("CATEGORY " + (i+1) + ": " + expType.toUpperCase() + "EXERIENCE");
        for (int j = 0; j < entryCount; j++) {
        	StringBuilder expTBsplit = new StringBuilder();
        	Experience exp = new Experience();
        	boolean currentlyWorking = false;
        	String yearBegin = "", yearEnd = "";
	        System.out.println("\nEntry #" + (j+1) + ":");
	        System.out.print("\nEnter organization name (e.g. Lacoste): ");
	        String inCompany = scanner.nextLine();
	        System.out.print("\nAre you currently working/volunteering at the company (Y/N)? ");
	        String workConf = scanner.nextLine();
	        if (workConf.contains("Yes") || workConf.contains("yes") || workConf.equals("Y") || workConf.contains("y")) {
	        	currentlyWorking = true;
	        	exp.setCurrentlyWorking(true);
	        } else {
	        }
	        if (currentlyWorking == true) { // Only asks user to enter year they started working if they are still working
	        	while (true) {
	        		System.out.print("\nWhat year did you start working/volunteering at this organization (e.g. 2020)? ");
		        	yearBegin = scanner.nextLine();
		        	if (yearBegin.isBlank()) {
		        		System.out.println("\nCannot leave entry blank.");
		        		continue;
		        	} else if (!(yearBegin.contains("1")) && !(yearBegin.contains("2")) && !(yearBegin.contains("3")) && !(yearBegin.contains("4")) && !(yearBegin.contains("5")) && !(yearBegin.contains("6")) && !(yearBegin.contains("7")) && !(yearBegin.contains("8")) && !(yearBegin.contains("9")) && !(yearBegin.contains("0"))) {
		        		System.out.println("\nMust enter a year.");
		        		continue;
		        	} else {
		        		break;
		        	}
	        	}
	        	exp.setYearBegin(yearBegin);
	        	yearEnd = exp.getYearEnd();
	        } else {
	        	while (true) {
	        		System.out.print("\nWhat year did you start working/volunteering at this organization (e.g. 2020)? ");
		        	yearBegin = scanner.nextLine();
		        	if (yearBegin.isBlank()) {
		        		System.out.println("\nCannot leave entry blank.");
		        		continue;
		        	} else if (!(yearBegin.contains("1")) && !(yearBegin.contains("2")) && !(yearBegin.contains("3")) && !(yearBegin.contains("4")) && !(yearBegin.contains("5")) && !(yearBegin.contains("6")) && !(yearBegin.contains("7")) && !(yearBegin.contains("8")) && !(yearBegin.contains("9")) && !(yearBegin.contains("0"))) {
		        		System.out.println("\nMust enter a year.");
		        		continue;
		        	} else {
		        		break;
		        	}
	        	}
	        	System.out.print("\nWhat year did you stop working/volunteering at this organization (e.g. 2022)? ");
	        	yearEnd = scanner.nextLine();
	        	if (yearEnd.isBlank() || (!(yearEnd.contains("1")) && !(yearEnd.contains("2")) && !(yearEnd.contains("3")) && !(yearEnd.contains("4")) && !(yearEnd.contains("5")) && !(yearEnd.contains("6")) && !(yearEnd.contains("7")) && !(yearEnd.contains("8")) && !(yearEnd.contains("9")) && !(yearEnd.contains("0")))) {
	        		yearEnd = yearBegin;
	        	} // If year the user stopped working is the same as the year start/is blank, enters the year ended the same as the year started
	        	exp.setYearBegin(yearBegin);
	        	exp.setYearEnd(yearEnd);
	        	exp.setYear(Integer.valueOf(yearEnd)); // Sets experience object's info according to user input
	        }
	        System.out.print("\nEnter address you worked/volunteered at (e.g. 123 Placeholder Blvd): ");
	        String inAddress = scanner.nextLine();
	        System.out.print("\nEnter position you worked/volunteered as (e.g. Sales Associate): ");
	        String inPos = scanner.nextLine();
	        exp.setTitleAndYearHeader(inPos, yearBegin, yearEnd);
	        exp.setCompanyAndAddressHeader(inCompany, inAddress); // Methods in experience object organize all user-inputted info into formatted borders
	        int descNoPts = 0;
	        while (true) {
	        	System.out.print("\nEnter # of bullet points you will use for description (1-5): ");
	        	descNoPts = scanner.nextInt();
	        	if (descNoPts < 1 || descNoPts > 5) {
	        		continue;
	        	} else {
	        		break;
	        	}
	        }
	        scanner.nextLine();
	        // Formatting description into bullet point form
            for (int k = 0; k < descNoPts; k++) {
            	System.out.print("\nEnter bullet pt. #" + (k+1) + " of description:\n∙ ");
            	String descPt = scanner.nextLine();
            	descPt = "∙ " + descPt;
            	if (k == descNoPts - 1) {
            		expTBsplit.append(descPt);
            	} else {
            		expTBsplit.append(descPt + "✗");
            	}
            }
            String skillSplit = expTBsplit.toString(); // Converts mashed skills marked with ✗'s to String
            String[] skillPt = skillSplit.split("✗"); // Splits String containing skills, with '✗' serving as the character used to split
    		StringBuilder assemblingLine = new StringBuilder();
    		for (int l = 0; l < skillPt.length; l++) {
    			StringBuilder skillAssemb = new StringBuilder();
    			char[] skillPtArray = skillPt[l].toCharArray();
    			for (int k = 0; k < skillPt[l].length(); k++) {
    				if (k > 0 && k % 73 == 0) {
    					if (skillPtArray[k] == 32 || skillPtArray[k] == 46 || skillPtArray[k] == 44) {
    						skillAssemb.append("\n"); // Same character limit-oriented line break logic
    					} else {
    						if (skillPtArray[k-1] == 32 || skillPtArray[k-1] == 46 || skillPtArray[k-1] == 44) {
    							skillAssemb.append("\n");
    						} else {
    							skillAssemb.append("-\n");
    						}
    					}
    				}
    				skillAssemb.append(skillPt[l].charAt(k));
    			}
    			skillPt[l] = skillAssemb.toString();
    		}
    		String[][] skillPtLine = new String[skillPt.length][30];
    		for (int l = 0; l < skillPtLine.length; l++) {
    			for (int k = 0; k < skillPtLine[l].length; k++) {
    				skillPtLine[l] = skillPt[l].split("\n");
    			}
    		}
    		for (int l = 0; l < skillPtLine.length; l++) {
    			for (int k = 0; k < skillPtLine[l].length; k++) {
    				if (skillPtLine[l][k].contains("∙ ")) {
    					assemblingLine.append("\n│    ");
    					assemblingLine.append(skillPtLine[l][k]);
    					for (int m = skillPtLine[l][k].length() + 5; m < 85; m++) {
    						assemblingLine.append(" ");
    					}
    					assemblingLine.append("│");
    				} else {
    					assemblingLine.append("\n│");
    					for (int m = 0; m < 6; m++) {
    						assemblingLine.append(" ");
    					}
    					assemblingLine.append(skillPtLine[l][k]);
    					for (int m = skillPtLine[l][k].length() + 7; m < 85; m++) {
    						assemblingLine.append(" ");
    					}
    					assemblingLine.append("│");
    				}
    			}
    		}
    		exp.setLine(assemblingLine.toString());
	        expArray[j] = exp; // Occupies experience array with experience object with latest entry
	        assemblingCateg.append(expArray[j]);
	        System.out.println("\nHere's what you've got so far:\n" + "\n│                                                                                    │" + assemblingCateg.toString());
        }
		// When displaying category, object displays titleAndYearHeader first, then companyAndAddress header
		// Line break exists between entries
		// Adds experience objects to queue
		// After for loop is over and all entries have been filled, outside of for loop, asks user if they would like to sort
		// their entries by year reverse-chronologically
        assemblingCateg.append("\n│                                                                                    │");
        if (entryCount > 1) {
        	System.out.print("\nRECOMMENDED: Would you like to sort your entries in order of most recently done (Y/N)? ");
        	String sortConf = scanner.nextLine();
        	if (sortConf.contains("yes") || sortConf.contains("Yes") || sortConf.equals("Y") || sortConf.equals("y")) {
        		insertionSort(expArray); // Insertion sort is used to sort each entry by year in descending order
        		for (int j = 0; j < entryCount; j++) {
        			categSorted.append(expArray[j]);
        		}
        		categSorted.append("\n│                                                                                    │");
        		return resumeInProgress + categSorted.toString();
        	}
        }
		return resumeInProgress + assemblingCateg.toString();
    }
    
    /*
    *  Pre: Receives number of categories added so far, scanner object as well as String containing resume
    *  Post: Returns resume with added 'other interests' category
    *  Description: User enters information into prompts to create and add 'other interests' category
    */
    public static String categInterests(int i, Scanner scanner, String resumeInProgress) {
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
    	StringBuilder interestTBsplit = new StringBuilder();
        System.out.println("CATEGORY " + (i+1) + ": OTHER INTERESTS");
        System.out.print("\nHow many entries will you make? ");
        int noOfInt = scanner.nextInt();
        scanner.nextLine();
        String intName, intDesc = ""; // Note: int = interest
        for (int j = 0; j < noOfInt; j++) {
        	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        	System.out.println("Interest #" + (j+1) + ":");
            System.out.print("\nEnter main heading (i.e. hobby/company/program name, etc.): ");
            intName = scanner.nextLine();
            if (intName.isBlank()) {
            	System.out.println("\nCannot leave heading blank.");
            	j--; // Counter decrements with invalid input to ensure for loop doesn't progress
            	continue;
            }
            intName = "∙ " + intName;
            interestTBsplit.append(intName);
            System.out.println("\nEnter a brief description. (Leave blank if you prefer not to include.)");
            System.out.println("Character count scale (175 char. max):");
            while (true) {
            	getCharacterCountScale(1, 175, 0);
                intDesc = scanner.nextLine();
                if (intDesc.length() > 175) {
                	System.out.println("\nDescription cannot exceed 175 characters.\n");
                	continue;
                } else {
                	break;
                }
            }
            if (intDesc.isBlank()) {
            	interestTBsplit.append("✗"); // Unicode indicates that the entry is complete and is ready to be combined with other entries
            } else {
                intDesc = ": " + intDesc; // Colon added before description to make formatting simpler
            	if (j == noOfInt - 1) {
            		interestTBsplit.append(intDesc);
            	} else {
            		interestTBsplit.append(intDesc + "✗");
            	}
            }
        }
        String intSplit = interestTBsplit.toString();
        String[] intPt = intSplit.split("✗"); // Reminder: Splits by unicode, and adds line break if necessary to each split component
		StringBuilder assemblingCateg = new StringBuilder();
		assemblingCateg.append("\n│    Other Interests                                                                 │");
		assemblingCateg.append("\n│    ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––    │");
		for (int j = 0; j < intPt.length; j++) {
			StringBuilder intAssemb = new StringBuilder();
			char[] intPtArray = intPt[j].toCharArray();
			for (int k = 0; k < intPt[j].length(); k++) {
				if (k > 0 && k % 73 == 0) {
					if (intPtArray[k] == 32 || intPtArray[k] == 46 || intPtArray[k] == 44) {
						intAssemb.append("\n"); // Same character limit-oriented line break logic
					} else {
						if (intPtArray[k-1] == 32 || intPtArray[k-1] == 46 || intPtArray[k-1] == 44) {
							intAssemb.append("\n");
						} else {
							intAssemb.append("-\n");
						}
					}
				}
				intAssemb.append(intPt[j].charAt(k));
			}
			intPt[j] = intAssemb.toString();
		}
		String[][] intPtLine = new String[intPt.length][30];
		for (int j = 0; j < intPtLine.length; j++) {
			for (int k = 0; k < intPtLine[j].length; k++) {
				intPtLine[j] = intPt[j].split("\n");
			}
		}
		for (int j = 0; j < intPtLine.length; j++) {
			for (int k = 0; k < intPtLine[j].length; k++) {
				if (intPtLine[j][k].contains("∙ ")) { // Same formatting logic as skills category
					assemblingCateg.append("\n│    ");
					assemblingCateg.append(intPtLine[j][k]);
					for (int l = intPtLine[j][k].length() + 5; l < 85; l++) {
						assemblingCateg.append(" ");
					}
					assemblingCateg.append("│");
				} else {
					assemblingCateg.append("\n│");
					for (int l = 0; l < 6; l++) {
						assemblingCateg.append(" ");
					}
					assemblingCateg.append(intPtLine[j][k]);
					for (int l = intPtLine[j][k].length() + 7; l < 85; l++) {
						assemblingCateg.append(" ");
					}
					assemblingCateg.append("│");
				}
			}
		}
		assemblingCateg.append("\n│                                                                                    │");
		assemblingCateg.append("\n│                                                                                    │");
		resumeInProgress = resumeInProgress + assemblingCateg.toString();
		return resumeInProgress;
    }
    
    /*
    *  Pre: Receives number of categories added so far, scanner object as well as String containing resume
    *  Post: Returns resume with added competitions category
    *  Description: User enters information into prompts to create and add competitions category
    */
    public static String categCompetitions(int i, Scanner scanner, String resumeInProgress) {
    	// Follows virtually the same code logic as the other interests category
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
    	StringBuilder compTBsplit = new StringBuilder();
        System.out.println("CATEGORY " + (i+1) + ": COMPETITONS");
        System.out.print("\nHow many competitions would you like to enter? ");
        int noOfComp = scanner.nextInt();
        scanner.nextLine();
        String contestName, contestYear, contestDesc = "";
        for (int j = 0; j < noOfComp; j++) {
        	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        	System.out.println("Competition #" + (j+1) + ":");
        	System.out.print("\nEnter name of competition: ");
        	contestName = scanner.nextLine();
        	if (contestName.isBlank()) {
            	System.out.println("\nCannot leave competition name blank.");
            	j--;
            	continue;
            }
        	while (true) {
        		System.out.print("\nEnter the year you participated: ");
        		contestYear = scanner.nextLine();
        		if (contestYear.isBlank()) {
                	System.out.println("\nCannot leave competition year blank.");
                	j--;
                	continue;
                } else {
                	break;
                }
        	}
        	contestName = "∙ " + contestName;
        	contestName = contestName + " (" + contestYear + ")"; // Contest year is added in brackets by contest name
        	compTBsplit.append(contestName);
        	System.out.println("\nEnter a brief description of the competition. (Leave blank if you prefer not to include):");
        	System.out.println("Character count scale (175 char. max):");
        	while (true) {
            	getCharacterCountScale(1, 175, 0);
            	contestDesc = scanner.nextLine();
                if (contestDesc.length() > 175) {
                	System.out.println("\nDescription cannot exceed 175 characters.\n");
                	continue;
                } else {
                	break;
                }
            }
            if (contestDesc.isBlank()) {
            	compTBsplit.append("✗");
            } else {
            	contestDesc = ": " + contestDesc;
            	if (j == noOfComp - 1) {
            		compTBsplit.append(contestDesc);
            	} else {
            		compTBsplit.append(contestDesc + "✗");
            	}
            }
        }
        String compSplit = compTBsplit.toString();
        String[] compPt = compSplit.split("✗");
		StringBuilder assemblingCateg = new StringBuilder();
		assemblingCateg.append("\n│    Competitions                                                                    │");
		assemblingCateg.append("\n│    ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––    │");
		for (int j = 0; j < compPt.length; j++) {
			StringBuilder compAssemb = new StringBuilder();
			char[] compPtArray = compPt[j].toCharArray();
			for (int k = 0; k < compPt[j].length(); k++) {
				if (k > 0 && k % 73 == 0) {
					if (compPtArray[k] == 32 || compPtArray[k] == 46 || compPtArray[k] == 44) {
						compAssemb.append("\n"); // Same character limit-oriented line break logic
					} else {
						if (compPtArray[k-1] == 32 || compPtArray[k-1] == 46 || compPtArray[k-1] == 44) {
							compAssemb.append("\n");
						} else {
							compAssemb.append("-\n");
						}
					}
				}
				compAssemb.append(compPt[j].charAt(k));
			}
			compPt[j] = compAssemb.toString();
		}
		String[][] compPtLine = new String[compPt.length][30];
		for (int j = 0; j < compPtLine.length; j++) {
			for (int k = 0; k < compPtLine[j].length; k++) {
				compPtLine[j] = compPt[j].split("\n");
			}
		}
		for (int j = 0; j < compPtLine.length; j++) {
			for (int k = 0; k < compPtLine[j].length; k++) {
				if (compPtLine[j][k].contains("∙ ")) {
					assemblingCateg.append("\n│    ");
					assemblingCateg.append(compPtLine[j][k]);
					for (int l = compPtLine[j][k].length() + 5; l < 85; l++) {
						assemblingCateg.append(" ");
					}
					assemblingCateg.append("│");
				} else {
					assemblingCateg.append("\n│");
					for (int l = 0; l < 6; l++) {
						assemblingCateg.append(" ");
					}
					assemblingCateg.append(compPtLine[j][k]);
					for (int l = compPtLine[j][k].length() + 7; l < 85; l++) {
						assemblingCateg.append(" ");
					}
					assemblingCateg.append("│");
				}
			}
		}
		assemblingCateg.append("\n│                                                                                    │");
		assemblingCateg.append("\n│                                                                                    │");
		resumeInProgress = resumeInProgress + assemblingCateg.toString();
		return resumeInProgress;
    }
    
    /*
    *  Pre: Receives number of categories added so far, scanner object as well as String containing resume
    *  Post: Returns resume with added custom-made category
    *  Description: User is asked how they would like to format their information in order to create and add their own custom-made category
    */
    public static String categCustom(int i, Scanner scanner, String resumeInProgress) {
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
    	StringBuilder assemblingCateg = new StringBuilder();
    	String customName = "";
    	while (true) {
		 	System.out.print("Enter name of custom category: ");
		 	customName = scanner.nextLine();
		 	if (customName.length() > 70) {
		 		System.out.println("\nCategory name cannot exceed 70 characters.\n");
		 	} else {
		 		break;
		 	}
    	}
    	assemblingCateg.append("\n│    " + customName);
    	for (int j = customName.length() + 5; j < 85; j++) {
    		assemblingCateg.append(" ");
    	}
    	assemblingCateg.append("│");
    	assemblingCateg.append("\n│    ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––    │");
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
    	int entryCount;
    	while (true) {
    		System.out.print("How many entries will you make (1-5)? ");
        	entryCount = scanner.nextInt();
        	if (entryCount < 1 || entryCount > 5) {
        		System.out.println("\nYou cannot make " + entryCount + " entries.\n");
        	} else {
        		break;
        	}
    	}
    	scanner.nextLine();
    	Queue q = new Queue(entryCount); // Queue is used to store custom category objects
    	System.out.println("–––––––––––––––––––––––––––––––––––––––––––––––––––––––––––");
        System.out.println("CATEGORY " + (i+1) + ": " + customName.toUpperCase());
        for (int j = 0; j < entryCount; j++) {
        	System.out.println("\nEntry " + (j+1) + "/" + entryCount + ": ");
        	Custom c = new Custom();
        	System.out.println("\nFORMAT OPTIONS");
    		System.out.println("[1] - Blurb" // Allows user to enter whatever they want; formats using %75 method; shows user their progress as well as line count
    						 + "\n[2] - Bulleted list");
			System.out.print("How would you like to format entry #" + (j+1) + "? ");
			int formatChoice = scanner.nextInt();
			scanner.nextLine();
			if (formatChoice == 1) { // User can enter 1 if they would like to format their information in blurb format; follows the same formatting logic as summary category
				System.out.println("\nEnter information:");
				String inBlurb = scanner.nextLine();
				StringBuilder cTempAssemb = new StringBuilder();
				char[] cTempArray = inBlurb.toCharArray();
				for (int k = 0; k < inBlurb.length(); k++) {
					if (k > 0 && k % 75 == 0) {
						// %75 formatting method
						if (cTempArray[k] == 32 || cTempArray[k] == 46 || cTempArray[k] == 44) {
							cTempAssemb.append("\n");
						} else {
							if (cTempArray[k-1] == 32 || cTempArray[k-1] == 46 || cTempArray[k-1] == 44) {
								cTempAssemb.append("\n");
							} else {
								cTempAssemb.append("-\n");
							}
						}
					}
					cTempAssemb.append(inBlurb.charAt(k));
				}
				inBlurb = cTempAssemb.toString();
				StringBuilder assemblingLine = new StringBuilder();
				String[] summaryTempLine = inBlurb.split("\n");
				for (int k = 0; k < summaryTempLine.length; k++) {
					String linePre = "│    " + summaryTempLine[k];
					assemblingLine.append("\n│    ");
					assemblingLine.append(summaryTempLine[k]);
					int lineDiff = 86 - linePre.length();
					for (int l = 0; l < lineDiff - 1; l++) {
						assemblingLine.append(" ");
					}
					assemblingLine.append("│");
				}
				c.setLine(assemblingLine.toString());
				q.enque(c); // Enqueues custom object with formatted user-inputted information
				assemblingCateg.append(q.end()); // Adds element at end of queue (where the newest element is added) to StringBuilder instance; instance will be used to add category to resume String
				if (j != entryCount - 1) {
					System.out.println("\nCustom category so far:\n" + "\n│                                                                                    │" + assemblingCateg.toString() + "\n│                                                                                    │");
				}
			} else if (formatChoice == 2) { // User can enter 2 if they would like to format their information in list format; follows the same formatting logic as skills category
		        StringBuilder cTBsplit = new StringBuilder();
				System.out.print("\nEnter information:\n∙ ");
				String inPoint = scanner.nextLine();
				inPoint = "∙ " + inPoint;
				cTBsplit.append(inPoint);
		        String cSplit = cTBsplit.toString();
		        String[] cPt = cSplit.split("✗"); // Note: Pt = point (for bullet point)
				StringBuilder assemblingBulletPoint = new StringBuilder();
				for (int l = 0; l < cPt.length; l++) {
					StringBuilder cAssemb = new StringBuilder();
					char[] cPtArray = cPt[l].toCharArray();
					for (int k = 0; k < cPt[l].length(); k++) { // Reminder: PtArray only stores each bullet point entered by the user for the custom category
						if (k > 0 && k % 73 == 0) {
							if (cPtArray[k] == 32 || cPtArray[k] == 46 || cPtArray[k] == 44) {
								cAssemb.append("\n");
							} else {
								if (cPtArray[k-1] == 32 || cPtArray[k-1] == 46 || cPtArray[k-1] == 44) {
									cAssemb.append("\n");
								} else {
									cAssemb.append("-\n");
								}
							}
						}
						cAssemb.append(cPt[l].charAt(k));
					}
					cPt[l] = cAssemb.toString();
				}
				String[][] cPtLine = new String[cPt.length][30];
				for (int l = 0; l < cPtLine.length; l++) {
					for (int k = 0; k < cPtLine[l].length; k++) {
						cPtLine[l] = cPt[l].split("\n");
					}
				}
				for (int m = 0; m < cPtLine.length; m++) {
					for (int k = 0; k < cPtLine[m].length; k++) {
						if (cPtLine[m][k].contains("∙ ")) {
							assemblingBulletPoint.append("\n│    ");
							assemblingBulletPoint.append(cPtLine[m][k]);
							for (int l = cPtLine[m][k].length() + 5; l < 85; l++) {
								assemblingBulletPoint.append(" ");
							}
							assemblingBulletPoint.append("│");
						} else {
							assemblingBulletPoint.append("\n│");
							for (int l = 0; l < 6; l++) {
								assemblingBulletPoint.append(" ");
							}
							assemblingBulletPoint.append(cPtLine[m][k]);
							for (int l = cPtLine[m][k].length() + 7; l < 85; l++) {
								assemblingBulletPoint.append(" ");
							}
							assemblingBulletPoint.append("│");
						}
					}
				}
	    		c.setLine(assemblingBulletPoint.toString());
	    		q.enque(c);
	    		assemblingCateg.append(q.end());
	    		if (j != entryCount - 1) {
	    			System.out.println("\nCustom category so far:\n" + "\n│                                                                                    │" + assemblingCateg.toString() + "\n│                                                                                    │");
	    		}
			} else {
				j--;
				continue;
			}
        }
        assemblingCateg.append("\n│                                                                                    │");
        assemblingCateg.append("\n│                                                                                    │");
		return resumeInProgress + assemblingCateg.toString();
    }
}
