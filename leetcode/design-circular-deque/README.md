```python
class MyCircularDeque:

    def __init__(self, k: int):
        self.head, self.tail = ListNode(None), ListNode(None)
        self.maxlen, self.currlen = k, 0
        self.head.right, self.tail.left = self.tail, self.head
        
    
    # Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
    def insertFront(self, value: int) -> bool:
        if self.currlen == self.maxlen:
            return False
        self.currlen += 1
        self._add(self.head, ListNode(value))
        return True
        

    def insertLast(self, value: int) -> bool:
        if self.currlen == self.maxlen:
            return False 
        self.currlen += 1
        self._add(self.tail.left, ListNode(value))
        return True
        

    def deleteFront(self) -> bool:
        if self.currlen == 0:
            return False
        self.currlen -= 1
        self._del(self.head)
        return True
        

    def deleteLast(self) -> bool:
        if self.currlen == 0:
            return False
        self.currlen -= 1
        self._del(self.tail.left.left)
        return True

    def getFront(self) -> int:
        if self.currlen:
            return self.head.right.val
        return -1

    def getRear(self) -> int:
        if self.currlen:
            return self.tail.left.val
        return -1

    def isEmpty(self) -> bool:
        return self.currlen == 0
        

    def isFull(self) -> bool:
        return self.currlen == self.maxlen
    
    def _add(self, node: ListNode, new: ListNode):
        n = node.right
        node.right = new
        new.left, new.right = node, n
        n.left = new
    
    def _del(self, node: ListNode):
        n = node.right.right
        node.right = n
        n.left = node
        


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
```