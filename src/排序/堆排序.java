package 排序;

public class 堆排序 {

    private static Integer leftChild(Integer i) {
        return 2 * i + 1;
    }

    /**
     * @param a 操作的数组
     * @param i 下虑开始的位置
     * @param n 数组大小
     * 该堆是大顶堆
     */
    private static void percDown(Integer[] a, Integer i, Integer n) {
        Integer child;
        Integer temp=a[i];

        for (; leftChild(i) < n; i = child) {
            child = leftChild(i);//获取左儿子节点
            if ((child != n - 1) && (a[child] < a[child + 1]))//获取两个儿子节点中最大的节点
                child++;
            if (temp < a[child])//由于是大顶堆,所以父节点必须大于子节点,所以如果temp小于最大的子节点时,不满足堆序性质,空穴下虑
                a[i] = a[child];
            else//反之,满足堆序性质
                break;
        }
        a[i] = temp;
    }

    private static void swap(Integer[] a, Integer i, Integer n) {
        Integer temp = a[i];
        a[i] = a[n];
        a[n] = temp;
    }

    private static void forEach(Integer[] a) {
        for (Integer i = 0; i < a.length; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = { 26, 53, 41, 58, 59, 31, 97 };
        // 构建大顶堆
        for (Integer i = a.length / 2 - 1; i >= 0; i--)// build heap
            percDown(a, i, a.length);
        forEach(a);
        // 每次循环将最大的值放在数组的末尾,并且堆大小减一,当堆被清空时,数组即为升序排列的序列
        for (Integer i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);// delete max
            percDown(a, 0, i);// 执行下滤,重新构建堆
        }
        forEach(a);
    }
}
