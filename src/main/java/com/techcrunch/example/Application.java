package com.techcrunch.example;

import com.techcrunch.example.cachestores.AppCacheStoreFactory;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

public class Application {
    
    public static void main(String[] args) {

        ApplicationContext ctx = Micronaut.run(Application.class);  // Start and retain the context
        AppCacheStoreFactory.init(ctx);  // Use the live context
    }
}
