package fkk;

import fkk.support.Log;

/**
 * Author: karl
 * Date: 2021/3/13 下午9:32
 * <p>
 * Desc:
 */
public class LC509 {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


    public static void main(String[] args) {

    }
}
