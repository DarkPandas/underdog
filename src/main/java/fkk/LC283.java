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

    /**
     * 双指针
     */
    public static void solution2(int[] nums) {
        int indexNow = 0;
        int indexNum = 0;
        int m = nums.length;

        while (indexNum < m) {
            if (nums[indexNum] != 0) {
                nums[indexNow++] = nums[indexNum];
            }
            ++indexNum;
        }

        for (int i = indexNow; i < m; i++) {
            nums[i] = 0;
        }
    }


    /**
     * 快慢指针，
     * 1. 快指针跟随遍历前进
     * 2. 慢指针，只有快指针发现不为零的元素时才交换元素前进1.
     */
    public static void solution3(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
    }

    private static void swap(int[] nums, int a, int b) {
        if (a == b) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 0, 1, 0, 3, 12};
        solution2(data);
    }
}
