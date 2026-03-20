# 2015模考错题集
16
20
22
26
31
32
37
38
40

## 重点复习章节
return细节，index和value要记得区分

Overload

Value/Reference semantics 26

看到recursion就要想到base case和recursive case

如何创建Array

## frq 答案
1a
```java
int sum = 0;
for (int i = 0; i < arr.length; i++) {
    sum += arr[i];
}
return sum;
```

1b
```java
int[] arrSum = new int[arr2D.length];
for (int i = 0; i < arr2D.length; i++) {
    arrSum[i] = arraySum(arr2D[i]);
}

return result;
```