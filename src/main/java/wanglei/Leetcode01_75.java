package wanglei;

public class Leetcode01_75 {

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     */

    public static void main(String[] args) {
        Leetcode01_75 a = new Leetcode01_75();
        int[]num = new int[]{2,0,1};
        a.sortColors(num);
    }

    /**
     * 双指针法分别从起点和终点进行遍历，遇到0放置头部 遇到2放到尾部，同步修改头部和尾部对应的索引。
     */
    public void sortColors(int[] nums){
        if (nums == null){
            return;
        }
        int length = nums.length;
        int leftIndex = 0;
        int rightIndex = length - 1;

        for (int i = 0; i <= rightIndex; ++i) {
            while (i <= rightIndex && nums[i] == 2){
                swap(nums, i, rightIndex);
                --rightIndex;
            }
            if (nums[i] == 0){
                swap(nums, i, leftIndex);
                ++leftIndex;
            }
        }
    }

    private void swap(int[] nums, int p, int i){
        int temp = nums[p];
        nums[p] = nums[i];
        nums[i] = temp;
    }
}
