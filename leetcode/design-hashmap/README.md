```python
class MyHashMap:

    def __init__(self):
        self.size = 1000
        self.table = collections.defaultdict(ListNode)
        

    def put(self, key: int, value: int) -> None:
        index = key % self.size
        
        if self.table[index].value is None:
            self.table[index] = ListNode(key, value)
            return
        
        node = self.table[index]
        
        while node:
            # If the key already exists in the map, update the corresponding value
            if node.key == key:
                node.value = value
                return
            if node.next is None:
                break
            node = node.next
        
        node.next = ListNode(key, value)
        return

    def get(self, key: int) -> int:
        index = key % self.size
        
        if self.table[index].value is None:
            return -1
        
        node = self.table[index]
        
        while node:
            if node.key == key:
                return node.value
            node = node.next
            
        # -1 if this map contains no mapping for the key
        return -1
        

    def remove(self, key: int) -> None:
        index = key % self.size
        if self.table[index].value is None:
            return
        
        node = self.table[index]
        
        # if first node matched
        if node.key == key:
            if node.next is None:
                self.table[index] = ListNode()
            else:
                self.table[index] = node.next
            return
        
        # else find matched node (chaining)
        prev = node
        while node:
            if node.key == key:
                prev.next = node.next
                return
            prev, node = node, node.next
        return
            
        

class ListNode:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.next = None


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
```