package org.example.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PageNotFoundException extends RuntimeException{

    public PageNotFoundException(String message) {
        super(message);
    }
}
