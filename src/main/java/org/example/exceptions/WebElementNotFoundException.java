package org.example.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WebElementNotFoundException extends RuntimeException{

    public WebElementNotFoundException(String message) {
        super(message);
    }
}
