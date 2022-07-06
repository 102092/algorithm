```python
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # because of strs.length >= 0 ..
        if not strs[0]:
            return [[""]]
        
        
        anagrams = collections.defaultdict(list)
        
        for str in strs:
            anagrams[''.join(sorted(str))].append(str)
        # print(anagrams)
        # input ["eat","tea","tan","ate","nat","bat"]
        # stdout defaultdict(<class 'list'>, {'aet': ['eat', 'tea', 'ate'], 'ant': ['tan', 'nat'], 'abt': ['bat']})
        return list(anagrams.values())
        
```


- 이해
    - anagram? 문자를 재배열해서 다른뜻을 가진 단어를 말함.
    - 아마도 문제에서는 문자를 재배열해서 같은 문자를 가질 수 있는 것끼리 묶으라는 뜻인듯 (eat, ate)
- 제한사항
    - strs 가 empty string 일수 있음. 제한사항 있으면 좋을듯.
- 아이디어
    - `dict` 자료구조 사용
    - 
- 기타
    - `sorted` 
        - Timesort 방식
        - 문자열도 정렬하여 결과를 리스트로 반환.
        - `sorted(list, key=len)` 과 같이 정렬을 위한 키 또는 함수를 지정할 수 있음.
        - 혹은 a = ['cde', 'cfc', 'abc'] 일때, sorted(a, key=lambda s: (s[0], s[-1])) 와 같이 사용하면, ['abc', 'cfc', 'cde'] 와 같이 정렬됨을 볼 수 있음
    - `collections.defaultdict(list)`
        - list
        - https://www.daleseo.com/python-collections-defaultdict/