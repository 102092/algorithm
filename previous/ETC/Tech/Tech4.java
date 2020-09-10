package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tech4 {

    public static void main(String[] args) throws Exception {

        // // 1
        // int[] pobi = new int[] { 97, 98 };
        // int[] crong = new int[] { 197, 198 };

        // // 2
        // int[] pobi = new int[] { 131, 132 };
        // int[] crong = new int[] { 211, 212 };

        // 3
        int[] pobi = new int[] { 99, 101 };
        int[] crong = new int[] { 211, 212 };

        System.out.println(solve(pobi, crong));

    }

    private static int solve(int[] pobi, int[] crong) {

        // 조건
        if (pobi[0] % 2 != 1 || pobi[1] % 2 != 0 || crong[0] % 2 != 1 || crong[1] % 2 != 0) {
            return -1;

        } else {
            int pobiPoint = 0;
            int crongPoint = 0;

            pobiPoint = cal(pobi);
            crongPoint = cal(crong);
            System.out.println(pobiPoint);
            System.out.println(crongPoint);

            if (pobiPoint > crongPoint) {
                return 1;
            } else if (pobiPoint < crongPoint) {
                return 2;
            } else {
                return 0;
            }

        }

    }

    private static int cal(int[] input) {
        int[] result = new int[] { 0, 1, 0, 1 }; // left sum , left mull, rightsum, right mull

        int leftPage = input[0];
        int rightPage = input[1];

        int leftSum = leftPage;
        while (leftSum != 0) {
            result[0] += leftSum % 10;
            leftSum /= 10;
        }

        int rightSum = rightPage;
        while (rightSum != 0) {
            result[2] += rightSum % 10;
            rightSum /= 10;
        }

        int leftMul = leftPage;
        while (leftMul != 0) {
            result[1] *= leftMul % 10;
            leftMul /= 10;

        }

        int rightMul = rightPage;
        while (rightMul != 0) {
            result[3] *= rightMul % 10;
            rightMul /= 10;

        }

        List<Integer> temp = new ArrayList<>(result.length);
        for (Integer integer : result) {
            temp.add(integer);
        }
        return Collections.max(temp);
    }

}