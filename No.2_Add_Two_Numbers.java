/**
 * My first intuition is to convert the list to a int number1, and another list to int number2, then add them 
 * together to get the int sum, and converts the sum to the result list.
 * pros: EASY to implement
 * cons: do not consider cases when sum is much bigger than int.
 * FAILING case: [9,9,9,9,9,9,9,9,1] [9]
 * expected result: [0,0,0,0,0,0,0,0,0,1]
 * my result: meaningless numbers.
 */
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution-1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int base1 = 1;
        int base2 = 1;
        int number1 = 0;
        int number2 = 0;
        while (l1 != null) {
            number1 += base1 * l1.val;
            l1 = l1.next;
            base1 *= 10;
        }
        while (l2 != null) {
            number2 += base2 * l2.val;
            l2 = l2.next;
            base2 *= 10;
        }
        //System.out.println(number1);
        //System.out.println(number2);
        int sum = number1 + number2;
        //System.out.println(sum);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        boolean first = true;
        while (sum != 0 || first) {
        int temp = sum % 10;
        ListNode newNode = new ListNode(temp);
        cur.next = newNode;
        cur = cur.next;
        sum = (sum - temp) /10;
        first = false;
        }
        return dummy.next;
        
    }
}

/**
 * To avoid the overflow problem, the second thought is to use the linked list data structure, add the corresponding digits and 
 * also the carry number. Four cases are considered:
 * 1. while l1 and l2 are not empty
 * 2. while l1 is not empty
 * 3. while l2 is not empty
 * 4. while l1 and l2 are empty, but the carry is not 0
 */
 
 class Solution-2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int digit = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode newNode = new ListNode(digit);
            cur.next = newNode;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null) {
            int digit = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode newNode = new ListNode(digit);
            cur.next = newNode;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            int digit = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            ListNode newNode = new ListNode(digit);
            cur.next = newNode;
            l2 = l2.next;
            cur = cur.next;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
            cur = cur.next;
        }
        return dummy.next;
    }
}

/**
 * Although the solution is accepted, the timing is not optimal. The first three cases can be merged into one, the optimal 
 * solution is then created. The codes respond faster than the last one.
 */
 
 class Solution-3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int digit = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            ListNode newNode = new ListNode(digit);
            cur.next = newNode;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            cur = cur.next;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
            cur = cur.next;
        }
        return dummy.next;
    
