package app;

import java.util.Arrays;

public class Tech1 {

    public static void main(String[] args) throws Exception {
        int money = 36000;
        int[] result = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        int input = money;

        if (input / 50000 > 0) {
            int count = input / 50000;

            for (int i = 0; i < count; i++) {
                result[0]++;
            }
            input = input % 50000;
        }

        if (input / 10000 > 0) {
            int count = input / 10000;

            for (int i = 0; i < count; i++) {
                result[1]++;
            }
            input = input % 10000;
        }

        if (input / 5000 > 0) {
            int count = input / 5000;

            for (int i = 0; i < count; i++) {
                result[2]++;
            }
            input = input % 5000;
        }

        if (input / 1000 > 0) {
            int count = input / 1000;

            for (int i = 0; i < count; i++) {
                result[3]++;
            }
            input = input % 1000;
        }

        if (input / 500 > 0) {
            int count = input / 500;

            for (int i = 0; i < count; i++) {
                result[4]++;
            }
            input = input % 500;
        }

        if (input / 100 > 0) {
            int count = input / 100;

            for (int i = 0; i < count; i++) {
                result[5]++;
            }
            input = input % 100;
        }

        if (input / 50 > 0) {
            int count = input / 50;

            for (int i = 0; i < count; i++) {
                result[6]++;
            }
            input = input % 50;
        }

        if (input / 10 > 0) {
            int count = input / 10;

            for (int i = 0; i < count; i++) {
                result[7]++;
            }
            input = input % 10;
        }

        if (input / 1 > 0) {
            int count = input / 1;

            for (int i = 0; i < count; i++) {
                result[8]++;
            }

        }
        System.out.println(Arrays.toString(result));

    }

}