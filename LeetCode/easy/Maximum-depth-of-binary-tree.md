> https://leetcode.com/problems/maximum-depth-of-binary-tree

## 나의풀이

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
```

## 필요개념

- 이진트리란?
  - 자식 노드들이 최대 두 개인 노드들로 구성된 트리.
  - 그 종류로는 full binary tree, complete binary tree, balanced binary tree 등이 있음.
    ![](https://i.imgur.com/6UeCp8t.png)
- leaf node란?

  - 자식노드가 없는 노드를 말함.

- Tree Traveral

  - 전위 preorder, 중위, inorder, 후위 postorder가 있음.
  - 루트 노드를 언제 방문하는지가 핵심
  - pre == 먼저 방문한다. 즉 제일 먼저 루트를 방문.
  - in 중간에
  - post 제일 나중에

- 전위
  ![](https://i.imgur.com/zfrXerB.png)

  - 루트 -> 왼쪽 서브트리 -> 오른쪽 서브트리
  - `1, 2, 4, 5, 3`

- 중위

  - 왼쪽 서브트리 -> 루트 -> 오른쪽 서브트리
  - `4 2 5 1 3`

- 후위
  - 왼쪽 서브트리 -> 오른쪽 서브트리 -> 루트
  - `4, 5, 2, 3, 1`
