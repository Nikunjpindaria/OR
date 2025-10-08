import java.util.Arrays;

public class HungarianAlgorithm {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) { 
        // Cost matrix (agents x tasks)
        int[][] costMatrix = {
            {4, 2, 8},
            {2, 3, 7},
            {3, 1, 6}
        };

        int[] assignment = hungarian(costMatrix);
        int totalCost = 0;

        System.out.println("Optimal Assignment:");
        for (int i = 0; i < assignment.length; i++) {
            System.out.println("Agent " + i + " assigned to Task " + assignment[i]);
            totalCost += costMatrix[i][assignment[i]];
        }

        System.out.println("Total Minimum Cost: " + totalCost);
    }

    public static int[] hungarian(int[][] cost) {
        int n = cost.length;
        int[] u = new int[n + 1];
        int[] v = new int[n + 1];
        int[] p = new int[n + 1];
        int[] way = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            p[0] = i;
            int j0 = 0;
            int[] minv = new int[n + 1];
            boolean[] used = new boolean[n + 1];
            Arrays.fill(minv, INF);

            do {
                used[j0] = true;
                int i0 = p[j0], delta = INF, j1 = -1;

                for (int j = 1; j <= n; j++) {
                    if (!used[j]) {
                        int cur = cost[i0 - 1][j - 1] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0;
                        }
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }

                for (int j = 0; j <= n; j++) {
                    if (used[j]) {
                        u[p[j]] += delta;
                        v[j] -= delta;
                    } else {
                        minv[j] -= delta;
                    }
                }

                j0 = j1;
            } while (p[j0] != 0);

            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }

        int[] result = new int[n];
        for (int j = 1; j <= n; j++) {
            result[p[j] - 1] = j - 1;
        }

        return result;
    }
}

