- [링크](https://py.checkio.org/mission/secret-message/share/4734114443b6d18a22f1ae2ebffcc2ec/)

##### 내 풀이

```python

def find_message(text: str) -> str:
    """Find a secret message"""
    res = []
    for ch in text:
        if ch.isupper():
            res.append(ch)
    return ''.join(res)
    
    //join, append needed

if __name__ == '__main__':
    print('Example:')
    print(find_message("How are you? Eh, ok. Low or Lower? Ohhh."))
    
    #These "asserts" using only for self-checking and not necessary for auto-testing
    assert find_message("How are you? Eh, ok. Low or Lower? Ohhh.") == "HELLO", "hello"
    assert find_message("hello world!") == "", "Nothing"
    assert find_message("HELLO WORLD!!!") == "HELLOWORLD", "Capitals"
    print("Coding complete? Click 'Check' to review your tests and earn cool rewards!")



```

<br>

- 19.05.15
- 리스트에 appned하고, 요소들사이에 ''넣어서 join하고

