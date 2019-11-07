

## 강의풀이

```java
package app.leetcode;

public class NumberOfIsland {
    public static void main(String[] args) throws Exception {
        // 2차원 배열
        char[][] grid = { { '1', '1', '1', '0', '1' }, { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '1' },
                { '0', '0', '0', '0', '1' } };
        NumberOfIsland n = new NumberOfIsland();
        System.out.println(n.solve(grid));
    }

    private int solve(char[][] grid) {
        print(grid);

        // null 예외 처리 처리
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        // 알고리즘 처리
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    System.out.print(" count grid[" + i + "][" + j + "] " + grid[i][j]);
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        System.out.println();
        print(grid);
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // System.out.println("i: " + i + " j: " + j);
        int m = grid.length;
        int n = grid[0].length;
        // 배열의 범위를 넘거나, 들어가는 좌표값이 바다('0')일 경우
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1' || grid[i][j] == 'X')
            return;
        grid[i][j] = 'X';
        // 육지('1')인 좌표만 들어와서 recursive 하게 4방향을 모두 볼 수 있도록
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    private void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // System.out.print(" grid[" + i + "][" + j + "] " + grid[i][j]);
                System.out.print(grid[i][j]);

            }
            System.out.println();
        }
    }
}
```

## 나의풀이



## 필요개념

- DFS
  - depth parse searching
  - 1은 육지 , 0은 바다
  - 결과값이 3
  - 어떻게 나왔을까?
    - 섬이 몇개나 있지?
    - 3개.
    - 이걸 어떻게 코드로 표현하지?

- 2차원 배열 프린트 하는 코드

  ```java
      private void print(char[][] grid) {
          for (int i = 0; i < grid.length; i++) {
              for (int j = 0; j < grid[i].length; j++) {
                  System.out.print(" grid[" + i + "][" + j + "] " + grid[i][j]);
  
              }
              System.out.println();
          }
  
  ```

  

1. (0,0) 1인 상태이면 들어감.

2. 좌우 4방향을 모두 살펴봐서 가봄.

   2.1 그렇지만 가본쪽인 0인 경우에는 들어가지 못함.

3. 예외처리 조건이 중요함.

4. 'X' 표식한 곳은 다시 방문하지 않도록.