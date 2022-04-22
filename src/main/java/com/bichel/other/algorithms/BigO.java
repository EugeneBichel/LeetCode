package com.bichel.other.algorithms;

public class BigO {
    public static void main(String[] args) {

    }

    private static void f1() {
        final int n = 10;
        for (int x = 0; x < n; x++) {
            //statement(s) that take constant time
        }

        /*
        Running time Complexity = T(n) = (2n+2) + cn = (2+c) n + 2(2n+2)+cn=(2+c)n+2.
        Dropping the leading constants n + 2
        Dropping lower order terms ⇒ O(n)
         */

        /*
        Explanation: Java for loop increments the value x by 1 in every iteration
        from 0 till n-1 ([0, 1, 2, …, n-1]). So n is first 0, then 1, then 2, …, then n-1.
        This means the loop increment statement x++ runs a total of nn times.
        The comparison statement x < n ; runs n+1n+1 times.
        The initialization x = 0; runs once.
        Summing them up, we get a running time complexity of the for loop of n + n + 1 + 1= 2n+2n+n+1+1=2n+2.
        Now, the constant time statements in the loop itself each run nn times.
        Supposing the statements inside the loop account for a constant running time of cc in each iteration,
        they account for a total running time of cncn throughout the loop’s lifetime.
        Hence the running time complexity is (2n+2) + cn(2n+2)+cn
         */
    }
    private static void f2() {
        final int n = 10;
        final int k = 2;

        for (int x = 0; x < n; x+=k) {
            //statement(s) that take constant time
        }

        /*
        The initialization x = 0; runs once.
        Then, x gets incremented by k until it reaches n.
        In other words, x will be incremented to [0, k, 2k, 3k, ..., (mk) < n0,k,2k,3k,⋯,(mk)<n].
        Hence, the incrementation part x+=k of the for loop takes floor(\frac{n}{k})floor(n/k) time.
        The comparison part of the for loop takes the same amount of time and one more iteration for the last comparison.

         */
    }
    private static void f3() {
        final int n = 10;
        final int m = 10;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                //Statement(s) that take(s) constant time
            }
        }

        /*
        Running time: nm(2+c)+2+4n=O(nm)
        The inner loop is a simple for loop that takes (2m+2) + cm(2m+2)+cm time
        and the outer loop runs it nn times so it takes n((2m+2) + cm)n((2m+2)+cm)time.
        Additionally, the initialization,
        increment and test for the outer loop take 2n+22n+2 time so in total,
        the running time is n((2m+2) + cm)+2n+2 = 2nm+4n+cnm+2 =
        nm(2+c)+4n+2n((2m+2)+cm)+2n+2=2nm+4n+cnm+2=nm(2+c)+4n+2,
        which is O(nm)O(nm).
         */
    }
    private static void f4() {
        final int n = 10;

        for (int i=0; i<n; i++){
            for (int j=0; j<i; j++){
                //Statement(s) that take(s) constant time
            }
        }

        /*
         O(n^2)
         The outer loop runs nn times and for each time the outer loop runs,
         the inner loop runs i times. So, the statements in the inner loop do not run
         at the first iteration of the outer loop since i is 0 then;
         they run once at the second iteration of the outer loop since i is equal to 11 at that point,
         then they run twice, then thrice, until i is n-1n−1.
         So, they run a total of c + 2c + 3c + ... + (n-1)cc+2c+3c+⋯+(n−1)c time
         The initialization of j in the inner for loop runs once in each iteration of the outer loop.
         So, this statement incurs a running time of nn. In the first iteration of the outer for loop,
         the j < i statement runs once, in the second iteration it runs twice and so on.

         */
    }
    private static void f5() {
        final int n = 10;

        for (int i=0; i<n; i++){
            i*=2;
            for (int j=0; j<i; j++){
                // Statement(s) that take(s) constant time
            }
        }

        /*
        O(n)

        Notice that the outer loop index variable is modified in the loop’s body.
        The first column in the following table shows the value of i immediately after entering
        the outer for loop. The second column shows the modified value of i after the i*=2; statement is run.
        A pattern is hard to decipher here. So, let’s simplify things. In the outer loop,
        i is doubled and then incremented each time. If we ignore the increment part,
        we will be slightly over-estimating the number of iteration of the outer for loop.
        That is fine because we are looking for an upper bound on the worst-case running time (Big O).
        If i keeps doubling, it will get from 1 to n-1 in roughly log_2(n-1) steps.
        With this simplification, the outer loop index goes (approximately) 1, 2, 4,..., 2^log_2(n-1)
        We’ve ignored the iteration with i=0, but it wouldn’t affect the result in Big O.
        If you are interested, you can add 11 to all the steps in the following calculations.

        Therefore, the running time of the inner for loop is 2 (2n-3) + 2 + c(2n-3)2(2n−3)+2+c(2n−3)
        where cc is the running time of the statements in the body of the inner loop.
        This simplifies to 2n(2+c)-3c-42n(2+c)−3c−4. The contribution from the initialization, test,
        and increment operations of the outer for loop is 2log_2(n-1)+22log
        So, the total running time is 2n(2+c)-3c-4+2log_2(n-1)+2n(2+c)−3c−4+2log + 2.
        The term linear in nn dominates the others, and the time complexity is O(n).

        Note that we could have done a rough approximation saying that the outer loop runs
        at most n times, the inner loop iterates at most nn times each iteration of the outer for loop.
        That would lead us to conclude that the total running time is O(n^2).
        Mathematically that is correct, but it isn’t a tight bound.
         */
    }
    private static void f6() {
        int i = 0;
        int n = 100;
        int k = 5;

        while (i < n){
            i*=k;
            // Statement(s) that take(s) constant time
        }

        /*
        Running Time Complexity = log_k(n) = O(log_k(n))
        A loop statement that multiplies/divides the loop variable by a constant such as the above takes
        log_k(n) time because the loop runs that many times.
        Let’s consider an example where n = 16, and k = 2:
         */
    }
}
