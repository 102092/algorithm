package app;

public class Tech5 {

    public static void main(String[] args) throws Exception {
        // int number = 13;

        int number = 33;

        System.out.println(solve(number));

    }

    private static int solve(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            String temp = i + "";
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
                    count++;
                }
            }
        }

        return count;
    }

}