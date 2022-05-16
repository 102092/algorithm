> https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        

        Node curr = head;
        while (curr != null) {
            
            if (curr.child != null) {
                Node childTail = getTail(curr.child);
                // why should check null?
                // [1,null,2,null,3,null]  -> 1 - 2 - 3
                // 1 - null
                // 2 - null
                // 3 - null 
                if (curr.next != null) {
                 curr.next.prev = childTail;   
                }
                childTail.next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null; // 제한조건 3번
            }
            curr = curr.next;
        }
        
        

        return head;
    }
    
    public Node getTail(Node node) {
        while(node.next != null) {
            node = node.next;
        }
        return node;
    }
}

```

- 아이디어
    - recursion or ... child node를 발견했을 경우, prev, next를 바꾸는 방법
    - 회귀로 풀 수 도 있을 것 같다..

- 제한조건
    - head == null일 경우 있음 (base case인듯)
    - 노드의 갯수 1000개
    - flatten 된 후에, all of their child pointer set to null

