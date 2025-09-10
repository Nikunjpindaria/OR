import java.util.*;

public class SJF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] AT = new int[n];
        int[] BT = new int[n];
        int[] CT = new int[n];
        int[] TAT = new int[n];
        int[] WT = new int[n];
        boolean[] completed = new boolean[n];

        for (int i = 0; i < n; i++) {
           
            System.out.print("Enter Arrival Time of P" + (i+1)+":");
            AT[i] = sc.nextInt();
            System.out.print("Enter Burst Time of P"+(i+1));
            BT[i] = sc.nextInt();
        }

        int time = 0, completedCount = 0;

        while (completedCount < n) {
            int idx = -1;
            int minBT = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (!completed[i] && AT[i] <= time && BT[i] < minBT) {
                    minBT = BT[i];
                    idx = i;
                }
            }

            if (idx == -1) {
                time++;
            } else {
                time += BT[idx];
                CT[idx] = time;
                TAT[idx] = CT[idx] - AT[idx];
                WT[idx] = TAT[idx] - BT[idx];
                completed[idx] = true;
                completedCount++;
            }
        }

        double avgTAT = 0, avgWT = 0;
        for (int i = 0; i < n; i++) {
            avgTAT += TAT[i];
            avgWT += WT[i];
        }

        System.out.println("\nAverage Turn Around Time: " + (avgTAT / n));
        System.out.println("Average Waiting Time: " + (avgWT / n));

    }
}
