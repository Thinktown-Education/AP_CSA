# Unit 3.4 — Writing Constructors

## Learning Goals
By the end of this unit, you will:
- Understand constructor purpose and syntax
- Write constructors with different parameter lists
- Understand constructor overloading
- Use the `this` keyword to refer to object fields
- Call one constructor from another using `this()`
- Understand the default constructor
- Follow best practices when writing constructors
- Design constructors that properly initialize objects

## 1. What Constructors Do

A **constructor** is a special method that:
- Runs automatically when you create a new object with `new`
- Initializes all the object's fields
- Ensures objects start in a valid state
- Receives parameters to customize initialization

**Constructor rules:**
- Must have the same name as the class
- No return type (not even `void`)
- Can have parameters
- Can be public or private

## 2. Basic Constructor

### 2.1 Simple Constructor Example

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

Using it:
```java
Student s = new Student("Alice", 10);
// Constructor runs with n="Alice", level=10
// name is set to "Alice"
// gradeLevel is set to 10
```

### 2.2 Field Assignment in Constructors

```java
public class Car {
    private String brand;
    private int year;
    private String color;
    
    public Car(String b, int y, String c) {
        brand = b;
        year = y;
        color = c;
    }
}
```

**Important:** Always assign to all fields in the constructor. Objects should never have uninitialized fields.

## 3. The `this` Keyword

The **`this` keyword** refers to the current object. Use it to distinguish between field names and parameter names.

### 3.1 Without `this` (Confusing)

```java
public class Student {
    private String name;
    
    public Student(String n) {
        name = n;  // Clear which is field, which is parameter
    }
}
```

### 3.2 With `this` (Better Practice)

```java
public class Student {
    private String name;
    
    public Student(String name) {
        this.name = name;  // this.name = field, name = parameter
    }
}
```

**Why use `this`?**
- Parameter names can match field names exactly
- Code is clearer and more readable
- Standard Java practice

### 3.3 More Examples with `this`

```java
public class Rectangle {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;    // this.width = field
        this.height = height;  // this.height = field
    }
}
```

## 4. Constructor Overloading

**Constructor overloading** means having multiple constructors with different parameter lists.

### 4.1 Different Number of Parameters

```java
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    
    // Constructor with all three parameters
    public Student(String name, int gradeLevel, double gpa) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
    }
    
    // Constructor with only name and grade
    public Student(String name, int gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = 0.0;  // Default value
    }
    
    // Constructor with only name
    public Student(String name) {
        this.name = name;
        this.gradeLevel = 9;  // Default grade
        this.gpa = 0.0;       // Default GPA
    }
}
```

Using overloaded constructors:
```java
Student s1 = new Student("Alice", 10, 3.8);
Student s2 = new Student("Bob", 11);
Student s3 = new Student("Charlie");
```

### 4.2 Different Parameter Types

```java
public class Person {
    private String name;
    private int age;
    
    // Constructor taking strings
    public Person(String name, String ageString) {
        this.name = name;
        this.age = Integer.parseInt(ageString);  // Convert to int
    }
    
    // Constructor taking integers
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

## 5. Using `this()` to Call Another Constructor

You can call one constructor from another using `this()`. This avoids repeating code.

### 5.1 Problem: Repeated Code

```java
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    
    public Student(String name, int gradeLevel, double gpa) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
    }
    
    public Student(String name, int gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = 0.0;  // Repeated initialization
    }
}
```

### 5.2 Solution: Use `this()`

```java
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    
    public Student(String name, int gradeLevel, double gpa) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
    }
    
    public Student(String name, int gradeLevel) {
        this(name, gradeLevel, 0.0);  // Call the other constructor
    }
    
    public Student(String name) {
        this(name, 9, 0.0);  // Call the three-parameter constructor
    }
}
```

**Important rule:** `this()` must be the first statement in the constructor.

## 6. Default Constructor

If you don't write any constructors, Java provides a **default constructor** with no parameters.

### 6.1 Automatic Default Constructor

```java
public class Person {
    private String name;
    private int age;
    // No constructor written
}

Person p = new Person();  // Works! Uses default constructor
// But name and age are uninitialized (null and 0)
```

### 6.2 Writing Your Own Default Constructor

If you write any constructor, the default is removed. To keep it, write it yourself:

```java
public class Person {
    private String name;
    private int age;
    
    // No-parameter constructor (explicit default)
    public Person() {
        this.name = "";
        this.age = 0;
    }
    
    // Parameter constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

## 7. Complete Constructor Example

### 7.1 Book Class with Multiple Constructors

```java
public class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    
    // Full constructor (main one)
    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }
    
    // Constructor without price (calculate later)
    public Book(String title, String author, int pages) {
        this(title, author, pages, 0.0);
    }
    
    // Constructor with just title (minimal info)
    public Book(String title) {
        this(title, "Unknown Author", 0, 0.0);
    }
    
    // No-parameter constructor
    public Book() {
        this("Untitled", "Unknown Author", 0, 0.0);
    }
    
    // Getter methods
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getPages() {
        return pages;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Information method
    public String getInfo() {
        return title + " by " + author + " (" + pages + " pages, $" + price + ")";
    }
}
```

Using different constructors:
```java
Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 180, 12.99);
Book b2 = new Book("1984", "George Orwell", 328);
Book b3 = new Book("To Kill a Mockingbird");
Book b4 = new Book();

System.out.println(b1.getInfo());
// Output: The Great Gatsby by F. Scott Fitzgerald (180 pages, $12.99)
```

## 8. Constructor Best Practices

### 8.1 Initialize All Fields

**Bad:**
```java
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    
    public Student(String name) {
        this.name = name;
        // gradeLevel and gpa are uninitialized!
    }
}
```

**Good:**
```java
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    
    public Student(String name) {
        this.name = name;
        this.gradeLevel = 9;    // Initialize all fields
        this.gpa = 0.0;
    }
}
```

### 8.2 Use Meaningful Parameter Names

**Bad:**
```java
public Student(String s, int g, double d) {
    this.name = s;
    this.gradeLevel = g;
    this.gpa = d;
}
```

**Good:**
```java
public Student(String name, int gradeLevel, double gpa) {
    this.name = name;
    this.gradeLevel = gradeLevel;
    this.gpa = gpa;
}
```

### 8.3 Validate Input When Possible

```java
public class Student {
    private String name;
    private int gradeLevel;
    
    public Student(String name, int gradeLevel) {
        this.name = name;
        // Validate gradeLevel
        if (gradeLevel >= 9 && gradeLevel <= 12) {
            this.gradeLevel = gradeLevel;
        } else {
            this.gradeLevel = 9;  // Default if invalid
        }
    }
}
```

### 8.4 Use `this()` to Reduce Code Duplication

**Bad (repeated code):**
```java
public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
}

public Rectangle(double side) {
    this.width = side;
    this.height = side;
}
```

**Good (uses `this()`):**
```java
public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
}

public Rectangle(double side) {
    this(side, side);  // Calls the other constructor
}
```

## 9. Common Constructor Patterns

### 9.1 Full Constructor + Convenience Constructors

```java
public class BankAccount {
    private String accountNumber;
    private double balance;
    private String owner;
    
    // Main constructor (all parameters)
    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }
    
    // Convenience: new account with $0 balance
    public BankAccount(String accountNumber, String owner) {
        this(accountNumber, owner, 0.0);
    }
}
```

### 9.2 Copy Constructor

```java
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    
    public Student(String name, int gradeLevel, double gpa) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
    }
    
    // Copy constructor (create from another Student)
    public Student(Student other) {
        this.name = other.name;
        this.gradeLevel = other.gradeLevel;
        this.gpa = other.gpa;
    }
}
```

Using a copy constructor:
```java
Student s1 = new Student("Alice", 10, 3.8);
Student s2 = new Student(s1);  // s2 is a copy of s1
```

## 10. Debugging Constructor Issues

### 10.1 Problem: Uninitialized Fields

**Code:**
```java
public class Person {
    private String name;
    
    public Person(int age) {
        // Forgot to initialize name!
    }
}
```

**Problem:** `name` is `null`, which can cause errors later.

**Solution:** Initialize all fields.

### 10.2 Problem: `this()` Not First Statement

**Bad:**
```java
public class Student {
    public Student(String name, int grade, double gpa) {
        this.name = name;
        this(name, grade);  // ERROR: this() must be first!
    }
}
```

**Good:**
```java
public class Student {
    public Student(String name, int grade) {
        this(name, grade, 0.0);  // this() is first
    }
}
```

## Key Takeaways
- Constructors initialize objects when created and run automatically with the `new` keyword
- Constructors must have the same name as the class and no return type
- Use `this.fieldName` to refer to fields, especially when parameter names match field names
- Constructor overloading allows multiple constructors with different parameters
- Use `this(...)` to call one constructor from another, reducing code duplication
- Always initialize all fields in every constructor
- If you write any constructor, Java removes the default no-parameter constructor
- Use parameter validation to ensure objects start in a valid state
- Meaningful parameter names and comments make constructors easier to understand
- Copy constructors can create new objects based on existing ones

## Practice Problems

1) **Basic Constructor**: Write a constructor for a `Dog` class that takes parameters for name, breed, and age. Assign them to fields.

2) **Using `this`**: Rewrite the constructor from problem 1 using the `this` keyword for field assignment.

3) **No-Parameter Constructor**: Write a no-parameter constructor for a `Dog` class that sets default values (name="Buddy", breed="Mixed", age=0).

4) **Constructor Overloading**: Write two constructors for a `Rectangle` class: one with width and height, and one with just side (for a square).

5) **Default vs. Custom Constructor**: Explain what happens when you don't write any constructor. Why might you want to write your own default constructor?

6) **Field Initialization**: Why is it important to initialize all fields in a constructor? What could go wrong if you don't?

7) **Parameter Names**: Write two versions of a constructor for a `Circle` class (with radius). One with a confusing parameter name, one with a clear name. Explain the difference.

8) **Using `this()` to Call Another Constructor**: Write a `Book` class with a constructor that takes title, author, pages, and price. Then write a constructor that takes only title and author, and calls the first constructor with default values for pages (200) and price (9.99).

9) **Validation in Constructor**: Write a constructor for a `GradeBook` class that takes a teacher name and class size. Validate that class size is between 1 and 100. If not, set it to 30.

10) **Copy Constructor**: Write a copy constructor for a `Student` class that creates a new Student based on an existing one.

11) **Multiple Overloaded Constructors**: Write a `Time` class with constructors for:
    - All three parameters: hour, minute, second
    - Just hour and minute (seconds default to 0)
    - Just hour (minute and second default to 0)
    - No parameters (defaults to 12:00:00)

12) **Challenge - Validation and `this()`**: Write a `BankAccount` class with:
    - Constructor(accountNumber, owner, balance) that validates balance >= 0
    - Constructor(accountNumber, owner) that calls the first constructor with balance = 0
    - A method that returns account information as a string

13) **Challenge - Copy Constructor**: Write a `Playlist` class that stores songs. Include:
    - A regular constructor that takes a playlist name
    - A copy constructor that creates a new playlist with the same name and songs
    - Methods to add songs and display the playlist

14) **Challenge - Design Your Own**: Design a class of your choice with at least three overloaded constructors. Explain why you chose each constructor version and when you would use each one.
