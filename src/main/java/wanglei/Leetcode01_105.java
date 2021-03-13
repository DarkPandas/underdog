package wanglei;

import wanglei.struc.TreeNode;

import java.util.Arrays;

/**
 * @author wanglei
 * @version 1.0
 * @date 2021-01-17 10:45 上午
 */
public class Leetcode01_105 {

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     */

    /**
     *
     * 重建二叉树的基本思路就是先构造根节点，再构造**左子树**，接下来构造**右子树**，其中，构造**左子树**和**右子树**是一个子问题，递归处理即可。因此我们只关心如何构造根节点，以及如何递归构造左子树和右子树。
     *
     * 递归函数的设计上，仍旧采用**左闭右闭**对数组局部进行描述。即一个数组，使用 3 个变量描述：
     *
     * 数组本身 arr
     * 数组的起始位置 lo
     * 数组的结束位置 hi
     * 因此，数组实际元素就是 arr[lo..hi] 这个范围（注意这是一个左闭右闭的区间，如果你喜欢左闭右开区间，那你可能重新考虑一下 lo、hi 的值如何计算）。
     *
     * 后面的故事就很简单了，三元组 (preorder, lo1, hi1) 描述的前序遍历数组，以及三元组 (inorder, lo2, hi2) 描述的中序遍历数组，如何从它们重建二叉树？递归的说法就是：
     *
     * 创建根节点
     * 递归创建左子树
     * 递归创建右子树
     * 你会发现，递归创建左子树，无非就是再构造一个新的前序遍历的三元组 (preorder, lo1+1, lo1+mid-lo2) 以及 (inorder, lo2, mid-1)，其中 mid 是当前 inorder 中 root 的位置。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=0;i<preorder.length;i++){
            if(preorder[0]==inorder[i]){
                root.left=buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                root.right=buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                break;
            }
        }
        return root;
    }
}
