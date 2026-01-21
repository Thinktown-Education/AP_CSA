# Unit 4.3 Array Creation and Access

## Learning Goals

By the end of this unit, you will:
- Declare arrays of primitive and object types
- Understand the difference between declaration and instantiation
- Create arrays using the `new` keyword
- Initialize arrays with values
- Access array elements using index notation
- Understand zero-based indexing and identify boundary issues
- Use the `.length` property to determine array size

## 1. What is an Array?

**Array**: A collection of variables of the same type stored together in memory and accessed using an index.

Instead of creating separate variables like `score1`, `score2`, `score3`, an array allows you to store all scores in one structure: `scores`. This makes working with large amounts of related data efficient.

Example motivation:
```java
// Without array (inefficient)
int score1 = 85;
int score2 = 92;
int score3 = 78;
int score4 = 88;

// With array (efficient)
int[] scores = {85, 92, 78, 88};
```

## 2. Declaring Arrays

To declare an array, use the syntax:

```java
dataType[] arrayName;
```

Examples:
```java
int[] numbers;
double[] prices;
String[] names;
Student[] roster;
boolean[] flags;
```

**Important**: Declaration only creates a reference, not the actual array. The array is initially `null`.

```java
int[] scores;
System.out.println(scores);  // Prints: null (no array exists yet)
```

## 3. Creating (Instantiating) Arrays

To create an actual array in memory, use the `new` keyword:

```java
arrayName = new dataType[size];
```

The size must be a positive integer and cannot change after creation.

Examples:
```java
int[] numbers = new int[5];           // Array of 5 integers
String[] names = new String[10];      // Array of 10 strings
double[] prices = new double[100];    // Array of 100 doubles
Student[] students = new Student[3];  // Array of 3 Student references
```

You can declare and create in one statement:
```java
int[] numbers = new int[5];
```

### 3.1 Default Values

When an array is created, all elements are automatically initialized to default values:
- **int, double, float**: `0` or `0.0`
- **boolean**: `false`
- **Objects (String, Student, etc.)**: `null`

```java
int[] numbers = new int[3];
System.out.println(numbers[0]);       // Prints: 0

String[] names = new String[3];
System.out.println(names[0]);         // Prints: null

boolean[] flags = new boolean[3];
System.out.println(flags[0]);         // Prints: false
```

## 4. Initializing Arrays with Values

### 4.1 Individual Element Assignment

Assign values to each element after creation:
```java
int[] scores = new int[3];
scores[0] = 85;
scores[1] = 92;
scores[2] = 78;
```

### 4.2 Array Initializer (Shorthand)

Provide initial values when creating the array:
```java
int[] scores = {85, 92, 78};
double[] prices = {19.99, 24.50, 15.00};
String[] colors = {"red", "green", "blue"};
Student[] students = {
    new Student("Alice", 85),
    new Student("Bob", 92)
};
```

Java automatically determines the size based on the number of values.

## 5. Accessing Array Elements

Use the index in square brackets to access an element:

```java
arrayName[index]
```

### 5.1 Zero-Based Indexing

Array indices start at **0**, not 1. This is crucial!

```java
String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
//          Index:  0          1          2            3         4

System.out.println(days[0]);    // Prints: Monday
System.out.println(days[2]);    // Prints: Wednesday
System.out.println(days[4]);    // Prints: Friday
```

For an array of size n:
- **First element**: `array[0]`
- **Last element**: `array[n-1]`

### 5.2 Reading and Modifying Elements

You can read values:
```java
int[] numbers = {10, 20, 30, 40, 50};
int value = numbers[1];  // value is 20
```

You can modify values:
```java
int[] numbers = {10, 20, 30, 40, 50};
numbers[1] = 25;         // Array is now {10, 25, 30, 40, 50}
```

You can use elements in expressions:
```java
int[] scores = {85, 92, 78};
int total = scores[0] + scores[1] + scores[2];  // total is 255
```

## 6. The `.length` Property

Every array has a `.length` property that stores the number of elements:

```java
int[] numbers = {10, 20, 30, 40, 50};
System.out.println(numbers.length);   // Prints: 5

String[] names = new String[100];
System.out.println(names.length);     // Prints: 100
```

**Note**: `.length` is a property, not a method. Use `array.length`, not `array.length()`.

The last valid index is always `array.length - 1`:
```java
int[] scores = {85, 92, 78};
// Valid indices: 0, 1, 2
// Last index: scores.length - 1 = 2
```

## 7. Arrays of Primitives vs Arrays of Objects

### 7.1 Arrays of Primitives

Each element holds an actual value:
```java
int[] numbers = new int[3];
numbers[0] = 5;
numbers[1] = 10;
numbers[2] = 15;

System.out.println(numbers[0]);  // Prints: 5
```

### 7.2 Arrays of Objects

Each element holds a **reference** to an object (or `null`):
```java
Student[] roster = new Student[3];
// All elements are null at this point
```

You must create the objects separately:
```java
Student[] roster = new Student[3];
roster[0] = new Student("Alice", 85);
roster[1] = new Student("Bob", 92);
roster[2] = new Student("Charlie", 78);

System.out.println(roster[0].getName());  // Prints: Alice
```

**Complete Example:**
```java
class Student {
    private String name;
    private int grade;
    
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
    
    public String getName() { return name; }
    public int getGrade() { return grade; }
}

// Usage:
Student[] students = new Student[2];
students[0] = new Student("Alice", 85);
students[1] = new Student("Bob", 92);

System.out.println(students[0].getName());   // Prints: Alice
System.out.println(students[0].getGrade());  // Prints: 85
```

## 8. Common Errors

### 8.1 Index Out of Bounds

Accessing an index that doesn't exist causes `ArrayIndexOutOfBoundsException`:
```java
int[] scores = new int[3];
System.out.println(scores[3]);  // ERROR! Valid indices are 0, 1, 2
```

### 8.2 Null Pointer Exception

Using object array elements before initialization:
```java
Student[] students = new Student[3];
System.out.println(students[0].getName());  // ERROR! students[0] is null
```

Fix: Initialize the object first:
```java
Student[] students = new Student[3];
students[0] = new Student("Alice", 85);
System.out.println(students[0].getName());  // Works: Prints "Alice"
```

### 8.3 Using Array Before Creation

Forgetting to use `new`:
```java
int[] numbers;
numbers[0] = 5;  // ERROR! Array was never created
```

Fix: Use `new` to create the array:
```java
int[] numbers = new int[5];
numbers[0] = 5;  // Now it works
```

### 8.4 Off-by-One Error

A common mistake when working with `.length`:
```java
int[] scores = {85, 92, 78};
System.out.println(scores[scores.length]);  // ERROR! Index 3 is out of bounds
System.out.println(scores[scores.length - 1]);  // Correct: Prints 78
```

## Key Takeaways

- **Array**: A collection of same-type elements accessed by zero-based index
- **Declaration**: `dataType[] name;` creates a reference (value is `null`)
- **Creation**: `new dataType[size]` creates the actual array in memory
- Arrays are **zero-indexed**: first element is at index 0, last is at index `length - 1`
- Access elements: `array[index]` for reading or modifying
- **`.length` property**: Gives the number of elements (read-only, cannot change)
- **Primitive arrays**: Elements hold actual values
- **Object arrays**: Elements hold references; must initialize each object
- **Index out of bounds**: Accessing invalid indices causes a runtime error
- Use `.length - 1` to access the last element safely

## Practice Problems

1. Declare an array variable named `temperatures` that can hold 7 double values.

2. Create an array of 5 integers and initialize all elements to 0 using the `new` keyword.

3. Create and initialize an array named `colors` with the values: "red", "green", "blue", "yellow", "purple".

4. Given `int[] nums = {10, 20, 30, 40, 50};`, what will `System.out.println(nums[2]);` print?

5. Given `String[] days = {"Mon", "Tue", "Wed"};`, what is the value of `days.length`?

6. Write code to access the last element of an array `int[] scores` without using a specific index number (use `.length`).

7. Create an array of 4 integers, then change the element at index 1 to the value 99.

8. Given `double[] prices = new double[5];`, what is the default value of `prices[0]`?

9. Create a Student array of size 3 and initialize the first Student object with name "Alice" and grade 90.

10. Explain why `int[] arr = new int[5]; System.out.println(arr[5]);` causes an error.

11. Write a statement to copy the first element of array `source` to array `destination`.

12. Create an array of Student objects with 2 students and explain why you must use `new` for each Student before accessing methods.

