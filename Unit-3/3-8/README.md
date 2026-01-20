# Unit 3.8 — Scope and Access

## Learning Goals
By the end of this unit, you will:
- Understand variable scope and the different types of scope
- Know the lifetime of variables in different scopes
- Understand access modifiers (public, private)
- Learn how scope and access control visibility of code
- Use scope effectively to avoid naming conflicts
- Understand block scope and how it affects variable visibility
- Learn shadowing and how to avoid it
- Use access modifiers to enforce encapsulation
- Design classes with proper access control
- Avoid common scope-related errors

## 1. What Is Scope?

**Scope** determines where a variable can be seen and used in your program.

### 1.1 Scope Affects Visibility

A variable is only visible within its scope:

```java
public class Example {
    public void method1() {
        int x = 5;  // x is here
    }
    
    public void method2() {
        System.out.println(x);  // ERROR: x is not visible here
    }
}
```

The variable `x` is only visible inside `method1`. You cannot use it in `method2`.

### 1.2 Scope Determines Lifetime

A variable exists only during its scope:

```java
public class Example {
    public void method() {
        int x = 5;
        System.out.println(x);  // x exists here
    }
    
    public void another() {
        // x no longer exists here
    }
}
```

When `method()` finishes, `x` is destroyed. It no longer exists.

## 2. Types of Scope

### 2.1 Block Scope (Local Variables)

Variables declared in a block `{ }` exist only in that block.

```java
public class Example {
    public void demo() {
        int x = 5;  // Block scope
        
        if (x > 0) {
            int y = 10;  // y only exists in this if block
            System.out.println(x + y);  // OK: both visible
        }
        
        System.out.println(x);      // OK: x visible
        System.out.println(y);      // ERROR: y not visible here
    }
}
```

**Scope rules:**
- `x` exists in the entire method
- `y` exists only in the `if` block
- Once the `if` block ends, `y` is destroyed

### 2.2 Method Scope (Parameters)

Parameters exist only within the method:

```java
public class Example {
    public void setName(String name) {
        // 'name' is a parameter: visible only in this method
        this.name = name;
    }
    
    public void another() {
        System.out.println(name);  // ERROR: parameter 'name' not visible
    }
}
```

**Scope rule:** Parameters are local to the method.

### 2.3 Class Scope (Fields)

Fields are visible throughout the class.

```java
public class Student {
    private String name;  // Field: class scope
    
    public void setName(String n) {
        this.name = n;  // Can access name here
    }
    
    public String getName() {
        return this.name;  // Can access name here
    }
    
    public void printInfo() {
        System.out.println(name);  // Can access name here
    }
}
```

**Scope rule:** Fields are visible in all methods of the class.

## 3. Variable Lifetime

### 3.1 Local Variables

Local variables exist only while their block is executing:

```java
public class Example {
    public void demo() {
        if (true) {
            int x = 5;  // x is created
            System.out.println(x);  // x exists
        }
        // x is destroyed here
        
        System.out.println(x);  // ERROR: x no longer exists
    }
}
```

### 3.2 Method Parameters

Parameters exist for the duration of the method call:

```java
public class Example {
    public void method(int param) {
        System.out.println(param);  // param exists
    }  // param is destroyed here
}

// Calling the method:
method(5);  // param = 5, method executes, param destroyed
method(10); // param = 10, method executes, param destroyed
```

### 3.3 Fields (Instance Variables)

Fields exist as long as the object exists:

```java
public class Student {
    private String name;  // Field created with object
    
    public Student(String n) {
        name = n;
    }
}

Student s = new Student("Alice");  // name is created
System.out.println(s.getName());   // name exists
// When object is garbage collected, name is destroyed
```

### 3.4 Static Variables

Static variables exist for the entire program:

```java
public class Student {
    private static int totalStudents = 0;  // Exists from program start
}

// Static variable persists throughout execution
Student s1 = new Student();
// totalStudents is still there

s1 = null;  // Object destroyed
// totalStudents still exists!
```

## 4. Access Modifiers

**Access modifiers** control who can see and use code elements.

### 4.1 Public vs. Private

| Modifier | Who Can Access | Use Case |
|---|---|---|
| `public` | Anyone (inside or outside class) | Interface—what others can use |
| `private` | Only the class itself | Implementation—internal details |

### 4.2 Private Fields

```java
public class Student {
    private String name;        // Private: only Student class can access
    private int gradeLevel;     // Private: only Student class can access
    private double gpa;         // Private: only Student class can access
    
    public Student(String n, int g, double p) {
        name = n;               // OK: inside Student class
        gradeLevel = g;
        gpa = p;
    }
}

// Outside the class:
Student s = new Student("Alice", 10, 3.8);
System.out.println(s.name);       // ERROR: private, cannot access
System.out.println(s.gradeLevel); // ERROR: private, cannot access
```

### 4.3 Public Methods

```java
public class Student {
    private String name;
    
    public String getName() {    // Public: anyone can call
        return name;
    }
    
    public void setName(String n) {  // Public: anyone can call
        name = n;
    }
}

// Outside the class:
Student s = new Student("Alice");
System.out.println(s.getName());   // OK: public method
s.setName("Alicia");                // OK: public method
```

### 4.4 Encapsulation: Public Interface, Private Implementation

**Good design:**
```java
public class BankAccount {
    private double balance;  // Private: hidden
    
    public void deposit(double amount) {  // Public: interface
        if (amount > 0) {
            balance += amount;  // Validation happens here
        }
    }
    
    public double getBalance() {  // Public: interface
        return balance;
    }
}

// Outside:
BankAccount acc = new BankAccount();
acc.deposit(100);        // OK: uses public method
System.out.println(acc.getBalance());  // OK: uses public method
acc.balance = -500;      // ERROR: private field, cannot access
```

Users cannot directly manipulate the balance. They must use public methods, which have validation.

## 5. Scope Within Methods

### 5.1 Local Variables in Different Blocks

```java
public class Example {
    public void demo() {
        int x = 5;  // Exists in entire method
        
        {
            int y = 10;  // Exists only in this block
            System.out.println(x + y);  // OK
        }
        
        System.out.println(x);  // OK
        System.out.println(y);  // ERROR: y not in scope
        
        if (true) {
            int z = 20;  // Exists only in if block
            System.out.println(z);  // OK
        }
        System.out.println(z);  // ERROR: z not in scope
    }
}
```

### 5.2 Loop Scope

Variables declared in a loop exist only in that loop:

```java
public class Example {
    public void demo() {
        for (int i = 0; i < 5; i++) {
            int x = i * 2;  // i and x exist only in loop
            System.out.println(x);
        }
        
        System.out.println(i);  // ERROR: i not in scope
        System.out.println(x);  // ERROR: x not in scope
    }
}
```

## 6. Parameter Scope

### 6.1 Parameters Are Local to Method

```java
public class Example {
    public void greet(String name, int age) {
        // 'name' and 'age' exist only in this method
        System.out.println("Hello, " + name);
        System.out.println("Age: " + age);
    }  // name and age destroyed here
    
    public void another() {
        System.out.println(name);  // ERROR: not in scope
    }
}
```

### 6.2 Parameters Hide Class Fields

If you have a parameter and field with similar names, use `this`:

```java
public class Student {
    private String name;  // Field
    
    public void setName(String name) {  // Parameter: same name!
        // Which 'name'? The parameter or the field?
        this.name = name;  // Use 'this' to specify field
    }
}
```

## 7. Shadowing

**Shadowing** occurs when a variable declared in an inner scope has the same name as a variable in an outer scope.

### 7.1 Shadowing Example

```java
public class Example {
    private int x = 5;  // Field x
    
    public void demo() {
        int x = 10;  // Local variable x (shadows field)
        
        System.out.println(x);        // 10 (local x)
        System.out.println(this.x);   // 5  (field x)
        
        if (true) {
            int x = 20;  // Another local x (shadows outer x)
            System.out.println(x);    // 20
        }
        
        System.out.println(x);        // 10 (back to method's x)
    }
}
```

### 7.2 Avoiding Shadowing

Best practice: don't create confusing names.

**Bad (shadowing):**
```java
public void setData(int data) {
    int data = 10;  // ERROR: already have parameter 'data'
}
```

**Good (different names):**
```java
public void setData(int newData) {
    this.data = newData;
}
```

## 8. Scope in Complex Classes

### 8.1 Complete Example: Rectangle Class

```java
public class Rectangle {
    // Class scope: accessible in all methods
    private double width;
    private double height;
    
    public Rectangle(double w, double h) {
        // Parameters: method scope only
        width = w;      // Can access field
        height = h;
    }
    
    public double getArea() {
        // No parameters
        return width * height;  // Access fields
    }
    
    public void printDimensions() {
        // Local variable: block scope
        String info = "Width: " + width + ", Height: " + height;
        System.out.println(info);
    }  // info is destroyed here
    
    public void resize(double factor) {
        // Parameter: method scope
        width = width * factor;    // Modify field using parameter
        height = height * factor;
    }
    
    public void demo() {
        if (width > height) {
            double temp = width;  // Local: exists only in if block
            width = height;
            height = temp;
        }  // temp destroyed here
    }
}
```

### 8.2 Accessing Fields from Methods

```java
public class Student {
    private String name;
    private double gpa;
    
    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    
    public void printInfo() {
        // Accessing fields from another method
        System.out.println("Name: " + name);    // Access field
        System.out.println("GPA: " + gpa);      // Access field
    }
    
    public String getDetails() {
        // Can access fields from any method
        return name + " has GPA " + gpa;
    }
}
```

## 9. Scope with Static vs. Instance

### 9.1 Static Field Scope

```java
public class Student {
    private static int totalStudents = 0;  // Class scope (static)
    private String name;                   // Instance scope
    
    public Student(String name) {
        this.name = name;
        totalStudents++;  // Access static field
    }
    
    public static int getTotalStudents() {
        return totalStudents;  // Access static field
        // return name;  // ERROR: can't access instance field
    }
    
    public String getName() {
        return name;  // Access instance field
        // Can also access static field
        System.out.println(totalStudents);  // OK
    }
}
```

### 9.2 Scope Rules for Static

| Can Access | From Static Method | From Instance Method |
|---|---|---|
| Static fields | ✓ Yes | ✓ Yes |
| Instance fields | ✗ No | ✓ Yes |
| `this` | ✗ No | ✓ Yes |
| Parameters | ✓ Yes | ✓ Yes |
| Local variables | ✓ Yes | ✓ Yes |

## 10. Best Practices for Scope and Access

### 10.1 Make Fields Private

```java
// Bad: fields are public
public class Student {
    public String name;
    public double gpa;
}

// Anyone can modify directly
Student s = new Student();
s.gpa = -5;  // Invalid! No validation

// Good: fields are private
public class Student {
    private String name;
    private double gpa;
    
    public void setGpa(double gpa) {
        if (gpa >= 0 && gpa <= 4.0) {
            this.gpa = gpa;  // Validated
        }
    }
}
```

### 10.2 Minimize Variable Scope

```java
// Bad: variable scope too large
public void process() {
    int result = 0;
    
    // 50 lines of code...
    
    for (int i = 0; i < 10; i++) {
        result = i * 2;
    }
}

// Good: variable scope is minimal
public void process() {
    // 50 lines of code...
    
    for (int i = 0; i < 10; i++) {
        int result = i * 2;  // Created here, used here
    }
}
```

### 10.3 Use Access Modifiers Correctly

```java
public class BankAccount {
    private double balance;        // Private: internal
    private void validateAmount(double amt) {  // Private: internal
        // ...
    }
    
    public void deposit(double amount) {  // Public: interface
        validateAmount(amount);
        balance += amount;
    }
    
    public double getBalance() {   // Public: interface
        return balance;
    }
}
```

## 11. Scope and Access in Real Programs

### 11.1 Library System Example

```java
public class Book {
    // Private fields: internal implementation
    private String title;
    private String author;
    private String isbn;
    private boolean isCheckedOut;
    
    // Public interface: what users interact with
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isCheckedOut = false;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void checkout() {
        isCheckedOut = true;
    }
    
    public void returnBook() {
        isCheckedOut = false;
    }
    
    public boolean isAvailable() {
        return !isCheckedOut;
    }
}

public class Library {
    // Private field: implementation detail
    private Book[] books;
    
    public Library(int capacity) {
        books = new Book[capacity];
    }
    
    // Public methods: interface
    public void addBook(Book b) {
        // ...
    }
    
    public Book findBook(String title) {
        // ...
    }
}
```

### 11.2 Separation of Concerns

Library users see only public methods. Internal details (private fields and methods) are hidden:

```
┌─────────────────────┐
│ Public Interface    │
│ addBook()           │
│ findBook()          │
│ borrowBook()        │
└─────────────────────┘
         ↓
┌─────────────────────┐
│ Private Details     │
│ searchByISBN()      │
│ updateIndex()       │
│ validateBook()      │
└─────────────────────┘
```

## 12. Debugging Scope Issues

### 12.1 Problem: Variable Not in Scope

**Error:**
```java
public class Example {
    public void method1() {
        int x = 5;
    }
    
    public void method2() {
        System.out.println(x);  // ERROR: x not in scope
    }
}
```

**Solution:** Variables are local to their method. To access elsewhere, use a field:

```java
public class Example {
    private int x;  // Field: accessible in all methods
    
    public void method1() {
        x = 5;
    }
    
    public void method2() {
        System.out.println(x);  // OK: x is a field
    }
}
```

### 12.2 Problem: Accessing Private Members

**Error:**
```java
public class Student {
    private String name;
}

Student s = new Student();
System.out.println(s.name);  // ERROR: private field
```

**Solution:** Use public getter:

```java
public class Student {
    private String name;
    
    public String getName() {
        return name;
    }
}

Student s = new Student();
System.out.println(s.getName());  // OK: public method
```

### 12.3 Problem: Shadowing Confusion

**Error:**
```java
public class Example {
    private int count = 5;
    
    public void reset(int count) {
        count = 0;  // Sets parameter, not field!
    }
}

Example ex = new Example();
ex.reset(10);
System.out.println(ex.count);  // Still 5! Unexpected
```

**Solution:** Use `this` to specify field:

```java
public class Example {
    private int count = 5;
    
    public void reset(int count) {
        this.count = 0;  // Now sets field
    }
}

Example ex = new Example();
ex.reset(10);
System.out.println(ex.count);  // 0. Correct!
```

## Key Takeaways
- Scope determines where a variable is visible and how long it exists
- Block scope: variables exist only in their `{}` block
- Method scope: parameters exist only in the method
- Class scope: fields are visible in all methods of the class
- Static scope: static variables exist for the entire program
- Lifetime: local variables are created and destroyed with their scope
- Access modifiers control visibility: `private` hides implementation, `public` shows interface
- Fields should be `private`; methods should be `public` (unless they're internal helpers)
- `this` refers to the current object and helps distinguish fields from parameters
- Shadowing occurs when an inner scope variable has the same name as an outer scope variable
- Static methods cannot access instance fields; instance methods can access static fields
- Encapsulation: hide internal details (`private`) and show only necessary interface (`public`)
- Minimize variable scope to make code clearer and reduce errors

## Practice Problems

1) **Block Scope**: Explain what happens in this code. What will print, and what will cause errors?
```java
public void demo() {
    int x = 5;
    if (true) {
        int y = 10;
        System.out.println(x + y);
    }
    System.out.println(x);
    System.out.println(y);  // ?
}
```

2) **Variable Lifetime**: When does each variable exist and when is it destroyed?
```java
public void method(int param) {
    int local = 5;
    for (int i = 0; i < 10; i++) {
        int temp = i * 2;
    }
}
```

3) **Field vs. Local**: Identify which variables are fields and which are local:
```java
public class Example {
    private int x;
    
    public void method() {
        int y = 5;
    }
}
```

4) **Private vs. Public**: Write a class with a private field and provide public getter and setter methods.

5) **Parameter Scope**: Explain why the parameter `name` only exists inside the method:
```java
public void setName(String name) {
    this.name = name;
}
```

6) **Using `this`**: Explain what `this` means and why it's useful in this code:
```java
public void setData(int data) {
    this.data = data;
}
```

7) **Shadowing**: What does this code print? Explain the difference between local and field variables:
```java
public class Example {
    private int x = 5;
    
    public void demo() {
        int x = 10;
        System.out.println(x);
        System.out.println(this.x);
    }
}
```

8) **Static vs. Instance Scope**: Why can't a static method access instance fields?

9) **Encapsulation**: Design a `Temperature` class with a private field and public methods to get/set the temperature in Celsius. Add validation to ensure temperature is realistic.

10) **Access Control**: Identify what's public interface and what's private implementation in a `Calculator` class.

11) **Loop Scope**: What's wrong with this code? How would you fix it?
```java
for (int i = 0; i < 10; i++) {
    int result = i * 2;
}
System.out.println(result);  // ERROR
```

12) **Challenge - BankAccount Security**: Design a `BankAccount` class that:
    - Has private fields for balance and PIN
    - Has public methods to check balance and withdraw (requires PIN)
    - Has private helper method to validate PIN
    - Explain why each member is public or private

13) **Challenge - Scope Analysis**: Trace through this code and identify all variable scopes:
```java
public class ComplexExample {
    private int field = 1;
    private static int staticField = 2;
    
    public void outerMethod(int param) {
        int local = 3;
        if (true) {
            int blockLocal = 4;
            System.out.println(field);
            System.out.println(param);
            System.out.println(local);
            System.out.println(blockLocal);
        }
    }
    
    public static void staticMethod() {
        System.out.println(staticField);
    }
}
```

14) **Challenge - Good vs. Bad Design**: Compare two approaches and explain which is better and why:
```java
// Approach 1: Public fields
public class Student {
    public String name;
    public double gpa;
}

// Approach 2: Private fields with methods
public class Student {
    private String name;
    private double gpa;
    
    public void setGpa(double newGpa) {
        if (newGpa >= 0 && newGpa <= 4.0) {
            gpa = newGpa;
        }
    }
    
    public double getGpa() {
        return gpa;
    }
}
```
