public class L19 {
    public static void main(String[] args) {
        removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        removeNthFromEnd(new ListNode(1), 1);
        removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode answer = new ListNode(0);

        ListNode first = answer;
        ListNode second = answer;

        answer.next = head;

        for(int i = 0; i < n; i++)
            second = second.next;

        while (second.next != null){
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
        return answer.next;
    }
}
