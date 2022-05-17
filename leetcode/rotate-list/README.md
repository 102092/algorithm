> https://leetcode.com/problems/rotate-list/

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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
    
        ListNode curr = head;
        int size = getSize(head);
        
        for (int i = 0; i < k % size; i++) {
            curr = rotate(curr);
        }
        
        return curr;
    }
    
    public ListNode rotate(ListNode node) {
        // 0 -> 1 -> 2;

        ListNode tail = null;
        ListNode curr = node;
        
        while (curr.next != null) {
            tail = curr;
            curr = curr.next;
        }
        
        // if node [1]
        if (tail != null) {
            tail.next = null;
            curr.next = node;
            node = curr;
        }
        
        return node;
    }
    
    public int getSize(ListNode node) {
        ListNode temp = node;
        int size = 0;
        
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        
        return size;
    }
}

```

- 아이디어
    - two poiner

- 제한조건
    - `0 <= k <= 2 * 10^9`, 생각보다 크다. time limt exceed 가 발생할 수 도 있겠음.
    -  nodes in the list is in the range [0, 500].

- 주의사항
    - head == null 베이스 케이스 필요할듯.
    - 만약에 nodes 의 range 가 1인 경우 확인해야할듯.

