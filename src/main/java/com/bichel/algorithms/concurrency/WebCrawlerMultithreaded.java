package com.bichel.algorithms.concurrency;

/*
Given a URL startUrl and an interface HtmlParser,
implement a Multi-threaded web crawler to crawl
all links that are under the same hostname as startUrl.

Return all URLs obtained by your web crawler in any order.

Your crawler should:

Start from the page: startUrl
Call HtmlParser.getUrls(url) to get all URLs from a webpage of a given URL.
Do not crawl the same link twice.
Explore only the links that are under the same hostname as startUrl.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

public class WebCrawlerMultithreaded {
    // This is the HtmlParser's API interface.
    // You should not implement it, or speculate about its implementation
    interface HtmlParser {
        default List<String> getUrls(String url) {
            List<String> urls = new ArrayList<>();
            urls.add("http://news.yahoo.com");
            urls.add("http://news.yahoo.com/news");
            urls.add("http://news.yahoo.com/news/topics/");
            urls.add("http://news.google.com");
            urls.add("http://news.yahoo.com/us");

            return urls;
        }
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostName = getHostName(startUrl);

        List<String> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Deque<Future> tasks = new ArrayDeque<>();

        queue.offer(startUrl);

        // Create a thread pool of 4 threads to perform I/O operations.
        ExecutorService executor = Executors.newFixedThreadPool(4, r -> {
            Thread t = new Thread(r);
            // Leetcode doesn't allow executor.shutdown().
            // Use daemon threads so the program can exit.
            t.setDaemon(true);
            return t;
        });

        while (true) {
            String url = queue.poll();
            if (url != null) {
                if (getHostName(url).equals(hostName) && !visited.contains(url)) {
                    res.add(url);
                    visited.add(url);
                    // Use a thread in thread pool to fetch new URLs and put them into the queue.
                    tasks.add(executor.submit(() -> {
                        List<String> newUrls = htmlParser.getUrls(url);
                        for (String newUrl : newUrls) {
                            queue.offer(newUrl);
                        }
                    }));
                }
            } else {
                if (!tasks.isEmpty()) {
                    // Wait for the next task to complete, which may supply new URLs into the queue.
                    Future nextTask = tasks.poll();
                    try {
                        nextTask.get();
                    } catch (InterruptedException | ExecutionException e) {
                    }
                } else {
                    // Exit when all tasks are completed.
                    break;
                }
            }
        }
        return res;
    }

    private String getHostName(String url) {
        url = url.substring(7);
        String[] parts = url.split("/");
        return parts[0];
    }
}
