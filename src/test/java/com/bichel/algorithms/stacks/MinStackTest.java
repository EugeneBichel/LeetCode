package com.bichel.algorithms.stacks;

import com.bichel.algorithms.problemsheap.stacks.MinStack;
import org.junit.jupiter.api.Test;

public class MinStackTest {

    @Test
    public void testTestCase1() {
        MinStack st = new MinStack();
        st.push(2147483646);
        st.push(2147483646);
        st.push(2147483647);
        st.top(); //2147483647
        st.pop();
        st.getMin(); //2147483646
        st.pop();
        st.getMin(); //2147483646
        st.pop();
        st.push(2147483647);
        st.top();
        st.getMin();
        st.pop();
        st.getMin();
    }
}
