package TutortAssignments.RecursionAssignment;

public class Q3CountGoodNumbers {
    public static long mod = 1000000007;
    public static void main(String[] args) {
        long n =50;
        //System.out.println(recursiveApproach(n));
        System.out.println(iterativeAproach(n));
    }

    private static int recursiveApproach(long n) {

        long odd = n/2;
        long even = (n/2)+n%2;
        return (int)((pow(5,even)*pow(4,odd))%mod);
    }

    private static long pow(long x, long n) {
        if(n==0){
            return 1;
        }
        if(n%2==0){
            return pow((x*x)%mod,n/2);
        }else{
            return (x%mod * pow (x,n-1))%mod;
        }
    }

    private static int iterativeAproach(long n){
        long odd = n / 2;
        long even = (n / 2) + n % 2;

        long evenPower = 1;
        long oddPower = 1;

        // Calculate power of 5 for even-indexed digits
        for (int i = 0; i < even; i++) {
            evenPower = (evenPower * 5) % mod;
        }

        // Calculate power of 4 for odd-indexed digits
        for (int i = 0; i < odd; i++) {
            oddPower = (oddPower * 4) % mod;
        }

        return (int)((evenPower * oddPower) % mod);
    }


}
