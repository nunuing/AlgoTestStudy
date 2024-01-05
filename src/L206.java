

public class L206 {
    public static void main(String[] args) {
        ListNode nodes = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution s = new Solution();
        s.reverseList(nodes);
        s.reverseList(new ListNode());
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
    public static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode previous = null;
            while (head != null){
                ListNode temp = head;
                head = head.next;
                temp.next = previous;
                previous = temp;
            }
            return previous;
        }
    }
//    public static class Solution {
//        public ListNode reverseList(ListNode head) {
//            Stack<Integer> s = new Stack<>();
//            while (head != null){
//                s.push(head.val);
//                head = head.next;
//            }
//
//            ListNode answer = new ListNode();
//            ListNode end = answer;
//            while (!s.empty()){
//                end.next = new ListNode(s.pop());
//                end = end.next;
//            }
//
//            return answer.next;
//        }
//    }
}
