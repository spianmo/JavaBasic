package org.spianmo.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName BTreeClass
 * @Description TODO
 * @Author Finger
 * @Date 11/3/2020
 **/
public class BTreeClass {
    BTNode<Character> b;
    String bstr;

    public BTreeClass() {
        b = null;
    }

    public void createBTree(String str) {
        Stack<BTNode<Character>> st = new Stack<>();
        BTNode<Character> p = null;
        boolean flag = true;
        char ch;
        int i = 0;
        while (i < str.length()) {
            ch = str.charAt(i);
            switch (ch) {
                case '(':
                    st.push(p);
                    flag = true;
                    break;
                case ')':
                    st.pop();
                    break;
                case ',':
                    flag = false;
                    break;
                default:
                    p = new BTNode<>(ch);
                    if (b == null) {
                        b = p;
                    } else {
                        if (flag) {
                            if (!st.empty()) {
                                st.peek().lchild = p;
                            }
                        } else {
                            if (!st.empty()) {
                                st.peek().rchild = p;
                            }
                        }
                    }
                    break;
            }
            i++;
        }
    }

    public BTNode<Character> findNode(char x) {
        return findNode1(b, x);
    }

    private BTNode<Character> findNode1(BTNode<Character> t, char x) {
        BTNode<Character> p;
        if (t == null) {
            return null;
        } else if (t.data == x) {
            return t;
        } else {
            p = findNode1(t.lchild, x);
            if (p != null) {
                return p;
            } else {
                return findNode1(t.rchild, x);
            }
        }
    }


    public int height() {
        return height1(b);
    }

    private int height1(BTNode<Character> t) {
        int lchildh, rchildh;
        if (t == null) {
            return 0;
        } else {
            lchildh = height1(t.lchild);
            rchildh = height1(t.rchild);
            return Math.max(lchildh, rchildh) + 1;
        }
    }

    public List<Character> preOrder() {
        List<Character> list = new ArrayList<>();
        if (this.b == null) {
            return list;
        }
        preOrder1(this.b, list);
        return list;
    }

    private void preOrder1(BTNode<Character> root, List<Character> list) {
        if (root != null) {
            list.add(root.data);
            preOrder1(root.lchild, list);
            preOrder1(root.rchild, list);
        }
    }

    public List<Character> inOrder() {
        List<Character> list = new ArrayList<>();
        if (this.b == null) {
            return list;
        }
        inOrder1(this.b, list);
        return list;
    }

    private void inOrder1(BTNode<Character> root, List<Character> list) {
        if (root != null) {
            inOrder1(root.lchild, list);
            list.add(root.data);
            inOrder1(root.rchild, list);
        }
    }

    public List<Character> postOrder() {
        List<Character> list = new ArrayList<>();
        if (this.b == null) {
            return list;
        }
        postOrder1(this.b, list);
        return list;
    }

    private void postOrder1(BTNode<Character> root, List<Character> list) {
        if (root != null) {
            postOrder1(root.lchild, list);
            postOrder1(root.rchild, list);
            list.add(root.data);
        }
    }

    @Override
    public String toString() {
        bstr = "";
        toString1(b);
        return bstr;
    }

    private void toString1(BTNode<Character> t) {
        if (t != null) {
            bstr += t.data;
            if (t.lchild != null || t.rchild != null) {
                bstr += "(";
                toString1(t.lchild);
                if (t.rchild != null) {
                    bstr += ",";
                }
                toString1(t.rchild);
                bstr += ")";
            }
        }
    }


}
