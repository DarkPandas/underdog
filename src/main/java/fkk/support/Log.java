package fkk.support;

/**
 * Author: karl
 * Date: 2021/1/7 下午10:45
 * <p>
 * Desc:
 */
public class Log {

    public static void n(String msg) {
        System.out.println(msg);
    }

    public static void w(String msg) {
        System.out.print(msg);
    }

    public static void w(int msg) {
        System.out.print("" + msg);
    }
}
