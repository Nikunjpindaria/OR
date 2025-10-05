import java.util.Scanner;

public class Northwest { 
    public static void main(String[] args) {
       
         
        //componies
        System.out.println("enter numbers of companies");
        Scanner sc = new Scanner(System.in);
        int companies = sc.nextInt();
        int[] supply= new int[companies];

        for(int i=0;i<companies;i++){
            System.out.println("enter supply from company :"+i);
            supply[i]=sc.nextInt();

        }
        //warehouses
        System.out.println("enter numbers of warehouses");
        
        int warehouses = sc.nextInt();
        int[] demand= new int[companies];

        for(int i=0;i<warehouses;i++){
            System.out.println("enter demand for warehouse :"+i);
            demand[i]=sc.nextInt();

        }

         int[][] grid = new int[warehouses][companies] ;
         for(int i=0;i<companies;i++){
            for(int j=0;j<warehouses;j++){
                System.out.println("enter cost for company :"+i+" to warehouse :"+j);
                grid[j][i]=sc.nextInt();
            }
         }

        int startR = 0; // start row
        int startC = 0; // start col
        int ans = 0;

        // Loop runs until it reaches the bottom right
        // corner
        while (startR != grid.length
               && startC != grid[0].length) {

            // If demand is greater than supply
            if (supply[startR] <= demand[startC]) {
                ans += supply[startR]
                       * grid[startR][startC];

                // Subtract the value of supply from the demand
                demand[startC] -= supply[startR];
                startR++;
            }

            // If supply is greater than demand
            else {
                ans += demand[startC]
                       * grid[startR][startC];

                // Subtract the value of demand from the supply
                supply[startR] -= demand[startC];
                startC++;
            }
        }

        System.out.println(
            "The initial feasible basic solution is "
            + ans);
    }
}
    

