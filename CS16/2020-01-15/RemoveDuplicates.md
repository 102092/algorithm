> https://leetcode.com/problems/remove-duplicates-from-sorted-array/



## 작성 코드

```java
class Solution {
    public int removeDuplicates(int[] nums) {
    //null check
    int length = nums.length;
        
    if(length == 0) return 0;
    int base = 0;
     
    
    //base vs compare
    for (int compare = 1; compare < length; compare++ ){
        if(nums[base] != nums[compare]){
            base++;
            nums[base] = nums[compare];
         }
     }
    
    return base +1;
    }
}
```

- 문제조건을 살펴봐야할듯.
  - Do not allocate extra space for another array, you must do this by **modifying the input array [in-place](https://en.wikipedia.org/wiki/In-place_algorithm)** with O(1) extra memory.
  - 주어진 배열에서 움직일 수 있도록 하라는 것. 그리고 배열을 생성하지 말라함