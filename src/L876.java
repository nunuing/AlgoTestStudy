public class L876 {
    public static void main(String[] args) {
        middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static  ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
//    public static ListNode middleNode(ListNode head) {
//        ListNode temp = head;
//        int cnt = 0;
//        while (temp != null) {
//            cnt++;
//            temp = temp.next;
//        }
//
//        int mid = cnt / 2;
//        for (int i = 1; i <= mid; i++)
//            head = head.next;
//
//        return head;
//    }

}
