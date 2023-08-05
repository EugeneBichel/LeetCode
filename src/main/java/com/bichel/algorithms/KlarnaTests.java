package com.bichel.algorithms;

import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class KlarnaTests {

    public final int MinSize = 7;

    public static void main(String[] args) {


        Map<Integer, Integer> map = new HashMap<>();

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            entry.getValue().intValue();
        }

        map.keySet().size();

        int[] c = {0, 0, 1, 0, 0,1, 0};

        Arrays.sort(c);

        //List<Integer> bribes = new ();
        //bribes.stream().anyMatch(item -> item > 2);

        int jumpsCounter = 0;

        for(int i = 0; i < c.length-1;) {

            if((i + 2) < c.length && c[i + 2] == 0) {
                i+=2;
            } else if((i + 1) < c.length && c[i + 1] == 0) {
                i+=1;
            }

            jumpsCounter++;
        }


        ArrayList<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("2");
        arr.add("3");

        System.out.println(arr.toString());

        //double res = evaluate("1 3 -");

        Stack<Integer> stack = new Stack<>();

        //String[] arr= new String[2];

       // System.out.println(res);
        System.out.println(11 % 100);
        System.out.println(1011 % 100);


        System.out.println(12 + "nd");
    }

    public static double evaluate(String expr) {

        if(expr.trim().isEmpty()) {
            return 0;
        }

        final String delimiter = " ";
        String[] symbols = expr.split(delimiter);

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < symbols.length; i++) {

            final String symbol = symbols[i];

            if(!isOperation(symbol)) {
                stack.push(Double.valueOf(symbol));
            } else {
                final Double op2 = stack.pop();
                final Double op1 = stack.pop();

                final Double res = setOperation(op1, op2, symbol);
                stack.push(res);
            }
        }

        return stack.pop();
    }

    private static boolean isOperation(final String symbol) {
        if(symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/")) {
            return true;
        }

        return false;
    }

    private static double setOperation(final double op1, final double op2, final String operation) {
        if(operation.equals("+")) {
            return op1 + op2;
        }
        if(operation.equals( "-")) {
            return op1 - op2;
        }
        if(operation.equals("*")) {
            return op1 * op2;
        }

        return op1 / op2;
    }



    public static String numberToOrdinal(Integer number) {

        if (number == 0) {
            return "0";
        }

        if (isException(number)) {
            return number + "th";
        }

        final int theLastDigit = getTheLastDigit(number);

        if (theLastDigit == 1) {
            return number + "st";
        }
        if (theLastDigit == 2) {
            return number + "nd";
        }
        if (theLastDigit == 3) {
            return number + "rd";
        }

        return number + "th";
    }

    private static int getTheLastDigit(final Integer number) {
        final int digitsAmount = getDigitsAmount(number);

        if (digitsAmount == 1) {
            return number;
        }

        return number % 10;
    }

    private static int getTwoLastDigits(final Integer number) {
        return number % 100;
    }

    private static int getDigitsAmount(final Integer number) {
        return number.toString().length();
    }

    private static boolean isException(final Integer number) {
        final int digitsAmount = getDigitsAmount(number);

        if (digitsAmount <= 1) {
            return false;
        }

        final int lastTwoDigits = getTwoLastDigits(number);

        if (lastTwoDigits == 11 || lastTwoDigits == 12 || lastTwoDigits == 13) {
            return true;
        }

        return false;
    }
}
