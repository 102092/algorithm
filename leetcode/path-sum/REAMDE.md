> https://leetcode.com/problems/path-sum/

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
    // map, recursion, two stacks
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null) {
            return root.val - targetSum == 0;
        }
        
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}

```

- 제한사항
    - `1 <= arr.length <= 104`
        - arr length가 1이상이니, 0 체크는 안해도 될듯.
    - -`0 <= arr[i] <= 104`
        - 양수 값만.
    

- IDEA
    - recursion 이용
    - 다음 매개변수로 넘기는 값을, `targetSum - root.val` 로 하고, leaf 노드일 때, `root.val - targetSum == 0` 이 성립하는 지 확인하면 될듯

