package com.bichel.other.algorithms;

class Solution {

    public static void permutations(char[] array, int length) {
        if (length == 1) {
            System.out.println(array);
            return;
        }
        else {
            for (int i = 0; i < length; i++) {
                swap(array, i, length-1);
                permutations(array, length-1);
                swap(array, i, length-1);
            }
        }
    }

    public static void swap(char[] array, int i, int j) {
        char c;
        c = array[i];
        array[i] = array[j];
        array[j] = c;
    }

    public static void main( String args[] ) {
        char[] input = {'a', 'b', 'b', 'a'};
        permutations(input, input.length);
    }
}

/*
Driver Method #
The recursive method is called within the driver method. Let’s first look at what it does-from lines 25 to 27.

An array of characters input is initialized on line 25.

The recursive method permutations is called on line 26 which takes in two input parameters: the input array and the length of that array.


Recursive Method #
Let’s look at the recursive method, which is the permutations method. Within a recursive method, you have the base case and the recursive case.

Base Case #
The base case in this method is the if condition-from line 4 to line 7. This if condition simply states that if the length - the length of the input array is equal to 1, it will print the character and return the method.

Recursive case #
Provided that the length of the array is greater than 1, we move to the recursive case. The first step in the method is to initialize a for loop which starts from 00 until the length of the array.

Inside the for loop, from line 9 to line 13, the swap method is called which takes in three input arguments; first is the array of characters, second is to keep track of the index and third is the last index of the array.

The swap method swaps the values of the current index i with the last index j, which is the length-1 index of array passed from the method above.

The recursive call to permutations is made on line 11 with arguments array and length-1. With each successive recursive call, it swaps the values and creates a new array of characters.

The swap method is called again on line 12.


public static int totalVowels(String text, int len, int index) {
  int count = 0;

  if (len == 0) {
    return 0;
  }
  char single = Character.toUpperCase(text.charAt(index));
  if (single == 'A' || single == 'E' || single == 'I' || single == 'O' || single == 'U') {
    count++;
  }
  return count + totalVowels(text, len-1, index+1);
}
public static void main(String args[])
{
     String text = "thisisrecursion";
     int cnt = 0;
     cnt = recursiveFunc(text, text.length, 0);
     System.out.println(cnt);
}

 */