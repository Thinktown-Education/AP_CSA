# Unit 3.3 — Anatomy of a Java Class

## Learning Goals
By the end of this unit, you will:
- Understand the structure and components of a Java class
- Know the difference between instance variables and methods
- Understand access modifiers (public and private)
- Learn about constructors and their purpose
- Learn about instance variables (fields) and how they store object state
- Write well-designed classes that follow object-oriented principles

## 1. What Is a Class?

A **class** is a blueprint for creating objects. It defines:
- **Fields (instance variables):** Data each object stores
- **Methods:** Actions each object can perform
- **Constructors:** How to initialize a new object

Think of a class like a recipe:
- The class is the recipe
- Each object is a dish made from that recipe
- Different dishes from the same recipe can have different ingredients

## 2. Basic Class Structure

```java
public class Student {
    // Fields (instance variables)
    private String name;
    private int gradeLevel;
    private double gpa;
    
    // Constructor
    public Student(String n, int level, double g) {
        name = n;
        gradeLevel = level;
        gpa = g;
    }
    
    // Methods
    public String getName() {
        return name;
    }
    
    public void study(int hours) {
        // Code to handle studying
    }
}
```

**Main parts:**
1. **Class declaration:** `public class Student`
2. **Fields:** Variables that store data for each object
3. **Constructor:** Initializes the object
4. **Methods:** Functions the object can perform

## 3. Fields (Instance Variables)

**Fields** store the state of an object. Each object has its own copy of the fields.

```java
public class Student {
    private String name;           // Each student has their own name
    private int gradeLevel;        // Each student has their own grade
    private double gpa;            // Each student has their own GPA
}
```

Creating two students:
```java
Student s1 = new Student("Alice", 10, 3.8);
Student s2 = new Student("Bob", 11, 3.5);

// s1 has name="Alice", gradeLevel=10, gpa=3.8
// s2 has name="Bob", gradeLevel=11, gpa=3.5
// Their fields are independent
```

## 4. Constructors

A **constructor** initializes a new object. It runs automatically when you use `new`.

### 4.1 Constructor Syntax

```java
public class Student {
    private String name;
    private int gradeLevel;
    
    // Constructor
    public Student(String n, int level) {
        name = n;
        gradeLevel = level;
    }
}
```

**Constructor rules:**
- Same name as the class
- No return type (not even `void`)
- Receives parameters for initialization
- Runs automatically with `new`

### 4.2 Creating Objects with Constructors

```java
Student s1 = new Student("Alice", 10);
// Calls constructor with n="Alice", level=10
// Sets name="Alice", gradeLevel=10
```

## 5. Methods

**Methods** are actions an object can perform.

### 5.1 Getter Methods

Getters return field values:

```java
public class Student {
    private String name;
    
    // Getter method
    public String getName() {
        return name;
    }
}
```

Using a getter:
```java
Student s = new Student("Alice", 10);
String studentName = s.getName();  // Returns "Alice"
```

### 5.2 Setter Methods

Setters change field values:

```java
public class Student {
    private String name;
    
    // Setter method
    public void setName(String newName) {
        name = newName;
    }
}
```

Using a setter:
```java
Student s = new Student("Alice", 10);
s.setName("Alicia");  // Changes name to "Alicia"
```

### 5.3 Action Methods

Methods that perform actions:

```java
public class Student {
    private double gpa;
    
    // Action method
    public boolean isHonorStudent() {
        return gpa >= 3.5;
    }
}
```

## 6. Access Modifiers

**Access modifiers** control who can access fields and methods.

### 6.1 Private vs. Public

| Modifier | Who Can Access | Common Use |
|---|---|---|
| `private` | Only the class itself | Fields (data) |
| `public` | Anyone | Methods (interface) |

### 6.2 Why Use Private Fields?

**Good design:**
```java
public class Student {
    private double gpa;  // Nobody can change this directly
    
    // Only way to change GPA
    public void setGpa(double newGpa) {
        if (newGpa >= 0 && newGpa <= 4.0) {  // Validate
            gpa = newGpa;
        }
    }
}
```

**Bad design:**
```java
public class Student {
    public double gpa;  // Anyone can change this directly
    
    Student s = new Student(...);
    s.gpa = -5;  // Invalid! But allowed
}
```

Private fields with public setter methods allow you to **validate** data before accepting it.

## 7. Complete Example: Student Class

```java
public class Student {
    // Fields
    private String name;
    private int gradeLevel;
    private double gpa;
    
    // Constructor
    public Student(String n, int level, double g) {
        name = n;
        gradeLevel = level;
        gpa = g;
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getGradeLevel() {
        return gradeLevel;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    // Setter method with validation
    public void setGpa(double newGpa) {
        if (newGpa >= 0 && newGpa <= 4.0) {
            gpa = newGpa;
        }
    }
    
    // Action method
    public boolean isHonorStudent() {
        return gpa >= 3.5;
    }
    
    // Method that returns information
    public String getInfo() {
        return name + " is in grade " + gradeLevel + 
               " with GPA " + gpa;
    }
}
```

Using the class:
```java
Student s = new Student("Alice", 10, 3.8);

System.out.println(s.getName());        // Alice
System.out.println(s.getGpa());         // 3.8
System.out.println(s.isHonorStudent()); // true

s.setGpa(3.9);
System.out.println(s.getGpa());         // 3.9

System.out.println(s.getInfo());
// Output: Alice is in grade 10 with GPA 3.9
```

## 8. Class Design Best Practices

### 8.1 Encapsulation

**Encapsulation** means hiding internal details and only showing what's necessary.

**Good encapsulation:**
- Fields are `private` (hidden)
- Methods are `public` (interface)
- Methods validate data before changing fields

**Example:**
```java
private double gpa;  // Hidden

public void setGpa(double newGpa) {  // Validated setter
    if (newGpa >= 0 && newGpa <= 4.0) {
        gpa = newGpa;
    }
}
```

### 8.2 Field Naming

Use meaningful names:

**Good:**
```java
private String studentName;
private int gradeLevel;
private double gpa;
```

**Bad:**
```java
private String n;
private int g;
private double d;
```

### 8.3 Method Naming

Getters start with `get`, setters with `set`:

```java
public String getName()      // Getter
public void setName(String s)  // Setter
public boolean isHonorStudent()  // Boolean method
```

### 8.4 Constructor Initialization

Always initialize all fields in the constructor:

```java
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    
    public Student(String n, int level, double g) {
        name = n;              // Initialize all fields
        gradeLevel = level;
        gpa = g;
    }
}
```

## 9. Multiple Objects from One Class

One class creates many objects:

```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 10, 3.8);
        Student s2 = new Student("Bob", 11, 3.5);
        Student s3 = new Student("Charlie", 10, 3.2);
        
        // Three independent objects
        System.out.println(s1.getName());  // Alice
        System.out.println(s2.getName());  // Bob
        System.out.println(s3.getName());  // Charlie
        
        s1.setGpa(3.9);  // Only s1 is affected
        System.out.println(s1.getGpa());   // 3.9
        System.out.println(s2.getGpa());   // 3.5 (unchanged)
    }
}
```

## 10. Designing Your Own Classes

When designing a class, ask:

1. **What data does each object need?** (→ Fields)
2. **How do we create an object?** (→ Constructor)
3. **What actions can the object perform?** (→ Methods)
4. **What information should be hidden?** (→ Private fields)
5. **What should be accessible?** (→ Public methods)

Example: Designing a `Book` class
- **Fields:** title, author, pages, isbn
- **Constructor:** Initialize all fields
- **Methods:** getTitle(), getAuthor(), getPageCount(), isLongBook()
- **Validation:** ISBN should be valid format

## Key Takeaways
- A class is a blueprint for creating objects with shared structure and behavior
- Fields (instance variables) store data, each object has its own copy
- Constructors initialize objects when they are created using the `new` keyword
- Methods are functions that objects can perform; getters return values, setters change values
- Private fields hide internal data; public methods provide the interface
- Access modifiers enforce encapsulation—hiding details and controlling what can be changed
- Good class design uses meaningful names, validates data in setters, and hides complexity
- One class can create many independent objects, each with their own field values
- Methods and fields work together to define what an object is and what it can do

## Practice Problems

1) **Class Definition**: What is a class? What is the relationship between a class and an object?

2) **Fields**: What are fields (instance variables)? Why does each object need its own copy?

3) **Constructor Purpose**: Explain the purpose of a constructor. When does it run?

4) **Constructor Parameters**: Write a constructor for a `Car` class with fields: brand, year, color.

5) **Getters and Setters**: What is the difference between a getter method and a setter method? Give one example of each.

6) **Access Modifiers**: Why would you make fields `private` and methods `public`? What does this accomplish?

7) **Validation**: Write a setter method for a `Person` class that sets the age field, but only accepts values between 0 and 150.

8) **Multiple Objects**: Write code that creates three `Student` objects with different names and GPAs. Then print each student's name and GPA.

9) **Object Independence**: Explain why changing one object's fields does not affect another object of the same class.

10) **Method Design**: Design a `Rectangle` class. What fields would it have? What methods would you include?

11) **String Representation**: Write a method called `getDescription()` for a `Book` class that returns a string like "The Great Gatsby by F. Scott Fitzgerald".

12) **Challenge - Bank Account**: Design a `BankAccount` class with fields for account holder name, balance, and account number. Include:
    - Constructor to initialize all fields
    - Getter methods for all fields
    - A `deposit(amount)` method that adds to balance
    - A `withdraw(amount)` method that removes from balance (but doesn't allow negative balance)
    - A method that returns the account information as a string

13) **Challenge - Student Grade Tracker**: Design a `StudentGradeTracker` class that:
    - Stores a student's name and list of grades
    - Has a constructor that sets the name
    - Has a method to add a grade
    - Has a method to calculate average grade
    - Has a method to find the highest grade
    - Has a method that returns a summary (name, average, highest)

14) **Challenge - Encapsulation**: Explain how encapsulation makes code safer and more maintainable. Use an example from one of the classes you've designed.
