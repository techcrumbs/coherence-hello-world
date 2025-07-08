package com.techcrunch.example;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class HelloWorld {
    public static void main(String[] args) {
        // Ensure Coherence is started
        CacheFactory.ensureCluster();

        // Get or create a cache named "hello"
        NamedCache<String, String> cache = CacheFactory.getCache("hello");

        // Put a value into the cache
        cache.put("greeting", "Hello, Coherence!");

        // Get the value from the cache
        String value = cache.get("greeting");

        // Print the result
        System.out.println("Cache says: " + value);

        // Shutdown Coherence cluster member
        CacheFactory.shutdown();
    }
}
