package com.bichel.algorithms.list;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while(head != null) {
            sb.append(head.val);
            head = head.next;
        }

        String s = sb.toString();
        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }

        return true;
    }
}
