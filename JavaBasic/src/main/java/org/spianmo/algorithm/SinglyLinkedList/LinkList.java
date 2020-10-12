package org.spianmo.algorithm.SinglyLinkedList;


/**
 * @author Finger
 * @file LinkList.java
 * @CopyRight (C) https://spianmo.com
 * @brief
 * @email Finger@spianmo.com
 * @date 2020/10/01
 */
public class LinkList<E> {
    LinkNode<E> head;
    private int size;

    /**
     * 默认构造函数
     */
    public LinkList() {
        head = new LinkNode<E>();
        head.next = null;
        size = 0;
    }

    /**
     * E[]构造函数初始化单向链表
     * @param array E[]泛型数组
     */
    public LinkList(E[] array) {
        head = new LinkNode<E>();
        head.next = null;
        addArray(array,null);
    }

    /**
     * 返回当前单向链表长度
     * @return int 链表长度
     */
    public int size() {
        return this.size;
    }

    /**
     * 头插法插入Node
     * @param value 泛型data
     */
    public void add(E value) {
        LinkNode<E> newNode = new LinkNode<>(value, null);
        newNode.next = this.head.next;
        this.head.next = newNode;
        size++;
    }

    /**
     * 尾插法插入Node
     * @param value 泛型data
     */
    public void addTail(E value) {
        LinkNode<E> newNode = new LinkNode<>(value, null);
        LinkNode<E> node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        size++;
    }

    /**
     * addNodeListener接口，回调addArray插入的泛型数据，可以进行各种处理(比较大小等等等)
     * @param <E>
     */
    public interface addNodeListener<E> {
        void onNodeAdded(E node);
    };

    /**
     * addArray(E[] array) 批量向单向链表添加数据
     * @param array E[]
     */
    public void addArray(E[] array) {
        for (E e : array) {
            add(e);
        }
    }

    /**
     * addArray(E[] array,addNodeListener<E> addNodeListener)，带回调的批量添加Node
     * @param array 待插入链表的泛型数组
     * @param addNodeListener 插入数据后的回调接口
     */
    public void addArray(E[] array,addNodeListener<E> addNodeListener) {
        for (E e : array) {
            add(e);
            if (addNodeListener != null){
                addNodeListener.onNodeAdded(e);
            }
        }
    }

    /**
     * addArraySafe(E[] array,addNodeListener<E> addNodeListener,Class<?> clazz) 带类型检查的addArray
     * @param array 待插入链表的泛型数组
     * @param addNodeListener 插入数据后的回调接口
     * @param clazz 待检查类型
     */
    public void addArraySafe(E[] array,addNodeListener<E> addNodeListener,Class<?> clazz) {
        for (E e : array) {
            add(e);
            if (addNodeListener != null){
                if (clazz.isInstance(e)){
                    addNodeListener.onNodeAdded(e);
                }
            }
        }
    }

    /**
     * find，根据data寻找首次出现的Node
     * @param value 待寻找的泛型数据
     * @return 第一次eq匹配到的Node
     */
    public LinkNode<E> findFirst(E value) {
        LinkNode<E> node = this.head.next;
        while (node != null) {
            if (node.data.equals(value)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 递归取Node
     * @param index 索引号
     * @return LinkNode
     */
    public LinkNode<E> get(int index) {
        if (index > size - 1) {
            throw new IllegalArgumentException("超过链表长度");
        }
        return getNodeByIndex(head.next, 0, index);
    }

    private LinkNode<E> getNodeByIndex(LinkNode<E> node, int point, int index) {
        if (point == index) {
            return node;
        }
        return getNodeByIndex(node.next, ++point, index);
    }

    /**
     * removeCommon 根据泛型value移除Node，While实现
     * @param value 待匹配的value
     */
    public void removeCommon(E value) {
        LinkNode<E> prev = this.head;
        while (prev.next != null) {
            LinkNode<E> curr = prev.next;
            if (curr.data.equals(value)) {
                prev.next = curr.next;
                break;
            }
            prev = prev.next;
        }
    }

    /**
     * remove 根据Node索引号递归移除Node
     * @param index 索引号
     */
    public void remove(int index) {
        if (index > size - 1) {
            throw new IllegalArgumentException("超过链表长度");
        }
        removeNodeByIndex(this.head, 0, index);
    }

    private void removeNodeByIndex(LinkNode<E> node, int point, int index) {
        if (index == 0) {
            this.head = this.head.next;
            this.size--;
            return;
        }
        if (point == index - 1) {
            node.next = node.next.next;
            this.size--;
            return;
        }
        removeNodeByIndex(node.next, ++point, index);
    }

    /**
     * removeAllNodeByData 移除所有匹配的节点
     * @param data 待匹配数据
     */
    public void removeAllNodeByData(E data) {
        removeNodeByData(this.head, data);
    }

    private LinkNode<E> removeNodeByData(LinkNode<E> head, E data) {
        if (head == null){
            return null;
        }
        LinkNode<E> node = removeNodeByData(head.next,data);
        if (data.equals(head.data)){
            this.size--;
            return node;
        }else{
            head.next = node;
            return head;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        LinkNode<E> p = head;
        while (p.next != null) {
            sb.append(" ");
            sb.append(p.next.data.toString());
            sb.append(" ");
            p = p.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
