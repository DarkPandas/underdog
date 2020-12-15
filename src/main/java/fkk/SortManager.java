package fkk;

public class SortManager {

    /**
     * 插入排序
     */
    public static int[] insertionSort(int[] arrays) {
        int step, currentValue;

        for (int i = 1; i < arrays.length; i++) {
            step = i - 1;
            currentValue = arrays[i];
            while (step >= 0 && arrays[step] >= currentValue) {
                arrays[step + 1] = arrays[step];
                step--;
            }
            arrays[step + 1] = currentValue;
        }

        return arrays;
    }
}
