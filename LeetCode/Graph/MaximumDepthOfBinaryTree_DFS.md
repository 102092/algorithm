

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

public class MaximumDepthOfBinaryTree_DFS {

    public static void main(String[] args) throws Exception {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.left.left = new TreeNode(6);
        MaximumDepthOfBinaryTree_DFS m = new MaximumDepthOfBinaryTree_DFS();
        System.out.println(m.dfs(tree));
    }

    private int dfs(TreeNode root) {

        if (root == null)
            return 0;
        Stack<TreeNode> stk = new Stack<>();
        Stack<Integer> valueStk = new Stack<>();

        stk.push(root);
        valueStk.push(1);
        int max = 0;

        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            int count = valueStk.pop();
            max = Math.max(max, count);
            if (node.left != null) {
                stk.push(node.left);
                valueStk.push(1 + count);
            }

            if (node.right != null) {
                stk.push(node.right);
                valueStk.push(1 + count);
            }

        }
        return max;
    }
}
```

## 나의풀이



## 필요개념

- Stack 방식
  - stack, push pop하면서 count하는 루트로 코드가 진행된다.

- 2개의 스택이 동시에 push, pop하면서 움직임.

- 계단형식으로 문제는 푸는 느낌.



