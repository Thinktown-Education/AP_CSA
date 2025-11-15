# Unit 1.8 Strings
This chapter covers Strings in Java for AP Computer Science A (AP CSA). It explains what a String is, how to create and reference Strings, concatenation, indexing and length, common String methods, and common mistakes students make.

**Learning goals:**
- Understand what a `String` represents in Java.
- Create and reference `String` objects and literals.
- Concatenate strings safely and predictably.
- Use indexing and `length()` to access characters.
- Use common `String` methods from the Java standard library.
- Avoid common mistakes when working with strings.

**Prerequisites:** Basic Java syntax (variables, types, expressions).

## 1. What is a String

A `String` is an object that represents a sequence of characters (letters, digits, punctuation, and whitespace). In Java, `String` is a class in `java.lang`, so you can create and use strings without importing anything.

Key points:
- Strings are immutable: once created, their contents cannot change. Methods that appear to modify a string actually create and return a new `String`.
- Strings can represent text: words, sentences, file paths, or any character data.

Example (conceptual):

```java
String s = "Hello, AP CSA!"; // a String literal
```

## 2. How to create/reference a String

There are two common ways to make a `String` in Java:

- String literal: the compiler stores the literal in the string pool.
	- Example: `String greeting = "Hi";`
- Using a constructor (less common): `new String("text")` — usually unnecessary and avoids the string pool.

Examples:

```java
String a = "apple";                 // string literal
String b = "apple";                 // references same pooled object as `a`
String c = new String("apple");     // distinct object with same characters

System.out.println(a == b); // true  (same reference from pool)
System.out.println(a == c); // false (different objects)
System.out.println(a.equals(c)); // true (same characters)
```

Use `==` to compare references (are the two variables pointing to the same object). Use `.equals(...)` to compare string content (do the characters match).

### Common mistakes & tips

- **Using `==` instead of `.equals(...)`**: `==` checks whether two references point to the same object, not whether their text matches. In AP CSA answers about content equality, use `.equals(...)`.

- **`null` references**: Be careful when a `String` might be `null`. Calling a method on `null` throws `NullPointerException`. Check for `null` before calling methods or design logic so strings are never `null`.

- **Unnecessary use of `new String("...")`**: This creates a separate object and can confuse `==` checks. Prefer string literals.

### Practice problem (creation/reference)

Given the code below, what prints?

```java
String x = "cat";
String y = "cat";
String z = new String("cat");
System.out.println(x == y);
System.out.println(x.equals(z));
```

Solution: `true` then `true`. `x == y` is `true` because both are pooled literals; `x.equals(z)` is `true` because contents match.

## 3. String concatenation

Concatenation joins strings together. There are several ways to concatenate:

- The `+` operator (most common in AP CSA):

```java
String first = "Hello";
String last = "World";
String name = first + ", " + last + "!"; // "Hello, World!"
```

- Using `StringBuilder` for efficiency when concatenating many pieces (advanced / performance-aware):

```java
StringBuilder sb = new StringBuilder();
sb.append("one");
sb.append(" ");
sb.append("two");
String result = sb.toString();
```

Notes:
- Java automatically converts non-String operands to `String` when using `+` with a `String` (e.g., `"Score: " + 10` → `"Score: 10"`).
- Operator associativity matters when concatenating numbers and strings: `"a" + 1 + 2` → `"a12"`, whereas `1 + 2 + "a"` → `"3a"`.

### Escape characters

When building strings you may need to include special characters such as double quotes, backslashes, or newlines. Use escape sequences inside string literals.

Examples:

```java
String quote = "She said, \"Hello\""; // contains double quotes
String path = "C:\\Users\\henry";    // backslashes must be escaped
String lines = "First line\nSecond line"; // newline escape
System.out.println(quote);
System.out.println(path);
System.out.println(lines);
```

Notes:
- Use `\"` to include a double-quote character inside a string literal.
- Use `\\` to include a literal backslash.
- Use `\n` for a newline; when concatenating, the escape behaves like any other character in the literal.

### Common mistakes & tips

- **Mixing concatenation and addition**: Without parentheses, Java evaluates left-to-right. `"Sum: " + 1 + 2` gives `"Sum: 12"`, whereas `"Sum: " + (1 + 2)` gives `"Sum: 3"`.

- **Assuming mutability**: Using methods like `concat` and expecting the original string to change will cause errors in reasoning; these methods return new `String` objects.

### Practice problem (concatenation)

What is printed by each statement?

```java
System.out.println("Sum: " + 1 + 2);
System.out.println("Sum: " + (1 + 2));
```

Solution: Prints `Sum: 12` then `Sum: 3` — parentheses change evaluation order.

## 4. String index and length

Strings are indexed from 0. Use `length()` to get the number of characters. To obtain parts of a string use `substring(beginIndex)` or `substring(beginIndex, endIndex)` (end index is exclusive).

```java
String s = "Java";
int len = s.length();     // 4

String sub1 = s.substring(1);    // "ava"
String sub2 = s.substring(0, 2); // "Ja"
```

Remember that valid indices are `0` to `length() - 1`. Attempting to access `charAt` with an out-of-range index throws `StringIndexOutOfBoundsException`.

You can get substrings with `substring(beginIndex)` or `substring(beginIndex, endIndex)` (end index is exclusive):

```java
String s = "Computer";
String sub1 = s.substring(3);       // "puter" (from index 3 to end)
String sub2 = s.substring(0, 3);    // "Com"   (index 0,1,2)
```

### Common mistakes & tips

- **Off-by-one errors**: Indices are zero-based and the `endIndex` in `substring(begin, end)` is exclusive. `substring(0, s.length())` returns the whole string, but `substring(0, s.length()+1)` throws.

- **Swapped or invalid indices**: Calling `substring(5, 2)` will throw `StringIndexOutOfBoundsException`. Ensure `beginIndex <= endIndex` and both are within range.

- **`charAt` index bounds**: `charAt(len)` is invalid because last valid index is `len - 1`.

### Practice problem (index & length)

Given:

```java
String s = "ABCDE";
int a = s.length();
System.out.println(s.substring(1, 4));
System.out.println(s.charAt(a - 1));
```


## 5. String methods

Below are commonly used `String` methods with a short definition, common use-cases, and a tiny `java` example for each.

- `length()`
  - Definition: Returns the number of characters in the string.
  - Use-cases: Checking bounds, looping over characters, validating input length.
  - Example:

```java
String s = "abc";
int n = s.length(); // 3
```

- `substring(int beginIndex)` / `substring(int beginIndex, int endIndex)`
  - Definition: Extracts a portion of the string. The two-argument form uses an exclusive `endIndex`.
  - Use-cases: Extracting tokens, prefixes/suffixes, or parts of IDs/dates.
  - Example:

```java
String s = "Computer";
String tail = s.substring(3);     // "puter"
String first3 = s.substring(0, 3); // "Com"
```

- `equals(Object other)`
  - Definition: Tests whether two strings contain the same sequence of characters.
  - Use-cases: Comparing user input, checking state, conditional logic in FRQs.
  - Example:

```java
String a = "yes";
if (a.equals("yes")) { /* matched */ }
```

- `compareTo(String other)`
  - Definition: Compares two strings lexicographically. Returns 0 if equal, a negative number if this string is lexicographically less than `other`, or a positive number if greater.
  - Use-cases: Ordering/sorting strings, implementing comparison logic where a total ordering is needed (e.g., dictionary order).
  - Example:

```java
int cmp = "apple".compareTo("banana"); // negative because "apple" < "banana"
if (cmp < 0) { /* apple comes before banana */ }
```

- `indexOf(String str)` / `indexOf(String str, int fromIndex)`
  - Definition: Returns the index of the first occurrence of `str`, or `-1` if not found.
  - Use-cases: Searching for tokens, validating presence of substrings, splitting logic.
  - Example:

```java
int p = "hello".indexOf("ll"); // 2
int missing = "abc".indexOf("z"); // -1
```

Each method returns a new `String` when applicable; operations do not mutate the original string.

### Common mistakes & tips

- **Assuming methods mutate the original**: Methods like `substring`, `replace`, `toUpperCase` return new strings — they don't change the original reference. Always assign the result if you intend to keep it.

- **Confusing reference equality with content equality**: Use `.equals(...)` to compare contents, not `==`.

- **Searching for substrings**: `indexOf(...)` returns `-1` when not found. Always check for `-1` before using the returned index.

### Practice problem (methods)

What does the following print?

```java
String a = "apple";
String b = "banana";
System.out.println(a.compareTo(b) < 0);
System.out.println("hello".indexOf("z") >= 0);
```
 
----
 
More practice problems (methods)

1) What does this print?

```java
String s = "foobar";
System.out.println(s.substring(3));
System.out.println(s.substring(0, s.length()));
```


2) Find the index (or -1) printed by each expression:

```java
String s = "ababa";
System.out.println(s.indexOf("ba"));
System.out.println(s.indexOf("ba", s.indexOf("ba") + 1));
```

3) What prints here?

```java
String a = "cat";
String b = "ca" + "t";
System.out.println(a.equals(b));
System.out.println(a == b);
```

4) Given concatenation and length, what is printed?

```java
String s = "ab";
s = s + "cd";
System.out.println(s.length());
```

5) Predict output for compareTo edge cases:

```java
String a = "";
String b = "";
System.out.println(a.compareTo(b));
System.out.println(a.length());
```


6) Substring edge: will this throw an exception? If not, what prints?

```java
String s = "XYZ";
System.out.println(s.substring(0, 1));
System.out.println(s.substring(0, s.length() - 1));
```




