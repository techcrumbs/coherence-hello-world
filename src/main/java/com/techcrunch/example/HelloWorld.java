package com.techcrunch.example;

import java.util.stream.IntStream;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class HelloWorld {
    public static void main(String[] args) {
        // Ensure Coherence is started
        CacheFactory.ensureCluster();

        // Get or create a cache named "hello"
        NamedCache<String, String> cache = CacheFactory.getCache("hello");
        NamedCache<Integer, Integer> intCache = CacheFactory.getCache("numbers");

        // Put a value into the cache
        cache.put("greeting", "Hello, Coherence!");

        // Get the value from the cache
        String value = cache.get("greeting");

        // Print the result
        System.out.println("Cache says: " + value);

        IntStream.rangeClosed(1, 1000).forEach(x -> {
            Integer previousValue = intCache.putIfAbsent(x, x);
            if (previousValue == null) {
                System.out.println("IntCache put value: " + x);
                // we put this value, we will sleep for a while to give a chance to someone else to put the next value
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });

        // Shutdown Coherence cluster member
        CacheFactory.shutdown();
    }
}
