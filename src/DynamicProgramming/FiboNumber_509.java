package DynamicProgramming;

public class FiboNumber_509 {
    public static void main(String[] args) {
        System.out.println(fib(1));
    }

    public static int fib(int n) {
        int first = 0;
        int second = 1;
        if(n==1) return 1;
        if (n==2) return second;
        int ans = 0;
        for(int i=3;i<=n;i++){
            int temp = first + second;
            first = second;
            second = temp;
            ans = first+second;
        }
        return ans;
    }
}
