package 排序;

import java.util.Arrays;

import static 排序.快速排序.quickSort;

public class 归并排序 {
    
    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        int[] data1 = {4, 5, 6, 7};
        Arrays.stream(mergeSort(data, data1)).forEach(x -> System.out.print(x + " "));
    }
    
    private static int[] mergeSort(int[] data, int[] data1) {
        
        int length = data.length;
        int length1 = data1.length;
        data = quickSort(data, 0, length - 1);
        data1 = quickSort(data1, 0, length1 - 1);
        
        int[] res = new int[length + length1];
        int[] overageData;
        int i = 0;
        int j;
        int index = 0, index1 = 0;
        for (; ; i++) {
            if (data[index] < data1[index1]) {
                res[i] = data[index];
                index++;
                if (index == length) {
                    overageData = data1;
                    j = index1;
                    break;
                }
            } else {
                res[i] = data1[index1];
                index1++;
                if (index1 == length1) {
                    overageData = data;
                    j = index;
                    break;
                }
            }
        }
        for (; j < overageData.length; j++) {
            res[++i] = overageData[j];
        }
        return res;
    }
}
