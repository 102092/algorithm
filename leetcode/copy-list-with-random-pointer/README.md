> https://leetcode.com/problems/copy-list-with-random-pointer

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    static Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        
        while (curr != null) {
            Node copied = getOrCreate(curr);
            Node copiedNext = getOrCreate(curr.next);
            Node copiedRandom = getOrCreate(curr.random);
            
            copied.next = copiedNext;
            copied.random = copiedRandom;
            
            curr = curr.next;
        }
        
        return map.get(head);
        
    }
    
    public Node getOrCreate(Node node) {
        if (node == null) {
            return null;
        }
        
        if (map.containsKey(node)) {
            return map.get(node);
        }
        
        map.put(node, new Node(node.val));
        return map.get(node);
    }
}

```

- 아이디어
    - node의 val, next, random을 모두 deep copy하는 문제. 객체 참조가 바뀌어야한다. 즉 객체 생성이 있어야한다.
    - map의 key에 객체를 하면, 아마도 유니크한 객체 값이 (object.hashcode 겠지..) 으로 구분할 수 있지 않을까.

- 제한조건
    - head == null일 경우 있음 (base case인듯)
    - node.random은 null을 가르킬 수도 있고, 아니면 다른 랜덤 리스트를 가르키고 있음.

- 주의사항
    - 한번 만들어진 경우. 즉 맵에 있는 node (key)로 있는 경우를 생각해야함.
    - `map.putIfAbsent` 를 이용하면 더 깔끔할 것 같기도함.
