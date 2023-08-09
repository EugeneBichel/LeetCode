package com.bichel.interviewbit;

import com.bichel.algorithms.problemsheap.math.AddBinary;
import org.junit.jupiter.api.Test;

public class AddBinaryTest {
    @Test
    public void test1() {
        AddBinary pr = new AddBinary();

        String a = "11";
        String b = "1";

        //String res =Integer.toBinaryString(Integer.parseInt(a, 2) +Integer.parseInt(b, 2));

        String res = pr.addBinary(a, b);
        System.out.println(res);
    }
}
