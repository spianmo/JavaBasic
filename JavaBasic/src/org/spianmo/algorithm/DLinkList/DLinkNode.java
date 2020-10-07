package org.spianmo.algorithm.DLinkList;

/**
 * @ClassName DLinkNode
 * @Description TODO
 * @Author Finger
 * @Date 10/7/2020
 **/
public class DLinkNode<E> {
    E mData;
    int mFrequency;
    DLinkNode<E> mFont;
    DLinkNode<E> mNext;

    public DLinkNode(){
        mFrequency = 0;
        mFont = null;
        mNext = null;
    }

    public DLinkNode(E data){
        mFrequency = 0;
        mData = data;
        mNext = null;
    }
}
