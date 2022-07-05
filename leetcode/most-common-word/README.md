```python
class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        if not banned:
            return re.sub('[^\w]', '', paragraph).lower()
        
        replaced = re.sub('[^\w]', ' ', paragraph)
        words = []
        
        for s in replaced.lower().split():
            if s not in banned:
                words.append(s)
        # print(collections.Counter(words))
        return collections.Counter(words).most_common(1)[0][0]
                
```



- 이해
    - 단락이 주어짐
    - 그리고 스페이스로 구분되는 단어가 얼마나 반복되는 지 체크
    - banned 된 리스트에 있는 문자열은 체크에서 무시되어야함

- 제한사항
    - banned 리스트가 비어서 올 수도 있음. 
    - paragraph는 space, 와 "!?',;." 을 가지고 있음.

- 아이디어
    - banned 리스트가 비어있으면, word가 아닌 것들은, '' 로 치환하고, lower로 바꿔서 리턴.

- 기타
    - `collections.Counter` 을 이용해서 카운트 할 경우.
    - `Counter({'ball': 2, 'bob': 1, 'a': 1, 'the': 1, 'flew': 1, 'far': 1, 'after': 1, 'it': 1, 'was': 1})`와 같이 반환.
    - `most_common` 라는 메서드는 데이터 갯수가 많은 순서대로 반환 그리고 인자로 넘긴 숫자만큼 반환함.
        - `most_common(1)` 은 `[('ball', 2)]` 가 반환됨.
        - 리스트 `[]` 속에 튜플 `()`로 존재하는 형식
        - 튜플? 
            - 이미 생성된 원소를 제거하거나, 변경할 수 없음.
            - 그리고 보통 원소의 타입이 같을때 사용함
        - 딕셔너리는 `{}`


- 참고
    - https://www.daleseo.com/python-collections-counter/
    - https://hashcode.co.kr/questions/4118/%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%99%80-%EC%82%AC%EC%9A%A9%ED%95%B4%EC%95%BC-%ED%95%A0-%EA%B3%B3
