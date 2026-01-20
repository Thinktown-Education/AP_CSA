# Unit 3.6 — Methods: Passing and Returning References of an Object

## Learning Goals
By the end of this unit, you will:
- Understand that objects are passed by reference, not by value
- Know how to pass objects to methods
- Understand how methods can modify objects passed to them
- Know how to return objects from methods
- Understand aliasing and how multiple variables can refer to the same object
- Learn to write methods that accept and return objects
- Understand null references and how to check for them
- Use objects as parameters and return values effectively
- Avoid common pitfalls with object references

## 1. Objects Are References, Not Values

### 1.1 Primitives vs. Objects

**Primitives (int, double, boolean):**
```java
int x = 5;
int y = x;  // y gets a copy of 5
y = 10;     // y changes
System.out.println(x);  // Still 5 (unchanged)
```

When you assign a primitive, the value is copied.

**Objects (Student, String, etc.):**
```java
Student s1 = new Student("Alice");
Student s2 = s1;  // s2 gets a reference to the same object
s2.setName("Alicia");  // Changes the object
System.out.println(s1.getName());  // "Alicia" (changed!)
```

When you assign an object, you copy the reference, not the object itself.

### 1.2 What Is a Reference?

A **reference** is like an address or pointer to an object in memory.

```
Memory:
┌─────────────────────────────────┐
│ Student object                  │
│ name = "Alice"                  │
│ gradeLevel = 10                 │
│ gpa = 3.8                       │
│ (memory address: 0x1234)        │
└─────────────────────────────────┘

In your code:
Student s1 = new Student("Alice");
// s1 holds the address: 0x1234

Student s2 = s1;
// s2 also holds the address: 0x1234
// s1 and s2 refer to the SAME object
```

## 2. Passing Objects to Methods

When you pass an object to a method, you pass a reference to it.

### 2.1 Method Receives Reference

```java
public class Example {
    public void modifyStudent(Student s) {
        // s is a reference to the object
        s.setName("Modified");  // Changes the original
    }
}

// In main:
Student alice = new Student("Alice", 10, 3.8);
Example ex = new Example();
ex.modifyStudent(alice);
System.out.println(alice.getName());  // "Modified" (changed!)
```

**Why?** The method receives a reference to the same object, so any changes affect the original.

### 2.2 Real Example: BankAccount Transfer

```java
public class Bank {
    public void transfer(BankAccount from, BankAccount to, double amount) {
        from.withdraw(amount);  // Changes 'from' object
        to.deposit(amount);     // Changes 'to' object
    }
}
```

Using it:
```java
BankAccount alice = new BankAccount("111", "Alice", 1000);
BankAccount bob = new BankAccount("222", "Bob", 500);

Bank bank = new Bank();
bank.transfer(alice, bob, 200);

System.out.println(alice.getBalance());  // 800 (changed!)
System.out.println(bob.getBalance());    // 700 (changed!)
```

### 2.3 Passing Multiple Objects

```java
public class ClassRoom {
    public void seatStudents(Student s1, Student s2, Student s3) {
        System.out.println("Seating " + s1.getName());
        System.out.println("Seating " + s2.getName());
        System.out.println("Seating " + s3.getName());
    }
}
```

Each parameter is a reference to an object:
```java
Student alice = new Student("Alice");
Student bob = new Student("Bob");
Student charlie = new Student("Charlie");

ClassRoom room = new ClassRoom();
room.seatStudents(alice, bob, charlie);  // Three references passed
```

## 3. Methods Cannot Reassign Object Parameters

### 3.1 Important Distinction

When you pass an object, the method receives a reference to it. However, the method **cannot change what the reference points to** in the caller's code.

**This doesn't work:**
```java
public class Example {
    public void replaceStudent(Student s) {
        s = new Student("Different");  // Creates new object
        // Only the local variable 's' changes
        // The original reference in main is unchanged
    }
}

// In main:
Student alice = new Student("Alice");
Example ex = new Example();
ex.replaceStudent(alice);
System.out.println(alice.getName());  // Still "Alice"
```

**Why?** The method creates a new object, but this only affects the local reference `s`. The `alice` reference in main still points to the original object.

### 3.2 What You CAN Do

You can modify the object's fields:
```java
public class Example {
    public void modifyStudent(Student s) {
        s.setName("Modified");  // This works—changes the object
    }
}

// In main:
Student alice = new Student("Alice");
Example ex = new Example();
ex.modifyStudent(alice);
System.out.println(alice.getName());  // "Modified" (changed!)
```

## 4. Returning Objects

Methods can return object references.

### 4.1 Return an Existing Object

```java
public class Library {
    private Student[] students = new Student[10];
    
    public Student findStudent(String name) {
        for (Student s : students) {
            if (s != null && s.getName().equals(name)) {
                return s;  // Return reference to found student
            }
        }
        return null;  // Not found
    }
}
```

Using it:
```java
Library lib = new Library();
Student found = lib.findStudent("Alice");
if (found != null) {
    System.out.println(found.getName());
    found.setGpa(4.0);  // Modifies the original student
}
```

### 4.2 Return a New Object

```java
public class StudentFactory {
    public Student createStudent(String name, int grade, double gpa) {
        return new Student(name, grade, gpa);  // Return new object
    }
}
```

Using it:
```java
StudentFactory factory = new StudentFactory();
Student s = factory.createStudent("Alice", 10, 3.8);
System.out.println(s.getName());  // "Alice"
```

### 4.3 Return Objects from Arrays

```java
public class ClassRoom {
    private Student[] students;
    
    public Student getTopStudent() {
        Student top = students[0];
        for (Student s : students) {
            if (s.getGpa() > top.getGpa()) {
                top = s;
            }
        }
        return top;  // Return reference to top student
    }
}
```

## 5. Aliasing

**Aliasing** occurs when two variables refer to the same object.

### 5.1 Creating Aliases

```java
Student alice = new Student("Alice", 10, 3.8);
Student student = alice;  // student is an alias for alice

// They refer to the same object
System.out.println(alice == student);  // true
System.out.println(alice.getName());   // "Alice"

student.setName("Alicia");
System.out.println(alice.getName());   // "Alicia" (also changed!)
```

### 5.2 Aliases from Method Parameters

```java
public class Example {
    public void createAlias(Student original) {
        Student alias = original;  // Alias created
        alias.setName("Different");
        // The original object is modified
    }
}

Student alice = new Student("Alice");
Example ex = new Example();
ex.createAlias(alice);
System.out.println(alice.getName());  // "Different"
```

### 5.3 Aliases from Method Return

```java
public class Library {
    private Student[] students;
    
    public Student getStudent(int index) {
        return students[index];  // Returns reference (alias)
    }
}

Library lib = new Library();
Student s1 = lib.getStudent(0);
Student s2 = lib.getStudent(0);

// s1 and s2 are aliases for the same object
s1.setGpa(4.0);
System.out.println(s2.getGpa());  // 4.0 (same object)
```

## 6. Null References

**null** means "no object"—the reference doesn't point to anything.

### 6.1 Null References

```java
Student s = null;  // No object
System.out.println(s);  // null

// Trying to use null causes an error
System.out.println(s.getName());  // NullPointerException!
```

### 6.2 Methods Can Return null

```java
public class Library {
    public Student findStudent(String name) {
        // ... search logic ...
        return null;  // Not found
    }
}
```

### 6.3 Checking for null

**Always check before using a reference:**

```java
Library lib = new Library();
Student found = lib.findStudent("Alice");

if (found != null) {
    System.out.println(found.getName());
} else {
    System.out.println("Student not found");
}
```

**Good practice:**
```java
if (s != null) {
    // Safe to use s
    s.setName("New Name");
}
```

## 7. Comparing Objects

### 7.1 == vs. equals()

```java
Student s1 = new Student("Alice", 10, 3.8);
Student s2 = new Student("Alice", 10, 3.8);
Student s3 = s1;

// == checks if references are the same
System.out.println(s1 == s2);   // false (different objects)
System.out.println(s1 == s3);   // true (same object)

// equals() checks if content is the same (if implemented)
System.out.println(s1.equals(s2));  // Depends on equals() method
```

### 7.2 When to Use Each

```java
// Use == to check if it's the SAME OBJECT
if (s1 == s2) {
    System.out.println("Same student");
}

// Use equals() to check if CONTENT IS EQUAL
if (s1.equals(s2)) {
    System.out.println("Students have same data");
}
```

## 8. Complete Example: StudentList Class

```java
public class StudentList {
    private Student[] students;
    private int count;
    
    public StudentList() {
        students = new Student[10];
        count = 0;
    }
    
    // Add a student (receives reference)
    public void addStudent(Student s) {
        if (count < students.length && s != null) {
            students[count] = s;  // Store reference
            count++;
        }
    }
    
    // Find student by name (returns reference)
    public Student findStudent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].getName().equals(name)) {
                return students[i];  // Return reference
            }
        }
        return null;  // Not found
    }
    
    // Get student at index (returns reference)
    public Student getStudent(int index) {
        if (index >= 0 && index < count) {
            return students[index];
        }
        return null;
    }
    
    // Move a student to front (modifies object order)
    public void moveToFront(Student s) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (students[i] == s) {  // Check if same object
                index = i;
                break;
            }
        }
        
        if (index > 0) {
            // Shift elements
            for (int i = index; i > 0; i--) {
                students[i] = students[i - 1];
            }
            students[0] = s;
        }
    }
    
    // Create a copy of the list (returns new objects)
    public StudentList createCopy() {
        StudentList copy = new StudentList();
        for (int i = 0; i < count; i++) {
            // Could make a copy of each student here
            copy.addStudent(students[i]);  // Or just reference
        }
        return copy;
    }
}
```

Using the class:
```java
StudentList list = new StudentList();

Student alice = new Student("Alice", 10, 3.8);
Student bob = new Student("Bob", 11, 3.5);
Student charlie = new Student("Charlie", 10, 3.2);

list.addStudent(alice);
list.addStudent(bob);
list.addStudent(charlie);

Student found = list.findStudent("Alice");
if (found != null) {
    found.setGpa(3.9);  // Modifies alice (same reference)
}

list.moveToFront(found);  // Move alice to front

StudentList copy = list.createCopy();
System.out.println(copy.getStudent(0).getName());  // "Alice"
```

## 9. Defensive Copying

Sometimes you want to protect your objects from being modified by methods that receive them.

### 9.1 Problem: Unwanted Modifications

```java
public class Example {
    private Student student;
    
    public void setStudent(Student s) {
        this.student = s;
    }
    
    public Student getStudent() {
        return this.student;
    }
}

// Outside code:
Student alice = new Student("Alice", 10, 3.8);
Example ex = new Example();
ex.setStudent(alice);

Student retrieved = ex.getStudent();
retrieved.setGpa(0.0);  // Modifies the original student!
System.out.println(alice.getGpa());  // 0.0 (unwanted change!)
```

### 9.2 Solution: Defensive Copy

If a class needs to protect its objects, it can create copies:

```java
public class Example {
    private Student student;
    
    public void setStudent(Student s) {
        // Make a copy instead of storing reference
        this.student = new Student(s.getName(), s.getGradeLevel(), s.getGpa());
    }
    
    public Student getStudent() {
        // Return a copy, not the original
        return new Student(student.getName(), student.getGradeLevel(), student.getGpa());
    }
}
```

Now outside code cannot modify the internal student.

## 10. Common Patterns

### 10.1 Search and Return Pattern

```java
public Student findByName(String name) {
    for (Student s : students) {
        if (s != null && s.getName().equals(name)) {
            return s;  // Return reference to found object
        }
    }
    return null;  // Return null if not found
}
```

### 10.2 Create and Return Pattern

```java
public Student createNewStudent(String name, int grade) {
    Student newStudent = new Student(name, grade, 0.0);
    return newStudent;  // Return reference to new object
}
```

### 10.3 Modify and Return Pattern

```java
public Student promoteStudent(Student s) {
    s.setGradeLevel(s.getGradeLevel() + 1);
    return s;  // Return same reference (already modified)
}
```

## 11. Debugging Reference Problems

### 11.1 Problem: NullPointerException

**Error:**
```java
Student s = null;
System.out.println(s.getName());  // NullPointerException!
```

**Solution:**
```java
Student s = null;
if (s != null) {
    System.out.println(s.getName());
} else {
    System.out.println("Student is null");
}
```

### 11.2 Problem: Unexpected Modifications

**Error:**
```java
Student s1 = new Student("Alice");
Student s2 = s1;
s2.setName("Bob");
System.out.println(s1.getName());  // "Bob" (unexpected!)
```

**Solution:** Remember that s1 and s2 are aliases—changing one affects the other. If you need independent objects, create a copy.

### 11.3 Problem: Comparing with ==

**Error:**
```java
Student s1 = new Student("Alice");
Student s2 = new Student("Alice");
if (s1 == s2) {  // false! Different objects
    System.out.println("Same student");
}
```

**Solution:**
```java
if (s1.equals(s2)) {  // Use equals() for content comparison
    System.out.println("Same student");
}
```

## Key Takeaways
- Objects are passed by reference, not by value—changes inside methods affect the original
- Methods receive references (addresses) to objects, not copies
- Methods cannot reassign what a reference points to in the caller's code, but can modify the object itself
- Methods can return object references, creating aliases
- Aliasing occurs when multiple variables refer to the same object
- null means "no object"—always check for null before using references
- Use == to check if two references point to the same object
- Use equals() to check if two objects have the same content
- Defensive copying can protect objects from unwanted modifications
- Understanding references is fundamental to object-oriented programming

## Practice Problems

1) **Pass and Modify**: Write a method that takes a `Student` object and increases their GPA by 0.1. Show that the original student object is modified.

2) **Return Object**: Write a method that creates a new `Student` object with given parameters and returns it.

3) **Null Check**: Write a method that searches for a student in an array and returns null if not found. Show proper null checking.

4) **Aliases**: Explain what happens in this code and why:
```java
Student s1 = new Student("Alice", 10, 3.8);
Student s2 = s1;
s2.setName("Bob");
System.out.println(s1.getName());
```

5) **Multiple Objects as Parameters**: Write a method that takes two `Student` objects and swaps their GPAs (modifies both objects).

6) **Return from Array**: Write a method that takes an array of `Student` objects and returns the student with the highest GPA.

7) **== vs equals()**: Explain the difference between using `==` and `equals()` when comparing two `Student` objects.

8) **Passing Multiple References**: Write a method called `transfer()` for a bank that takes two `BankAccount` objects and an amount, then transfers money from one account to the other.

9) **Finding Objects**: Write a method that searches a list of `Student` objects for those whose GPA is above 3.5, and returns an array of references to those students.

10) **Defensive Copying**: Write a `StudentRecord` class with methods `setStudent()` and `getStudent()` that use defensive copying to protect internal student objects.

11) **Creating Objects in Methods**: Write a factory method that creates an array of `Student` objects with sample data and returns it.

12) **Challenge - Reference Tracking**: Write a `ClassRoom` class that:
    - Can add students (pass Student objects)
    - Can find a student by name (return Student reference)
    - Can get the top student by GPA (return Student reference)
    - Demonstrate that modifying returned students affects the classroom's students

13) **Challenge - Aliasing and Modification**: Explain aliasing with a complete example. Show how modifying an alias affects the original, and explain why this happens with objects but not primitives.

14) **Challenge - Design a Robust Collection**: Write a `StudentCollection` class that:
    - Stores students safely without exposing internal references
    - Uses defensive copying in getters to prevent external modification
    - Provides methods to add, find, and list students
    - Handles null values gracefully
