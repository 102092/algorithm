

## 강의풀이

```java
package app;

public class TrappingRainWater {
    public static void main(String[] args) throws Exception {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(solve(height));
    }

    private static int solve(int[] height) {

        int result = 0;
        if (height == null || height.length <= 2) // 물이 채울수가 없음. 물은 양옆으로 갇혀있어야하는데
            return result;

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        // left 배열 채우기
        int max = height[0];
        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            if (max < height[i]) {
                left[i] = height[i];
                max = height[i];
            } else {
                left[i] = max;
            }

        }

        // right 배열 채우기
        max = height[height.length - 1];
        right[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            if (max < height[j]) {
                right[j] = height[j];
                max = height[j];
            } else {
                right[j] = max;
            }

        }

        for (int i = 0; i < height.length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
}
```

## 나의풀이



## 필요개념

- 물이 채워진다.
- 얼마나 채워지는지 값을 구하라.
  1. int [] left
     - height배열을 돌면서 , max값과 비교하여 left배열을 채우는 방법으로.
  2. int [] right
  3. Math.min
  4.  **-** Height(이미 올라와있는 부분을 빼야함)
  5. 정답!.. 6이 나와야함



