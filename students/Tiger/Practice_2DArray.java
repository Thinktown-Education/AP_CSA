public class Practice_2DArray {

	// Each question is represented by one method.

	// Question 1: Return the sum of all elements in a 2D array.
	public static int sumAllElements(int[][] grid) {

	}

	// Question 2: Return the row index with the largest row sum.
	public static int rowWithLargestSum(int[][] grid) {

	}

	// Question 3: Count how many times target appears in the 2D array.
	public static int countOccurrences(int[][] grid, int target) {

	}

	// Question 4: Return a new array rotated 90 degrees clockwise.
	public static int[][] rotateClockwise90(int[][] grid) {

	}

	// Question 5: Given a 2D array named classroom of Student objects,
	// return the array of students in the column with the highest average score.
	public static Student[] highestAverageColumn(Student[][] classroom) {

	}
    
    ///////// Student should only complete code above this line ////////
    ////////////// DO NOT MODIFY ANY CODE BELOW THIS LINE //////////////

	static class Student {
		private String name;
		private int grade;

		public Student(String name, int grade) {
			this.name = name;
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public int getGrade() {
			return grade;
		}
	}

	private static int totalTests = 0;
	private static int passedTests = 0;
	private static int failedTests = 0;

	private static void checkInt(String testName, int expected, int actual) {
		totalTests++;
		if (expected == actual) {
			passedTests++;
		} else {
			failedTests++;
			System.out.println("FAIL: " + testName + " | expected=" + expected + ", actual=" + actual);
		}
	}

	private static void checkMatrix(String testName, int[][] expected, int[][] actual) {
		totalTests++;
		if (java.util.Arrays.deepEquals(expected, actual)) {
			passedTests++;
		} else {
			failedTests++;
			System.out.println("FAIL: " + testName);
			System.out.println("  expected=" + java.util.Arrays.deepToString(expected));
			System.out.println("  actual  =" + java.util.Arrays.deepToString(actual));
		}
	}

	private static void checkStudentArray(String testName, Student[] expected, Student[] actual) {
		totalTests++;
		if (java.util.Arrays.equals(expected, actual)) {
			passedTests++;
		} else {
			failedTests++;
			System.out.println("FAIL: " + testName);
			System.out.println("  expected=" + java.util.Arrays.toString(expected));
			System.out.println("  actual  =" + java.util.Arrays.toString(actual));
		}
	}

	public static void main(String[] args) {
		System.out.println("Running Practice_2DArray tests...\n");

		// Question 1 tests: sumAllElements (3 cases)
		int[][] q1Case1 = {
			{ 1, 2, 3 },
			{ 4, 5, 6 }
		};
		int[][] q1Case2 = {
			{ -1, -2 },
			{ 10, 0 }
		};
		int[][] q1Case3 = {
			{ 5, 5, 5 }
		};
		checkInt("Q1 Case 1 normal", 21, sumAllElements(q1Case1));
		checkInt("Q1 Case 2 with negatives", 7, sumAllElements(q1Case2));
		checkInt("Q1 Case 3 single row", 15, sumAllElements(q1Case3));

		// Question 2 tests: rowWithLargestSum (3 cases)
		int[][] q2Case1 = {
			{ 1, 1, 1 },
			{ 9, 0, 0 },
			{ 2, 2, 2 }
		};
		int[][] q2Case2 = {
			{ 5, 0 },
			{ 2, 3 },
			{ 1, 4 }
		};
		int[][] q2Case3 = {
			{ -3, -4 },
			{ -1, -1 },
			{ -5, -5 }
		};
		checkInt("Q2 Case 1 normal", 1, rowWithLargestSum(q2Case1));
		checkInt("Q2 Case 2 tie uses first row", 0, rowWithLargestSum(q2Case2));
		checkInt("Q2 Case 3 with negatives", 1, rowWithLargestSum(q2Case3));

		// Question 3 tests: countOccurrences (3 cases)
		int[][] q3Case1 = {
			{ 7, 1, 7 },
			{ 2, 7, 3 }
		};
		int[][] q3Case2 = {
			{ 1, 2 },
			{ 3, 4 }
		};
		int[][] q3Case3 = {
			{ 5, 5, 5 },
			{ 1, 5, 2 }
		};
		checkInt("Q3 Case 1 multiple matches", 3, countOccurrences(q3Case1, 7));
		checkInt("Q3 Case 2 no matches", 0, countOccurrences(q3Case2, 9));
		checkInt("Q3 Case 3 many matches", 4, countOccurrences(q3Case3, 5));

		// Question 4 tests: rotateClockwise90 (3 cases)
		int[][] q4Case1 = {
			{ 1, 2, 3 },
			{ 4, 5, 6 }
		};
		int[][] q4Expected1 = {
			{ 4, 1 },
			{ 5, 2 },
			{ 6, 3 }
		};
		int[][] q4Case2 = {
			{ 1, 2 },
			{ 3, 4 }
		};
		int[][] q4Expected2 = {
			{ 3, 1 },
			{ 4, 2 }
		};
		int[][] q4Case3 = {
			{ 9 },
			{ 8 },
			{ 7 }
		};
		int[][] q4Expected3 = {
			{ 7, 8, 9 }
		};
		checkMatrix("Q4 Case 1 rectangular rotate", q4Expected1, rotateClockwise90(q4Case1));
		checkMatrix("Q4 Case 2 square rotate", q4Expected2, rotateClockwise90(q4Case2));
		checkMatrix("Q4 Case 3 single-column rotate", q4Expected3, rotateClockwise90(q4Case3));

		// Question 5 tests: highestAverageColumn (3 cases)
		Student a = new Student("Ava", 70);
		Student b = new Student("Ben", 90);
		Student c = new Student("Cara", 80);
		Student d = new Student("Dan", 60);
		Student e = new Student("Eli", 100);
		Student f = new Student("Fay", 85);
		Student[][] q5Case1 = {
			{ a, b, c },
			{ d, e, f }
		};
		Student[] q5Expected1 = { b, e };

		Student g = new Student("Gus", 90);
		Student h = new Student("Hana", 80);
		Student i = new Student("Ivy", 100);
		Student j = new Student("Jay", 70);
		Student[][] q5Case2 = {
			{ g, h },
			{ i, j }
		};
		Student[] q5Expected2 = { g, i };

		Student k = new Student("Kai", 77);
		Student l = new Student("Lia", 92);
		Student m = new Student("Moe", 81);
		Student n = new Student("Nia", 95);
		Student o = new Student("Omar", 79);
		Student p = new Student("Pia", 90);
		Student[][] q5Case3 = {
			{ k, l },
			{ m, n },
			{ o, p }
		};
		Student[] q5Expected3 = { l, n, p };

		checkStudentArray("Q5 Case 1 normal", q5Expected1, highestAverageColumn(q5Case1));
		checkStudentArray("Q5 Case 2 tie uses first column", q5Expected2, highestAverageColumn(q5Case2));
		checkStudentArray("Q5 Case 3 three rows", q5Expected3, highestAverageColumn(q5Case3));

		System.out.println("\nSummary: total=" + totalTests + ", passed=" + passedTests + ", failed=" + failedTests);
		System.out.println("Done.");
	}
}
