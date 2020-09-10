- [링크](https://py.checkio.org/mission/easy-unpack/share/509bf6660cfb1bb07bde44f4b36b6f2f/)

##### 내 풀이

```python

def easy_unpack(elements: tuple) -> tuple:
    """
        returns a tuple with 3 elements - first, third and second to the last
    """
    # your code here
    result = (elements[0], elements[2], elements[-2]) 
    
    return result

if __name__ == '__main__':
    print('Examples:')
    print(easy_unpack((1, 2, 3, 4, 5, 6, 7, 9)))
    
    #These "asserts" using only for self-checking and not necessary for auto-testing
    assert easy_unpack((1, 2, 3, 4, 5, 6, 7, 9)) == (1, 3, 7)
    assert easy_unpack((1, 1, 1, 1)) == (1, 1, 1)
    assert easy_unpack((6, 3, 7)) == (6, 7, 3)
    print('Done! Go Check!')


```

<br>

- 19.05.15

