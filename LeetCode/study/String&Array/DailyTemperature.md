## 강의풀이

```java
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) throws Exception {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = dailyTemperature(nums);

        System.out.println("=====result=====");
        for (int i : res) {
            System.out.print(i+" ");
            
        }
    }
    public static int[] dailyTemperature(int[] temper){
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[temper.length];

        for (int i = 0; i < temper.length; i++) {
            while (!stk.isEmpty() && temper[stk.peek()] < temper[i]) {
                //result[0] = 1-0
                int index = stk.pop();
                result[index] = i - index;
                
            }
            stk.push(i);
            
        }
        return result;
    }
}
```



## 나의풀이



## 필요개념

- Stack 사용

- 배열은 8개, 답은 7개. 음.. 입력된 배열의 첫번째 인자는 쓸모가 없나?
- 답이 된 배열을 보니까, 아마도 **인덱스**를 이용하지 않을까?
  - `Stack` 에 인덱스를 `push` 하는데,
  - 단계별로 생각하자 왜 답배열에서 1이 나왔을 까? 1을 어떻게 구해야할까?

- 75번 구간은 어떻게 해야하지? 이 문제에 답하는게 핵심