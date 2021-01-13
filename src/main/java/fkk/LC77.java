package fkk;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Author: karl
 * Date: 2021/1/11 下午10:07
 * <p>
 * Desc: 组合 https://leetcode-cn.com/problems/combinations/
 * 主要考察 回溯算法+剪枝
 */
public class LC77 {

    private List<Integer> temp = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        temp.clear();
        result.clear();
        dfs(1, n, k);
        return result;
    }

    private void dfs(int start, int n, int k) {
        if (temp.size() + (n - start + 1) < k) {
            return;
        }

        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(start);
        dfs(start + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(start + 1, n, k);
    }


    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> container = new ArrayList<>();
        if (k == 0 || n < k) {
            return container;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, container);
        return container;
    }

    private void dfs(int n, int k, int start,
                     Deque<Integer> path, List<List<Integer>> container) {
        if (path.size() == k) {
            container.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= (n + 1 - (k - path.size())); i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, container);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        LC77 lc77 = new LC77();
        lc77.combine(4, 2);
    }
}
