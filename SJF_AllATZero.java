import java.util.*;

public class SJF_AllATZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        String[] process = new String[n];
        int[] BT = new int[n];
        int[] CT = new int[n];
        int[] TAT = new int[n];
        int[] WT = new int[n];

        // Input burst times
        for (int i = 0; i < n; i++) {
            process[i] = "P" + (i + 1);
            System.out.print("Enter Burst Time of " + process[i] + ": ");
            BT[i] = sc.nextInt();
        }

        // Sort processes by Burst Time (since AT=0 for all)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (BT[j] > BT[j + 1]) {
                    // swap burst times
                    int temp = BT[j];
                    BT[j] = BT[j + 1];
                    BT[j + 1] = temp;

                    // swap process names
                    String t = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = t;
                }
            }
        }

        // Calculate CT, TAT, WT
        int time = 0;
        double avgTAT = 0, avgWT = 0;
        for (int i = 0; i < n; i++) {
            time += BT[i];
            CT[i] = time;
            TAT[i] = CT[i];        // AT = 0 → TAT = CT
            WT[i] = TAT[i] - BT[i];
            avgTAT += TAT[i];
            avgWT += WT[i];
        }

        // Print result
        System.out.println("\nProcess\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.println(process[i] + "\t" + BT[i] + "\t" + CT[i] + "\t" + TAT[i] + "\t" + WT[i]);
        }

        System.out.println("\nAverage Turn Around Time: " + (avgTAT / n));
        System.out.println("Average Waiting Time: " + (avgWT / n));

        sc.close();
    }
}
