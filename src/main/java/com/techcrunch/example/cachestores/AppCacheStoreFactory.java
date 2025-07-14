package com.techcrunch.example.cachestores;

import com.tangosol.net.BackingMapManagerContext;
import com.tangosol.net.cache.CacheStore;
import com.techcrunch.example.dao.repository.JobRepository;
import io.micronaut.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppCacheStoreFactory {

//  private static ApplicationContext context;

  private static JobRepository jobRepository;

  private static final Map<String, CacheStore<?,?>> cacheStoreMap = new ConcurrentHashMap<>();

  private static final Logger logger = LoggerFactory.getLogger(AppCacheStoreFactory.class);

  public static void init(ApplicationContext ctx) {
    jobRepository = ctx.getBean(JobRepository.class);
  }

  public static CacheStore<?, ?> getStore(String cacheName) {
    if ("jobCache".equals(cacheName)) {
      return cacheStoreMap.computeIfAbsent(cacheName, k -> new JobStore(jobRepository));
    }

    throw new RuntimeException("Unknown cache name: " + cacheName);
  }

//  public static CacheStore<?, ?> getStore(String cacheName) {
//    if ("jobCache".equals(cacheName)) {
//      return cacheStoreMap.computeIfAbsent(cacheName, k -> new JobStore(null));
//    }
//    throw new RuntimeException("Unknown cache name: " + cacheName);
//  }

}
