# FRQ for unit 1 and 2

## 1
Write a method that counts the number of consonants in the parameter word. You can assume that the word is all in lower case. Use the method boolean isConsonant(String letter) to determine if a single letter is a consonant. For example, isConsonant("a") will return false, while isConsonant("x") will return true. 

Example 1:
> Input: "hello"
> 
> Output: 3 (the consonants are 'h', 'l', and 'l')

Example 2:
> Input: "apple"
> 
> Output: 3 (the consonants are 'p', 'p', and 'l')

Example 3:
> Input: "aeiou"
> 
> Output: 0 (there are no consonants)

Complete the below method:

```java
public static int countConsonants(String word) {
    // Your code goes here
}
```


## 2
Write a method that finds the product of the number of digits in num

Example 1:
> Input: 1234
> 
> Output: 24 (1 * 2 * 3 * 4 = 24)

 Example 2:
> Input: 405
> 
> Output: 0 (4 * 0 * 5 = 0)

Complete the below method:

```java
public static int productOfDigits(int num) {
    // Your code goes here
}
```

## 3
A mathematical sequence is an ordered list of numbers. This question involves a sequence called a hailstone
sequence. If n is the value of a term in the sequence, then the following rules are used to find the next term, if
one exists.
- If n is 1, the sequence terminates.
- If n is even, then the next term is n/2
- If n is odd, then the next term is 3n + 1.

For this question, assume that when the rules are applied, the sequence will eventually terminate with the term
n = 1.

The following are examples of hailstone sequences.
Example 1: 5, 16, 8, 4, 2, 1
- The first term is 5, so the second term is 5 * 3 + 1 = 16.
- The second term is 16, so the third term is $\frac{16}{2}$ = 8.
- The third term is 8, so the fourth term is $\frac{8}{2}$ = 4.
- The fourth term is 4, so the fifth term is $\frac{4}{2}$ = 2.
- The fifth term is 2, so the sixth term is $\frac{2}{2}$ = 1.
- Since the sixth term is 1, the sequence terminates.

Example 2: 8, 4, 2, 1
- The first term is 8, so the second term is $\frac{8}{2}$ = 4.
- The second term is 4, so the third term is $\frac{4}{2}$ = 2.
- The third term is 2, so the fourth term is $\frac{2}{2}$ = 1.
- Since the fourth term is 1, the sequence terminates.

The Hailstone class, shown below, is used to represent a hailstone sequence. You will write three methods
in the Hailstone class.

```java
public class Hailstone {
	/**
	 * Returns the length of a hailstone sequence that starts with n, as described
	 * in part (a). Precondition: n > 0
	 */
	public static int hailstoneLength(int n) {
		/* to be implemented in part (a) */ }

	/**
	 * Returns true if the hailstone sequence that starts with n is considered long
	 * and false otherwise, as described in part (b). Precondition: n > 0
	 */
	public static boolean isLongSeq(int n) {
		/* to be implemented in part (b) */ }

	/**
	 * Returns the proportion of the first n hailstone sequences that are considered
	 * long, as described in part (c). Precondition: n > 0
	 */
	public static double propLong(int n) {
		/* to be implemented in part (c) */ }
    
    // There may be instance variables, constructors, and methods not shown.
}
```

### a
The length of a hailstone sequence is the number of terms it contains. For example, the hailstone
sequence in example 1 (5, 16, 8, 4, 2, 1) has a length of 6 and the hailstone sequence in example 2
(8, 4, 2, 1) has a length of 4.
Write the method hailstoneLength(int n), which returns the length of the hailstone sequence
that starts with n.

```java
/** Returns the length of a hailstone sequence that starts with n, as described in part (a).
* Precondition: n > 0
*/
public static int hailstoneLength(int n)
```

### b
A hailstone sequence is considered long if its length is greater than its starting value. For example, the
hailstone sequence in example 1 (5, 16, 8, 4, 2, 1) is considered long because its length (6) is greater
than its starting value (5). The hailstone sequence in example 2 (8, 4, 2, 1) is not considered long
because its length (4) is less than or equal to its starting value (8).

Write the method isLongSeq(int n), which returns true if the hailstone sequence starting
with n is considered long and returns false otherwise. Assume that hailstoneLength
works as intended, regardless of what you wrote in part (a). You must use hailstoneLength appropriately to receive full credit

```java
 /** Returns true if the hailstone sequence that starts with n is considered long
* and false otherwise, as described in part (b).
* Precondition: n > 0
*/
public static boolean isLongSeq(int n)
```

### c
The method propLong(int n) returns the proportion of long hailstone sequences with starting values between 1 and n, inclusive. 

Examples:
- If n = 5, the hailstone sequences starting with 1, 2, 3, 4, and 5 are:
  - 1 (length 1, not long)
  - 2, 1 (length 2, not long)
  - 3, 10, 5, 16, 8, 4, 2, 1 (length 8, long)
  - 4, 2, 1 (length 3, not long)
  - 5, 16, 8, 4, 2, 1 (length 6, long)
  
Of these five sequences, two are long. Therefore, propLong(5) returns 0.4.

Write the propLong method. Assume that hailstoneLength and isLongSeq work as
intended, regardless of what you wrote in parts (a) and (b). You must use isLongSeq appropriately to
receive full credit.

```java
/** Returns the proportion of the first n hailstone sequences that are considered long,
* as described in part (c).
* Precondition: n > 0
*/
public static double propLong(int n)
```