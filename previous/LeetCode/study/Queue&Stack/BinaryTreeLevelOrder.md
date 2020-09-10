

## 강의풀이

```java

package app;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class BinaryTreeLevelOrder {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        System.out.println(solve(root));
    }

    private static List<List<Integer>> solve(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 데이터에 대한 작업 완료.

        while (!q.isEmpty()) {
            int size = q.size(); // size를 할당하는 것은 queue를 사용할 때 거의 항상 필요함.
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }

            }
            result.add(list);
        }
        return result;
    }
}
```

## 나의풀이



## 필요개념

- 기본적으로 제공해주는 Tree node Class를 사용함.
- 이 문제의 개념은 상당히 많이 이용되고 있음.
- Queue를 이용해서 품.
- Queue는 bfs의 대표적인 문제. 너비 우선 문제.