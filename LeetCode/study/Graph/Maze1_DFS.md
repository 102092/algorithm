

## 강의풀이

```java
package coding.test.graph;

public class Maze1_DFS {

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		// int[] dest = { 3, 4 };
		int[] dest = { 4, 4 };
		Maze1_DFS mb = new Maze1_DFS();
		System.out.println(mb.hasPath(maze, start, dest));
	}

	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	int m, n;

	private boolean hasPath(int[][] maze, int[] start, int[] dest) {
		if (maze == null || maze[0].length == 0)
			return false;

		m = maze.length; // 가로
		n = maze[0].length; // 세로
		boolean[][] visitied = new boolean[m][m];

		return dfs(maze, start, dest, visitied);
	}

	private boolean dfs(int[][] maze, int[] start, int[] dest, boolean[][] visitied) {

		// error check
		if (start[0] < 0 || start[0] >= m || start[1] < 0 || start[1] >= n || visitied[start[0]][start[1]])
			return false;

		visitied[start[0]][start[1]] = true; // 0,4

		// destination ?
		if (start[0] == dest[0] && start[1] == dest[1])
			return true;

		for (int[] dir : dirs) {
			int x = start[0];
			int y = start[1];

			while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
				x += dir[0];
				y += dir[1];
			}
			// if they reached block and back to previous point
			x -= dir[0];
			y -= dir[1];

			if (dfs(maze, new int[] { x, y }, dest, visitied))
				return true;

		}
		return false;
	}

}

```

- input start (0,4)
- input destination (4,4)
- output `true`



## 나의풀이



## 필요개념

- DFS 깊이 우선 탐색 (depth first search)
  - 진입한 곳을 우선적으로 파는 느낌.
  - vistited 사용 true or false
  - DFS point 좌표를 잡는 것이 포인트

