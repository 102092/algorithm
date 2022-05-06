> https://leetcode.com/problems/remove-nth-node-from-end-of-list/


```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        
        Stack<ListNode> stk = new Stack<>();
        ListNode a = head;
        
        while (a != null) {
            stk.add(a);
            a = a.next;
        }
        
        ListNode target = null;
        
        while (n != 0) {
            target = stk.pop();
            n--;
        }
        
        
        ListNode b = head;
        
        while(b != null) {
            if (b == target) {
                head = b.next;
                break;
            }
            
            if (b.next == target) {
                b.next = b.next.next;
                break;
            }
            b = b.next;
        }
        
        return head;
    }
}

```

- 아이디어
    - Stack을 이용해서 제거해야할 Node가 어떤 건지 판단.
    - two pointer로도 풀 수 있을 것 같음.
        - [참고](https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/2010973/Single-pass-Java-Solution-or-Two-Pointer-or-LinkedList)

- 제한사항
    - 1 <= sz <= 30
    - 1 <= n <= sz
        - node들의 갯수는 무조건 1 이상이고,
        - n도 1이상이니, node의 리스트가 1개인데 n == 1인경우..  example 2를 base컨디션으로 잡으면 될듯.
