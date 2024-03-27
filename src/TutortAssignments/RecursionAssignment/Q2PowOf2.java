package TutortAssignments.RecursionAssignment;

public class Q2PowOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
    }
    public static boolean isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        if((n&1)!=0 || n==0) {
            return false;
        }
        return isPowerOfTwo(n/2);

    }
}
