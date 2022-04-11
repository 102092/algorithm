```java
class Solution {
    
    public int solution(int[] absolutes, boolean[] signs) {
        if (absolutes.length == 1) {
            return  absolutes[0] * mutipleValue(signs[0]);
        }
        
        int result = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
            result += absolutes[i] * mutipleValue(signs[i]);
        }
        
        return result;
    }
    
    public int mutipleValue(boolean flag) {
        if (flag) {
            return 1;
        }
        return -1;
    }
}

```

- 제한사항
    - 크게 신경쓸 거 없는듯.
    - Integer 범위나.. 혹은 시간복잡도도..

- 시간복잡도
    - O(N)