> https://leetcode.com/problems/path-sum/

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        nodes.add(root);
        sums.add(sum - root.val);

        while(!nodes.isEmpty()) {
            TreeNode current_node = nodes.pop();
            int current_sum = sums.pop();

            if(current_node.left == null && current_node.right == null && current_sum == 0) {
                return true;
            }

            if(current_node.left != null) {
                nodes.add(current_node.left);
                sums.add(current_sum - current_node.left.val);
            }

            if(current_node.right != null) {
                nodes.add(current_node.right);
                sums.add(current_sum - current_node.right.val);
            }

        }
        return false;

    }
}
```

## 다른 풀이

```java
public boolean hasPathSum(TreeNode root, int sum) {
   if(root == null){
     return false;
   }
   if(root.left == null && root.right == null){
      return (root.val == sum);
   }
   return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

}
```

- 회귀를 이용한 풀이
- sum 매번 지나가는 `path.val`을 차감하여 비교하는 형식
- 왼쪽 오른쪽 둘중 하나의 루트만 성공해도 상관 없음.
