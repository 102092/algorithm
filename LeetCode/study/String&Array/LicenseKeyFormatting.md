## 강의풀이

```java
package main;

import java.io.*;

public class LicenseKeyFormatting {    
    public static void main(String[] args) throws IOException {   
        String str = "8F3Z-2e-9-wabcdef";
        int k = 4;
        solve(str,k);
    }

    private static void solve(String str, int k) {
        String newStr = str.replace("-", "").toUpperCase();
        int leng = newStr.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leng; i++) {
            sb.append(newStr.charAt(i));            
        }
        System.out.println("sb :" +sb);
        for (int i = k; i < leng; i=i+k) {//이부분이 핵심
            sb.insert(leng-i, '-');
            
        }
        System.out.println("After sb :" +sb);
    }
}
```

## 나의풀이



## 필요개념

- Stringbuffer, StringBuilder

- `-` 모두 제거, 대문자로 만들어주고, **뒤에서 4번째부터 끊는다**
- string의 `+` , `concat` 사용시 메모리를 많이 잡아먹으니까. 가능하면 StringBuilder를 사용

- 멀티쓰레드 synchronized, `StringBuffer` 사용
- 싱글쓰레드 asynchronized, `StringBuilder` 사용
  - 보통 후자것을 많이 쓴다. stringbuilder...