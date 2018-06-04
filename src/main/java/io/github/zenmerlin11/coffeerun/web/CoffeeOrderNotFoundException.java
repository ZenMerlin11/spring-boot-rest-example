package io.github.zenmerlin11.coffeerun.web;

public class CoffeeOrderNotFoundException extends RuntimeException {

    public CoffeeOrderNotFoundException(String exception) {
        super(exception);
    }
}
