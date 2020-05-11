package 一些问题;

/**
 * @author parry
 * @date 2020/05/11
 */
public class 快速幂 {
    
    public static void main(String[] args) {
        System.out.println(myPow(2, 1));
        System.out.println(myPow(1, -1 >>> 1));
    }
    
    private static double myPow(double x, int n) {
        if (n < 0) {
            return 1 / fun(x, -n);
        }
        return fun(x, n);
    }
    
    /**
     * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
     */
    public static double fun(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double result = fun(x, n / 2);
        return (n & 1) == 0 ? result * result : result * result * x;
    }
    
    
    /**
     * https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
     */
    private static double fun1(double x, int n) {
        double result = 1;
        while (n >= 1) {
            if ((n & 1) == 1) {
                result *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return result;
    }
}
