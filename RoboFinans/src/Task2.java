import java.lang.reflect.Array;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        final int ROW = 3;
        final int COL = 5;
        int[][] sm = new int[ROW][COL];

        int k = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                sm[i][j] = k;
                k++;
            }
        }

        System.out.println(Arrays.deepToString(sm));
        System.out.println();

        int[][] newMatrix = transition(sm);
        System.out.println(Arrays.deepToString(newMatrix));
    }

    private static int[][] transition(int[][] sm) {
        int row = sm.length;
        int col = sm[0].length;
        int[][] tMatrix = new int[col][row];

        for (int i = 0; i < col; i++) {
            tMatrix[i] = new int[row];
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tMatrix[j][row - i - 1] = sm[i][j];
            }
        }
        return tMatrix;
    }
}