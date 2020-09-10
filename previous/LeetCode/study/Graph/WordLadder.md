

## 강의풀이

```java
package app;

import java.util.*;

public class WordLadder {
    public static void main(final String[] args) throws Exception {
        String[] words = { "hot", "dot", "lot", "log", "cog" };
        // String[] words = { "hot", "dot", "dog", "lot", "log" };

        List<String> wordList = Arrays.asList(words);
        WordLadder w = new WordLadder();
        System.out.println(w.ladderLength_neighbor("hit", "cog", wordList));
    }

    private int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        q.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size(); // 1 , "hit" 단어 들어가있음.
            for (int i = 0; i < size; i++) {
                String str = q.poll(); // hit
                if (str.equals(endWord))
                    return level;
                for (String neighbor : neighbors(str, wordList)) {
                    q.offer(neighbor);
                }
            }
            level++;

        }
        return 0;
    }

    private List<String> neighbors(String s, List<String> wordList) {
        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList); // 중복을 허용하지 않는 저장장치

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String word = new String(chars);
                if (dict.remove(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }
}
```

## 나의풀이

```java
package app;

import java.util.*;

public class WordLadder {
    public static void main(final String[] args) throws Exception {
        String[] words = { "hot", "dot", "lot", "log", "cog" };
        // String[] words = { "hot", "dot", "dog", "lot", "log" };

        List<String> wordList = Arrays.asList(words);
        WordLadder w = new WordLadder();
        System.out.println(w.ladderLength_neighbor("hit", "cog", wordList));
    }

    private int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        q.offer(beginWord);
        // dict.add(endWord);
        // dict.remove(beginWord);

        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size(); // 1 , "hit" 단어 들어가있음.
            for (int i = 0; i < size; i++) {
                String str = q.poll(); // hit
                if (str.equals(endWord))
                    return level;
                for (String neighbor : neighbors(str, dict)) {
                    q.offer(neighbor);
                }
            }
            level++;

        }
        return 0;
    }

    private List<String> neighbors(String s, Set<String> wordList) {
        List<String> res = new LinkedList<>();
        // Set<String> dict = new HashSet<>(wordList); // 중복을 허용하지 않는 저장장치

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String word = new String(chars);
                if (wordList.remove(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }
}
```



## 필요개념

- 단어 사다리

- Queue 사용, 하나하나 다 돌려가면서 target List 와 비교

- BFS

  https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html

  - 너비우선탐색
  - 두 노드 사이의 최단 경로, 혹은 임의의 경로를 찾고 싶을 때 사용함.
  - cf) 깊이 우선 탐색 DFS , 모든 노드 확인



- BFS 특징

  - 재귀적이지 않음.
  - 어떤 노드를 방문 했는지 여부를 반드시 검사 (DFS에서도 했었는듯...)

  - Queue를 사용.
    - 즉 FIFO 선입 선출. 



- 과정
  - 우선 깊이가 1인 노드를 방문하고 나서, 2인 노드를 그리고 깊이가 3인 모든 노드를 방문하는 방식.
  - 이렇게 진행하다가 더 이상 방문할 곳이 없으면 탐색을 마침.



- BFS 구현

  ```java
  import java.io.*;
  import java.util.*;
  
  /* 인접 리스트를 이용한 방향성 있는 그래프 클래스 */
  class Graph {
    private int V; // 노드의 개수
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
  
    /** s를 시작 노드으로 한 BFS로 탐색하면서 탐색한 노드들을 출력 */
    void BFS(int s) {
      // 노드의 방문 여부 판단 (초깃값: false)
      boolean visited[] = new boolean[V];
      // BFS 구현을 위한 큐(Queue) 생성
      LinkedList<Integer> queue = new LinkedList<Integer>();
  
      // 현재 노드를 방문한 것으로 표시하고 큐에 삽입(enqueue)
      visited[s] = true;
      queue.add(s);
  
      // 큐(Queue)가 빌 때까지 반복
      while (queue.size() != 0) {
        // 방문한 노드를 큐에서 추출(dequeue)하고 값을 출력
        s = queue.poll();
        System.out.print(s + " ");
  
        // 방문한 노드와 인접한 모든 노드를 가져온다.
        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()) {
          int n = i.next();
          // 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입(enqueue)
          if (!visited[n]) {
            visited[n] = true;
            queue.add(n);
          }
        }
      }
    }
  }
  https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html
  ```

  

- 시간 복잡도
  - 인접 리스트로 표현됨 : O(N+E)
  - 인접 행렬도 표현 : O(N^2)
    - DFS와 마찬가지.