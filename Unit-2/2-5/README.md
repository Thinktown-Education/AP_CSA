# Unit 2.5 — For Loops

## Learning Goals
By the end of this unit, you will:
- Understand the structure and purpose of for loops
- Write for loops to repeat code a specific number of times
- Choose between while loops and for loops
- Use loop variables to control iteration
- Write nested for loops for more complex patterns
- Trace for loop execution
- Solve problems that require counted repetition

## 1. From While Loops to For Loops

In Unit 2.4, you learned that while loops repeat code while a condition is true. Many loops follow a **pattern**: they start with an initial value, check a condition, and increment a variable each iteration.

**While loop pattern:**
```java
int i = 0;           // initialize
while (i < 5) {      // condition
    System.out.println(i);
    i++;             // increment
}
```

This pattern is so common that Java provides a shorter syntax: the **for loop**.

**Same logic as a for loop:**
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

Both print 0, 1, 2, 3, 4. The for loop is just a cleaner way to write the same thing.

## 2. The For Loop

A **for loop** is a control structure that repeats code a specific number of times. It combines initialization, condition checking, and increment all in one line.

### 2.1 Syntax

```java
for (initialization; condition; increment) {
    // statements executed repeatedly
}
```

- **initialization**: Sets the starting value of the loop variable (runs once)
- **condition**: Boolean expression checked before each iteration (if false, loop exits) 
- **Loop body**: Statements between `{}`
- **increment**: Changes the loop variable after each iteration (usually `i++` or `i--`)

### 2.2 Parts of a For Loop

Let's break down this example:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Number: " + i);
}
```

| Part | Example | Meaning |
|------|---------|---------|
| Initialization | `int i = 1` | Create variable i and set it to 1 (runs once) |
| Condition | `i <= 5` | Continue loop while i is less than or equal to 5 |
| Increment | `i++` | After each iteration, add 1 to i |
| Body | `System.out.println(...)` | Code that repeats each iteration |

### 2.3 Step-by-Step Execution

```java
for (int i = 1; i <= 3; i++) {
    System.out.println(i);
}
```

1. **Initialization**: `int i = 1` — Create i, set to 1
2. **Check condition**: `i <= 3` (1 <= 3? Yes)
3. **Execute body**: Print 1
4. **Increment**: `i++` — i becomes 2
5. **Check condition**: `i <= 3` (2 <= 3? Yes)
6. **Execute body**: Print 2
7. **Increment**: `i++` — i becomes 3
8. **Check condition**: `i <= 3` (3 <= 3? Yes)
9. **Execute body**: Print 3
10. **Increment**: `i++` — i becomes 4
11. **Check condition**: `i <= 3` (4 <= 3? No)
12. **Exit loop**

**Output:** 1, 2, 3

## 3. For Loop Examples

### 3.1 Print Numbers 1 to 10

```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

### 3.2 Sum Numbers from 1 to N

```java
int sum = 0;
for (int i = 1; i <= 100; i++) {
    sum = sum + i;
}
System.out.println("Sum: " + sum);  // Output: Sum: 5050
```

### 3.3 Count Down

```java
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
System.out.println("Blastoff!");
```

Output: 10, 9, 8, ..., 2, 1, Blastoff!

### 3.4 Print Even Numbers from 2 to 20

```java
for (int i = 2; i <= 20; i = i + 2) {
    System.out.println(i);
}
```

Here, `i = i + 2` increments by 2 each time instead of 1.

### 3.5 Iterate Over String Characters

```java
String word = "Java";
for (int i = 0; i < word.length(); i++) {
    System.out.println(word.charAt(i));
}
```

Output: J, a, v, a

## 4. For Loops vs. While Loops

Both for and while loops can do the same thing, but they're best used in different situations.

| Feature | While Loop | For Loop |
|---------|-----------|---------|
| **Best for** | Repetition with unpredictable end (input validation, user interaction) | Counted repetition (fixed number of iterations) |
| **Syntax** | Simpler, more readable for complex logic | Cleaner when using standard count pattern |
| **Loop variable** | Declared outside loop | Declared in loop header |
| **Common use** | Sentinel loops, game loops | Printing ranges, summing, iterating |

**When to use while:**
```java
// Input validation - don't know how many tries needed
while (age < 0) {
    age = input.nextInt();
}
```

**When to use for:**
```java
// Count from 1 to 50 - know exactly how many times
for (int i = 1; i <= 50; i++) {
    System.out.println(i);
}
```

## 5. Loop Variable Scope

The loop variable in a for loop is only available **inside the loop**. Once the loop exits, the variable no longer exists.

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);  // OK, i exists here
}
System.out.println(i);  // ERROR: i doesn't exist outside the loop
```

**Compare to while loop:**
```java
int i = 0;
while (i < 5) {
    System.out.println(i);  // OK, i exists here
    i++;
}
System.out.println(i);  // OK, i still exists (i is now 5)
```

This is why while loops declare their variable outside the loop: the variable needs to exist after the loop ends.

## 6. Nested For Loops

A **nested for loop** is a for loop inside another for loop. The inner loop completes all its iterations for each iteration of the outer loop.

### 6.1 Simple 2D Pattern

```java
for (int row = 1; row <= 3; row++) {
    for (int col = 1; col <= 4; col++) {
        System.out.print("*");
    }
    System.out.println();  // newline after each row
}
```

**Output:**
```
****
****
****
```

**Trace:** The outer loop runs 3 times. For each outer loop iteration, the inner loop runs 4 times.

### 6.2 Triangle Pattern

```java
for (int row = 1; row <= 5; row++) {
    for (int col = 1; col <= row; col++) {
        System.out.print("*");
    }
    System.out.println();
}
```

**Output:**
```
*
**
***
****
*****
```

The inner loop condition uses the outer loop variable `row`, so each row prints a different number of stars.

### 6.3 Times Table

```java
for (int i = 1; i <= 10; i++) {
    for (int j = 1; j <= 10; j++) {
        System.out.print(i * j + "\t");  // \t is a tab
    }
    System.out.println();
}
```

This prints the 10×10 multiplication table.

### 6.4 Understanding Nested Loop Execution

When you have nested loops, think about the **flow**:
1. Outer loop iteration 1 starts
2. Inner loop runs completely (all iterations)
3. Outer loop iteration 2 starts
4. Inner loop runs completely again
5. Continue until outer loop ends

If outer loop runs n times and inner loop runs m times, the inner block executes **n × m times total**.

## 7. Loop Variable Names and Conventions

Standard naming conventions for loop variables:

```java
for (int i = 0; i < 10; i++) { }           // Simple counter, most common
for (int row = 0; row < 5; row++) { }      // More descriptive
for (int col = 0; col < 3; col++) { }      // Nested loop variables
for (int index = 0; index < size; index++) { }  // When clarity matters
```

**Convention**: Use single letters (`i`, `j`, `k`, `x`, `y`) for simple counters, and descriptive names (`row`, `col`, `count`) for nested or complex loops.

## 8. Common For Loop Patterns

### 8.1 Print a Range

```java
for (int i = 5; i <= 15; i++) {
    System.out.println(i);
}
```

### 8.2 Reverse Order

```java
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
```

### 8.3 Sum or Product

```java
int sum = 0;
for (int i = 1; i <= 10; i++) {
    sum = sum + i;
}

int product = 1;
for (int i = 1; i <= 5; i++) {
    product = product * i;
}
```

### 8.4 Iterate by Steps

```java
for (int i = 0; i <= 100; i = i + 10) {
    System.out.println(i);  // 0, 10, 20, 30, ..., 100
}
```

### 8.5 Loop Until Condition Met

```java
int count = 0;
for (int i = 1; count < 1000; i++) {
    count = count + i;
}
// Find first number where sum of 1+2+3+...+n >= 1000
```

## 9. Tracing For Loops

To understand a for loop, trace through it iteration by iteration:

```java
int total = 0;
for (int i = 1; i <= 4; i++) {
    total = total + (i * 2);
}
System.out.println(total);
```

**Trace table:**
| Iteration | i | total (before) | i*2 | total (after) | Condition true? |
|-----------|---|----------------|-----|---------------|---|
| 1         | 1 | 0              | 2   | 2             | Yes |
| 2         | 2 | 2              | 4   | 6             | Yes |
| 3         | 3 | 6              | 6   | 12            | Yes |
| 4         | 4 | 12             | 8   | 20            | Yes |
| Check     | 5 | 20             | —   | —             | No (5 <= 4 is false) |

**Output:** 20

## 10. Common Mistakes

| Mistake | Example | Problem | Fix |
|---------|---------|---------|-----|
| Off-by-one error | `for (int i = 0; i < 5; i++)` when you want 1 to 5 | Starts at 0 instead of 1 | Use `i = 1` or `i <= 5` |
| Loop variable used after loop | `for (int i...) { } println(i);` | Variable doesn't exist outside loop | Declare i outside if needed after loop |
| Forgetting increment | `for (int i = 0; i < 5; ) { }` | Infinite loop | Add `i++` in increment section |
| Wrong comparison | `for (int i = 0; i = 5; i++)` | Assignment instead of comparison | Use `==` or `<` instead of `=` |
| Nested loop logic error | Inner condition uses wrong variable | Incorrect pattern generated | Check which loop variable you're using |

## Key Takeaways
- For loops are ideal for repeating code a specific number of times
- The for loop header contains initialization, condition, and increment all in one place
- For loops are cleaner than while loops when using the standard count pattern
- The loop variable is created in the for statement and only exists inside the loop
- Nested for loops repeat completely for each outer loop iteration
- The total iterations in nested loops is the product of each loop's iterations
- Common patterns include ranges, counting, summing, and creating patterns
- Choose while loops for unpredictable repetition and for loops for counted repetition

## Practice Problems

1) **Basic For Loop**: What does this code print?
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

2) **For Loop Output**: Write the output of this loop:
```java
for (int i = 1; i <= 3; i++) {
    System.out.print(i + " ");
}
```

3) **For Loop Calculation**: What value does `result` have after this loop completes?
```java
int result = 0;
for (int i = 1; i <= 5; i++) {
    result = result + i;
}
```

4) **Write a For Loop**: Write a for loop that prints the numbers 1 through 10.

5) **Write a For Loop**: Write a for loop that prints every even number from 2 to 20.

6) **Count Backwards**: Write a for loop that prints the numbers 10 down to 1.

7) **Loop with String**: Write a for loop that prints each character of the string "Hello" on a separate line using `substring()`.

8) **Sum of Multiples**: Write a for loop that calculates the sum of all multiples of 3 from 3 to 30 (3, 6, 9, ..., 30).

9) **Square Numbers**: Write a for loop that prints the squares of numbers 1 to 8 in the format: "1 squared is 1", "2 squared is 4", etc.

10) **Nested Loop - Rectangle**: Write nested for loops to print a 4×5 rectangle of asterisks (*).

11) **Nested Loop - Triangle**: Write nested for loops that create this pattern:
```
*
**
***
****
*****
```

12) **Challenge - Multiplication Table**: Write nested for loops that print a times table for 1-12 (like a calendar grid).

13) **Challenge - Factorial**: Write a for loop that calculates the factorial of 6 (6! = 6 × 5 × 4 × 3 × 2 × 1). Store the result in a variable called `factorial`.

14) **Challenge - Diamond Pattern**: Write nested for loops that create a diamond pattern using asterisks (hint: use row numbers and their distance from the middle).
