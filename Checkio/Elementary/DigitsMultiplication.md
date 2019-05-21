- [링크](https://py.checkio.org/mission/digits-multiplication/share/973c58b1aaaa73691f3388637048bb4b/)

##### 내 풀이

```python

def checkio(number: int) -> int:
    
    res = 1
    for d in str(number):
        if int(d) != 0:
            res *= int(d)

    return res


if __name__ == '__main__':
    print('Example:')
    print(checkio(123405))
    
    # These "asserts" using only for self-checking and not necessary for auto-testing
    assert checkio(123405) == 120
    assert checkio(999) == 729
    assert checkio(1000) == 1
    assert checkio(1111) == 1
    print("Coding complete? Click 'Check' to review your tests and earn cool rewards!")


```

<br>

- 19.05.15

