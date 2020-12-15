package fkk;

import java.util.List;

/**
 * 三数之和 https://leetcode-cn.com/problems/3sum/
 */
public class HelloLC {

    public static void main(String[] args) {
        List<List<Integer>> lists = LC15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println("[\n");
        for (List<Integer> list : lists) {
            String msg = "{" + list.get(0) + "," + list.get(1) + "," + list.get(2) + "}";
            System.out.println(msg + "\n");
        }
        System.out.println("\n]");
    }
}
