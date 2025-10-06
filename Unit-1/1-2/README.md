# Unit 1.2 Variables and Data Types

## 1. What Is a Data Type?
**Data type**: a set of possible values and the operations allowed on them. Java data types are either **primitive** or **reference**.

- Primitive types store raw values directly in memory.
- Reference types store an address (reference) that points to an object in memory.

AP CSA focuses on 3 primitive types:
1. `int` – integers (whole numbers)
2. `double` – floating point (decimal) numbers
3. `boolean` – logical values `true` / `false`

Other primitive types exist in Java (`char`, `long`, `short`, `byte`, `float`) but are not required for AP CSA.

## 2. What Is a Variable?
A **variable** is a named piece of memory that holds a value of a declared type. We use variables to store and reuse data.

How does a user control the volume of a computer? A variable can store the current volume level!  
<img src="./assets/image.png" alt="drawing" width="500"/>

### 2.1 Motivation Example (Without Variables)
Imagine getting a restaurant receipt produced by this code:
```java
System.out.println("Subtotal:");
System.out.println(38 + 40 + 30);
System.out.println("Tax:");
System.out.println((38 + 40 + 30) * .08);
System.out.println("Tip:");
System.out.println((38 + 40 + 30) * .15);
System.out.println("Total:");
System.out.println(38 + 40 + 30 +
                  (38 + 40 + 30) * .08 +
                  (38 + 40 + 30) * .15);
```

Do you find something repetitive? Tax, tip, and total all recompute the subtotal. A variable avoids repetition.

## 3. Declaring Variables
Declaration sets aside memory and associates a name with a type. You must declare before use.

Syntax:
```
type name;
```
Examples:
```java
int a;
double b;
boolean c;
String d;
```

Illustrative memory table (after declaration, before assignment):
| name | value |
|------|-------|
| a    | (unset) |
| b    | (unset) |
| c    | (unset) |
| d    | (unset) |

## 4. Assignment
Assignment stores a value into an existing variable.

Syntax:
```
name = value;
```
Examples:
```java
a = 1;
b = 2.0;
c = false;
d = "Hello world!";
```

Memory after assignment:
| name | value |
|------|-------|
| a    | 1     |
| b    | 2.0   |
| c    | false |
| d    | Hello world! |

## 5. Initialization (Declare + Assign)
You can declare and give an initial value in one statement.
```
type name = value;
```
Examples:
```java
int x = 1;
double y = 1.0 + 2.2;
```

## 6. Using Variables in Expressions
Once a value is stored, use the variable name inside expressions.
```java
int x = 5;
System.out.println("Value of x is " + x); // Value of x is 5
x = 1 + 1;
System.out.println(x + 1); // 3
```

## 7. Multiple Declarations
You can declare multiple variables of the same type on one line (use sparingly for readability).
```java
int x, y, z;
int a1 = 1, b1 = 2, c1 = 3;
```

## 8. Type Compatibility & Errors
Assigning an incompatible type causes a compile-time error.
```java
int x = 1.1; // Error: cannot convert from double to int
```
But assigning an int to a double is allowed (widening conversion):
```java
double ok = 3; // becomes 3.0
```

## 9. Reference Types (Strings & Objects)
Reference types store addresses pointing to objects. The most common AP CSA reference type is `String`.
```java
String name = "Alice";
```

## 10. Naming Rules vs. Conventions
Rules (must follow):
- Start with a letter, `_`, or `$`
- Cannot start with a digit
- No spaces or most symbols (only `_` and `$` allowed)
- Case sensitive (`score` vs `Score`)

Conventions (best practice):
- Use meaningful names: `gpa`, `subtotal`, `isValid`
- camelCase for variables: `numberOfStudents`
- Constants in ALL_CAPS with underscores: `MAX_SCORE`

Valid examples:
```java
int score;
double _average;
boolean $isActive;
```
Invalid examples:
```java
int 2ndPlace;   // starts with digit
double total-score; // hyphen not allowed
```

## 11. Primitive Types in AP CSA
### 11.1 int
Whole numbers (no decimal part):
```java
int a = 1;
int b = -10;
int c = 0;
int d = 10 + 111;
int e = a + b + c;
```

### 11.2 double
Decimal (floating point) numbers:
```java
double a = 1.0;
double b = -0.2;
double c = 1.0 + 2.0;
```

### 11.3 boolean
Logical values `true` or `false`:
```java
double gpa = 3.8;
boolean isHonorRoll = gpa > 3.5;
boolean aFlag = false;
System.out.println(isHonorRoll); // true
System.out.println(aFlag);       // false
System.out.println(4 <= 5);      // true
```

## 12. Type Casting (Converting Between Types)
Used to explicitly convert one numeric type to another.
```java
int a = 5;
double b = (double) a; // 5.0
double c = 3.7;
int d = (int) c; // 3 (fraction truncated)
int xCast = 7;
double yCast = xCast; // implicit widening
```

## 13. Default Values (Class vs Local)
Local (inside a method) variables MUST be initialized before use. Instance (field) defaults:
| Type | Default |
|------|---------|
| int / double | 0 or 0.0 |
| boolean | false |
| Reference (e.g., String) | null |
Example:
```java
class Example {
        int a;       // 0
        boolean b;   // false
        String s;    // null
        void method() {
                int x;   // must assign before use
        }
}
```

## 14. Scope and Lifetime
- Local: declared inside method/block — exist only during execution of that block.
- Instance (field): one copy per object.
- Static: one shared copy per class.
```java
public class Student {
        int age;          // instance variable
        static int count; // class variable
        public void setAge(int a) {
                int year = 2025; // local
                age = a;
        }
}
```

## 15. String Concatenation
Use `+` to combine strings and values.
```java
String name = "Alice";
int score = 95;
System.out.println(name + " scored " + score + " points.");
```

## 16. Constants (`final`)
`final` makes a variable unchangeable after it’s assigned.
```java
final double PI = 3.14;
final int MAX_SCORE = 100;
// PI = 4.2; // ERROR
```

## 17. Common Errors
- Using an uninitialized local variable
    ```java
    int x;
    System.out.println(x); // Error
    ```
- Incompatible assignment
    ```java
    int aWrong = "hello"; // Error
    ```
- Reassigning a final
    ```java
    final int MAX = 100;
    // MAX = 90; // Error
    ```

## 18. Practical Use of Constants
Useful for fixed values used in multiple expressions:
```java
final double TAX_RATE = 0.08;
final double TIP_RATE = 0.15;
```

## 19. Refactoring the Receipt Example with Variables
```java
int subtotal = 38 + 40 + 30;
double tax = subtotal * 0.08;
double tip = subtotal * 0.15;
double total = subtotal + tax + tip;

System.out.println("Subtotal: " + subtotal);
System.out.println("Tax: " + tax);
System.out.println("Tip: " + tip);
System.out.println("Total: " + total);
```

## 20. Practice
1. Declare an `int` named `count` and assign it the value 10.
2. Create a `double` named `average` initialized to the sum of 4.5 and 3.5 divided by 2.
3. Write a boolean expression that stores whether `count` is greater than 5.
4. Create a constant for maximum students (`MAX_STUDENTS = 32`).
5. Explain why `int x = 2.9;` is invalid and how to fix it.
6. Given `double z = 7;` what is its stored value? Why?
7. Convert a `double price = 19.99;` to an `int` named `wholePrice`.
8. Given `int a = 17; int b = 5;` what are the values of `a / b` and `a % b`?
9. Suppose `int slices = 23; int people = 4;`. Write two assignments so each person gets the same whole number of slices:
```java
int perPerson = // fill in
int leftover = // fill in
```
10. Store the last digit of a positive `int n` into `int lastDigit`.
11. What does this print?
```java
int x = 8;
int y = 3;
System.out.println(x / y);
System.out.println(x % y);
```
12.  Given `int totalSeconds = 125;` declare two variables: `int minutes` (whole minutes) and `int seconds` (remaining seconds) using `/` and `%`.
13.  Predict the values stored:
```java
int n = 504;
int ones = n % 10;        // ?
int tens = (n / 10) % 10; // ?
int hundreds = n / 100;   // ?
```
14.  Write a boolean expression that is true exactly when `num` is an even integer (use `%`).


## 21. Keywords (Reserved Words)
Cannot be used as variable names: `public`, `static`, `void`, `class`, `int`, `double`, `boolean`, `new`, `super`, `if`, `while`, `for`, and others.

---
By mastering these foundational concepts you build a solid base for later topics like control flow, methods, and object-oriented design.
We can declare/initialize multiple variables of the same type in a single line.

```java
int x, y, z;

int x = 1, y = 2, z = 3;
```

What if we assign incompatiable types to variables?\
Let's try to assign a double to int variable
```java
int x = 1.1; // Error!
```

But what about the reverse?
```java
double x = 3;
System.out.println(x); // 3.0
```

## Practice
Now back to the receipt question, how can we optimize the code with variables?
```java
System.out.println("Subtotal:");
System.out.println(38 + 40 + 30);
System.out.println("Tax:");
System.out.println((38 + 40 + 30) * .08);
System.out.println("Tip:");
System.out.println((38 + 40 + 30) * .15);
System.out.println("Total:");
System.out.println(38 + 40 + 30 +
                  (38 + 40 + 30) * .08 +
                  (38 + 40 + 30) * .15);
```

#### Answer
```java
int subtotal = 38 + 40 + 30;
double tax = subtotal * 0.08;
double tip = subtotal * 0.15;
double total = subtotal + tax + tip;

System.out.println("Subtotal: " + subtotal);
System.out.println("Tax: " + tax);
System.out.println("Tip: " + tip);
System.out.println("Total: " + total);
```
