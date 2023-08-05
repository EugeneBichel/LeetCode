package com.bichel.algorithms;

class InvertPosOfElemInArray {

    private static void invert(int[] array, int currentIndex) {
        if (currentIndex < array.length/2) {
            // swap array[currentIndex] and array[array.length-1-currentIndex]
            int temp = array[currentIndex];
            array[currentIndex] = array[array.length-1-currentIndex];
            array[array.length-1-currentIndex] = temp;

            invert(array, currentIndex+1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Before: ");

        int[] array = {1,2,3,4,5,6,7};
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("} ");

        System.out.println("After: ");

        invert(array, 0);

        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("} ");
    }
}
