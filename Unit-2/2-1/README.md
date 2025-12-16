# Unit 2.1 Boolean Expressions

This chapter covers Boolean expressions in Java for AP Computer Science A (AP CSA). You will learn what Boolean values are, how to build relational expressions using comparison operators, common pitfalls, and practice problems.

**Learning goals:**
- Understand the `boolean` type and Boolean literals `true` and `false`.
- Build relational expressions using `==`, `!=`, `<`, `<=`, `>`, `>=`.
- Avoid common mistakes (assignment vs equality, object equality for Strings).

## 1. The `boolean` type

`boolean` is a primitive type that can hold one of two values: `true` or `false`.

```java
boolean b1 = true;
boolean b2 = (5 > 3); // true
boolean b3 = (2 + 2 == 5); // false
```

Booleans are used for decisions (`if` statements), loop conditions, and logical checks.

## 2. Relational operators

Relational operators compare numeric values (or expressions) and produce a `boolean` result.

- `==` equality
- `!=` inequality
- `<` less than
- `<=` less than or equal
- `>` greater than
- `>=` greater than or equal

Examples:

```java
int a = 7;
int b = 10;
System.out.println(a == b); // false
System.out.println(a != b); // true
System.out.println(a < b);  // true
```

Note: For objects like `String`, use `.equals(...)` for content equality instead of `==`.

## 3. Common mistakes

- Using `=` instead of `==` in conditionals (assignment vs comparison). Java will not allow `if (x = 5)` for primitive types — it is a compile error. For booleans, `if (flag = true)` compiles but is usually a bug because it assigns rather than compares.
- Confusing `==` for object equality (`String` vs `String.equals(...)`).
- Forgetting to consider the difference between reference equality and content equality for objects.

## 4. Practice problems

Each problem uses only relational operators (no logical `&&`/`||`/`!`). Try to work them out on paper first.

1) Evaluate each comparison (what prints?):

```java
int a = 3, b = 4, c = 3;
System.out.println(a == b);
System.out.println(a != b);
System.out.println(a <= c);
```

2) String equality check (what prints?):

```java
String s = "hello";
System.out.println(s == "hello");
System.out.println(s.equals("hello"));
```

3) For `n = 15`, evaluate the two relational checks below (what prints?):

```java
int n = 15;
System.out.println(n >= 10);
System.out.println(n <= 20);
```


