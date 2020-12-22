package fkk;

/**
 * 【移动0】 https://leetcode-cn.com/problems/move-zeroes/
 */
public class LC283 {


    /**
     * 三指针法
     */
    public static void moveZeroes(int[] nums) {

        int head = 0;
        int footer = nums.length - 1;

        while (head < footer) {

            while (footer >= head && nums[footer] == 0) {
                footer--;
            }

            while (head < footer && nums[head] != 0) {
                head++;
            }

            if (head == footer) {
                break;
            }

            int a = head;

            while (a < footer) {
                int temp = nums[a + 1];
                nums[a + 1] = nums[a];
                nums[a] = temp;
                a++;
            }

        }

    }
}
