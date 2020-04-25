package 一些问题;

/**
 * @author parry
 * @date 2020/02/20
 * 已知根号2约等于1.414，求精确到0.0000000001的值
 */
public class 求根号2 {
    
    public static void main(String[] args) {
        System.out.println(sqrt(1.413, 1.415, 0.0000000001));
        System.out.println(sqrt(1.4, 1.5, 0.0000000001));
    }
    
    /**
     * 二分查找
     */
    private static double sqrt(double low, double high, double precision) {
        double mid = (high + low) / 2;
        if (mid < 0) {
            throw new IllegalArgumentException("high < low");
        }
        while (high - low > precision) {
            if (mid * mid > 2) {
                high = mid;
            }else {
                low = mid;
            }
            mid = (high + low) / 2;
        }
        return mid;
    }
}
