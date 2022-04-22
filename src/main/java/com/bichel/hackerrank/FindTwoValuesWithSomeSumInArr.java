package com.bichel.hackerrank;
import java.util.HashMap;
import java.util.Map;
/*
public class FindTwoValuesWithSomeSumInArr {
    public class Solution {

        // Complete the whatFlavors function below.
        static void whatFlavors(int[] cost, int money) {

            Map<Integer, Integer> remainders = new HashMap<>();

            for(int i = 0; i < cost.length; i++) {

                int currVal = cost[i];

                if(currVal >= money) {
                    continue;
                }

                int val = money - currVal;

                if(remainders.isEmpty()) {
                    remainders.put(val, i);
                } else if(!remainders.containsKey(val)) {
                    remainders.put(val, i);
                }

                if(remainders.containsKey(currVal)){
                    //for (Map.Entry<Integer, Integer> map : remainders.entrySet()) {
                    //if (map.getValue().equals(currVal)) {
                    int one = remainders.get(currVal) + 1;// map.getKey()+1;
                    int two = i+1;

                    if(one == two) {
                        continue;
                    }

                    StringBuilder sb = new StringBuilder();
                    if(one < two) {
                        sb.append(one).append(" ");
                        sb.append(two);
                    } else {
                        sb.append(two).append(" ");
                        sb.append(one);
                    }
                    System.out.println(sb.toString());
                    // break;
                    // }
                    //}
                }
            }
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int money = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] cost = new int[n];

                String[] costItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    int costItem = Integer.parseInt(costItems[i]);
                    cost[i] = costItem;
                }

                whatFlavors(cost, money);
            }

            scanner.close();
        }
    }

}
*/