# Unit 2.3 — Compound Boolean

This chapter explains how to combine boolean expressions in Java using the logical operators `&&` (AND), `||` (OR), and `!` (NOT). The chapter is organized to build intuition, show precise rules (including operator precedence and truth tables), demonstrate safe coding patterns (short-circuiting), and provide practice problems with answers.

## Goals

## Prerequisites

## 1. Introduction — Detailed operator guide

This section explains each compound boolean operator in detail: its semantics, truth table, short-circuit behavior, common uses, and small examples. Understanding these thoroughly helps you write safe, readable conditions.

1.1 `!` — NOT (negation)

- Semantics: `!A` evaluates to `true` if and only if `A` is `false`; otherwise it evaluates to `false`. It simply inverts the boolean value of `A`.
- Truth table:

	| A     | !A    |
	|-------|-------|
	| true  | false |
	| false | true  |

- Precedence: `!` has the highest precedence among the three operators — it applies to the nearest boolean expression to its right.
- Short-circuit notes: `!` itself doesn't short-circuit other operators; it's a unary operator applied before `&&`/`||` evaluation.
- Common uses: flip a condition, check "not" cases, and avoid double negatives in logic.
- Example:

```java
boolean loggedIn = false;
if (!loggedIn) {
		System.out.println("Please log in");
}
```

1.2 `&&` — AND (conjunction)

- Semantics: `A && B` is `true` only when both `A` and `B` are `true`; otherwise it's `false`.
- Truth table:

	| A     | B     | A && B |
	|-------|-------|--------|
	| true  | true  | true   |
	| true  | false | false  |
	| false | true  | false  |
	| false | false | false  |

- Short-circuit behavior: Java evaluates `A` first; if `A` is `false`, it does NOT evaluate `B` because the whole expression cannot become `true`. This is called short-circuiting and is important for writing safe guards.
- Common uses: combine multiple requirements (e.g., range checks), guard risky operations (e.g., `s != null && s.length() > 0`), and make composite conditions concise.
- Example (range check):

```java
int x = 12;
if (x > 0 && x < 100) {
	System.out.println("x is between 1 and 99");
}
```

Example (guarding unsafe operation):

```java
int[] arr = {1,2,3};
int i = 2;
if (i >= 0 && i < arr.length && arr[i] == 3) {
	System.out.println("Index ok and value is 3");
}
```

1.3 `||` — OR (disjunction)

- Semantics: `A || B` is `true` if at least one of `A` or `B` is `true`; it's `false` only when both are `false`.
- Truth table:

	| A     | B     | A \|\| B |
	|-------|-------|--------|
	| true  | true  | true   |
	| true  | false | true   |
	| false | true  | true   |
	| false | false | false  |

- Short-circuit behavior: Java evaluates `A` first; if `A` is `true`, it does NOT evaluate `B` because the whole expression is already `true`. This avoids unnecessary work but also means `B` may not run if `A` is `true`.
- Common uses: provide alternate allowed conditions (e.g., user has role A OR role B), default/short-circuit success checks.
- Example:

```java
boolean rainy = true;
boolean windy = false;
if (rainy || windy) {
		System.out.println("Take an umbrella or jacket");
}
```

Notes on combining operators:
- Precedence: `!` &gt; `&&` &gt; `||`. Use parentheses to make grouping explicit and improve readability.
- De Morgan's Laws are useful when pushing `!` inside a compound expression: `!(A && B)` ⇔ `(!A) || (!B)`, and `!(A || B)` ⇔ `(!A) && (!B)`.

Now that each operator is explained in depth, the following sections show truth tables, precedence, short-circuit evaluation, patterns, practice problems, and answers.
## 3. Operator Precedence and Grouping
Precedence (highest → lowest):

- `!` (NOT)
- `&&` (AND)
- `||` (OR)

Example: `!a && b || c` is grouped as `((!a) && b) || c` by precedence rules. When in doubt, add parentheses to make your intent explicit.


## 4. Short-Circuit Evaluation (Practical note)
- `A && B`: if `A` is false, `B` is not evaluated (because result must be false).
- `A || B`: if `A` is true, `B` is not evaluated (because result must be true).

Short-circuiting is useful to avoid errors (e.g., checking array bounds before accessing an index) and to prevent unnecessary expensive computation. However, avoid relying on side effects inside `B` because it may not run.

Example (safe array check):

```java
int[] arr = {1,2,3};
int i = 2;
if (i >= 0 && i < arr.length && arr[i] == 3) {
	System.out.println("Index ok and value is 3");
}
```

---

## 5. De Morgan's Laws
De Morgan's laws let you move a negation (`!`) inside a compound expression and are commonly used when you want to negate conditions cleanly:

- `!(A && B)`  is equivalent to  `(!A) || (!B)`
- `!(A || B)`  is equivalent to  `(!A) && (!B)`

Examples:

```java
// !(x > 0 && x < 10)  <=>  (x <= 0) || (x >= 10)
// !(a == b || a == c) <=> (a != b) && (a != c)
```

Use De Morgan's laws to simplify or rephrase negated conditions and to avoid double negatives.

---

## 6. Common Pitfalls and Tips
- Don't confuse `=` (assignment) with `==` (comparison).
- Remember operator precedence; use parentheses for clarity.
- Avoid side effects in right-hand operands that rely on evaluation.
- When checking `null` before calling a method on an object, use `&&` with the null-check first.

Bad:

```java
if (s.equals("yes") && s != null) { // can throw NullPointerException
	// ...
}
```

Good:

```java
if (s != null && s.equals("yes")) { // safe because s != null is checked first
	// ...
}
```

---

## 7. Examples and Patterns

- Combining ranges:

```java
int x = 12;
if (x > 0 && x < 100) {
	System.out.println("x is between 1 and 99");
}
```

- Guard with short-circuit (avoid division by zero):

```java
int a = 0;
if (a != 0 && (10 / a) > 1) {
	System.out.println("Safe");
}
```

---

## 8. Practice Problems

1) Evaluate and state what prints (if anything):

```java
int x = 5;
if (x > 0 && x < 10) {
	System.out.println("A");
}
if (x < 0 || x % 2 == 0) {
	System.out.println("B");
}
```

2) What prints? Explain short-circuiting and why no exception is thrown:

```java
int a = 0;
if (a != 0 && (10 / a) > 1) {
	System.out.println("Safe");
} else {
	System.out.println("Blocked or unsafe");
}
```

3) Write an `if` that prints `"ok"` only when `s` is not `null` and equals `"yes"` (avoid NullPointerException).

4) Parenthesize and evaluate (p=true, q=false, r=true):

```
p || q && !r
```

5) Write two equivalent conditions that test whether `n` is outside the range 1..100 (first using `||`, second using `!` with `&&`).

---

## 9. Practice Answers

1) Output:

A

Explanation: `x > 0 && x < 10` is true, so `A` prints. `x < 0 || x % 2 == 0` is false for x=5 (positive odd), so `B` does not print.

2) Output:

Blocked or unsafe

Explanation: `a != 0` is false, so `a != 0 && (10 / a) > 1` short-circuits; `(10 / a)` is not evaluated and no division-by-zero occurs. The `else` branch runs.

3) Example solution:

```java
if (s != null && s.equals("yes")) {
	System.out.println("ok");
}
```

4) Parenthesize and evaluate:

```
p || (q && (!r))

q && (!r) => false && (!true) => false
p || false => true

Result: true
```

5) Using `||`:

```java
if (n < 1 || n > 100) {
	// outside range
}
```

Using `!` and `&&`:

```java
if (!(n >= 1 && n <= 100)) {
	// outside range
}
```

---

## 10. Quick Checklist
- Use `&&` for "both must be true", `||` for "any true is enough", and `!` to invert.
- Remember precedence: `!` → `&&` → `||`.
- Use parentheses for clarity.
- Prefer short-circuit-safe ordering when expressions may error.
-

If you want, I can also:
- Add SVG diagrams for truth tables and short-circuit flow to `Unit-2/2-3/images/`.
- Generate runnable `.java` examples and a small test harness.
- Export a printer-friendly version.

Truth table (A && B):
- true && true => true
- true && false => false
- false && true => false
- false && false => false

Example:

```java
int x = 12;
if (x > 0 && x < 100) {
	System.out.println("x is between 1 and 99");
}
```

Explanation: Both `x > 0` and `x < 100` must be true for the message to print.

Short-circuit behavior: In `A && B`, if `A` is false, Java does not evaluate `B` because the whole expression cannot be true. This is important when `B` has side effects or may cause errors (e.g., dividing by zero or accessing an array).

## 3. `||` — OR

Truth table (A || B):
- true || true => true
- true || false => true
- false || true => true
- false || false => false

Example:

```java
boolean rainy = true;
boolean windy = false;
if (rainy || windy) {
	System.out.println("Take an umbrella or jacket");
}
```

Explanation: The message prints if at least one of the conditions is true.

Short-circuit behavior: In `A || B`, if `A` is true, Java does not evaluate `B` since the result is already true.

## 4. `!` — NOT

`!` inverts a boolean expression.

Example:

```java
boolean loggedIn = false;
if (!loggedIn) {
	System.out.println("Please log in");
}
```

Explanation: `!loggedIn` is true, so the message prints.

## 5. Combining operators

Operators can be combined; use parentheses to make intent clear and to control evaluation order.

Operator precedence (from highest to lowest):

- `!` (NOT)
- `&&` (AND)
- `||` (OR)

This means `!a && b || c` is interpreted as `((!a) && b) || c` unless parentheses change the grouping.

Because precedence can be subtle, prefer parentheses when expressions are moderately complex — this improves readability and avoids surprises.

Example:

```java
int age = 16;
boolean guardianPresent = true;
if ((age >= 18) || (guardianPresent && age >= 13)) {
	System.out.println("Allowed entry");
} else {
	System.out.println("Not allowed");
}
```

Explanation: This checks if someone is an adult, or if they are at least 13 and a guardian is present.

## 6. Common pitfalls
- Mixing `==` with `=`: `if (x = 5)` is invalid — `=` assigns, `==` compares.
- Using `&&` when you need `||`, and vice versa — think in terms of "AND requires both" and "OR accepts any".
- Forgetting parentheses when combining many operators — parentheses improve readability and correctness.
- Relying on side effects inside short-circuited expressions — avoid code with required side effects inside `B` of `A && B` or `A || B`.

### De Morgan's laws

De Morgan's laws help transform negated compound expressions and are useful when simplifying logic or when you need to invert a condition:

- !(A && B)  is equivalent to  (!A) || (!B)
- !(A || B)  is equivalent to  (!A) && (!B)

Examples:

```java
// !(x > 0 && x < 10)  <=>  (x <= 0) || (x >= 10)
// !(a == b || a == c) <=> (a != b) && (a != c)
```

Use De Morgan's laws when you want to push a `!` inside a compound expression or when negating complex conditions for clarity.

## 7. Examples (with short-circuit notes)

Example 1 — Safe array access with short-circuit:

```java
int[] arr = {1,2,3};
int i = 2;
if (i >= 0 && i < arr.length && arr[i] == 3) {
	System.out.println("Index ok and value is 3");
}
```

Because `i < arr.length` is checked before `arr[i] == 3`, we avoid an ArrayIndexOutOfBoundsException.

Example 2 — Avoid side effects in right-hand expression when left short-circuits:

```java
boolean ok = false;
if (ok || expensiveCheck()) {
	System.out.println("Proceed");
}
// expensiveCheck() is not called because ok is false? (actually it is called only if ok is false; if ok is true it will NOT be called)
```

## 8. Practice problems

1) Evaluate the following and state what prints (if anything):

```java
int x = 5;
if (x > 0 && x < 10) {
	System.out.println("A");
}
if (x < 0 || x % 2 == 0) {
	System.out.println("B");
}
```

2) What does this print? Explain short-circuit behavior.

```java
int a = 0;
if (a != 0 && (10 / a) > 1) {
	System.out.println("Safe");
} else {
	System.out.println("Blocked or unsafe");
}
```

3) Write an `if` statement that prints `"ok"` when a string `s` is not `null` and equals the text `"yes"`. Use short-circuiting to avoid a NullPointerException.

4) For the boolean expression below, add parentheses to make the evaluation order explicit and then state whether it evaluates to true or false (assume `p=true`, `q=false`, `r=true`):

```
p || q && !r
```

5) Write a condition that checks whether an integer `n` is outside the range 1..100 inclusive (i.e., `n < 1` or `n > 100`). Then write an equivalent condition using `!` (NOT) applied to the inside-of-range test.

## 9. Practice answers

1) Output:

A

Explanation: `x > 0 && x < 10` is true so `A` prints. `x < 0 || x % 2 == 0` is false (x is positive and odd) so `B` does not print.

2) Output:

Blocked or unsafe

Explanation: `a != 0` is false, so in `a != 0 && (10 / a) > 1` Java short-circuits and does NOT evaluate `(10 / a)` — that prevents a division-by-zero exception. Because the `if` condition is false, the `else` runs.

3) Example solution:

```java
if (s != null && s.equals("yes")) {
	System.out.println("ok");
}
```

Explanation: If `s` is `null`, the left side `s != null` is false and `s.equals("yes")` is not evaluated, avoiding a NullPointerException.

4) Add parentheses and evaluate:

```
p || (q && (!r))

With p=true, q=false, r=true:
q && (!r) => false && (!true) => false && false => false
p || (false) => true || false => true

So the expression is true.
```

5) Using `||`:

```
if (n < 1 || n > 100) {
	// outside range
}
```

Using `!` applied to inside-of-range:

```
if (!(n >= 1 && n <= 100)) {
	// outside range
}
```

## 10. Quick checklist for compound booleans
- Remember operator precedence: `!` then `&&` then `||`.
- Use parentheses to clarify complex conditions.
- Prefer short-circuit-safe ordering when expressions may cause errors.
- Avoid heavy side effects inside boolean expressions.

---

If you want, I can:
- Convert this chapter to a printable handout.
- Add SVG diagrams illustrating short-circuit flow to `Unit-2/2-3/images/` and insert them.
- Generate runnable `.java` example files and a test harness.