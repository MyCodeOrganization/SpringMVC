package practise.T1_10;

/**
 * 问题：二元查找树转化为双向链表
 * PackageName practise
 * Created by wangkang on 2018/1/17.
 */
public class BTree {
    private TNode head = null;
    private TNode _head = null;
    private TNode _tail = null;
    class TNode{
        int value;
        TNode left;
        TNode right;
        TNode(){
            this.value = -1;
            this.left = null;
            this.right = null;
        }
        TNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    private void putNode(int val) {
        if (head == null){
            head = new TNode(val);
        }else{
            put(head,val);
        }
    }
    private void put(TNode root,int val){
        if (root == null){
            root = new TNode(val);
        }else{
            if (root.value > val){
                if (root.left != null){
                    put(root.left,val);
                }else {
                    root.left = new TNode(val);
                }
            }else {
                if (root.right != null){
                    put(root.right,val);
                }else {
                    root.right = new TNode(val);
                }
            }
        }
    }

    private void get(){
        get(head);
    }
    private void get(TNode root){
        if (root == null)
            return;
        get(root.left);
        System.out.println(root.value);
        get(root.right);
    }
    private TNode change(){
        return change(head);
    }

    /**
     * java实现二元查找树转换为双向链表  核心思想：递归，对每颗子树进行拉伸转变为双向链表
     * java实现与c实现的不同在于，java无法引用指针，需要额外开辟一个临时节点来保存拉伸后的
     * head指针和tail指针
     * @param root
     * @return
     */
    private TNode change(TNode root){
        TNode _left = null;
        TNode _right = null;
        TNode result = new TNode();//临时节点保存每颗子树的head和tail
        if (root == null){
            return null;
        }
        _left = change(root.left);
        _right = change(root.right);
        if (_left != null){
            _left.right.right = root;
            root.left = _left.right;
            result.left = _left.left;
        }else {
            result.left = root;
        }
        if (_right != null){
            root.right = _right.left;
            _right.left.left = root;
            result.right = _right.right;
        }else {
            result.right = root;
        }
        return result;
    }

    private void change(TNode head,TNode tail ,TNode root){
        TNode _left=null,_right=null;
        if (root == null){
            head = null;
            tail=null;
            return;
        }
        change(head,_left,root.left);
        change(_right,tail,root.right);
        if (_left != null){
            _left.right = root;
            root.left = _left;
        }else {
            head = root;
        }
        if (_right != null){
            _right.left = root;
            root.right = _right;
        }else {
            tail = root;
        }
    }

    public static void main(String[] args) {
        BTree tree = new BTree();
        tree.putNode(10);
        tree.putNode(6);
        tree.putNode(14);
        tree.putNode(4);
        //tree.putNode(8);
        tree.putNode(12);
        //tree.putNode(16);
        tree.get();
        TNode node = tree.change();
        if (node.left!= null){
            TNode head = node.left;
            TNode next = head;
            while (next != null){
                System.out.print(next.value + " ");
                next = next.right;
            }
            System.out.println();
        }
        if (node.right != null){
            TNode tail = node.right;
            TNode next = tail;
            while (next != null){
                System.out.print(next.value + " ");
                next = next.left;
            }
            System.out.println();
        }
        System.exit(0);
    }
}
