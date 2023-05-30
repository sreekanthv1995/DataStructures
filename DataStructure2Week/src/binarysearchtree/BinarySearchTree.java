package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    static class Node {
         Node left;
         Node right;
         int data;
        public Node(int data) {
            this.data = data;
        }
    }
    Node root;
    public BinarySearchTree(){
         root = null;
    }

    public boolean insertion(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return true;
        }
        Node currentNode = root;
        while (true) {
            if (newNode.data == currentNode.data)return false;
            if (newNode.data < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return true;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return true;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public Node insertionRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertionRecursive(root.left, data);
        }else {
            root.right = insertionRecursive(root.right,data);
        }
        return root;
    }

    public void insertionIntoTree(int data){
        insertionRecursive(root,data);
    }

    public boolean contains(int data){
        Node current = root;

        while (current != null){
            if (data < current.data){
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            }else {
                return true;
            }
        }
        return false;
    }

    public boolean containsRecursive(Node current,int data){
       if (current == null) return false;
       if (current.data == data) return true;

       if (data < current.data){
          return containsRecursive(current.left, data);
        }else {
           return containsRecursive(current.right,data);
        }
    }
    public boolean contain(int data){
        return containsRecursive(root,data);
    }

    private Node delete(Node currentNode, int data){
        if (currentNode == null) return null;

        if (data < currentNode.data){
            currentNode.left = delete(currentNode.left, data);
        } else if (data > currentNode.data) {
            currentNode.right = delete(currentNode.right, data);
        } else {
            if (currentNode.left == null && currentNode.right == null){
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            }else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.data = subTreeMin;
                currentNode.right = delete(currentNode.right,subTreeMin);
            }
        }
        return currentNode;
    }

    public void delete(int data){
        delete(root,data);
    }
    public int minValue(Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.data;
    }

    public void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public int getMaximum(Node root){
        if(root.right != null){
            return getMaximum(root.right);
        }
        return root.data;
    }

    public void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.data +" ");

            if (currentNode.left != null)
                queue.offer(currentNode.left);

            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }
    }

    public int closestValue(Node root, int target) {
        int closest = root.data;
        while (root != null) {
            if (Math.abs(root.data - target) < Math.abs(closest - target)) {
                closest = root.data;
            }
            root = target < root.data ? root.left : root.right;
        }
        return closest;
    }
    public int closestVal(int target){
        return closestValue(root,target);
    }
    public void inOrderTraversal(){
        inOrder(root);
    }
    public void preOrderTraversal(){
        preOrder(root);
    }
    public void postOrderTraversal(){
        postOrder(root);
    }

    public boolean isValidBSTHelper(Node root, Integer min,Integer max){

        if (root == null) return true;

        if (root.data <= min || root.data >= max){
            return false;
        }
        return isValidBSTHelper(root.left, min, root.data) && isValidBSTHelper(root.right, root.data, max);
    }
    public boolean isValidBST(Node root){
       return isValidBSTHelper(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
