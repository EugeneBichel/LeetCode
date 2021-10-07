package com.bichel.leetcode.stacks;

import org.junit.jupiter.api.Test;

class MaxStackTest {
    @Test
    void testTestCase1() {
        MaxStack st = new MaxStack();
        st.push(2147483646);
        st.push(2147483646);
        st.push(2147483647);
        st.top(); //2147483647
        st.pop();
        st.peekMax(); //2147483646
        st.pop();
        st.peekMax(); //2147483646
        st.pop();
        st.push(2147483647);
        st.top();
        st.peekMax();
        st.pop();
        st.peekMax();
    }

    @Test
    void testTestCase2() {
        MaxStack st = new MaxStack();
        st.push(5);
        st.push(1);
        System.out.println(st.popMax());
        System.out.println(st.peekMax());
    }
}
