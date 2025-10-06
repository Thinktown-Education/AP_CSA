# Unit 1.4 Input

Starting in 2025, the AP Computer Science A curriculum explicitly emphasizes reading user input. In Java, interactive console input is almost always done with the `Scanner` class. This section gives you everything you need to correctly and safely read input for AP CSA problems.

## 1. Why Input Matters
Up to now, your programs may have only printed output. Input lets the program respond to user-provided data instead of hard‑coding values. Many FRQ style problems simulate processing values that could (in a real setting) come from input.

## 2. The `Scanner` Class Overview
`Scanner` is a utility class in `java.util` used to parse text into tokens (pieces) separated by whitespace (spaces, tabs, newlines) or custom delimiters.

Key abilities relevant to AP CSA:
- Read numbers: `int`, `double`
- Read single word tokens: `String` (via `next()`)
- Read whole lines: `String` (via `nextLine()`)
- Mix numeric and string input (careful with line breaks!)

## 3. Importing Scanner
Add an import at the very top of your file (before the class definition):
```java
import java.util.Scanner;
```
If you forget this, you will get an error: `cannot find symbol: class Scanner`.

## 4. Creating a Scanner for Keyboard Input
You typically attach a `Scanner` to standard input (`System.in`).
```java
Scanner in = new Scanner(System.in);
```
`in` is a common variable name (short for input). You can choose another, but stay consistent.

## 5. Closing a Scanner (AP CSA Guidance)
Calling `in.close()` also closes `System.in`, which you usually should NOT do if there may be more input later in the program runtime. For small AP exam style programs, you may omit closing the scanner. (College Board will not penalize you for leaving it open in short examples.)

## 6. Core Input Methods You Must Know
| Method | Returns | Reads | Stops At | Notes |
|--------|---------|-------|----------|-------|
| `nextInt()` | `int` | next integer token | whitespace after number | Fails if token is not a valid int |
| `nextDouble()` | `double` | next floating point token | whitespace | Accepts forms like `3.14`, `10`, `0.5` |
| `next()` | `String` | next token (word) | whitespace | Does NOT read spaces |
| `nextLine()` | `String` | entire remainder of current line (may be empty) | newline | Consumes the line break |

Example:
```java
int age = in.nextInt();
double price = in.nextDouble();
String firstName = in.next();
String wholeLine = in.nextLine();
```

## 7. The Tricky Part: Mixing `nextInt()` / `nextDouble()` With `nextLine()`
`nextInt()` and similar methods leave the newline character sitting in the input buffer; the next call to `nextLine()` will read just that leftover newline and return an empty string.

Problem example:
```java
System.out.print("Enter age: ");
int age = in.nextInt(); // user types: 17⏎
System.out.print("Enter full name: ");
String name = in.nextLine(); // returns "" (just consumes leftover newline)
```

Solution: consume the rest of the line AFTER reading a number BEFORE using `nextLine()`:
```java
int age = in.nextInt();
in.nextLine(); // clear the leftover newline
String name = in.nextLine();
```

## 8. Prompting the User
Always make clear what the user should type:
```java
System.out.print("Enter width: ");
int width = in.nextInt();
System.out.print("Enter height: ");
int height = in.nextInt();
System.out.println("Area = " + (width * height));
```

Use `print` (not `println`) for prompts when you want the cursor to remain on the same line as the user's input.

## 9. Basic Data Validation (Conceptual)
AP CSA does not require robust error handling. If the user types something invalid (e.g., a word when `nextInt()` is expected) the program will throw an exception and stop. For exam purposes you can assume well‑formed input unless the prompt specifies otherwise.

## 10. Converting Between Types After Input
Sometimes you read a token as one type and convert it:
```java
int x = in.nextInt();
double asDouble = x;      // widening conversion
double d = in.nextDouble();
int truncated = (int) d;  // narrowing cast (fraction discarded)
```

Parsing from strings (less common when using Scanner directly):
```java
String token = in.next();
int value = Integer.parseInt(token);
double decimal = Double.parseDouble(token);
```

## 11. Sample Programs
### a. Sum of Two Integers
```java
import java.util.Scanner;

public class SumTwo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter first integer: ");
		int a = in.nextInt();
		System.out.print("Enter second integer: ");
		int b = in.nextInt();
		int sum = a + b;
		System.out.println("Sum = " + sum);
	}
}
```

### b. Reading a Full Name
```java
import java.util.Scanner;

public class FullName {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter age: ");
		int age = in.nextInt();
		in.nextLine(); // consume leftover newline
		System.out.print("Enter full name: ");
		String fullName = in.nextLine();
		System.out.println(fullName + " is " + age + " years old.");
	}
}
```

### c. Average of Three Doubles
```java
import java.util.Scanner;

public class AverageThree {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter three numbers separated by spaces: ");
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		double avg = (a + b + c) / 3.0;
		System.out.println("Average = " + avg);
	}
}
```

### d. Rectangle Info (Combining Int + Line)
```java
import java.util.Scanner;

public class RectangleInfo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter rectangle name: ");
		String name = in.next(); // single word name
		System.out.print("Enter width and height: ");
		int w = in.nextInt();
		int h = in.nextInt();
		System.out.println(name + ": area=" + (w * h) + " perimeter=" + (2 * (w + h)));
	}
}
```

### e. Reading a Full Sentence After Numeric Input
```java
import java.util.Scanner;

public class DescribeScore {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter score: ");
		int score = in.nextInt();
		in.nextLine(); // consume newline
		System.out.print("Describe the performance: ");
		String description = in.nextLine();
		System.out.println("Score " + score + " => " + description);
	}
}
```

## 12. Common Pitfalls & Fixes
| Pitfall | Example | Problem | Fix |
|---------|---------|---------|-----|
| Forget import | use Scanner without import | Compilation error | Add `import java.util.Scanner;` |
| Mixing `nextInt` then `nextLine` | read int then empty string | Leftover newline consumed | Call extra `nextLine()` to clear |
| Using `next()` for multi-word input | entering `New York` returns only `New` | `next()` stops at space | Use `nextLine()` |
| Expecting float when dividing ints | `7/2` gives 3 | Integer division truncates | Make one operand a double: `7 / 2.0` |
| Closing Scanner too early | `in.close();` mid-program | Further input not possible | Usually skip closing in short programs |

## 13. Style & Best Practices
- Use clear prompt messages ending with a space or colon.
- Store input in well‑named variables (`firstScore`, `width`, `fullName`).
- Keep related reads together; compute after reading all required values.
- Avoid magic numbers: if a constant matters elsewhere, use `final`.

## 14. Practice Exercises
Try these without immediately running—predict results first.

1. Write a program that asks for two integers and prints their product and difference.
2. Write a program that reads a first name (single word) and a full sentence describing a goal. Output: `Name: <first> | Goal: <sentence>`.
3. Read three integers and print the largest (no loops needed yet—just use Math methods or comparisons).
4. Read an `int` then a whole line description and ensure the description is not accidentally empty.
5. Read a double radius and print area of a circle (use `final double PI = 3.14159;`).
6. Read two doubles and print the rounded average to 2 decimal places (hint: `System.out.printf`).
7. Challenge: Read a full name (with spaces) and an integer representing birth year; print the initials and age in 2025.

## 15. (Optional Extension) File Input (Not Required for AP CSA)
`Scanner` can also read from files using: `Scanner fileIn = new Scanner(new File("data.txt"));` (plus `import java.io.*;`). This is beyond the minimal AP requirement but is a natural next step.

---
Mastering `Scanner` input early helps reduce bugs later—especially the `nextInt()` then `nextLine()` newline issue. Practice until handling mixed input feels natural.