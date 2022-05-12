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

- 기타
    - two pointer from linked list

```java
// Initialize slow & fast pointers
ListNode slow = head;
ListNode fast = head;
/**
 * Change this condition to fit specific problem.
 * Attention: remember to avoid null-pointer error
 **/
while (slow != null && fast != null && fast.next != null) {
    slow = slow.next;           // move slow pointer one step each time
    fast = fast.next.next;      // move fast pointer two steps each time
    if (slow == fast) {         // change this condition to fit specific problem
        return true;
    }
}
return false;   // change return value to fit specific problem

```
- he space complexity will be O(1)
- if there is no cycle, the fast pointer takes N/2 times
    - N is the length of the linked list
- If there is a cycle, the fast pointer needs M times to catch up the slower pointer
    - M is the length of the cycle in the list