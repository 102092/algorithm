> https://leetcode.com/problems/reverse-integer/



## 작성 코드

```java
class Solution {
    public int reverse(int x) {
        int result = 0;        
        StringBuilder sb = new StringBuilder();
        char[] ch = String.valueOf(x).toCharArray();
        char[] res = new char[ch.length];
        int pointer = ch.length-1;
        
        for (int number = 0; number < ch.length; number++) {
            if(ch[number] == '-'){
                res[0] = '-';
                continue;
            }else{
                res[pointer] = ch[number];
                pointer--;
            }
        }
        
        
        for (int number = 0; number < res.length; number++) {
            sb.append(res[number]);
        }
        try{
            result = Integer.parseInt(String.valueOf(sb));
            return result;
        }catch(Exception e){
            return 0;
        }   
    }
}
```

- `char` 배열로 만들어서, 뒤집은 다음에, Integer로 parseing
  - 이과정에서 NumberFormatException..
  - https://jamesdreaming.tistory.com/126 참고하여 `Try~Catch 문 적용`



## 다른 코드

```java
    public int reverse(int x) {
        String ans = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
                : new StringBuilder(String.valueOf(x)).reverse().toString();
        try {
            return Integer.parseInt(ans);
        } catch (Exception e) {
            return 0;
        }
    }
```

- 내가 작성한 코드와 비슷한 개념을 사용한듯.
- StringBuilder에 `reverse()`가 있군.



```java
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }
```

- `Integer.MIN_VALUE, MAX_VALUE` Integer값을 리턴해야 하므로, 이 타입의 한계범위를 벗어난 값은 `return 0`
- `while` 문을 사용하여, 지속적인 사칙연산을 이용해서..