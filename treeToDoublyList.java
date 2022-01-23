/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    //Declare outside of methods to make it publicly accessible for all methods
    Node prev = null;
    Node min = null;
    public Node treeToDoublyList(Node root) {
        /*
        Left = Predecessor
        Right = Successor
        The important thing to notice is that when a BST turns into a doubly linked list, all the nodes are arranged in ascending order of values, which implies the in-order tree traversal
        We need to declare a variable to keep track of the head of the doubly linked list (typically it is the left-most tree node in BST or the minimum value). This is because we need to connect the last element in the linked list with the first element in the linked list together later on. We can accomplish this the end linking outside of helper method
        We will also declare another variable to keep track of the previous node that we traversed so that we can connect the current node with the previous node (This linking will be taken place in helper method. For example: 
            2
            /\
            1 3
            Linked List:
            1 -> 2 -> 3
            if current node is 2, then prev node is 1. Hence, we can say curr.left = prev and prev.right = curr
            Our algorithms would be:
                Write a helper method to traverse in order fasion
                In helper(), we do:
                    1. Recursively call helper() on the left node 
                    2. Check if prev node is null. If not, we do the linking. Otherwise, we assign the curr node to prev and first node
                    3. Recursively call helper() on the right node
            */
        
        if (root == null) {
            return null;
        }
        conversion(root);
        //Do the final linking to create a circular doubly linked list
        prev.right = min;
        min.left = prev;
        return min;
        
    }
    public void conversion(Node node) {
        if (node == null) {
            return;
        }
        conversion(node.left);
        if (prev == null) {
            min = node; // Keep track of min
        } else {
            node.left = prev;
            prev.right = node;
        }
        prev = node; //update the previous node as we go
        conversion(node.right);
    }
}
