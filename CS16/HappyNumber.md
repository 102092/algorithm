> https://leetcode.com/problems/happy-number/



## 작성 코드

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isHappy(int n) {
        return isHappyNumber(n);
    }
    
    public boolean isHappyNumber(int input) {
        Map<Integer, Integer> map = new HashMap<>();
        int key = input, value = 0;

        while (value != 1){
            if(!map.containsKey(key)){
                value = calculate(key);
                map.put(key, value);
                key = value;
            }else{
                value = map.get(key);
                break;
            }
        }
        return value == 1 ? true : false;
    }

    public int calculate(int input) {
        int res = 0;
        while (input > 0) {
            int remain = input % 10;
            res += remain * remain;
            input /= 10;
        }
        return res;
    }
}


```
