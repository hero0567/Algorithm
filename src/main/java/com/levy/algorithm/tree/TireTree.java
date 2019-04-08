package com.levy.algorithm.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TireTree {

    private Node rootNode = new Node();

    class Node {
        int count;
        Map<Character, Node> childMap = new HashMap<>();
    }

    public void insert(String word) {
        insert(word, 0, rootNode);
    }

    private void insert(String word, int index, Node node) {
        if ((index < 0) || (index >= word.length())) {
            node.count++;
            return;
        }
        char c = word.charAt(index);
        Node next = node.childMap.get(c);
        if (next == null) {
            next = new Node();
            node.childMap.put(c, next);
        }
        insert(word, ++index, next);
    }

    public boolean search(String word) {
        return search(word, 0, rootNode);
    }

    private boolean search(String word, int index, Node node) {
        if (index == word.length()) {
            if (node.count > 0) {
                return true;
            }
            return false;
        }
        char c = word.charAt(index);
        Node next = node.childMap.get(c);
        if (next == null) {
            return false;
        }
        return search(word, ++index, next);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0, rootNode);
    }

    public boolean startsWith(String prefix, int index, Node node) {
        if (index == prefix.length()) {
            return true;
        }
        char c = prefix.charAt(index);
        Node next = node.childMap.get(c);
        if (next == null) {
            return false;
        }
        return startsWith(prefix, ++index, next);
    }


    @Test
    public void testTireTree() {
        TireTree tireTree = new TireTree();

        tireTree.insert("apple");
        tireTree.insert("app");
        tireTree.insert("hello");
        tireTree.insert("hell");
        tireTree.insert("heee");
        tireTree.insert("abc");
        tireTree.insert("abc");

        Assert.assertTrue(tireTree.startsWith("hello"));
        Assert.assertTrue(tireTree.startsWith("hell"));
        Assert.assertTrue(tireTree.startsWith("heee"));
        Assert.assertTrue(tireTree.startsWith("abc"));
        Assert.assertFalse(tireTree.startsWith("abcd"));
        Assert.assertFalse(tireTree.startsWith("hllo"));
        Assert.assertTrue(tireTree.startsWith("hel"));
        Assert.assertTrue(tireTree.startsWith("h"));

        Assert.assertTrue(tireTree.search("hello"));
        Assert.assertTrue(tireTree.search("heee"));
        Assert.assertTrue(tireTree.search("abc"));
        Assert.assertFalse(tireTree.search("abcd"));
        Assert.assertFalse(tireTree.search("hllo"));
        Assert.assertFalse(tireTree.search("hel"));
        Assert.assertFalse(tireTree.search("h"));
        Assert.assertTrue(tireTree.search("app"));

    }
}
