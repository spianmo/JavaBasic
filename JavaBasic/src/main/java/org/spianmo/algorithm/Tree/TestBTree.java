package org.spianmo.algorithm.Tree;

/**
 * @ClassName TestBTree
 * @Description TODO
 * @Author Finger
 * @Date 11/3/2020
 **/
public class TestBTree {
    public static void main(String[] args) {
        BTreeClass bTree = new BTreeClass();
        bTree.createBTree("(a,(d,f)),(b),(c),(d,q)");
        System.out.println("==========>二叉树高度"+bTree.height());
        System.out.println(bTree.findNode('a').data);
        System.out.println(bTree.toString());
    }
}
