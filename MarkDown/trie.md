# 字典树

Trie，又称前缀树或字典树，是一种有序树，用于保存关联数组，其中的键通常是字符串。与二叉查找树不同，键不是直接保存在节点中，而是由节点在树中的位置决定。一个节点的所有子孙都有相同的前缀，也就是这个节点对应的字符串，而根节点对应空字符串。一般情况下，不是所有的节点都有对应的值，只有叶子节点和部分内部节点所对应的键才有相关的值。

字典树设计的核心思想是空间换时间，所以数据结构本身比较消耗空间。但它利用了字符串的**共同前缀（Common Prefix）**作为存储依据，以此来节省存储空间，并加速搜索时间。Trie 的字符串搜索时间复杂度为 **O(m)**，m 为最长的字符串的长度，其查询性能与集合中的字符串的数量无关。其在搜索字符串时表现出的高效，使得特别适用于构建文本搜索和词频统计等应用。

## Trie 的性质

- 根节点（Root）不包含字符，除根节点外的每一个节点都仅包含一个字符；
- 从根节点到某一节点路径上所经过的字符连接起来，即为该节点对应的字符串；
- 任意节点的所有子节点所包含的字符都不相同；

## Trie 的查找过程

1. 每次从根结点开始搜索；
2. 获取关键词的第一个字符，根据该字符选择对应的子节点，转到该子节点继续检索；
3. 在相应的子节点上，获取关键词的第二个字符，进一步选择对应的子节点进行检索；
4. 以此类推，进行迭代过程；
5. 在某个节点处，关键词的所有字母已被取出，则读取附在该节点上的信息，查找完成。

## Trie 的应用

（1）自动补全

![img](http://dunwu.test.upcdn.net/snap/20200305095300.png)

（2）拼写检查

![img](http://dunwu.test.upcdn.net/snap/20200305101637.png)

（3）IP 路由 (最长前缀匹配)

![img](http://dunwu.test.upcdn.net/snap/20200305102959.gif)

图 3. 使用 Trie 树的最长前缀匹配算法，Internet 协议（IP）路由中利用转发表选择路径。

（4）T9 (九宫格) 打字预测

![img](http://dunwu.test.upcdn.net/snap/20200305103047.jpg)

（5）单词游戏

![img](http://dunwu.test.upcdn.net/snap/20200305103052.png)

图 5. Trie 树可通过剪枝搜索空间来高效解决 Boggle 单词游戏

还有其他的数据结构，如平衡树和哈希表，使我们能够在字符串数据集中搜索单词。为什么我们还需要 Trie 树呢？尽管哈希表可以在 O(1)O(1) 时间内寻找键值，却无法高效的完成以下操作：

- 找到具有同一前缀的全部键值。
- 按词典序枚举字符串的数据集。

Trie 树优于哈希表的另一个理由是，随着哈希表大小增加，会出现大量的冲突，时间复杂度可能增加到 $$O(n)$$，其中 n 是插入的键的数量。与哈希表相比，Trie 树在存储多个具有相同前缀的键时可以使用较少的空间。此时 Trie 树只需要 $$O(m)$$ 的时间复杂度，其中 m 为键长。而在平衡树中查找键值需要 $$O(mlogn)$$ 时间复杂度。

## Trie 树的结点结构

Trie 树是一个有根的树，其结点具有以下字段：。

最多 R 个指向子结点的链接，其中每个链接对应字母表数据集中的一个字母。

- 本文中假定 R 为 26，小写拉丁字母的数量。
- 布尔字段，以指定节点是对应键的结尾还是只是键前缀。

![3463d9e7cb323911aa67cbd94910a34d88c9402a1ab41bbea10852cd0a74f2af-file_1562596867185](http://dunwu.test.upcdn.net/snap/20200305103530.png)

```java
class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
```
向 Trie 树中插入键

我们通过搜索 Trie 树来插入一个键。我们从根开始搜索它对应于第一个键字符的链接。有两种情况：

- 链接存在。沿着链接移动到树的下一个子层。算法继续搜索下一个键字符。
- 链接不存在。创建一个新的节点，并将它与父节点的链接相连，该链接与当前的键字符相匹配。

重复以上步骤，直到到达键的最后一个字符，然后将当前节点标记为结束节点，算法完成。

图 7. 向 Trie 树中插入键

Java
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
}
复杂度分析

时间复杂度：O(m)O(m)，其中 mm 为键长。在算法的每次迭代中，我们要么检查要么创建一个节点，直到到达键尾。只需要 mm 次操作。

空间复杂度：O(m)O(m)。最坏的情况下，新插入的键和 Trie 树中已有的键没有公共前缀。此时需要添加 mm 个结点，使用 O(m)O(m) 空间。

在 Trie 树中查找键
每个键在 trie 中表示为从根到内部节点或叶的路径。我们用第一个键字符从根开始，。检查当前节点中与键字符对应的链接。有两种情况：

存在链接。我们移动到该链接后面路径中的下一个节点，并继续搜索下一个键字符。
不存在链接。若已无键字符，且当前结点标记为 isEnd，则返回 true。否则有两种可能，均返回 false :
还有键字符剩余，但无法跟随 Trie 树的键路径，找不到键。
没有键字符剩余，但当前结点没有标记为 isEnd。也就是说，待查找键只是Trie树中另一个键的前缀。


图 8. 在 Trie 树中查找键

Java
class Trie {
    ...

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        return node;
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }
}
复杂度分析

时间复杂度 : O(m)O(m)。算法的每一步均搜索下一个键字符。最坏的情况下需要 mm 次操作。
空间复杂度 : O(1)O(1)。
查找 Trie 树中的键前缀
该方法与在 Trie 树中搜索键时使用的方法非常相似。我们从根遍历 Trie 树，直到键前缀中没有字符，或者无法用当前的键字符继续 Trie 中的路径。与上面提到的“搜索键”算法唯一的区别是，到达键前缀的末尾时，总是返回 true。我们不需要考虑当前 Trie 节点是否用 “isend” 标记，因为我们搜索的是键的前缀，而不是整个键。



图 9. 查找 Trie 树中的键前缀

Java
class Trie {
    ...

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
复杂度分析

时间复杂度 : O(m)O(m)。
空间复杂度 : O(1)O(1)。

## 实战

## 参考资料

- https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/D:\Codes\ZPTutorial\ZPSpring\spring-boot-tutorial\codes\spring-boot-dubbo\README.md
