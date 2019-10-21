package app;

public class Tech2 {

    public static void main(String[] args) throws Exception {
        int[][] lands = new int[][] { { 10, 0, 30, 5 }, { 0, 30, 20, 50 }, { 30, 30, 40, 40 } };
        int[][] wells = new int[][] { { 15, 15, 25, 25 }, { 40, 10, 50, 20 } };
        int[] points = new int[] { 10, 10, 30, 30 };

        // int[][] lands = new int[][] { { 0, 0, 20, 10 }, { 10, 20, 20, 40 }, { 30, 0,
        // 50, 20 } };
        // int[][] wells = new int[][] { { 20, 40, 30, 50 }, { 30, 20, 50, 30 } };
        // int[] points = new int[] { 20, 30, 30, 40 };

        System.out.println(solution(lands, wells, points));
    }

    private static boolean solution(int[][] lands, int[][] wells, int[] points) {

        boolean flag = false;

        // 토지가 겹치는가?
        for (int i = 0; i < lands.length; i++) {
            for (int j = 0; j < lands[i].length; j++) {
                if (points[0] > lands[i][0] && points[1] > lands[i][1]) {
                    if (points[0] < lands[i][2] && points[1] < lands[i][3]) {
                        flag = false;
                        break;
                    }
                }
                if (points[2] > lands[i][0] && points[3] > lands[i][1]) {
                    if (points[2] < lands[i][2] && points[3] < lands[i][3]) {
                        flag = false;
                        break;
                    }

                }

            }
        }
        // 분양받을 토지 내부에 식수원이 있는가?
        for (int i = 0; i < wells.length; i++) {
            for (int j = 0; j < wells[i].length; j++) {
                if (points[0] < wells[i][0] && points[1] < wells[i][1]) {
                    if (points[2] > wells[i][2] && points[3] > wells[i][3]) {
                        flag = true;
                        break;

                    }

                }
            }

        }

        return flag;
    }

}