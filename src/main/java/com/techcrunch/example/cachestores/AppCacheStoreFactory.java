package com.techcrunch.example.cachestores;

import com.tangosol.net.cache.CacheStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppCacheStoreFactory {

  private static final Map<String, CacheStore> cacheStoreMap = new ConcurrentHashMap<>();

  private static final Logger logger = LoggerFactory.getLogger(AppCacheStoreFactory.class);

  @SuppressWarnings("unchecked")
  public static <K, V> CacheStore<K, V> getStore(String cacheName) {
    switch (cacheName) {
      case "jobCache":
        return cacheStoreMap.computeIfAbsent(cacheName, k -> new JobStore());
      default:
        throw new RuntimeException("Unknown cache name: " + cacheName);
    }
  }

}
