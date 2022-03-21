package BinaryTree;

// Definition for a binary tree node. 二叉树类型
public class TreeNode<T> {
    T val; //结点数据
    TreeNode<T> left; //左子树
    TreeNode<T> right; //右子树
    TreeNode<T> next;

    TreeNode() {}
    TreeNode(T val) { this.val = val; }
    TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 作用：构造二叉树
     * 注：必须逆序建立，即：先建立子节点，再逆序往上建立
     * 原因：非叶子节点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
     */
    public TreeNode<String> init(){
        // 结构如下：(由下往上建立)
        //            A
        //       B         C
        //    D         E     F
        //  G   H         I
        TreeNode<String> I = new TreeNode<String>("I", null, null);
        TreeNode<String> H = new TreeNode<String>("H", null, null);
        TreeNode<String> G = new TreeNode<String>("G", null, null);
        TreeNode<String> F = new TreeNode<String>("F", null, null);
        TreeNode<String> E = new TreeNode<String>("E", null, I);
        TreeNode<String> D = new TreeNode<String>("D", G, H);
        TreeNode<String> C = new TreeNode<String>("C", E, F);
        TreeNode<String> B = new TreeNode<String>("B", D, null);
        TreeNode<String> A = new TreeNode<String>("A", B, C);
        return A;  // 返回根节点
    }

    public TreeNode<String> perfectBTInit(){
        // 结构如下：(由下往上建立)
        //            4
        //       2         7
        //    1     3    6     9
        TreeNode<String> one = new TreeNode<String>("1", null, null);
        TreeNode<String> three = new TreeNode<String>("3", null, null);
        TreeNode<String> six = new TreeNode<String>("6", null, null);
        TreeNode<String> nine = new TreeNode<String>("9", null, null);
        TreeNode<String> two = new TreeNode<String>("2", one, three);
        TreeNode<String> seven = new TreeNode<String>("7", six, nine);
        TreeNode<String> four = new TreeNode<String>("4", two, seven);
        return four;  // 返回根节点
    }
}