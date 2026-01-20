# Unit 3.5 — Writing and Using Methods

## Learning Goals
By the end of this unit, you will:
- Understand method syntax and structure
- Write methods with parameters and return values
- Distinguish between void methods and methods that return values
- Use method return values in your code
- Write methods that work together to solve problems
- Follow method naming conventions and best practices
- Understand scope and how variables work inside methods
- Design methods that are clear, reusable, and maintainable
- Call methods from other classes
- Debug common method-related problems

## 1. What Methods Do

A **method** is a reusable block of code that performs a specific task.

**Methods are useful because they:**
- Avoid code repetition (write once, use many times)
- Make programs easier to understand and maintain
- Allow code to be organized and modular
- Enable teamwork (different people write different methods)

## 2. Method Structure

### 2.1 Method Syntax

```java
public returnType methodName(parameter1, parameter2) {
    // Method body: code that does something
    return value;
}
```

### 2.2 Method Components

```java
public boolean isHonorStudent(double gpa) {
    return gpa >= 3.5;
}
```

| Part | Name | Example | Purpose |
|---|---|---|---|
| `public` | Access modifier | `public` | Who can call this method |
| `boolean` | Return type | `boolean` | Type of value returned |
| `isHonorStudent` | Method name | `isHonorStudent` | What the method does |
| `(double gpa)` | Parameters | `double gpa` | Input the method receives |
| `return gpa >= 3.5;` | Return statement | `return gpa >= 3.5;` | Value sent back to caller |

## 3. Void Methods (No Return Value)

**Void methods** perform an action but don't return a value.

### 3.1 Simple Void Method

```java
public class Student {
    private String name;
    
    public void printName() {
        System.out.println(name);
    }
}
```

Using it:
```java
Student s = new Student("Alice");
s.printName();  // Prints: Alice
```

### 3.2 Void Method with Parameters

```java
public class Student {
    private String name;
    private int gradeLevel;
    
    public void study(int hours) {
        System.out.println(name + " studied for " + hours + " hours");
    }
}
```

Using it:
```java
Student s = new Student("Bob", 10);
s.study(3);  // Prints: Bob studied for 3 hours
s.study(5);  // Prints: Bob studied for 5 hours
```

### 3.3 Void Method with Multiple Parameters

```java
public class Rectangle {
    private double width;
    private double height;
    
    public void setDimensions(double w, double h) {
        width = w;
        height = h;
    }
}
```

Using it:
```java
Rectangle r = new Rectangle();
r.setDimensions(10.5, 8.0);
```

## 4. Methods with Return Values

**Methods that return values** give data back to the caller.

### 4.1 Simple Return Method

```java
public class Rectangle {
    private double width;
    private double height;
    
    public double getArea() {
        return width * height;
    }
}
```

Using it:
```java
Rectangle r = new Rectangle(10, 5);
double area = r.getArea();  // Gets 50
System.out.println(area);   // Prints: 50.0
```

### 4.2 Return Type Matters

The return type must match what you return:

```java
public int countLetters(String word) {
    return word.length();  // Returns an int
}

public String getFullName(String first, String last) {
    return first + " " + last;  // Returns a String
}

public boolean isEven(int number) {
    return number % 2 == 0;  // Returns a boolean
}
```

### 4.3 Using Return Values

```java
String result = getFullName("John", "Smith");
System.out.println(result);  // Prints: John Smith

if (isEven(4)) {
    System.out.println("4 is even");  // This prints
}

int letters = countLetters("hello");
System.out.println(letters);  // Prints: 5
```

## 5. Method Parameters

**Parameters** are inputs to a method. Each parameter has a type and name.

### 5.1 No Parameters

```java
public String getName() {
    return name;
}
```

### 5.2 One Parameter

```java
public void setName(String name) {
    this.name = name;
}
```

### 5.3 Multiple Parameters

```java
public void setInfo(String name, int age, String email) {
    this.name = name;
    this.age = age;
    this.email = email;
}
```

Using it:
```java
setInfo("Alice", 16, "alice@email.com");
```

### 5.4 Passing Objects as Parameters

```java
public class ClassRoom {
    public void seatStudent(Student s) {
        System.out.println("Seating " + s.getName());
    }
}
```

Using it:
```java
Student alice = new Student("Alice");
ClassRoom room = new ClassRoom();
room.seatStudent(alice);
```

## 6. Method Design

### 6.1 Do One Thing Well

**Bad (does too much):**
```java
public void processAndDisplayStudent(String name, int grade, double gpa) {
    // Validate input
    if (grade < 9 || grade > 12) return;
    // Calculate status
    boolean isHonor = gpa >= 3.5;
    // Print output
    System.out.println(name + ": Grade " + grade + ", Honor: " + isHonor);
    // Update database
    // ...
}
```

**Good (each method does one thing):**
```java
public boolean isValidGrade(int grade) {
    return grade >= 9 && grade <= 12;
}

public boolean isHonorStudent(double gpa) {
    return gpa >= 3.5;
}

public String getStudentStatus(String name, int grade, double gpa) {
    return name + ": Grade " + grade + ", Honor: " + isHonorStudent(gpa);
}
```

### 6.2 Use Clear Parameter Names

**Bad:**
```java
public double calc(double x, double y) {
    return x + y;
}
```

**Good:**
```java
public double calculateSum(double num1, double num2) {
    return num1 + num2;
}
```

### 6.3 Use Descriptive Method Names

**Bad:**
```java
public void do1() { ... }
public int get2() { ... }
public void process() { ... }
```

**Good:**
```java
public void sendEmail() { ... }
public int calculateGrade() { ... }
public void validateInput() { ... }
```

## 7. Getters and Setters

**Getters** return field values. **Setters** change field values.

### 7.1 Basic Getters and Setters

```java
public class Person {
    private String name;
    private int age;
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
```

### 7.2 Setters with Validation

```java
public class Person {
    private String name;
    private int age;
    
    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
        // If invalid, don't change it
    }
}
```

### 7.3 Computed Getters

Sometimes getters compute a value rather than just returning a field:

```java
public class Rectangle {
    private double width;
    private double height;
    
    // Not a field—computed on demand
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
```

## 8. Methods Calling Methods

Methods can call other methods to break down complex tasks.

### 8.1 Simple Example

```java
public class Student {
    private String name;
    private int[] grades;
    
    public double getAverage() {
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.length;
    }
    
    public boolean isHonorStudent() {
        return getAverage() >= 3.5;  // Calls getAverage()
    }
    
    public String getStatus() {
        if (isHonorStudent()) {  // Calls isHonorStudent()
            return "Honor Student";
        } else {
            return "Regular Student";
        }
    }
}
```

### 8.2 Building Complexity

```java
public class ShoppingCart {
    private Item[] items;
    
    public double getSubtotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
    
    public double getTax() {
        return getSubtotal() * 0.08;  // Calls getSubtotal()
    }
    
    public double getTotal() {
        return getSubtotal() + getTax();  // Calls other methods
    }
}
```

## 9. Variable Scope

**Scope** determines where a variable can be used.

### 9.1 Field Scope

Fields are accessible to all methods in the class:

```java
public class Student {
    private String name;  // Field scope: accessible to all methods
    
    public String getName() {
        return name;  // Can use name
    }
    
    public void printName() {
        System.out.println(name);  // Can use name
    }
}
```

### 9.2 Parameter Scope

Parameters exist only within the method:

```java
public class Math {
    public int add(int a, int b) {  // a and b exist here
        return a + b;
    }
    
    public void test() {
        int result = add(5, 3);
        // a and b don't exist here
        System.out.println(result);  // But result does
    }
}
```

### 9.3 Local Variable Scope

Local variables exist only within the block where they're declared:

```java
public class Example {
    public void demo() {
        int x = 5;  // x exists here
        
        if (x > 0) {
            int y = 10;  // y exists only in this block
            System.out.println(x + y);  // Works
        }
        
        // y doesn't exist here
        System.out.println(x);  // Works
        // System.out.println(y);  // ERROR
    }
}
```

## 10. Complete Example: BankAccount Class

```java
public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;
    
    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }
    
    // Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Setter methods
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    // Action methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Cannot withdraw: insufficient funds");
            return false;
        }
    }
    
    public void printStatement() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Owner: " + owner);
        System.out.println("Balance: $" + balance);
    }
    
    public String getInfo() {
        return owner + "'s account: $" + balance;
    }
}
```

Using the class:
```java
BankAccount account = new BankAccount("12345", "Alice", 1000);

account.deposit(500);      // Deposited: $500
account.withdraw(200);     // Withdrew: $200
account.printStatement();  // Prints account information
System.out.println(account.getInfo());  // Prints: Alice's account: $1300
```

## 11. Method Best Practices

### 11.1 Keep Methods Small

**Long method (hard to understand):**
```java
public void processOrder(Order order) {
    // 50+ lines of code doing everything
    validateOrder();
    calculateTax();
    calculateShipping();
    applyDiscount();
    updateInventory();
    // ... etc
}
```

**Small methods (easier to understand):**
```java
public void processOrder(Order order) {
    validateOrder(order);
    double total = calculateTotal(order);
    updateInventory(order);
    confirmOrder(order, total);
}
```

### 11.2 Avoid Side Effects

**Bad (method changes unexpected things):**
```java
private int globalCount = 0;

public int calculateSum(int[] numbers) {
    int sum = 0;
    for (int n : numbers) {
        sum += n;
        globalCount++;  // Unexpected side effect!
    }
    return sum;
}
```

**Good (method only does what it says):**
```java
public int calculateSum(int[] numbers) {
    int sum = 0;
    for (int n : numbers) {
        sum += n;
    }
    return sum;
}
```

### 11.3 Use Comments for Complex Logic

```java
public double calculateGrade(int homeworkScore, int testScore) {
    // Homework is 40%, test is 60%
    double grade = (homeworkScore * 0.4) + (testScore * 0.6);
    return grade;
}
```

## 12. Common Method Patterns

### 12.1 Search Method

```java
public int findIndex(String target) {
    for (int i = 0; i < items.length; i++) {
        if (items[i].equals(target)) {
            return i;
        }
    }
    return -1;  // Not found
}
```

### 12.2 Count Method

```java
public int countOccurrences(String target) {
    int count = 0;
    for (String item : items) {
        if (item.equals(target)) {
            count++;
        }
    }
    return count;
}
```

### 12.3 Calculate Method

```java
public double calculateAverage(int[] scores) {
    int sum = 0;
    for (int score : scores) {
        sum += score;
    }
    return (double) sum / scores.length;
}
```

### 12.4 Validation Method

```java
public boolean isValidEmail(String email) {
    return email.contains("@") && email.contains(".");
}
```

## 13. Debugging Method Problems

### 13.1 Problem: Missing Return Statement

**Error:**
```java
public int getValue() {
    if (x > 0) {
        return 5;
    }
    // What if x <= 0? No return statement!
}
```

**Fix:**
```java
public int getValue() {
    if (x > 0) {
        return 5;
    } else {
        return 0;  // Always return a value
    }
}
```

### 13.2 Problem: Wrong Return Type

**Error:**
```java
public int calculateTotal() {
    return sum / count;  // Returns double, but should return int
}
```

**Fix:**
```java
public int calculateTotal() {
    return (int)(sum / count);  // Cast to int
}
```

### 13.3 Problem: Parameter Mismatch

**Error:**
```java
public void setName(String name) { ... }

setName(123);  // ERROR: passing int instead of String
```

**Fix:**
```java
setName("John");  // Pass String argument
```

## Key Takeaways
- Methods are reusable blocks of code that perform specific tasks
- Method structure includes: access modifier, return type, method name, parameters, and body
- Void methods perform actions but don't return values
- Methods with return types send values back to the caller
- Parameters are inputs to methods; each parameter has a type and name
- Getters return field values; setters change field values
- Methods can call other methods to break down complex tasks
- Variable scope determines where variables can be used
- Small, focused methods are easier to understand and maintain
- Method names should clearly describe what the method does
- Methods with validation ensure objects stay in valid states
- Comments help explain complex logic and method purpose

## Practice Problems

1) **Basic Void Method**: Write a void method for a `Dog` class called `bark()` that prints "Woof!".

2) **Void Method with Parameter**: Write a method called `feed(int amount)` for a `Dog` class that prints "The dog ate [amount] grams of food".

3) **Method with Return Value**: Write a method for a `Rectangle` class called `getArea()` that returns the area (width × height).

4) **Multiple Parameters**: Write a method called `calculateGrade(int homework, int test)` that returns homework * 0.3 + test * 0.7.

5) **Boolean Return Method**: Write a method called `isPositive(int number)` that returns true if the number is positive, false otherwise.

6) **String Return Method**: Write a method for a `Person` class called `getFullInfo()` that returns a string like "John, age 25".

7) **Parameter Validation**: Write a setter method for a `Student` class that sets age, but only accepts values between 0 and 100.

8) **Getter and Setter Pair**: Write a getter and setter for a private field `email` in a `User` class.

9) **Computed Getter**: Write a method for a `Circle` class that returns the circumference (2πr). Note: circumference is not stored as a field.

10) **Methods Calling Methods**: Write two methods: `getSubtotal()` that calculates the total price of items, and `getTotal()` that calls `getSubtotal()` and adds tax (8%).

11) **Search Method**: Write a method called `findStudent(String name)` for a `ClassRoom` class that searches an array and returns the index of the student, or -1 if not found.

12) **Challenge - String Processing**: Write a method called `countVowels(String word)` that counts how many vowels (a, e, i, o, u) are in the word and returns the count.

13) **Challenge - Object Communication**: Write two classes: `Player` and `Game`. The `Player` class should have methods to get/set score. The `Game` class should have a method that takes a `Player` object and checks if their score is over 100. Write code to demonstrate this.

14) **Challenge - Complex Method**: Design a method called `calculateGPA(int[] grades)` for a `Student` class that:
    - Validates all grades are between 0 and 100
    - Calculates the GPA (90-100=4.0, 80-89=3.0, 70-79=2.0, etc.)
    - Returns the average GPA
    - Handles edge cases (empty array, invalid grades)
