package com.bichel.java;

import java.io.*;
import java.util.*;

public class JobQueue {
    private int numWorkers;
    private long[] jobs;

    private long[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    class WorkerItem {

        public int index;
        public long duration;

        public WorkerItem(int index, long duration) {
            this.index = index;
            this.duration = duration;
        }
    }

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new long[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }
/*
    for (int i = 0; i < jobs.length; i++) {
        int duration = jobs[i];
        int bestWorker = 0;
        for (int j = 0; j < numWorkers; ++j) {
            if (nextFreeTime[j] < nextFreeTime[bestWorker])
                bestWorker = j;
        }
        assignedWorker[i] = bestWorker;
        startTime[i] = nextFreeTime[bestWorker];
        nextFreeTime[bestWorker] += duration;
    }
*/
    private static Comparator<WorkerItem> WorkerItemComparator = new Comparator<WorkerItem>() {
        @Override
        public int compare(WorkerItem item1, WorkerItem item2) {
            if(item1.duration == item2.duration && item1.index >= item2.index ||
                    item1.duration > item2.duration) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new long[jobs.length];
        startTime = new long[jobs.length];
        long[] nextFreeTime = new long[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            nextFreeTime[i] = 0;
        }

        PriorityQueue<WorkerItem> prQueue = new PriorityQueue<WorkerItem>(numWorkers, WorkerItemComparator);
        for (int i = 0; i < numWorkers; i++) {
            nextFreeTime[i] = 0;
            prQueue.add(new WorkerItem(i, 0));
        }

        for (int i = 0; i < jobs.length; i++) {
            long duration = jobs[i];
            WorkerItem bestWorker = prQueue.remove();
            assignedWorker[i] = bestWorker.index;
            startTime[i] = nextFreeTime[bestWorker.index];
            nextFreeTime[bestWorker.index] += duration;
            prQueue.add(new WorkerItem(bestWorker.index, bestWorker.duration + duration));
        }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
