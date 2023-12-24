package com.practice.ood.LowLevelDesign.hashset;

import java.util.LinkedList;

class TreeNode{
    public int val;
    public TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
    }
}

class BSTree{
    TreeNode root = null;
    public TreeNode insertIntoBST(TreeNode root, Integer val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val > root.val){
            root.right =  insertIntoBST(root.right,val);
        }else if(val == root.val){
            // skip the insertion
            return root;
        }else{
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
    public int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
    public int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
    public TreeNode deleteNodeBST(TreeNode root, Integer val){
        if(root == null)return null;
        if(val > root.val){
            root.right = deleteNodeBST(root.right,val);
        }else if(val < root.val){
            root.left = deleteNodeBST(root.left,val);
        }else{
            // found the node to be deleted
            if(root.left == null && root.right == null){
                root = null;
                // the node is not a leaf and has a right child
            }else if(root.right != null){
                root.val = successor(root);
                root.right = deleteNodeBST(root.right,root.val);
            }else{
                root.val = predecessor(root);
                root.left = deleteNodeBST(root.left,root.val);
            }
        }
        return root;
    }

    public TreeNode searchBST(TreeNode root, Integer val){
        if(root == null || val == root.val){
            return root;
        }
        return val < root.val ? searchBST(root.left,val):searchBST(root.right,val);
    }
}

interface Bucket<T>{
    public void insert(T key);
    public void delete(T key);
    public boolean exists(T key);
}

class BucketList<T> implements Bucket<T>{
    private LinkedList<T> container;
    public BucketList(){
        this.container = new LinkedList<T>();
    }
    @Override
    public void insert(T key){
        int index = this.container.indexOf(key);
        if(index == -1){
            this.container.addFirst(key);
        }
    }
    @Override
    public void delete(T key){
        this.container.remove(key);
    }
    @Override
    public boolean exists(T key){
        int index = this.container.indexOf(key);
        return (index != -1);
    }
}

class BucketBST<T> implements Bucket<T>{
    private BSTree tree;
    public BucketBST(){
        this.tree = new BSTree();
    }
    @Override
    public void insert(T key){
        this.tree.root = this.tree.insertIntoBST(this.tree.root,(Integer)key);
    }
    @Override
    public void delete(T key){
        this.tree.root = this.tree.deleteNodeBST(this.tree.root,(Integer)key);
    }
    @Override
    public boolean exists(T key){
        TreeNode node = this.tree.searchBST(this.tree.root,(Integer)key);
        return (node != null);
    }

}
public class MyHashSet {
    /*
     In case of hashset or hashmap design we need to address following 2 things.
        1. hash function
        2. collision handling
        To handle collion handling, we have following 3 ways.
        Seperate chaining - for values with the same hash key, we keep them in a bucket, and each bucket is independent of each other.
        open addressing - whenever there is a collision, we keep on probing on the main space with certain strategy
        until a free slot is found.
        2-choice hashing - using 2 hash functions for generating the hash functions and will use the one having fewer collisions.
    */
    private Bucket[]bucketArray;
    private int keyRange;

    protected int _hash(int key){
        return (key % this.keyRange);
    }
    public MyHashSet() {
        this.keyRange = 769;
        this.bucketArray = new Bucket[this.keyRange];
        for(int i = 0; i < this.keyRange;++i){
            this.bucketArray[i] = new BucketBST<Integer>();
        }
    }
    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucketArray[bucketIndex].delete(key);
    }

    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucketArray[bucketIndex].exists(key);
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(12);
        myHashSet.add(34);
        System.out.println(myHashSet.contains(12));
        System.out.println(myHashSet.contains(454));
        myHashSet.remove(12);
        System.out.println(myHashSet.contains(12));

    }
}

