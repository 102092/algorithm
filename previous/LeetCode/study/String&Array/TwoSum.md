## 강의풀이

```java
package main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    public static void main(String[] args) throws IOException {
        int[] nums = {2, 8, 11, 21};
        int target = 10;

        TwoSum a = new TwoSum();
        int[] results = a.solve(nums, target);    
        
       for (int i : results) {
           System.out.print(i+" ");
           
       }
    }

    private int[] solve(int[] nums, int target) {
        //답을 담을 장소
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        //주어진 배열을 돌아가면서 찾아야하니까 -> for문
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){//key 값이 있으면
                int mapValue = map.get(nums[i]); //i = 1, mapValue = 0 ; map(8,0)이니까
                result[0] = mapValue + 1; //1
                result[1] = i + 1; //2
                break;
            }else{
                map.put(target-nums[i], i); //10-2 = 8 , i = 0
            }

            
        }
        return result;
    }
    
}
```

## 나의풀이



## 필요개념

- 문제를 제대로 해석하고, 요구하는 바를 알아야함
  - `Map, Array`를 이용해야 겠구나
- 주어진 배열을 두개를 더하여 ` target ` 값이 되는 두가지의 `int`요소를 출력하는 문제