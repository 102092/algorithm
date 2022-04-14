```java

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        
        return answer;
    }
}

```

- 제한사항
    - 딱히 없었음.

- 시간복잡도
    - O(N)