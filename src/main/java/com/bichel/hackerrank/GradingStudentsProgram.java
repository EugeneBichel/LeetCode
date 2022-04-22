package com.bichel.hackerrank;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class GradingStudentsProgram {
    public static void main(String[] args) {

        String test1="fsdfsd";
        String res = test1.substring(0,1);

        Deque<Integer> stack = new ArrayDeque<>();
        //stack.push();
        //args.length
        //stack.isEmpty()
        //stack.pop()
        //stack.isEmpty()
        stack.pop();
        //stack.peek()

        //Character ch = null;
        //ch.charValue()
        //Scanner sc = new Scanner(System.in);
        //sc.nextInt();
        char ch = 'd';
        //String.valueOf()

        Map<Integer, Integer> map = new HashMap<>();
        //map.put()
        //map.conta
        //map.containsKey()
        //map.get()
        map.values().stream().reduce(0, Integer::sum);

        String str = "sfsf";
        //str.length()
        //str.

        String[] a = {"d", "a"};
        //a.length;
        String s = "sdsdf";
        //s.to

        Queue<Integer> queue = new LinkedList<>();
        //queue.add()
        queue.isEmpty();
        queue.poll();

        Scanner input = new Scanner(System.in);
        //input.next()
        Integer.valueOf(input.next().split(" ")[1]);


        Set<Integer> set = new HashSet<>();
        //set.add
        //set.contains()

        class GridItem implements Comparable<GridItem> {
            int i;
            int j;


            @Override
            public int compareTo(GridItem o) {
                if( o!=null && this.i == o.i && this.j==o.j) {
                    return 0;
                }

                return 1;
            }
        }
    }
}

        /*
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);
        //list.get(list.size()-1);
       // Integer.parseInt()
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println(formatter.format(4.0));
        //Integer.p
        //toBinary(6);

        int[] arr = new int[4];

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,2);
        map.put(1,3);
        map.containsValue(3);
        //map.ge

        return map.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet()).toArray()[0];


        Scanner scan = new Scanner(System.in);
        //Double.pa

        //Integer.MIN_VALUE;

        for(Map.Entry entrySet: map.entrySet()) {
            //entrySet.
        }

        //map.entrySet()


        Set<Integer> set = new HashSet<>();

        "br".compareTo()

        int num = 1101;
        num %= 10;
        System.out.println(num);

        String s = "sdfs sfsf";
        String[] arr33 = s.split(" ");
        //5
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);
        list2.add(2);
        list2.add(2);
        list2.add(4);

        Collections.sort(list2);

        customSort(list2);

        /*DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        Float f = Float.parseFloat(df.format(((float)73)/100).toString());

        int temp = (int)(f*100);

        System.out.println(temp);


        DoublyLinkedListNode head = new DoublyLinkedListNode(1);

        //sortedInsert();
       // Long.MAX_VALUE

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,2);
        map.put(1,3);
        map.containsValue(3);

        //map.g

        abbreviation("daBcd", "ABC");

        //map.values().

        //"dd".toLowerCase()

        int[] arr1 = {4,3,1,2};
        minimumSwaps(arr1);

        Set<Integer> set = new HashSet<>();

        int[] arr = {1,5,3,4,2};
        pairs(2, arr);

        Arrays.sort(arr);

*/
        //freqQuery(q);

/*
    class LexComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String a1 = a.substring(a.indexIf(' '));
            String b1 = a.substring(b.indexIf(' '));

            int res1 = a1.compareTo(b1);

            if(res1 != 0) {
                return res1;
            }

            String a2 = a.substring(0, a.indexIf(' '));
            String b2 = a.substring(0, b.indexIf(' '));

            return a2.compareTo(b2);

        }

    public static int toBinary(int n) {
        int multiplier = 1;
        int res = 0;

        List<Integer> list = new ArrayList<>();
        int counter = 0;
        boolean section = false;

        while(n > 0) {
            int r = n % 2;
            res += r * multiplier;

            multiplier *= 10;
            n /= 2;

            if(r == 1) {
                counter++;
                section = true;
            }
            if((r == 0 && section == true) || n == 0) {
                section = false;
                list.add(counter);
                System.out.println(counter);
                counter = 0;
            }
        }

        Collections.sort(list);

        System.out.println(list.get(list.size()-1));

        return res;
    }

    public static void customSort(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);

        Map<Integer, List<Integer>> freqMap = new HashMap<>();

        for(int i = 0; i < arr.size(); ) {
            int j = i + 1;
            int counter = 1;
            while(j < arr.size() && arr.get(i).equals(arr.get(j))) {
                counter++;
                j++;
            }

            int currItem = arr.get(i);

            if(!freqMap.containsKey(counter)) {
                List<Integer> list = new ArrayList<>();
                list.add(currItem);
                freqMap.put(counter, list);
            } else {
                List<Integer> updatedList = freqMap.get(counter);
                updatedList.add(currItem);
                freqMap.put(counter, updatedList);
            }

            i = j;
        }

        Map<Integer, List<Integer>> sortedMap = new TreeMap<>(freqMap);

        for (Integer key : sortedMap.keySet()) {
            List<Integer> curr = (List<Integer>) sortedMap.get(key);
            for(int i = 0; i < curr.size(); i++) {

                for(int j = 0; j < key; j++) {
                    System.out.println(curr.get(i));
                }
            }
        }
    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> wordsDictionary = new HashMap<>();
        for(int i = 0; i < magazine.length; i++) {
            if(wordsDictionary.containsKey(magazine[i])) {
                int amount = wordsDictionary.get(magazine[i]);
                //wordsDictionary.remove(magazine[i]);
                wordsDictionary.put(magazine[i], amount+1);
            } else {
                wordsDictionary.put(magazine[i], 1);
            }
        }

        for(int j = 0; j < note.length; j++) {
            if(wordsDictionary.containsKey(note[j]) && wordsDictionary.get(note[j]) > 0) {
                int amount = wordsDictionary.get(note[j]);
                //wordsDictionary.remove(note[j]);
                wordsDictionary.put(note[j], amount-1);
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), 1);
        }

        for(int i = 0; i < s2.length(); i++) {
            if(map.containsKey(s2.charAt(i))) {
                return "YES";
            }
        }
        return "NO";
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        //words


        return 0;
    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> checkList = new ArrayList<Integer>();
        Map<Integer, Integer> dataMap = new HashMap<>();
        int size = queries.size();

        for(int i = 0; i < size; i++) {
            int operation = queries.get(i).get(0);
            int data = queries.get(i).get(1);
            int mapData = -1;
            if(dataMap.containsKey(data)) {
                mapData = dataMap.get(data);
            }

            if (operation == 1) {
                if(mapData != -1) {
                    dataMap.put(data, mapData + 1);
                } else {
                    dataMap.put(data, 1);
                }
            } else if (operation == 2) {
                if(mapData > 1 ) {
                    int val = dataMap.get(data);
                    dataMap.put(data, val - 1);
                } else if(mapData == 1 ) {
                    dataMap.remove(data);
                }
            } else if (operation == 3) {
                if(dataMap.containsValue(data)) {
                    checkList.add(1);
                } else {
                    checkList.add(0);
                }
            }
        }

        return checkList;
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode currNode = head;

        while(currNode != null) {

            DoublyLinkedListNode prevNode = currNode.prev;

            if(currNode.data > data) {
                DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
                newNode.next = currNode;
                newNode.prev = prevNode;
                prevNode.next = newNode;
                currNode.prev = newNode;
                break;
            }

            currNode = currNode.next;
        }

        return head;
    }

    static class DoublyLinkedListNode {

        DoublyLinkedListNode(int data) {
            this.data = data;
        }

        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;
    }

    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/

/*
    public static int height(Node root) {
        // Write your code here.

        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        int distLeft = getDist(root.left, 1);
        int distRight = getDist(root.right, 1);

        if(distLeft > distRight) {
            return distLeft;
        }

        return distRight;
    }
*/
/*
    private static int getDist(Node root, int dist) {
        if(root == null || (root.left == null && root.right == null)) {
            return dist;
        }

        int distLeft = getDist(root.left, dist + 1);
        int distRight = getDist(root.right, dist + 1);

        if(distLeft > distRight) {
            return distLeft;
        }

        return distRight;
    }
*/

/*

/*
        1 5
1 6
3 2
1 10
1 10
1 6
2 5
3 2
        * */

/*
List<Integer> list1 = new ArrayList<>();
        list1.add(1);
                list1.add(5);

                List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(6);

        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(2);

        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(10);

        List<Integer> list5 = new ArrayList<>();
        list5.add(1);
        list5.add(10);

        List<Integer> list6 = new ArrayList<>();
        list6.add(1);
        list6.add(6);

        List<Integer> list7 = new ArrayList<>();
        list7.add(2);
        list7.add(5);

        List<Integer> list8 = new ArrayList<>();
        list8.add(3);
        list8.add(2);

        List<List<Integer>> q = new ArrayList<>();
        q.add(list1);
        q.add(list2);
        q.add(list3);
        q.add(list4);
        q.add(list5);
        q.add(list6);
        q.add(list7);
        q.add(list8);

*/


/*
    static  class Node {
        int data;
        Node left;
        Node right;
    }
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

        if(head == null)
            return head;

        // 1 -> 2 -> null
        // null <- 1 <- 2
        DoublyLinkedListNode currNode = head;
        DoublyLinkedListNode nextNode = head.next;
        DoublyLinkedListNode prevNode = head.prev;

        while(nextNode != null) {
            currNode.next = prevNode;
            currNode.prev = nextNode;
            nextNode.prev = nextNode.next;
            nextNode.next = currNode;

            prevNode = currNode;
            currNode = nextNode;
            nextNode = currNode.prev;
            head = currNode;
        }

        return head;
    }
    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            Character ch = s.charAt(i);

            if(!ch.equals('(') &&
                    !ch.equals('[') &&
                    !ch.equals('{') && stack.empty()) {
                return "NO";
            }

            if(ch.equals('(') ||
                    ch.equals('[') ||
                    ch.equals('{')) {
                stack.push(ch);
            } else if(ch.equals(')')) {
                if(!stack.peek().equals('(')) {
                    return "NO";
                }
                stack.pop();
            } else if(ch.equals(']')) {
                if(!stack.peek().equals('[')) {
                    return "NO";
                }
                stack.pop();
            } else if(ch.equals('}')) {
                if(!stack.peek().equals('{')) {
                    return "NO";
                }
                stack.pop();
            }
        }

        if(stack.empty()) {
            return "YES";
        }

        return "NO";
    }

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {

        int pairsCounter = 0;
        int[][] foundPairs = new int[arr.length][arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(i == j || foundPairs[i][j] == 1  || foundPairs[j][i] == 1) {
                    continue;
                }
                if(Math.abs(arr[i] - arr[j]) == k ) {
                    pairsCounter++;
                    foundPairs[i][j] = 1;
                }
            }
        }

        return pairsCounter;
    }

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> mapb = new HashMap<>();

        for(int i = 0; i < a.length(); i++) {
            if(!map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), 1);
            } else {
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            }
        }

        for(int i = 0; i < b.length(); i++) {
            if(map.containsKey(b.charAt(i))) {
                if(map.get(b.charAt(i)) > 1) {
                    map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
                } else {
                    map.remove(b.charAt(i));
                }
            } else {
                if(!mapb.containsKey(b.charAt(i))) {
                    mapb.put(b.charAt(i), 1);
                } else {
                    mapb.put(b.charAt(i), mapb.get(b.charAt(i)) + 1);
                }
            }
        }

        int counter=0;

        Object[] a1 = map.values().toArray();
        Object[] a2 = mapb.values().toArray();

        for(int i = 0; i < a1.length; i++){
            counter+=(Integer)a1[i];
        }

        for(int i = 0; i < a2.length; i++){
            counter+=(Integer)a2[i];
        }

        return counter;
    }

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {

        int diff = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length-1; i++) {
            int curr = Math.abs(arr[i] - arr[i+1]);
            if(curr < diff) {
                diff = curr;
            }
        }

        return diff;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swapsCounter = 0;

        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        return swapsCounter;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

        if (a.length() < b.length()) {
            return "NO";
        }

        String bLowerCase = b.toLowerCase();
        Map<Character, Integer> bMap = new HashMap<>();

        for (int i = 0; i < bLowerCase.length(); i++) {
            if (bMap.containsKey(bLowerCase.charAt(i))) {
                bMap.put(bLowerCase.charAt(i), bMap.get(bLowerCase.charAt(i)) + 1);
            } else {
                bMap.put(bLowerCase.charAt(i), 1);
            }
        }

        List<Character> list = new ArrayList<>();

        for (int j = 0; j < a.length(); j++) {

            char lower = a.toLowerCase().charAt(j);

            if (bMap.containsKey(lower)) {
                int val = bMap.get(lower);
                if (val > 1) {
                    bMap.put(lower, val - 1);
                } else {
                    bMap.remove(lower);
                }
            } else if ((int)(a.charAt(j)) < 97) {
                list.add(a.charAt(j));
            }
        }

        if (!bMap.isEmpty() || !list.isEmpty()) {
            return "NO";
        }

        return "YES";
    }
 */