## 강의풀이

```java
package main;

import java.io.*;
import java.util.*;


public class PlusOne {
    public static void main(String[] args) throws IOException {
        int[] digits = {1,2,3};
        //int [] digits = {9,9,9};
        int[] result = plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    private static int[] plusOne(int[] digits) {
      	//뒤에서 부터 시작한다.
        for (int i = digits.length-1; i >= 0; i--) {
            if(digits[i] != 9){
                digits[i]++;
                break;
            }else{
                digits[i] = 0;
            }
            
        }
        if(digits[0] == 0){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
    
}
```

## 나의풀이



## 필요개념

- 배열의 마지막에 1을 더함.
  - [9,9,9] - > [1,0,0,0] 
  - 좀 헷갈린다.
- 뒷자리부터 9가 있는지 체크한다.