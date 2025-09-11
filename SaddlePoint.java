import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        System.out.println("Enter the payoff matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        boolean hasSaddlePoint = false;
        int gameValue = 0;

        for (int i = 0; i < m; i++) {
            int rowMin = matrix[i][0];
            int colIndex = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < rowMin) {
                    rowMin = matrix[i][j];
                    colIndex = j;
                }
            }

            boolean isSaddle = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][colIndex] > rowMin) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                hasSaddlePoint = true;
                gameValue = rowMin;
                System.out.println("Saddle Point found at (" + i + "," + colIndex + ") = " + rowMin);
            }
        }

        if (!hasSaddlePoint) {
            System.out.println("No Saddle Point exists in the matrix.");
        } else {
            System.out.println("Value of the Game Point = " + gameValue);
        }

    }
}
