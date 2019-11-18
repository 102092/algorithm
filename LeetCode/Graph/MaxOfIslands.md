

## 강의풀이

```java
package app.leetcode;

public class MaxOfIsland {
    public static void main(String[] args) throws Exception {

        int[][] grid = { { 1, 1, 0, 1, 1 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 }, { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 1, 1 }

        };
        MaxOfIsland m = new MaxOfIsland();
        System.out.println(m.maxAreaOfIsland(grid));

    }

    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int m, n;

    private int maxAreaOfIsland(int[][] grid) {
        // null 체크
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length; // 6
        n = grid[0].length; // 5
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // return 4
                    max = Math.max(dfs(grid, i, j, 0), max);
                }

            }

        }
        return max;
    }

    private int dfs(int[][] grid, int x, int y, int area) {

        // 범위 체크
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0)
            return area;

        // 좌표가 1인경우 , 즉 육지인 경우만 들어왔음.
        grid[x][y] = 0;
        area++;
        for (int[] dir : dirs) {
            area = dfs(grid, x + dir[0], y + dir[1], area);
        }
        return area;
    }

}

```

## 나의풀이



## 필요개념

1. 각 섬의 갯수를 구하고

2. Count 변수를 두고 == 4,2,4,8

   Math.max(...) 를 사용해서 8이 나오도록함

- DFS 사용, 깊이 우선 탐색

  https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html

  - 그래프 탐색 : 4방향을 탐색하자. 갈수 있는지 아닌지
  - Depth - First Search
  - 다음 분기로 넘어가기 전에, 해당 분기를 완전히 탐색하는 방법
  - DFS가 BFS보다 좀 더 간단하다.
  - 다만 검색 속도 자체는 BFS보다 느림.



- DFS 특징
  1. 순환 알고리즘 형태를 가지고 있음, recursive하게
  2. 방문한 노드를 체크하는 방법이 필요하다. 그렇지 않을 경우 무한 루프 위험 가능성

- DFS 구현

  1. 순환 호출
  2. 스택 사용

  ```java
  import java.io.*;
  import java.util.*;
  
  /* 인접 리스트를 이용한 방향성 있는 그래프 클래스 */
  class Graph {
    private int V;   // 노드의 개수
    private LinkedList<Integer> adj[]; // 인접 리스트
  
    /** 생성자 */
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) // 인접 리스트 초기화
            adj[i] = new LinkedList();
    }
  
    /** 노드를 연결 v->w */
    void addEdge(int v, int w) { adj[v].add(w); }
  
    /** DFS에 의해 사용되는 함수 */
    void DFSUtil(int v, boolean visited[]) {
        // 현재 노드를 방문한 것으로 표시하고 값을 출력
        visited[v] = true;
        System.out.print(v + " ");
  
        // 방문한 노드와 인접한 모든 노드를 가져온다.
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            // 방문하지 않은 노드면 해당 노드를 시작 노드로 다시 DFSUtil 호출
            if (!visited[n])
                DFSUtil(n, visited); // 순환 호출
        }
    }
  
    /** 주어진 노드를 시작 노드로 DFS 탐색 */
    void DFS(int v) {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean visited[] = new boolean[V];
  
        // v를 시작 노드로 DFSUtil 순환 호출
        DFSUtil(v, visited);
    }
  
    /** DFS 탐색 */
    void DFS() {
        // 노드의 방문 여부 판단 (초깃값: false)
        boolean visited[] = new boolean[V];
  
        // 비연결형 그래프의 경우, 모든 정점을 하나씩 방문
        for (int i=0; i<V; ++i) {
            if (visited[i] == false)
                DFSUtil(i, visited);
        }
    }
  }
  https://gmlwjd9405.github.io/2018/08/14/algorithm-dfs.html
  ```

  

- DFS 시간 복잡도
  - 인접 리스트로 표현했을 경우 O(N)
  - 인접 행렬로 표현했을 경우 (N^2)

