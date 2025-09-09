public class Simplexmeth {

    public static void main(String[] args) {
        // Right-hand side values
        double[] b = {24, 21, 9};
double[] c = {2, 5};

double[][] newMat = {
    {1, 4, 1, 0, 0, 24},
    {3, 1, 0, 1, 0, 21},
    {1, 1, 0, 0, 1, 9}
};

int[] cb = {0, 0, 0};
int[] cj = {2, 5, 0, 0, 0, 0};  // ✅ Added 6th value for RHS
int[] zj = new int[newMat[0].length];
int[] cjmzj = new int[newMat[0].length];

        // Step 1: Calculate Zj
        calczj(zj, cb, newMat);

        // Step 2: Calculate Cj - Zj
        calcjMInusZj(cjmzj, cj, zj);

        // Step 3: Find entering variable (column with max Cj - Zj)
        int keyCol = findkeyCol(cjmzj);
        System.out.println("Key Column (Entering Variable): " + keyCol);

        // Step 4: Find leaving variable (minimum ratio test)
        int keyRow = findKeyRow(keyCol, b, newMat);
        System.out.println("Key Row (Leaving Variable): " + keyRow);

        // Step 5: Pivot Element
        double pivot = newMat[keyRow][keyCol];
        System.out.println("Pivot Element: " + pivot);

        // Step 6: Normalize the pivot row
        for (int i = 0; i < newMat[0].length; i++) {
            newMat[keyRow][i] /= pivot;
        }
        b[keyRow] /= pivot;

        // Step 7: Make other entries in key column zero
        for (int i = 0; i < newMat.length; i++) {
            if (i != keyRow) {
                double factor = newMat[i][keyCol];
                for (int j = 0; j < newMat[0].length; j++) {
                    newMat[i][j] -= factor * newMat[keyRow][j];
                }
                b[i] -= factor * b[keyRow];
            }
        }

        // Step 8: Update cb
        cb[keyRow] = cj[keyCol];

        // Print updated table
        System.out.println("\nUpdated Tableau:");
        for (int i = 0; i < newMat.length; i++) {
            for (int j = 0; j < newMat[0].length; j++) {
                System.out.print(newMat[i][j] + "\t");
            }
            System.out.println(" | b = " + b[i] + " | cb = " + cb[i]);
        }
    }

    // Calculate zj values
    public static int[] calczj(int[] zj, int[] cb, double[][] newMat) {
        for (int i = 0; i < newMat[0].length; i++) {
            for (int j = 0; j < newMat.length; j++) {
                zj[i] += cb[j] * newMat[j][i];
            }
        }
        return zj;
    }

    // Calculate cj - zj
    public static int[] calcjMInusZj(int[] cjmzj, int[] cj, int[] zj) {
        for (int i = 0; i < cjmzj.length; i++) {
            cjmzj[i] = cj[i] - zj[i];
        }
        return cjmzj;
    }

    // Find entering variable (most positive cj - zj)
    public static int findkeyCol(int[] cjmzj) {
        int maxIndex = 0;
        for (int i = 1; i < cjmzj.length; i++) {
            if (cjmzj[i] > cjmzj[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    // Find leaving variable (minimum ratio b[i]/a[i][colIndex])
    public static int findKeyRow(int colIndex, double[] b, double[][] newMat) {
        double[] ratio = new double[b.length];
        for (int i = 0; i < b.length; i++) {
            if (newMat[i][colIndex] == 0) {
                ratio[i] = Double.POSITIVE_INFINITY;
            } else {
                ratio[i] = b[i] / newMat[i][colIndex];
            }
        }

        int minIndex = 0;
        for (int i = 1; i < ratio.length; i++) {
            if (ratio[i] < ratio[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}

