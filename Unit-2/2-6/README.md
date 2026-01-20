# Unit 2.6 — For Loops with Conditionals and Strings

## Learning Goals
By the end of this unit, you will:
- Combine for loops with if statements to process data selectively
- Use string methods (length(), substring(), indexOf(), equals()) within loops
- Search for substrings and patterns in strings
- Count and filter based on conditions
- Build new strings through iteration and conditionals
- Solve real-world problems combining loops, conditions, and string manipulation

## 1. Why Combine Loops and Conditionals?

In previous units, you learned:
- For loops repeat code a fixed number of times
- If statements make decisions based on conditions

By combining them, you can process data intelligently: loop through items and take action only when a condition is met.

**Simple example:**
```java
// Count how many numbers from 1 to 10 are even
int count = 0;
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        count++;
    }
}
System.out.println("Even numbers: " + count);  // Output: 5
```

This is more powerful than just looping: you're filtering based on a condition.

## 2. Searching Within Strings Using Loops

Strings have a `length()` method and `substring()` method. You can use loops and conditionals to search for patterns in strings.

### 2.1 Finding Substrings

The `indexOf()` method finds the first occurrence of a substring. You can combine this with loops to find all occurrences.

```java
String text = "apple apple apple";
String search = "apple";
int count = 0;
int index = 0;

while (index < text.length()) {
    index = text.indexOf(search, index);
    if (index == -1) {
        break;  // no more occurrences
    }
    count++;
    index = index + search.length();  // move past this occurrence
}
System.out.println("Found: " + count);  // Output: Found: 3
```

### 2.2 Finding Words of Specific Length

```java
String[] words = {"cat", "elephant", "dog", "butterfly", "bat"};
int targetLength = 3;

System.out.println("Words with " + targetLength + " letters:");
for (int i = 0; i < words.length; i++) {
    if (words[i].length() == targetLength) {
        System.out.println(words[i]);
    }
}
```

**Output:**
```
Words with 3 letters:
cat
dog
bat
```

## 3. Counting and Filtering Strings

### 3.1 Count Substring Occurrences

```java
String text = "The quick brown fox jumps over the lazy dog";
String target = "the";
int count = 0;

for (int i = 0; i < text.length() - target.length() + 1; i++) {
    String substring = text.substring(i, i + target.length());
    if (substring.equals(target)) {
        count++;
    }
}
System.out.println("Count: " + count);  // Output: Count: 1
```

Note: This is case-sensitive. "The" and "the" are different.

### 3.2 Filter Words Containing a Substring

```java
String[] words = {"hello", "world", "help", "beautiful", "python"};
String search = "el";

System.out.println("Words containing \"" + search + "\":");
for (int i = 0; i < words.length; i++) {
    if (words[i].indexOf(search) != -1) {
        System.out.println(words[i]);
    }
}
```

**Output:**
```
Words containing "el":
hello
help
beautiful
```

**How it works:**
- `indexOf(search)` returns the index if found, or `-1` if not found
- We check `if (... != -1)` to see if the substring exists

### 3.3 Count Words of Each Length

```java
String[] words = {"cat", "dog", "elephant", "bird", "fox"};

for (int length = 1; length <= 10; length++) {
    int count = 0;
    for (int i = 0; i < words.length; i++) {
        if (words[i].length() == length) {
            count++;
        }
    }
    if (count > 0) {
        System.out.println("Length " + length + ": " + count + " words");
    }
}
```

**Output:**
```
Length 3: 3 words
Length 4: 1 word
Length 8: 1 word
```

## 4. Building Strings with Loops and Conditionals

### 4.1 Filter String Elements

```java
String original = "a1b2c3d4e5";
String result = "";

for (int i = 0; i < original.length(); i++) {
    String current = original.substring(i, i + 1);
    if (!current.equals("0") && !current.equals("1") && !current.equals("2") && 
        !current.equals("3") && !current.equals("4") && !current.equals("5")) {
        result = result + current;
    }
}
System.out.println("Letters only: " + result);  // Output: Letters only: abcde
```

### 4.2 Replace Based on Condition

```java
String text = "I like cats and dogs";
String result = "";

for (int i = 0; i < text.length(); i++) {
    String current = text.substring(i, i + 1);
    if (current.equals("a")) {
        result = result + "*";
    } else {
        result = result + current;
    }
}
System.out.println(result);  // Output: I like c*ts *nd dogs
```

### 4.3 Build Abbreviated Text

```java
String[] words = {"apple", "banana", "cherry", "date"};
String abbreviation = "";

for (int i = 0; i < words.length; i++) {
    // Take first letter of each word
    abbreviation = abbreviation + words[i].substring(0, 1);
}
System.out.println("Abbreviation: " + abbreviation);  // Output: Abbreviation: abcd
```

## 5. Validating Strings

### 5.1 Check if String Matches Pattern

```java
// Check if a string only contains specific characters
String test = "aeiou";
boolean allVowels = true;

for (int i = 0; i < test.length(); i++) {
    String current = test.substring(i, i + 1);
    if (!current.equals("a") && !current.equals("e") && !current.equals("i") && 
        !current.equals("o") && !current.equals("u")) {
        allVowels = false;
        break;
    }
}

if (allVowels) {
    System.out.println("All vowels!");
} else {
    System.out.println("Contains consonants");
}
```

### 5.2 Check if String Starts or Ends with Substring

```java
String filename = "document.pdf";
String[] validExtensions = {".pdf", ".txt", ".doc"};
boolean isValid = false;

for (int i = 0; i < validExtensions.length; i++) {
    String ext = validExtensions[i];
    if (filename.length() >= ext.length()) {
        String ending = filename.substring(filename.length() - ext.length());
        if (ending.equals(ext)) {
            isValid = true;
            break;
        }
    }
}

if (isValid) {
    System.out.println("Valid file");
} else {
    System.out.println("Invalid file");
}
```

### 5.3 Find Starting Position Match

```java
String[] names = {"Alice", "Bob", "Anna", "Andrew", "Charlie"};

System.out.println("Names starting with 'A':");
for (int i = 0; i < names.length; i++) {
    if (names[i].substring(0, 1).equals("A")) {
        System.out.println(names[i]);
    }
}
```

**Output:**
```
Names starting with 'A':
Alice
Anna
Andrew
```

## 6. Common String + Loop Patterns

### 6.1 Concatenate Substrings

```java
String text = "Hello World Java";
String result = "";

for (int i = 0; i < text.length(); i++) {
    String current = text.substring(i, i + 1);
    if (!current.equals(" ")) {  // skip spaces
        result = result + current;
    }
}
System.out.println(result);  // Output: HelloWorldJava
```

### 6.2 Count Specific Substrings

```java
String text = "bookkeeper";
String target = "o";
int count = 0;

for (int i = 0; i < text.length(); i++) {
    String current = text.substring(i, i + 1);
    if (current.equals(target)) {
        count++;
    }
}
System.out.println("\"" + target + "\" appears " + count + " times");
```

**Output:** `"o" appears 2 times`

### 6.3 Extract Words with Same Prefix

```java
String[] words = {"java", "jump", "joke", "apple", "apricot", "banana"};
String prefix = "j";
String result = "";

for (int i = 0; i < words.length; i++) {
    if (words[i].substring(0, 1).equals(prefix)) {
        if (!result.equals("")) {
            result = result + ", ";
        }
        result = result + words[i];
    }
}
System.out.println("Words starting with '" + prefix + "': " + result);
```

**Output:** `Words starting with 'j': java, jump, joke`

## 7. Tracing Complex Examples

### Example: Count Substring Occurrences

```java
String text = "banana";
String search = "an";
int count = 0;

for (int i = 0; i < text.length() - search.length() + 1; i++) {
    String chunk = text.substring(i, i + search.length());
    if (chunk.equals(search)) {
        count++;
    }
}
System.out.println(count);
```

**Trace:**
| i | substring(i, i+2) | Equals "an"? | count |
|---|---|---|---|
| 0 | "ba" | No | 0 |
| 1 | "an" | Yes | 1 |
| 2 | "na" | No | 1 |
| 3 | "an" | Yes | 2 |

**Output:** 2

### Example 2: Build Result String

```java
String text = "hello";
String result = "";

for (int i = 0; i < text.length(); i++) {
    String current = text.substring(i, i + 1);
    if (current.equals("l")) {
        result = result + "*";  // replace 'l' with '*'
    } else {
        result = result + current;  // keep original
    }
}
System.out.println(result);  // Output: "he**o"
```

**Trace:**
| i | substring(i, i+1) | Action | result |
|---|---|---|---|
| 0 | "h" | Not 'l', add | "h" |
| 1 | "e" | Not 'l', add | "he" |
| 2 | "l" | Is 'l', add * | "he*" |
| 3 | "l" | Is 'l', add * | "he**" |
| 4 | "o" | Not 'l', add | "he**o" |

**Output:** "he**o"

## 8. Common Mistakes

| Mistake | Example | Problem | Fix |
|---------|---------|---------|-----|
| Using `==` instead of `.equals()` | `if (str1 == str2)` | Compares references, not content | Use `if (str1.equals(str2))` |
| Forgetting to check `-1` | `if (str.indexOf("x"))` | `-1` is truthy, returns wrong result | Use `if (str.indexOf("x") != -1)` |
| Off-by-one in substring loop | `for (int i = 0; i < s.length(); i++)` with `substring(i, i+2)` | Causes StringIndexOutOfBoundsException | Use `i < s.length() - 1` or `i + 2 <= s.length()` |
| Not breaking early | Loop continues unnecessarily after finding match | Inefficient or incorrect | Use `break` to exit when condition met |
| Forgetting to update result | Building string but not concatenating | Result stays empty | Always assign `result = result + ...` |

## Key Takeaways
- Loops and conditionals work together to filter, count, and process data intelligently
- String methods like `indexOf()`, `equals()`, `substring()`, and `length()` integrate with loops and if statements
- `indexOf()` returns `-1` if not found; always check for this special value
- `substring(i, i+1)` extracts single character as a string; useful in loops
- Use `equals()` to compare string content, not `==`
- Building strings by concatenating within loops creates new results without modifying originals
- Common patterns: counting occurrences, filtering elements, validating input, searching for patterns
- Always consider loop boundaries when using substring to avoid index errors

## Practice Problems

1) **Basic Filtering**: Write a loop that counts how many numbers in the array are greater than 5:
```java
int[] nums = {3, 8, 2, 9, 5, 1};
```

2) **String Search**: What does this code print?
```java
String text = "hello";
if (text.indexOf("ll") != -1) {
    System.out.println("Found");
}
```

3) **Count Substring**: Write a loop that counts how many times "l" appears in "hello" using substring.

4) **Filter Words**: Write code that counts how many words in this array have length greater than 3:
```java
String[] words = {"cat", "elephant", "dog", "butterfly"};
```

5) **Check if Contains**: Write a loop that checks if the string "world" contains the substring "or".

6) **Build Result String**: Write a loop that removes all spaces from "Hello World Java":
```java
String text = "Hello World Java";
String result = "";
// add code here
```

7) **Count Specific Substring**: Write a loop to count how many times "ab" appears in "abracadabra" using substring and equals.

8) **Filter Valid Strings**: Given an array of email-like strings, count how many contain "@":
```java
String[] emails = {"john@email", "test", "alice@domain.com", "noatsign"};
```

9) **Find Words Starting with Letter**: Write a loop that prints all words starting with "a":
```java
String[] words = {"apple", "banana", "apricot", "avocado", "cherry"};
```

10) **Find and Extract**: Write a loop that builds a string containing only words from an array that contain "ing":
```java
String[] words = {"running", "walking", "jump", "swimming", "sleep"};
```

11) **Challenge - Count Words Containing Substring**: Write code that counts how many words in an array contain a specific substring "or":
```java
String[] words = {"color", "world", "word", "door", "book"};
```

12) **Challenge - Build Acronym**: Write a loop that builds an acronym from the first character of each word in an array:
```java
String[] words = {"good", "bye", "world"};
// Output: "GBW"
```

13) **Challenge - Replace Substring Pattern**: Write a loop that replaces all occurrences of a two-character substring with another using substring and equals (without using String replace method):
```java
String text = "banana";
String oldSub = "an";
String newSub = "ON";
// Output: "bONONa"
```

14) **Challenge - Find Position of Nth Occurrence**: Write code to find the index where the 2nd occurrence of a substring appears:
```java
String text = "abracadabra";
String search = "ab";
// Find position of 2nd "ab"
```
