import java.util.*;
class Main {
    static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BT{
        static int idx = -1;
        public static Node createNode(int nodes[]) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = createNode(nodes);
            newNode.right = createNode(nodes);

            return newNode;
        }
        
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.println(root.data+" ");
            inorder(root.right);
        }
        public static int height(Node root){
            if(root==null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh) + 1;
        }
        public static int count(Node root){
            if(root==null){
                return 0;
            }
            int leftCount = count(root.left);
            int rightCount = count(root.right);
            return leftCount + rightCount + 1;
        }
        public static int sum(Node root){
            if(root==null){
                return 0;
            }
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            return leftSum + rightSum + root.data;
        }
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int leftDiam = diameter(root.left);
            int leftHeight = height(root.left);
            int rightDiam = diameter(root.right);
            int rightHeight = height(root.right);

            int selfDiam = leftHeight + rightHeight + 1;
            return Math.max(selfDiam, Math.max(leftDiam,rightDiam));
        }
        public static void DFS(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,3,4,5,6,7,8,9,10};
        BT tree = new BT();
        Node root = tree.createNode(nodes);
        System.out.println(height(root));
        System.out.println(count(root));
        System.out.println(sum(root));
        System.out.println(diameter(root));
        tree.DFS(root);
    }
}
