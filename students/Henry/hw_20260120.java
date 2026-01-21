import java.util.Arrays;

public class hw_20260120 {
    
    /**
     * Q1. Count number of even integers in a 2D array.
     */
    public static int countEvens(int[][] arr) {
        
    }

    /**
     * Q2. Calculate the average of all positive integers in a 2D array.
     * Return 0.0 if there are no positive integers.
     */
    public static double averageOfPositives(int[][] arr) {
        
    }

    /**
     * Q3. Search for all occurrences of 'target' in the 2D array
     * and replace them with 'replacement'.
     */
    public static void searchAndReplace(int[][] arr, int target, int replacement) {
        
    }

    /**
     * Q4. Return the sume of the last column in a 2D array.
     */
    public static int sumLastColumn(int[][] arr) {
        
    }

    /**
     * Q5. Given a 2D array of Student objects, return the number of students
     * with a grade of 60 or higher.
     * Student class is defined below for reference.
     */
    public static int countPassing(Student[][] arr) {

    }

    /**
     * Q6. Given a 2D array of Student objects, return the average grade
     */
    public static double averageGrade(Student[][] arr) {

    }

    /**
     * Q7. Given a 2D array of Student objects, return the Student
     * with the shortest name. If there are multiple, return the first one.
     */
    public static Student findShortestName(Student[][] arr) {
        
    }

    /**
     * ==========================================================
     * Do NOT modify any code below this line. This is for testing purposes only.
     */
    public static void main(String[] args) {
        // Main method for testing purposes.
        testQ1();
        testQ2();
        testQ3();
        testQ4();
        testQ5();
        testQ6();
        testQ7();
    }

    public static void testQ1() {
        boolean allPassed = true;
        
        // Test case 1: Mix of even and odd numbers
        int[][] test1 = {{2, 3, 4}, {5, 6, 7}};
        int expected1 = 3;
        int result1 = countEvens(test1);
        if (result1 != expected1) {
            System.out.println("======Q1 failed======");
            System.out.println("Test dataset: {{2, 3, 4}, {5, 6, 7}}");
            System.out.println("Expected: " + expected1);
            System.out.println("Got: " + result1);
            return;
        }
        
        // Test case 2: All even numbers
        int[][] test2 = {{2, 4, 6}, {8, 10, 12}};
        int expected2 = 6;
        int result2 = countEvens(test2);
        if (result2 != expected2) {
            System.out.println("======Q1 failed======");
            System.out.println("Test dataset: {{2, 4, 6}, {8, 10, 12}}");
            System.out.println("Expected: " + expected2);
            System.out.println("Got: " + result2);
            return;
        }
        
        // Test case 3: All odd numbers
        int[][] test3 = {{1, 3, 5}, {7, 9, 11}};
        int expected3 = 0;
        int result3 = countEvens(test3);
        if (result3 != expected3) {
            System.out.println("======Q1 failed======");
            System.out.println("Test dataset: {{1, 3, 5}, {7, 9, 11}}");
            System.out.println("Expected: " + expected3);
            System.out.println("Got: " + result3);
            return;
        }
        
        System.out.println("Q1 passed");
    }

    public static void testQ2() {
        // Test case 1: Mix of positive, negative, and zero
        int[][] test1 = {{-5, 3, -2}, {4, 0, 6}};
        double expected1 = 4.33;
        double result1 = averageOfPositives(test1);
        if (Math.abs(result1 - expected1) >= 0.01) {
            System.out.println("======Q2 failed======");
            System.out.println("Test dataset: {{-5, 3, -2}, {4, 0, 6}}");
            System.out.println("Expected: " + expected1);
            System.out.println("Got: " + result1);
            return;
        }
        
        // Test case 2: All positive numbers
        int[][] test2 = {{1, 2, 3}, {4, 5, 6}};
        double expected2 = 3.5;
        double result2 = averageOfPositives(test2);
        if (Math.abs(result2 - expected2) >= 0.01) {
            System.out.println("======Q2 failed======");
            System.out.println("Test dataset: {{1, 2, 3}, {4, 5, 6}}");
            System.out.println("Expected: " + expected2);
            System.out.println("Got: " + result2);
            return;
        }
        
        // Test case 3: No positive numbers
        int[][] test3 = {{-5, -3, -2}, {-4, 0, -6}};
        double expected3 = 0.0;
        double result3 = averageOfPositives(test3);
        if (Math.abs(result3 - expected3) >= 0.01) {
            System.out.println("======Q2 failed======");
            System.out.println("Test dataset: {{-5, -3, -2}, {-4, 0, -6}}");
            System.out.println("Expected: " + expected3);
            System.out.println("Got: " + result3);
            return;
        }
        
        System.out.println("Q2 passed");
    }

    public static void testQ3() {
        // Test case 1: Replace existing target values
        int[][] test1 = {{1, 2, 3}, {2, 4, 2}};
        int[][] expected1 = {{1, 9, 3}, {9, 4, 9}};
        searchAndReplace(test1, 2, 9);
        if (!Arrays.deepEquals(test1, expected1)) {
            System.out.println("======Q3 failed======");
            System.out.println("Test dataset: {{1, 2, 3}, {2, 4, 2}}, replace 2 with 9");
            System.out.println("Expected: " + Arrays.deepToString(expected1));
            System.out.println("Got: " + Arrays.deepToString(test1));
            return;
        }
        
        // Test case 2: Target not present
        int[][] test2 = {{1, 2, 3}, {4, 5, 6}};
        int[][] expected2 = {{1, 2, 3}, {4, 5, 6}};
        searchAndReplace(test2, 7, 9);
        if (!Arrays.deepEquals(test2, expected2)) {
            System.out.println("======Q3 failed======");
            System.out.println("Test dataset: {{1, 2, 3}, {4, 5, 6}}, replace 7 with 9");
            System.out.println("Expected: " + Arrays.deepToString(expected2));
            System.out.println("Got: " + Arrays.deepToString(test2));
            return;
        }
        
        // Test case 3: Replace all values
        int[][] test3 = {{5, 5, 5}, {5, 5, 5}};
        int[][] expected3 = {{0, 0, 0}, {0, 0, 0}};
        searchAndReplace(test3, 5, 0);
        if (!Arrays.deepEquals(test3, expected3)) {
            System.out.println("======Q3 failed======");
            System.out.println("Test dataset: {{5, 5, 5}, {5, 5, 5}}, replace 5 with 0");
            System.out.println("Expected: " + Arrays.deepToString(expected3));
            System.out.println("Got: " + Arrays.deepToString(test3));
            return;
        }
        
        System.out.println("Q3 passed");
    }

    public static void testQ4() {
        // Test case 1: Regular 2D array
        int[][] test1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int expected1 = 18;
        int result1 = sumLastColumn(test1);
        if (result1 != expected1) {
            System.out.println("======Q4 failed======");
            System.out.println("Test dataset: {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}");
            System.out.println("Expected: " + expected1);
            System.out.println("Got: " + result1);
            return;
        }
        
        // Test case 2: Single row
        int[][] test2 = {{10, 20, 30}};
        int expected2 = 30;
        int result2 = sumLastColumn(test2);
        if (result2 != expected2) {
            System.out.println("======Q4 failed======");
            System.out.println("Test dataset: {{10, 20, 30}}");
            System.out.println("Expected: " + expected2);
            System.out.println("Got: " + result2);
            return;
        }
        
        // Test case 3: Single column
        int[][] test3 = {{5}, {10}, {15}};
        int expected3 = 30;
        int result3 = sumLastColumn(test3);
        if (result3 != expected3) {
            System.out.println("======Q4 failed======");
            System.out.println("Test dataset: {{5}, {10}, {15}}");
            System.out.println("Expected: " + expected3);
            System.out.println("Got: " + result3);
            return;
        }
        
        System.out.println("Q4 passed");
    }

    public static void testQ5() {
        // Test case 1: Mix of passing and failing students
        Student[][] test1 = {
            {new Student("Alice", 75), new Student("Bob", 55)},
            {new Student("Charlie", 90), new Student("Diana", 60)}
        };
        int expected1 = 3;
        int result1 = countPassing(test1);
        if (result1 != expected1) {
            System.out.println("======Q5 failed======");
            System.out.println("Test dataset: Alice(75), Bob(55), Charlie(90), Diana(60)");
            System.out.println("Expected: " + expected1);
            System.out.println("Got: " + result1);
            return;
        }
        
        // Test case 2: All passing students
        Student[][] test2 = {
            {new Student("Eve", 80), new Student("Frank", 70)},
            {new Student("Grace", 85), new Student("Henry", 65)}
        };
        int expected2 = 4;
        int result2 = countPassing(test2);
        if (result2 != expected2) {
            System.out.println("======Q5 failed======");
            System.out.println("Test dataset: Eve(80), Frank(70), Grace(85), Henry(65)");
            System.out.println("Expected: " + expected2);
            System.out.println("Got: " + result2);
            return;
        }
        
        // Test case 3: No passing students
        Student[][] test3 = {
            {new Student("Ian", 50), new Student("Jade", 45)},
            {new Student("Kevin", 55), new Student("Liam", 40)}
        };
        int expected3 = 0;
        int result3 = countPassing(test3);
        if (result3 != expected3) {
            System.out.println("======Q5 failed======");
            System.out.println("Test dataset: Ian(50), Jade(45), Kevin(55), Liam(40)");
            System.out.println("Expected: " + expected3);
            System.out.println("Got: " + result3);
            return;
        }
        
        System.out.println("Q5 passed");
    }

    public static void testQ6() {
        // Test case 1: Mix of grades
        Student[][] test1 = {
            {new Student("Alice", 80), new Student("Bob", 70)},
            {new Student("Charlie", 90), new Student("Diana", 60)}
        };
        double expected1 = 75.0;
        double result1 = averageGrade(test1);
        if (Math.abs(result1 - expected1) >= 0.01) {
            System.out.println("======Q6 failed======");
            System.out.println("Test dataset: Alice(80), Bob(70), Charlie(90), Diana(60)");
            System.out.println("Expected: " + expected1);
            System.out.println("Got: " + result1);
            return;
        }
        
        // Test case 2: High grades
        Student[][] test2 = {
            {new Student("Eve", 95), new Student("Frank", 92)},
            {new Student("Grace", 88), new Student("Henry", 100)}
        };
        double expected2 = 93.75;
        double result2 = averageGrade(test2);
        if (Math.abs(result2 - expected2) >= 0.01) {
            System.out.println("======Q6 failed======");
            System.out.println("Test dataset: Eve(95), Frank(92), Grace(88), Henry(100)");
            System.out.println("Expected: " + expected2);
            System.out.println("Got: " + result2);
            return;
        }
        
        // Test case 3: Low grades
        Student[][] test3 = {
            {new Student("Ian", 50), new Student("Jade", 45)},
            {new Student("Kevin", 55), new Student("Liam", 40)}
        };
        double expected3 = 47.5;
        double result3 = averageGrade(test3);
        if (Math.abs(result3 - expected3) >= 0.01) {
            System.out.println("======Q6 failed======");
            System.out.println("Test dataset: Ian(50), Jade(45), Kevin(55), Liam(40)");
            System.out.println("Expected: " + expected3);
            System.out.println("Got: " + result3);
            return;
        }
        
        System.out.println("Q6 passed");
    }

    public static void testQ7() {
        // Test case 1: Different name lengths
        Student[][] test1 = {
            {new Student("Alice", 80), new Student("Bob", 70)},
            {new Student("Christopher", 90), new Student("Diana", 60)}
        };
        Student expected1 = test1[0][1]; // "Bob" with 3 characters
        Student result1 = findShortestName(test1);
        if (result1 == null || !result1.getName().equals(expected1.getName())) {
            System.out.println("======Q7 failed======");
            System.out.println("Test dataset: Alice, Bob, Christopher, Diana");
            System.out.println("Expected: " + expected1.getName());
            System.out.println("Got: " + (result1 != null ? result1.getName() : "null"));
            return;
        }
        
        // Test case 2: Multiple same shortest length names (return first)
        Student[][] test2 = {
            {new Student("Eve", 95), new Student("Ian", 92)},
            {new Student("Dan", 88), new Student("Amy", 100)}
        };
        Student expected2 = test2[0][0]; // "Eve" (first encountered with 3 chars)
        Student result2 = findShortestName(test2);
        if (result2 == null || !result2.getName().equals(expected2.getName())) {
            System.out.println("======Q7 failed======");
            System.out.println("Test dataset: Eve, Ian, Dan, Amy");
            System.out.println("Expected: " + expected2.getName());
            System.out.println("Got: " + (result2 != null ? result2.getName() : "null"));
            return;
        }
        
        // Test case 3: Single name
        Student[][] test3 = {
            {new Student("Zoe", 50), new Student("Leonardo", 45)},
            {new Student("Kevin", 55), new Student("Liam", 40)}
        };
        Student expected3 = test3[0][0]; // "Zoe" with 3 characters
        Student result3 = findShortestName(test3);
        if (result3 == null || !result3.getName().equals(expected3.getName())) {
            System.out.println("======Q7 failed======");
            System.out.println("Test dataset: Zoe, Leonardo, Kevin, Liam");
            System.out.println("Expected: " + expected3.getName());
            System.out.println("Got: " + (result3 != null ? result3.getName() : "null"));
            return;
        }
        
        System.out.println("Q7 passed");
    }
}

class Student {
    private String name;
    private int grade;

    public Student(String n, int g) {
        name = n;
        grade = g;
    }

    public String getName() { return name; }
    public int getGrade() { return grade; }
}
