package 排序;

import java.util.Arrays;

public class 快速排序 {
    
    public static void main(String[] args) {
        
        int[] data = {6, 2, 7, 3, 8, 9};
        int[] data1 = {1, 2, 3, 4, 5, 6};
        int[] data2 = {6, 5, 4, 3, 2, 1};
        Arrays.stream(quickSort1(data2, 0, data2.length - 1)).forEach(x -> System.out.print(x + " "));
    }
    
    /**
     * 递归方式的快排,时间复杂度为O(n)
     *
     * @param data  待排数组
     * @param start 待排元素起始下标
     * @param end   待排元素结束下标
     */
    
    public static int[] quickSort(int[] data, int start, int end) {
        if (end <= start) {
            return data;
        }
        
        //简便起见,确定枢纽元,这里以下标为start的元素
        int key = data[start];
        int i = 0;
        int j = end - start + 1;
        //为了减少交换次数,新建数组用于存储排好序的结果
        int[] tmp = new int[j--];
        for (int z = start + 1; z <= end; z++) {
            if (data[z] > key) {//将小于枢纽元的元素从数组头开始存放
                tmp[j--] = data[z];
            } else {//这里会造成不稳定排序
                tmp[i++] = data[z];//将大于枢纽元的元素从数组尾部开始存放
            }
        }
        //将枢纽元放入结果数组中
        tmp[i] = key;
        //最后将排好序的结果放入data中,最后枢纽元在data中的下标是start+i
        System.arraycopy(tmp, 0, data, start, tmp.length);
        //对枢纽元左边的元素进行排序
        data = quickSort(data, start, start + i - 1);
        //对枢纽元右边的元素进行排序
        data = quickSort(data, start + i + 1, end);
        return data;
    }
    
    /**
     * 原地排序
     */
    public static int[] quickSort1(int[] data, int start, int end) {
        if (end <= start) {
            return data;
        }
        int key = partition(data, start, end);
        quickSort1(data, start, key - 1);
        quickSort1(data, key + 1, end);
        return data;
    }
    
    /**
     * 返回枢纽元的下标
     */
    public static int partition(int[] data, int start, int end) {
        int key = data[end];
//        [start,i)是小于枢纽元的区间,(i,end]是大于等于枢纽元的区间
        int i = start;
        for (int j = start; j < end; j++) {
            if (data[j] < key) {
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                i++;
            }
        }
        int tmp = data[i];
        data[i] = data[end];
        data[end] = tmp;
        return i;
    }
}
