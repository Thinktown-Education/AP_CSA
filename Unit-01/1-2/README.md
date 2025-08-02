# Unit 1.2 Variables and Data Types

**Data Type** is a set of values and a set of operations on them. All java data types are either **primitive** or **reference** type. 

Primitive type data are directly stored in computer memory with raw values. \
Reference type data are stored in a blob of memory, where the address of the blob is saved for a variable.

In AP CSA, there are only 3 primitive data types:
1. int - integer
2. double - floating point numbers
3. boolean - true or false

--- 
**Variable**: a location in computer memory to temporarily store data. Variables are often used so that certain data can be used later in the program.

For example, you went to a restaurant for dinner. Below is a program to calculate your check:
```java
System.out.println("Subtotal:");
System.out.println(38 + 40 + 30);
System.out.println("Tax:");
System.out.println((38 + 40 + 30) * .08);
System.out.println("Tip:");
System.out.println((38 + 40 + 30) * .15);
System.out.println("Total:");
System.out.println(38 + 40 + 30 +
                  (38 + 40 + 30) * .08 +
                  (38 + 40 + 30) * .15);
```

Do you find something long and repetitive?