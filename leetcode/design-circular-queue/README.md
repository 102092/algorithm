```python
class MyCircularQueue:

    def __init__(self, k: int):
        # value >= 0
        self.q = [None] * k
        self.maxlen = k
        self.f = 0
        self.r = 0
        

    # Inserts an element into the circular queue. Return true if the operation is successful.
    def enQueue(self, value: int) -> bool:
        if self.q[self.r] is None:
            self.q[self.r] = value
            self.r = (self.r + 1) % self.maxlen
            return True
        else:
            return False
        

    # Deletes an element from the circular queue. Return true if the operation is successful.
    def deQueue(self) -> bool:
        if self.q[self.f] is None:
            return False
        else:
            self.q[self.f] = None
            self.f = (self.f + 1) % self.maxlen
            return True
        

    # Gets the front item from the queue. If the queue is empty, return -1
    def Front(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.q[self.f]
        

    # Gets the last item from the queue. If the queue is empty, return -1
    def Rear(self) -> int:
        if self.isEmpty():
            return -1
        else:
            return self.q[self.r - 1]
        

    # Checks whether the circular queue is empty or not.
    def isEmpty(self) -> bool:
        return self.f == self.r and self.q[self.f] is None

    def isFull(self) -> bool:
        return self.f == self.r and self.q[self.r] is not None
        


# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()
```

- 아이디어
    - 리스트를 이용해서 원형큐 구현
    - two pointer 사용
    - `enQueue()`, `deQueue()` 할 때, 포인터가 maxlen을 넘지않도록 하는게 핵심