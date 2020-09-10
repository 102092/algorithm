

## 강의풀이

```java
package app;

public class WordSearch {
    public static void main(final String[] args) throws Exception {
        char[][] grid = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        WordSearch w = new WordSearch();
        System.out.println(w.solve(grid, word));

    }

    // dfs 기본 세팅 상, 하, 좌, 우
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int m, n;

    private boolean solve(char[][] grid, String word) {

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return false;
        m = grid.length; // 세로
        n = grid[0].length; // 가로

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(grid, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int x, int y, int start, String word) {
        if (start == word.length()) // 즉 별일 없이 word 마지막까지 간거니까...
            return true;
        if (x < 0 || x >= m || y < 0 || y >= n) // x : 행, y : 열
            return false;
        if (visited[x][y])
            return false;
        if (grid[x][y] != word.charAt(start))
            return false;

        visited[x][y] = true;
        for (int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if (dfs(grid, visited, dx, dy, start + 1, word)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
```

## 나의풀이



## 필요개념

- DFS

  Depth First Search

- `visited [][]` 배열 을 사용한다.