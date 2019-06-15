package baekjoon;

import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int[] digits = new int[a];
        String b = s.next();
        int sum = 0;

        digits = Stream.of(b.split("")).mapToInt(Integer::parseInt).toArray();
        
        for(int i =0; i < digits.length; i++){
            
            sum += digits[i];
        }
        System.out.print(sum);
        s.close();
    }

}
