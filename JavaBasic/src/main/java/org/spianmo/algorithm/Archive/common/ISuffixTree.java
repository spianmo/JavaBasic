package org.spianmo.algorithm.Archive.common;

import java.util.Set;

/**
 * In computer science, a suffix tree (also called PAT tree or, in an earlier form, position tree) is a compressed trie
 * containing all the suffixes of the given text as their keys and positions in the text as their values. Suffix trees
 * allow particularly fast implementations of many important string operations.
 * <p>
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 * @see <a href="https://en.wikipedia.org/wiki/Suffix_tree">Suffix Tree (Wikipedia)</a>
 * <br>
 */
public interface ISuffixTree<C extends CharSequence> {

    /**
     * Does the sub-sequence exist in the suffix tree.
     *
     * @param sub-sequence to locate in the tree.
     * @return True if the sub-sequence exist in the tree.
     */
    boolean doesSubStringExist(C sub);

    /**
     * Get all the suffixes in the tree.
     *
     * @return set of suffixes in the tree.
     */
    Set<String> getSuffixes();

}
