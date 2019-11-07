

## 강의풀이

```java
package app.leetcode;

import java.util.*;

public class NumberOfIsland_BFS {
    public static void main(String[] args) throws Exception {
        // 2차원 배열
        char[][] grid = { { '1', '1', '1', '0', '1' }, { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '1' },
                { '0', '0', '0', '0', '1' } };
        NumberOfIsland_BFS n = new NumberOfIsland_BFS();
        System.out.println(n.numberOfIsland(grid));
    }

    private int numberOfIsland(char[][] grid) {

        // null 체크
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }

        }
        return count;
    }

    // 4방향을 탐색할 수 있는 directions
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { i, j });
        while (!q.isEmpty()) {
            int size = q.size();
            int[] point = q.poll();

            for (int k = 0; k < size; k++) {
                for (int[] dir : dirs) {
                    int x1 = point[0] + dir[0];
                    int y1 = point[1] + dir[1];
                    if (x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == '1') {
                        grid[x1][y1] = 'X';
                        q.offer(new int[] { x1, y1 });
                    }
                }
            }

        }
    }

}
```

## 나의풀이



## 필요개념

- BFS, 너비 우선 검색 , 큐를 사용해서
  - 우선 한 row부터 탐색함.
  - DFS는 stack을 사용

- DFS, BFS 개념에 대해 다시 공부하고, 두개가 어떤 차이가 있는지 알아보는게 좋겠다.