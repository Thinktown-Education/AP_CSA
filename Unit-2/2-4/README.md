# Unit 2.4 — While Loops

## Learning Goals
By the end of this unit, you will:
- Understand the purpose of loops and when to use them
- Write and trace while loops
- Use loop control variables to manage loop execution
- Identify and avoid infinite loops
- Use `break` and `continue` statements appropriately
- Choose between if statements and while loops
- Solve problems that require repetition

## 1. What is a Loop?

A **loop** is a control structure that executes a block of code repeatedly as long as a condition is true. Instead of writing the same code many times, loops let you automate repetition.

**Example without a loop (repetitive):**
```java
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
System.out.println("Hello");
```

**Example with a loop (efficient):**
```java
int count = 0;
while (count < 5) {
    System.out.println("Hello");
    count++;
}
```

Both print "Hello" five times, but the loop is cleaner and scales to any number.

## 2. The While Loop

A **while loop** executes a block of code repeatedly while a condition is true. Once the condition becomes false, the loop stops.

### 2.1 Syntax

```java
while (condition) {
    // statements executed while condition is true
}
```

- `condition`: a boolean expression that is checked before each iteration
- The block inside `{}` is called the **loop body**
- The loop body runs repeatedly as long as the condition is true

### 2.2 How While Loops Execute

1. Check the condition
2. If true, execute the loop body
3. Return to step 1
4. If condition is false, exit the loop and continue with the next statement

### 2.3 Simple Example

```java
int count = 1;
while (count <= 3) {
    System.out.println("Count: " + count);
    count++;  // increment count
}
```

**Output:**
```
Count: 1
Count: 2
Count: 3
```

**Trace of execution:**
> Iteration 1: count is 1, condition (1 <= 3) is true, print "Count: 1", count becomes 2
> Iteration 2: count is 2, condition (2 <= 3) is true, print "Count: 2", count becomes 3
> Iteration 3: count is 3, condition (3 <= 3) is true, print "Count: 3", count becomes 4
> Check: count is 4, condition (4 <= 3) is false, loop exits

## 3. Loop Control Variables

A **loop control variable** is a variable that changes each iteration to eventually make the condition false. Without it, the loop could run forever (infinite loop).

### 3.1 Common Pattern: Count-Controlled Loop

```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;  // increment to move toward loop termination
}
```

Here, `i` is the loop control variable:
- It starts at 0
- It increases by 1 each iteration (`i++`)
- When `i` reaches 5, the condition (i < 5) becomes false and the loop exits

### 3.2 Sum Example

```java
int sum = 0;
int i = 1;
while (i <= 5) {
    sum = sum + i;  // add i to sum
    i++;
}
System.out.println("Sum: " + sum);  // Output: Sum: 15
```

## 4. Infinite Loops and How to Avoid Them

An **infinite loop** is a loop that never terminates because the condition never becomes false.

### 4.1 Example of an Infinite Loop (DO NOT RUN)

```java
int count = 0;
while (count < 10) {
    System.out.println(count);
    // BUG: count never changes, so condition is always true!
}
```

This prints 0 forever because `count` never increases.

### 4.2 How to Avoid Infinite Loops

Always ensure:
1. The loop control variable is **modified** inside the loop (usually incremented or decremented)
2. The modification **moves toward** making the condition false
3. The condition will eventually become false

**Fixed version:**
```java
int count = 0;
while (count < 10) {
    System.out.println(count);
    count++;  // count increases, moving toward termination
}
```

## 5. Break and Continue Statements

### 5.1 Break Statement

The `break` statement **exits the loop immediately**, even if the condition is still true.

```java
int i = 0;
while (i < 100) {
    if (i == 5) {
        break;  // exit loop when i equals 5
    }
    System.out.println(i);
    i++;
}
```

**Output:**
```
0
1
2
3
4
```

The loop stops at i = 5 because of the `break` statement.

### 5.2 Continue Statement

The `continue` statement **skips the rest of the current iteration** and jumps to the condition check for the next iteration.

```java
int i = 0;
while (i < 5) {
    i++;
    if (i == 3) {
        continue;  // skip printing when i equals 3
    }
    System.out.println(i);
}
```

**Output:**
```
1
2
4
5
```

Notice 3 is not printed because `continue` skips the println when i == 3.

## 6. While Loops vs. If Statements

| Feature | If Statement | While Loop |
|---------|--|--|
| **Executes code** | 0 or 1 time based on condition | Multiple times while condition is true |
| **Use when** | Decision needed once | Repetition needed |
| **Loop variable** | Not required | Usually needed |
| **Example** | Check if age >= 18 | Count from 1 to 100 |

**Example comparison:**

```java
// If: checks once and moves on
if (age >= 18) {
    System.out.println("Adult");
}
System.out.println("Done");  // executes immediately

// While: repeats until done
int count = 0;
while (count < 3) {
    System.out.println("Repeat " + count);
    count++;
}
System.out.println("Done");  // executes after loop ends
```

## 7. Common Loop Patterns

### 7.1 Print Numbers in a Range

```java
int start = 5;
int end = 10;
while (start <= end) {
    System.out.println(start);
    start++;
}
```

Output: 5, 6, 7, 8, 9, 10

### 7.2 Sum of Numbers

```java
int sum = 0;
int i = 1;
while (i <= 10) {
    sum = sum + i;
    i++;
}
System.out.println("Sum: " + sum);  // Output: Sum: 55
```

### 7.3 Counting Down

```java
int countdown = 5;
while (countdown > 0) {
    System.out.println(countdown);
    countdown--;  // decrement instead of increment
}
System.out.println("Blastoff!");
```

Output: 5, 4, 3, 2, 1, Blastoff!

### 7.4 Sentinel-Controlled Loop (User Input)

```java
import java.util.Scanner;

Scanner input = new Scanner(System.in);
int number = 0;
int sum = 0;

while (number != -1) {  // -1 is the "sentinel" value to stop
    System.out.print("Enter a number (-1 to stop): ");
    number = input.nextInt();
    if (number != -1) {
        sum = sum + number;
    }
}
System.out.println("Sum: " + sum);
```

## 8. Tracing While Loops

To understand a loop, trace through it step by step:

```java
int x = 1;
int product = 1;
while (x <= 4) {
    product = product * x;
    x++;
}
System.out.println(product);
```

**Trace:**
| Iteration | x | product (before) | product (after) | x (after) | Condition true? |
|-----------|---|-----------------|-----------------|-----------|---|
| 1         | 1 | 1               | 1               | 2         | Yes |
| 2         | 2 | 1               | 2               | 3         | Yes |
| 3         | 3 | 2               | 6               | 4         | Yes |
| 4         | 4 | 6               | 24              | 5         | Yes |
| Check     | 5 | 24              | —               | —         | No (5 ≤ 4 is false) |

**Output:** 24

## 9. Common Mistakes

| Mistake | Example | Problem | Fix |
|---------|---------|---------|-----|
| Forgetting to update loop variable | `while (i < 5) { print(i); }` | Infinite loop | Add `i++` |
| Using `=` instead of `==` | `while (i = 5)` | Always true; assignment not comparison | Use `while (i == 5)` |
| Off-by-one error | `while (i <= 10)` when you want 0-9 | Loop runs one extra time | Use `while (i < 10)` |
| Break in wrong place | `break;` outside loop | Syntax error | Put `break` inside loop body |

## Key Takeaways
- Loops repeat code while a condition is true; use them instead of copying code
- While loops require a loop control variable that eventually makes the condition false
- Always ensure the loop variable changes each iteration to avoid infinite loops
- `break` exits a loop immediately; `continue` skips to the next iteration
- If statements execute 0 or 1 time; while loops execute 0 or many times
- Trace loops step-by-step to understand their behavior
- Common patterns include counting loops, sum loops, and sentinel-controlled loops
- Proper loop design prevents infinite loops and makes code efficient

## Practice Problems

1) **Basic Loop Trace**: What does this code print?
```java
int count = 0;
while (count < 4) {
    System.out.println(count);
    count++;
}
```

2) **Loop Output**: Write the output of this loop:
```java
int i = 10;
while (i > 5) {
    System.out.print(i + " ");
    i--;
}
```

3) **Loop with Calculation**: What value does `result` have after this loop?
```java
int result = 0;
int i = 1;
while (i <= 5) {
    result = result + (i * 2);
    i++;
}
```

4) **Write a Loop**: Write a while loop that prints the numbers 1 through 7.

5) **Write a Loop**: Write a while loop that prints every even number from 2 to 20.

6) **Find the Bug**: Why is this loop infinite? Fix it.
```java
int x = 1;
while (x < 10) {
    System.out.println(x);
    // BUG HERE
}
```

7) **Sum with Loop**: Write a while loop that calculates the sum of numbers from 1 to 100 and prints the result.

8) **Countdown Loop**: Write a while loop that counts down from 10 to 1, then prints "Liftoff!".

9) **Breaking Early**: Write a loop that adds numbers starting from 1. Stop when the sum reaches or exceeds 50. Print the sum.

10) **Sentinel Loop**: Write a while loop that reads integers from the user until they enter 0, then prints how many numbers were entered (not counting the 0).

11) **Challenge - Multiplication Table**: Write a while loop that prints the 5 times table (5 × 1 = 5, 5 × 2 = 10, ..., 5 × 10 = 50).

12) **Challenge - Find a Number**: Write a while loop that finds the smallest positive integer `n` such that `n * n >= 1000`.
