public class Offer16 {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }

        if(n==1){
            return x;
        }

        if(n==-1){
            return 1/x;
        }



        double reg=myPow(x,n%2);
        double mod=myPow(x,n/2);

        return mod*reg*reg;
    }
}
