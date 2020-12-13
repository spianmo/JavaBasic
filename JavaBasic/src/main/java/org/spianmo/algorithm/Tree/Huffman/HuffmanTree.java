package org.spianmo.algorithm.Tree.Huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName HuffmanTree1
 * @Description TODO
 * @Author Finger
 * @Date 11/17/2020
 **/
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 15, 8, 2, 3, 7, 30};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node root = huffmanTree.createHuffmanTree(arr);
        huffmanTree.preOrder(root);
    }

    public void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }


    /**
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的赫夫曼树的root结点
     */
    public Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int temp : arr) {
            nodes.add(new Node(temp));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node newNode = new Node(leftNode.value + rightNode.value);
            newNode.left = leftNode;
            newNode.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    private String reverse(String s){
        StringBuilder t= new StringBuilder();
        for (int i=s.length()-1;i>=0;i--) {
            t.append(s.charAt(i));
        }
        return t.toString();
    }
}

class Node implements Comparable<Node> {
    int value;
    char c;
    Node left;
    Node right;

    public void preOrder() {
        System.out.print(this.value + " ");
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

}
