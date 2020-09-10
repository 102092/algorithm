> hhttps://www.acmicpc.net/problem/10989



## 작성 코드

```java
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int total = Integer.parseInt(br.readLine());

        int[] countArr = new int[10001];

        for (int input = 0; input < total ; input++) {
            countArr[Integer.parseInt(br.readLine())]++;
        }

        for (int index = 1; index < countArr.length; index++) {
            for (int count = 0; count < countArr[index]; count++) {
                bw.write(index +"\n");
            }

        }
        br.close();
        bw.close();

    }
}
```
