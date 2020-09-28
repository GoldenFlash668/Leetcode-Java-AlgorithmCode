class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        if(root.left != null && root.right != null){
            root.left.next = root.right;
        }else if(root.left != null && root.right == null){
            Node head = root.next;
            while(head != null){
                if(head.left != null){
                    root.left.next = head.left;
                    break;
                }else if(head.right != null){
                    root.left.next = head.right;
                    break;
                }
                head = head.next;
            }
        }
        if(root.right != null){
            Node head = root.next;
            while(head != null){
                if(head.left != null){
                    root.right.next = head.left;
                    break;
                }else if(head.right != null){
                    root.right.next = head.right;
                    break;
                }
                head = head.next;
            }
        }
        connect(root.right);
        connect(root.left);      
        return root;
    }
}