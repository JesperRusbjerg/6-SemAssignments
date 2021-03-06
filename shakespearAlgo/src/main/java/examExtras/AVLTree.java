package examExtras;

class AVLTree {

    Node root;
    int height = 0;

    // A utility function to get the height of the tree or any sub tree
    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {

        //If node is null means root was null
        // Or we made it to a left or right child that was null
        // When we find a null position we insert the given key into the node
        if (node == null)
            return (new Node(key));

        // we recursively take this action till we find a null node
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        //Then we recursively handle each node, going back up the stack
        //Making sure our tree stays balanced after every insert

        //Everytime we insert, we also make sure to update each nodes height
        // Just incase it has changed
        //This is simply done by updating each node with its max left or right subtree height
        //As this is done bottom up, the recurrsion makes sure it is done throughout the tree
        node.height = 1 + max(height(node.left),
                height(node.right));

        //balance describes wether or not the tree is balanced
        // This value has to be between 1 and -1 for the tree to be balanced
        // If we get a positive balance, it means the tree is balanced towards the LEFT side
        // If we get a positive balance, it means the tree is balanced towards the RIGHT side
        int balance = getBalance(node);

        // If this node becomes unbalanced, then we must figure out which case

        //Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }


        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);


        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }


        return node;
    }

    private class Node {
        int key;
        int height;
        Node left;
        Node right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }


    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node
    void preOrder(Node node) {
        if (node != null) {
            if(node.key == root.key){
                System.out.print(" Root node val: " + node.key + "  Height: " + node.height +"\n ");
            }else{
                System.out.print(" Node val: " + node.key + "  Height: " + node.height +"\n ");
            }
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, 7);
        tree.root = tree.insert(tree.root, 17);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 17);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 13);

       //Visualization: https://www.geeksforgeeks.org/avl-tree-set-1-insertion/

        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
}