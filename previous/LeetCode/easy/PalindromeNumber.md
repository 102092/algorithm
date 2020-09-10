> https://leetcode.com/problems/palindrome-number/

## 나의풀이

```java
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x != 0 && x % 10 == 0) return false;

        int remain = 0;

        while(x > remain) {
            remain = (remain * 10) + (x % 10);
            x /= 10;
        }

        if(x == remain || x == remain / 10) {
            return true;
        }
        return false;

    }
}
```

## 필요개념

```java
int remain = 0;

while (x != 0) {
    remain = (remain * 10) + (x % 10);
    x /= 10;
}
```

- 정수를 뒤집는 방법
- 반만 뒤집어서 비교하면 된다..
