package org.learnify.com.product_microservice.exception;

public class ProductFetchEexception extends RuntimeException {
    public ProductFetchEexception(String message) {
        super(message);
    }

    public ProductFetchEexception(String message, Throwable cause) {
        super(message, cause);
    }
}
