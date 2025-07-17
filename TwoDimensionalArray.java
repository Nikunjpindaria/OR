import java.util.Scanner;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array:");
        int n=sc.nextInt();
        System.out.println("enter size of array:");
        int m=sc.nextInt();
        int[][] arr=new int[n][m];


        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println("enter element at position ["+i+"]["+j+"]");
                arr[i][j]=sc.nextInt();


            }
            
            
        }
       
        
        System.out.println("array is:");
        for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                
                System.out.print(arr[i][j]+" ");
                


            }
            System.out.println();
        }

    } 


    

}
