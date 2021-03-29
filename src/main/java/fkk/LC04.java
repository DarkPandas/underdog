package fkk;

/**
 * Author: karl
 * Date: 2021/3/13 下午10:47
 * <p>
 * Desc:
 */
public class LC04 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = 0, b = 0, step = 0;
        int length1 = nums1.length, length2 = nums2.length;
        if (length1 == 0 && length2 == 0) {
            return 0;
        }

        if (length1 == 0) {
            return calculate(nums2);
        }

        if (length2 == 0) {
            return calculate(nums1);
        }

        int length = length1 + length2;
        int[] array = new int[length1 + length2];
        while (step < length) {
            if (a < length1 && b < length2) {
                int m = nums1[a];
                int n = nums2[b];
                if (m > n) {
                    array[step] = n;
                    b++;
                } else {
                    array[step] = m;
                    a++;
                }
            } else if (a == length1) {
                array[step] = nums2[b];
                b++;
            } else {
                array[step] = nums1[a];
                a++;
            }
            step++;
        }

        double result;
        if (length % 2 == 0) {
            result = (array[length / 2] + array[(length / 2) - 1]) * 1.0d / 2;
        } else {
            result = array[length / 2];
        }

        return result;
    }

    private double calculate(int[] array) {
        double result;
        int length = array.length;
        if (length / 2 == 0) {
            result = (array[length / 2] + array[(length / 2) - 1]) * 1.0d / 2;
        } else {
            result = array[length / 2];
        }
        return result;
    }


}
