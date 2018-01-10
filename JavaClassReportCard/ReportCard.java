import java.util.ArrayList;

public class ReportCard {
	private int numOfSemesters = 0;
	//private ArrayList<Integer> subList = new ArrayList<Integer>();
	int[] subEnglish;
	int[] subHistory;
	int[] subChemistry;
	int[] subPhysics;
	int[] subMaths;

	public ReportCard(int numOfSemesters) {
		this.numOfSemesters = numOfSemesters;
		initializeSubGrades(numOfSemesters);
	}

	private void initializeSubGrades(int numOfSemesters) {
		this.subEnglish = new int[numOfSemesters];
		this.subHistory = new int[numOfSemesters];
		this.subChemistry = new int[numOfSemesters];
		this.subPhysics = new int[numOfSemesters];
		this.subMaths = new int[numOfSemesters];
	}

	// Set subject Grade
	private void setSubGrade(int[] sub, int[] gradeMarks) {
		if (gradeMarks.length == numOfSemesters) {
			for (int i = 0; i < sub.length; i++) {
				sub[i] = gradeMarks[i];
 			}
		}
	}

	// Print Grades
    @Override
    public String toString() {
        String printString = "Final Grades\n";
        for (int i = 0; i < numOfSemesters; i++) {
        	printString += "\nSem " + (i + 1) + "\n";
        	printString += "English : " + subEnglish[i] + "\n";
        	printString += "History : " + subHistory[i] + "\n";
        	printString += "Chemistry : " + subChemistry[i] + "\n";
        	printString += "Physics : " + subPhysics[i] + "\n";
        	printString += "Maths : " + subMaths[i] + "\n";
        }

        return printString;
    }


    // Set number of Semesters
	public void modifyNumOfSemesters(int numOfSemesters) {
		initializeSubGrades(numOfSemesters);
	}

	// English
	public void setSubEnglish(int... args) {
		setSubGrade(subEnglish, args);
	}

	public int[] getSubEnglish() {
		return subEnglish;
	}

	// History
	public void setSubHistory(int... args) {
		setSubGrade(subHistory, args);
	}

	public int[] getSubHistory() {
		return subHistory;
	}

	// Chemistry
	public void setSubChemistry(int... args) {
		setSubGrade(subChemistry, args);
	}

	public int[] getSubChemistry() {
		return subChemistry;
	}

	// Physics	
	public void setSubPhysics(int... args) {
		setSubGrade(subPhysics, args);
	}

	public int[] getSubPhysics() {
		return subPhysics;
	}

	// Maths	
	public void setSubMaths(int... args) {
		setSubGrade(subMaths, args);
	}

	public int[] getSubMaths() {
		return subMaths;
	}
}