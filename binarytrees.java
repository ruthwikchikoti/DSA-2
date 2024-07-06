import java.util.*;
public class binarytrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; } 
        }
    // given  an arrray which was sorted intially but two elements were swapped return the 2 values that were swapped
    public  static  int[] swapped(int[] a){
        int[] res = new int[2];
        int first = -1;
        int second = -1;
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i + 1]){
                if(first == -1){
                    first = i;
                }else{
                    second = i + 1;
                }
            }
        }
        res[0] = a[first];
        res[1] = a[second];
        return res;
    }
    // given a BST where two nodes have been swapped,fix it to original BST
    public static void recoverTree(TreeNode root){
        TreeNode[] nodes = new TreeNode[3];
        inorder(root,nodes);
        int temp = nodes[1].val;
        nodes[1].val = nodes[2].val;
        nodes[2].val = temp;
    }
    public static void inorder(TreeNode root,TreeNode[] nodes){
        if(root == null){
            return;
        }
        inorder(root.left,nodes);
        if(nodes[0] != null && nodes[0].val > root.val){
            if(nodes[1] == null){
                nodes[1] = nodes[0];
            }
            nodes[2] = root;
        }
        nodes[0] = root;
        inorder(root.right,nodes);
    }

    
   
    









    // inorder traversal of a BST via iterative method

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

    // preorder traversal of a BST via itreative method
    public static void preorder(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode  cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    // implement inorder with morris traversal
    public static void morrisInorder(TreeNode root){
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                System.out.println(cur.val);
                cur = cur.right;
            }else{
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }else{
                    pre.right = null;
                    System.out.println(cur.val);
                    cur = cur.right;
                }
            }
        }
    }
    //postorder traversal of a BST via iterative method
    
    
 

    public static void main(String[] args) {
        int[] testArray = {1,2,3,4,5,6,7,8,9,10,11,21,13,14,15,16,17,18,19,20,12};
        int[] result = swapped(testArray);
        System.out.println("Swapped elements are: " + result[0] + " and " + result[1]);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        preorder(root);
        
    }
}   