

## 강의풀이

```java
package app.leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class MaximumDepthOfBinaryTree_BFS {

    public static void main(String[] args) throws Exception {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        MaximumDepthOfBinaryTree_BFS m = new MaximumDepthOfBinaryTree_BFS();
        System.out.println(m.bfs(tree));
    }

    private int bfs(TreeNode root) {

        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll(); // 3
                if (node.left != null) {
                    q.offer(node.left); // 1
                }
                if (node.right != null) {
                    q.offer(node.right); // 4
                }
            }
            count++;
        }
        return count;
    }

}
```

## 나의풀이



## 필요개념

- Queue방식

