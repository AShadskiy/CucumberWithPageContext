package org.example.dataManager;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum User {

    ROLE("ROLE"),

    ;

    private final String roleName;

}
