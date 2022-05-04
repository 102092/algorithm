> https://leetcode.com/problems/linked-list-cycle/


```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

```

- 아이디어
    - two pointer
    - 빠른 포인터와, 느린 포인터로 나눈 다음에, 언젠가 만난다면? 원의 형태의 링크드 리스트라 판단할 수 있을 것.

- 제한사항
    - 만약에 head == null 이거나 head.next == null 이면 -1를 리턴하면 될듯.