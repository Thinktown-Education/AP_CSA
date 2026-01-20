# Unit 3.7 — Class (static) Variables and Methods

## Learning Goals
By the end of this unit, you will:
- Understand the difference between instance and class variables
- Know when to use static variables
- Understand how static variables are shared among all objects
- Learn to write and use static methods
- Understand when to use static methods vs. instance methods
- Use static methods for utility functions
- Learn about static initializers
- Design classes with static members effectively
- Understand the difference between static and non-static code
- Apply static variables to common problems like counters

## 1. Instance vs. Class Variables

### 1.1 Instance Variables (What We've Been Using)

**Instance variables** belong to each individual object. Each object has its own copy.

```java
public class Student {
    private String name;        // Instance variable
    private int gradeLevel;     // Instance variable
    private double gpa;         // Instance variable
    
    public Student(String name, int level, double gpa) {
        this.name = name;
        this.gradeLevel = level;
        this.gpa = gpa;
    }
}
```

Each student has their own name, grade level, and GPA:
```java
Student s1 = new Student("Alice", 10, 3.8);
Student s2 = new Student("Bob", 11, 3.5);

// s1 has: name="Alice", gradeLevel=10, gpa=3.8
// s2 has: name="Bob", gradeLevel=11, gpa=3.5
// Completely independent
```

### 1.2 Class Variables (Static)

**Class variables** (static variables) belong to the entire class, not to individual objects. All objects share the same copy.

```java
public class Student {
    private static int totalStudents = 0;  // Class variable (static)
    
    private String name;                   // Instance variable
    private int gradeLevel;                // Instance variable
    
    public Student(String name, int level) {
        this.name = name;
        this.gradeLevel = level;
        totalStudents++;  // Increment shared counter
    }
}
```

All students share one `totalStudents`:
```java
Student s1 = new Student("Alice", 10);     // totalStudents = 1
Student s2 = new Student("Bob", 11);       // totalStudents = 2
Student s3 = new Student("Charlie", 10);   // totalStudents = 3

System.out.println(Student.totalStudents);  // Prints: 3
```

### 1.3 Visual Comparison

**Instance Variables:**
```
Memory:
Student object 1          Student object 2
name = "Alice"           name = "Bob"
gradeLevel = 10          gradeLevel = 11
(independent)            (independent)
```

**Class Variables:**
```
Memory:
┌──────────────────┐
│ Student class    │
│ totalStudents=3  │  (shared by all objects)
└──────────────────┘

Student object 1    Student object 2    Student object 3
name = "Alice"      name = "Bob"         name = "Charlie"
gradeLevel = 10     gradeLevel = 11     gradeLevel = 10
```

## 2. Static Variables

### 2.1 Declaring Static Variables

```java
public class Student {
    // Static variable: belongs to class
    private static int totalStudents = 0;
    
    // Instance variable: belongs to each object
    private String name;
    
    public Student(String name) {
        this.name = name;
        totalStudents++;
    }
}
```

**Syntax:** `private static type variableName = initialValue;`

### 2.2 Accessing Static Variables

From inside the class:
```java
public class Student {
    private static int totalStudents = 0;
    
    public Student(String name) {
        totalStudents++;  // Can access static variable directly
    }
    
    public static int getTotalStudents() {
        return totalStudents;  // Can access from static method
    }
}
```

From outside the class:
```java
// Access using ClassName.variableName
System.out.println(Student.getTotalStudents());  // Through getter
```

### 2.3 Static Variable Persists Across Objects

```java
public class Student {
    private static int totalStudents = 0;
    private String name;
    
    public Student(String name) {
        this.name = name;
        totalStudents++;
    }
    
    public static int getTotalStudents() {
        return totalStudents;
    }
}

// Usage:
System.out.println(Student.getTotalStudents());  // 0

Student s1 = new Student("Alice");
System.out.println(Student.getTotalStudents());  // 1

Student s2 = new Student("Bob");
System.out.println(Student.getTotalStudents());  // 2

Student s3 = new Student("Charlie");
System.out.println(Student.getTotalStudents());  // 3
```

The static variable persists and accumulates across all object creations.

## 3. Static Methods

### 3.1 Instance Methods vs. Static Methods

**Instance method** (works on specific object):
```java
public class Math {
    private int value;
    
    public void setValue(int v) {
        this.value = v;  // Uses 'this'—refers to specific object
    }
}

Math m = new Math();
m.setValue(5);  // Must have an object
```

**Static method** (works on class, not objects):
```java
public class Math {
    public static int add(int a, int b) {
        return a + b;  // No 'this'—no specific object
    }
}

int result = Math.add(5, 3);  // No object needed!
```

### 3.2 Declaring Static Methods

```java
public class Utility {
    // Static method: no 'this', called on class
    public static double square(double x) {
        return x * x;
    }
    
    // Static method with multiple parameters
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
```

### 3.3 Using Static Methods

```java
// Don't need an object
double result = Utility.square(5.0);    // Prints: 25.0
int maximum = Utility.max(10, 15);      // Prints: 15

// This is how Java's built-in methods work
int absolute = Math.abs(-5);             // Math.abs() is static
double squareRoot = Math.sqrt(16);       // Math.sqrt() is static
```

### 3.4 Static vs. Instance Methods

| Feature | Static Method | Instance Method |
|---|---|---|
| Called on | Class: `ClassName.method()` | Object: `object.method()` |
| Can use `this`? | No | Yes |
| Can access instance variables? | No | Yes |
| Can access static variables? | Yes | Yes |
| Use case | Utilities, helpers | Object behavior |

## 4. Complete Example: Student with Static Counter

```java
public class Student {
    // Static variable: shared by all students
    private static int totalStudents = 0;
    
    // Instance variables: each student has own copy
    private String name;
    private int gradeLevel;
    private double gpa;
    
    // Constructor
    public Student(String name, int gradeLevel, double gpa) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        totalStudents++;  // Increment counter
    }
    
    // Instance methods
    public String getName() {
        return name;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public boolean isHonorStudent() {
        return gpa >= 3.5;
    }
    
    // Static method: get total students
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    // Static method: get average GPA
    public static void printStatistics(Student[] students) {
        if (students.length == 0) {
            System.out.println("No students");
            return;
        }
        
        double sum = 0;
        for (Student s : students) {
            sum += s.gpa;
        }
        double average = sum / students.length;
        System.out.println("Average GPA: " + average);
    }
}
```

Using the class:
```java
System.out.println("Total: " + Student.getTotalStudents());  // 0

Student s1 = new Student("Alice", 10, 3.8);
System.out.println("Total: " + Student.getTotalStudents());  // 1

Student s2 = new Student("Bob", 11, 3.5);
System.out.println("Total: " + Student.getTotalStudents());  // 2

Student s3 = new Student("Charlie", 10, 3.2);
System.out.println("Total: " + Student.getTotalStudents());  // 3

Student[] allStudents = {s1, s2, s3};
Student.printStatistics(allStudents);  // Average GPA: 3.5
```

## 5. Static Methods for Utilities

**Utility classes** contain static methods that don't need objects.

### 5.1 Math Utility Class

```java
public class MathHelper {
    // Static methods: no objects needed
    
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public static double average(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return (double) sum / numbers.length;
    }
}
```

Using it:
```java
System.out.println(MathHelper.factorial(5));         // 120
System.out.println(MathHelper.isPrime(17));          // true
System.out.println(MathHelper.average(new int[] {1, 2, 3, 4, 5}));  // 3.0
```

### 5.2 String Utility Class

```java
public class StringHelper {
    // Static method: reverse a string
    public static String reverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.substring(i, i + 1);
        }
        return result;
    }
    
    // Static method: count vowels
    public static int countVowels(String s) {
        int count = 0;
        String lower = s.toLowerCase();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.substring(i, i + 1).charAt(0);
            if ("aeiou".contains(lower.substring(i, i + 1))) {
                count++;
            }
        }
        return count;
    }
}
```

Using it:
```java
System.out.println(StringHelper.reverse("Hello"));      // olleH
System.out.println(StringHelper.countVowels("Hello"));  // 2
```

## 6. Static Constants

**Constants** are static variables that never change.

```java
public class Constants {
    // Static constants: don't change
    public static final double PI = 3.14159;
    public static final int MAX_STUDENTS = 100;
    public static final String SCHOOL_NAME = "Lincoln High";
}
```

Using constants:
```java
double circleArea = Constants.PI * radius * radius;
if (numStudents > Constants.MAX_STUDENTS) {
    System.out.println("Too many students!");
}
System.out.println("Welcome to " + Constants.SCHOOL_NAME);
```

**Convention:** Constants use ALL_CAPS naming.

## 7. Common Uses of Static Variables

### 7.1 Counters

```java
public class User {
    private static int totalUsers = 0;
    private String username;
    
    public User(String username) {
        this.username = username;
        totalUsers++;
    }
    
    public static int getTotalUsers() {
        return totalUsers;
    }
}
```

### 7.2 Settings/Configuration

```java
public class GameSettings {
    public static final int DIFFICULTY_EASY = 1;
    public static final int DIFFICULTY_MEDIUM = 2;
    public static final int DIFFICULTY_HARD = 3;
    
    public static int currentDifficulty = DIFFICULTY_MEDIUM;
}
```

### 7.3 IDs/Unique Numbers

```java
public class Product {
    private static int nextId = 1000;
    private int id;
    private String name;
    
    public Product(String name) {
        this.name = name;
        this.id = nextId;
        nextId++;  // Increment for next product
    }
    
    public int getId() {
        return id;
    }
}
```

Using it:
```java
Product p1 = new Product("Laptop");
Product p2 = new Product("Phone");
Product p3 = new Product("Tablet");

System.out.println(p1.getId());  // 1000
System.out.println(p2.getId());  // 1001
System.out.println(p3.getId());  // 1002
```

## 8. Static Initializers

A **static initializer** runs once when the class is first loaded, before any objects are created.

```java
public class Configuration {
    public static int maxSize;
    
    // Static initializer: runs once, first time class is used
    static {
        maxSize = 100;
        System.out.println("Configuration initialized");
    }
}
```

When the class is first used:
```java
System.out.println(Configuration.maxSize);  // Prints: Configuration initialized
                                            // Then: 100
```

## 9. Complete Example: Bank with Static Data

```java
public class Bank {
    // Static data: shared by all bank accounts
    private static double interestRate = 0.02;
    private static int totalAccounts = 0;
    private static double totalDeposits = 0;
    
    // Instance data: unique to each account
    private String accountNumber;
    private String owner;
    private double balance;
    
    public Bank(String accountNumber, String owner, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialDeposit;
        totalAccounts++;
        totalDeposits += initialDeposit;
    }
    
    public void deposit(double amount) {
        balance += amount;
        totalDeposits += amount;
    }
    
    public void applyInterest() {
        balance = balance * (1 + interestRate);
    }
    
    // Static methods
    public static void setInterestRate(double rate) {
        interestRate = rate;
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public static double getTotalDeposits() {
        return totalDeposits;
    }
    
    public static void printBankInfo() {
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Total Deposits: $" + totalDeposits);
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
    
    // Instance methods
    public double getBalance() {
        return balance;
    }
    
    public void printAccountInfo() {
        System.out.println(owner + "'s account: $" + balance);
    }
}
```

Using the class:
```java
Bank.printBankInfo();  // Total Accounts: 0, Total Deposits: $0.0

Bank account1 = new Bank("111", "Alice", 1000);
Bank account2 = new Bank("222", "Bob", 500);

Bank.printBankInfo();  // Total Accounts: 2, Total Deposits: $1500.0

account1.deposit(200);
Bank.printBankInfo();  // Total Accounts: 2, Total Deposits: $1700.0

Bank.setInterestRate(0.03);
account1.applyInterest();
account1.printAccountInfo();  // Alice's account: $1236
```

## 10. Best Practices with Static

### 10.1 Use Static for Utilities and Constants

**Good use of static:**
```java
// Utility methods (no object needed)
public class Math {
    public static double sqrt(double x) { ... }
    public static int abs(int x) { ... }
}

// Constants (same for all)
public class Constants {
    public static final double PI = 3.14159;
}
```

### 10.2 Avoid Overusing Static Variables

**Bad (too much shared state):**
```java
public class Student {
    private static String name;  // All students share same name!
    private static int age;      // All students share same age!
}
```

**Good (use instance variables):**
```java
public class Student {
    private String name;  // Each student has own name
    private int age;      // Each student has own age
}
```

### 10.3 Static Variables and Modification

Be careful with static variables—they're shared and mutable:

```java
public class Example {
    public static int counter = 0;
}

Example.counter = 5;
System.out.println(Example.counter);  // 5

Example.counter = 10;
System.out.println(Example.counter);  // 10 (changed everywhere!)
```

## 11. When to Use Static vs. Instance

| Use Instance When | Use Static When |
|---|---|
| Data varies per object | Data shared by all objects |
| Method works on object data | Method works independently |
| Example: Student name | Example: Counter of all students |
| Example: Rectangle width | Example: Math.sqrt() utility |

## 12. Debugging Static Problems

### 12.1 Problem: Modifying Shared Static

**Error:**
```java
public class Config {
    public static int value = 10;
}

Config.value = 20;  // Changes it for everyone
// Now all code sees value = 20
```

**Solution:** Use private and provide getter/setter:
```java
public class Config {
    private static int value = 10;
    
    public static void setValue(int newValue) {
        value = newValue;
    }
}
```

### 12.2 Problem: Accessing Instance Data from Static

**Error:**
```java
public class Student {
    private String name;
    
    public static void printName() {
        System.out.println(name);  // ERROR: can't access instance variable
    }
}
```

**Solution:** Use instance method or pass object:
```java
public class Student {
    private String name;
    
    public void printName() {  // Instance method
        System.out.println(name);  // OK
    }
    
    public static void printStudentName(Student s) {  // Pass object
        System.out.println(s.name);  // OK
    }
}
```

## Key Takeaways
- Static variables belong to the class and are shared by all objects
- Instance variables belong to individual objects and each object has its own copy
- Static methods can be called on the class without creating an object
- Instance methods must be called on specific objects
- Static methods cannot access instance variables directly
- Use static for utilities, constants, and class-level data that is shared
- Use instance variables and methods for data and behavior unique to each object
- Static variables persist across all object creations
- Static constants follow ALL_CAPS naming convention
- Static initializers run once when the class is first loaded
- Counters and IDs are common uses of static variables
- Be careful not to overuse static—most data should be instance data

## Practice Problems

1) **Static vs. Instance**: Explain the difference between a static variable and an instance variable. Give an example of each.

2) **Shared Static Variables**: Write a `Dog` class with an instance variable `name` and a static variable `totalDogs`. Increment the counter in the constructor.

3) **Static Counter**: Write a method that returns the total number of `Dog` objects created. Show its usage.

4) **Static Methods**: Write a static method called `isEven(int num)` that returns true if the number is even, false otherwise.

5) **Utility Class**: Write a `StringUtils` class with static methods `capitalize(String s)` and `reverse(String s)`.

6) **Static Constants**: Write a `GameState` class with static constants for PLAYING, PAUSED, and GAME_OVER.

7) **Accessing Static**: Show how to access a static variable from outside the class. Write code that demonstrates this.

8) **Instance vs. Static Methods**: Explain why you can't use `this` in a static method. What would you use instead?

9) **Static Method that Uses Static Variable**: Write a `BankAccount` class with a static interest rate, a static method to change the rate, and a method to calculate interest.

10) **Multiple Objects and Static**: Create three `Student` objects. After each creation, print the total count. Explain what you observe.

11) **Static Initializer**: Write a class with a static initializer that prints a message when the class is first loaded.

12) **Challenge - ID Generator**: Write a `Product` class that automatically assigns a unique ID to each product using a static variable. Show that IDs are sequential.

13) **Challenge - Game Statistics**: Write a `Game` class that tracks:
    - Static variables: total games played, highest score, total points
    - Instance variables: player name, score
    - Methods to update statistics and display them

14) **Challenge - Singleton Pattern**: Write a `DatabaseConnection` class with:
    - Private constructor (can't create with new)
    - Static variable holding a single instance
    - Static method getInstance() that returns the instance
    - Demonstrate that all code uses the same instance
