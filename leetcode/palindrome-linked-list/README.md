> https://leetcode.com/problems/palindrome-linked-list


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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        
        ListNode a = head;
        while (a != null) {
            stk.push(a);
            a = a.next;
        }
        
        ListNode target = head;
        
        while(!stk.isEmpty()) {
            ListNode b = stk.pop();
            if (target.val != b.val) {
                return false;
            }
            target = target.next;
        }
        
        return true;
    }
}

```

- 아이디어
    - Stack 이용

- 제한사항
    - 딱히 없는듯.
    

- 기타
    - Could you do it in O(n) time and O(1) space?
    - O(1) 에 어떻게 할 수 있을까..
    
