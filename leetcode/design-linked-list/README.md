> https://leetcode.com/problems/design-linked-list/

```java
class MyLinkedList {
    private LinkedList<Integer> ll = new LinkedList();  

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        try { 
            return ll.get(index);
           } catch (IndexOutOfBoundsException ioobe) {
            return -1;
        }
        
    }
    
    public void addAtHead(int val) {
        ll.addFirst(val);
    }
    
    public void addAtTail(int val) {
        ll.addLast(val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > ll.size()) {
            return;
        }
        ll.add(index, val);
    }
    
    public void deleteAtIndex(int index) {
        if (get(index) != -1) {
         ll.remove(index);   
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

```

- 제한사항
    - Please do not use the built-in LinkedList library.  (그냥 사용했음, 아마도 의도한 바는 Node 클래스를 직접 구현해서 사용하는 방법인듯)

- 기타
    - https://leetcode.com/submissions/detail/691940646/ 
    - 다른 풀이를 참고하여 만듬.