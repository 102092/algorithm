> https://programmers.co.kr/learn/courses/30/lessons/42578



## 작성 코드

```java
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        answer = clotheCombination(clothes);
        return answer;
    }
     private int clotheCombination(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();
        int result = 1;
        int type =1;

        for (int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][type])){
                map.replace(clothes[i][type], map.get(clothes[i][type])+1);
            }else{
                map.put(clothes[i][type], 1);
            }
        }

        int notSelect =1;
        int notAllselect = 1;
        for(int count : map.values()){
            result *= (count +notSelect);
        }

        result -= notAllselect;
        return result;
    }
}
```
