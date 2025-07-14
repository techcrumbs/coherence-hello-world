package com.techcrunch.example.cachestores;

import com.tangosol.net.cache.CacheStore;
import io.micronaut.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppCacheStoreFactory {

  private static ApplicationContext ctx;

  private static final Map<String, CacheStore<?,?>> cacheStoreMap = new ConcurrentHashMap<>();

  private static final Logger logger = LoggerFactory.getLogger(AppCacheStoreFactory.class);

  public static void init(ApplicationContext ctx) {
    AppCacheStoreFactory.ctx = ctx;
  }

  public static CacheStore<?, ?> getStore(String cacheName) {
    if ("jobCache".equals(cacheName)) {
      return ctx.getBean(JobStore.class);
    }
    throw new RuntimeException("Unknown cache name: " + cacheName);
  }

}
