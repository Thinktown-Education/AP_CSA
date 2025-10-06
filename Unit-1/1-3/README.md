# Unit 1.3 Arithmetic Operations

Arithmetic operations are used to perform mathematical calculations in Java. Understanding these operations is essential for manipulating data and solving problems in AP CSA.

## Basic Arithmetic Operators
Java provides several basic arithmetic operators:

| Operator | Description         | Example         | Result |
|----------|---------------------|-----------------|--------|
| `+`      | Addition            | `2 + 3`         | `5`    |
| `-`      | Subtraction         | `5 - 2`         | `3`    |
| `*`      | Multiplication      | `4 * 2`         | `8`    |
| `/`      | Division            | `8 / 2`         | `4`    |
| `%`      | Remainder (modulo)  | `7 % 3`         | `1`    |

## Integer vs. Double Arithmetic
- When both operands are integers, the result is an integer. Division drops the decimal part (truncates):
	```java
	int a = 7 / 2; // a is 3
	```
- When at least one operand is a double, the result is a double:
	```java
	double b = 7.0 / 2; // b is 3.5
	double c = 7 / 2.0; // c is 3.5
	```

## Order of Operations (Precedence)
Java follows standard math precedence rules:
1. Parentheses `()`
2. Multiplication `*`, Division `/`, Remainder `%`
3. Addition `+`, Subtraction `-`

Example:
```java
int result = 2 + 3 * 4; // result is 14
int result2 = (2 + 3) * 4; // result2 is 20
```

## Compound Assignment Operators
These operators combine arithmetic with assignment:
| Operator | Example      | Equivalent      |
|----------|--------------|-----------------|
| `+=`     | `x += 5;`    | `x = x + 5;`    |
| `-=`     | `x -= 3;`    | `x = x - 3;`    |
| `*=`     | `x *= 2;`    | `x = x * 2;`    |
| `/=`     | `x /= 4;`    | `x = x / 4;`    |
| `%=`     | `x %= 2;`    | `x = x % 2;`    |

## Increment and Decrement
These operators increase or decrease a variable by 1:
- `x++` (post-increment): increases x by 1 after its value is used
- `++x` (pre-increment): increases x by 1 before its value is used
- `x--` (post-decrement): decreases x by 1 after its value is used
- `--x` (pre-decrement): decreases x by 1 before its value is used

Example:
```java
int x = 5;
x++;
System.out.println(x); // 6
--x;
System.out.println(x); // 5
```

## Integer Division and Modulo
Integer division truncates the decimal part. Modulo finds the remainder:
```java
int a = 10 / 3; // a is 3
int b = 10 % 3; // b is 1
```

## Type Casting in Arithmetic
You can cast between types to control results:
```java
int a = 5;
int b = 2;
double result = (double) a / b; // result is 2.5
```

## Common Mistakes
- Dividing integers when you want a decimal result (cast to double!)
- Using `%` with negative numbers (result may be negative)
- Forgetting operator precedence

## Practice Problems

### Practice Problems: Complex Arithmetic Expressions
1. What is the value of `int result = 2 + 3 * 4 - 8 / 2;`?
2. What is the value of `double value = (5 + 2.0) * 3 / 4;`?
3. What does `int x = 10; x += 2 * 3;` set `x` to?
4. What is the value of `int y = (7 + 5) % 4 * 2;`?
5. What does `double z = 10 / 4 + 2.5 * 3;` evaluate to?
6. Write code to calculate the average of three numbers: 7, 13, and 20, as a double.
7. Write code to compute the remainder when the sum of 15, 22, and 9 is divided by 5.
8. What is the value of `int a = 2; int b = 3; int c = 4; int result = a * b + c / a - b % c;`?
