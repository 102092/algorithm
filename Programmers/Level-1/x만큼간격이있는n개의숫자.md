> https://programmers.co.kr/learn/courses/30/lessons/12954

## 나의풀이

```java
class Solution {
  public long[] solution(int x, int n) {
      long[] answer = new long[n];
      long result = 0;

      for(int i = 0; i < n; i++) {
          result += x;
          answer[i] = result;
       }
      return answer;
  }
}
```

## 필요개념
