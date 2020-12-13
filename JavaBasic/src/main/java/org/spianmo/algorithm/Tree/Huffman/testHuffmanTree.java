package org.spianmo.algorithm.Tree.Huffman;

/**
 * @ClassName HuffmanTree
 * @Description TODO
 * @Author Finger
 * @Date 11/17/2020
 **/
public class testHuffmanTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node root = huffmanTree.createHuffmanTree(arr);
        huffmanTree.preOrder(root);
    }

}

