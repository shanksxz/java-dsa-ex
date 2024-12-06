public class Main {

    // n to 1
    public static void f(int count) {
        if(count == 0) {
            return;
        }
        System.out.println(count);
        f(count - 1);
    }

    // 1 to n
    public static void f2(int i, int n) {
        // if(i > n) return;
        // System.out.println(i);
        // f2(i+1, n);
        if(n == 0) return;
        f2(i, n-1);
        System.out.println(n);
    }

    // sum of first n numbers - parametrized way
    public static void f3(int n, int sum) {
        if(n==0) {
            System.out.println(sum);
            return;
        }
        f3(n-1, sum + n);
    }

    // sum of first n numbers - functional way
    public static int f4(int n) {
        if(n==0) return 0;
        return n + f4(n-1);
    }

    public static void main(String[] args) {
        // f(5);
        // f2(1, 5);
        // f3(5, 0);
        System.out.println(f4(5));
    }   
}
