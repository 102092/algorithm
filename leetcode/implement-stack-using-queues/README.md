```python
class MyStack:

    def __init__(self):
        # using deque
        # FIFO 선입 선출
        self.q = collections.deque()

    def push(self, x: int) -> None:
        # left -> top, right -> tail
        # append(), add to right (tail)
        # Pushes element x to the top of the stack
        self.q.append(x)
        
        for _ in range(len(self.q) -1):
            self.q.append(self.q.popleft())        
        

    def pop(self) -> int:
        # Removes the element on top of the stack and returns that element.
        return self.q.popleft()

    def top(self) -> int:
        # Returns the element on the top of the stack.
        return self.q[0]

    def empty(self) -> bool:
        # Returns true if the stack is empty, false otherwise.
        return len(self.q) == 0
        


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()
        
```
- 이해
![](https://velog.velcdn.com/images%2Fdramatic%2Fpost%2Fb1634d3e-1d48-4ca7-8963-1bb7b8627722%2Fimage.png)
- deque의 구조.
- `append()` 를 사용하면 리스트의 오른쪽으로 들어간다.
- stack의 구조에 따르면, LIFO. push해서 들어간 element가 가장 먼저 나가야함.
    - push 이후에 정렬하지 않으면, FIFO 하지 않을 수 있음.
    - tail로 들어간 요소를 제일 앞에 재배치해야함.

- 제한사항

> You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
- Queue 의 성질만을 이용해라
- push 할때 tail로 들어가는 점. peek, pop은 top에서 이뤄지는점..등


- 참고
    - https://velog.io/@dramatic/Python-Deque