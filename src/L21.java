public class L21 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode answer = mergeTwoLists(list1, list2);
        System.out.println(answer.val);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode answer = new ListNode();
        ListNode end = answer;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                end.next = list1;
                list1 = list1.next;
            }
            else {
                end.next = list2;
                list2 = list2.next;
            }
            end = end.next;
        }

        end.next= list1 == null ? list2 : list1;

        return answer.next;
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
}
