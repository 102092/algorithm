> https://leetcode.com/problems/binary-tree-postorder-traversal/

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        
        Set<TreeNode> visited = new HashSet<>();
        TreeNode head = root;
        TreeNode curr = root;
        
        while (curr != null && !visited.contains(curr)) {
            if (curr.left != null && !visited.contains(curr.left)) {
                curr = curr.left;
            } else if (curr.right != null && !visited.contains(curr.right)) {
                curr = curr.right;
            } else {
                result.add(curr.val);
                visited.add(curr);
                curr = head;
            }

        }
        
        return result;
    }
}
```

- 아이디어
    - 잘 생각 안남 -> 검색
    - [여기서](https://www.geeksforgeeks.org/postorder-traversal-binary-tree-without-recursion-without-stack/) Set을 이용해서 구현하는 걸 참고
    - 2개의 stack을 이용해서 구하는 방법도 있는듯
    

- 제한조건
    - root == null 일 경우, empty list를 반환해줘야할듯

