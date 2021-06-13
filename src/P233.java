import java.util.Scanner;
class P233 {
    public static int countDigitOne(int n) {
        int high=n/10;
        int current=n%10;
        int low=0;
        int tag=1;

        int res=0;
        while(high!=0 || current!=0){
            switch(current){
                case 0:res+=high*tag;break;
                case 1:res+=high*tag+low+1;break;
                default:res+=high*tag+tag;
            }

            tag*=10;
            current=high%10;
            low=n%tag;
            high/=10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println(countDigitOne(scanner.nextInt()));
    }
}
