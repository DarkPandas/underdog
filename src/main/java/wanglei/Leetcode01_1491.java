package wanglei;

import java.util.Map;

public class Leetcode01_1491 {

    /**
     * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
     *
     * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
     *
     */

    public double average(int[] salary) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            maxValue = Math.max(maxValue, salary[i]);
            minValue = Math.min(minValue, salary[i]);
        }
        return (sum - minValue - maxValue) / (salary.length - 2);
    }
}
