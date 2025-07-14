package com.techcrunch.example;

import com.techcrunch.example.cachestores.AppCacheStoreFactory;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class Application {
    
    public static void main(String[] args) {

        // set the ctx in the CacheStoreFactory
        try (ApplicationContext ctx = ApplicationContext.run()) {
            AppCacheStoreFactory.init(ctx);
        }

        Micronaut.run(Application.class);
    }
}
