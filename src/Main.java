/**
 * @author parry
 * @date 2020/04/13
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println(fun1(18));
    }
    
    /**
     * 4n+7m
     */
    private static boolean fun1(int n) {
        if (n % 4 == 0) {
            return true;
        }
        if (n % 7 == 0) {
            return true;
        }
        for (int i = 7; i < n; i+=7) {
            if ((n-i)%4 == 0) {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }
    
    
    public static int fun(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    
}
