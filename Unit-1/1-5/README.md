# Unit 1.5 Methods (Basics)

Methods let us break a big task into smaller reusable pieces. You have already SEEN one method every time you wrote a program:
```java
public static void main(String[] args) { }
```
In this unit we learn how to WRITE and CALL our own methods (still staying outside of full OOP design). Think of a method as a mini‑program with:
1. A name
2. (Optional) inputs (called parameters)
3. (Optional) a returned output (using `return`)
4. A body (the statements it performs)

## 1. Motivation: Repetition & Clarity
Suppose we want to print the perimeter and area of several rectangles:
```java
int w1 = 5, h1 = 2;
int w2 = 7, h2 = 4;
int w3 = 10, h3 = 3;
System.out.println("Rect 1 area=" + (w1 * h1) + " perim=" + (2 * (w1 + h1)));
System.out.println("Rect 2 area=" + (w2 * h2) + " perim=" + (2 * (w2 + h2)));
System.out.println("Rect 3 area=" + (w3 * h3) + " perim=" + (2 * (w3 + h3)));
```
Repeated logic = harder to read & maintain. A method centralizes that logic:
```java
printRectangleInfo(5, 2);
printRectangleInfo(7, 4);
printRectangleInfo(10, 3);
```
Much cleaner!

## 2. Defining a Method (Void Version)
Structure (we'll keep `public static` for now; meaning will be revisited later):
```
public static void methodName(parameterList) {
    // statements
}
```
Example:
```java
public static void printRectangleInfo(int width, int height) {
    int area = width * height;
    int perimeter = 2 * (width + height);
    System.out.println("Area=" + area + " Perimeter=" + perimeter);
}
```
`void` means this method does NOT return a value; it just performs an action (printing).

## 3. Calling a Method
Use its name followed by parentheses with arguments in order:
```java
printRectangleInfo(5, 2);
printRectangleInfo(10, 10);
```
Arguments must match parameter types and order.

## 4. Parameters vs. Arguments
- Parameter: variable declared in the method header (e.g., `int width`).
- Argument: actual value you pass when calling (`5`).
Parameters act like local variables whose values are copies of the arguments.

### Example (Tracing)
```java
printSum(3, 4);
printSum(10, -2);

public static void printSum(int a, int b) {
    int s = a + b;
    System.out.println("Sum=" + s);
}
```
Call 1: `a=3`, `b=4`, prints `Sum=7`.  
Call 2: `a=10`, `b=-2`, prints `Sum=8`.

## 5. Return Methods (Producing a Value)
Sometimes we want to compute a value and use it later instead of printing immediately.
Structure:
```
public static returnType methodName(parameters) {
    // compute something
    return value; // value must match returnType
}
```
Example:
```java
public static int rectangleArea(int w, int h) {
    int area = w * h;
    return area; // or: return w * h;
}
```
Using it:
```java
int a1 = rectangleArea(5, 2); // 10
int a2 = rectangleArea(7, 4); // 28
System.out.println(a1 + a2);  // 38
```
A `return` statement immediately exits the method.

## 6. Why Return Instead of Print?
Return separates CALCULATION from DISPLAY. This lets you:
- Reuse results in bigger expressions
- Decide later HOW to present the value
- Unit test logic (later) more easily

Bad (locks logic to printing):
```java
public static void printDouble(int x) {
    System.out.println(x * 2);
}
```
Better:
```java
public static int doubleValue(int x) {
    return x * 2;
}
System.out.println(doubleValue(7));
int y = doubleValue(10) + 5; // 25
```

## 7. More Examples
### a. Average of Three
```java
public static double average3(double a, double b, double c) {
    return (a + b + c) / 3.0;
}
```
### b. Last Digit
```java
public static int lastDigit(int n) {
    return n % 10; // assumes n >= 0
}
```
### c. Fahrenheit to Celsius
```java
public static double fToC(double f) {
    return (f - 32) * 5.0 / 9.0;
}
```
### d. Is Even
```java
public static boolean isEven(int n) {
    return n % 2 == 0;
}
```

## 8. Standard Library Methods (Calling Existing Ones)
You have already used `System.out.println()` which calls the `println` method. Java provides many reusable methods, especially in `Math`.
Examples:
```java
int max = Math.max(10, 25);      // 25
int min = Math.min(-2, 5);       // -2
double root = Math.sqrt(16);    // 4.0
double pow = Math.pow(2, 3);    // 8.0
long rounded = Math.round(3.6);  // 4
```
We call library methods the same way: `ClassName.methodName(arguments)`.
(No need to write them ourselves.)

## 9. Multiple Returns & Early Exit
You can return early based on conditions (we haven't formally introduced `if` yet; preview):
```java
public static int bigger(int a, int b) {
    if (a >= b) {
        return a;
    }
    return b; // executes only if first return didn't run
}
```
(Conditional logic will be covered in the next unit; for now just note only one return executes.)

## 10. Procedural Abstraction
Procedural abstraction means focusing on *what* a method does, not *how* it does it internally. Once a method is written and tested, you can treat it like a black box: give inputs (arguments) and trust the output (return value or side effect) without re-reading its implementation every time.

Benefits:
- Hides complexity: `average3(a,b,c)` is clearer than rewriting the formula
- Encourages reuse across different parts of a program
- Simplifies reasoning and testing (test the method once, then rely on it)
- Improves readability of higher-level logic (your `main` reads like a story)

Good abstraction guidelines:
- Name expresses purpose at the right level (not implementation details)
- Single responsibility inside each method
- Return a value instead of printing when the result might be reused

Example (without abstraction):
```java
double g = (m1 * m2 * 6.67e-11) / (d * d);
System.out.println(g);
```
Improved with a clear method:
```java
double force = gravitationalForce(m1, m2, d);
System.out.println(force);

public static double gravitationalForce(double m1, double m2, double distance) {
    final double G = 6.67e-11;
    return (m1 * m2 * G) / (distance * distance);
}
```
You can now reuse or replace the internal formula without touching the calling code.

## 10. Method Design Guidelines
| Goal | Guideline |
|------|-----------|
| Clarity | Use descriptive names: `sumOdds`, `averageScore` |
| Single Purpose | One logical task per method |
| Reuse | Prefer returning values over printing inside, unless printing is the purpose |
| Parameter Order | From most general to most specific, or natural reading order |
| Avoid Magic Numbers | Use parameters or constants |
| Abstraction | Hide details; the caller should not care *how* result is produced |

## 11. Common Mistakes
| Mistake | Example | Fix |
|---------|---------|-----|
| Missing return in non-void | `public static int foo(){ int x=5; }` | Add `return x;` |
| Wrong return type | `public static int area(double r){ return 2 * Math.PI * r; }` (circumference) | Make method name reflect result OR change return calculation |
| Printing instead of returning | `void average(){ System.out.println(sum/3); }` | Change to `double average(..)` and return value |
| Using undeclared variable | `return result;` without defining `result` | Declare & assign first |
| Parameter shadow confusion | Reusing names—keep it simple | Distinct, meaningful names |

## 12. Putting It Together (Mini Example)
Goal: Read three test scores and print both their average and the highest.
```java
import java.util.Scanner;

public class Scores {
    public static double average3(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }
    public static double max3(double a, double b, double c) {
        double max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter three scores: ");
        double s1 = in.nextDouble();
        double s2 = in.nextDouble();
        double s3 = in.nextDouble();
        double avg = average3(s1, s2, s3);
        double top = max3(s1, s2, s3);
        System.out.println("Average=" + avg);
        System.out.println("Highest=" + top);
    }
}
```

## 13. Documenting Methods (Comments & Javadoc)
Why document methods? Clear documentation states a method's purpose, expected inputs, and output without forcing someone to read every line of the body.

### 13.1 Types of Comments
- Inline comment (after a statement):
    ```java
    int area = w * h; // rectangle area in square units
    ```
- Block comment (multiple lines) for a longer note.
- Javadoc (structured) comment placed immediately before a method to generate documentation.

### 13.2 Javadoc Structure
```java
/**
 * Returns the average of three numbers.
 * @param a first value
 * @param b second value
 * @param c third value
 * @return arithmetic mean of a, b, and c
 */
public static double average3(double a, double b, double c) {
        return (a + b + c) / 3.0;
}
```
Tags you will commonly use now:
- `@param name description`
- `@return description` (omit for `void` methods)

### 13.3 Good Style (WHAT, not HOW)
Start with a short verb phrase:
- Good: "Returns the last digit of n."
- Avoid: "This method is used to return the last digit of n." (extra words)
Avoid documenting the obvious if the name is perfectly clear (`sum(int a, int b)` usually needs no sentence beyond a param clarification if needed).

### 13.4 Preconditions / Assumptions
If inputs must satisfy conditions, state them:
```java
/**
 * Returns the last digit of a non-negative integer n.
 * @param n a non-negative integer
 * @return n % 10
 */
public static int lastDigit(int n) { return n % 10; }
```
If no special assumption, you can skip.

### 13.5 Documenting Void vs Return Methods
For `void` methods that perform an action (like printing):
```java
/**
 * Prints a greeting in the form: Hello, <name>!
 * @param name the name to greet
 */
public static void greeting(String name) {
        System.out.println("Hello, " + name + "!");
}
```
Return methods focus on the value contract (what is returned and under what conditions).

### 13.6 When to Skip Javadoc
Super short, obvious helpers with self‑explanatory names sometimes only need clear naming. Don't add noise comments that just restate code.

### 13.7 Common Documentation Mistakes
| Mistake | Problem | Better |
|---------|---------|--------|
| Explains algorithm line-by-line | Becomes outdated after changes | Describe purpose & contract |
| Omits parameter meaning | Ambiguous inputs | Add concise meaning / units |
| Restates method name only | No extra information | Clarify edge cases or assumptions |
| No units for numeric values | Misinterpretation | Include units: "distance in kilometers" |

### 13.8 AP CSA Relevance
Formal Javadoc generation isn't required on the exam, but clearly communicating a method's purpose improves scoring on free-response and helps you avoid logic errors.

## 14. Method Signature
The *method signature* in Java consists of the method name + the ordered list of parameter types. It does **not** include the return type or the parameter variable names. (Access modifiers like `public` and keywords like `static` are outside the signature for overload matching.)

Example:
```java
public static int max(int a, int b) { ... }
public static double max(double x, double y) { ... }
```
Signatures here are:
- `max(int, int)`
- `max(double, double)`

Return types differ? That alone is NOT enough to create a different signature. You cannot have:
```java
public static int foo(int x) { return x; }
public static double foo(int x) { return x; } // ERROR – same signature
```

Why care now? Recognizing signatures helps you understand how the same method name can adapt to different argument types (overloading).

## 15. Method Overloading (Preview)
**Method overloading** is defining multiple methods with the same name but different parameter lists (different number or types or order of types). Java chooses the most specific match based on the arguments you pass.

You already used overloaded methods without realizing it: `System.out.println` works for `int`, `double`, `String`, etc.

Examples:
```java
public static int add(int a, int b) { return a + b; }
public static double add(double a, double b) { return a + b; }
public static int add(int a, int b, int c) { return a + b + c; }
```
Each has a unique signature:
- `add(int, int)`
- `add(double, double)`
- `add(int, int, int)`

Java decides which one to call at compile time:
```java
System.out.println(add(3, 4));      // uses int,int version
System.out.println(add(3.0, 4.5));  // uses double,double version
System.out.println(add(1,2,3));     // uses int,int,int version
```
Why overloading? Clarity + grouping related operations under one conceptual name. Keep it simple—avoid confusing overloads that differ only subtly.

Rules snapshot:
- Parameter count OR at least one parameter type must differ
- Return type alone cannot distinguish
- Varargs (later) also count as different parameter lists

## 16. Practice (Write or Predict)
1. Write a method `square(int n)` returning `n * n`.
2. Write a method `sumRange(int a, int b)` that returns the sum of the two numbers (just `a + b` for now—loops come later). Call it with 5 and 11.
3. Write a method `greeting(String name)` that prints `Hello, <name>!` (void method). Call it twice with two different names.
4. Predict output:
```java
public static int mystery(int a, int b) {
    int x = a * 2;
    int y = b + 3;
    return x - y;
}
System.out.println(mystery(3, 4));
System.out.println(mystery(10, -2));
```
5. Write a method `lastTwoDigits(int n)` returning the last two digits (assume `n >= 10`).
6. Write a method `toHours(int totalMinutes)` returning whole hours (`totalMinutes / 60`).
7. Write a method `remainingMinutes(int totalMinutes)` returning leftover minutes (`totalMinutes % 60`). Use both to convert 135 minutes.
8. Write a method `average2(int a, int b)` returning a `double` average. Why should you cast?
9. Write a method `abs(int n)` returning the absolute value (preview: use `if` or `Math.abs`).
10. Challenge: `percent(int part, int whole)` returns a double percentage (0–100). Use: `(part * 100.0) / whole`.
 11. Overloading practice: Write two `printLine` methods—one taking an `int count` and printing that many dashes, another taking a `String s` and printing it surrounded by dashes (e.g., `--Hello--`). Explain their signatures.

