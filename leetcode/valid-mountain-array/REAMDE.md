> https://leetcode.com/problems/valid-mountain-array/

```java
class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        
        if (arr[0] > arr[1]) {
            return false;
        }
        
        int peak = 0;
        
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            
            if (arr[i] - arr[i+1] > 0) {
                peak = i;
                break;
            }
        }
        
        for (int i = peak; i < arr.length-1; i++) {
            if (arr[i] - arr[i + 1] <=0) {
                return false;
            }
            
        }
        
        return true;
    }
}

```

- 제한사항
    - `1 <= arr.length <= 104`
        - arr length가 1이상이니, 0 체크는 안해도 될듯.
    - -`0 <= arr[i] <= 104`
        - 양수 값만.
    

- IDEA
    - peak index 전까지는..
        - 혹시 연속해서 숫자가 같이 나오지 않나 체크하고,
        - peak 지점을 찾으면 break.
    - peak 지점 부터는..
        - 내리막길 컨셉에 맞게 arr[i] - arr[i+1] > 0 조건을 만족하는지 확인하면 될듯.
        - 만약에 0이거나 음수라면 false를 리턴해야함

- 시간복잡도
    - O(N)

- 기타
    - 맨처음 값이 (arr[0]) 이 해당 arr에서 가장 클 경우도 생각해야함 (내리막길 케이스)
    - 만약에 연속해서 숫자가 같은게 나온다면, false를 리턴해야함
    
