## 강의풀이

```java
package app;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
      	//2차원배열만들기
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9 } };

        System.out.println(solve(matrix));

    }

    private static List<Integer> solve(int[][] matrix) {

        // 1. null체크
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return result;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
	
      	// 2. 배열 순환시키기
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 오른쪽
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // 오른쪽 끝에서 아래로
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // 오른쪽 아래 끝에서 왼쪽으로
            if (rowStart <= rowEnd)
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            rowEnd--;

            // 맨 왼쪽서 하나 올라가기
            if (colStart <= colEnd)
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            colStart++;

        }
        return result;
    }
}
```

## 나의풀이



## 필요개념

- 2차원배열
  - row 가로
  - colum 세로
- 좌표에 대한 규칙을 찾아라
- 너무 어렵게 생각하지 말고..



