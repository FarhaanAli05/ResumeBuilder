# ICS4U Final Project – Resume Builder

This is a Java-based Resume Builder application created for the ICS4U final project. It guides the user through entering resume sections such as education, work experience, skills, and more. The application organizes this data and formats it into a structured resume.

## Demo Video

Watch a full walkthrough of the Resume Builder [here](https://youtu.be/l_4ur4XKv8I).

## Project Report

For a detailed explanation of the program structure, how it works, and answers to reflection questions, check out the final project report:

📘 [ICS4U_FP_Final_Farhaan_Ali.pdf](ICS4U_FP_Final_Farhaan_Ali.pdf)

---

## Required Files

Make sure the following files are in the same folder when running the program:

- `src/` — contains all Java source files
- `Resume Template.txt` — required at runtime for formatting

The PDF (`ICS4U_FP_Final_Farhaan_Ali.pdf`) contains the final project write-up and reflection but is not needed to run the program.

## Features

- Interactive console prompts for easy input
- Add up to **6 different resume sections** (Summary, Education, Experience, Skills, etc.)
- Optional sample content for inspiration
- Custom sections supported
- Resume preview during creation
- Automatic formatting with clean borders and line length limits
- Output saved as a `.txt` file named after the user

### Running the Program

1. Make sure `Resume Template.txt` and the `src/` folder are in the same directory.
2. Open terminal or command prompt in that directory.
3. Compile and run the program:

```bash
javac -d bin src/*.java
java -cp bin ICS4U_FP_Resume_Builder
