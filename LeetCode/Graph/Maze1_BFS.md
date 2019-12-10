

## 강의풀이

```java
package coding.test.graph;

import java.util.*;

public class Maze1_BFS {

	public static void main(String[] args) {
		int[][] maze = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int[] start = { 0, 4 };
		int[] dest = { 3, 4 };
		// int[] dest = { 4, 4 };
		Maze1_BFS mb = new Maze1_BFS();
		System.out.println(mb.hasPath(maze, start, dest));
	}

	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	int m, n; // 행 열

	private boolean hasPath(int[][] maze, int[] start, int[] dest) {

		if (start[0] == dest[0] && start[1] == dest[1])
			return true;

		m = maze.length; // 행 5
		n = maze[0].length; // 열 5
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { start[0], start[1] });

		// BFS basic format
		while (!q.isEmpty()) {
			int[] point = q.poll();
			for (int[] dir : dirs) {
				int x = point[0] + dir[0];
				int y = point[1] + dir[1];

				while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
				}
				x -= dir[0];
				y -= dir[1];
				if (visited[x][y] == true)
					continue;
				visited[x][y] = true;

				// System.out.println("============");
				// print(visited);

				if (dest[0] == x && dest[1] == y)
					return true;
				q.offer(new int[] { x, y });
			}
		}
		return false;
	}

	private void print(boolean[][] visited) {
		if (visited == null || visited[0].length == 0)
			return;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}

}

```

- input : start (0,4);
- input : dest (4,4);
  - input : dest (3,4);
  - 결과 : `false`
- 결과 : `true`

## 나의풀이



## 필요개념

- BFS -- Queue 이용
- **벽면**을 인식하고 다시 돌아와야함.
- <u>공이 굴러간다고 생각하면 됨.</u> .. 핵심
  - 중간에 멈추는 경우는 없다. 벽이 없는 한.

- maze 4방향 탐색 == dirs 필요
- 이미 방문한 곳이면 넘어가는 기능 필요... boolean visited 



- BFS 어떨때 사용? 너비 우선 탐색
  - https://twpower.github.io/151-bfs-dfs-basic-problem