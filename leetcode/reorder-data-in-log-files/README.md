```python
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letters, digits = [], []
        
        for log in logs:
            if log.split()[1].isdigit():
                digits.append(log)
            else:
                letters.append(log)
        
        # identifier를 제외하고 정렬하고, 중복되는 경우엔 identifier 순으로 정렬한다
        letters.sort(key=lambda x: (x.split()[1:], x.split()[0]))
        
        # 문자 로그는 숫자 로그 보다 앞에 온다.
        return letters + digits
```


- 제한사항
    - 로그의 가장 앞 부분이 식별자
    - 2개의 타입의 로그가 있음 (문자, 숫자)
    - 문자 로그는, 숫자 로그보다 앞에 옴.
    - 식별자는 순서에 영향을 끼치진 않지만, 문자가 동일하면 식별자 순으로 함.
    - 숫자 로그는 입력 순서대로 됨.


- 아이디어
    - 2개의 리스트 기반
    - log의 2번째 문자가 숫자인지 아닌지 판단하여 리스트에 추가
    - letters 리스트의 추가적인 정렬 조건
    - 더해서 리턴

