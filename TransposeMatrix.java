import java.util.Scanner;

public class TransposeMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array:");
        int n=sc.nextInt();
        System.out.println("enter size of array:");
        int m=sc.nextInt();
        int[][] arr=new int[n][m];
        int[][] transposedMatrix=new int[m][n];


        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println("enter element at position ["+i+"]["+j+"]");
                arr[i][j]=sc.nextInt();


            }
            
            
        }
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transposedMatrix[j][i] = arr[i][j];
            }
        }
       
            

        
        
        System.out.println("array is:");
        for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                
                System.out.print(arr[i][j]+" ");
                


            }
            System.out.println();
        }
         System.out.println("transpose is:");
        for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                
                System.out.print(transposedMatrix[i][j]+" ");
                


            }
            System.out.println();
        }

    } 

    
}
