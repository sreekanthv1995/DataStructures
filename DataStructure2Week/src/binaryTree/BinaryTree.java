package binaryTree;
import java.util.Stack;

public class BinaryTree {
    Node root;
    static class Node{

        Node left;
        Node right;
        int data;

        public Node(int data){
            this.data = data;
        }
    }
    public void createBinaryTree(){
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5 );

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;

    }
    public void preOrderRecursive(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
    public void preOrderIterative(){
        if (root ==null){
            return;
        }
        Stack<Node> stackPreOrder = new Stack<>();
        stackPreOrder.push(root);
        while (!stackPreOrder.isEmpty()){
            Node temp = stackPreOrder.pop();
            System.out.print(" "+temp.data+" ");
            if (temp.right != null){
                stackPreOrder.push(temp.right);
            }
            if (temp.left != null){
                stackPreOrder.push(temp.left);
            }
        }
    }
    public void inOrderRecursive(Node root){
        if (root == null){
            return;
        }
        inOrderRecursive(root.left);
        System.out.print(root.data);
        inOrderRecursive(root.right);

    }
    public void inOrderIterative(){
        if (root == null){
            return;
        }
        Stack<Node> stackInOrder = new Stack<>();
        Node temp = root;
        while (!stackInOrder.isEmpty() || temp != null){
            if (temp != null){
                stackInOrder.push(temp);
                temp = temp.left;
            }else {
                temp = stackInOrder.pop();
                System.out.print(" "+temp.data+" ");
                temp = temp.right;
            }
        }
    }
    public void postOrderRecursive(Node root){
        if (root == null){
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(" "+root.data+" ");
    }
}

