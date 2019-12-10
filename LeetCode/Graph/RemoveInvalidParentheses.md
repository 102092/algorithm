

## 강의풀이

```java
package coding.test.graph;

import java.util.*;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		String s = "(a)())()";
		RemoveInvalidParentheses r = new RemoveInvalidParentheses();
		System.out.println(r.solve(s));

	}

	private List<String> solve(String s) {
		List<String> res = new ArrayList<>();
		if (s == null) {
			return res;
		}
		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		q.offer(s);
		visited.add(s);

		boolean found = false;

		while (!q.isEmpty()) {
			int size = q.size(); // 1

			// bfs basic format
			for (int i = 0; i < size; i++) {
				String str = q.poll();
				if (isValid(str)) {
					res.add(str);
					found = true;
				}
				if (found == true)
					continue;
				// index 0->7
				for (int j = 0; j < str.length(); j++) {

					if (str.charAt(j) != '(' && str.charAt(j) != ')')
						continue;
					String nStr = str.substring(0, j) + str.substring(j + 1);x
					if (!visited.contains(nStr)) {
						q.offer(nStr);
						visited.add(nStr);
					}
				}
			}
		}

		return res;
	}

	private boolean isValid(String str) {
		int count = 0;

		for (char c : str.toCharArray()) {
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
				if (count < 0)
					return false;

			}
			// ())( 이 경우는 0이지만 조건에 맞지 않는 input
		}
		return count == 0; // 0이면 true 0이 아니면 false
	}
}

```

## 나의풀이



## 필요개념

- BFS -> Queue 필요
- 문자열은 제외하고,
- 가로를 하나하나씩 지워보면서, 완벽한 `()` 이면 체크 해놨다가, 출력한다.

- vscode dubug하는 법 배웠당. 너무 좋은듯

- `substring()`

  - https://coding-factory.tistory.com/126

  - String.substring(start) //문자열  start위치부터 끝까지 문자열 자르기

  - String.substring(start,end) //문자열  start위치 부터 end전까지 문자열 발췌

    ```java
    String s= "(a)())()";
    String temp = s.substring(0,0); // "" 공백 아무것도 반환안함.
    ```

