> https://programmers.co.kr/learn/courses/30/lessons/77884

```java
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        
        for (int i = left; i <= right; i++) {
            if (hasEvenDivisor(i)) {
                answer += i;
                continue;
            }
            answer -= i;
        }
        
        return answer;
    }
    
    public boolean hasEvenDivisor(int target) {
        int count = 0;
        
        for (int i = 1; i <= target; i++) {
            if (target % i == 0) {
                count++;
            }
        }
        
        return count % 2 == 0;
    }
}
```

- 시간복잡도
    - O(N)

- 기타
    - 홀수 odd, 짝수 even
    - 약수에 대해 조금 더 효율적으로 구할 수 있는 방법이 있을듯.
    - [참고](https://mygumi.tistory.com/122)
