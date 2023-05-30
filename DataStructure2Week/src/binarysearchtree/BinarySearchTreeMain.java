package binarysearchtree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
            BinarySearchTree bST = new BinarySearchTree();
            bST.insertion(50);
            bST.insertion(30);
            bST.insertion(60);
            bST.insertion(20);
            bST.insertion(40);
            bST.insertion(55);
            bST.insertion(75);

            bST.inOrderTraversal();

            System.out.println(bST.isValidBST(bST.root));



    }
}
