public class Maximization {
    public static void main(String[] args) {
        int x1=0,x2=0,Z,Max=0;
        for(x1=0;x1<=4;x1++){
            for(x2=0;x2<=4;x2++){
                if(x1+x2<=4){
                    Z=3*x1 + 2*x2;
                    if(Z>Max){
                        Max=Z;
                    }
                }
            }
        }
        System.out.println(Max);
    }
    
}
