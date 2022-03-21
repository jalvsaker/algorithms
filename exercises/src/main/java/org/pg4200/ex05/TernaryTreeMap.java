package org.pg4200.ex05;

import org.pg4200.les05.MyMapTreeBased;

import java.util.Objects;

public class TernaryTreeMap<K extends Comparable<K>, V> implements MyMapTreeBased<K, V> {
    protected class TreeNode{
        public K firstKey;
        public V firstValue;

        public K secondKey;
        public V secondValue;

        public TreeNode left;
        public TreeNode middle;
        public TreeNode right;
    }


    protected TreeNode root;
    protected int size;
    /**
     * Create a mapping from the given Key to the given Value.
     * If a mapping for Key already exists, replace the old
     * value with this new one
     *
     * @param key
     * @param value
     * @throws NullPointerException if the {@code key} is null
     */
    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(key);
        root = put(key, value, root);
    }

    private TreeNode put(K key, V value, TreeNode subtree){
        if (subtree == null) {
            TreeNode node = new TreeNode();
            node.firstKey = key;
            node.firstValue = value;
            size++;
            return node;
        }

        if (key == subtree.firstKey){
            subtree.firstValue = value;
            return subtree;
        } else if (key == subtree.secondKey){
            subtree.secondValue = value;
            return subtree;
        }

        int cmpFirst = key.compareTo(subtree.firstKey);


        if (cmpFirst < 0) {
            subtree.left = put(key, value, subtree.left);
            return subtree;
        }
        else if(cmpFirst > 0 && subtree.secondKey == null){
            subtree.secondKey = key;
            subtree.secondValue = value;
            size++;
            return subtree;
        }

        int cmpSecond = key.compareTo(subtree.secondKey);

        if (cmpSecond > 0) {
            subtree.right = put(key, value, subtree.right);
        }
        else if (cmpFirst > 0 && cmpSecond < 0){
            subtree.middle = put(key, value, subtree.middle);
        }

        else if (cmpFirst == 0){
            subtree.firstValue = value;
        }
        else if (cmpSecond == 0){
            subtree.secondValue = value;
        }

        return subtree;
    }

    /**
     * Remove the given key from the container.
     *
     * @param key
     * @throws NullPointerException if the {@code key} is null
     */
    @Override
    public void delete(K key) {
        Objects.requireNonNull(key);
        root = delete(key, root);
    }


    protected TreeNode delete(K key, TreeNode subtreeRoot){
        if (subtreeRoot == null){
            return null;
        }

        int cmpFirst = key.compareTo(subtreeRoot.firstKey);

        if (cmpFirst < 0) {
            subtreeRoot.left = delete(key, subtreeRoot.left);
            return subtreeRoot;
        }

        if (cmpFirst == 0){

            size--;

            if (subtreeRoot.secondKey == null){

                if (subtreeRoot.left == null && subtreeRoot.middle == null){
                    return null;
                }

                if (subtreeRoot.left == null){
                    return subtreeRoot.middle;
                }
                else if (subtreeRoot.middle == null){
                    return subtreeRoot.left;
                }
                else {
                    TreeNode min = min(subtreeRoot.middle);
                    subtreeRoot.firstKey = min.firstKey;
                    subtreeRoot.firstValue = min.firstValue;
                    subtreeRoot.middle = deleteMin(subtreeRoot.middle);
                    return subtreeRoot;
                }

            } else {

                if (subtreeRoot.middle == null){
                    moveSecondToFirst(subtreeRoot);
                    subtreeRoot.middle = subtreeRoot.right;
                    subtreeRoot.right = null;
                    return subtreeRoot;
                } else if (subtreeRoot.left == null){
                    moveSecondToFirst(subtreeRoot);
                    subtreeRoot.left = subtreeRoot.middle;
                    subtreeRoot.middle = subtreeRoot.right;
                    subtreeRoot.right = null;
                    return subtreeRoot;
                } else {
                    TreeNode min = min(subtreeRoot.middle);
                    subtreeRoot.firstKey = min.firstKey;
                    subtreeRoot.firstValue = min.firstValue;
                    subtreeRoot.middle = deleteMin(subtreeRoot.middle);
                    return subtreeRoot;
                }
            }
        }

        if (cmpFirst > 0){

            if (subtreeRoot.secondKey == null){
                subtreeRoot.middle = delete(key, subtreeRoot.middle);
                return subtreeRoot;
            }

            int cmpSecond = key.compareTo(subtreeRoot.secondKey);

            if (cmpSecond < 0){
                subtreeRoot.middle = delete(key, subtreeRoot.middle);
                return subtreeRoot;
            }

            if (cmpSecond > 0){
                subtreeRoot.right = delete(key, subtreeRoot.right);
                return subtreeRoot;
            }

            size--;
            if (subtreeRoot.right == null){
                subtreeRoot.secondKey = null;
                subtreeRoot.secondValue = null;
                return subtreeRoot;
            } else {
                TreeNode min = min(subtreeRoot.right);
                subtreeRoot.secondKey = min.firstKey;
                subtreeRoot.secondValue = min.firstValue;
                subtreeRoot.right = deleteMin(subtreeRoot.right);
                return subtreeRoot;
            }
        }

        return subtreeRoot;
    }


    private TreeNode min(TreeNode subtreeRoot) {

        if (subtreeRoot.left == null) {
            return subtreeRoot;
        }
        return min(subtreeRoot.left);
    }

    private TreeNode deleteMin(TreeNode subtreeRoot) {

        if (subtreeRoot.left == null) {
            if (subtreeRoot.secondKey == null){
                return subtreeRoot.middle;
            } else {
                moveSecondToFirst(subtreeRoot);
                subtreeRoot.left = subtreeRoot.middle;
                subtreeRoot.middle = subtreeRoot.right;
                subtreeRoot.right = null;
                return subtreeRoot;
            }
        }

        subtreeRoot.left = deleteMin(subtreeRoot.left);

        return subtreeRoot;
    }

    private void moveSecondToFirst(TreeNode subtreeRoot){
        subtreeRoot.firstValue = subtreeRoot.secondValue;
        subtreeRoot.firstKey = subtreeRoot.secondKey;

        subtreeRoot.secondKey = null;
        subtreeRoot.secondValue = null;
    }

    /**
     * Return the value in the container mapped by the given key
     *
     * @param key
     * @throws NullPointerException if the {@code key} is null
     */
    @Override
    public V get(K key) {
        Objects.requireNonNull(key);
        return get(key, root);
    }

    public V get(K key, TreeNode subtreeRoot){
        if (subtreeRoot == null){
            return null;
        }

        if (key == subtreeRoot.firstKey){
            return subtreeRoot.firstValue;
        }
        if (key == subtreeRoot.secondKey){
            return subtreeRoot.secondValue;
        }

        int cmpFirst = key.compareTo(subtreeRoot.firstKey);


        if (cmpFirst < 0){
            return get(key, subtreeRoot.left);
        }

        if (subtreeRoot.secondKey == null){
            return get(key, subtreeRoot.middle);
        }

        int cmpSecond = key.compareTo(subtreeRoot.secondKey);

        if (cmpSecond > 0) {
            return get(key, subtreeRoot.right);
        }
        if (cmpFirst > 0 && cmpSecond < 0){
            return get(key, subtreeRoot.middle);
        }
        return null;
    }

    /**
     * The number of elements in the container
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Check if there is no element in the container
     */
    @Override
    public boolean isEmpty() {
        return MyMapTreeBased.super.isEmpty();
    }

    @Override
    public int getMaxTreeDepth() {
        if (root == null) {
            return 0;
        }
        return depth(root);
    }

    protected int depth(TreeNode node){
        int leftDepth = 0;
        int middleDepth = 0;
        int rightDepth = 0;

        if (node.left != null){
            leftDepth = depth(node.left);
        }
        if (node.middle != null){
            middleDepth = depth(node.middle);
        }
        if (node.right != null){
            rightDepth = depth(node.right);
        }

        return 1 + Math.max(leftDepth, Math.max(middleDepth, rightDepth));
    }
}
