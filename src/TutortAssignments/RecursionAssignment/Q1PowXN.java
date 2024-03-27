package TutortAssignments.RecursionAssignment;

public class Q1PowXN {
    public static void main(String[] args) {
        double x = 7;
        int n = 7;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
//        System.out.println(approach1(x,n));
        System.out.println(approach2(x,n));
    }

    private static double approach1(double x, int n){
        if(n==0){
            return 1.0;
        }
        double half = approach1(x,n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    private static double approach2(double x, int n){
            double pow = 1;

            while(n != 0){

                if((n & 1) != 0){
                    pow *= x;
                }
                x *= x;
                n >>= 1;

            }

            return pow;
        }

}
