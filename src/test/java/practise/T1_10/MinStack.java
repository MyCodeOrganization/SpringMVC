package practise.T1_10;

/**
 * 定义一个栈，使这个栈的pop push min的时间复杂度为1
 * PackageName practise
 * Created by wangkang on 2018/1/18.
 */
public class MinStack {
    class SNode{
        int val;
        int min;//如果在栈中保存最小值，push的时候可以判断，pop的时候无法怕段最小值
        //故而将最小值保存在栈元素中，每个元素保存当前元素之前的最小值，这样每次pop之后
        //只要取栈顶元素就能取得最小值
        SNode next;
    }
    private SNode head = null;

    public void push(int v){
        if (null == head){
            head = new SNode();
            head.val = v;
            head.min = v;
            head.next = null;
        }else {
            SNode newNode = new SNode();
            newNode.val = v;
            int min = v < head.min ? v : head.min;
            newNode.min = min;
            newNode.next = head;
            head = newNode;
        }
    }
    public void pop(){
        if (null == head){
            return;
        }else {
            SNode pnode = head;
            head = pnode.next;
            pnode = null;
        }
    }

    public int min(){
        return head == null ? 0 : head.min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(9);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        stack.push(1);
        System.out.println("min: " + stack.min());
        stack.pop();
        System.out.println("min: " + stack.min());
        stack.pop();
        System.out.println("min: " + stack.min());
        System.exit(0);
    }
}
