package org.spianmo.algorithm.Tree;

/**
 * @ClassName BTNode
 * @Description TODO
 * @Author Finger
 * @Date 11/3/2020
 **/
public class BTNode<E> {
    E data;
    BTNode<E> lchild;
    BTNode<E> rchild;

    public BTNode(){
        lchild = rchild = null;
    }

    public BTNode(E d){
        data = d;
        lchild = rchild = null;
    }

}
