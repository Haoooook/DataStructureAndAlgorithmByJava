package DataStructure.chapter4.leetCode203;

/**
 * @author Damon
 * @create 2020-10-19 20:56
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] num){
        if(num==null||num.length==0)
            throw new IllegalArgumentException("num can not be empty!");

        this.val =num[0];
        ListNode cur=this;
        for(int i=0;i< num.length;i++){
            cur.next=new ListNode(num[i]);
            cur=cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur =this;
        while(cur!=null){
            res.append(cur.val+"--->");
            cur=cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
