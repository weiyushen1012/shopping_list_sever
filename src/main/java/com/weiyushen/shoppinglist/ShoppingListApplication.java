package com.weiyushen.shoppinglist;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class ShoppingListApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingListApplication.class, args);
    }

}
