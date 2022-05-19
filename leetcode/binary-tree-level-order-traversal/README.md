> https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        if (root.left == null && root.right == null) {
            result.add(Arrays.asList(root.val));
            return result;
        }
        
        
        Queue<TreeNode> q = new LinkedList<>(); // BFS
        q.add(root);
        
        
        while(!q.isEmpty()) { // level by level
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            
            while(size --> 0) {
                TreeNode node = q.poll();
                temp.add(node.val);
                
                if (node.left != null) {
                    q.add(node.left);
                }
                
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(temp);
        }
        
        return result;
    }
}
```

- 아이디어
    - BFS..로 풀어야겠지? 레벨에 따라 리스트를 새로 만들어야 하니
    - 검색 -> Queue로 많이 사용하는 힌트 착안

- 제한조건
    - root == null 일 경우, empty list를 반환해줘야할듯
    - root.left && root.right == null 이면 root.val을 가지고 있는 리스트를 반환해주면 될듯.
        - 전역 변수로 `List<List<Integer>>` 가 있으면 좋을듯.


- 시간복잡도
    - O(N)

- 참고
    - https://java119.tistory.com/105
    - https://www.baeldung.com/java-breadth-first-search

