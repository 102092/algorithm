> https://programmers.co.kr/learn/courses/30/lessons/42748



## 작성 코드

```java
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
                int start = commands[i][0]-1;
                int end = commands[i][1];
                int index = commands[i][2] -1;

            ArrayList<Integer> temp = new ArrayList<>();
            for (; start < end; start++) {
                temp.add(array[start]);
            }
            Collections.sort(temp);
            answer[i] = temp.get(index);

        }
        return answer;
    }
}
```
