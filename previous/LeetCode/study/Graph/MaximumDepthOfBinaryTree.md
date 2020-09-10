

## 강의풀이

```java
package app.leetcode;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) throws Exception {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
        System.out.println(m.maxDepth(tree));
    }

    private int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        System.out.print("root.val : " + root.val + " ");
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
```

## 나의풀이



## 필요개념

- Recurive하게 풀었음. (재귀호출)
  - 3 ,1,5,7 즉 return 4
  - 몇개의 depth가 있는가?
  - depth면 dfs아닐까?
- Recursive 는 곧 stack
- 어떻게?
  1. left, right를 호출
  2. Math.max(leftMax, rightMax)를 사용
  3. null이 나올때 까지.
- 1,2번이 어떻게 활용 될까?
  - tree 가 null이면 return 0을 이용

