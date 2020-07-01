#### Longest Substring Without Repeating Characters（LeetCode num.3）

solution 1. 穷举

通过嵌套for循环计算出每个非repeating substrings的长度，选择最大的长度返回。

solution 2. 滑窗

类似于TCP中拥塞控制原理，用两个指针分别指示窗口的前端和后端，当后端的char是重复时，将前端指针已到该重复char处，并计算当前字符长度，比较后记录最大长度。

```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
```

#### Median of Two Sorted Arrays (Leetcode num.4)

solutions

只需要将两个数组切分成两部分，并满足

```
len(left_part) == len(right_part)
max(left_part) <= min(right_part)
```

为满足以上两个条件，需以下条件

```
1. i + j = m - i + n - j (or: m - i + n - j + 1)
	if n >= m, we just need to set: i = 0 ~ m, j = (m + n + 1) / 2 - i
2. B[j - 1] <= A[i] and A[i-1] <= B[j]
```

通过二分查找找出合适的i将两个数组切分

```
Searching i in [0, m], to find an object i such that:
	B[j-1] <= A[i] and A[i-1] <= B[j], where j = (m+n+1)/2 - i
```

在二分查找的循环中，有以下三种情况：

```
1.(j = 0 or i = m or B[j - 1] <= A[i]) and
	(i = 0 or j = n or A[i - 1] <= B[j])
	Means i is perfect, we can stop searching.
2. j > 0 and B[j-1] > A[i]
	Means i is too small, we must increase it.
3. i > 0 and A[i-1] > B[j]
	Means i is too big, we must decrease it.
```

当i找到之后，中位数为：

```
max(A[i-1],B[j-1]), when m+n is odd.
(max(A[i-1], B[j-1])+min(A[i], B[j]))/2, when m+n is even.
```

```java
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
```

#### Reverse Integer(leetcode num.7)

solution

Pop and Push Digits & Check  before Overflow

Pop逐一取出位数，Push将Pop中取出的数字合并

```
pop = x % 10; x /= 10;
temp = rev * 10 + pop; tev = temp;
```

判断rev是否溢出

```
1. if temp = rev*10 + pop >= INTMAX/10, causes overflow
2. if rev == INTMAX/10 & pop > 7, overflow
```

该条件适用于x为负数时

```java
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
```

#### Palindrome Number(leetcode num.9)

前提：不将数字转换成字符串

solution

只转换一半的数值，避免溢出的可能性，通过判断前半边跟后半边的相似性得出结果

有以下几种情况

```
1. x < 0 || (x % 10 == 0 && x != 0) , false;
2. reverseNumber == x(x不为原来的数) || reverseNumber/10 == x, true
```

```java
if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        
        return x == rev || x == rev / 1;
```

#### Integer to Roman(leetcode num.12)

solution

将需要转换的结果按位数使用不同的数组存下来，

求余取得相应位置上的数字，按数字取出相应的情况拼接起来即可。

```java
class Solution {
    public String intToRoman(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
```

#### Rotated Digits（788）

> X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
>
> A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

**solution**

```java
public int rotatedDigits(int N) {
    if (N <= 0)
        return 0;

    Set<Integer> good = new HashSet<>(Arrays.asList(2,5,6,9));
    Set<Integer> bad = new HashSet<>(Arrays.asList(3,4,7));
    boolean isValid;
    int count = 0;

    for (int i = 0; i <= N; i++) {
        isValid = false;
        int currentNumber = i;
        while(currentNumber > 0) {
            int bit = currentNumber % 10;
            currentNumber /= 10;
            if (bad.contains(bit)){
                isValid = false;
                break;
            }
            if (good.contains(bit)) {
                isValid = true;
            }
        }
        if (!isValid)
            continue;
        count++;
    }
    return count;
}
```



