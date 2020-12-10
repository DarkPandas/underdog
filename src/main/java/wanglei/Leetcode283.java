package wanglei;

/**
 * @author wanglei
 * @version 1.0
 * @date 2020-12-10 8:51 下午
 */
public class Leetcode283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */

    public static void main(String[] args) {
        int [] data = new int[]{0,1,0,3,12};
        solution(data);
        for (int datum : data) {
            System.out.println("data:" + datum);
        }
    }

    /**
     * 双指针(快慢指针) 快指针每次向右遍历元素，如果该元素为零，则与慢指针所处的元素交换位置，此时慢指针才会向右移动
     * @param arr
     */
    private static void solution(int [] arr){
        int length = arr.length;
        int slowIndex = 0;
        int fastIndex = 0;
        while (fastIndex < length){
            if (arr[fastIndex] == 0){
                swap(arr, fastIndex, slowIndex);
                slowIndex ++;
            }
            fastIndex ++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
