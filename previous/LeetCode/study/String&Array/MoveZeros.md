- ## 강의풀이

  ```java
  package main;
  
  import java.io.*;
  
  
  public class MoveZeros {
      public static void main(String[] args) throws IOException {
          int[] nums = {0, 3, 2, 0, 8, 5};
          int index =0;
  
          for (int i = 0; i < nums.length; i++) {
              if (nums[i] !=0) {
                  nums[index] = nums[i];
                  index++;
                  System.out.println("Index: "+index);                
              }             
          }
          while (index<nums.length) {
              nums[index] = 0;
              index++;
              System.out.println("Index while : "+index);    
          }
          for (int i = 0; i < nums.length; i++) {
              System.out.print(nums[i]+" ");    
          }
          
      }
      
  }
  
  ```

  ## 나의풀이

  

  ## 필요개념

  - `Array` 개념을 알고, `Index`를 조정할 수 있는가?