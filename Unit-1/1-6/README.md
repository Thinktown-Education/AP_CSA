# Unit 1.6 The `Math` Class

## Learning Goals
By the end of this unit, you will:
- Use `Math` constants (`PI`, `E`) and static methods
- Apply common `Math` methods: `abs()`, `max()`, `min()`, `sqrt()`, `pow()`, `random()`
- Generate random integers in specified ranges
- Understand method overloading
- Compose nested `Math` method calls
- Avoid common `Math` pitfalls

## 1. Why a `Math` Class?
Instead of rewriting common operations (max, square root, powers), Java provides a collection of ready‑to‑use static methods and constants. Using them:
- Reduces bugs
- Improves readability (`Math.max(a,b)` is self‑documenting)
- Ensures consistent behavior

## 2. Static Utility: No Objects
All members of `Math` are `static`. You never instantiate it:
```java
// Wrong: Math m = new Math(); // not allowed
int bigger = Math.max(12, 30); // correct
```
Call format: `Math.methodName(arguments)`.

## 3. Constants: `Math.PI` and `Math.E`
Frequently used mathematical constants:
```java
double circ = 2 * Math.PI * r;
double growth = Math.pow(Math.E, x); // e^x
```
`PI` (~3.141592653589793) and `E` (~2.718281828459045) are `double` values.

## 4. Core Methods You Must Know
| Method | Purpose | Example | Result |
|--------|---------|---------|--------|
| `Math.abs(x)` | Absolute value | `Math.abs(-7)` | `7` |
| `Math.max(a,b)` | Larger of two | `Math.max(4,9)` | `9` |
| `Math.min(a,b)` | Smaller of two | `Math.min(4,9)` | `4` |
| `Math.sqrt(x)` | Square root | `Math.sqrt(25)` | `5.0` |
| `Math.pow(a,b)` | a^b (double) | `Math.pow(2,3)` | `8.0` |
| `Math.random()` | Double in [0.0,1.0) | `Math.random()` | e.g. 0.428 |

Notice `pow` and `sqrt` always return `double`. Even an exact integer result like `Math.sqrt(16)` produces `4.0`.

## 5. Overloaded Methods
Some `Math` methods exist in more than one form (overloading) for different parameter types:
- `Math.abs(int)`, `Math.abs(double)`
- `Math.max(int,int)`, `Math.max(double,double)`
Java picks the version that matches argument types. Example:
```java
System.out.println(Math.abs(-5));     // uses int version -> 5
System.out.println(Math.abs(-5.2));   // uses double version -> 5.2
```
Understanding overloading helps you read code; you don’t need to write overloaded methods yet.

## 6. `Math.random()` and Integer Ranges
`Math.random()` produces a pseudo‑random double in `[0.0, 1.0)`. To convert to an integer range:
```
int value = (int)(Math.random() * size) + start;
```
Where `size = (high - low + 1)` and `start = low`.
Examples:
```java
int die = (int)(Math.random() * 6) + 1;      // 1..6
int digit = (int)(Math.random() * 10);       // 0..9
int score = (int)(Math.random() * 31) + 70;  // 70..100 (31 = 100-70+1)
```
Common error (cast too early):
```java
(int)Math.random() * 6 + 1; // always 1 ( (int)Math.random() is 0 )
```
Always multiply first, then cast.

## 7. Truncation
Casting drops the fractional part:
```java
double val = 12.9;
int truncated = (int) val; // 12
```

## 8. When (and When Not) to Use `Math.pow`
`Math.pow(a,b)` is flexible but slower and returns `double`.
Prefer direct multiplication for small integer exponents:
```java
int squared = n * n;          // better than (int)Math.pow(n, 2)
int cubed = n * n * n;        // better than (int)Math.pow(n, 3)
```
Use `Math.pow` when exponent is not a small integer or is a variable representing different powers.

## 9. Composing Math Methods
Methods can be nested. Inner call runs first:
```java
double hyp = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
```
If both `a` and `b` are ints and you only need integer squares:
```java
double hyp2 = Math.sqrt(a * a + b * b); // avoids double conversions
```

## 10. Guarding Against Mistakes
| Mistake | Issue | Safer Approach |
|---------|-------|----------------|
| `(int)Math.random() * 10` | Always 0 | `(int)(Math.random() * 10)` |
| Expecting `sqrt` int | Produces double | Cast intentionally: `(int)Math.sqrt(n)` if floor desired |
| Rounding via `+0.5` trick | Less clear | Avoid unless explicitly rounding later |
| Writing your own max logic | Repetitive | `Math.max(a,b)` |

## 11. Selecting the Right Method (Decision Guide)
- Need max/min of two? -> `Math.max`, `Math.min`
- Need absolute difference? -> `Math.abs(a - b)`
- Need square root? -> `Math.sqrt`
- Need power with fractional exponent? -> `Math.pow`
- Need random integer range? -> multiply random, cast, add offset

## 12. Out-of-Scope for Now (But Good to Know Exist)
Provided by `Math` but not required early for AP CSA:
- Trigonometric: `Math.sin`, `Math.cos`, `Math.tan`
- Inverses / hyperbolic: `Math.asin`, `Math.atan`, etc.
- Logarithms: `Math.log`, `Math.log10`
- Exponential: `Math.exp` (useful later, minimal early use)
- Remainder with doubles: `Math.IEEEremainder`
- Copy sign, scaling: `Math.copySign`, `Math.scalb`
You can safely ignore these until a project or later unit needs them.

## 13. Practice
1. Write a single expression for the larger magnitude value between `x` and `y` (i.e., whichever has greater absolute value) returning the original signed value.
2. Generate a random integer in the inclusive range 5–12.
3. Refactor: replace manual max logic:
    ```java
    int bigger;
    if (a > b) bigger = a; else bigger = b;
    ```
    with one line using `Math`.
4. Method `int clampToHundred(int n)` returning 0 if negative, 100 if over 100, otherwise `n` (use `Math.min` and `Math.max`).
5. Give an expression for distance between two points on a number line: `a` and `b`.
6. Generate a random even integer from 0 to 20 inclusive.
7. Show two different correct formulas to produce a random lowercase letter `'a'`–`'z'`.
8. Explain why `(int)(Math.random() * (high - low)) + low` is wrong if you want to include `high`.
9. Method `boolean isPerfectSquare(int n)` using `Math.sqrt` (floor check).
10. Method `double hyp(int a, int b)` returning hypotenuse using no `Math.pow`.
11. Expand: Show two equivalent ways to compute integer cube of `n` (one with `pow`, one without) and explain which is preferable.
12. MC Style: Which yields a random integer 20–30 inclusive?\
    A. `(int)(Math.random() * 11) + 20`  
    B. `(int)(Math.random() * 10) + 20`  
    C. `(int)(Math.random() * 12) + 19`  
    D. `(int)Math.random() * 11 + 20`  
    E. `(int)(Math.random()) * 11 + 20`
13. MC Style: What prints?
```java
System.out.println(Math.max(Math.min(8, 5), Math.abs(-4))); // ?
```
14. Challenge: Expression returning the midpoint (as double) between two ints `a` and `b` (avoid overflow if they might be large— hint: use `a + (b - a) / 2.0`).
